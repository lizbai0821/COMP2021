public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int i;
        int j = 0;
        float b = 0;
        if (Character.getNumericValue(bitSequence.charAt(1)) == 0){
            for(i=2; i<5; i++){
                j = j+Character.getNumericValue(bitSequence.charAt(i))*(int)(Math.pow(2,(4-i)));
            }
        }
        else{
            char[] a = new char[4];
            int k = 0;
            for(i=1; i<5; i++){
                if(bitSequence.charAt(i) == '1'){
                    a[k] = '0';
                }
                else{
                    a[k] = '1';
                }
                k++;
            }
            for(i=0; i<=3; i++){
                j = j+Character.getNumericValue(a[i])*(int)(Math.pow(2,(3-i)));
            }
            j += 1;
            j *= -1;
        }

        for(i=5; i<8; i++){
            b = b+Character.getNumericValue(bitSequence.charAt(i))*(float)(Math.pow(2,(4-i)));
        }
        b++;
        float r;
        r = b*(float)(Math.pow(2,j));

        if(Character.getNumericValue(bitSequence.charAt(0))==1){
            r *= -1;
        }
        return r;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int len = bitSequences.length;
        int i;
        int count = 0;
        for(i=0; i<len;i++){
            float r = miniFloatFromString(bitSequences[i]);
            if(((int)r-r)==0){
                System.out.printf("%s: %d\n",bitSequences[i],(int)(r));
                count ++;
            }
        }
        System.out.printf("Total number of integral miniFloat values: %d\n",count);
    }

    /**
     * Get all valid bit sequences for miniFloat values.
     */
    private static String[] getValidMiniFloatBitSequences(){
        int nbrValues = (int)Math.pow(2, MINI_FLOAT_SIZE);

        String[] r = new String[nbrValues];
        for(int i = 0; i < nbrValues; i++){

            String full = String.format("%" + Integer.SIZE + "s", Integer.toBinaryString(i))
                    .replace(' ', '0');
            r[i] = full.substring(Integer.SIZE - MINI_FLOAT_SIZE, Integer.SIZE);
        }
        return r;
    }
    
    private static int MINI_FLOAT_SIZE = 8;

}
