public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int sign = 0; // -1 for negative while 1 for positive (replace the boolean)
        float exponent = 0;
        float mantissa = 0;

        // Signed part
        if (bitSequence.charAt(0) == '1'){
            sign = -1;
        }
        else if (bitSequence.charAt(0) == '0') {
            sign = 1;
        }

        // Exponent part
        for (int j = 0; j < 4; j++){
            if (bitSequence.substring(1,5).charAt(j) == '1'){
                exponent += (float) Math.pow(2,3-j);
            }
        }

        //exponent = Integer.parseInt(bitSequence.substring(1,5),2); // BinaryString to int

        // mantissa part
        for (int i = 0; i < 3; i++){
            if (bitSequence.substring(5,8).charAt(i) == '1'){
                mantissa += (float) Math.pow(2,-i-1);
            }
        }
        mantissa = 1 + mantissa;
        return mantissa * (float) Math.pow(2,exponent) * sign;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        // Task 2: print all the miniFloat values that are integer;
        int counter = 0;
        for (int i = 0; i < 256; i++){
            if (miniFloatFromString(bitSequences[i]) == (int)miniFloatFromString(bitSequences[i])){
                System.out.println(bitSequences[i] + " == " + (int)miniFloatFromString(bitSequences[i]));
                counter++;
            }
        }
        System.out.println("The total number of integral minifloat value is: "+counter);
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
