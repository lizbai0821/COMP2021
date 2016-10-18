package minifloat;

public class minifloat {

	    public static void main(String[] args){
	        printIntegralMiniFloats();
	        miniFloatFromString("10101001");
	    }

	    private static float miniFloatFromString(String bitSequence){
	        // Task1: compute the miniFloat value from "bitSequence";
		float x=1;
		float c2=1;
		int i=1;
		int c=0;
		if(bitSequence.charAt(0)!='0')
		{
			x *= -1;
		}
		while (i<5 && i>0)
		{
			if (bitSequence.charAt(i)!='0')
			{
				c += (int)Math.pow(2,(4-i));
			}
			i++;
		}
		while (i<8 && i>=5)
		{
			if (bitSequence.charAt(i)!='0')
				c2 += (float)Math.pow(0.5,(i-4));
			i++;
		}
		return (x*((int)Math.pow(2,c))*c2);

	    }

	    private static void printIntegralMiniFloats(){
	        String[] bitSequences = getValidMiniFloatBitSequences();
	        // Task 2: print all the miniFloat values that are integer;
	    }

	    /**
	     * Get all valid bit sequences for miniFloat values.
	     */
	    private static String[] getValidMiniFloatBitSequences(){
	        int nbrValues = (int)Math.pow(2, MINI_FLOAT_SIZE);
	        int total=0;
	        String[] result = new String[nbrValues];
	        for(int i = 0; i < nbrValues; i++){

	            String full = String.format("%" + Integer.SIZE + "s", Integer.toBinaryString(i))
	                    .replace(' ', '0');
	            result[i] = full.substring(Integer.SIZE - MINI_FLOAT_SIZE, Integer.SIZE);
	            if ((miniFloatFromString(result[i]))==(int)(miniFloatFromString(result[i])))
	            	System.out.println(result[i]+" == "+(int)miniFloatFromString(result[i]));
	            	total+=1;
	        }
	        System.out.println("Total number of integral miniFloat values: " + total);
	        return result;
	    }

	    private static int MINI_FLOAT_SIZE = 8;

}
