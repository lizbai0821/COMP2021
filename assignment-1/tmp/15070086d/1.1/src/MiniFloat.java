public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        final int EXPONENT_SIZE = 4;
        final int MANTISSA_SIZE = 3;

        int sign = bitSequence.charAt(0) == '1' ? -1 : 1;

        String bitExponent = bitSequence.substring(1, EXPONENT_SIZE+1);
        int exponent = Integer.parseInt(bitExponent, 2);
        if (exponent >= Math.pow(2, EXPONENT_SIZE-1))
            exponent -= Math.pow(2, EXPONENT_SIZE);

        String bitMantissa = bitSequence.substring(EXPONENT_SIZE+1);
        float mantissa = 1;
        for (int i = 0; i < MANTISSA_SIZE; i++) {
            mantissa += Character.getNumericValue(bitMantissa.charAt(i)) * Math.pow(2, -(i+1));
        }

        return (float)(sign * Math.pow(2, exponent) * mantissa);
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int sequenceLength = bitSequences.length;
        int counter = 0;
        for (int i = 0; i < sequenceLength; i++) {
            float miniFloat = miniFloatFromString(bitSequences[i]);
            if (miniFloat == (int) miniFloat) {
                counter += 1;
                System.out.format("%s == %d\n", bitSequences[i], (int) miniFloat);
            }
        }
        System.out.format("Total number integral minFloat values: %d\n", counter);
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
