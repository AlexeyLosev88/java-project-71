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
    @Parameters(paramLabel = "filepath1", index = "0", description = "path to first file")
    private File filepath1;
    @Parameters(paramLabel = "filepath2", index = "0", description = "path to second file")
    private File filepath2;

    @Option(paramLabel = "format", names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format = "stylish";

    /*@Option(names = { "-h", "--help" }, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;*/



    @Override
    public void run() {
        // The business logic of the command goes here...
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
            System.exit(exitCode);
    }
}

