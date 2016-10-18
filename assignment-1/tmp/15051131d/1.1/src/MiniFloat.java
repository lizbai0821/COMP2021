public class MiniFloat {

    public static void main(String[] args) {
        printIntegralMiniFloats();

    }

    private static float miniFloatFromString(String bitSequence) {
        // Task1: compute the miniFloat value from "bitSequence";
        float result = 0;
        int[] temp = new int[bitSequence.length()];
        int exponent;

        for (int i = 0; i < bitSequence.length(); i++) {
            if (bitSequence.charAt(i) == '0') {
                temp[i] = 0;
            } else if (bitSequence.charAt(i) == '1') {
                temp[i] = 1;
            }
        }

        if (temp[1] == 0) {
            exponent = (int) (Math.pow(2, 2) * temp[2] + Math.pow(2, 1) * temp[3] + Math.pow(2, 0) * temp[4]);
        } else {
            exponent = -(16 - ((int) (Math.pow(2, 3) * temp[1]
                    + (Math.pow(2, 2) * temp[2] + Math.pow(2, 1) * temp[3] + Math.pow(2, 0) * temp[4]))));
        }
        result = (float) ((Math.pow(2, -1) * temp[5] + Math.pow(2, -2) * temp[6] + Math.pow(2, -3) * temp[7] + 1.0)
                * Math.pow(2, exponent));
        if (temp[0] == 1) {
            result *= -1;
        }

        return result;

    }

    private static void printIntegralMiniFloats() {
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count = 0;
        for (int i = 0; i < bitSequences.length; i++) {
            if (miniFloatFromString(bitSequences[i]) == (int) (miniFloatFromString(bitSequences[i]))) {
                System.out.println(bitSequences[i] + "=" + (int) (miniFloatFromString(bitSequences[i])));
                count++;
            }
        }
        System.out.printf("Total number of integral miniFloat values: %d", count);

        // Task 2: print all the miniFloat values that are integer;

    }

    /**
     * Get all valid bit sequences for miniFloat values.
     */
    private static String[] getValidMiniFloatBitSequences() {
        int nbrValues = (int) Math.pow(2, MINI_FLOAT_SIZE);

        String[] result = new String[nbrValues];
        for (int i = 0; i < nbrValues; i++) {

            String full = String.format("%" + Integer.SIZE + "s", Integer.toBinaryString(i)).replace(' ', '0');
            result[i] = full.substring(Integer.SIZE - MINI_FLOAT_SIZE, Integer.SIZE);
        }
        return result;
    }

    private static int MINI_FLOAT_SIZE = 8;

}
