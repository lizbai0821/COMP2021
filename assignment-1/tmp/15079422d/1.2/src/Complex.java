//Chan Kwan Wai, 15079422D
public class Complex {

    // Task 3: add the missing fields
    double realnum, imagine;

    Complex(double real, double imag){
        // Task 4: complete the constructor
        realnum = real;
        imagine = imag;
    }

    Complex add(Complex other){
        // Task 4: complete the method
        double realpart = realnum+other.realnum;
        double imagpart = imagine+other.imagine;
        Complex a = new Complex(realpart,imagpart);
        return a;
    }

    Complex multiply(Complex other){
        // Task 4: complete the method
        double realpart = realnum*other.realnum-imagine*other.imagine;
        double imagpart = imagine*other.realnum + realnum*other.imagine;
        Complex a = new Complex(realpart,imagpart);
        return a;
    }

    String asString(){
        // Task 4: complete the method
        StringBuilder longString = new StringBuilder();
        longString.append('(').append(this.realnum).append(", ").append(this.imagine).append("i)");
        return longString.toString();
    }

    public static void main(String[] args){
        // Task 5: create Complex objects, add or multiply them, and
        //         print the results out to check they are correct
        Complex num1 = new Complex(1,2);
        Complex num2 = new Complex(2,3);

        num1 = num1.add(num2);
        System.out.println(num1.asString());

        num1 = num1.multiply(num2);
        System.out.println(num1.asString());
    }


}
