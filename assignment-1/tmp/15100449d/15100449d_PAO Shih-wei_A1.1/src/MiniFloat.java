public class MiniFloat {

    public static void main(String[] args){
        //printIntegralMiniFloats();
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        double miniFloat=0;
        int mantissa;
        mantissa=1000+ Integer.parseInt(bitSequence.substring(5, 8));

        for(int i=0;i<=3;i++){
            if(Integer.toString(mantissa).charAt(i)== '1')
                miniFloat+=Math.pow(2,-i);
        }
        for(int j=1;j<=4;j++){
            if(bitSequence.charAt(j)== '1')
                miniFloat*=Math.pow(2,Math.pow(2,4-j));
        }
        if(bitSequence.charAt(0)=='0')
            return (float) miniFloat;
        else
            return (float) -miniFloat;


    }


    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count=0;
        for(int i=0;i<256;i++){
            if(miniFloatFromString(bitSequences[i])==(int)miniFloatFromString(bitSequences[i])){
                System.out.println(bitSequences[i]+"=="+(int)miniFloatFromString(bitSequences[i]));
                count++;
            }

        }
        System.out.println("Total number of integral miniFloat values:  "+count);
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
