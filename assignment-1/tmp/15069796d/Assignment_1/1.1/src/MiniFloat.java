///////////////////////////////////////////////
//  Student ID: 15069796D
//  Name: Lee Man Kit Tommy
//  Info: Assignment 1.1
//  Description: A simple implementation of:
//                1. Convert bit sequence to float value using the given minifloat standard using string handling and...
//                      - simple maths for sign bit
//                      - loops for dealing with exponents (with 2s complement) and mantissa
//                2. Prints all integral minifloat sequence
//                      - using % 1 to find the integral minifloat
//                      - typecase the minifloat to be printed as int so as to fulfill the sample output

///////////////////////////////////////////////
// Compiled and tested at jdk1.0.8_101
// Troubleshooting:
// If cannot compile in IntelliJ IDEA: Right Click src(folder) -> Press F4 -> Set Language level: 8
public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }


    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";

        /* miniFloat bits:
            SEEEEMMM
          S = Sign, E = Exponent(2s complement), M = Mantissa
        */
        final int EXP_BIT_START = 1;
        final int EXP_BIT_LENGTH = 4;
        final int MAN_BIT_START = EXP_BIT_START+EXP_BIT_LENGTH;
        final int MAN_BIT_LENGTH = 3;

        /*Deal with the sign
          0 is positive, 1 is negative, therefore sign = (sign bit * 2 - 1) * -1 would return the sign in (+1 or -1)
          Simplify the above formula: sign = -2 * sign bit + 1
        */
        int sign = -2*Character.getNumericValue(bitSequence.charAt(0))+1;    //First bit is sign bit, and plug in the formula to get the sign

        //Now we've got the sign, time to deal with the exponent and mantissa using the typical conversion method

        int exponent = 0;
        int expValue = 1;

        /*Calculate the binary value from b to a, e.g.: the twos complement for exponent
                                           a  b
                                           |  |
                                           v  v
        miniFloat bits:                   SEEEEMMM

        expValue = 1;
          for i := 3 downto 1
              answer = E[i]*expValue;
              expValue *= 2;
        */
        for(int i = EXP_BIT_START+EXP_BIT_LENGTH-1; i >= EXP_BIT_START ; i--, expValue *= 2)
            exponent += Character.getNumericValue(bitSequence.charAt(i))*expValue;

        if (Character.getNumericValue(bitSequence.charAt(EXP_BIT_START)) == 1)
            exponent -= expValue; //"flip the bits"

        //Deal with the mantissa, this time, do it from left to right, divide by 2 instead of multiply...

        float mantissa = 1f;
        float expValueM = 0.5f;
        for(int i = MAN_BIT_START; i < MAN_BIT_START+MAN_BIT_LENGTH ; i++, expValueM /= 2)
        {
            //System.out.printf("%f\n",mantissa);
            mantissa += Character.getNumericValue(bitSequence.charAt(i))*expValueM;
        }

        return (float)(sign*Math.pow(2,exponent)*mantissa);
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int counter = 0;
        // Task 2: print all the miniFloat values that are integer;
        for(int i = 0; i < bitSequences.length; i++)
        {
            float value = miniFloatFromString(bitSequences[i]);
            if(value % 1 == 0) { //if it only has the integral part...
                System.out.printf("%s == %d\n", bitSequences[i], (int)value); //typecast int to remove zeros and radix point.
                counter++;
            }
        }
        System.out.println("Total number of integral miniFloat values: " + Integer.toString(counter));
    }

    /**
     * Get all valid bit sequences for miniFloat values.
     */
    private static String[] getValidMiniFloatBitSequences(){
        int nbrValues = (int)Math.pow(2, MINI_FLOAT_SIZE);

        String[] result = new String[nbrValues];
        for(int i = 0; i < nbrValues; i++){

            String full = String.format("%" + Integer.SIZE + "s", Integer.toBinaryString(i))
                    .replace(' ', '0');
            result[i] = full.substring(Integer.SIZE - MINI_FLOAT_SIZE, Integer.SIZE);
        }
        return result;
    }

    private static int MINI_FLOAT_SIZE = 8;

}
