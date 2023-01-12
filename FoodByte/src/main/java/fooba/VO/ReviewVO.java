package fooba.VO;

import java.sql.Timestamp;

public class ReviewVO {

   private int review_seq;
   private String id;
   private int rseq;
   private Timestamp indate;
   private int star;
   private String image;
   private String content;
   private int oseq;
   private String reply;
   private int replyyn;
   private String nick;
   private String fnames;
   
   
   public String getNick() {
	return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getReview_seq() {
      return review_seq;
   }
   public void setReview_seq(int review_seq) {
      this.review_seq = review_seq;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public int getRseq() {
      return rseq;
   }
   public void setRseq(int rseq) {
      this.rseq = rseq;
   }
   public Timestamp getIndate() {
      return indate;
   }
   public void setIndate(Timestamp indate) {
      this.indate = indate;
   }
   public int getStar() {
      return star;
   }
   public void setStar(int star) {
      this.star = star;
   }
   
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   public int getOseq() {
      return oseq;
   }
   public void setOseq(int oseq) {
      this.oseq = oseq;
   }
   public String getReply() {
      return reply;
   }
   public void setReply(String reply) {
      this.reply = reply;
   }
   public int getReplyyn() {
      return replyyn;
   }
   public void setReplyyn(int replyyn) {
      this.replyyn = replyyn;
   }
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getFnames() {
	return fnames;
}
public void setFnames(String fnames) {
	this.fnames = fnames;
}
   
   
   
}