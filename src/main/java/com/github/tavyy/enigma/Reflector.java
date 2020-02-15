package com.github.tavyy.enigma;

class Reflector implements Cypher {

    private final String letters = "abcdefgdijkgmkmiebftcvvjat";
    private final Rotor rotor;

    Reflector(Rotor rotor) {
        this.rotor = rotor;
    }

    @Override
    public int encode(int index) {
        int reflectedIndex = getReflectedCharIndex(index);
        return rotor.encode(reflectedIndex);
    }

    private int getReflectedCharIndex(int index) {
        char letter = letters.charAt(index);
        int firstLetterIndex = letters.indexOf(letter);
        int lastLetterIndex = letters.lastIndexOf(letter);
        return index == firstLetterIndex ? lastLetterIndex : firstLetterIndex;
    }

}