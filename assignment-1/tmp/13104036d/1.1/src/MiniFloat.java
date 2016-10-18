public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }


    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int sign = bitSequence.charAt(0) == '0' ? 1 : -1;

        int exponent = 0;
        for (int i = 4; i > 1; i--)
            exponent += Math.pow(2, 4 - i) * (bitSequence.charAt(i) - 48);
        if (bitSequence.charAt(1) == '1')
            exponent -= 8;

        float mantissa = 1;
        for (int i = 5; i < 8; i++)
            mantissa += Math.pow(0.5, i - 4) * (bitSequence.charAt(i) - 48);

        return sign * (float) Math.pow(2, exponent) * mantissa;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        float num;
        int count = 0;
        for (String str : bitSequences) {
            num = miniFloatFromString(str);
            if (num - (int) num == 0.0) {
                System.out.println(str + " -- " + (int) num);
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
