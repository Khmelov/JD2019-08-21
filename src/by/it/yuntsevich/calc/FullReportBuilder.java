package by.it.yuntsevich.calc;

import java.io.*;

public class FullReportBuilder extends ReportBuilder {

    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = Var.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + "operationsAndResults.txt";
    }

    @Override
    public void buildName() {
        report.setName("----------Full Report----------");
    }

    @Override
    public void buildStartTime() {
        report.setStartTime(ConsoleRunner.start.toString().replace("MSK 2019", ""));
    }

    @Override
    public void buildOperationsAndResults() {
        StringBuilder operations = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(getFileName()))) {
            while (br.ready()){
                operations.append(br.readLine());
                operations.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        report.setOperationsAndResults(operations.toString());
    }

    @Override
    public void buildFinishTime() {
        report.setFinishTime(ConsoleRunner.finish.toString().replace("MSK 2019", ""));
    }


}
