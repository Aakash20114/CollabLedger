package services;

import blockchain.Blockchain;
import com.google.gson.Gson;
import models.Contribution;
import utils.DateUtil;

public class BlockchainService {

private Blockchain blockchain;
private Gson gson;

public BlockchainService() {
    blockchain = new Blockchain();
    gson = new Gson();
}

// Record contribution as JSON block
public void recordContribution(String contributor, String task) {

    String timestamp = DateUtil.getCurrentTimestamp();

    Contribution contribution =
            new Contribution(contributor, task, timestamp);

    // Convert object → JSON
    String jsonData = gson.toJson(contribution);

    blockchain.addBlock(jsonData);

    System.out.println("Contribution recorded on blockchain.");
}

// Print blockchain
public void printBlockchain() {
    blockchain.printChain();
}

public void validateBlockchain() {

    boolean valid = blockchain.isChainValid();

    if (valid) {
        System.out.println("Blockchain is valid.");
    } else {
        System.out.println("Blockchain is NOT valid.");
    }
}
public void tamperBlock() {

    System.out.println("\n⚠ Simulating blockchain tampering...");

    blockchain.getChain().get(1).setData("HACKED DATA");

}

}
