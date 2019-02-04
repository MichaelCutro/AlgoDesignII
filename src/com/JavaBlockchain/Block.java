import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class Block {
	//Attributes of block
	private String block;
	private Date timeStamp;
	private String hash;
	private String previousHash;
	private String data;
	//Construct block
	public Block(String version, Date timeStamp, String data) {
		this.block = version;
		this.timeStamp = timeStamp;
		this.data = data;
		this.hash = computeHash();
	}
	//Create method compute hash
	public String computeHash() {

		String dataToHash = " " + this.block + this.timeStamp + this.previousHash + this.data;

		MessageDigest digest;
		String encoded = null;

		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
			encoded = Base64.getEncoder().encodeToString(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		this.hash = encoded;
		return encoded;

	}

	public String getVersion() {
		return block;
	}

	public void setVersion(String version) {
		this.block = version;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
