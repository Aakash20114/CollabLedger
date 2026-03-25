package test;

import services.ContributionService;

public class TestContributionService {

    public static void main(String[] args) {

        ContributionService service = new ContributionService();

        service.addContribution("Aakash", "Installed irrigation controller");
        service.addContribution("Ravi", "Configured soil moisture sensor");

        service.listContributions();

        service.showBlockchain();
    }
}