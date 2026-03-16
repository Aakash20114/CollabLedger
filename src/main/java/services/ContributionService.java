package services;

import models.Contribution;
import utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class ContributionService {


private List<Contribution> contributions;
private BlockchainService blockchainService;

public ContributionService() {
    contributions = new ArrayList<>();
    blockchainService = new BlockchainService();
}

// Record a contribution
public void addContribution(String contributor, String task) {

    String timestamp = DateUtil.getCurrentTimestamp();

    Contribution contribution = new Contribution(contributor, task, timestamp);

    contributions.add(contribution);

    // Record on blockchain
    blockchainService.recordContribution(contributor, task);

    System.out.println("Contribution added successfully.");
}

// Show all contributions
public void listContributions() {

    if (contributions.isEmpty()) {
        System.out.println("No contributions recorded.");
        return;
    }

    for (Contribution c : contributions) {

        System.out.println("Contributor: " + c.getContributor());
        System.out.println("Task: " + c.getTask());
        System.out.println("Time: " + c.getTimestamp());

        System.out.println("--------------------");
    }
}

// Print blockchain
public void showBlockchain() {
    blockchainService.printBlockchain();
}


}
