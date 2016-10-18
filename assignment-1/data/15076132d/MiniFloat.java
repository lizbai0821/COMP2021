public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float mfloat = 0;
        int sign = 0;
        float mantissa = 1;
        int mantissatime = -1;
        int exponent = 0;
        int expotime = 3;
        int[] intarray= new int[bitSequence.length()];
        String[] strarray = bitSequence.split("");
        for (int h = 0; h < bitSequence.length(); h++){
            intarray[h] = Integer.parseInt(strarray[h]);
            //find exponent
            if(h > 0 && h < 5){
                if(intarray[h] == 1){
                    if(h == 1){
                        exponent += -8;
                    }
                    else{
                        exponent += Math.pow(2,expotime);
                    }
                }
                expotime -= 1;
            }
            //find mantissa
            if(h > 4){
                if(intarray[h] == 1){
                    mantissa += Math.pow(2,mantissatime);
                }
                mantissatime -= 1;
            }
        }
        //find miniFloat
        mfloat = (float) ((mantissa)*Math.pow(2,exponent));
        if(intarray[0] == 1){
            mfloat *= -1;
        }
        //System.out.printf(bitSequence+" = ");
        //System.out.println(mfloat);
        //System.out.println("");
        return mfloat;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        //find the total number of integer miniFloat
        int count = 0;
        for(int j=0; j<bitSequences.length;j++){
            float minifloat = miniFloatFromString(bitSequences[j]);
            if (Math.ceil(minifloat) - minifloat == 0){
                count += 1;
                System.out.println(bitSequences[j] + " = " + String.valueOf(minifloat));
            }
        }
        System.out.println("Total number of integral miniFloat values: " + count + ".");
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
