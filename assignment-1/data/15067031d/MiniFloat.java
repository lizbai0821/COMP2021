public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float ans = 0;
        int m = 2, exp = 0;

        for (int i = 5; i <= 7; i++){
            if (bitSequence.charAt(i) == '1')
                ans += 1/(float)m;
            m <<= 1;
        }

        m = 1;
        for (int i = 4; i >= 2; i--){
            if (bitSequence.charAt(i) == '1')
                exp += m;
            m <<= 1;
        }
        if (bitSequence.charAt(1) == '1')
            exp = exp-16;

        ans = (float) ((ans+1) * Math.pow(2, exp) *((bitSequence.charAt(1) == '1') ? -1:1));

        return ans;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;

        float ans;
        int cnt = 0;

        for (int i = 0; i < bitSequences.length; i++){
            ans = miniFloatFromString(bitSequences[i]);
            if (ans - (int)ans == 0.0){
                System.out.printf("%s == %d\n", bitSequences[i], (int)ans);
                cnt++;
            }
        }

        System.out.println("Total number of integral miniFloat values: " + cnt);
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
