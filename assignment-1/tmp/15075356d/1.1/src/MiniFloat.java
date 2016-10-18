public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float result ;
        int sign,exponent_sign,temp;
        float mantissa = 0,exponent = 0;
        if (bitSequence.charAt(0) == '0'){

            sign = 1;
        }
        else {

            sign = -1;
        }
        if (bitSequence.charAt(1) == '0'){

            exponent_sign = 1;
        }
        else {

            exponent_sign = -1;
        }
        for (int i = 1; i <= 4;i++){
            temp = (int) Character.getNumericValue(bitSequence.charAt(i)) ;
            temp *= Math.pow(2,7-i-3);
            exponent += temp;
        }
        for (int i = 5; i<= 7; i++){
            float temp2 = Character.getNumericValue(bitSequence.charAt(i)) ;
            temp2 *= Math.pow(2,4-i);
            mantissa += temp2;
        }
        if (bitSequence.charAt(1) == '1'){
            float temp2 = (float)Math.pow(2,4);
            exponent = temp2 - exponent;
            exponent *= -1;
        }

        exponent =(float) Math.pow(2,exponent);
        result = (mantissa+1) * sign* exponent ;

        return result;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count = 0;
        for (int i =0; i <= 255; i++){
            float temp = miniFloatFromString(bitSequences[i]);
            if (temp%1 == 0) {
                count+= 1;
                System.out.println(bitSequences[i] + "==" + temp);
            }
        }
        System.out.println("Total number of integral miniFloat values: " + count);
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
