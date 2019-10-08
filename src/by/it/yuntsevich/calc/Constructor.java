package by.it.yuntsevich.calc;

 class Constructor {

    private ReportBuilder reportBuilder;

    void setReportBuilder(ReportBuilder rb) {
        reportBuilder = rb;
    }

    Report getReport() {
        return reportBuilder.getReport();
    }


    void constructReport() {
        reportBuilder.createNewReport();
        reportBuilder.buildName();
        reportBuilder.buildStartTime();
        reportBuilder.buildOperationsAndResults();
        reportBuilder.buildFinishTime();

    }
}
