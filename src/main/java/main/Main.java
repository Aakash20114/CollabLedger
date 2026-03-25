package main;

import blockchain.Blockchain;
import blockchain.Block;

import security.Wallet;
import security.Transaction;


// ================= MAIN =================
public class Main {

    // ===== CONSENSUS FUNCTION =====
    public static Blockchain getLongestChain(Blockchain c1, Blockchain c2) {
        if (c1.getChain().size() > c2.getChain().size() && c1.isChainValid()) {
            return c1;
        } else if (c2.isChainValid()) {
            return c2;
        }
        return c1;
    }

    public static void main(String[] args) {

        System.out.println("===== BLOCKCHAIN PROJECT =====");

        // ================= DIGITAL SIGNATURE =================
        System.out.println("\n--- DIGITAL SIGNATURE ---");

        Wallet user1 = new Wallet();
        Wallet user2 = new Wallet();

        Transaction tx = new Transaction(user1.publicKey, user2.publicKey, 100);
        tx.generateSignature(user1.privateKey);

        System.out.println("Transaction Signature Valid: " + tx.verifySignature());

        // ================= BLOCKCHAIN =================
        Blockchain blockchain = new Blockchain();

        System.out.println("\nMining blocks...");

        long start = System.currentTimeMillis();

        blockchain.addBlock("User Aakash contributed 50 to Project SolarPump");
        blockchain.addBlock("User Ravi contributed 30 to Project SolarPump");
        blockchain.addBlock("User Meena contributed 100 to Project SmartFarm");

        long end = System.currentTimeMillis();

        System.out.println("\n===== ORIGINAL BLOCKCHAIN =====");
        blockchain.printChain();

        System.out.println("\nBlockchain valid: " + blockchain.isChainValid());

        // ================= PERFORMANCE =================
        System.out.println("\n--- PERFORMANCE ANALYSIS ---");

        long totalTime = end - start;
        System.out.println("Total Mining Time: " + totalTime + " ms");

        int txCount = 3;
        double throughput = txCount / (totalTime / 1000.0);
        System.out.println("Throughput: " + throughput + " tx/sec");

        // ================= ATTACK SIMULATION =================
        System.out.println("\n⚠️ Simulating tampering attack...");

        Block tamperedBlock = blockchain.getChain().get(1);

        System.out.println("Block 1 hash before tampering: " + tamperedBlock.getHash());

        // Simulate data change (attack)
        tamperedBlock.mineBlock(2);

        System.out.println("Block 1 hash after tampering: " + tamperedBlock.getHash());

        System.out.println("\n===== BLOCKCHAIN AFTER ATTACK =====");
        System.out.println("Blockchain valid: " + blockchain.isChainValid());

        if (!blockchain.isChainValid()) {
            System.out.println("Attack detected! Invalid block rejected.");
        }

        // ================= 51% ATTACK SIMULATION =================
        System.out.println("\n--- 51% ATTACK SIMULATION ---");

        Blockchain attackerChain = new Blockchain();

        // Copy original chain data (simulate attacker copy)
        for (Block b : blockchain.getChain()) {
            attackerChain.addBlock("Fake Copy: " + b.getHash());
        }

        Blockchain selectedChain = getLongestChain(blockchain, attackerChain);

        System.out.println("Selected chain length: " + selectedChain.getChain().size());

        // ================= SCALABILITY =================
        System.out.println("\n--- SCALABILITY TEST ---");

        for (int i = 0; i < 5; i++) {
            long s = System.currentTimeMillis();

            blockchain.addBlock("Test Block " + i);

            long e = System.currentTimeMillis();

            System.out.println("Block " + i + " time: " + (e - s) + " ms");
        }
    }
}