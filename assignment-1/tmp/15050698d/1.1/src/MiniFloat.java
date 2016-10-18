
import java.lang.Math;

public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float miniFloat = 0f;
        char signString = bitSequence.charAt(0);
        String exponentString = bitSequence.substring(1,5),
                mantissaString = bitSequence.substring(5,8);

        int exponentValue = 0;
        if(exponentString.charAt(0) == '0')
            exponentValue = Integer.parseInt(exponentString, 2);
        else if(exponentString.charAt(0) == '1')
            exponentValue = -1 * ((int)Math.pow(2,5) - Integer.parseInt(exponentString, 2));


        float mantissaValue = 0f;
        for(int i = 0, j = -1; i < mantissaString.length(); i++, j--)
            mantissaValue += Character.getNumericValue(mantissaString.charAt(i)) * (float)Math.pow(2, j);

        miniFloat = (1 + mantissaValue) * (float) Math.pow(2, exponentValue);
        if(signString == '1') miniFloat *= -1;

        return miniFloat;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int intCount = 0;
        for(int i = 0; i < bitSequences.length; i++){
            float mf = miniFloatFromString(bitSequences[i]);
            if (mf%1 == 0){
                System.out.println(bitSequences[i] + " == " + (int)mf);
                intCount++;
            }
        }
        System.out.println("Total number of bit sequences in array: " + bitSequences.length);
        System.out.println("Total number of integral miniFloat values: " + intCount);
    }

    /**
     * Get all valid bit sequences for miniFloat values.
     */
    private static String[] getValidMiniFloatBitSequences(){
        int nbrValues = (int)Math.pow(2, MINI_FLOAT_SIZE);

        String[] result = new String[nbrValues];
        for(int i = 0; i < nbrValues; i++){
            String full = String.format("%" + Integer.SIZE + "s", Integer.toBinaryString(i)).replace(' ', '0');
            result[i] = full.substring(Integer.SIZE - MINI_FLOAT_SIZE, Integer.SIZE);
        }
        return result;
    }

    private static int MINI_FLOAT_SIZE = 8;

}
