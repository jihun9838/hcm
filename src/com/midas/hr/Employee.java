//package MIDAS;
//
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//
//public class Employee {
//	private SimpleStringProperty num;
//	private SimpleStringProperty id;
//	private SimpleStringProperty pw;
//	private SimpleStringProperty name;
//	private SimpleStringProperty birth;
//	private SimpleStringProperty gender;
//	private SimpleStringProperty category;
//	private SimpleStringProperty salary;
//	private SimpleStringProperty department;
//	private SimpleStringProperty position;
//	private SimpleStringProperty place;
//	private SimpleStringProperty phone;
//	private SimpleStringProperty join;
//	private SimpleStringProperty email;
//	private SimpleStringProperty education;
//	private SimpleStringProperty address;
//	private SimpleStringProperty image;
//	
//	public Employee() {
//		this.num = new SimpleStringProperty();
//		this.id = new SimpleStringProperty();
//		this.pw = new SimpleStringProperty();
//		this.name = new SimpleStringProperty();
//		this.birth = new SimpleStringProperty();
//		this.gender = new SimpleStringProperty();
//		this.category = new SimpleStringProperty();
//		this.salary = new SimpleStringProperty();
//		this.department = new SimpleStringProperty();
//		this.position = new SimpleStringProperty();
//		this.place = new SimpleStringProperty();
//		this.phone = new SimpleStringProperty();
//		this.join = new SimpleStringProperty();
//		this.email = new SimpleStringProperty();
//		this.education = new SimpleStringProperty();
//		this.address = new SimpleStringProperty();
//		this.image = new SimpleStringProperty();
//	}
//	public Employee(String num, String id, String pw, String name, String birth, String gender, String category, String salay, String department, String position, String place, String phone, String join, String email, String education, String adrress, String image) {
//		this.num = new SimpleStringProperty(num);
//		this.id = new SimpleStringProperty(id);
//		this.pw = new SimpleStringProperty(pw);
//		this.name = new SimpleStringProperty(name);
//		this.birth = new SimpleStringProperty(birth);
//		this.gender = new SimpleStringProperty(gender);
//		this.category = new SimpleStringProperty(category);
//		this.salary = new SimpleStringProperty(salay);
//		this.department = new SimpleStringProperty(department);
//		this.position = new SimpleStringProperty(position);
//		this.place = new SimpleStringProperty(place);
//		this.phone = new SimpleStringProperty(phone);
//		this.join = new SimpleStringProperty(join);
//		this.email = new SimpleStringProperty(email);
//		this.education = new SimpleStringProperty(education);
//		this.address = new SimpleStringProperty(adrress);
//		this.image = new SimpleStringProperty(image);
//	}
//	public Employee(String num, String name, String category, String department, String position, String place, String phone, String join, String email, String education) {
//		this.num = new SimpleStringProperty(num);
//		this.name = new SimpleStringProperty(name);
//		this.category = new SimpleStringProperty(category);
//		this.department = new SimpleStringProperty(department);
//		this.position = new SimpleStringProperty(position);
//		this.place = new SimpleStringProperty(place);
//		this.phone = new SimpleStringProperty(phone);
//		this.join = new SimpleStringProperty(join);
//		this.email = new SimpleStringProperty(email);
//		this.education = new SimpleStringProperty(education);
//	}
//	public Employee(String num, String name) {
//		this.num = new SimpleStringProperty(num);
//		this.name = new SimpleStringProperty(name);
//	}
//	
//	public String getnum() {
//		return num.get();
//	}
//	public void setnum(String num) {
//		this.num.set(num);
//	}
//	public StringProperty num() {
//		return num;
//	}
//	public String getid() {
//		return id.get();
//	}
//	public void setid(String id) {
//		this.id.set(id);
//	}
//	public StringProperty id() {
//		return id;
//	}
//	public String getpw() {
//		return pw.get();
//	}
//	public void setpw(String pw) {
//		this.pw.set(pw);
//	}
//	public StringProperty pw() {
//		return pw;
//	}
//	public String getname() {
//		return name.get();
//	}
//	public void setname(String name) {
//		this.name.set(name);
//	}
//	public StringProperty name() {
//		return name;
//	}
//	public String getbirth() {
//		return birth.get();
//	}
//	public void setbirth(String birth) {
//		this.birth.set(birth);
//	}
//	public StringProperty birth() {
//		return birth;
//	}
//	public String getgender() {
//		return gender.get();
//	}
//	public void setgender(String gender) {
//		this.gender.set(gender);
//	}
//	public StringProperty gender() {
//		return gender;
//	}
//	public String getcategory() {
//		return category.get();
//	}
//	public void setcategory(String category) {
//		this.category.set(category);
//	}
//	public StringProperty category() {
//		return category;
//	}
//	public String getsalary() {
//		return salary.get();
//	}
//	public void setsalary(String salary) {
//		this.salary.set(salary);
//	}
//	public StringProperty salary() {
//		return salary;
//	}
//	public String getdepartment() {
//		return department.get();
//	}
//	public void setdepartment(String department) {
//		this.department.set(department);
//	}
//	public StringProperty department() {
//		return department;
//	}
//	public String getposition() {
//		return position.get();
//	}
//	public void setposition(String position) {
//		this.position.set(position);
//	}
//	public StringProperty position() {
//		return position;
//	}
//	public String getplace() {
//		return place.get();
//	}
//	public void setplace(String place) {
//		this.place.set(place);
//	}
//	public StringProperty place() {
//		return place;
//	}
//	public String getphone() {
//		return phone.get();
//	}
//	public void setphone(String phone) {
//		this.phone.set(phone);
//	}
//	public StringProperty phone() {
//		return phone;
//	}
//	public String getjoin() {
//		return join.get();
//	}
//	public void setjoin(String join) {
//		this.join.set(join);
//	}
//	public StringProperty join() {
//		return join;
//	}
//	public String getemail() {
//		return email.get();
//	}
//	public void setemail(String email) {
//		this.email.set(email);
//	}
//	public StringProperty email() {
//		return email;
//	}
//	public String geteducation() {
//		return education.get();
//	}
//	public void seteducation(String education) {
//		this.education.set(education);
//	}
//	public StringProperty education() {
//		return education;
//	}
//	public String getaddress() {
//		return address.get();
//	}
//	public void setaddress(String adrress) {
//		this.address.set(adrress);
//	}
//	public StringProperty address() {
//		return address;
//	}
//	public String getimage() {
//		return image.get();
//	}
//	public void setimage(String image) {
//		this.image.set(image);
//	}
//	public StringProperty image() {
//		return image;
//	}
//}
