package MIDIController;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;

public class MIDIDetector {
	private String name;
	
	public MIDIDetector(String n){
		name = n;
	}
	
	public void getMIDIDevices(){
		System.out.println("TX: " + getAllDeviceNames(true, false));
	    System.out.println("RX: " + getAllDeviceNames(false, true));
	}
	
	public MidiDevice getMidiDevice(boolean tx, boolean rx) throws MidiUnavailableException{
		MidiDevice device = null;
		MidiDevice.Info[] devices = MidiSystem.getMidiDeviceInfo();

		for (MidiDevice.Info info : devices){
			if(info.getName().equals(name)){
				try {
		    		MidiDevice aux = MidiSystem.getMidiDevice(info);
		    		
		    		boolean canRX = aux.getMaxTransmitters() != 0;
		    		boolean canTX = aux.getMaxReceivers() != 0;
		    		
		    		if (tx && canTX || rx && canRX)
		    			device = MidiSystem.getMidiDevice(info);
		    		
		    	} catch (MidiUnavailableException ex) {
		    		//TODO Devices not found
		    		System.exit(0);
		    	}
			}
	    }
		
		return device;
	}
	
	public boolean isConnected(){
		boolean r = false;
		MidiDevice.Info[] devices = MidiSystem.getMidiDeviceInfo();

	    for (MidiDevice.Info info : devices){
	    	if (info.getName().equals(name))
				r = true;
	    }
	    
	    return r;
	}
	
	public List<String> getAllDeviceNames(boolean tx, boolean rx) {
	    List<String> deviceNames = new ArrayList<>();
	    MidiDevice.Info[] devices = MidiSystem.getMidiDeviceInfo();
	    
	    for (MidiDevice.Info info : devices) {
	    	try {
	    		MidiDevice device = MidiSystem.getMidiDevice(info);
	    		boolean canRX = device.getMaxTransmitters() != 0;
	    		boolean canTX = device.getMaxReceivers() != 0;
	    		
	    		if (tx && canTX || rx && canRX)
	    			deviceNames.add(info.getName());
	    	} catch (MidiUnavailableException ex) {
	    		//TODO Devices not found
	    		System.exit(0);
	    	}
	    }
	    
	    return deviceNames;
	}
}
