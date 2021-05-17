import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class Launcher {

    public static void main(String[] args) {
        System.out.println("Bienvenue les Kheys");
        Scanner scanIn = new Scanner(System.in);

        System.out.println("Command : quit -> arrete le programme | fibo");

        String line = scanIn.nextLine();

        while (!"quit".equals(line))
        {
            switch (line) {
                case "fibo":
                    fibo(scanIn);
                    break;
                case "freq":
                    freq(scanIn);
                    break;
                default:
                    System.out.println("Unknown command");
            }
            line = scanIn.nextLine();
        }
    }

    public static void fibo(Scanner scanIn)
    {
        int nbr1=0;
        int nbr2=1;
        int nbr3=0;
        System.out.println("Donnez un chiffre plus grand que 0");
        String nb = scanIn.nextLine();

        if (1 == parseInt(nb))
        {
            System.out.println("1");
        }
        else
        {
            int i;

            for (i = 2; i <= parseInt(nb); ++i) {
                nbr3 = nbr1 + nbr2;
                nbr1 = nbr2;
                nbr2 = nbr3;
            }
            System.out.println(nbr3);
        }
    }

    public static void freq(Scanner scanIn)
    {
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

            //countByWord.entrySet().stream().sorted(Comparator.<Map.Entry<String, Long>, Long>comparing());

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
