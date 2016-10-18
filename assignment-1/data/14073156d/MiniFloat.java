public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        // As it is not required by the assignment document, there is no validation for simplicity
        // We assume that the user entered a string of eight 1s and 0s with no errors
        int exponent = Integer.parseInt(bitSequence.substring(1,5),2);

        //Getting significand
        char[] charArray = bitSequence.toCharArray();
        double significand = 1.0;
        for (int i = 1; i<=3; i++)
        {
            if (charArray[i+4] == '1')
            {
                significand += Math.pow(2,i *-1);
            }
        }
        return (float)(significand * Math.pow(2, exponent) * (charArray[0]=='1'? -1:1));
    }

    private static void printIntegralMiniFloats(){
        // Task 2: print all the miniFloat values that are integer;
        String[] bitSequences = getValidMiniFloatBitSequences();
        int cnt = 0;
        for (String processSequence:bitSequences)
        {
            float temp = miniFloatFromString(processSequence);
            if ((int)temp - temp == 0)
            {
                System.out.printf("%s == %d\n", processSequence, (int)temp);
                cnt++;
            }
        }
        System.out.printf("Total number of integral miniFloat values: %d\n",cnt);

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
