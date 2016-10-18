import java.util.Arrays;

public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        String bit = bitSequence;
        double manti = 0, expo = 0;
        double indi = -3 ;
        float result;
        for(int i = 7; i>4; i--){
            char s = bit.charAt(i);
            float n = Character.getNumericValue(s);
            if(n==1){manti = manti + Math.pow(2, indi);}
            indi++;
        }
        manti += 1;
        indi = 0;
        for(int i=4; i>0; i--){
            char s = bit.charAt(i);
            float n = Character.getNumericValue(s);
            if (n == 1) {
                expo = expo + Math.pow(2, indi);
            }
            indi++;
        }
        Double mantiv = new Double(manti);
        expo = Math.pow(2, expo);
        Double expov = new Double(expo);
        float m = mantiv.floatValue();
        float e = expov.floatValue();
        char s = bit.charAt(0);
        float n = Character.getNumericValue(s);
        if(n == 0.0){
            result =  m*e;
        }
        else{
            result =  -(m*e);
        }
        return result;
    }

    private static void printIntegralMiniFloats(){
   //     String[] bitSequences = {"00100110", "00100111", "01111111"};

        // Task 2: print all the miniFloat values that are integer;
        String[] bitSequences = getValidMiniFloatBitSequences();
        int total=0;
        double value;
        for(int i = 0; i<bitSequences.length; i++){
            value = miniFloatFromString(bitSequences[i]);
            if(value == Math.ceil(value)){
                System.out.println((bitSequences[i]) + " == " + value);
                total += 1;
            }
        }
        System.out.println("Total number of integral miniFloat values: " + total);
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
