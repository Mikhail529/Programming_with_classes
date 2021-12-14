import java.text.DecimalFormat;

public class CLS {
    public static void main(String[] args) {

        // Task 7. Описать класс, Представляющий треугольник. Предусмотреть методы для создания объектов,
        // вычисления площади, периметра и точки пересечения медиан

        Treugolnik treugolnik = new Treugolnik(92, 71, 51);
        treugolnik.perimeter();
        treugolnik.square();
        treugolnik.medians();
    }
}

class Treugolnik {
    private int a;
    private int b;
    private int c;

    public Treugolnik(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void perimeter() {
        int p = a + b + c;

        System.out.println("Perimeter: \t" + p);
    }

    public void square() {
        int p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p-a) * (p-b) * (p-c));

        DecimalFormat f = new DecimalFormat("###.000");
        System.out.println("Square: \t" + (f.format(s)));
    }

    public void medians() {
        double mA = Math.sqrt( ((2*Math.pow(b,2)) + 2*Math.pow(c,2) - Math.pow(a,2)) / 4 );
        double mB = Math.sqrt( ((2*Math.pow(a,2)) + 2*Math.pow(c,2) - Math.pow(b,2)) / 4 );
        double mC = Math.sqrt( ((2*Math.pow(a,2)) + 2*Math.pow(b,2) - Math.pow(c,2)) / 4 );

        System.out.println("\nMedian intersection points");
        DecimalFormat f = new DecimalFormat("###.000");
        System.out.println("mA: " + (f.format(mA)));
        System.out.println("mB: " + (f.format(mB)));
        System.out.println("mC: " + (f.format(mC)));
    }
}