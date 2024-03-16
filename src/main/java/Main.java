public class Main {
    public static double factorial(int n){
        if (n < 0) {
            throw new ArithmeticException("Factorial is unknown if n < 0");
        }
        if (n == 0) return 1;
        return n * factorial(n-1);
    }

    public static double sin(double x, int steps){
        return Math.pow(-1, steps) * Math.pow(x, 2*steps + 1) / factorial(2*steps + 1);
    }

    public static double cos(double x, int steps){
        return sin(Math.PI / 2 - x, steps);
    }

    public static double tan(double x, int steps){
        return sin(x, steps) / cos(x, steps);
    }

    public static double cot(double x, int steps){
        return cos(x, steps) / sin(x, steps);
    }

    public static double sec(double x, int steps){
        return 1/cos(x, steps);
    }

    public static double csc(double x, int steps){
        return 1/sin(x, steps);
    }

    public static double ln(double x, int steps){
        double num, mul, cal, sum = 0;

        num = (x - 1) / (x + 1);

        for (int i = 1; i <= steps; i++) {
            mul = (2 * i) - 1;
            cal = Math.pow(num, mul);
            cal = cal / mul;
            sum = sum + cal;
        }

        sum = 2 * sum;
        return sum;
    }

    public static double log_10(double x, int steps){
        return ln(x, steps) / ln(10, steps);
    }

    public static double log_5(double x, int steps){
        return ln(x, steps) / ln(5, steps);
    }

    public static double log_3(double x, int steps){
        return ln(x, steps) / ln(3, steps);
    }

    public static void main(String[] args) {
        int steps = 1;
        double diff = 0.00001;
        double x = 1;
        while (Math.abs(Math.sin(x) - sin(x, steps)) > diff || Math.abs(Math.log(x) - ln(x,steps)) > diff){
            steps++;
        }

        double y = 0;
        if (x <= 0){
            y = ((Math.pow((Math.pow((((((((Math.pow((((Math.pow((Math.pow(((sec(x, steps) * cos(x, steps)) * tan(x, steps)),3)),2)) - cot(x, steps)) - sin(x, steps)),2)) + sec(x, steps)) / sin(x, steps)) + (cos(x, steps) / tan(x, steps))) + (cos(x, steps) / cos(x, steps))) + (csc(x, steps) * (((((Math.pow(sec(x, steps),3)) * (Math.pow(cos(x, steps),3))) / sec(x, steps)) + cos(x, steps)) * csc(x, steps)))) + ((((cot(x, steps) - csc(x, steps)) * tan(x, steps)) + (cot(x, steps) + tan(x, steps))) - (tan(x, steps) / sin(x, steps)))),3)),2)) / (((cos(x, steps) / (cot(x, steps) - csc(x, steps))) + ((((((Math.pow(cos(x, steps),3)) / tan(x, steps)) / csc(x, steps)) * sin(x, steps)) * (((tan(x, steps) / sec(x, steps)) / tan(x, steps)) * cos(x, steps))) / cot(x, steps))) - ((((sin(x, steps) + (Math.pow(sin(x, steps),2))) * (sec(x, steps) / (((tan(x, steps) - (tan(x, steps) * cot(x, steps))) / (Math.pow(sec(x, steps),3))) * cot(x, steps)))) / csc(x, steps)) + cos(x, steps))));
        } else {
            y = (Math.pow(((((ln(x, steps) - log_10(x, steps)) - log_5(x, steps)) * log_5(x, steps)) / (log_3(x, steps) + ln(x, steps))), 3));
        }

    }
}
