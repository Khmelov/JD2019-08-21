package by.it.krautsevich.jd02_06;

abstract class Reporter {

    Report report ;

    Report getReport() {return report ;}

    void createNewReport() { report = new Report() ;}

    public abstract String getReportName() ;
    public abstract String getTimeStart() ;
    public abstract String getTimeFin() ;
    public abstract String getErrors () ;
}
