public class Complex {
	double real;
	double imag;
    // Task 3: add the missing fields


    Complex(double real, double imag){
        // Task 4: complete the constructor
    	this.real=real;
    	this.imag=imag;
    }

    Complex add(Complex other){
        // Task 4: complete the method
    	Complex res=new Complex(0,0);
    	res.real=this.real+other.real;
    	res.imag=this.imag+other.imag;
    	return res;
    }

    Complex multiply(Complex other){
        // Task 4: complete the method
    	Complex res=new Complex(0,0);
    	res.real=this.real*other.real-this.imag*other.imag;
    	res.imag=this.imag*other.real+this.real*other.imag;
    	return res;
    }

    String asString(){
        // Task 4: complete the method
    	String realStr=String.valueOf(this.real);
    	String imagStr=String.valueOf(this.imag);
    	String res=realStr+" + "+imagStr+"i";
    	return res;
    }

    public static void main(String[] args){
        // Task 5: create Complex objects, add or multiply them, and
        //         print the results out to check they are correct
    	Complex a=new Complex(4,2);
    	Complex b=new Complex(2,5);
    	Complex sum=a.add(b);
    	Complex mult=a.multiply(b);
    	System.out.println(sum.asString());
    	System.out.println(mult.asString());
    }
}
