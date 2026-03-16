package test;

import database.ContributionRepository;
import models.Contribution;
import utils.DateUtil;

public class TestContributionRepository {

    public static void main(String[] args) {

        ContributionRepository repo = new ContributionRepository();

        Contribution contribution = new Contribution(
                "Aakash",
                "Installed irrigation controller",
                DateUtil.getCurrentTimestamp()
        );

        repo.saveContribution(contribution);

        System.out.println("Contribution inserted successfully");
    }
}