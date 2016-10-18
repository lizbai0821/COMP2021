public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float miniFloat;
        int sign=0;
        int[] exponent = new int[4];
        int[] mantissa = new int[3];
        int n = bitSequence.length();

        //To store the binary bit in different tuple
        for (int i = 0; i < n; i++) {
            if (i == 0){
                sign = Integer.parseInt(String.valueOf(bitSequence.charAt(i)));
            }
            else if (i > 0 && i < 5) {
                exponent[i - 1] = Integer.parseInt(String.valueOf(bitSequence.charAt(i)));
            }
            else{
                mantissa[i - 5] = Integer.parseInt(String.valueOf(bitSequence.charAt(i)));
            }
        }


        //switch the 2's complement binary exponent
        int primitive = exponent[0];
        if(exponent[0] == 1){
            int b = exponent.length;
            if (exponent[b - 1] == 1) {
                exponent[b - 1] = 0;
                for (int i = 0; i < b; i++) {
                    exponent[i] = (exponent[i] == 0) ? 1 : 0;
                }
            }
            else {
                int k = b;
                while (exponent[k - 1] == 0) {
                    exponent[k - 1] = 1;
                    k--;
                }
                exponent[k - 1] = 0;
                for (int i = 0; i < b; i++) {
                    exponent[i] = (exponent[i] == 0) ? 1 : 0;
                }
            }
        }

        //calculate the integer of the binary exponent part
        int exinteger = 0;
        for (int j = 0; j < exponent.length; j++) {
            exinteger = exponent[j] * (int)Math.pow(2,3-j) + exinteger;
        }
        exinteger = (primitive == 0) ? exinteger : -exinteger;



        //calculate the integer of the binary mantissa part
        float mainteger = 0;
        for (int m = 0; m < mantissa.length; m++) {
            mainteger = mantissa[m] * (float)Math.pow(2,-1-m) + mainteger;
        }
        mainteger = mainteger +1;

        miniFloat = (sign == 0) ? mainteger*(float)Math.pow(2,exinteger) : -mainteger*(float)Math.pow(2,exinteger);
        return miniFloat;

    }


    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int counter = 0;
        for(int i = 0; i < 256; i++){
            if(miniFloatFromString(bitSequences[i])%1 == 0){
                System.out.println(bitSequences[i]+"=="+miniFloatFromString(bitSequences[i]));
                counter++;
            }
        }
        System.out.println("Total number of integral miniFloat values:"+counter);

        // Task 2: print all the miniFloat values that are integer;

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
