public class Complex {

    private double real;
    private double imag;

    Complex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    Complex add(Complex other){
        Complex result = new Complex(this.real+other.real, this.imag+other.imag);
        return result;
    }

    Complex multiply(Complex other){
        Complex result = new Complex(this.real*other.real - this.imag*other.imag, this.real*other.imag+this.imag*other.real);
        return result;
    }

    String asString(){
       return ("("+ String.valueOf(this.real) + "," + String.valueOf(this.imag) + "i") + ")";
    }

    public static void main(String[] args){
        Complex a = new Complex(4,4);
        Complex b = new Complex(5,2);
        System.out.println("Addition result: " + (a.add(b)).asString());
        System.out.println("Multiply result: " + (a.multiply(b)).asString());
    }
}
