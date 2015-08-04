
import sh.luka.fractal.*;

public class f06b extends FractalIFS {

	public f06b() {
		WIDTH = 2500;
		HEIGHT= 5000;
		IMG_TYPE = java.awt.image.BufferedImage.TYPE_INT_RGB;
		Iteration_minor = 100000;
	}

	protected Transformation getTransformation() {

		int MIP = 4;
		double[] AA = {0, 0.85, 0.2, -0.15};
		double[] AB = {0, 0.04, -0.26, 0.28};
		double[] AC = {0, -0.04, 0.23, 0.26};
		double[] AD = {0.16, 0.85, 0.22, 0.24};
		double[] AE = {0, 0, 0, 0};
		double[] AF = {0, 1.6, 1.6, 0.44};

		Transformation t = new Transformation(MIP, AA, AB, AC, AD, AE, AF);

		return t;
	}

	public double[] defaultScale() {

		// scale for isf
                double[] scale = new double[4];
		// 0 & 1 - it is left-bottom corner
		// 2 & 3 - it is right-top corner
		scale[0] = -3;
		scale[1] = 0;
		scale[2] = 3;
		scale[3] = 10;

                setScale(scale);

		return scale;
	}

}
