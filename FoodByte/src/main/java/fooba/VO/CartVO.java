package fooba.VO;

import java.sql.Timestamp;

public class CartVO {
		private Integer cseq;
		private Integer quantity;
		private String id;
		private Integer fseq;
		private String sideyn1;
		private String sideyn2;
		private String sideyn3;
		private int cprice;
		private Timestamp indate;
		private String cfname;
		private int rseq;
		
		public Integer getCseq() {
			return cseq;
		}
		public void setCseq(Integer cseq) {
			this.cseq = cseq;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Integer getFseq() {
			return fseq;
		}
		public void setFseq(Integer fseq) {
			this.fseq = fseq;
		}
		
		public String getSideyn1() {
			return sideyn1;
		}
		public void setSideyn1(String sideyn1) {
			this.sideyn1 = sideyn1;
		}
		public String getSideyn2() {
			return sideyn2;
		}
		public void setSideyn2(String sideyn2) {
			this.sideyn2 = sideyn2;
		}
		public String getSideyn3() {
			return sideyn3;
		}
		public void setSideyn3(String sideyn3) {
			this.sideyn3 = sideyn3;
		}
		public int getCprice() {
			return cprice;
		}
		public void setCprice(int cprice) {
			this.cprice = cprice;
		}
		public Timestamp getIndate() {
			return indate;
		}
		public void setIndate(Timestamp indate) {
			this.indate = indate;
		}
		public String getCfname() {
			return cfname;
		}
		public void setCfname(String cfname) {
			this.cfname = cfname;
		}
		public int getRseq() {
			return rseq;
		}
		public void setRseq(int rseq) {
			this.rseq = rseq;
		}
		
		

}
