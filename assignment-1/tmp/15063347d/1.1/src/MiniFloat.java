public class MiniFloat {

    public static void main(String[] args){


        //printIntegralMiniFloats();
        printIntegralMiniFloats();
    }



    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        //int Bits = Integer.parseInt(bitSequence);
        String temp = bitSequence;
        String sign = temp.substring(0,1);
        String expo = temp.substring(1,5);
        String manti = temp.substring(5);

        int sign_n = Integer.parseInt(sign);
        int dec_expo=0;
        for(int i =0; i<expo.length();i++){
            if (expo.charAt(0) == '1') {
                String res =expo;
                res.replace("0"," ");
                res.replace("1","0");
                res.replace(" ","0");

                int dec = Integer.parseInt(res,2);
                dec_expo= (dec+1)*-1;

            }
            else{
                String res =expo;
                dec_expo = Integer.parseInt(res,2);
            }
        }
        float dec_manti=0;
        for(int i = 0; i<manti.length();i++){
            dec_manti+= Character.getNumericValue(manti.charAt(i))*Math.pow(2,-i-1);
        }
        float final_num;
        if(sign_n==0)
            final_num = 1+dec_manti;
        else
            final_num = -(1+dec_manti);

        final_num = final_num*(float)Math.pow(2,dec_expo);

        return final_num;


    }

    private static void printIntegralMiniFloats(){
        // Task 2: print all the miniFloat values that are integer;
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count=0;
        for(int i=0; i<bitSequences.length;i++){
            float value =miniFloatFromString(bitSequences[i]);
            if(value == Math.ceil(value)) {
                System.out.println(bitSequences[i] + " == " + (int) value);
                count+=1;
            }
            else
                continue;

        }
        System.out.print("Total number of integral miniFloat values: "+count);

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
