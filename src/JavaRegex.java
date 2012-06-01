
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

public class JavaRegex {

            public static final String EXAMPLE_TEST = "opsware-agent-50.33.9-aix.zip";
            public static void main(String[] args) {
                Pattern pattern = Pattern.compile("opsware-agent-([^-]+)-.*");

                    //Pattern pattern = Pattern.compile("opsware-agent-(*).*");
                    // In case you would like to ignore case sensitivity you could use this
                    // statement
                    // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(EXAMPLE_TEST);
                    // Check all occurance
                    while (matcher.find()) {
                            System.out.print("Start index: " + matcher.start());
                            System.out.print(" End index: " + matcher.end() + " ");
                            System.out.println(matcher.group());
                    }

            }


}
