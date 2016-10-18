public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int sign;  //1 for positive, 0 for negative.
        int number = Integer.parseInt(bitSequence);
        char [] Sequence = bitSequence.toCharArray();
        if (number >= 10000000) {
            sign = -1;
            number -= 10000000;
        }
        else
            sign = 1;
        int exponent2 = number / 1000;
        int exponent10 = 0;
        if (Sequence[1] == '1'){
            exponent10 = -1 * (8 - Character.getNumericValue(Sequence[2]) * 4 - Character.getNumericValue(Sequence[3]) * 2
                    - Character.getNumericValue(Sequence[4]));
        }
        else{
            exponent10 = Character.getNumericValue(Sequence[2]) * 4 + Character.getNumericValue(Sequence[3]) * 2
                    + Character.getNumericValue(Sequence[4]);
        }
        double significand;
        significand = 1 + Character.getNumericValue(Sequence[5]) * 0.5 +Character.getNumericValue(Sequence[6]) * 0.25
                + Character.getNumericValue(Sequence[7]) * 0.125;
        return (float) (sign * significand * Math.pow(2, exponent10));
     }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int counter = 0;
        // Task 2: print all the miniFloat values that are integer;
        for(String x: bitSequences){
            float a = miniFloatFromString(x) - (int)miniFloatFromString(x);
            if(a == 0){
                System.out.println(x + " == " + (int)miniFloatFromString(x));
                counter++;
            }
        }
        System.out.println("Total number of integral minifloat values: " + counter);
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
