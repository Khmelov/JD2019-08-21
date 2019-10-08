package by.it.rubatskii.jd02_06;

import java.util.List;

class Report {
    private String title;
    private String startTime;
    private String endTime;
    private List<String> errorMessages;
    private StringBuilder operations;
    private List<StackTraceElement[]> errorStackTraces;

    String getTitle() {
        return title;
    }

    String getStartTime() {
        return startTime;
    }

    String getEndTime() {
        return endTime;
    }

    List<String> getErrorMessages() {
        return errorMessages;
    }

    StringBuilder getOperations() {
        return operations;
    }

    List<StackTraceElement[]> getErrorStackTraces() {
        return errorStackTraces;
    }

    private Report(ReportBuilder reportBuilder) {
        this.title = reportBuilder.title;
        this.startTime = reportBuilder.startTime;
        this.endTime = reportBuilder.endTime;
        this.errorMessages = reportBuilder.errorMessages;
        this.operations = reportBuilder.operations;
        this.errorStackTraces = reportBuilder.errorStackTraces;
    }

    static class ReportBuilder {
        private String title;
        private String startTime;
        private String endTime;
        private List<String> errorMessages;
        private StringBuilder operations;
        private List<StackTraceElement[]> errorStackTraces;

        ReportBuilder(String title, String startTime, String endTime, List<String> errorMessages) {
            this.title = title;
            this.startTime = startTime;
            this.endTime = endTime;
            this.errorMessages = errorMessages;
        }

        ReportBuilder operations(StringBuilder operations) {
            this.operations = operations;
            return this;
        }

        ReportBuilder errorStackTraces(List<StackTraceElement[]> errorStackTraces) {
            this.errorStackTraces = errorStackTraces;
            return this;
        }

        Report build() {
            return new Report(this);
        }
    }
}