package com.github.tavyy.enigma;

class Rotor implements Cypher {

    private final String name;
    private final Wheel wheel;
    private final char notch;

    private Cypher leftCypher;
    private Cypher rightCypher;
    private boolean encodingLeftDirection = true;

    Rotor(String name, char notch, Wheel wheel) {
        this.name = name;
        this.wheel = wheel;
        this.notch = notch;
    }

    @Override
    public int encode(int index) {
        if (encodingLeftDirection) {
            switchEncodingDirection();
            if (hasRightCypher()) {
                rotateOnce();
            }
            char rightLetter = this.wheel.rightLetterAt(index);
            int encodedIndex = this.wheel.leftIndexLetterOf(rightLetter);
            return this.leftCypher.encode(encodedIndex);
        } else {
            switchEncodingDirection();
            char leftLetter = this.wheel.leftLetterAt(index);
            int encodedIndex = this.wheel.rightIndexLetterOf(leftLetter);
            if (hasRightCypher()) {
                return encodedIndex;
            } else {
                return this.rightCypher.encode(encodedIndex);
            }
        }
    }

    private boolean hasRightCypher() {
        return this.rightCypher == null;
    }

    private void rotateOnce() {
        char leftLetterFromFirstRow = this.wheel.leftLetterAt(0);
        if (leftLetterFromFirstRow == notch) {
            if (this.leftCypher instanceof Rotor) {
                ((Rotor) this.leftCypher).rotateOnce();
            }
        }
        this.wheel.rotateOnce();
    }

    private void switchEncodingDirection() {
        this.encodingLeftDirection = !this.encodingLeftDirection;
    }

    void setLeftCypher(Cypher leftCypher) {
        this.leftCypher = leftCypher;
    }

    void setRightCypher(Cypher rightCypher) {
        this.rightCypher = rightCypher;
    }

    @Override
    public String toString() {
        return name;
    }
}