package blockchain;

import utils.HashUtil;
import java.util.Date;

public class Block {

    private String hash;
    private String previousHash;
    private String data;
    private long timestamp;
    private int nonce;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {

        String input = previousHash + timestamp + nonce + data;

        return HashUtil.applySHA256(input);
    }

    public void mineBlock(int difficulty) {

        String target = new String(new char[difficulty]).replace('\0', '0');

        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }

        System.out.println("Block mined: " + hash);
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
    this.data = data;
}
}