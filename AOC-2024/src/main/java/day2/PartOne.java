package day2;

import java.util.ArrayList;

import utilities.HintInput;

public class PartOne {

    private ArrayList<Report> reports = new ArrayList<>();

    private Integer safeReportsCount = 0;

    public PartOne(HintInput input) {
        for(String inputLine : input.getHintLines()) {
            reports.add(new Report(inputLine));
        }
        System.out.println();
        for(Report report : reports)
        {
            if(report.isSafe())
            {
                System.out.print("Safe: ");
                report.printLevels();
                safeReportsCount += 1;
            }
            else
            {
                System.out.print("Unsafe: ");
                report.printLevels();
            }
        }
        System.out.println();
    }

    public Integer getSafeReportsCount()
    {
        return this.safeReportsCount;
    }
    
}
