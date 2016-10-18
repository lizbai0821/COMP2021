public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();

    }

    public static float miniFloatFromString(String bitSequence){
        String str2 = bitSequence.substring(1,5);
        int intstr = Integer.parseInt(str2, 2);
        String str3 = bitSequence.substring(5,8);
        float mantissa = 1;
        if (Integer.parseInt(str3.substring(0,1)) == 1){
            mantissa += 0.5;
        }
        if (Integer.parseInt(str3.substring(1,2)) == 1){
            mantissa += 0.25;
        }
        if (Integer.parseInt(str3.substring(2,3)) == 1){
            mantissa += 0.125;
        }
        float miniStr=0;

        miniStr = intstr * mantissa;

        if (Integer.parseInt(bitSequence.substring(0,1)) == 1) {
            miniStr = -(miniStr);
        }

        return miniStr;
    }

    private static void printIntegralMiniFloats(){
       String[] bitSequences = getValidMiniFloatBitSequences();
       int intSequence = 0;
        int count = 0;


        for (int i = 0; i< 256; i++) {
            intSequence = Integer.parseInt(bitSequences[i]);
            float ans = miniFloatFromString(bitSequences[i]);
            if ((int)ans == ans){
                System.out.println(bitSequences[i] + " == " + (int)(ans));
                count++;
            }
        }
        System.out.println("\nTotal number of integral miniFloat values: <" + count + ">");



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
