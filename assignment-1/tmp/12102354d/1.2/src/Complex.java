public class Complex {
	// Task 3: add the missing fields
		private final double re;   
	    private final double im;


	    Complex(double real, double imag){
	        // Task 4: complete the constructor
	    	re=real;
	    	im=imag;
	    }

	    Complex add(Complex other){
	        // Task 4: complete the method
	    	return new Complex(re+other.re, im+other.im);
	    }

	    Complex multiply(Complex other){
	        // Task 4: complete the method
	    	return new Complex(re*other.re-im*other.im,re*other.im+other.re*im);
	    }

	    String asString(){
	        // Task 4: complete the method
	    	String s=String.valueOf(this);
	    	return s;
	    }

	    public static void main(String[] args){
	        // Task 5: create Complex objects, add or multiply them, and
	        //         print the results out to check they are correct
	    	Complex a=new Complex(6.0,5.0);
	    	Complex other=new Complex(-3.0,4.0);
	    	System.out.println("a+other="+a.add(other));
	    	System.out.println("a*other="+a.multiply(other));
	    	System.out.println("(a)"+a.asString());
	    }
}
