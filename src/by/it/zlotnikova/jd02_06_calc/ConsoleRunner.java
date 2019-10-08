package by.it.zlotnikova.jd02_06_calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();
        Logger logger = Logger.getLogger();

        while (!(line = sc.nextLine()).equals("end")) {
            try {
                Var result = parser.calc(line);
                printer.print(result);
                logger.log(line + " calculated");
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                logger.log(e.getMessage());
            }
        }
    }
}
