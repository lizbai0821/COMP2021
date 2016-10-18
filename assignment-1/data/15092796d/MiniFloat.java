public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float ans=1;
        String temp;
        short square;
        float tempfloat=0;

        if (bitSequence.charAt(0)=='0'){
            ans*=1;
        }
        else {
            ans *= -1;
        }
        if(bitSequence.charAt(1) == '0'){
            temp="000000000000"+bitSequence.substring(1,5);
        }
        else {
            temp="111111111111"+bitSequence.substring(1,5);
        }
        square=(short)Integer.parseInt(temp,2);
        for(int i=5;i<8;i++){
            int tempc=Integer.parseInt(bitSequence.substring(i,i+1),10);
            tempfloat+=(tempc*Math.pow(2,-(i-4)));
        }
        tempfloat*=ans;
        ans+=tempfloat;
        ans*=Math.pow(2,square);
        return ans;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        float temp;
        int count=0;
        // Task 2: print all the miniFloat values that are integer;
        for(int i=0;i<bitSequences.length;i++){
            temp=miniFloatFromString(bitSequences[i]);
            if(temp%1==0) {
                System.out.println(bitSequences[i]+" == "+(int) temp);
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
