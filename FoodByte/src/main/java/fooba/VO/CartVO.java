package fooba.VO;

import java.sql.Timestamp;

public class CartVO {
		private Integer cseq;
		private Integer quantity;
		private String id;
		private Integer fseq;
		private Integer sideyn1;
		private Integer sideyn2;
		private Integer sideyn3;	
		private Timestamp indate;
		
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
		public Integer getSideyn1() {
			return sideyn1;
		}
		public void setSideyn1(Integer sideyn1) {
			this.sideyn1 = sideyn1;
		}
		public Integer getSideyn2() {
			return sideyn2;
		}
		public void setSideyn2(Integer sideyn2) {
			this.sideyn2 = sideyn2;
		}
		public Integer getSideyn3() {
			return sideyn3;
		}
		public void setSideyn3(Integer sideyn3) {
			this.sideyn3 = sideyn3;
		}
		public Timestamp getIndate() {
			return indate;
		}
		public void setIndate(Timestamp indate) {
			this.indate = indate;
		}
		
		

}
