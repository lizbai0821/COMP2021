public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int exponent = 0;
        double value = 1;
        double mantissa = 1.000;
        if ((bitSequence.substring(0,1).equals("1"))){
            value=-1;
        }
        exponent = Integer.parseInt(bitSequence.substring(1,5),2);
        mantissa = Integer.parseInt(bitSequence.substring(5,6))*Math.pow(2,-1)+Integer.parseInt(bitSequence.substring(6,7))*Math.pow(2,-2)+Integer.parseInt(bitSequence.substring(7,8))*Math.pow(2,-3)+1;
        value = value* mantissa* Math.pow(2,exponent);
        return (float)value;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        // Task 2: print all the miniFloat values that are integer;
        int counter =0;
        for (int i=0; i<bitSequences.length;i++){
            String element = bitSequences[i];
            if (miniFloatFromString(element)%1==0){
                counter+=1;
                System.out.printf("%s == %d \n",element, (int)(miniFloatFromString(element)));
            }
        }
        System.out.printf("Total number of integral miniFloat values: %d",counter);
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
