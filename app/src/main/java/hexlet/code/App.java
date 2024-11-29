package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")
/*public class App {
    //public static void main(String[] args) {
        //System.out.println("Hello World!");
*/

public class App implements Runnable {
    @Override
    public void run() {
        // The business logic of the command goes here...
        // In this case, code for generation of ASCII art graphics
        // (omitted for the sake of brevity).
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
            System.exit(exitCode);
    }
}

