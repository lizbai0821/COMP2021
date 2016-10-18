public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
    	int exponent = -7;
    	float mantissa=0.0f;
    	float magnitude;
    	if(bitSequence.charAt(1)=='1'){
    		exponent+=8;
    	}
    	if(bitSequence.charAt(2)=='1'){
    		exponent+=4;
    	}
    	if(bitSequence.charAt(3)=='1'){
    		exponent+=2;
    	}
    	if(bitSequence.charAt(4)=='1'){
    		exponent+=1;
    	}
    	if(bitSequence.charAt(5)=='1'){
    		mantissa+=0.5;
    	}
    	if(bitSequence.charAt(6)=='1'){
    		mantissa+=0.25;
    	}
    	if(bitSequence.charAt(7)=='1'){
    		mantissa+=0.125;
    	}
    	magnitude = (1+mantissa)*(float)Math.pow(2,exponent);
    	if(bitSequence.charAt(0)=='1'){
    		return -magnitude;
    	}
    	return magnitude;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int counter = 0;
        // Task 2: print all the miniFloat values that are integer;
        for(int i=0;i<bitSequences.length;i++){
        	float value = miniFloatFromString(bitSequences[i]);
        	if(value%1==0){
        		System.out.println(bitSequences[i]+" == "+(int)value);
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
