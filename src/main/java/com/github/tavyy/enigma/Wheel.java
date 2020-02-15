package com.github.tavyy.enigma;

class Wheel {

    private final String leftLettersGradation = "abcdefghijklmnopqrstuvwxyz";
    private final String rightLettersGradation;
    private final int lettersCount = leftLettersGradation.length();

    private String leftLetters;
    private String rightLetters;
    private int rotatedPosition;

    Wheel(String rightLettersGradation, char firstRowLeftLetter) {
        this.rightLettersGradation = rightLettersGradation;
        this.rightLetters = rightLettersGradation;
        this.leftLetters = leftLettersGradation;
        rotate(leftLettersGradation.indexOf(firstRowLeftLetter));
    }

    void rotateOnce() {
        rotate(1);
    }

    private void rotate(int positions) {
        int rotateWith = (rotatedPosition + positions) % lettersCount;
        if (rotateWith != rotatedPosition) {
            this.leftLetters = rotateLetters(leftLettersGradation, rotateWith);
            this.rightLetters = rotateLetters(rightLettersGradation, rotateWith);
            this.rotatedPosition = rotateWith;
        }
    }

    char leftLetterAt(int index) {
        return this.leftLetters.charAt(index);
    }

    int leftIndexLetterOf(char c) {
        return this.leftLetters.indexOf(c);
    }

    char rightLetterAt(int index) {
        return this.rightLetters.charAt(index);
    }

    int rightIndexLetterOf(char c) {
        return this.rightLetters.indexOf(c);
    }

    private String rotateLetters(String letters, int rotateWith) {
        return (letters + letters).substring(rotateWith, rotateWith + lettersCount);
    }

}
