package br.pro.hashi.ensino.desagil.aps.model;

public class And3Gate extends Gate {
    private final NandGate nandLeft;
    private final NandGate nandMidLeft;
    private final NandGate nandMidRight;
    private final NandGate nandRight;

    public And3Gate() {
        super("AND3", 3);

        nandLeft = new NandGate();
        nandMidLeft = new NandGate();
        nandMidRight = new NandGate();
        nandRight = new NandGate();
        nandMidLeft.connect(0, nandLeft);
        nandMidLeft.connect(1, nandLeft);
        nandMidRight.connect(0,nandMidLeft);
        nandRight.connect(0,nandMidRight);
        nandRight.connect(1,nandMidRight);
    }

    @Override
    public boolean read() {
        return nandRight.read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        switch (inputIndex) {
            case 0:
                nandLeft.connect(0, emitter);
                break;
            case 1:
                nandLeft.connect(1, emitter);
                break;
            case 2:
                nandMidRight.connect(1,emitter);
                break;
            default:
                throw new IndexOutOfBoundsException(inputIndex);
    }
}}