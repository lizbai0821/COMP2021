public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int exponent = 0;
        if(bitSequence.charAt(1) == '0') {
            exponent =bitSequence.charAt(4)-48+(bitSequence.charAt(3)-48) * 2 +(bitSequence.charAt(2)-48)*4;}
        else{

            exponent = -((1-(bitSequence.charAt(4)-48)) + (1-(bitSequence.charAt(3)-48)) * 2 + (1-(bitSequence.charAt(2)-48)) * 4+1);
        }
        float mantissa = (float) ((bitSequence.charAt(5)-48)/2.0 +(bitSequence.charAt(6)-48)/4.0+ (bitSequence.charAt(7)-48)/8.0 + 1);
        float value = mantissa*(float)Math.pow(2,exponent);
        if( Integer.parseInt(String.valueOf(bitSequence.charAt(0))) == 0) return value;
        else return (-value);
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        // Task 2: print all the miniFloat values that are integer;
        int i;
        int counter = 0;
        for(i = 0;i<bitSequences.length;i++){
            String  bitSequence= bitSequences[i];
            float value1 = miniFloatFromString(bitSequence);
            int value2 = (int)value1;
            if(value1 == value2) {
                counter += 1;
                System.out.println(bitSequence+" == "+value2);
            }
            else continue;
        }
        System.out.printf("Total number of integral miniFloat values: %d",counter);
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
