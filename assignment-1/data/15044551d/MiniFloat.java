public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        boolean pos = (bitSequence.charAt(0) == '0');
        int exp = 0;
        for (int i = 1; i < 5; i++) {
            if (pos)
            {
                if (bitSequence.charAt(i) == '1')
                    exp += Math.pow(2, (4 - i));
            }else if (bitSequence.charAt(i) == '0')
                exp += Math.pow(2, (4 - i));
        }
        float man = 1;
        for (int j = 5; j < 8; j++)
        {
            if (bitSequence.charAt(j) == '1')
                man += Math.pow(0.5, j-4);
        }
        if (pos)
            return (float) Math.pow(2, exp) * man;
        else return (float) Math.pow(2, exp) * man * (-1) + 1;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
            int count = 0;
        for (String value: bitSequences) {
            float result = miniFloatFromString(value);
            if (result % 1 == 0){
                System.out.println(value+" = "+(int)result);
                count++;
            }

        }
        System.out.println("Total number of integral miniFloat values: "+count);
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
