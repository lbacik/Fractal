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
 * @author Lukasz Bacik <mail@luka.sh>
 */
package sh.luka.fractal;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * code generated by gui builder
 *
 */
public class SettingsWindow extends javax.swing.JFrame {

    public gui guiObject;
    /**
     * Creates new form NewJFrame
     */
    public SettingsWindow() {
        initComponents();
        ApplyButton.addActionListener(new SettingsApplyButtonListener());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTextField9 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        widthValue = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        heightValue = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        scaleX1Value = new javax.swing.JTextField();
        scaleY1Value = new javax.swing.JTextField();
        scaleX2Value = new javax.swing.JTextField();
        scaleY2Value = new javax.swing.JTextField();
        iterationMajorValue = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ApplyButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        iterationMinorValue = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        jTextField9.setText("jTextField9");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 420));
        setPreferredSize(new java.awt.Dimension(400, 420));
        setResizable(false);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        getContentPane().setLayout(layout);

        jLabel1.setText("Width");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        getContentPane().add(jLabel1, gridBagConstraints);

        widthValue.setColumns(5);
        widthValue.setMinimumSize(new java.awt.Dimension(70, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        getContentPane().add(widthValue, gridBagConstraints);

        jLabel2.setText("Height");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        getContentPane().add(jLabel2, gridBagConstraints);

        heightValue.setColumns(5);
        heightValue.setMinimumSize(new java.awt.Dimension(70, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 2;
        getContentPane().add(heightValue, gridBagConstraints);

        jLabel3.setText("AA");
        jLabel3.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 22;
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel4.setText("AB");
        jLabel4.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 24;
        getContentPane().add(jLabel4, gridBagConstraints);

        jLabel5.setText("AC");
        jLabel5.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 26;
        getContentPane().add(jLabel5, gridBagConstraints);

        jLabel6.setText("AD");
        jLabel6.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 28;
        getContentPane().add(jLabel6, gridBagConstraints);

        jLabel7.setText("AE");
        jLabel7.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 30;
        getContentPane().add(jLabel7, gridBagConstraints);

        jLabel8.setText("AF");
        jLabel8.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 32;
        getContentPane().add(jLabel8, gridBagConstraints);

        scaleX1Value.setColumns(4);
        scaleX1Value.setMinimumSize(new java.awt.Dimension(70, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        getContentPane().add(scaleX1Value, gridBagConstraints);

        scaleY1Value.setColumns(4);
        scaleY1Value.setMinimumSize(new java.awt.Dimension(70, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 10;
        getContentPane().add(scaleY1Value, gridBagConstraints);

        scaleX2Value.setColumns(4);
        scaleX2Value.setMinimumSize(new java.awt.Dimension(70, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 8;
        getContentPane().add(scaleX2Value, gridBagConstraints);

        scaleY2Value.setColumns(4);
        scaleY2Value.setMinimumSize(new java.awt.Dimension(70, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 10;
        getContentPane().add(scaleY2Value, gridBagConstraints);

        iterationMajorValue.setColumns(11);
        iterationMajorValue.setMinimumSize(new java.awt.Dimension(80, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(iterationMajorValue, gridBagConstraints);

        jLabel9.setText("MIP");
        jLabel9.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 20;
        getContentPane().add(jLabel9, gridBagConstraints);

        jButton1.setLabel("Cancel");
        jButton1.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 38;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(jButton1, gridBagConstraints);

        ApplyButton.setLabel("Apply");
        ApplyButton.setMaximumSize(new java.awt.Dimension(100, 30));
        ApplyButton.setMinimumSize(new java.awt.Dimension(100, 30));
        ApplyButton.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 38;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(ApplyButton, gridBagConstraints);

        jButton3.setLabel("OK");
        jButton3.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton3.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton3.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 38;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(jButton3, gridBagConstraints);

        iterationMinorValue.setColumns(11);
        iterationMinorValue.setMinimumSize(new java.awt.Dimension(80, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(iterationMinorValue, gridBagConstraints);

        jTextField11.setColumns(4);
        jTextField11.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 22;
        getContentPane().add(jTextField11, gridBagConstraints);

        jTextField12.setColumns(4);
        jTextField12.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 22;
        getContentPane().add(jTextField12, gridBagConstraints);

        jTextField13.setColumns(4);
        jTextField13.setToolTipText("");
        jTextField13.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 22;
        getContentPane().add(jTextField13, gridBagConstraints);

        jTextField15.setColumns(4);
        jTextField15.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 24;
        getContentPane().add(jTextField15, gridBagConstraints);

        jTextField16.setColumns(4);
        jTextField16.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 24;
        getContentPane().add(jTextField16, gridBagConstraints);

        jTextField17.setColumns(4);
        jTextField17.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 24;
        getContentPane().add(jTextField17, gridBagConstraints);

        jTextField18.setColumns(4);
        jTextField18.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 26;
        getContentPane().add(jTextField18, gridBagConstraints);

        jTextField20.setColumns(4);
        jTextField20.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 26;
        getContentPane().add(jTextField20, gridBagConstraints);

        jTextField21.setColumns(4);
        jTextField21.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 26;
        getContentPane().add(jTextField21, gridBagConstraints);

        jTextField22.setColumns(4);
        jTextField22.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 30;
        getContentPane().add(jTextField22, gridBagConstraints);

        jTextField23.setColumns(4);
        jTextField23.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 22;
        getContentPane().add(jTextField23, gridBagConstraints);

        jLabel10.setText("Scale");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        getContentPane().add(jLabel10, gridBagConstraints);

        jLabel11.setText("Iteration");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(jLabel11, gridBagConstraints);

        jLabel12.setText("minor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 16;
        getContentPane().add(jLabel12, gridBagConstraints);

        jTextField24.setColumns(4);
        jTextField24.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 28;
        getContentPane().add(jTextField24, gridBagConstraints);

        jTextField25.setColumns(4);
        jTextField25.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 28;
        getContentPane().add(jTextField25, gridBagConstraints);

        jTextField26.setColumns(4);
        jTextField26.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 28;
        getContentPane().add(jTextField26, gridBagConstraints);

        jTextField28.setColumns(4);
        jTextField28.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField28.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 30;
        getContentPane().add(jTextField28, gridBagConstraints);

        jTextField29.setColumns(4);
        jTextField29.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 30;
        getContentPane().add(jTextField29, gridBagConstraints);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("left-bottom");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(jLabel13, gridBagConstraints);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("right-top");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(jLabel14, gridBagConstraints);

        jTextField30.setColumns(4);
        jTextField30.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 20;
        getContentPane().add(jTextField30, gridBagConstraints);

        jTextField31.setColumns(4);
        jTextField31.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 30;
        getContentPane().add(jTextField31, gridBagConstraints);

        jTextField32.setColumns(4);
        jTextField32.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 28;
        getContentPane().add(jTextField32, gridBagConstraints);

        jTextField33.setColumns(4);
        jTextField33.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 26;
        getContentPane().add(jTextField33, gridBagConstraints);

        jTextField34.setColumns(4);
        jTextField34.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 24;
        getContentPane().add(jTextField34, gridBagConstraints);

        jTextField10.setColumns(4);
        jTextField10.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 32;
        getContentPane().add(jTextField10, gridBagConstraints);

        jTextField14.setColumns(4);
        jTextField14.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 32;
        getContentPane().add(jTextField14, gridBagConstraints);

        jTextField19.setColumns(4);
        jTextField19.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 32;
        getContentPane().add(jTextField19, gridBagConstraints);

        jTextField27.setColumns(4);
        jTextField27.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 32;
        getContentPane().add(jTextField27, gridBagConstraints);

        jLabel15.setText("major");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 14;
        getContentPane().add(jLabel15, gridBagConstraints);

        jLabel16.setText("x");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        getContentPane().add(jLabel16, gridBagConstraints);

        jLabel17.setText("y");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        getContentPane().add(jLabel17, gridBagConstraints);

        jLabel18.setText("x");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 8;
        getContentPane().add(jLabel18, gridBagConstraints);

        jLabel19.setText("y");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 10;
        getContentPane().add(jLabel19, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setValues(SettingsWindowValues settings) {

        widthValue.setText(settings.widthValue);
        heightValue.setText(settings.heightValue);
        scaleX1Value.setText(settings.scaleX1Value);
        scaleY1Value.setText(settings.scaleY1Value);
        scaleX2Value.setText(settings.scaleX2Value);
        scaleY2Value.setText(settings.scaleY2Value);
        iterationMajorValue.setText(settings.iterationMajorValue);
        iterationMinorValue.setText(settings.iterationMinorValue);

    }

    public SettingsWindowValues getValues() {
        SettingsWindowValues result = new SettingsWindowValues();
        result.widthValue = widthValue.getText();
        result.heightValue = heightValue.getText();
        result.iterationMajorValue = iterationMajorValue.getText();
        result.iterationMinorValue = iterationMinorValue.getText();
        result.scaleX1Value = scaleX1Value.getText();
        result.scaleY1Value = scaleY1Value.getText();
        result.scaleX2Value = scaleX2Value.getText();
        result.scaleY2Value = scaleY2Value.getText();
        return result;
    }

    public class SettingsApplyButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            guiObject.recalculate(getValues());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApplyButton;
    private javax.swing.JTextField heightValue;
    private javax.swing.JTextField iterationMajorValue;
    private javax.swing.JTextField iterationMinorValue;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField scaleX1Value;
    private javax.swing.JTextField scaleX2Value;
    private javax.swing.JTextField scaleY1Value;
    private javax.swing.JTextField scaleY2Value;
    private javax.swing.JTextField widthValue;
    // End of variables declaration//GEN-END:variables
}

