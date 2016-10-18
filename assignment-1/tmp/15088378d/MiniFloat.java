public class MiniFloat {

    public static void main(String[] args){

        printIntegralMiniFloats();

    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat   at value from "bitSequence";
        float miniFloat;

        int sign = Integer.valueOf(bitSequence.charAt(0)-48);

        int exponent=0;
        float mantissa=0;


            for (int j = 4; j >= 2; j--) {
                exponent += (Integer.valueOf(bitSequence.charAt(j)) - '0') * (int) Math.pow(2, 4 - j);
            }

        if(Integer.valueOf(bitSequence.charAt(1))-'0'==1) exponent-=8;


        exponent= (int)Math.pow(2, exponent);
        for(int j=7;j>=5;j--){
            mantissa+= (Integer.valueOf(bitSequence.charAt(j))-'0') * Math.pow(2, 4-j);
        }
        miniFloat = (1+mantissa) * exponent;

        return sign==0?miniFloat: -miniFloat;

    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count=0;
        for(int i=0;i<(int)Math.pow(2, MINI_FLOAT_SIZE);i++){
            float miniFloat = miniFloatFromString(bitSequences[i]);

            if(miniFloat==(int)miniFloat &&(miniFloat!=0)){
                System.out.println(bitSequences[i]+" == "+(int)miniFloat);
                count++;
            }
        }
        System.out.println("Total number of integral miniFloat values: "+count);
    }

    /**
     * Get all valid bit sequences for miniFloat values.
     */
    private static String[] getValidMiniFloatBitSequences(){
        int nbrValues = (int)Math.pow(2, MINI_FLOAT_SIZE); // 2^8

        String[] result = new String[nbrValues]; //create 2^8
        for(int i = 0; i < nbrValues; i++){

            String full = String.format("%" + Integer.SIZE + "s", Integer.toBinaryString(i))
                    .replace(' ', '0');

            result[i] = full.substring(Integer.SIZE - MINI_FLOAT_SIZE, Integer.SIZE); //(24,32)
        }
        return result;
    }

    private static int MINI_FLOAT_SIZE = 8;

}
