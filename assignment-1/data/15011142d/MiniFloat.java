import java.lang.Math;

public class MiniFloat {

    public static void main(String[] args){
        //System.out.println(miniFloatFromString("00100110"));
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";

        int[] bToD = {8, 4, 2, 1};
        int exponent = 0;
        float mantissa = 1;
        for(int i = 1 ; i < 5;i++)
            if(bitSequence.charAt(i) == '1')
                exponent += bToD[i-1];

        if(bitSequence.charAt(1) == '1')
        	exponent -= 16;

        for(int i = 5 ; i < 8;i++)
            if(bitSequence.charAt(i) == '1')
                mantissa += Math.pow(2,4-i);

        return (bitSequence.charAt(0) == '1' ? -1 : 1) * (float)Math.pow(2,exponent) * mantissa;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int integerCount = 0;
        for(int i = 0 ; i < bitSequences.length; i++){
            float temp = miniFloatFromString(bitSequences[i]);
            if(temp == (int)temp) {
                System.out.println(bitSequences[i] + " == " + (int)temp);
                integerCount++;
            }
        }
        System.out.println("...");
        System.out.println("Total number of integral miniFloat values: " + integerCount);
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
