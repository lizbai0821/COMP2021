public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
        //miniFloatFromString("01111111");
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int len = bitSequence.length();
        int[] tempIntArray = new int[len];
        float result;
        int sign;
        int exponent;
        float mantissa = 1;

        //put original string into CharArray
        for(int i = 0; i < len ; i++){
            tempIntArray[i] = Character.getNumericValue(bitSequence.charAt(i));
        }

        //sign
        sign = tempIntArray[0];

        //mantissa
        int temp = -1;
        for(int k = 0; k < 3; k++) {
            mantissa += tempIntArray[k + 5] * (float) Math.pow(2, temp);
            temp -= 1;
        }
      //System.out.println(mantissa);

        //2's component
        exponent = Integer.parseInt(bitSequence.substring(1,5),2);
        if(tempIntArray[1] == 1)
                exponent -= 16;

      //System.out.println(exponent);

        result = mantissa * (float) Math.pow(2,exponent);

        if(sign == 1)
            result *= -1;


     // System.out.print(result);

        return result;

    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int len = bitSequences.length;
        float temp = 0;
        int count = 0;
        for(int i = 0; i < len; i++){
            temp = miniFloatFromString(bitSequences[i]);
            if(temp == (int) temp){
                System.out.println( bitSequences[i] +" == " + temp);
                count++;
            }
        }
        System.out.print("Total number of integral miniFloat values: "+count);

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
