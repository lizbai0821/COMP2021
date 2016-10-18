public class Complex {

    // Task 3: add the missing fields
    double Real, Imag;

    Complex(double real, double imag) {
        // Task 4: complete the constructor
        this.Real = real;
        this.Imag = imag;
    }

    Complex add(Complex other) {
        // Task 4: complete the method
        this.Real += other.Real;
        this.Imag += other.Imag;
        return this;
    }

    Complex multiply(Complex other) {
        // Task 4: complete the method
        double rawReal = this.Real;
        this.Real = this.Real * other.Real + (this.Imag * other.Imag) * -1;
        this.Imag = rawReal * other.Imag + this.Imag * other.Real;
        return this;
    }

    String asString() {
        // Task 4: complete the method
        return "(" + this.Real + "," + this.Imag + "i)";
    }

    public static void main(String[] args) {
        // Task 5: create Complex objects, add or multiply them, and
        //         print the results out to check they are correct
        Complex c1 = new Complex(3, 2);
        Complex c2 = new Complex(1, 7);

        c1 = c1.multiply(c2);           //Result: (-11.0,23.0i)
        System.out.println("Multiply:\t" + c1.asString());

        c1 = c1.add(c2);                //Result: (-10.0,30.0i)
        System.out.println("Add:\t\t" + c1.asString());
    }
}
