public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        float ans=0;
        float ans2=0;
        int temp1;
        // Task1: compute the miniFloat value from "bitSequence";
        for(int i=1;i<=4;i++){
            temp1=Character.getNumericValue(bitSequence.charAt(i));
            ans = ans +(temp1) * ((float)Math.pow(2,((i-4)*-1)));
        }
        ans2=ans2+1;
        for(int i=5;i<=7;i++){
            temp1=Character.getNumericValue(bitSequence.charAt(i));
            ans2= ans2 +(temp1)* ((float) Math.pow(2,((i-4)*-1)));
        }
        if(bitSequence.charAt(0)=='1')
            ans=((int)(Math.pow(2,ans)))*ans2*-1;
        else ans=((int)(Math.pow(2,ans)))*ans2;
        return ans;
    }
    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        // Task 2: print all the miniFloat values that are integer;
        float temp2;
        int count=0;
        for(int i=0;i<=255;i++) {
            temp2 = miniFloatFromString(bitSequences[i]);
            if (temp2 - (int) temp2 == 0) {
                System.out.println(bitSequences[i] + " " + (int)temp2);
                count = count + 1;
            }
        }
        System.out.println("Total number of integral miniFloat values:"+count);
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
