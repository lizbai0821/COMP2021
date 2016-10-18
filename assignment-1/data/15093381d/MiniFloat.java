public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";

        int sign;
        if(bitSequence.charAt(0)=='0')  sign=1;
        else sign=-1;

        int exponent=0;
        for(int i=0;i<3;i++){
            exponent+=(bitSequence.charAt(i+2)-'0')*Math.pow(2,2-i);
        }
        if(bitSequence.charAt(1)=='1'){
            exponent-=8;
            //System.out.print(exponent);
        }

        float exponent2=1;
        if (exponent>0){
            for(int i=0;i<exponent;i++){
                exponent2*=2;
            }
        }
        else if(exponent<0){
            for(int i=0;i>exponent;i--){
                exponent2/=2;
            }
        }

        float mantissa=0;
        for(int i=0;i<3;i++){
            mantissa+=(bitSequence.charAt(i+5)-'0')*Math.pow(2,-i-1);
        }

        return sign*exponent2*(1+mantissa);
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int counter=0;
        // Task 2: print all the miniFloat values that are integer;

        for(int i=0;i<bitSequences.length;i++){
            /*System.out.print(miniFloatFromString(bitSequences[i]));
            System.out.print(" , ");
            if(i%10==9) System.out.println();*/
            if((miniFloatFromString(bitSequences[i])-(int)miniFloatFromString(bitSequences[i]))==0){
                System.out.println(bitSequences[i]+"=="+(int)miniFloatFromString(bitSequences[i]));
                counter++;
            }
        }
        System.out.println("Total number of integral miniFloat values: "+counter);
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
