public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int check = 0;
        int exponent = 0;
        float mantissa = 0;
        float sum = 0;
        if (bitSequence.charAt(1) == check + '0'){ //check the exponent is positive or not
            for (int j = 2; j < 5; j++) { //Calaculate the exponent part
                if (bitSequence.charAt(j) == check + '1')
                    exponent = exponent + (int)Math.pow(2, 4-j);
                else{
                    exponent = exponent + 0;
                }
            }
            for (int n = 5; n < MINI_FLOAT_SIZE; n++){ //Calculate the mantissa part
                if (bitSequence.charAt(n) == check + '1')
                    mantissa = mantissa + (float)Math.pow(2, 4-n);
            }
            mantissa = mantissa + 1;
            sum = mantissa*(float)(Math.pow(2, exponent)); //Calculate the who;e value
            if (bitSequence.charAt(0) == check + '1')
                sum = 0 - sum;
        }
        else{
            float deflector = (float)0.0001; //Terminate the loop if the exponent is negative which will bring decimal place to the result
            return deflector;
        }
        return sum;
    }

    private static void printIntegralMiniFloats(){
        // Task 2: print all the miniFloat values that are integer;
        String[] bitSequences = getValidMiniFloatBitSequences();
        float temp = 0; //Store each 8-bits binary number
        int count = 0; //Counter for the number of valid output
        for (int y = 0; y < Math.pow(2, MINI_FLOAT_SIZE); y++){
            temp = miniFloatFromString(bitSequences[y]);
            if (temp - Math.ceil(temp) == 0.0) { //Check whether the result is integer or not
                System.out.println(bitSequences[y] + "=" + temp);
                count = count +1;
            }
        }
        System.out.println("Total number: " + count);
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
