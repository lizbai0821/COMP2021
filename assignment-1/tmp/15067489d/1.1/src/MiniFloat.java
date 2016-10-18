public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    // Task1: compute the miniFloat value from "bitSequence";
    private static float miniFloatFromString(String bitSequence){

        int sign = 1;
        float mantissa = 1.0f;

        if (bitSequence.substring(0,1).equals("1")){
            sign = -1;
        }

        int exponent = Integer.parseInt(bitSequence.substring(1,5),2);

        for (int i = 5; i < 8; i++){
            mantissa += Integer.parseInt(bitSequence.substring(i, i+1)) * (float)Math.pow(2, 4-i);
        }

        return sign * (float)Math.pow(2,exponent) * mantissa;
    }

    // Task 2: print all the miniFloat values that are integer;
    private static void printIntegralMiniFloats(){

        String[] bitSequences = getValidMiniFloatBitSequences();

        int count = 0; // To count the total number of integral miniFloat values

        for (int i = 0; i < bitSequences.length; i++){

            float value = miniFloatFromString(bitSequences[i]);

            if (value == (int)value){
                System.out.println(bitSequences[i] + " == " + (int)value);
                count++;
            }

        }

        System.out.println("Total number of integral miniFloat values: " + count);
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
