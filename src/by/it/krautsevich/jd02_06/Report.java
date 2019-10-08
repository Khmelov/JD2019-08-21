package by.it.krautsevich.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Report {
    private String name = "" ;
    private String timeStart = "" ;
    private String timeFin = "" ;
    private String errors = "" ;

    void setReportName(String name)     { this.name = name; }
    void settimeStart(String timeStart)     { this.timeStart = timeStart; }
    void setTimeFin(String timeFin) { this.timeFin = timeFin; }
    void setErrors (String errCollection ) {this.errors = errCollection ;}


}
