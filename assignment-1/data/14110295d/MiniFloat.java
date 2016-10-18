import java.util.Scanner;

public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();

    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";


        int Array[] = new int [bitSequence.length()];
        int exp =0;
        float man = 1;
        for (int m=1;m<bitSequence.length();m++){
            Array[m] = Character.getNumericValue(bitSequence.charAt(m));
        }


        //exponent
        for(int s = 4; s > 0; s--) {
            exp = Integer.parseInt(bitSequence.substring(1, 5), 2);
            if (Array[1] == 1)
                exp -= 16;
        }


        //mantissa
        int h= -1;
        for (int i2 = 5 ; i2 < 8 ; i2++) {
            man += Array[i2] * (float) Math.pow(2, h);
            h -= 1;
        }

        float result =0;


        //result
        result = man * (float) Math.pow(2,exp);

        if (Array[0]==1){
            result=-result;
        }


        return result;

    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int Count = 0;
        for( int i=0;i<bitSequences.length;i++) {
            if (miniFloatFromString(bitSequences[i])== (int)miniFloatFromString(bitSequences[i])) {
                System.out.println(bitSequences[i] + "==" + miniFloatFromString(bitSequences[i]));
                Count++;
            }
    }
        System.out.print("Total number of integral miniFloat values: "+ Count);
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
