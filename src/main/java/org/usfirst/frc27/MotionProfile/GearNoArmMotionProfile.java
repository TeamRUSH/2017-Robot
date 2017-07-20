package org.usfirst.frc27.MotionProfile;

/**
 * Created by cyocom on 3/1/17.
 */
public class GearNoArmMotionProfile implements MotionProfile {
	public static final int kNumPoints =159;

	// Position (rotations) Velocity (RPM) Duration (ms)
	@Override
	public double[][] getPoints() {
		return new double[][]{
			{0,	0	,30},
			{0.000535714285714286,	2.142857143	,30},
			{0.00241071428571429,	5.357142857	,30},
			{0.00616071428571428,	9.642857143	,30},
			{0.0123214285714286,	15	,30},
			{0.0214285714285714,	21.42857143	,30},
			{0.0340178571428571,	28.92857143	,30},
			{0.050625,	37.5	,30},
			{0.0715178571428571,	46.07142857	,30},
			{0.0966964285714286,	54.64285714	,30},
			{0.126160714285714,	63.21428571	,30},
			{0.159910714285714,	71.78571429	,30},
			{0.197946428571429,	80.35714286	,30},
			{0.240267857142857,	88.92857143	,30},
			{0.286875,	97.5	,30},
			{0.337232142857143,	103.9285714	,30},
			{0.390535714285714,	109.2857143	,30},
			{0.44625,	113.5714286	,30},
			{0.503839285714286,	116.7857143	,30},
			{0.562767857142857,	118.9285714	,30},
			{0.6225,	120	,30},
			{0.6825,	120	,30},
			{0.7425,	120	,30},
			{0.8025,	120	,30},
			{0.8625,	120	,30},
			{0.9225,	120	,30},
			{0.9825,	120	,30},
			{1.0425,	120	,30},
			{1.1025,	120	,30},
			{1.1625,	120	,30},
			{1.2225,	120	,30},
			{1.2825,	120	,30},
			{1.3425,	120	,30},
			{1.4025,	120	,30},
			{1.4625,	120	,30},
			{1.5225,	120	,30},
			{1.5825,	120	,30},
			{1.6425,	120	,30},
			{1.7025,	120	,30},
			{1.7625,	120	,30},
			{1.8225,	120	,30},
			{1.8825,	120	,30},
			{1.9425,	120	,30},
			{2.0025,	120	,30},
			{2.0625,	120	,30},
			{2.1225,	120	,30},
			{2.1825,	120	,30},
			{2.2425,	120	,30},
			{2.3025,	120	,30},
			{2.3625,	120	,30},
			{2.4225,	120	,30},
			{2.4825,	120	,30},
			{2.5425,	120	,30},
			{2.6025,	120	,30},
			{2.6625,	120	,30},
			{2.7225,	120	,30},
			{2.7825,	120	,30},
			{2.8425,	120	,30},
			{2.9025,	120	,30},
			{2.9625,	120	,30},
			{3.0225,	120	,30},
			{3.0825,	120	,30},
			{3.1425,	120	,30},
			{3.2025,	120	,30},
			{3.2625,	120	,30},
			{3.3225,	120	,30},
			{3.3825,	120	,30},
			{3.4425,	120	,30},
			{3.5025,	120	,30},
			{3.5625,	120	,30},
			{3.6225,	120	,30},
			{3.6825,	120	,30},
			{3.7425,	120	,30},
			{3.8025,	120	,30},
			{3.8625,	120	,30},
			{3.9225,	120	,30},
			{3.9825,	120	,30},
			{4.0425,	120	,30},
			{4.1025,	120	,30},
			{4.1625,	120	,30},
			{4.2225,	120	,30},
			{4.2825,	120	,30},
			{4.3425,	120	,30},
			{4.4025,	120	,30},
			{4.4625,	120	,30},
			{4.5225,	120	,30},
			{4.5825,	120	,30},
			{4.6425,	120	,30},
			{4.7025,	120	,30},
			{4.7625,	120	,30},
			{4.8225,	120	,30},
			{4.8825,	120	,30},
			{4.9425,	120	,30},
			{5.0025,	120	,30},
			{5.0625,	120	,30},
			{5.1225,	120	,30},
			{5.18249999999999,	120	,30},
			{5.24249999999999,	120	,30},
			{5.30249999999999,	120	,30},
			{5.36249999999999,	120	,30},
			{5.42249999999999,	120	,30},
			{5.48249999999999,	120	,30},
			{5.54249999999999,	120	,30},
			{5.60249999999999,	120	,30},
			{5.66249999999999,	120	,30},
			{5.72249999999999,	120	,30},
			{5.78249999999999,	120	,30},
			{5.84249999999999,	120	,30},
			{5.90249999999999,	120	,30},
			{5.96249999999999,	120	,30},
			{6.02249999999999,	120	,30},
			{6.08249999999999,	120	,30},
			{6.14249999999999,	120	,30},
			{6.20249999999999,	120	,30},
			{6.26249999999999,	120	,30},
			{6.32249999999999,	120	,30},
			{6.38249999999999,	120	,30},
			{6.44249999999999,	120	,30},
			{6.50249999999999,	120	,30},
			{6.56249999999999,	120	,30},
			{6.62249999999999,	120	,30},
			{6.68249999999999,	120	,30},
			{6.74249999999998,	120	,30},
			{6.80249999999998,	120	,30},
			{6.86249999999998,	120	,30},
			{6.92249999999998,	120	,30},
			{6.98249999999998,	120	,30},
			{7.04249999999998,	120	,30},
			{7.10249999999998,	120	,30},
			{7.16249999999998,	120	,30},
			{7.22249999999998,	120	,30},
			{7.28249999999998,	120	,30},
			{7.34249999999998,	120	,30},
			{7.40249999999998,	120	,30},
			{7.46249999999998,	120	,30},
			{7.52249999999998,	120	,30},
			{7.58249999999998,	120	,30},
			{7.64249999999998,	120	,30},
			{7.70196428571426,	117.8571429	,30},
			{7.76008928571426,	114.6428571	,30},
			{7.81633928571426,	110.3571429	,30},
			{7.87017857142855,	105	,30},
			{7.92107142857141,	98.57142857	,30},
			{7.96848214285712,	91.07142857	,30},
			{8.01187499999998,	82.5	,30},
			{8.05098214285712,	73.92857143	,30},
			{8.08580357142855,	65.35714286	,30},
			{8.11633928571426,	56.78571429	,30},
			{8.14258928571426,	48.21428571	,30},
			{8.16455357142855,	39.64285714	,30},
			{8.18223214285712,	31.07142857	,30},
			{8.19562499999998,	22.5	,30},
			{8.20526785714284,	16.07142857	,30},
			{8.21196428571427,	10.71428571	,30},
			{8.21624999999998,	6.428571429	,30},
			{8.2186607142857,	3.214285714	,30},
			{8.21973214285712,	1.071428571	,30},
			{8.21999999999998,	4.996E-15	,30},
			{8.21999999999998,	0	,30}};
	}
}