public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float mini = 1;
        if(bitSequence.charAt(0)=='1'){
            mini=-1;
        }
        float sign=1;
        for(int i=0;i<bitSequence.substring(5,8).length();i++){
            sign+=Character.getNumericValue(bitSequence.charAt(5+i))*Math.pow(2,-1-i);
        }
        mini*=sign;
        int exp=1;
        if(bitSequence.charAt(1)=='1'){
            exp*=-Math.pow(2,4)-Integer.parseInt(bitSequence.substring(1,5),2);
        }
        else{
            exp=Integer.parseInt(bitSequence.substring(1,5),2);
        }
        mini*=Math.pow(2,exp);
        return mini;
    }

    private static void printIntegralMiniFloats(){
        int counter=0;
        String[] bitSequences = getValidMiniFloatBitSequences();
        for(int i=0;i<bitSequences.length;i++){
            float mini=miniFloatFromString(bitSequences[i]);
            if(mini==Math.ceil(mini)){
                System.out.printf("%s == %d\n",bitSequences[i],(int)Math.ceil(mini));
                counter++;
            }
        }
        System.out.printf("Total number of integral miniFloat values: %d",counter);
        // Task 2: print all the miniFloat values that are integer;
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
