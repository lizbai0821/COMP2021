public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";

        String cde = "";
        int a, b, exponent;
        float mantissa;
        boolean isPositive = true, exponentIsPositive = true;

        a = Character.getNumericValue(bitSequence.charAt(0));
        if (a == 1)
            isPositive = false;
        b = Character.getNumericValue(bitSequence.charAt(1));
        if (b == 1)
            exponentIsPositive = false;

        cde += bitSequence.charAt(2);
        cde += bitSequence.charAt(3);
        cde += bitSequence.charAt(4);

        if (exponentIsPositive) {
            exponent = Integer.parseInt(cde, 2);
        }
        else {
            if (cde.charAt(2) == '1')
                cde = "1" + cde.charAt(0) + cde.charAt(1) + "0";
            else if (cde.charAt(1) == '1')
                cde = "1" + cde.charAt(0) + "0" + "1";
            else if (cde.charAt(0) == '1')
                cde = "1011";
            else
                cde = "0111";
            StringBuilder CDE = new StringBuilder(cde);
            for (int i = 0; i < 4; i++) {
                if (cde.charAt(i) == '1')
                    CDE.setCharAt(i, '0');
                else
                    CDE.setCharAt(i, '1');
            }
            exponent = (-1) * Integer.parseInt(CDE.toString(), 2);
        }

        mantissa = (float) (1 + 0.5 * (bitSequence.charAt(5) - '0') + 0.25 * (bitSequence.charAt(6) - '0') + 0.125 * (bitSequence.charAt(7) - '0'));

        if (isPositive)
            return (float) (mantissa * Math.pow(2, exponent));
        else
            return (float) ((-1) * mantissa * Math.pow(2, exponent));

    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        float var;
        int count = 0;

        for (int i = 0; i < bitSequences.length; i++) {
            var = miniFloatFromString(bitSequences[i]);
            if ((int) var == var) {
                System.out.print(bitSequences[i] + " == " + (int) var + '\n');
                count++;
            }
        }

        System.out.print("Total number of integral miniFloat values: " + count);

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
