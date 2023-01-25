package TamagochPrj;

public class PlayDTO {
	private int growth = 0;
	private int boring = 100;
	public PlayDTO(int growth, int boring) {
		super();
		this.growth = growth;
		this.boring = boring;
	}
	public int getGrowth() {
		return growth;
	}
	public void setGrowth(int growth) {
		this.growth = growth;
	}
	public int getBoring() {
		return boring;
	}
	public void setBoring(int boring) {
		this.boring = boring;
	}
	
	
}
