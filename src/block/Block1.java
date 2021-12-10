package block;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Block1 {
    private String id;
    private String name;
    private String address;
    private Double amount;
    private String prevHash;

    public Block1() {
        id = getCryptoHash(UUID.randomUUID().toString());
    }

    public Block1(String name, String address, Double amount, String prevHash) {
        id = getCryptoHash(UUID.randomUUID().toString());
        this.name = getCryptoHash(name);
        this.address = getCryptoHash(address);
        this.amount = amount;
        this.prevHash = getCryptoHash(prevHash);
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Double getAmount() {
        return amount;
    }

    public String getPrevHash() {
        return prevHash;
    }

    public void setName(String name) {
        this.name = getCryptoHash(name);
    }

    public void setAddress(String address) {
        this.address = getCryptoHash(address);
    }

    public String getId() {
        return id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setPrevHash(String prevHash) {
        this.prevHash = getCryptoHash(prevHash);
    }

    public static String getCryptoHash(String input) {
        if (input == null) input = "Initial";
        try {
            MessageDigest msgDigest = MessageDigest.getInstance("SHA-512");
            byte[] inputDigest = msgDigest.digest(input.getBytes());
            BigInteger inputDigestBigInt = new BigInteger(1, inputDigest);
            StringBuilder hashtext = new StringBuilder(inputDigestBigInt.toString(16));
            while (hashtext.length() < 32) {
                hashtext.append("0").append(hashtext);
            }
            return hashtext.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                ", prevHash='" + prevHash + '\'' +
                '}';
    }
}
