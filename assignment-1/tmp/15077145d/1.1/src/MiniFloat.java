public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int sign;
        int exponent = 0;
        float mantissa = 0f;

        if(bitSequence.charAt(0) == '0'){
            sign = 1;
        }
        else{
            sign = -1;
        }
        for (int i=4;i>0;i--) {
            exponent = exponent + Integer.parseInt(bitSequence.substring(i,i+1)) * (int) Math.pow(2, (4 - i));
        }
        for (int j=5;j<8;j++) {
            mantissa = mantissa + Integer.parseInt(bitSequence.substring(j,j+1)) * (float) Math.pow(2, (4 - j));
        }
    return sign*(float) Math.pow(2, exponent)*(mantissa+1);
    }

    // Task 2: print all the miniFloat values that are integer;
    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count = 0;
        for(int i=0; i < bitSequences.length;i++) {
            if (miniFloatFromString(bitSequences[i]) == (int)miniFloatFromString(bitSequences[i])){
                System.out.println(bitSequences[i] + " == " + miniFloatFromString(bitSequences[i]));
                count = count + 1;
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
