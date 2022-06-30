package de.celinadev.pterobot.util;

public class LogUtil {

    public static void log(String prefix, String s) {
        System.out.println("[" + AnsiColors.BLUE + prefix + AnsiColors.RESET + "] " + AnsiColors.GREEN + s);
    }

    public static void warn(String prefix, String s) {
        System.out.println("[" + AnsiColors.BLUE + prefix + AnsiColors.RESET + "] " + AnsiColors.YELLOW + s);
    }

    public static void error(String prefix, String s) {
        System.out.println("[" + AnsiColors.BLUE + prefix + AnsiColors.RESET + "] " + AnsiColors.RED + s);
    }

    public static void error(String prefix, String s, String... errorLines) {
        System.out.println("[" + AnsiColors.BLUE + prefix + AnsiColors.RESET + "] " + AnsiColors.RED + s);
        for (String s1 : errorLines)
            System.out.println("[" + AnsiColors.BLUE + prefix + AnsiColors.RESET + "] " + "[" + AnsiColors.RED + "STACKTRACE" + AnsiColors.RESET + "] " + AnsiColors.RED + s1);
    }
}
