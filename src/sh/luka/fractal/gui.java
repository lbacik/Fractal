/*
 * Copyright (C) 2015 Lukasz Bacik <mail@luka.sh>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

/**
 *
 * !!! This code is still under heavy development
 * !!! (however, as usually - all comments are welcome :))
 *
 * @version 0.1 ALFA (prototype)
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
package sh.luka.fractal;

import java.awt.event.*;
import java.awt.geom.Line2D;
import javax.swing.*;
import javax.swing.JMenuBar;
import java.io.*;
import sh.luka.gui.*;

/**
 * GUI
 *
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
public class gui extends JImageViewerRuler implements Cloneable, Serializable {

    private ProgressMonitor progressDialog;
    private Timer activityMonitor;
    private Thread activityThread;
    protected Registry reg;
    protected Main main;

    public gui(Line2D scale) {
        super(scale);
        // it does not work as expected with cloning function :(
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JImageViewerRuler - scale type
        righttop = true;
    }

    protected Object clone() {
        Object result = null;

        /**
         * classes that does not implement Serializable interface
         */
        if(activityThread != null)  activityThread = null;
        // this one below maybe should (?)
        if(main.fractal != null)    main.fractal = null;
        if(progressDialog != null)  progressDialog = null;

        try {

            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bout);
            out.writeObject(this);
            out.close();

            ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bin);

            result = in.readObject();
            in.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return result;
    }

    // @Override
    protected JMenuBar menu() {
        JMenuBar menu = super.menu();
        JMenu fractal_menu = new JMenu("Fractal");

        JMenuItem clone = new JMenuItem("Clone");
        clone.addActionListener(new CloneListener());
        fractal_menu.add(clone);

        JMenuItem showReg = new JMenuItem("Show Registry");
        showReg.addActionListener(new ShowRegistryListener());
        fractal_menu.add(showReg);

        JMenuItem settings = new JMenuItem("Settings");
        settings.addActionListener(new SettingsListener());
        fractal_menu.add(settings);

        menu.add(fractal_menu);
        return menu;
    }

    // @Override
    protected void action(File file) {

        reg = Registry.create();

        if (file.isFile()) {

            reg.inFile = file.getAbsolutePath();

            try {

                reg.setDrawingClassName();

            } catch (IOException e) {
                JOptionPane.showMessageDialog(getParent(),
                        "Does not compute !", "No file read or found",
                        JOptionPane.INFORMATION_MESSAGE);
                e.printStackTrace();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(getParent(),
                        "Does not compute !", e.getMessage(),
                        JOptionPane.INFORMATION_MESSAGE);
            }

            main = new Main(reg);

            calculate();
        }

    }

    /**
     * calculate the fractal
     *
     */
    public void calculate() {

        try {

            activityThread = new Thread(main);
            activityThread.start();

            while (main.fractal == null || main.fractal.getInstance() == null) {
                Thread.sleep(100);
            }

            progressDialog = new ProgressMonitor(gui.this, "processing...", null, 0,
                    main.fractal.getInstance().getTarget());

            activityMonitor = new Timer(500, new ActionListener() {

                public void actionPerformed(ActionEvent event) {

                    int current = main.fractal.getInstance().getCurrent();
                    progressDialog.setProgress(current);

                    if (current == main.fractal.getInstance().getTarget()
                            || progressDialog.isCanceled()) {
                        activityMonitor.stop();
                        progressDialog.close();
                        activityThread.interrupt();
                        // activity monitor finished - unblock menu

                        double[] s;
                        if (reg.useDefaulScale == true) {
                            s = main.fractal.defaultScale;
                        } else {
                            s = reg.scale;
                        }

                        rulerScale = new Line2D.Double(s[0], s[1], s[2], s[3]);

                        if (main.image.image != null) {
                            image.image = main.image.image;
                            showImage(image.image);
                        } // else throw new Exception("image is null...");
                    }
                }
            });

            activityMonitor.start();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(getParent(),
                    "Does not compute !", e.getMessage(),
                    JOptionPane.INFORMATION_MESSAGE);

        } finally {

            // progressDialog = null;
        }
    }

    public void recalculate(SettingsWindowValues settings) {

        System.out.println("recalculating...");

        main.fractal.getInstance().setWidth(Integer.parseInt(settings.widthValue));
        main.fractal.getInstance().setHeight(Integer.parseInt(settings.heightValue));

        ((FractalIFS) main.fractal.getInstance()).setIteration(
                Integer.parseInt(settings.iterationMinorValue),
                Integer.parseInt(settings.iterationMajorValue));

        reg.useDefaulScale = false;
        reg.scale[0] = Double.parseDouble(settings.scaleX1Value);
        reg.scale[1] = Double.parseDouble(settings.scaleY1Value);
        reg.scale[2] = Double.parseDouble(settings.scaleX2Value);
        reg.scale[3] = Double.parseDouble(settings.scaleY2Value);

        calculate();
    }

    public static void main(String[] args) {
        // ruler is initializing with some default scale
        // System.out.println("gui - main");
        new gui(new Line2D.Double(-1, 1, 1, -1));
    }

    protected class OpenFileListener
            extends JImageViewer.OpenFileListener
            implements ActionListener, Cloneable, Serializable {

        protected void action(File f) {
            gui.this.action(f);
        }

    }

    protected class CloneListener implements ActionListener, Cloneable, Serializable {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui newgui = (gui) gui.this.clone();
            newgui.setVisible(true);
            newgui.repaint();
        }

    }

    protected class SettingsListener implements ActionListener, Serializable {

        @Override
        public void actionPerformed(ActionEvent ae) {
            SettingsWindow setwin = new SettingsWindow();
            setwin.guiObject = gui.this;

            SettingsWindowValues settings = new SettingsWindowValues();

            /**
             * After clonning the main.fractal will equal null
             *
             * @todo it shouldn't be here i think...
             */
            if(main.fractal == null) {
                try {
                    main.fractal = main.compile();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                main.fractal.instantiateIt(reg.drawingClassName);
            }

            Integer i = main.fractal.getInstance().getWidth();
            settings.widthValue = i.toString();

            i = main.fractal.getInstance().getHeight();
            settings.heightValue = i.toString();

            int[] ai = ((FractalIFS) (main.fractal.getInstance())).getIteration();
            settings.iterationMajorValue = Integer.toString(ai[1]);
            settings.iterationMinorValue = Integer.toString(ai[0]);

            double[] scale = main.fractal.getInstance().getScale();

            settings.scaleX1Value = Double.toString(scale[0]);
            settings.scaleY1Value = Double.toString(scale[1]);
            settings.scaleX2Value = Double.toString(scale[2]);
            settings.scaleY2Value = Double.toString(scale[3]);

            setwin.setValues(settings);
            setwin.setVisible(true);
            setwin.repaint();
        }

    }

    protected class ShowRegistryListener implements ActionListener, Serializable {

        @Override
        public void actionPerformed(ActionEvent ae) {
                System.out.println("Registry:");
                main.reg.show();

        }

    }
}
