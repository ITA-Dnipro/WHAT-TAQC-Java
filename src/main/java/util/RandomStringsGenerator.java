package util;

import java.util.Random;

public class RandomStringsGenerator {

    private static final int LEFT_LIMIT_UPPERCASE = 65;
    private static final int RIGHT_LIMIT_UPPERCASE = 90;
    private static final int LEFT_LIMIT_LOWERCASE = 97;
    private static final int RIGHT_LIMIT_LOWERCASE = 122;
    private static final int MAX_NAME_VALUE = 30;
    private static final int MIN_NAME_VALUE = 2;
    private static final int emailLocalPathLength = 6;
    private static Random random = new Random();

    private RandomStringsGenerator() {

    }

    public static String getAlphabeticStringLowerCaseCharacters(int stringLength) {
        String generatedString = random.ints(LEFT_LIMIT_LOWERCASE, RIGHT_LIMIT_LOWERCASE + 1)
                .limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    public static String getAlphabeticStringFirstUppercaseCharacters(int stringLength) {
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

    public static String getRandomEmail(int localPartLength, String domain) {
        String email = getAlphabeticStringLowerCaseCharacters(localPartLength) + "@" + domain;
        return email;
    }

    public static String getRandomEmail() {
        String email = getAlphabeticStringLowerCaseCharacters(emailLocalPathLength) + "@what.com";
        return email;
    }

    public static String getRandomName() {
        Integer numberSymbols = random.nextInt(MAX_NAME_VALUE - MIN_NAME_VALUE) + MIN_NAME_VALUE;
        return getAlphabeticStringFirstUppercaseCharacters(numberSymbols);
    }
}
