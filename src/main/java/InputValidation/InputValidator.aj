package InputValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Christoph on 07.04.2018.
 */
public aspect InputValidator {

    private Pattern pattern;
    private final String patternString = "[a-zA-Z0-9@;\\/$.]*";

    pointcut myPointcut(String argument):   execution(* Car.set*(String))
                                            && args(argument);

    before (String argument): myPointcut(argument) {
        Matcher matcher;

        if (pattern == null) {
            pattern = Pattern.compile(patternString);
        }
        if (argument == null) {
            throw new IllegalArgumentException("Argument is NULL!");
        }
        matcher = pattern.matcher(argument);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid symbols in Argument!");
        }
    }
}
