package by.it.yuntsevich.calc;

public class Report {

    private String name = "";
    private String startTime = "";
    private String finishTime = "";
    private String operationsAndResults = "";

    public void setName(String name) {
        this.name = name;
    }

    void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    void setOperationsAndResults(String operationsAndResults) {
        this.operationsAndResults = operationsAndResults;
    }

    @Override
    public String toString() {
        return   name + '\n' +
                "start Time = " + startTime + '\n' +'\n'+
                "operations And Results: " + operationsAndResults + '\n' +
                "finish Time = " + finishTime;
    }
}