public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float mantissa=0;
        int exponent =0;


        for(int i=1;i<4;i++){
            if(bitSequence.charAt(MINI_FLOAT_SIZE-i)=='1'){
                mantissa+= Math.pow(2,i-4);//the last three bit, the last is 2^-3, i=1;so i-4
            }
        }
        for(int i=1;i<4;i++){
            if(bitSequence.charAt(MINI_FLOAT_SIZE-i-3)=='1'){//from 2-4 so need to be 8-i-3
                exponent+=(int)Math.pow(2,i-1);
            }
        }
        if(bitSequence.charAt(0)=='0'){//judge the sign of 0and 1 bit;
            if(bitSequence.charAt(1)=='0'){


                return (1+mantissa)*((int)Math.pow(2,exponent));
            }
            else{return (1+mantissa)*((float)Math.pow(2,exponent-8));}

        }else{if(bitSequence.charAt(1)=='0'){

            return -(1+mantissa)*((int)Math.pow(2,exponent));
        }
        else{return -(1+mantissa)*((float)Math.pow(2,exponent-8));}
        }


    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int numberOfInt =0;//count
        for(int k=0;k<(int)Math.pow(2, MINI_FLOAT_SIZE)-1;k++){
            float valueOfMiniFloat= miniFloatFromString(bitSequences[k]);

            if(valueOfMiniFloat %1==0){
                System.out.print(bitSequences[k]);
                System.out.println(" == "+(int)valueOfMiniFloat);
                numberOfInt++;
            }
        }
        System.out.printf("Total number of integral miniFloat values: %d \n",numberOfInt);
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
