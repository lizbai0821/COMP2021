
public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
    	float ans1 = 0;
    	
		if(bitSequence.charAt(1)== '1'){
			for (int x1=1;x1<5;x1++){
				if(bitSequence.charAt(x1)== '1')
					bitSequence.replace("1", "0");
				else
					bitSequence.replace("0", "1");
			}
			for (int x2=2; x2<5;x2++){
				if(bitSequence.charAt(x2)== '1')
					ans1 += (float) Math.pow(2, 4-x2);
			}
			ans1 = (ans1 + 1) * -1;
			ans1 = (float) Math.pow(2, ans1);
		}
		else{
			for(int i=2;i<5;i++){
				if(bitSequence.charAt(i)== '1')
					ans1 += (float) Math.pow(2, 4-i);
			}
			ans1 = (float) Math.pow(2, ans1);
		}

    	float ans2 = 1;
  
    	for(int y=5;y<8;y++){
    		   if(bitSequence.charAt(y)== '1')
    		   ans2 += (float) Math.pow(2, 4-y);
    	}

    	float fans = ans1 * ans2;
    	
    	if (bitSequence.charAt(0) == '1')
    		fans *= -1;
    	
    	return fans;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count = 0;
        // Task 2: print all the miniFloat values that are integer;
        for(int x = 0; x < 256; x++){
        	float solution = miniFloatFromString(bitSequences[x]);
        	if (solution - (int) solution == 0){
        		System.out.print(bitSequences[x]);
        		System.out.print(" == ");
        		System.out.println((int) solution);
        		count += 1;
        	}
        }
        System.out.print("Total number of integral miniFloat values: ");
        System.out.println(count);
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
