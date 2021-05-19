import java.util.Scanner;

public class Quit implements Command {
    @Override
    public String name() {
        return "quit";
    }

    @Override
    public Boolean run(Scanner scanIn) {
        return true;
    }
}
