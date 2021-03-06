abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {
    double a;
    double b;
    double c;
    Triangle (double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getPerimeter() {
        return a + b + c;
    }
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

class Rectangle extends Shape {
    double a;
    double b;
    Rectangle (double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getPerimeter() {
        return (a + b) * 2;
    }
    public double getArea() {
        return a * b;
    }
}

class Circle extends Shape {
    double r;
    Circle (double r) {
        this.r = r;
    }

    public double getPerimeter() {
        return 2 * Math.PI * r;
    }
    public double getArea() {
        return Math.PI * r * r;
    }
}