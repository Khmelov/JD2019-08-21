package by.it.boytsov.jd02_04;
import java.util.Scanner;

public class ConsoleRunner
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer= new Printer();

        while (!(line=scanner.nextLine()).equals("end"))
        {
            if ((line.equals("printVar")))
            {
                Var.printVar();
                continue;
            }
            Var result = parser.calculateExpression(line);
            printer.print(result);
        }
    }
}
