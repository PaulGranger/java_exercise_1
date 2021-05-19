import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Freq implements Command{
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public Boolean run(Scanner scanIn) {
        System.out.println("Donnez le path d'un fichier txt");
        String path = scanIn.nextLine();
        Path filePath = Paths.get(path);

        try
        {
            String content = Files.readString(filePath);

            content = content.replaceAll("[, .;]", " ");
            String[] contentSlit = content.split("\\s+");

            Stream<String> stream = Arrays.stream(contentSlit);

            Map<String, Long> countByWord = stream.filter(s -> !s.isBlank()).map(String::toLowerCase).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            Comparator<Map.Entry<String, Long>> countReversed = Comparator.<Map.Entry<String, Long>, Long>comparing(e -> e.getValue()).reversed();

            String threeMostOccuringWords = countByWord.entrySet().stream()
                    .sorted(countReversed)
                    .limit(3)
                    .map(e -> e.getKey())
                    .collect(Collectors.joining(" "));

            System.out.println(threeMostOccuringWords);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
