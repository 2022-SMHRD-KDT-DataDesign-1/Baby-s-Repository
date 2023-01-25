package TamagochPrj;

public class JoinDTO {

	private String id;
	private String pw;
	private String name;
	public String b_date;
	public int growth;
	public int tired;
	public int hungry;
	public int boring;
	public int sleeping;
	public int knowledge;
	

	public JoinDTO(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JoinDTO(String name) {
		this.name = name;

	}

	public JoinDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	

}
