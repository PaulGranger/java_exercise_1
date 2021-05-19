import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toUnsignedLong;

public class Launcher {

    public static void main(String[] args) {

        List<Command> commands = List.of(
                new Freq(),
                new Fibo(),
                new Quit(),
                new Predict()
        );

        System.out.println("Bienvenue les Kheys");
        Scanner scanIn = new Scanner(System.in);

        System.out.println("Command : quit -> arrete le programme | fibo");

        String line;

        Boolean bool = false;
        boolean enter;

        do {
            line = scanIn.nextLine();
            enter = false;
            //Optional<Command> potentialCommand = commands.stream().filter(c -> c.name().equals(line)).findFirst();
            for (Command command : commands) {
                if (command.name().equals(line)) {
                    bool = command.run(scanIn);
                    enter = true;
                }
            }
            if (!enter) {
                System.out.println("Unknown command");
            }
        }
        while (bool.equals(false));

    }
}
