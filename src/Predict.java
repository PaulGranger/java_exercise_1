import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Predict implements Command{
    @Override
    public String name() {
        return "predict";
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

            Map<String, String> wordsAndRef = new HashMap<>();
            int i = 0;
            for (; i < contentSlit.length; i++)
            {
                getWordAndOccuration(contentSlit, contentSlit[i]);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    private void getWordAndOccuration(String[] words, String word) {
        HashMap<String, Integer> maps = new HashMap<>();

        int i = 0;
        for (; i < words.length; ++i) {
            if (words[i].equals(word)) {
                if (maps.get(words[i]) != null) {
                    if (maps.get(words[i+1]) != null) {
                        int nb = maps.get(words[i + 1]) + 1;
                        maps.put(words[i + 1], nb);
                    }
                }
                else
                {
                    maps.put(words[i], 1);
                }
            }
        }

        for (Map.Entry<String, Integer> element: maps.entrySet()) {
            String wor = element.getKey();
            Integer nb = element.getValue();
            //System.out.println(wor);
            //System.out.println(nb);
        }
    }
}
