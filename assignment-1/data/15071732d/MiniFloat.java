public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the m;iniFloat value from "bitSequence";
        double sig = 1;
        int exp = 0;
        for(int i =2;i<=4;i++){
            int temp = (int) (((bitSequence.charAt(i))-48)*Math.pow(2,4-i));
            exp= exp+temp;
            if((((bitSequence.charAt(1))-48))==1){
                exp=exp-8;
            }
        }

        int x=2;
        for (int j =5;j<=7;j++){
            double temp2 = ((bitSequence.charAt(j)-48)*(1.0/x));
            sig = sig+temp2;
            x=x*2;
        }
        float ans=(float) (sig*Math.pow(2,exp));
        if(bitSequence.charAt(0)-48 == 1){
            ans=0-ans;
        }
        return ans;
    }


    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int counter=0;

        // Task 2: print all the miniFloat values that are integer;
        for(int k = 0; k<256; k++){
            String temp =  bitSequences[k];
            if (miniFloatFromString(temp)%1 == 0) {
                counter = counter + 1;
                System.out.println(temp+" "+"== "+ (int)(miniFloatFromString(temp)));
            }
        }
        System.out.print("Total number of integral miniFloat values: "+counter);


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

