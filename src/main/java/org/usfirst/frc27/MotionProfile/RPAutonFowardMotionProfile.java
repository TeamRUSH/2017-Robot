package org.usfirst.frc27.MotionProfile;

/**
 * Created by cyocom on 3/1/17.
 */
public class RPAutonFowardMotionProfile implements MotionProfile {
	public static final int kNumPoints =78;

	// Position (rotations) Velocity (RPM) Duration (ms)
	@Override
	public double[][] getPoints() {
		return new double[][]{		
			{0,	0	,20},
			{0.000909090909090909,	5.454545455	,20},
			{0.00409090909090909,	13.63636364	,20},
			{0.0104545454545455,	24.54545455	,20},
			{0.0209090909090909,	38.18181818	,20},
			{0.0363636363636364,	54.54545455	,20},
			{0.0577272727272727,	73.63636364	,20},
			{0.0859090909090909,	95.45454545	,20},
			{0.121818181818182,	120	,20},
			{0.166363636363636,	147.2727273	,20},
			{0.220454545454545,	177.2727273	,20},
			{0.284545454545455,	207.2727273	,20},
			{0.358636363636364,	237.2727273	,20},
			{0.442727272727273,	267.2727273	,20},
			{0.536818181818182,	297.2727273	,20},
			{0.640909090909091,	327.2727273	,20},
			{0.755,	357.2727273	,20},
			{0.879090909090909,	387.2727273	,20},
			{1.01318181818182,	417.2727273	,20},
			{1.15727272727273,	447.2727273	,20},
			{1.31136363636364,	477.2727273	,20},
			{1.47454545454545,	501.8181818	,20},
			{1.64545454545455,	523.6363636	,20},
			{1.82318181818182,	542.7272727	,20},
			{2.00681818181818,	559.0909091	,20},
			{2.19545454545455,	572.7272727	,20},
			{2.38818181818182,	583.6363636	,20},
			{2.58409090909091,	591.8181818	,20},
			{2.78227272727273,	597.2727273	,20},
			{2.98181818181818,	600	,20},
			{3.18181818181818,	600	,20},
			{3.38181818181818,	600	,20},
			{3.58181818181818,	600	,20},
			{3.78181818181818,	600	,20},
			{3.98181818181818,	600	,20},
			{4.18181818181818,	600	,20},
			{4.38181818181818,	600	,20},
			{4.58181818181818,	600	,20},
			{4.78181818181818,	600	,20},
			{4.98181818181818,	600	,20},
			{5.18181818181818,	600	,20},
			{5.38181818181818,	600	,20},
			{5.58181818181818,	600	,20},
			{5.78181818181818,	600	,20},
			{5.98181818181818,	600	,20},
			{6.18181818181818,	600	,20},
			{6.38181818181818,	600	,20},
			{6.58181818181818,	600	,20},
			{6.78181818181818,	600	,20},
			{6.98090909090909,	594.5454545	,20},
			{7.17772727272728,	586.3636364	,20},
			{7.37136363636364,	575.4545455	,20},
			{7.56090909090909,	561.8181818	,20},
			{7.74545454545455,	545.4545455	,20},
			{7.92409090909091,	526.3636364	,20},
			{8.09590909090909,	504.5454545	,20},
			{8.26,	480	,20},
			{8.41545454545455,	452.7272727	,20},
			{8.56136363636364,	422.7272727	,20},
			{8.69727272727273,	392.7272727	,20},
			{8.82318181818182,	362.7272727	,20},
			{8.93909090909091,	332.7272727	,20},
			{9.045,	302.7272727	,20},
			{9.14090909090909,	272.7272727	,20},
			{9.22681818181819,	242.7272727	,20},
			{9.30272727272728,	212.7272727	,20},
			{9.36863636363637,	182.7272727	,20},
			{9.42454545454546,	152.7272727	,20},
			{9.47045454545455,	122.7272727	,20},
			{9.50727272727273,	98.18181818	,20},
			{9.53636363636364,	76.36363636	,20},
			{9.55863636363637,	57.27272727	,20},
			{9.575,	40.90909091	,20},
			{9.58636363636364,	27.27272727	,20},
			{9.59363636363637,	16.36363636	,20},
			{9.59772727272728,	8.181818182	,20},
			{9.59954545454546,	2.727272727	,20},
			{9.6,	0	,20}};
	}
}