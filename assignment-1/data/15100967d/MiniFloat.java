public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float firstFour = 0;
        float lastThree = 1;
        float result = 0;
        float fourResult = 0;
        int findA = bitSequence.charAt(0);
        int res = Integer.parseInt(String.valueOf(findA));
        float[] newArray = new float[8];
        newArray[0] = -1;
        for(int j = 1; j<8; j++)
            newArray[j] = (float) Math.pow(2, 4 - j);
        newArray[1] *= newArray[0];
        for(int i = 1; i < 5; i++)
        {
            firstFour = firstFour +  (bitSequence.charAt(i)-48) * newArray[i];
            fourResult = (float)Math.pow(2, firstFour);
        }
        for(int k = 5; k < 8; k++)
        {
            lastThree = lastThree + (bitSequence.charAt(k)-48) * newArray[k];
        }
        if(res == 1)
        {
            return result = lastThree * (float)Math.pow(2,firstFour) * -1;
        }
        else
        {
            return result = lastThree * (float)Math.pow(2,firstFour);
        }





    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int Counter = 0;
        for(int i = 0; i < bitSequences.length; i++) {
            float value = miniFloatFromString(bitSequences[i]);
            if ((int) value - value == 0) {
                System.out.printf("%s == %d\n", bitSequences[i], (int) value);
                Counter++;

            }
        }
        System.out.printf("Total number of integral miniFloat values: %d", Counter);

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
