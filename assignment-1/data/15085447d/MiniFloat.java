import sun.awt.AWTAccessor;
import sun.security.util.Length;

public class MiniFloat {

    public static void main(String[] args){ printIntegralMiniFloats(); }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int i;
        int index = 0;
        float base = 0;
        if (Character.getNumericValue(bitSequence.charAt(1)) == 0) {
            for(i=2;i<=4;i++) {
                index = index + Character.getNumericValue(bitSequence.charAt(i)) * (int) (Math.pow(2, (4 - i)));
            }
        }
        else{
            char[] complement = new char[4];
            int j=0;
            for(i=1;i<=4;i++){
                if(bitSequence.charAt(i)=='1'){
                    complement[j] = '0';
                }
                else {
                    complement[j] = '1';
                }
                j++;
            }
            for(i=0;i<4;i++) {
                index = index + Character.getNumericValue(complement[i]) * (int) (Math.pow(2, (3 - i)));
            }
            index = index + 1;
            index = -(index);
        }

        for(i=5;i<=7;i++){
            base = base + Character.getNumericValue(bitSequence.charAt(i))*(float)(Math.pow(2,(4-i)));
        }
        base ++;
        float result;
        result = base * (float)(Math.pow(2,index));

        if(Character.getNumericValue(bitSequence.charAt(0))==1){
            result = -(result);
        }
        return result;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int length = bitSequences.length;
        int i;
        int counter = 0;
        for(i = 0;i < length;i++){
            float result = miniFloatFromString(bitSequences[i]);
            if(((int)result - result)==0){
                System.out.printf("%s == %d\n",bitSequences[i],(int)(result));
                counter ++;
            }
        }
        System.out.printf("Total number of integral miniFloat values: %d\n",counter);
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
