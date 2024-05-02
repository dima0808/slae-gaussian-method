package com.amo.lab5.util;

public class SlaeCalculation {

    public static double[] gaussianMethod(int n, double[][] a, double[] b) {

        double[] x = new double[n];

        double aMax;
        int l;
        double[] tempA;
        double tempB;
        double m;
        for (int k = 0; k < n - 1; k++) {
            aMax = a[k][k];
            l = k;

            for (int i = k + 1; i < n; i++) {
                if (a[i][k] > aMax) {
                    aMax = a[i][k];
                    l = i;
                }
            }

            if (l != k) {
                tempA = a[k];
                a[k] = a[l];
                a[l] = tempA;

                tempB = b[k];
                b[k] = b[l];
                b[l] = tempB;
            }

            for (int i = k + 1; i < n; i++) {
                m = a[i][k] / a[k][k];

                for(int j = k; j < n; j++) {
                    a[i][j] = a[i][j] - m * a[k][j];
                }

                b[i] = b[i] - m * b[k];
            }
        }

        x[n - 1] = b[n - 1] / a[n - 1][n - 1];

        double s;
        for (int i = n - 2; i >= 0; i--) {
            s = 0;

            for (int j = i + 1; j < n; j++) {
                s += a[i][j] * x[j];
            }

            x[i] = (b[i] - s) / a[i][i];
        }

        return x;
    }
}
