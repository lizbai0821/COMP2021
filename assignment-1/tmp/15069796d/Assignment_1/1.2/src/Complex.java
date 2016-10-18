///////////////////////////////////////////////
//  Student ID: 15069796D
//  Name: Lee Man Kit Tommy
//  Info: Assignment 1.2
//  Description: A simple implementation using class to handle complex numbers and some of its operation (+,x)
//

import static java.lang.System.currentTimeMillis; //Uses this for generating some "random" numbers

///////////////////////////////////////////////
// Compiled and tested at jdk1.0.8_101
// Troubleshooting:
// If cannot compile in IntelliJ IDEA: Right Click src(folder) -> Press F4 -> Set Language level: 8

public class Complex {
    // Task 3: add the missing fields
    private double real, imag;

    Complex(double real, double imag){
        // Task 4: complete the constructor
        //Assignment operations
        this.real = real;
        this.imag = imag;
    }

    Complex add(Complex other){
        // Task 4: complete the method
        // Maths stuffs: a+bi + c+di = (a+c) + (b+d)i
        return new Complex(this.real+other.real,this.imag+other.imag);
    }

    Complex multiply(Complex other){
        // Task 4: complete the method
        // (a+bi) * (c+di) = ac-bd + (ad+bc)i
        return new Complex(
                            this.real*other.real-
                            this.imag*other.imag,

                            this.real*other.imag+
                            other.real*this.imag
                          );
    }

    String asString(){
        // Task 4: complete the method
        return String.format("(%f, %f)",real, imag); //Return the string in the format (real ,imag) by formatting the string
    }

    public static void main(String[] args){
        // Task 5: create Complex objects, add or multiply them, and
        //         print the results out to check they are correct

        final int NUM_OF_COMPLEX_OP = 10;
        final double D_MIN = -10.0;
        final double D_MAX = 10.0;

        //Print some simple stuffs first to check correctness...
        Complex t1 = new Complex(1, 2);
        Complex t2 = new Complex(3, 4);
        System.out.printf("%s + %s = %s\n",t1.asString(), t2.asString(), t1.add(t2).asString());
        System.out.printf("%s * %s = %s\n\n",t1.asString(), t2.asString(), t1.multiply(t2).asString());

        //Afterwards, lets print some "random" stuffs
        for(int i = 0; i < NUM_OF_COMPLEX_OP; i++)
        {
            double r1 = currentTimeMillis()%2016.0922-15.57;
            double r2 = currentTimeMillis()%2021-1.80101;
            double r3 = currentTimeMillis()%2021-814;
            double r4 = currentTimeMillis()%1.2-0.6;
            Complex a = new Complex(r1, r2);
            Complex b = new Complex(r3, r4);
            System.out.printf("%s + %s = %s\n",a.asString(), b.asString(), a.add(b).asString());
            System.out.printf("%s * %s = %s\n\n",a.asString(), b.asString(), a.multiply(b).asString());
        }
    }
}
