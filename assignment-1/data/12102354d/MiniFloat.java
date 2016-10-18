public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
		
        // Task1: compute the miniFloat value from "bitSequence";
    	float plusMinus, temp, result;
    	plusMinus=0;
    	temp=0;
    	result=0;
    	
    	
    	
    	
    	if(bitSequence.charAt(0)=='1'){
    		plusMinus=-1;
    	}else{
    		plusMinus=0;
    	}
    	
    	
    	
        
        	
        return result=result*plusMinus; 
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        System.out.println(bitSequences+"=="+"");
        int total=0;
        total=total+1;
        System.out.println("Total number of integral miniFloat values: <"+total+">");
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
