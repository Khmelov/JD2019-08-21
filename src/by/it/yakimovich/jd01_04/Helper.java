package by.it.yakimovich.jd01_04;

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
        boolean swap;
        double last=arr.length-1;
        do {
            swap=false;
            for (int i = 0; i <last; i++) {
                if (arr[i] > arr[i+1]) {
                    int buffer= (int) arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=buffer;
                    swap=true;
                }


            }
            last--;
        }
        while (swap);
     }
}
