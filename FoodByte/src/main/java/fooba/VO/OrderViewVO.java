package fooba.VO;

import java.sql.Timestamp;

public class OrderViewVO {
	private int oseq;
	private int result;
	private Timestamp indate;
	private String id;
	private int rideryn;
	private int plasticyn;
	private int payment;
	private String oadd1;
	private String oadd2;
	private String ophone;
	private int totalprice;
	
	private int odseq;
	private int quantity;
	private int fseq;
	private int sideyn1;
	private int sideyn2;
	private int sideyn3;

	private String nick;
	private String madd1;
	private String madd2;
	private String mphone;
	
	private String fname;
	private int fprice;
	private String fside1;
	private int fsideprice1;
	private String fside2;
	private int fsideprice2;
	private String fside3;
	private int fsideprice3;
	private String fimage;
	private String fcontent;
	
	private String rname;
	private int rseq;
	private String rimage;
	private int rtip;
	private int ryn;
	
	
	public int getOseq() {
		return oseq;
	}
	public void setOseq(int oseq) {
		this.oseq = oseq;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRideryn() {
		return rideryn;
	}
	public void setRideryn(int rideryn) {
		this.rideryn = rideryn;
	}
	public int getPlasticyn() {
		return plasticyn;
	}
	public void setPlasticyn(int plasticyn) {
		this.plasticyn = plasticyn;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getOadd1() {
		return oadd1;
	}
	public void setOadd1(String oadd1) {
		this.oadd1 = oadd1;
	}
	public String getOadd2() {
		return oadd2;
	}
	public void setOadd2(String oadd2) {
		this.oadd2 = oadd2;
	}
	public String getOphone() {
		return ophone;
	}
	public void setOphone(String ophone) {
		this.ophone = ophone;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public int getOdseq() {
		return odseq;
	}
	public void setOdseq(int odseq) {
		this.odseq = odseq;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getFseq() {
		return fseq;
	}
	public void setFseq(int fseq) {
		this.fseq = fseq;
	}
	public int getSideyn1() {
		return sideyn1;
	}
	public void setSideyn1(int sideyn1) {
		this.sideyn1 = sideyn1;
	}
	public int getSideyn2() {
		return sideyn2;
	}
	public void setSideyn2(int sideyn2) {
		this.sideyn2 = sideyn2;
	}
	public int getSideyn3() {
		return sideyn3;
	}
	public void setSideyn3(int sideyn3) {
		this.sideyn3 = sideyn3;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getMadd1() {
		return madd1;
	}
	public void setMadd1(String madd1) {
		this.madd1 = madd1;
	}
	public String getMadd2() {
		return madd2;
	}
	public void setMadd2(String madd2) {
		this.madd2 = madd2;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getFprice() {
		return fprice;
	}
	public void setFprice(int fprice) {
		this.fprice = fprice;
	}
	public String getFside1() {
		return fside1;
	}
	public void setFside1(String fside1) {
		this.fside1 = fside1;
	}
	public int getFsideprice1() {
		return fsideprice1;
	}
	public void setFsideprice1(int fsideprice1) {
		this.fsideprice1 = fsideprice1;
	}
	public String getFside2() {
		return fside2;
	}
	public void setFside2(String fside2) {
		this.fside2 = fside2;
	}
	public int getFsideprice2() {
		return fsideprice2;
	}
	public void setFsideprice2(int fsideprice2) {
		this.fsideprice2 = fsideprice2;
	}
	public String getFside3() {
		return fside3;
	}
	public void setFside3(String fside3) {
		this.fside3 = fside3;
	}
	public int getFsideprice3() {
		return fsideprice3;
	}
	public void setFsideprice3(int fsideprice3) {
		this.fsideprice3 = fsideprice3;
	}
	public String getFimage() {
		return fimage;
	}
	public void setFimage(String fimage) {
		this.fimage = fimage;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getRseq() {
		return rseq;
	}
	public void setRseq(int rseq) {
		this.rseq = rseq;
	}
	public String getRimage() {
		return rimage;
	}
	public void setRimage(String rimage) {
		this.rimage = rimage;
	}
	public int getRtip() {
		return rtip;
	}
	public void setRtip(int rtip) {
		this.rtip = rtip;
	}
	public int getRyn() {
		return ryn;
	}
	public void setRyn(int ryn) {
		this.ryn = ryn;
	}
}
