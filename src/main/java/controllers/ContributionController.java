package controllers;

import services.ContributionService;

public class ContributionController {


private ContributionService contributionService;

public ContributionController() {
    contributionService = new ContributionService();
}

// Add contribution
public void contribute(String contributor, String task) {

    contributionService.addContribution(contributor, task);
}

// Show contributions
public void listContributions() {

    contributionService.listContributions();
}

// Show blockchain
public void showBlockchain() {

    contributionService.showBlockchain();
}


}
