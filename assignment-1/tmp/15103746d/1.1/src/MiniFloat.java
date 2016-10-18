public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";

        int signValue= bitSequence.charAt(0)=='0'?1:-1;
        int exponentValue=Integer.valueOf(bitSequence.substring(1,5),2);
        float mantissaValue=Integer.valueOf(bitSequence.substring(5),2)/8.0f;//the value of mantissa part
        if(bitSequence.charAt(1)=='1')//if the exponent part starts with 1 , which means that the real value is negative(16-exponent)
            exponentValue-=16;
        float floatValue=(float)((mantissaValue+1)*Math.pow(2,exponentValue))*signValue;//calculate the float value of the string
        return floatValue;

    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count=0;
        for(int i = 0; i<bitSequences.length;i++){//for each member in the list
            float miniFloatValue=miniFloatFromString(bitSequences[i]);//get the float value
            if(miniFloatValue%1==0){//if the number is int, print the number and its value, count++
                System.out.println(bitSequences[i]+"=="+(int)miniFloatValue);
                count++;
            }
        }
        System.out.println("Total number of integral miniFloat values: "+count);
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
