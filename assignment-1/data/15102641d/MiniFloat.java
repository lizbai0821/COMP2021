//15102641d
//Wan Qinyu

public class MiniFloat {
    public static void main(String[] args){
		// Task 2: print all the miniFloat values that are integer;
		String[] bitSequences = getValidMiniFloatBitSequences();
		String bitSequence;
		int counter = 0;

		for(int i = 0;i<((int)Math.pow(2, MINI_FLOAT_SIZE));i++){
			bitSequence = bitSequences[i];
			float compare = miniFloatFromString(bitSequence);

			if ((compare% 1) == 0) {
				counter++;
				System.out.println(bitSequence + " == " + (int) miniFloatFromString(bitSequence));
			}

		}
		System.out.println("Total number of integral miniFloat values: "+counter);
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
		int[] bitArray = new int[8];
		float result = 0;
		//System.out.println(bitArray);

		//for each bitSequence
		for (int j=0;j<8;j++){
			bitArray[j] = Integer.parseInt(String.valueOf(bitSequence.charAt(j)));
			//System.out.println(bitArray[j]);
			//System.out.println(bitSequence.charAt(j));
		}
		int exponent;
		//calculate exponent
		//if positive, compute directly; else, calculate correlative 2's complement
		if (bitArray[1] == 0){
			exponent = 8*bitArray[1] + 4*bitArray[2] + 2*bitArray[3] + 1*bitArray[4];
		}
		else{
			for (int h = 1; h<=4; h++){
				if (bitArray[h] == 1){
					bitArray[h] = 0;
				}
				else{
					bitArray[h]=1;
				}
			}
			exponent = 0 - (8*bitArray[1] + 4*bitArray[2] + 2*bitArray[3] + 1*bitArray[4] + 1);
		}
		float mantissa = 0.5f*bitArray[5] + 0.25f*bitArray[6] + 0.125f*bitArray[7];

		float significand = 1 + mantissa;

		result = significand * (float)Math.pow(2,exponent);

		if (bitArray[0] == 1) {
			result = 0 - result;
		}


		return result;
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

/*
    private static String printIntegralMiniFloats(){
		// Task 2: print all the miniFloat values that are integer;
		String[] bitSequences = getValidMiniFloatBitSequences();
		String bitSequence;
		int counter = 0;

		for(int i = 0;i<((int)Math.pow(2, MINI_FLOAT_SIZE));i++){
			bitSequence = bitSequences[i];
			float compare = miniFloatFromString(bitSequence);

			if ((compare% 1) == 0) {
				counter++;
				System.out.println(bitSequence + " == " + (int) miniFloatFromString(bitSequence));
			}

		}
		System.out.println("Total number of integral miniFloat values: "+counter);

    }
	*/
