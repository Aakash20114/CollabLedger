package blockchain;

import java.util.ArrayList;

public class Blockchain {


private ArrayList<Block> chain;
private int difficulty = 4;

public Blockchain() {
    chain = new ArrayList<>();
    chain.add(createGenesisBlock());
}

private Block createGenesisBlock() {
    return new Block("Genesis Block", "0");
}

public Block getLatestBlock() {
    return chain.get(chain.size() - 1);
}

public void addBlock(String data) {

    Block newBlock = new Block(data, getLatestBlock().getHash());

    newBlock.mineBlock(difficulty);

    chain.add(newBlock);
}

// Print the blockchain
public void printChain() {


for (Block block : chain) {

    System.out.println("\n========== BLOCK ==========");
    System.out.println("Data: " + block.getData());
    System.out.println("Hash: " + block.getHash());
    System.out.println("Previous Hash: " + block.getPreviousHash());
}


}


// Validate blockchain integrity
public boolean isChainValid() {

    Block currentBlock;
    Block previousBlock;

    for (int i = 1; i < chain.size(); i++) {

        currentBlock = chain.get(i);
        previousBlock = chain.get(i - 1);

        // Check if current hash is correct
        if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {

            System.out.println("Current hash is invalid!");
            return false;
        }

        // Check if previous hash matches
        if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {

            System.out.println("Previous hash mismatch!");
            return false;
        }
    }

    return true;
}

public ArrayList<Block> getChain() {
    return chain;
}


}

