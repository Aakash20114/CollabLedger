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

    for (int i = 1; i < chain.size(); i++) {

        Block current = chain.get(i);
        Block previous = chain.get(i - 1);

        // 🔴 Check hash integrity
        if (!current.getHash().equals(current.calculateHash())) {
            return false;
        }

        // 🔴 Check chain link
        if (!current.getPreviousHash().equals(previous.getHash())) {
            return false;
        }
    }

    return true;
}

public ArrayList<Block> getChain() {
    return chain;
}


}

