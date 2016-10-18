// Chan Kwan Wai, 15079422D
public class MiniFloat {

    public static void main(String[] args) {printIntegralMiniFloats();}

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int exponent, sign;
        float mantissa;


        String str2 = bitSequence.substring(1,5);
        byte forexponent = Byte.parseByte(str2,2);
        exponent= Character.getNumericValue(bitSequence.charAt(1)) ==1? forexponent-(int)Math.pow(2,4) :forexponent;


        StringBuilder temp= new StringBuilder();
        temp.append("1").append(bitSequence.substring(5,8)).toString();
        String str1 = temp.toString();
        mantissa = Integer.parseInt(str1,2)/(float)Math.pow(2,3);


        sign = Integer.parseInt( Character.toString(bitSequence.charAt(0)));


        return (float)(Math.pow(2,exponent)*mantissa*(sign==1? -1:1));
    }


    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        // Task 2: print all the miniFloat values that are integer;
        for (int i = 0; i < bitSequences.length; i++){
            System.out.printf("%s == %f\n",bitSequences[i], miniFloatFromString(bitSequences[i]));
        }
        System.out.println("Total number of integral miniFloat values: "+bitSequences.length);
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
