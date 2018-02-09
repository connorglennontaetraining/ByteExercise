package undercover.android.avengers.byteexercise;

import android.util.Log;

import java.util.Arrays;

public class Exercise {
	private byte[] inputArray;
	private byte[] statusArray;

	public Exercise(byte a, byte b){
		inputArray = new byte[2];
		inputArray[0] = a;
		inputArray[1] = b;
	}

	public ConnectionStatus getStatus(){
		ConnectionStatus connectionStatus = new ConnectionStatus();

		combineByteArrays(this.extractBits(inputArray[0]), this.extractBits(inputArray[1]));
		connectionStatus.setSlavePuckConnected(this.getPuckStatus());
		connectionStatus.setGpsConnected(this.getGpsStatus());
		connectionStatus.setHrmConnected(this.getHrmStatus());

		connectionStatus.setSessionStatus(this.getSessionStatus());
		connectionStatus.setRunProfile(this.getRunProfile());

		return connectionStatus;
	}

	private String getRunProfile() {
		byte[] concatees = Arrays.copyOfRange(statusArray, 6, 10);
		switch(concatBytes(concatees)){
			case 1:
				return "quickRun";
			default:
				return "Something else";
		}
	}

	private SessionStatus getSessionStatus() {
		byte[] status = Arrays.copyOfRange(statusArray, 3, 5);
		switch(concatBytes(status)){
			case 0:
				return SessionStatus.IDLE;
			case 1:
				return SessionStatus.IN_SESSION;
			case 2:
				return SessionStatus.UNNAMED_1;
			case 3:
				return SessionStatus.UNNAMED_2;
		}
		// Just because
		return SessionStatus.IDLE;
	}

	private byte concatBytes(byte[] array){
		byte result = 0;
		for(int i = 0; i < array.length; i++){
			Log.i(this.getClass().getSimpleName(), "b" + result);
			result += array[i] * Math.pow(2, i);
			Log.i(this.getClass().getSimpleName(), "a" + result);
		}
		return result;
	}

	private boolean getHrmStatus() {
		return statusArray[2] == 1;
	}

	private boolean getGpsStatus() {
		return statusArray[1] == 1;
	}

	private boolean getPuckStatus() {
		return statusArray[0] == 1;
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

	private void combineByteArrays(byte[] a, byte[] b){
		statusArray = new byte[16];
		for(int i = 0; i < 8; i++) {
			statusArray[i] = a[i];
			statusArray[i + 8] = b[i];
		}
	}

}
