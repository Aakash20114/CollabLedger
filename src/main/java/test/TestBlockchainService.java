package test;

import services.BlockchainService;

public class TestBlockchainService {

    public static void main(String[] args) {

        BlockchainService service = new BlockchainService();

        service.recordContribution("Aakash", "Installed irrigation controller");
        service.recordContribution("Ravi", "Configured soil moisture sensor");

        service.printBlockchain();

        service.validateBlockchain();

        // Tampering attack
        service.tamperBlock();

        service.validateBlockchain();
    }
}