package com.github.tavyy.enigma;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EnigmaMachine {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final Rotor inputRotor;

    public EnigmaMachine() {
        Rotor rotor1 = new Rotor("Rotor 1", 'q', new Wheel("ekmflgdqvzntowyhxuspaibrcj", 'm'));
        Rotor rotor2 = new Rotor("Rotor 2", 'e', new Wheel("ajdksiruxblhwtmcqgznpyfvoe", 'c'));
        Rotor rotor3 = new Rotor("Rotor 3", 'v', new Wheel("bdfhjlcprtxvznyeiwgakmusqo", 'k'));
        Reflector reflector = new Reflector(rotor1);

        rotor1.setLeftCypher(reflector);
        rotor1.setRightCypher(rotor2);

        rotor2.setLeftCypher(rotor1);
        rotor2.setRightCypher(rotor3);

        rotor3.setLeftCypher(rotor2);

        this.inputRotor = rotor3;
    }

    public String encrypt(String text) {
        return Arrays.stream(text.split(" "))
                .map(word -> word.chars()
                        .map(ALPHABET::indexOf)
                        .map(inputRotor::encode)
                        .map(ALPHABET::charAt)
                        .collect(StringBuilder::new, (sb, c) -> sb.append((char) c), StringBuilder::append)
                        .toString())
                .collect(Collectors.joining(" "));
    }

}
