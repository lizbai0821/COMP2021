public class Complex {


    // Task 3: add the missing fields
    private double real;
    private double imaginary;

    //Add Getter & Setter
    public double getReal(){return real;}
    public double getImaginary(){return  imaginary;}

    public void setImaginary(double imaginary) {this.imaginary = imaginary;}
    public void setReal(double real) {this.real = real;}

    Complex(double real, double imag){
        // Task 4: complete the constructor
        this.real = real;
        this.imaginary = imag;
    }

    Complex add(Complex other){
        // Task 4: complete the method
        double real =  this.getReal() + other.getReal();
        double imag = this.getImaginary() + other.getImaginary();
        return new Complex(real,imag);
    }

    Complex multiply(Complex other){
        // Task 4: complete the method
        double real = this.getReal()*other.getReal() - this.getImaginary()*other.getImaginary();
        double imag = this.getImaginary()*other.getReal() + this.getReal()*other.getImaginary();
        return  new Complex(real,imag);
    }

    String asString(){
        // Task 4: complete the method
        return "("+getReal()+","+getImaginary()+")";
    }

    public static void main(String[] args){
        // Task 5: create Complex objects, add or multiply them, and
        //         print the results out to check they are correct
        Complex x = new Complex(1,2);
        Complex y = new Complex(2,4);
        System.out.println("x+y = "+ x.add(y).asString());
        System.out.println("x*y = " + x.multiply(y).asString());

    }


}
