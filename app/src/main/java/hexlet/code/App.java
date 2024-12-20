package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.Map;
import java.util.concurrent.Callable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")

class App implements Callable<Integer> {
    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private String filepath1;
    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]", paramLabel = "format",
            defaultValue = "stylish")
    private String format;

    /*@Option(names = { "-h", "--help" }, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;*/

    @Override
    public Integer call() throws Exception {
        Path writeFilePath1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path writeFilePath2 = Paths.get(filepath2).toAbsolutePath().normalize();
        String content1 = Files.readString(writeFilePath1);
        String content2 = Files.readString(writeFilePath2);
        //System.out.println(content1);
        //System.out.println(content2);
        ObjectMapper map = new ObjectMapper();
        Map<String, Object> data1 = map.readValue(content1, Map.class);
        //System.out.println(data1);
        Map<String, Object> data2 = map.readValue(content2, Map.class);
        //System.out.println(data2);
        System.out.println(Differ.generate(data1, data2));
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
