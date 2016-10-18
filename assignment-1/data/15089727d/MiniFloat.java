public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        String sign = bitSequence.substring(0,1);
        String exponent = bitSequence.substring(1,5);
        String mantissa = bitSequence.substring(5,8);
        float result = 1;
        int index = 0;

        if (Integer.parseInt(exponent.substring(0,1)) == 0) {
            index = Integer.parseInt(exponent, 2);
        }
        else {
            String temp = exponent.substring(1,4);
            index = Integer.parseInt(temp, 2);
            index = index - 8;
        }


        for (int i = 0; i < 3; i++) {
            int x = Integer.parseInt(mantissa.substring(i,i+1));
            result += x * Math.pow(2, -1*(i+1));
        }

        result = result * (float)Math.pow(2, index);

        if (Integer.parseInt(sign) == 1)
            return result * -1;
        else
            return result;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;

        int count = 0;

        for (int i = 0; i <= 255; i++){
            if (miniFloatFromString(bitSequences[i]) == (int)miniFloatFromString(bitSequences[i]))  {
                System.out.println(bitSequences[i] + " == " + (int)miniFloatFromString(bitSequences[i]));
                count++;
            }
        }

        System.out.println("Total number of integral miniFloat values: " + count);
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
