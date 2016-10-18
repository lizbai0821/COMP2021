public class MiniFloat {

    public static void main(String[] args){
        miniFloatFromString("00100110");
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat minifloat from "bitSequence";
        String mantissa = bitSequence.substring(5,8);
        char F_sign = bitSequence.charAt(0);
        String S_com = bitSequence.substring(1,5);
        int I_com = Integer.parseInt(S_com,2);
        float F_man = (float) (Integer.parseInt(mantissa,2)*Math.pow(2,-3)+1);
        float minifloat = (float) (F_man*Math.pow(2,I_com));
        if (F_sign == '1'){
            minifloat = minifloat*(-1);
        }
        System.out.println(minifloat);
        return 0;
    }


    private static void printIntegralMiniFloats() {
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;

        for (int i = 0; i < bitSequences.length; i++) {
            String S_man = bitSequences[i].substring(5, 8);
            float F_man;
            int I_com;
            float minifloatnum;
            F_man = (float) (Integer.parseInt(S_man, 2) * Math.pow(2, -3) + 1);
            String S_com = bitSequences[i].substring(1, 5);
            I_com = Integer.parseInt(S_com, 2);
            minifloatnum = (float) (F_man * Math.pow(2, I_com));
            if (minifloatnum - (int)minifloatnum == 0) {
                char sign = bitSequences[i].charAt(0);
                if (sign == '1') {
                    minifloatnum = minifloatnum * (-1);
            }
                System.out.println(bitSequences[i] + " == " + (int)minifloatnum);

            }
        }
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
