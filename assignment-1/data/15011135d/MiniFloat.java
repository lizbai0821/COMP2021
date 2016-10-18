public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float result = 1;
        int exponent =0;
        for(int i =1; i<5 ;i++){
            if(bitSequence.charAt(i)=='1'){
                exponent+=Math.pow(2,4-i);
            }
        }
        if(bitSequence.charAt(1)=='1'){
            exponent= 16-exponent;
            exponent*=-1;
        }


        for(int i =5; i<8 ;i++){
            if(bitSequence.charAt(i)=='1'){
                result+=Math.pow(2,-i+4);
            }
        }
        result*=Math.pow(2,exponent);
        if(bitSequence.charAt(0)=='1'){
            result*=-1;
        }
        return  result;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int count=0;
        for(int i=0;i<bitSequences.length;i++){
            float temp = miniFloatFromString(bitSequences[i]);
            if(temp==(int)temp){
                System.out.println(bitSequences[i]+" == "+ (int)temp);
                count++;
            }
        }
        System.out.println("Total number of intergral minifloat values: "+count);
    }

    /**
     * Get all valid bit sequences for miniFloat values.
     */
    private static String[] getValidMiniFloatBitSequences(){
        int nbrValues = (int)Math.pow(2, MINI_FLOAT_SIZE);

        String[] result = new String[nbrValues];
        for(int i = 0; i < nbrValues; i++){

            String full = String.format("%" + Integer.SIZE + "s", Integer.toBinaryString(i)).replace(' ', '0');
            result[i] = full.substring(Integer.SIZE - MINI_FLOAT_SIZE, Integer.SIZE);
        }
        return result;
    }

    private static int MINI_FLOAT_SIZE = 8;

}
