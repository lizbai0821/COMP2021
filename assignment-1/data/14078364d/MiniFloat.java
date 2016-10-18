public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }
    	
    private static float miniFloatFromString(String bitSequence){
    	
        // Task1: compute the miniFloat value from "bitSequence";
    	float bitMiniFloat = 0;
    	String buf1 = new String();
    	String buf2 = new String();
    	int exponent = 0;
    	float mantissa = 0; 
    	char e, m;
    	for (int i=1;i<=4;i++){
    		e = bitSequence.charAt(i);
    		buf1+=e;
    	}
    	exponent = Integer.parseInt(buf1,2);
    	
    	for (int i=5;i<=7;i++){
    		m = bitSequence.charAt(i);
    		buf2+=m;
    	}
    	mantissa = (float)(Integer.parseInt(buf2,2)/Math.pow(2, 3));
    	
    	bitMiniFloat = (float) Math.pow(2, exponent)*(mantissa+1);
    	
    	if (bitSequence.charAt(0)=='1'){
    		bitMiniFloat *= -1;
    	}
    	
    	return bitMiniFloat;

    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int r, cnt = 0;
    	for (int i=0; i<bitSequences.length; i++){
    		if (miniFloatFromString(bitSequences[i]) == Math.round(
    				miniFloatFromString(bitSequences[i]))){
    			r = (int)miniFloatFromString(bitSequences[i]);
    			System.out.println(bitSequences[i]+" == "+r);
    			cnt++;
    		}
    	}
    	System.out.println("Total number of integral miniFloat values: "+cnt);
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
