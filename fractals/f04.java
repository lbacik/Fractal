
import sh.luka.fractal.FractalIFS;

/* Dragon */
public class f04 extends FractalIFS {

    public f04() {
        WIDTH = 10000;
        HEIGHT = 10000;
        IMG_TYPE = java.awt.image.BufferedImage.TYPE_INT_RGB;
        Iteration_minor = 100000000;
    }

    @Override
    protected Transformation getTransformation() {

        int MIP = 2;

        double[] AA = {0.824074, 0.088272};
        double[] AB = {0.281482, 0.520988};
        double[] AC = {-0.212346, -0.463889};
        double[] AD = {0.864198, -0.377778};
        double[] AE = {-1.88229, 0.78536};
        double[] AF = {-0.110607, 8.095795};

        Transformation t = new Transformation(MIP, AA, AB, AC, AD, AE, AF);

        return t;
    }

    @Override
    public double[] defaultScale() {

        // scale for isf
        double[] scale = new double[4];
        // 0 & 1 - it is left-bottom corner
        // 2 & 3 - it is right-top corner
        scale[0] = -6.5;
        scale[1] = -1.5;
        scale[2] = 6.5;
        scale[3] = 11.5;

        setScale(scale);

        return scale;
    }
}
