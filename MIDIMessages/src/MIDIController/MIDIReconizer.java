package MIDIController;

import javax.sound.midi.MidiMessage;

public class MIDIReconizer {
	private MIDISender tx;
	private MIDIReceiver rx;
	
	public MIDIReconizer(String n){
		rx = new MIDIReceiver(n);
		tx = new MIDISender(n);
	}
	
	public void initTransmition(){
		if(!tx.initTransmition()){
			//Device not found
			closeAllConections();
		}
	}
	
	public void sendSysEx(byte data[]){
		if(!rx.sendMessage(data)){
			//Sending SysEx message failed
			closeAllConections();
		}
	}
	
	public void sendMIDI(MidiMessage m){
		if(!rx.sendMessage(m)){
			//Sending MIDI message failed
			closeAllConections();
		}
	}
	
	public void closeAllConections(){
		rx.close();
		tx.endTransmition();
		System.exit(0);
	}
}
