public class MiniFloat {

    public static void main(String[] args) {
        printIntegralMiniFloats();
    }

    private static float signFromString(char sign) {
        if (sign == '1') // negative value when sign = 1;;
            return -1;
        else
            return 1; //positive value when sign = 0;

    }

    private static float miniFloatFromString(String bitSequence) {
        // Task1: compute the miniFloat value from "bitSequence";
        float signValue, exponentSignValue, exponentValue, mantissaValue, miniFloatString;
        miniFloatString = 0;

        // Find the sign of float number
        signValue = signFromString(bitSequence.charAt(0));

        // Find the exponent  of float number
        exponentSignValue = signFromString(bitSequence.charAt(1));
        float temp = 0; // To find the exponent value
        temp = Integer.parseInt(bitSequence.substring(1, 5), 2);
        if (exponentSignValue == -1)
            exponentValue = -1 * (16-temp); //negative integer
        else
            exponentValue = temp;

        //Find the mantissaValue
        temp = 2;
        mantissaValue = 1;
        for (int i = 5; i <= 7; i++) {
            if (bitSequence.charAt(i) == '1')
                mantissaValue += 1 / temp;
            temp *= 2;
        }

        //get miniFloat
        miniFloatString = (float) (signValue * Math.pow(2, exponentValue) * mantissaValue);


        return miniFloatString;
    }

    private static void printIntegralMiniFloats() {
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int countMiniFloat = 0;
        float temp = 0;
        for (int i = 0; i < bitSequences.length; i++) {
            temp = miniFloatFromString(bitSequences[i]);
            if (temp % 1 == 0) {
                System.out.println(bitSequences[i] + "==" +(int)temp);
                countMiniFloat++;
            }
        }
        System.out.println("Total number  of integral miniFloat values: "+countMiniFloat);

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