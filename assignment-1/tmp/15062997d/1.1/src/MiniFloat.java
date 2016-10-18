public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        String result ;

        double exp_part = Math.pow(2,Integer.parseInt(bitSequence.substring(1,5), 2));
        //System.out.println("----"+Integer.parseInt(bitSequence.substring(1,5), 2));
        //System.out.println("----"+exp_part);
        //double mantissa = Float.parseFloat(("1."+bitSequence.substring(5)));
        //System.out.println("----"+mantissa);
        //double number = exp_part*mantissa;


        //double exp_part = Math.pow(2,Integer.parseInt(bitSequence.substring(1,5), 2));
        //System.out.println("----"+exp_part);
        double mantissa =1;
        for( int i=0; i<bitSequence.substring(5).length();i++){
            if(bitSequence.substring(5).charAt(i)=='1'){
                mantissa = mantissa+Math.pow(2,-(i+1));
            }
        }

        double number = exp_part*mantissa;
        //System.out.println(number);
        result = (bitSequence.toCharArray()[0] == '0')?"+"+Double.toString(number):"-"+Double.toString(number);
        return Float.parseFloat(result);



    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int counter =0;
        for(int i =0;i < bitSequences.length;i++){
            float m_s= miniFloatFromString(bitSequences[i]);
            //System.out.println(bitSequences[i]+" == "+m_s);
            if (m_s % 1 ==0){
                //System.out.println(bitSequences[i]);
                System.out.println(bitSequences[i]+" == "+(int)m_s);
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
