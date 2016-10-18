public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int sign;
        float exponent =0;
        float mantissa =0;
        int temp1;
        float temp2;
        char L1,L2;
        if(bitSequence.charAt(0)=='0'){
            sign=1;
        }
        else{
            sign=-1;
        }

        for(int i=1;i<=4;i++){
            L1=bitSequence.charAt(i);
            temp1= (int) Character.getNumericValue(L1);		
			temp1 *= Math.pow(2,4-i);
            exponent += temp1;
            if(bitSequence.charAt(1)=='1'){
                exponent -=Math.pow(2,4);
            }
        }
        for(int i=5;i<=7;i++){
            L2=bitSequence.charAt(i);
            temp2 = Character.getNumericValue(L2);
            temp2 *= Math.pow(2,4-i);
            mantissa += temp2;
        }

        exponent= (int) Math.pow(2,exponent);
        float result = sign*exponent*(mantissa+1);
        return result;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        // Task 2: print all the miniFloat values that are integer;
        int count = 0;
        for(int j=0;j<=255;j++){
            float tmp = miniFloatFromString(bitSequences[j]);
            if (tmp == Math.ceil(tmp)) {
                if(tmp!=0) {
                    System.out.println(bitSequences[j] + " == " + (int) tmp);
                    count += 1;
                }
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
