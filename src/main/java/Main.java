import blockchain.Blockchain;
import blockchain.Block;

public class Main {


public static void main(String[] args) {

    Blockchain blockchain = new Blockchain();

    // Add blocks
    blockchain.addBlock("User Aakash contributed 50 to Project SolarPump");
    blockchain.addBlock("User Ravi contributed 30 to Project SolarPump");
    blockchain.addBlock("User Meena contributed 100 to Project SmartFarm");

    System.out.println("\n===== ORIGINAL BLOCKCHAIN =====");
    blockchain.printChain();

    System.out.println("\nBlockchain valid: " + blockchain.isChainValid());

    // -------- Tampering Attack --------
    System.out.println("\n⚠️ Simulating tampering attack...");

    Block tamperedBlock = blockchain.getChain().get(1);

    // Changing data indirectly by recalculating hash
    // (in real attack someone edits block data)
    System.out.println("Block 1 hash before tampering: " + tamperedBlock.getHash());

    // simulate change by recalculating hash with modified nonce
    tamperedBlock.mineBlock(2);

    System.out.println("Block 1 hash after tampering: " + tamperedBlock.getHash());

    // -------- Validate chain again --------
    System.out.println("\n===== BLOCKCHAIN AFTER ATTACK =====");

    System.out.println("Blockchain valid: " + blockchain.isChainValid());
}


}
