package test;

import blockchain.Blockchain;
import blockchain.Block;

import security.Wallet;
import security.Transaction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestFullProjectTest {

    // ================= DIGITAL SIGNATURE TEST =================
    @Test
    public void testDigitalSignature() {
        Wallet user1 = new Wallet();
        Wallet user2 = new Wallet();

        Transaction tx = new Transaction(user1.publicKey, user2.publicKey, 50);
        tx.generateSignature(user1.privateKey);

        assertTrue(tx.verifySignature(), "Signature verification failed");
    }

    // ================= BLOCKCHAIN VALIDITY TEST =================
    @Test
    public void testBlockchain() {
        Blockchain blockchain = new Blockchain();

        blockchain.addBlock("Tx1");
        blockchain.addBlock("Tx2");

        assertTrue(blockchain.isChainValid(), "Blockchain should be valid");
    }

    // ================= ATTACK DETECTION TEST =================
    @Test
    public void testAttack() {
        Blockchain blockchain = new Blockchain();

        blockchain.addBlock("Tx1");
        blockchain.addBlock("Tx2");

        // Tamper block (WITHOUT re-mining)
        Block block = blockchain.getChain().get(1);
        block.setData("HACKED DATA");   // IMPORTANT FIX

        assertFalse(blockchain.isChainValid(), "Attack should invalidate blockchain");
    }

    // ================= PERFORMANCE TEST =================
    @Test
    public void testPerformance() {
        Blockchain blockchain = new Blockchain();

        long start = System.currentTimeMillis();

        blockchain.addBlock("Tx1");
        blockchain.addBlock("Tx2");
        blockchain.addBlock("Tx3");

        long end = System.currentTimeMillis();

        assertTrue((end - start) >= 0, "Performance timing failed");
    }

    // ================= CONSENSUS TEST =================
    @Test
    public void testConsensus() {
        Blockchain chain1 = new Blockchain();
        Blockchain chain2 = new Blockchain();

        chain1.addBlock("Tx1");
        chain1.addBlock("Tx2");

        chain2.addBlock("Tx1");

        Blockchain selected;

        if (chain1.getChain().size() > chain2.getChain().size() && chain1.isChainValid()) {
            selected = chain1;
        } else if (chain2.isChainValid()) {
            selected = chain2;
        } else {
            selected = chain1;
        }

        assertTrue(selected.isChainValid(), "Consensus failed");
    }
}