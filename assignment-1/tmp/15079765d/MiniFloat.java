public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int val = 1; //The positive or negative value (1st bit)
        if (bitSequence.charAt(0) == '1'){
            val = -1;
        }
        int val2 = 0; //The exponent's value (2nd bit to 5th bit)
        if(bitSequence.charAt(1)=='0'){		//positive exponent;
            for (int bit = 2; bit >= 0; bit--){
                if (bitSequence.charAt(4 - bit) == '1'){
                    val2 += Math.pow(2, bit);
                }
            }
        }
        else{				//negative exponent;
            char[] temp = new char[4]; //ones' complement
            for(int i = 0; i <= 3; i++){
                if( bitSequence.charAt(1 + i) == '1'){
                    temp[i] = '0';
                };
                if( bitSequence.charAt(1 + i) == '0'){
                    temp[i] = '1';
                };
            }
            for (int j = 3; j >= 0; j--){
                if( temp[j] == '1'){
                    val2 += Math.pow(2, j);
                }
            }
            val2 += 1;
            val2 *= -1;
        }

        float val3 = 0; // The significand's value (6nd bit to 8th bit)
        for (int bit2 = 2; bit2 >= 0; bit2--){
            if (bitSequence.charAt(7 - bit2) == '1'){
                val3 += Math.pow(2, bit2);
            }
        }
        val3 = (val3 / 8) +1;
        return (float) (val * (val3 * (Math.pow(2, val2))));
    }

    private static void printIntegralMiniFloats(){
        // Task 2: print all the miniFloat values that are integer;
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count = 0;
        for (int i = 0; i < bitSequences.length; i++) {
            float num = miniFloatFromString(bitSequences[i]);
            if (num - (int) num == 0){
                System.out.printf("%s == %d \n", bitSequences[i], (int)num);
                count++;
            }
        }
        System.out.printf("Total number of integral miniFloat values: %d", count);
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
