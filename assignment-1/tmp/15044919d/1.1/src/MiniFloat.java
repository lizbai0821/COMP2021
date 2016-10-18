public class MiniFloat {


    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int exponent = 0;
        float mantissa = 0;
        float value;

        for (int i=1; i<=4; i++){
            if (bitSequence.charAt(i) == '1'){
                exponent += (int)Math.pow(2, 4-i);
            }
        }

        for (int j=5; j<=7; j++){
            if (bitSequence.charAt(j) == '1'){
                mantissa += (float)Math.pow(2, -(j-4));
            }
        }

        value = (mantissa+1)*(float)Math.pow(2, exponent);

        if (bitSequence.charAt(0) == '1'){
            value = -value;
        }
        return value;
    }

    private static void printIntegralMiniFloats(){
        // Task 2: print all the miniFloat values that are integer;
        String[] bitSequences = getValidMiniFloatBitSequences();

        int totalNumber = 0;

        for (int x=0; x<bitSequences.length; x++){
            float y = miniFloatFromString(bitSequences[x]);
            if (y == (int)y){
                totalNumber++;
                System.out.println(bitSequences[x] + " == " + (int)y);
            }
        }
        System.out.println("\nTotal number of integral miniFloat values: " + totalNumber);
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