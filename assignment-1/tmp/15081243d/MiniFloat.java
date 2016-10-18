// 15081243 LAU TAK WAI Comp2021 Assginment1
import com.sun.org.apache.xpath.internal.functions.FuncFalse;

public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        String signBit,exponentBit,mantissaBit;
        int signValue = 0,exponentValue = 0,exponentSign =0;
        float mantissaValue = 1,answer;

        signBit = bitSequence.substring(0,1);
        exponentBit = bitSequence.substring(1,5);
        mantissaBit = bitSequence.substring(5,8);

        //System.out.println(signBit+" "+exponentBit+" "+mantissaBit);

        if(signBit.substring(0,1).equals("0"))signValue = 1;
        else signValue = -1;

        if(exponentBit.substring(0,1).equals("0"))
            exponentSign = 0;
        else exponentSign = 1;

        if(exponentSign == 0) {
            for (int i = 1; i < 4; i++)
                if (exponentBit.substring(i, i + 1).equals("1"))
                    exponentValue = exponentValue + (int) ((Math.pow(2, 3 - i)));
        }
        else {
            /*
            int tempValue = Integer.parseInt(exponentBit.substring(0, 4), 2);
            tempValue = tempValue - 1;
            exponentBit = Integer.toBinaryString(tempValue);

            while(exponentBit.length() < 4)
                exponentBit = "0" + exponentBit;
            exponentBit = "0" + exponentBit.substring(1,4);
            */

                int tempValue = (int) Math.pow(2, 5) - Integer.parseInt(exponentBit.substring(0, 4), 2);
                exponentBit = (Integer.toBinaryString(tempValue));
                exponentBit = exponentBit.substring(exponentBit.length() - 4, exponentBit.length());
                while (exponentBit.length() < 4)
                    exponentBit = "0" + exponentBit;

                for (int i = 0 ;i < 4; i++)
                    if (exponentBit.substring(i, i + 1).equals("1"))
                        exponentValue = exponentValue + (int) ((Math.pow(2, 3 - i)));



        }
        int tempValueCount = 2;
        for(int i = 0 ; i < 3; i++) {
            if (mantissaBit.substring(i, i + 1).equals("1")) {
                mantissaValue = mantissaValue + (float)(1.0 / tempValueCount);
            }

            tempValueCount = tempValueCount * 2;
        }

        if(exponentSign == 0)
            answer = signValue * mantissaValue * (float)Math.pow(2,exponentValue);
        else
            answer = signValue * mantissaValue * (float)(1/Math.pow(2,exponentValue));
        //System.out.println("E : " + exponentValue);
        //System.out.println("M : " + mantissaValue);
        //System.out.println(answer);
        return answer;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        // Task 2: print all the miniFloat values that are integer;
        String newSequence = "",tempString;
        float tempCount;
        int bitSequencesLength = bitSequences.length;
        int countTotal = 0;

        for(int i = 0; i < bitSequencesLength; i++)
            newSequence = newSequence + bitSequences[i];

        for(int i = 0; i < newSequence.length(); i = i + 8) {
            tempString = newSequence.substring(i, i + 8);
            tempCount = miniFloatFromString(tempString);
            if ( Math.ceil(tempCount) == tempCount ) {
                countTotal = countTotal + 1;
                System.out.println(tempString + " == " + (int)(tempCount));

            }

        }

        System.out.println("Total number of integral miniFloat values: "+countTotal);
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
