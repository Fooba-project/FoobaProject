package fooba.VO;

import java.sql.Timestamp;

public class MemberVO {

   private String id;
   private String pwd;
   private String name;
   private String phone;
   private String email;
   private String zip_num;
   private String address1;
   private String address2;
   private Timestamp indate;
   private String nick;
   
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPwd() {
      return pwd;
   }
   public void setPwd(String pwd) {
      this.pwd = pwd;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getPhone() {
      return phone;
   }
   public void setPhone(String phone) {
      this.phone = phone;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getZip_num() {
      return zip_num;
   }
   public void setZip_num(String zip_num) {
      this.zip_num = zip_num;
   }
   public String getAddress1() {
      return address1;
   }
   public void setAddress1(String address1) {
      this.address1 = address1;
   }
   public String getAddress2() {
      return address2;
   }
   public void setAddress2(String address2) {
      this.address2 = address2;
   }
   public Timestamp getIndate() {
      return indate;
   }
   public void setIndate(Timestamp indate) {
      this.indate = indate;
   }
   public String getNick() {
      return nick;
   }
   public void setNick(String nick) {
      this.nick = nick;
   }
   
   
}