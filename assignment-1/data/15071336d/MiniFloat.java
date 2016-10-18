public class MiniFloat {

    public static void main(String[] args) {
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence) {
        // Task1: compute the miniFloat value from "bitSequence";

        int sign = 0;
        int exponent = 0;//the index of base2
        int exponent_value = 1;
        float mantissa = 0;
        float miniFloat = 1;//whole value
        if (Character.getNumericValue(bitSequence.charAt(0)) == 0)//sign
            sign = 1;
        else sign = -1;

        for (int i = 2; i <= 4; i++) {         //exponent;
            exponent = exponent + Character.getNumericValue(bitSequence.charAt(i));
            if (i < 4)
                exponent = exponent * 2;
        }


        for (int i = 0; i < exponent; i++) {
            exponent_value = exponent_value * 2;
        }
        for (int i = 7; i >= 5; i--) {         //exponent;
            mantissa = mantissa + Character.getNumericValue(bitSequence.charAt(i));
            mantissa = mantissa / 2;

        }
        mantissa = mantissa + 1;
        miniFloat = sign * exponent_value * mantissa;

        return miniFloat;

    }


    private static void printIntegralMiniFloats() {
        String[] bitSequences = getValidMiniFloatBitSequences();
        // Task 2: print all the miniFloat values that are integer;
        float c = 0;//accept the result
        int pc = 0;// the result in integer type to print out
        int count = 0;//count the number of the integer number
        for (int i = 0; i < bitSequences.length; i++) {
            c = miniFloatFromString(bitSequences[i]);
            if (Character.getNumericValue(bitSequences[i].charAt(1)) == 0) {
                if (c == (int) c) {
                    pc = (int) c;
                    System.out.println(bitSequences[i] + " == " + pc);

                    count = count + 1;
                }
            }
        }
        System.out.println("Total number of integral miniFloat values:" + count);
    }


    /**
     * Get all valid bit sequences for miniFloat values.
     */
    private static String[] getValidMiniFloatBitSequences() {
        int nbrValues = (int) Math.pow(2, MINI_FLOAT_SIZE);

        String[] result = new String[nbrValues];
        for (int i = 0; i < nbrValues; i++) {

            String full = String.format("%" + Integer.SIZE + "s", Integer.toBinaryString(i))
                    .replace(' ', '0');
            result[i] = full.substring(Integer.SIZE - MINI_FLOAT_SIZE, Integer.SIZE);
        }
        return result;
    }

    private static int MINI_FLOAT_SIZE = 8;

}
