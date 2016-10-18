public class MiniFloat {

    public static void main(String[] args){printIntegralMiniFloats();}

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int sign = 1;
        int exponent = 0;
        float mantissa = 1;

        if (bitSequence.charAt(0) == 49) {
            sign = -1;
        }

        for (int i = 1; i <= 4;i++ ){
            if (bitSequence.charAt(i) == 49){
                exponent += (int)Math.pow(2, (4-i));
            }
        }

        for (int j = 5; j <=7; j++){
            if (bitSequence.charAt(j) == 49){
                mantissa += (float)Math.pow(2, (-(j-4)));
            }
        }

        return sign*mantissa*(int)Math.pow(2, exponent);
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int count = 0;
        for (int j=0; j<256; j++){
            if (miniFloatFromString(bitSequences[j]) == (int)miniFloatFromString(bitSequences[j])){
                count += 1;
                System.out.printf("%s" + " == " + "%d", bitSequences[j], (int)miniFloatFromString(bitSequences[j]));
                System.out.println();
            }
        }
        System.out.print("Total number of integral miniFloat values: ");
        System.out.printf("%d", count);
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
