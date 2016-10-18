public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        //Calculate the mantissa
        float decimal = 1.0f;
        decimal += (bitSequence.charAt(5) == '1' ? 1 : 0) * 0.5;
        decimal += (bitSequence.charAt(6) == '1' ? 1 : 0) * 0.25;
        decimal += (bitSequence.charAt(7) == '1' ? 1 : 0) * 0.125;

        //Calculate the exponent in two's complement
        int exp = Integer.parseInt(bitSequence.substring(1,5), 2);
        if(bitSequence.charAt(1) == '1')    //the exponent is negative
            exp -= 16;                      //16 = 2 to the power of 4
        decimal *= Math.pow(2.0, (double)exp);

        if(bitSequence.charAt(0) == '1')    //the whole decimal number is negative
            decimal = -decimal;

        return decimal;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count = 0;
        float decimal;
        int integer;

        for(int i = 0; i < bitSequences.length; i++){
            String bitSequence = bitSequences[i];
            decimal = miniFloatFromString(bitSequence);
            integer = (int)decimal;

            if(integer == decimal){
                count++;
                System.out.println(bitSequence + " == " + integer);
            }
        }
        System.out.println("Total number of integral miniFloat values: " + count);
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
