/*
* Student Name: Pang King Shun
* Student ID:14075067d
* Assignment 1
* */

public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int i, sign, bitSign, index;
        float exponent = 0, mantissa=0, temp;
        char bit = bitSequence.charAt(0);       //get the first bit in char
        sign = Character.getNumericValue(bit);  //change into int

        char c = bitSequence.charAt(1);     //get the second bit as the sign of 2's complement

        bitSign = Character.getNumericValue(c);    //change into int
        if (bitSign == 0){				//2's complement when it is positive
            for(i = 2 , index = 2; i < 5; i++, index--){
                char c1 = bitSequence.charAt(i);
                temp = Character.getNumericValue(c1);
                exponent = exponent + (temp*(float)(Math.pow(2,index)));


            }

        }
        else{						//2's complement when it is negative
            for(i = 2 , index = 2; i < 5; i++, index--){
                char c2 = bitSequence.charAt(i);
                temp =Character.getNumericValue(c2);


                if(temp == 0){		//change 0 to 1
                    exponent = exponent + (1*(float)(Math.pow(2,index)));
                }
				else{											//change 1 to 0
                    exponent = exponent + (0*(float)(Math.pow(2,index)));
                }
            }
            exponent++; //add 1 to exponent
            exponent=exponent*(-1);

        }
        for(i = 5 , index = -1; i < MINI_FLOAT_SIZE; i++, index--){
            char c3 = bitSequence.charAt(i);
            temp = Character.getNumericValue(c3);
            mantissa = mantissa + (temp *(float)(Math.pow(2,index)));

        }
        mantissa++;




        if(sign==1) {
            float result = mantissa*(float)Math.pow(2, exponent);
            result = result *(-1);

            return result;

        }
        else {
            float result =  mantissa * (float) Math.pow(2, exponent);


            return result;

        }









    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        // Task 2: print all the miniFloat values that are integer;
        int counter=0;

         for(int j=0 ; j < (int)Math.pow(2, MINI_FLOAT_SIZE); j++){

             float result = miniFloatFromString(bitSequences[j]);
             if(result == (int)result){
                 ++counter;
                 System.out.println(bitSequences[j] + "==" + (int)result);



             }
         }
         System.out.println("Total number of integral miniFloat values:"+counter);



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

        System.out.println(result);


        return result;
    }

    private static int MINI_FLOAT_SIZE = 8;

}
