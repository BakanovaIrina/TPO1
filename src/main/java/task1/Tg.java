package task1;

public class Tg {
    public static double calc(double x){

        while (x > Math.PI / 2) x -= Math.PI;

        while (x < - Math.PI / 2) x += Math.PI;

        double result = 0;
        for(int n = 0; n < 10; n++){
            result += Math.pow(-1, n - 1) * (Math.pow(2, 2* n ) * (Math.pow(2, 2 * n) - 1) * calcBn(2 * n)) * Math.pow(x, 2 * n - 1) /
                    (factorial(2 * n));
        }

        if (x == Math.PI / 2 || x == -Math.PI / 2) return Double.NaN;
        if(x == 0) return 0;

        return result;
    }

    public static double calcBn(double n){
        if (n == 0){
            return 1;
        }
        double x = 1;
        for(int m = 1; m < n; m++){
            x += calcCnm(n + 1, m) * calcBn(m);
        }
        return - x / calcCnm(n + 1, n);
    }

    private static double calcCnm(double n, double m){
        return factorial(n) / (factorial(m) * factorial(n - m));
    }

    private static double factorial(double x){
        if(x == 1 || x == 0){
            return 1;
        }
        else {
            return x * factorial(x - 1);
        }
    }


}
