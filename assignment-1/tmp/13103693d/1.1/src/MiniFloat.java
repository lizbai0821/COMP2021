


import static java.lang.Math.pow;

public class MiniFloat {

    public static void main(String[] args){
            printIntegralMiniFloats();

//        System.out.println(1/2);
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
            float result; int power=0; int a =8; float mag = 0; float b = (float) 0.5;
            int i;
            for(i=1; i<=4; i++) {
                if ((bitSequence.charAt(i)) == 49) {
                    power= power+a;
                }
                a = a/2;
            }
            if (bitSequence.charAt(1)==49){
                power = -(16 - power);
            }

            for(i=5;i<=7;i++){
                if (bitSequence.charAt(i) == 49){
                    mag = mag + b;
                }
                b = b/2;
            }

            float p = (float) pow(2, power);

            if (bitSequence.charAt(0)==48) {
                result = ((mag + 1) * p);
            }

            else {
                result = -((mag + 1) * p);
            }


        return result;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        // Task 2: print all the miniFloat values that are integer;
        int count = 0;
        int k;

        for (int j = 0; j< bitSequences.length; j++){
             k = (int)miniFloatFromString(bitSequences[j]);

            if ((miniFloatFromString(bitSequences[j])-k ) ==0){
                System.out.println(bitSequences[j]+" == "+ k);
                count= count+1;
            }
        }
        System.out.println("total number:" + count);
    }

    /**
     * Get all valid bit sequences for miniFloat values.
     */
    private static String[] getValidMiniFloatBitSequences(){
        int nbrValues = (int) pow(2, MINI_FLOAT_SIZE);

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
