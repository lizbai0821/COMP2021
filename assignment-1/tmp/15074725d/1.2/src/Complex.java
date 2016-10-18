public class Complex {

    // Task 3: add the missing fields
    double real;
    double imag;

    Complex(double real, double imag){
        // Task 4: complete the constructor
        this.real = real;
        this.imag = imag;
    }

    Complex add(Complex other){
        // Task 4: complete the method
        Complex sum = new Complex (this.real + other.real, this.imag + other.imag);
        return sum;
    }

    Complex multiply(Complex other){
        // Task 4: complete the method
        Complex pro = new Complex (this.real * other.real + this.imag * other.imag * - 1,this.real * other.imag + other.real * this.imag);
        return pro;
    }

    String asString(){
        // Task 4: complete the method
        String S = this.real + " + "+ this.imag + "i";
        return S;
    }

    public static void main(String[] args){
        // Task 5: create Complex objects, add or multiply them, and
        //         print the results out to check they are correct
        Complex A = new Complex(-7, 5);
        Complex B = new Complex(1, -4);
        System.out.println("The sum of two complex numbers is: " + A.add(B).asString());
        System.out.println("The product of two complex number is: " + A.multiply(B).asString());
    }
}




