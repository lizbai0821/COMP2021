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
    	return new Complex(this.real+other.real,this.imag+other.imag);
    }

    Complex multiply(Complex other){
        // Task 4: complete the method
    	return new Complex(this.real*other.real-this.imag*other.imag,this.real*other.imag+this.imag*other.real);
    }

    String asString(){
        // Task 4: complete the method
    	return "("+this.real+","+this.imag+")";

    }

    public static void main(String[] args){
        // Task 5: create Complex objects, add or multiply them, and
        //         print the results out to check they are correct
    	Complex c1 = new Complex(1,2);
    	Complex c2 = new Complex(3,4);
    	System.out.println(c1.add(c2).asString());
    	System.out.println(c1.multiply(c2).asString());
    }


}
