public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }
    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float f;
        double d = 0;
        double d2;
        int power = 2;
        for (int i=2;i<5;i++){
            if (bitSequence.charAt(i)=='1'){
                d = d + (Math.pow(2, power));
            }
            power = power - 1;
        }
        if (bitSequence.charAt(1)=='1'){
            d = d - 8;
        }
        d2 = Math.pow(2,d);

        d = 0;

        for (int i = 5;i < 8;i++){

            if (bitSequence.charAt(i)=='1'){
                d = d + Math.pow(2, power);
            }
            power = power - 1;
        }
        if (bitSequence.charAt(0) == '1' ){
            d = -d - 1;
        }
        else{
            d = d +1;
        }
        d = d*d2;
        f = (float) d;
        return f;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count=0;
        for (int i = 0; i<bitSequences.length;i++){
            float f = miniFloatFromString(bitSequences[i]);
            if (f == Math.round(f)){
                count += 1;
                System.out.println(bitSequences[i] + " = " + f);
            }
        }
        System.out.println("The total amount of integer is " + count + " .");

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
