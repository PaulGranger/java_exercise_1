import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Fibo implements Command{
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public Boolean run(Scanner scanIn) {
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
        return false;
    }
}
