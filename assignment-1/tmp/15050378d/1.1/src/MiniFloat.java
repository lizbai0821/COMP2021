public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int sign = 1, exponent = 0;
        float significand = 1;
        float miniFloat;

        if (bitSequence.charAt(0) == '1'){
            sign = -1;}

        for (int i = 1; i <= 4; i++){
            if (bitSequence.charAt(i) == '1'){
                exponent = exponent + (int) Math.pow(2, (4-i));}
        }

        for (int j = 5; j<=7; j++){
            if (bitSequence.charAt(j) == '1') {
                significand = significand + (float) Math.pow(2, (4-j));}
        }

        miniFloat = sign*significand*(int) Math.pow(2, exponent);
        return miniFloat;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int totalnum = 0;

        // Task 2: print all the miniFloat values that are integer;
        for (int j = 0; j < bitSequences.length; j++) {
            float k = miniFloatFromString(bitSequences[j]);
            if (k == (int) k){
                totalnum++ ;
                System.out.printf("%s == %d\n", bitSequences[j], (int)k);}
        }
        System.out.println("Total number of integral miniFloat values: " + totalnum);
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
