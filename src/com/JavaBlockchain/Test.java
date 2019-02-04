
public class Test {

	public static void main(String[] args) {

		Blockchain mrcCoin = new Blockchain();
		
		Block a = new Block ("Genesis", new java.util.Date(), "<transactions>");
		Block b = new Block ("2", new java.util.Date(), "<transactions>");
		Block c = new Block ("3", new java.util.Date(), "<transactions>");
		
		mrcCoin.addBlock(a);
		mrcCoin.addBlock(b);
		mrcCoin.addBlock(c);
		
		
		
		mrcCoin.displayChain();
		
		mrcCoin.isValid();
	}

}
