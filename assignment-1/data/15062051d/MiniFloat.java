public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        String exponent = bitSequence.substring(1,5);//the exponent part of the bitSequence
        String mantissa = bitSequence.substring(5,8);//the mantissa part of the bitSequence
        float ValueOfMantissa=1;
        short ValueOfExponent;
        for(int i=1;i<=3;i++){//calculate the value of the mantissa
            if(mantissa.charAt(i-1)=='1'){
                ValueOfMantissa= ValueOfMantissa + 1/(float) Math.pow(2,i);
            }
        }
        if(exponent.charAt(0)=='1'){//if the exponent part is negative, add 1 in the left
            exponent="111111111111"+exponent;
        }
        ValueOfExponent = (short)Integer.parseInt(exponent, 2);//get the two’s complement value of the exponent
        float temp =  (float) Math.pow(2,ValueOfExponent);
        float ans = ValueOfMantissa * temp;// calculate the answer
        if(bitSequence.charAt(0)=='1'){// check whether the sign of bitSequence is positive or negative
            ans*=-1;
        }


        return ans;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count=0;
        for(int i=0;i<bitSequences.length;i++){
            float valueOfBitSequences = miniFloatFromString(bitSequences[i]);
            if(valueOfBitSequences==(int) valueOfBitSequences ){
                System.out.print(bitSequences[i]+" == "+valueOfBitSequences+"\n" );
                count++;
            }


        }
        System.out.print("Total number of integral miniFloat values: "+count);
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
