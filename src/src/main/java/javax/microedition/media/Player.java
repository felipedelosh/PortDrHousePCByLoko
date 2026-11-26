package javax.microedition.media;

import javax.sound.midi.*;
import javax.microedition.media.control.VolumeControl;

public final class Player {

    private final Sequence sequence;

    private Sequencer sequencer;
    private Synthesizer synthesizer;
    private Receiver receiver;

    private int loops = 1;
    private int volume = 100;

    private final VolumeControl volumeControl = this::setVolume;

    Player(Sequence s) {
        sequence = s;
    }

    public void realize() throws Exception {

        if (sequencer == null) {

            try {

                synthesizer = MidiSystem.getSynthesizer();
                synthesizer.open();

                receiver = synthesizer.getReceiver();

                sequencer = MidiSystem.getSequencer(false);
                sequencer.open();
                sequencer.setSequence(sequence);

                sequencer.getTransmitter().setReceiver(receiver);

                applyVolume();

            } catch (Exception e) {
                close();
                throw e;
            }
        }
    }

    public void prefetch() throws Exception {
        realize();
    }

    public void setLoopCount(int n) {
        loops = n;
    }

    public long setMediaTime(long t) {

        if (sequencer != null) {
            sequencer.setMicrosecondPosition(Math.max(0, t));
        }

        return Math.max(0, t);
    }

    public void start() throws Exception {

        realize();

        sequencer.setLoopCount(
            loops < 0 ? Sequencer.LOOP_CONTINUOUSLY : loops - 1
        );

        sequencer.start();

        applyVolume();
    }

    private int setVolume(int level) {

        volume = Math.max(0, Math.min(level, 100));

        applyVolume();

        return volume;
    }

    private void applyVolume() {

        if (receiver == null) {
            return;
        }

        // MIDI MASTER VOLUME
        int midiVolume = volume * 16383 / 100;

        try {

            SysexMessage message = new SysexMessage();

            byte[] data = {
                (byte) 0xF0,
                (byte) 0x7F,
                (byte) 0x7F,
                (byte) 0x04,
                (byte) 0x01,
                (byte) (midiVolume & 0x7F),
                (byte) ((midiVolume >> 7) & 0x7F),
                (byte) 0xF7
            };

            message.setMessage(data, data.length);

            receiver.send(message, -1);

            System.out.println("[MIDI] Master volume: " + volume + "%");

        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    public void close() {

        if (sequencer != null) {
            sequencer.close();
            sequencer = null;
        }

        if (receiver != null) {
            receiver.close();
            receiver = null;
        }

        if (synthesizer != null) {
            synthesizer.close();
            synthesizer = null;
        }
    }

    public Object getControl(String name) {

        if ("VolumeControl".equals(name)) {
            return volumeControl;
        }

        return null;
    }
}
