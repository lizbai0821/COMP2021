import static java.lang.Math.ceil;

public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float input=0;
        boolean negative=false;
        if(bitSequence.charAt(0)==49)
            negative=true;
        String exponent=bitSequence.substring(1,5);
        int ex=0;
        for(int temp=3;temp>=0;temp--){
            if(exponent.charAt(temp)==49)
                ex+=2^temp;
        }
        String mantissa=bitSequence.substring(5,8);
        float ma=0;
        for(int temp=2;temp>=0;temp--){
            if(mantissa.charAt(temp)==49) {
                ma += 2 ^ (-1 * temp);
            }
        }
        input=(2^ex)*ma;
        if(negative)
            input*=-1;

        return input;


    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        float res=0;
        int count=0;

        // Task 2: print all the miniFloat values that are integer;
        for (String temp:bitSequences) {
            res = miniFloatFromString(temp);
            if (ceil(res) == res) {
                System.out.printf("%s == %f", temp, res);
                count++;
            }
            System.out.println();
        }
        System.out.printf("Total number of intergral miniFloat values: %d",count);




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
