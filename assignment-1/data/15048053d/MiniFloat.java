public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        //sign bit
        int sign = 1;
        if(bitSequence.charAt(0)=='1') {
            sign = -1;
        }

        //exponent
        String expo = bitSequence.substring(1,5);
        int len1 = expo.length();
        int exponent = 0;
        for(int i = 0; i < len1; i++){
            int index1 = len1 - i - 1;
            int result = Integer.parseInt ("" + expo.charAt(i)) * (int)Math.pow(2,index1);
            exponent = exponent + result;
        }

        //mantissa
        String mant = bitSequence.substring(5);
        int len2 = mant.length();
        float mantissa = 0;
        for(int j = 0; j < len2; j++){
            int index2 = len2 - 4 - j;
            float output = Float.parseFloat ("" + mant.charAt(j)) * (float)Math.pow(2,index2);
            mantissa = mantissa + output;
        }

        float finalResult = sign*((float)Math.pow(2,exponent))*(1+mantissa);
        return finalResult;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count = 0;
        // Task 2: print all the miniFloat values that are integer;
        for(int k = 0; k< bitSequences.length; k++){
            if((miniFloatFromString(bitSequences[k])) == (int)(miniFloatFromString(bitSequences[k]))) {
                count = count + 1;
                System.out.printf("%s == %d\n", bitSequences[k], (int)miniFloatFromString(bitSequences[k]));
            }
        }
        System.out.printf("Total number of integral miniFloat values: %d", count);
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
