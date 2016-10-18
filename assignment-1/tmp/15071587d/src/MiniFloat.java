public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){

        float value = 1;
        float total;
        int bit = Character.getNumericValue(bitSequence.charAt(0));
        int exp = Integer.parseInt(bitSequence.substring(1, 5),2);
        int n1 =Character.getNumericValue(bitSequence.charAt(5));
        int n2 =Character.getNumericValue(bitSequence.charAt(6));
        int n3 =Character.getNumericValue(bitSequence.charAt(7));

        if (n1==1) {
            value = value + (float) Math.pow(2, -1);
        }
        if (n2==1) {
            value = value + (float) Math.pow(2, -2);
        }
        if (n3==1) {
            value = value + (float) Math.pow(2, -3);
        }

        total = value  * (int) Math.pow(2, exp) ;

        if (bit==0){
            total = total * -1 ;
        }
        return total;
        // Task1: compute the miniFloat value from "bitSequence";
    }

    private static void printIntegralMiniFloats(){

        String[] bitSequences = getValidMiniFloatBitSequences();
        int size = bitSequences.length;
        int total_value = 0;

        for (int i = 0 ; i < size ; i ++ ){
            float final_value= miniFloatFromString(bitSequences[i]);

            if (final_value == (int)final_value)
            {
                total_value = total_value + (int)final_value;
                System.out.println(bitSequences[i] + " == " + (int)final_value);
            }
        }
        System.out.println("Total number of integral miniFloat values: " + total_value);

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