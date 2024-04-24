package com.counteer.wordprovider.wordgenerator;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HungarianWordGenerator implements WordGenerator {
    private static final Random random = new Random();

    private static final String[] vowels = {"a", "e", "i", "o", "u", "á", "é", "í", "ó", "ö", "ő", "ú", "ü", "ű"};
    private static final String[] consonants = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "r", "s", "t", "v", "z", "zs"};


    @Override
    public String generateWord() {
        StringBuilder word = new StringBuilder();
        int wordLength = random.nextInt(8) + 3;

        // Generate first syllable
        word.append(getRandomElement(consonants));
        word.append(getRandomElement(vowels));


        while (word.length() < wordLength) {
            if (random.nextBoolean()) {
                word.append(getRandomElement(consonants));
                word.append(getRandomElement(vowels));
            } else {
                word.append(getRandomElement(vowels));
                word.append(getRandomElement(consonants));
            }
        }

        return word.toString();
    }

    private static String getRandomElement(String[] array) {
        return array[random.nextInt(array.length)];
    }
}
