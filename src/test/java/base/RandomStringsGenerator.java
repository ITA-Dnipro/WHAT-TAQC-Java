package base;

import java.util.Random;

public class RandomStringsGenerator {

    private final int LEFT_LIMIT_UPPERCASE = 65; // letter 'A'
    private final int RIGHT_LIMIT_UPPERCASE = 90; // letter 'Z'
    private final int LEFT_LIMIT_LOWERCASE = 97; // letter 'a'
    private final int RIGHT_LIMIT_LOWERCASE = 122; // letter 'z'
    private Random random = new Random();

    public String getAlphabeticStringLowerCase(int stringLength) {
        String generatedString = random.ints(LEFT_LIMIT_LOWERCASE, RIGHT_LIMIT_LOWERCASE + 1)
                .limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    public String getAlphabeticStringFirstUppercaseLetter(int stringLength) {
        StringBuilder upperCaseCharacter =
                random.ints(LEFT_LIMIT_UPPERCASE, RIGHT_LIMIT_UPPERCASE + 1)
                .limit(1)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);

        StringBuilder lowerCaseCharacters =
                random.ints(LEFT_LIMIT_LOWERCASE, RIGHT_LIMIT_LOWERCASE + 1)
                .limit(stringLength - 1)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);

        String generatedString = upperCaseCharacter.append(lowerCaseCharacters).toString();
        return generatedString;
    }
}
