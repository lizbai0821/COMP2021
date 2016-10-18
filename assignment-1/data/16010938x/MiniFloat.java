

public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
       // System.out.println(miniFloatFromString("00100110"));
    }

    private static int convertExpBits(String expString)
    {
        int exponent = 0;
        
        for (int i = 0; i < expString.length(); i++)
        {
            exponent += Character.getNumericValue(expString.charAt(i)) * Math.pow(2,expString.length()-1-i);
        }
        return  exponent;
    }

    private static float convertManBits(String expString)
    {
        float base = 0;
        for (int i = 0; i < expString.length(); i++)
        {
            base += Character.getNumericValue(expString.charAt(i)) * Math.pow(0.5,i+1);
        }
        return  base+1;
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        boolean isPositive = true;
        String index = bitSequence.substring(1,5);
        String mantissa = bitSequence.substring(5, bitSequence.length());

        //Check Positive
        if (bitSequence.charAt(0) == '1')
            isPositive = false;
        int exponent = convertExpBits(index);
        float base = convertManBits(mantissa);
        float unsign =  (float) (base * Math.pow(2,exponent));
        if (isPositive)
            return unsign;
        else
            return -unsign;
    }


    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        // Task 2: print all the miniFloat values that are integer;
        for (int i = 0 ; i< bitSequences.length; i++)
        {
            System.out.println("Number is "+ miniFloatFromString(bitSequences[i]));
        }
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
