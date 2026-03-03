package com.thetestingacademy.listeners;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReporterListener implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
 outputDirectory ="C:\\Users\\devin\\IdeaProjects\\SeleniumAdvanceFramework\\Reports";

        String reportPath = outputDirectory + "/custom-report.html";

        try {
            FileWriter file = new FileWriter(reportPath);
            PrintWriter writer = new PrintWriter(file);
            writer.println("<html><head><title>TestNG Custom Report</title>");
            writer.println("<style>table{border-collapse:collapse}th,td{border:1px solid #ddd;padding:8px}</style>");
            writer.println("</head><body>");

            int total = 0;
            int passed = 0;
            int failed = 0;
            int skipped = 0;

            for (ISuite suite : suites) {

                writer.println("<h2>Suite: " + suite.getName() + "</h2>");

                for (ISuiteResult context : suite.getResults().values()) {
                    passed += context.getTestContext().getPassedTests().size();
                    failed += context.getTestContext().getFailedTests().size();
                    skipped += context.getTestContext().getSkippedTests().size();
                    total += context.getTestContext().getPassedTests().size() +
                            context.getTestContext().getFailedTests().size() +
                            context.getTestContext().getSkippedTests().size();

                    // Failed tests table
                    if (!context.getTestContext().getFailedTests().getAllMethods().isEmpty()) {
                        writer.println("<h3>Failed Tests:</h3>");
                        writer.println("<table><tr><th>Test</th><th>Time</th></tr>");
                        for (ITestResult result : context.getTestContext().getFailedTests().getAllResults()) {
                            writer.println(String.format(
                                    "<tr><td>%s</td><td>%d ms</td></tr>",
                                    result.getName(),
                                    result.getEndMillis() - result.getStartMillis()
                            ));
                        }
                        writer.println("</table>");
                    }
                }

                // Summary
                writer.println("<h1>Summary</h1>");
                writer.println(String.format(
                        "<p>Total: %d | Passed: %d | Failed: %d | Skipped: %d</p>",
                        total, passed, failed, skipped
                ));

                writer.println("</body></html>");
                System.out.println("Custom report generated: " + reportPath);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

