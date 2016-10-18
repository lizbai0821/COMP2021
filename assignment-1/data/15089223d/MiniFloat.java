
public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
    	
    	//break the string
    	String exp = "";
    	for(int i = 1; i < 5; i++)
    		exp += bitSequence.charAt(i);
    	String man = "";
    	for(int i = 5; i < 8; i++)
    		man += bitSequence.charAt(i);
    	
    	//calculate the corresponding decimal value
    	int EXP = 0;
    	float MAN = 1;
    		//checking for negative exponent value
    	if(exp.charAt(0) == '1'){
    		for(int i = 0; i < 4; i++)
    			if(exp.charAt(i) == '0')
    				EXP += (int)Math.pow(2, 3 - i);
    		EXP++;
    		EXP *= -1;
    	}
    	else
    		for(int i = 0; i < 4; i++)
    			if(exp.charAt(i) == '1')
    				EXP += (int)Math.pow(2, 3 - i);
    	
    		//the mantissa part
    	for(int i = 0; i < 3; i++)
			if(man.charAt(i) == '1')
				MAN += Math.pow(2, -1 - i);
    	
    	//calculate the whole decimal value
    	float result = (float)Math.pow(2, EXP) * MAN;
    	if(bitSequence.charAt(0) == '1')
    		result *= -1;
    	
    	return result;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int count = 0;
        for(int i = 0; i < bitSequences.length; i++)
        	if(miniFloatFromString(bitSequences[i])%1 == 0){
        		System.out.println(bitSequences[i] + " == " + String.valueOf(miniFloatFromString(bitSequences[i])));
        		count++;
        	}
        System.out.printf("Total number of integral miniFloat values: %d\n", count);
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
