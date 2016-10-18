public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int signNum = bitSequence.charAt(0) - 48;
        int expoNum0 = bitSequence.charAt(1) - 48;
        int expoNum1 = bitSequence.charAt(2) - 48;
        int expoNum2 = bitSequence.charAt(3) - 48;
        int expoNum3 = bitSequence.charAt(4) - 48;
        int manNum0 = bitSequence.charAt(5) - 48;
        int manNum1 = bitSequence.charAt(6) - 48;
        int manNum2 = bitSequence.charAt(7) - 48;

        int expoNum = 0;
        if (expoNum0 == 0) {
            expoNum = expoNum1 * 4 + expoNum2 * 2 + expoNum3;
        }
        else {
            expoNum = expoNum1 * 4 + expoNum2 * 2 + expoNum3 - 8;
        }
        float manNum = (float)(1 * 8 + manNum0 * 4 + manNum1 * 2 + manNum2) / 8;

        float miniFloat = (float)Math.pow(2, expoNum) * manNum;
        if (signNum == 1) {
            miniFloat = - miniFloat;
        }
        return miniFloat;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int inteNum = 0, totalNum = bitSequences.length, tempInte;
        float tempMiniFloat = 0;

        for (int i = 0; i < totalNum;i++) {
            tempMiniFloat = miniFloatFromString(bitSequences[i]);
            if (tempMiniFloat == (int)tempMiniFloat) {
                tempInte = (int) tempMiniFloat;
                System.out.println(bitSequences[i] + " == " + tempInte);
                inteNum++;
            }
        }

        System.out.println("Total number of integral minifloat values: "+ inteNum);
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
