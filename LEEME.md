Envia o recibe mensajes SysEx/MIDI en dispositivos MIDI basado en JAVA

Constructor: MIDIReconizer("nombre del dispositivo")

Metodos:

initTransmition(): Inicializar el dispositivo

sendSysEx(byte data[]): Enviar mensaje SysEx

sendMIDI(MidiMessage m): Enviar mensaje MIDI

closeAllConections(): Desconectar el dispositivo

Puedes editar la decodificacion de los mensajes SysEx en la clase MIDISender
send(MidiMessage msg, long time) 

Mediante esta bliblioteca puedes manejar dispositivos MIDI como pedales multiefectos, mezcladoras, teclados, etc.

Ejemplo:


![alt text](https://github.com/fua94/SysEx-JAVA-Library/blob/master/controller.PNG)
