package fooba.VO;

public class RestaurantVO {
	private String rid;
	private String rpwd;
	private String rname;
	private String ownername;
	private String rphone;
	private String raddress;
	private String rimage;
	private String content;
	private String hash;
	private int rseq;
	private String rbiznum;
	private int kind;
	private int rtip;
	private int ryn;
	private String fimage;
	
	public String getFimage() {
		return fimage;
	}
	public void setFimage(String fimage) {
		this.fimage = fimage;
	}
	public void setRbiznum(String rbiznum) {
		this.rbiznum = rbiznum;
	}
	public int getRyn() {
		return ryn;
	}
	public void setRyn(int ryn) {
		this.ryn = ryn;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRpwd() {
		return rpwd;
	}
	public void setRpwd(String rpwd) {
		this.rpwd = rpwd;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getRphone() {
		return rphone;
	}
	public void setRphone(String rphone) {
		this.rphone = rphone;
	}
	public String getRaddress() {
		return raddress;
	}
	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
	public String getRimage() {
		return rimage;
	}
	public void setRimage(String rimage) {
		this.rimage = rimage;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public int getRseq() {
		return rseq;
	}
	public void setRseq(int rseq) {
		this.rseq = rseq;
	}
	
	public String getRbiznum() {
		return rbiznum;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public int getRtip() {
		return rtip;
	}
	public void setRtip(int rtip) {
		this.rtip = rtip;
	}
}
