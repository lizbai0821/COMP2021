public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
    	float mantissa = 0;
    	int num=0;
    	int po=-4;
    	
    	for(int i=4;i>0;i--){
    		   		
    		if(bitSequence.charAt(i)=='1'){
    			num+=Math.pow(2, i + po);}
    		po+=2;
    		    	
    		
    	}
    	for(int i=7;i>4;i--){
    		
    		if(bitSequence.charAt(i)=='1'){
    			mantissa+=1;}
    		mantissa/=2;    		
    	}
    	float ans=0;
    	mantissa+=1;
    	
    	int exponent=1<<num;

    	ans=(mantissa*exponent);
    	
    	if(bitSequence.charAt(0)=='1'){
    		ans *= -1;
    	}
    	return ans;
    	
    	
    	
    		

    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int counter=0;
        
        // Task 2: print all the miniFloat values that are integer;
        for(int i=0;i<256;i++){
        	if(miniFloatFromString(bitSequences[i]) % 1 == 0){
        		System.out.println(bitSequences[i] + "=" +(int) miniFloatFromString(bitSequences[i]));
        		counter++;
        		
        	}
        	
        
        }
        System.out.println(counter);
        
        

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
