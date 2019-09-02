package by.it.yakimovich.jd01_03;

 class Helper {
    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (double element : arr) {
            if (element < min) min = element;
        }
        return min;

    }

    static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        for (double element : arr) {
            if (element > max) max = element;
        }
        return max;
    }
     static void sort(double[ ] arr){
        double m[]={};
        boolean swap= false;
        double last;
        while(!swap) {
            swap = true;
            for (int i = 0; i < m.length - 1; i++) {
                if (m[i] > m[i + 1]) {
                    swap = false;

                    last = m[i];
                    m[i] = m[i + 1];
                    m[i + 1] = last;
                }
            }
        }

     }
}
