class PowerOfN {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0) {
            x = 1/x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long N) {
        if(N == 0) {
            return 1.0;
        }
        double halfProduct = fastPow(x, N/2);
        if(N % 2 == 0) {
            return halfProduct*halfProduct;
        } else {
            return halfProduct*halfProduct*x;
        }
    }
};