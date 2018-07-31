# SysEx-JAVA-Library
Send or Recieve SysEx/MIDI messages for any MIDI Device implemented in JAVA

Constructor:
MIDIReconizer("name of device")

Methods: 

1. initTransmition(): Inizialize device 
	
2. sendSysEx(byte data[]): Send SysEx message

3. sendMIDI(MidiMessage m): Send MIDI message
	
4. closeAllConections(): Disconnect device

You can edit class MIDISender to custom Receiver to decode SysEx messages.

send(MidiMessage msg, long time) 

Through this library you can handle MIDI devices such as multi-effect pedals, mixers, keyboards, etc.

Example:

![alt text](https://github.com/fua94/SysEx-JAVA-Library/blob/master/controller.PNG)
