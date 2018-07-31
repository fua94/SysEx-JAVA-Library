package MIDIController;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.SysexMessage;

public class MIDIReceiver {
	private MidiDevice rx;
	private Receiver r;
	private MIDIDetector device;
	
	public MIDIReceiver(String name) {
		device = new MIDIDetector(name);
		setSender();
	}

	private void setSender(){
		rx = null;
		r = null;
	    MidiDevice d = null;
	    
	    try {
		    d = device.getMidiDevice(true, false);
			d.open();
	        r = d.getReceiver();
		} catch (MidiUnavailableException e) {
			//TODO MIDI DEVICE NOT FOUND
		}
    	rx = d;
	}
	
	public boolean sendMessage(byte data[]){
		boolean ret = false;
		
		if ( rx != null ){
			try{
				rx.open();
				SysexMessage sm = new SysexMessage();
				sm.setMessage(data, data.length );
				if(device.isConnected()){
					//Send Methods
					System.out.println("Bytes send : "+data.length); //you can omit
					r.send(sm, -1);	
					ret = true;
				}
	        }
	        catch( MidiUnavailableException e )
	        {
	        	//TODO MIDI DEVICE NOT FOUND
	        	rx.close();
	        }
			catch( InvalidMidiDataException e )
	        {
	        	//TODO INVALID MIDI MESSAGE
	        	rx.close();
	        }
		}
		return ret;
	}
	
	public boolean sendMessage(MidiMessage m){
		boolean ret = false;
		
		if ( rx != null ){
			try{
				rx.open();
				if(device.isConnected()){
					r.send(m, -1);	
					ret = true;
				}
	        }
	        catch( MidiUnavailableException e )
	        {
	        	//TODO MIDI DEVICE NOT FOUND
	        	rx.close();
	        }
		}
		return ret;
	}
	
	public void close(){
		rx.close();
		r.close();
	}
}
