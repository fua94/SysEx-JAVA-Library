package Main;

import MIDIController.*;

public class Test {
	public static void main(String[] args) {
		new MIDIDetector(null).getMIDIDevices();
		
		MIDIReconizer device = new MIDIReconizer("ZOOM G Series");
		device.initTransmition();
		byte[] testmessage ={
				(byte)0xF0, (byte)0x52, (byte)0x00, 
				(byte)0x5A, (byte)0x50, (byte)0xF7,
				(byte)0xF0, (byte)0x52, (byte)0x00, 
				(byte)0x5A, (byte)0x16, (byte)0xF7				
		};
		device.sendSysEx(testmessage);
		device.closeAllConections();
	}

}
