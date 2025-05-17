package prog_lab34.argparser;

import java.util.Map;
import java.util.HashMap;

public class ArgParser {
    private Map<String, String> arguments = new HashMap<>();

    public ArgParser(String[] args) {
        parseArgs(args);
        validateArguments();
    }

    private void parseArgs(String[] args) {
        for (String arg : args) {
            if (arg.startsWith("--")) {
                String[] parts = arg.substring(2).split("=", 2);

                if (parts.length == 2) {
                    arguments.put(parts[0], parts[1]);
                } else {
                    arguments.put(parts[0], "");
                }
            } else if (arg.startsWith("-")) {
                String[] parts = arg.substring(1).split("=", 2);

                if (parts.length == 2) {
                    arguments.put(parts[0], parts[1]);
                } else {
                    arguments.put(parts[0], "");
                }
            }
            
        }
    }

    public String getArgument(String key) {
        return arguments.get(key);
    }

    public Map<String, String> getAllArguments() {
        return arguments;
    }

    private void validateArguments() {
        if (!arguments.containsKey("provider") && !arguments.containsKey("p")) {
            throw new IllegalArgumentException("[Error] A required argument was not passed: provider or p.");
        }

        String providerValue = arguments.get("provider");
        String shortProviderValue = arguments.get("p");

        if (providerValue != null && !isValidProvider(providerValue)) {
            throw new IllegalArgumentException("[Error] The value for --provider should be 'config' or 'simple'.");
        }

        if (shortProviderValue != null && !isValidShortProvider(shortProviderValue)) {
            throw new IllegalArgumentException("[Error] The value for --p should be 'c' or 's'.");
        }

        if ("config".equals(providerValue) || "c".equals(shortProviderValue)) {
            if (!arguments.containsKey("input") && !arguments.containsKey("i")) {
                throw new IllegalArgumentException("[Error] The 'path' argument must be provided when 'config' is specified.");
            }
        }

        
    }

    private boolean isValidProvider(String value) {
        return value.equals("config") || value.equals("simple");
    }

    private boolean isValidShortProvider(String value) {
        return value.equals("c") || value.equals("s");
    }
}
