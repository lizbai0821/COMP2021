public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static double miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        double result, mantissa = 0;
        int exponent = 0;
        boolean numPositive = true, expPositive = true;
        if (Character.getNumericValue(bitSequence.charAt(0))==1) numPositive = false;
        if (Character.getNumericValue(bitSequence.charAt(1))==1) expPositive = false;
        for (int i = 2;i<=4;i++)
        {
            exponent += (Character.getNumericValue(bitSequence.charAt(i))*((float)Math.pow(2,(i-1))));
        }
        exponent -= (expPositive?0:8);
        for (int i = 7;i>=5;i--)
        {
            mantissa = (mantissa+Character.getNumericValue(bitSequence.charAt(i)))/2;
        }
        result = (numPositive?1:-1)* (double)Math.pow(2, exponent) * (mantissa+1);
        return result;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        double output;
        int sum = 0;
        // Task 2: print all the miniFloat values that are integer;
        for (int i =0; i<256; i++) {
            output = miniFloatFromString(bitSequences[i]);
            if (output-(int)output == 0.0) {
                System.out.printf("%s == %d \n", bitSequences[i], (int) output);
                sum += (int) output;
            }
        }
        System.out.printf("Total number of integral miniFloat values: %d", sum);

    }

    /**
     * Get all valid bit sequences for miniFloat values.
     */
    private static String[] getValidMiniFloatBitSequences(){
        int nbrValues = (int)Math.pow(2, MINI_FLOAT_SIZE);

        String []result = new String[nbrValues];
        for(int i = 0; i < nbrValues; i++){

            String full = String.format("%" + Integer.SIZE + "s", Integer.toBinaryString(i))
                    .replace(' ', '0');
            result[i] = full.substring(Integer.SIZE - MINI_FLOAT_SIZE, Integer.SIZE);
        }
        return result;
    }

    private static int MINI_FLOAT_SIZE = 8;

}
