public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int exponent[] = new int[4];
        if (bitSequence.charAt(1)=='0') {
            for (int i=0;i<3;i++) {
                exponent[i] = Character.getNumericValue(bitSequence.charAt(i+2)) * (int) Math.pow(2, 2-i);
            }
            exponent[3]=exponent[0]+exponent[1]+exponent[2];
        }
        else{
            for (int i=0;i<3;i++){
                if (bitSequence.charAt(i+2)=='0')
                    exponent[i]=1* (int) Math.pow(2, 2-i);
                else
                    exponent[i]=0* (int) Math.pow(2, 2-i);
            }
            exponent[3]=-(exponent[0]+exponent[1]+exponent[2]+1);
        }
        float significant[] = new float[4];
        for (int i=0;i<3;i++){
            significant[i] = (float) (Character.getNumericValue(bitSequence.charAt(i+5))*Math.pow(2, -(i+1)));
        }
        significant[3]=significant[0]+significant[1]+significant[2]+1;
        if (bitSequence.charAt(0)=='1')
            return (float)-(significant[3]* Math.pow(2, exponent[3]));
        else
            return (float)(significant[3]* Math.pow(2, exponent[3]));

    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count = 0;
        // Task 2: print all the miniFloat values that are integer;
        for (int i =0;i<256;i++){
            float answer = miniFloatFromString(bitSequences[i]);
            if (answer%1==0) {
                System.out.println(bitSequences[i] + " == " + (int) answer);
                count += 1;
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
