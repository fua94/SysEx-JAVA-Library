package MIDIController;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;

public class MIDISender {
	private MidiDevice tx;
	private static MIDIDetector device;
	
	public MIDISender(String name) {
		device = new MIDIDetector(name);
		setReceiver();
	}
	
	static class customReciever implements Receiver {	
		@Override
		public void send(MidiMessage msg, long time) {
			//TODO Decode methods
			if(device.isConnected())
				System.out.println("Bytes recieved: "+msg.getLength()); //you can omit
		}

		@Override
		public void close() {}
	}
	
	private void setReceiver(){
		tx = null;
	    MidiDevice d = null;
	    
	    try{
	        d = device.getMidiDevice(false, true);
	        d.open();
        }
        catch(MidiUnavailableException e)
        {
        	//TODO MIDI DEVICE NOT FOUND
        	d.close();
        }
    	tx = d;
	}
	
	public boolean initTransmition(){
		boolean ret = false;
		if ( tx != null ){
			try{
				tx.getTransmitter().setReceiver(new customReciever());
				ret = true;
	        }
	        catch( MidiUnavailableException e )
	        {
	        	//TODO MIDI DEVICE NOT FOUND
	        	tx.close();
			}
		}
		return ret;
	}
	
	public void endTransmition(){
		tx.close();
	}
}
