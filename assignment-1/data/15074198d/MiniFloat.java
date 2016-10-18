
public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";

        float miniFloat;
        char[] binaryBits = bitSequence.toCharArray();

        /* Compute the sign value */
        int sign = binaryBits[0] == '0' ? 1 : -1;

        /* Compute the exponent value */
        int power = 0;
        float exponent = 1.0f;

        for (int i = 1; i <= MINI_FLOAT_SIZE / 2; i++) {
            if (i == 1 && binaryBits[i] != '0')
                power = (power * 2 + (binaryBits[i] - '0'))* -1;
            else
                power = power * 2 + (binaryBits[i] - '0');
        }

        if (power >= 0) {
            for (int j = 1; j <= power; j++)
                exponent *= 2;
        } else {
            for (int j = -1; j >= power; j--) {
                exponent /= 2;
            }
        }

        /* Compute the value of mantissa */
        float mantissa = 0f;

        for (int k = 5; k < MINI_FLOAT_SIZE; k++) {
            mantissa = mantissa * 2 + (binaryBits[k] - '0');
        }
        mantissa /= MINI_FLOAT_SIZE;

        /* Calculate the whole float value "miniFloat" */
        miniFloat = (float)sign * exponent * (1 + mantissa);

        return miniFloat;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;

        int intCount = 0;
        for (int a = 0; a < bitSequences.length; a++) {
            float floatValue = miniFloatFromString(bitSequences[a]);
            if (floatValue - (int)floatValue == 0) {
                System.out.printf("%s == %d\n", bitSequences[a], (int)floatValue);
                intCount++;
            } else
                continue;
        }

        System.out.printf("Total number of integral miniFloat values: %d", intCount);

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
