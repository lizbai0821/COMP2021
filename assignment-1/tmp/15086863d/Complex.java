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
        this.real=(this.real+other.real);
        this.imag=(this.imag+other.imag);
        return this;
    }

    Complex multiply(Complex other){
        // Task 4: complete the method
        double tempreal,tempimag;
        tempreal=this.real;
        tempimag=this.imag;
        this.real = (this.real*other.real-this.imag*other.imag);
        this.imag = (tempreal*other.imag+tempimag*other.real);
        return this;
    }

    String asString(){
        // Task 4: complete the method
        String temp;
       temp="(" +String.valueOf(this.real)+","+ String.valueOf(this.imag)+")";
        return temp;
    }

    public static void main(String[] args){
        // Task 5: create Complex objects, add or multiply them, and
        //         print the results out to check they are correct
        Complex complex1 = new Complex(7,5);
        Complex complex2 = new Complex(3,10);
        complex1.add(complex2);
        //complex1.multiply(complex2);
        System.out.println("The addition result is: "+complex1.asString());
       // System.out.println("The multiplication result is: "+ complex1.asString());

    }


}
