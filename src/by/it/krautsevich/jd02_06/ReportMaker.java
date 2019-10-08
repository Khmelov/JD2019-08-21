package by.it.krautsevich.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class ReportMaker {

    private Reporter Solovbev ;

    void setReporter (Reporter rep) {Solovbev = rep ; }
    Report getReport() {return Solovbev.getReport();}

    public void toReport() {
        String path = getPath.getMyPath(Report.class) ;
        String filename = "report.txt" ;
        String fullpath = path + filename ;

        StringBuilder myReport = new StringBuilder() ;
        myReport.append(Solovbev.getReportName()).append("\n").append(Solovbev.getTimeStart()).append(" - ").append(Solovbev.getTimeFin()).append("\n").append(Solovbev.getErrors()) ;
        try (PrintWriter printer = new PrintWriter(new FileWriter(fullpath, true)) ) {

            printer.println(myReport);
            printer.flush();
        } catch (IOException e) {
            e.printStackTrace();}
    }
}
