import java.util.Scanner;

public class Complex {

    // Task 3: add the missing fields

    double real,imag;


    Complex(double real, double imag){
        // Task 4: complete the constructor
        this.real=real;
        this.imag=imag;

    }

    Complex add(Complex other){
        // Task 4: complete the method
        Complex Temp = new Complex((this.real+other.real),(this.imag+other.imag));
        return Temp;
    }

    Complex multiply(Complex other){
        // Task 4: complete the method
        Complex Temp = new Complex(
                (this.real*other.real-this.imag*other.imag),
                (this.real*other.imag+this.imag*other.real));
        return Temp;
    }

    String asString(){
        // Task 4: complete the method
        StringBuilder str = new StringBuilder();
        str.append('(').append(real).append(" , ").append(imag).append("i)");
        return str.toString();
    }

    public static void main(String[] args){
        // Task 5: create Complex objects, add or multiply them, and
        //         print the results out to check they are correct
        Complex num1 = new Complex(0,0);
        Complex num2 = new Complex(0,0);
        Scanner input = new Scanner(System.in);
        System.out.printf("Please input the first real part of the number: ");
        num1.real = input.nextDouble();
        System.out.printf("Please input the first imaginary part of the number: ");
        num1.imag = input.nextDouble();
        System.out.printf("Please input the second real part of the number: ");
        num2.real = input.nextDouble();
        System.out.printf("Please input the second imaginary part of the number: ");
        num2.imag = input.nextDouble();
        System.out.println("Sum of two complexes: ");
        num1 = num1.add(num2);
        System.out.println(num1.asString());
        System.out.println("Multiply of two complexes: ");
        num1 = num1.multiply(num2);
        System.out.printf(num1.asString());


    }


}
