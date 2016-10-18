public class Complex {

    double realPart, imagPart;
    Complex(double real, double imag) {
        // Task 4: complete the constructor
        realPart = real;
        imagPart = imag;
}

    Complex add(Complex other){
        Complex result = new Complex(0,0);
        result.realPart = this.realPart + other.realPart;
        result.imagPart = this.imagPart + other.imagPart;
        return result;
    }

    Complex multiply(Complex other){
        Complex result = new Complex(0,0);
        result.realPart = this.realPart * other.realPart -this.imagPart*other.imagPart;
        result.imagPart = this.imagPart * other.realPart + this.realPart*other.imagPart;
        return result;
    }

    String asString(){

        return String.valueOf(this.realPart) + " + " + String.valueOf(this.imagPart)+ "i";
    }

    public static void main(String[] args){
        Complex result ;
        Complex a = new Complex(3,2);
        Complex b = new Complex(1,7);
        result = a.add(b);
        System.out.printf("a + b = %s \n", result.asString());
        result = a.multiply(b);
        System.out.printf("a * b = %s \n", result.asString());
    }


}
