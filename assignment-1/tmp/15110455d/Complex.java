package complex;

public class complex {
	public static class Complex {
		// Task 3: add the missing fields
			private final double real=0;   
		    private final double imag=0;


		    Complex(double real, double imag){
		    	real = real;
		    	imag = imag;
		    }

		    Complex add(Complex other){
		    	System.out.println(real+other.real + imag+other.imag);
		    	return new Complex(real+other.real, imag+other.imag);
		    }

		    Complex multiply(Complex other){
		        // Task 4: complete the method
		    	return new Complex(real*other.real-imag*other.imag , real*other.imag+other.real*imag);
		    }

		    String asString(){
		        // Task 4: complete the method
		    	String x = String.valueOf(this);
		    	return x;
		    }

		    public static void main(String[] args){
		        // Task 5: create Complex objects, add or multiply them, and
		        //         print the results out to check they are correct
		    	Complex num1 = new Complex(-2.0,5.51);
		    	Complex num2= new Complex(-2.75,4.0);
		    	System.out.println("the answer of num1 plus num2 = "+num1.add(num2));
		    	System.out.println("the answer of num1 times num2 ="+num1.multiply(num2));
		    	System.out.println("the answer of num1 as string = "+num1.asString());
		    	System.out.println("the answer of num2 as string = "+num2.asString());
		    }
	}


}
