package com.interview.atlassian.middlewarerouter;

public class RunRouter {

    private static RouterService routerService;

    public static void main(String[] args) {
        routerService = new RouterService();

        routerService.add("Shikha/Work/Resumes", "May_Resume.pdf");
        routerService.add("Shikha/Work/Old_Resumes", "June_Resume.pdf");

        testCase(routerService.get("Shikha/Work/Resumes"), "May_Resume.pdf");
        testCase(routerService.get("Shikha/Work/Old_Resumes"), "June_Resume.pdf");
        testCase(routerService.get("Shikha/Work"), "");
    }

    private static void testCase(String actual, String expected) {
        System.out.println(actual.equals(expected) + "<-TestCase| " + actual);
    }

}
