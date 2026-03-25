package security;

import java.security.*;

public class Transaction {
    public PublicKey sender;
    public PublicKey receiver;
    public float amount;
    private byte[] signature;

    public Transaction(PublicKey from, PublicKey to, float amount) {
        this.sender = from;
        this.receiver = to;
        this.amount = amount;
    }

    public String getData() {
        return sender.toString() + receiver.toString() + amount;
    }

    public void generateSignature(PrivateKey privateKey) {
        try {
            Signature rsa = Signature.getInstance("SHA256withRSA");
            rsa.initSign(privateKey);
            rsa.update(getData().getBytes());
            signature = rsa.sign();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verifySignature() {
        try {
            Signature rsa = Signature.getInstance("SHA256withRSA");
            rsa.initVerify(sender);
            rsa.update(getData().getBytes());
            return rsa.verify(signature);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}