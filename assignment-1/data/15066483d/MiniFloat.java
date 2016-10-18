public class MiniFloat {

    public static void main(String[] args){


        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){

        int store=0;  //store the value of 8bit

        for (int i=1;i<5;i++){
            char result=bitSequence.charAt(i);
            if(result=='1'){
                store+=Math.pow(2,4-i);

            }else{
                store+=0;
            }
        }

        float storef=0;    //store value of mantissa
        for (int k=5;k<8;k++){
            char result1=bitSequence.charAt(k);

            if(result1=='1'){
                storef+=Math.pow(2,4-k);

            }
            else{
                storef+=0;
            }
        }
        int signofexponent=bitSequence.charAt(1);
        if(signofexponent=='1'){
            store=store*-1;
        }
        else{
            store=store;
        }

        float mantissa=  1+ storef;
        float exponent=(float)Math.pow(2,store);
        float value=mantissa*exponent;
        int sign=bitSequence.charAt(0);
        if(sign=='1'){
            value=value*-1;
        }
        else{
            value=value;
        }
        //System.out.println(value);
        return value;

    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int a=bitSequences.length;
        int counter=0;
        for(int i=0;i<a;i++){
            float value1=miniFloatFromString(bitSequences[i]);
            if(value1==(int) value1){
                System.out.println(bitSequences[i]+" == "+value1);

                counter++;

            }



        }System.out.println("The total number of integers:"+counter);


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
