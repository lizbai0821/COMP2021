public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float minFloat = 0;
        int exp = 0;
        float sig = 1;
        boolean positive = false;  //assume the number is negative as default

        if (bitSequence.charAt(0) == '0')
            positive = true; //set the bool to true if the number is positive


        String expStr = bitSequence.substring(1,5);
        exp = Integer.parseInt(expStr,2);
        if (Character.getNumericValue(bitSequence.charAt(1)) == 1){
            exp *= -1;
        }



        for (int i = 1; i <= 3; i++){
            sig += Character.getNumericValue(bitSequence.charAt(i+4))* Math.pow(2,-1*i);
        }
        minFloat = (float) (sig * Math.pow(2,exp));
        if (!positive){
            minFloat = minFloat * -1;
        }

        return minFloat; //return the float value
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;

        System.out.println("Binary       Decimal");
        int intCounter = 0;
        for (int i = 0; i <= 255; i++){
            float minFloat = miniFloatFromString(bitSequences[i]);
            if (Math.floor(minFloat) == minFloat){
                System.out.print(bitSequences[i]+"     ");
                System.out.println(minFloat);
                intCounter++;
            }
        }
        System.out.println();
        System.out.print("The total number of integer is: "+intCounter);




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
