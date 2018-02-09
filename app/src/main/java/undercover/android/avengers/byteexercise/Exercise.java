package undercover.android.avengers.byteexercise;

public class Exercise {
	private byte[] inputArray;

	public Exercise(byte a, byte b){
		inputArray = new byte[2];
		inputArray[0] = a;
		inputArray[1] = b;
	}

	public ConnectionStatus getStatus(){
		return new ConnectionStatus(combineByteArrays(
						this.extractBits(inputArray[0]),
						this.extractBits(inputArray[1])));
	}

	private byte[] extractBits(byte subject) {
		byte[] bits = new byte[8];
		
		for(int i = 0; i < bits.length; i++) {
			byte currentBit = (byte) (subject & 1);
			if(currentBit != 0) bits[i] = 1;
			subject >>= (byte) 1;
		}
		
		return bits;
	}

	private byte[] combineByteArrays(byte[] a, byte[] b){
		byte[] statusArray = new byte[16];
		for(int i = 0; i < 8; i++) {
			statusArray[i] = a[i];
			statusArray[i + 8] = b[i];
		}
		return statusArray;
	}

}
