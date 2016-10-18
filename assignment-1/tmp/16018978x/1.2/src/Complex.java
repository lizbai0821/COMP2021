public class Complex {

    // Task 3: add the missing fields
    double real;
    double imaginary;

    Complex(double real, double imag){
        // Task 4: complete the constructor
        this.real = real;
        this.imaginary = imag;
    }

    /**
     * Adds to complex numbers
     * @param other - second complex number in addition
     * @return sum of these two complex numbers
     */
    Complex add(Complex other){
        // Task 4: complete the method
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    /**
     * Multiplies two complex numbers
     * @param other - second complex number in multiplication
     * @return product of these two complex numbers
     */
    Complex multiply(Complex other){
        // Task 4: complete the method
        return new Complex(
                this.real * other.real + this.imaginary * other.imaginary * -1,
                this.real * other.imaginary + other.real * this.imaginary);
    }

    /**
     * Represents complex number in the following format:
     * (realPart, imaginaryPart)
     * @return string representation
     */
    String asString(){
        // Task 4: complete the method
        return "(" + this.real + ", " + this.imaginary + ")";
    }

    public static void main(String[] args){
        // Task 5: create Complex objects, add or multiply them, and
        //         print the results out to check they are correct
        Complex first = new Complex(2, 3);
        Complex second = new Complex(4, 5);
        Complex multiplied = first.multiply(second);
        System.out.println(multiplied.asString());
    }


}
