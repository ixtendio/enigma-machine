package com.github.tavyy.enigma;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnigmaMachineTest {

    private EnigmaMachine enigmaMachine = new EnigmaMachine();

    @Test
    public void testEncryption() {
        //GIVEN
        var originalText = "enigma revealed";
        var expectedEncryptedText = "qmjido mzwzjfjr";

        //WHEN
        var result = enigmaMachine.encrypt(originalText);

        //THEN
        assertThat(result).isEqualTo(expectedEncryptedText);
    }

    @Test
    public void testDecryption() {
        //GIVEN
        var encryptedText = "qmjido mzwzjfjr";
        var expectedOriginalText = "enigma revealed";

        //WHEN
        var result = enigmaMachine.encrypt(encryptedText);

        //THEN
        assertThat(result).isEqualTo(expectedOriginalText);
    }
}
