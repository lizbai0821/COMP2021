public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        // Consider for example a miniFloat value with the bit sequence 00100110.
        // The value is positive (0), the exponent is 4_10 (= 0100_2),
        // and the significand is 1.7510 (=1.110_2).
        // Therefore the whole value is 1.75 x 2^4 = 28.
        System.out.println(bitSequence);
        int exp = 0;
        double significand;
        String bS = "";

        if (bitSequence.charAt(0) == '0') {
            exp = Integer.parseInt(bitSequence.substring(1, 5), 2);
            System.out.println(exp);
        }
        else {
            bS = bitSequence.substring(1, 5).replace('1', '$');
            bS = bitSequence.substring(1, 5).replace('0', '1');
            bS = bitSequence.substring(1, 5).replace('1', '0');
            exp = -1 * (Integer.parseInt(bS, 2) + 1);
            System.out.println(exp);
        }

        significand = 1 + 0.5 * Integer.parseInt(bitSequence.substring(5, 6)) + 0.25 * Integer.parseInt(bitSequence.substring(6, 7)) + 0.125 * Integer.parseInt(bitSequence.substring(7, 8));
        System.out.println(significand);

        return (float)significand * (float)Math.pow(2, exp);
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        System.out.println(bitSequences[1]);
        System.out.println(miniFloatFromString("11111110"));

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
