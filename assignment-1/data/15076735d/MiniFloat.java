public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        double result;
        double exp = Math.pow(2,Integer.parseInt(bitSequence.substring(1,5),2));
        double manti = 1;
        for( int i =0; i<bitSequence.substring(5).length(); i++){
            if(bitSequence.substring(5).charAt(i)=='1'){
                manti = manti+Math.pow(2,-(i+1));
            }
        }
        double num = exp* manti;
        result = (bitSequence.charAt(0) == '0')?num:-num;
        return (float)result;
    }


    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int c =0;
        for(int i=0; i<bitSequences.length;i++){
            float ms = miniFloatFromString(bitSequences[i]);
            if (ms % 1 == 0){
                System.out.println(bitSequences[i]+" == "+(int)ms);
                c++;

            }
        }
        System.out.println("Total number of integer values: " +c);

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
