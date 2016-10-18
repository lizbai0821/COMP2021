public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float miniflono = 1;
        float miniinteno = 0;
        for(int i = 7;i>=5;i--){ // calculate mantissa value
            if(bitSequence.charAt(i) == '1'){
                miniflono += 1/(Math.pow(2,(i-4)));
            }
        }
        for(int i = 4;i>=1;i--){ // compute the first 5 bits par
            if(bitSequence.charAt(i) == '1') {
                if (i == 1) {
                    miniinteno -= Math.pow(2, 4 - i);
                }
                else{
                    miniinteno += Math.pow(2, 4 - i);
                }
            }
        }
        miniinteno = (float)Math.pow(2,miniinteno);
        if(bitSequence.charAt(0) == '1'){ // decide positive and negative value
            miniflono *= -1;
        }
        return (miniflono * miniinteno);

    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        // Task 2: print all the miniFloat values that are integer;
        int count = 0;
        for(int i = 0;i<bitSequences.length;i++){
            float result = miniFloatFromString(bitSequences[i]);
            if(result - (int)result == 0){
                count += 1;
                System.out.println(bitSequences[i]+" == "+(int)result);
            }
        }
        System.out.println("The Total number of integral miniFloat values: "+count);

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
