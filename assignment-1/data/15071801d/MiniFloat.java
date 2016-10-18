public class MiniFloat {

    public static void main(String[] args) {
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence) {
        // Task1: compute the miniFloat value from "bitSequence";
        float num = 0;
        int exp = 0;
        float exp1 = 1;

        for (int i = 1; i <= 4; i++) {
            char ch = bitSequence.charAt(i);
            if (ch == '1') {
                exp += (int) Math.pow(2, 4-i);
            }
        }

        for (int k = 5; k <= 7; k++) {
            char ch1 = bitSequence.charAt(k);
            if (ch1 == '1') {
                exp1 += (float) Math.pow(2, 4 - k);
            }
        }

        num = (float)Math.pow(2,exp)*exp1;

        if (bitSequence.startsWith("1")) {
            num = -num;
        }

        return num;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count = 0;
        for(int j=0;j < bitSequences.length; j++){
            if(miniFloatFromString(bitSequences[j]) == (int)miniFloatFromString(bitSequences[j])){
                count++;
                System.out.println(bitSequences[j]+" == "+(int)miniFloatFromString(bitSequences[j]));
            }
        }
        System.out.println("Total number of integral miniFloat values: "+ count);
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
