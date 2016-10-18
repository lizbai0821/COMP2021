public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float exponextBit = 0;
        float mantissaBit=0;
        float signBit = Character.getNumericValue(bitSequence.charAt(0));
        for(int i = 1;i<5;i++)
            exponextBit += Character.getNumericValue(bitSequence.charAt(i)) * Math.pow(2,5-i-1);
        if(Character.getNumericValue(bitSequence.charAt(1))==1)
            exponextBit = -1*((int)Math.pow(2,4)-exponextBit);
        for(int i = 5;i<8;i++)
            mantissaBit += Character.getNumericValue(bitSequence.charAt(i)) * Math.pow(2,-i+4);
        float result = (1+mantissaBit)* (float)Math.pow(2,exponextBit);
        result = (signBit==0)?(result*1):(result*-1);
        return result;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int totalNumberOfInteger = 0;
        // Task 2: print all the miniFloat values that are integer;
        for(int i = 0;i<bitSequences.length;i++)
        {
            float result = miniFloatFromString(bitSequences[i]);
            String temp = String.valueOf((int)result);
            if(result == (int)(result)) {
                System.out.println(bitSequences[i] + " == " + temp);
                totalNumberOfInteger++;
            }
        }
        System.out.printf("Total number of integral miniFloat values: %d\n",totalNumberOfInteger);
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
