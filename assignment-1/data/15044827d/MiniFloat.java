/**
 * Created by Jacky Chiu on 22/9/2016.
 */

public class MiniFloat {

    public static void main(String[] args) {
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String[] bitSequence) {
        // Task1: compute the miniFloat value from "bitSequence";
        int[] array = new int[8];
        int exponent = 0;
        float value = 1;
        int c = 5;
        int c2 = 1;

        for (int h = 0; h < bitSequence.length; h++) {
            array[h] = Integer.parseInt(bitSequence[h]);
        }
        if (array[0] == 1) {
            value *= -1;
        }
        for (int g = 3; g >= 0; g--) {
            if (array[c2] == 1) {
                exponent += Math.pow(2, g);
            }
            c2++;
        }
        for (int k = -1; k >= -3; k--) {
            if (array[c] == 1) {
                value += Math.pow(2, k);
            }
            c++;
        }
        return value * ((int) Math.pow(2, exponent));

    }

    private static void printIntegralMiniFloats() {
        String[] bitSequences = getValidMiniFloatBitSequences();
        float temp2;

        // Task 2: print all the miniFloat values that are integer;

        for (int i = 0; i < bitSequences.length; i++) {
            String[] temp1 = bitSequences[i].split("");
            temp2 = miniFloatFromString(temp1);
            if (temp2 == Math.round(temp2)) {
                System.out.print("Bit Sequence=" + bitSequences[i] + " ");
                System.out.print("Value=" + temp2);
                System.out.println('\n');
            }
        }
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
