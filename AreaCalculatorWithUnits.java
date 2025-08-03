
import java.util.Scanner;

abstract class Shape {

    abstract double area();
}

class Circle extends Shape {

    double radius;

    Circle(double r) {
        radius = r;
    }

    double area() {
        return 3.14 * radius * radius;
    }
}

class Rectangle extends Shape {

    double length, width;

    Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    double area() {
        return length * width;
    }
}

class Triangle extends Shape {

    double base, height;

    Triangle(double b, double h) {
        base = b;
        height = h;
    }

    double area() {
        return 0.5 * base * height;
    }
}

class Trapezium extends Shape {

    double a, b, height;

    Trapezium(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.height = h;
    }

    double area() {
        return 0.5 * (a + b) * height;
    }
}

class Cylinder extends Shape {

    double radius, height;

    Cylinder(double r, double h) {
        radius = r;
        height = h;
    }

    double area() {
        return 2 * 3.14 * radius * (radius + height);
    }
}

class Sphere extends Shape {

    double radius;

    Sphere(double r) {
        radius = r;
    }

    double area() {
        return 4 * 3.14 * radius * radius;
    }
}

class Cone extends Shape {

    double radius, slant;

    Cone(double r, double s) {
        radius = r;
        slant = s;
    }

    double area() {
        return 3.14 * radius * (radius + slant);
    }
}

class Cube extends Shape {

    double side;

    Cube(double s) {
        side = s;
    }

    double area() {
        return 6 * side * side;
    }
}

class Cuboid extends Shape {

    double l, w, h;

    Cuboid(double l, double w, double h) {
        this.l = l;
        this.w = w;
        this.h = h;
    }

    double area() {
        return 2 * (l * w + w * h + h * l);
    }
}

public class AreaCalculatorWithUnits {

    public static double convertToMeters(double value, String fromUnit) {
        return switch (fromUnit) {
            case "mm" ->
                value * 0.001;
            case "cm" ->
                value * 0.01;
            case "m" ->
                value;
            default ->
                value;
        };
    }

    public static double convertArea(double areaInMeters, String toUnit) {
        return switch (toUnit) {
            case "mm" ->
                areaInMeters * 1_000_000;
            case "cm" ->
                areaInMeters * 10_000;
            case "m" ->
                areaInMeters;
            default ->
                areaInMeters;
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape s = null;
        int choice;

        do {
            System.out.println("\n=== Area Calculator Menu ===");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Trapezium");
            System.out.println("5. Cylinder");
            System.out.println("6. Sphere");
            System.out.println("7. Cone");
            System.out.println("8. Cube");
            System.out.println("9. Cuboid");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 10) {
                System.out.println("Exiting...");
                return;
            }

            System.out.print("Enter input unit (mm/cm/m): ");
            String inputUnit = sc.next().toLowerCase();
            System.out.print("Enter output unit for area (mm/cm/m): ");
            String outputUnit = sc.next().toLowerCase();

            double a, b, h, r, l, w, s1;

            switch (choice) {
                case 1:
                    System.out.print("Enter radius: ");
                    r = convertToMeters(sc.nextDouble(), inputUnit);
                    s = new Circle(r);
                    break;
                case 2:
                    System.out.print("Enter length and width: ");
                    l = convertToMeters(sc.nextDouble(), inputUnit);
                    w = convertToMeters(sc.nextDouble(), inputUnit);
                    s = new Rectangle(l, w);
                    break;
                case 3:
                    System.out.print("Enter base and height: ");
                    b = convertToMeters(sc.nextDouble(), inputUnit);
                    h = convertToMeters(sc.nextDouble(), inputUnit);
                    s = new Triangle(b, h);
                    break;
                case 4:
                    System.out.print("Enter base1, base2 and height: ");
                    a = convertToMeters(sc.nextDouble(), inputUnit);
                    b = convertToMeters(sc.nextDouble(), inputUnit);
                    h = convertToMeters(sc.nextDouble(), inputUnit);
                    s = new Trapezium(a, b, h);
                    break;
                case 5:
                    System.out.print("Enter radius and height: ");
                    r = convertToMeters(sc.nextDouble(), inputUnit);
                    h = convertToMeters(sc.nextDouble(), inputUnit);
                    s = new Cylinder(r, h);
                    break;
                case 6:
                    System.out.print("Enter radius: ");
                    r = convertToMeters(sc.nextDouble(), inputUnit);
                    s = new Sphere(r);
                    break;
                case 7:
                    System.out.print("Enter radius and slant height: ");
                    r = convertToMeters(sc.nextDouble(), inputUnit);
                    s1 = convertToMeters(sc.nextDouble(), inputUnit);
                    s = new Cone(r, s1);
                    break;
                case 8:
                    System.out.print("Enter side: ");
                    s1 = convertToMeters(sc.nextDouble(), inputUnit);
                    s = new Cube(s1);
                    break;
                case 9:
                    System.out.print("Enter length, width and height: ");
                    l = convertToMeters(sc.nextDouble(), inputUnit);
                    w = convertToMeters(sc.nextDouble(), inputUnit);
                    h = convertToMeters(sc.nextDouble(), inputUnit);
                    s = new Cuboid(l, w, h);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            double areaInMeters = s.area();
            double finalArea = convertArea(areaInMeters, outputUnit);
            System.out.printf("Area = %.2f %s²\n", finalArea, outputUnit);

            System.out.println("Press Enter to continue...");
            sc.nextLine(); // consume leftover newline
            sc.nextLine(); // wait for enter

        } while (true);
    }
}
