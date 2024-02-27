package Demo;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
interface IBooK{
	double Calculate_total();
}
abstract class boOK implements IBooK{
	public static boOK[] list;
	private String bookID,title, author, publisher, entryDate, language;
	private double unitPice, quantity;
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public double getUnitPice() {
		return unitPice;
	}
	public void setUnitPice(double unitPice) {
		this.unitPice = unitPice;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public boOK() {
		this.bookID = "";
		this.title = "";
		this.author = "";
		this.publisher = "";
		this.entryDate = "";
		this.language = "";
		this.quantity = 0;
		this.unitPice = 0;
	}
	public boOK(String bookID,String title, String language, String author, String entryDate, String publisher, double quantity, double unitPrice) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.entryDate = entryDate;
		this.language = language;
		this.publisher = publisher;
		this.quantity = quantity;
		this.unitPice = unitPrice;
	}
	void input() {
		Scanner objSc = new Scanner(System.in);
		System.out.print("BookID: ");
		this.setBookID(objSc.nextLine());
		System.out.print("Title: ");
		this.setTitle(objSc.nextLine());
		System.out.print("Author: ");
		this.setAuthor(objSc.nextLine());
		System.out.print("EntryDate: ");
		this.setEntryDate(objSc.nextLine());
		System.out.print("Publisher: ");
		this.setPublisher(objSc.nextLine());
		System.out.print("Language: ");
		this.setLanguage(objSc.nextLine());
		System.out.print("Quantity: ");
		this.setQuantity(objSc.nextDouble());
		System.out.print("UnitPrice: ");
		this.setUnitPice(objSc.nextDouble());
	}
	void output() {
		System.out.println("BookID: "+this.getBookID());
		System.out.println("Title: "+this.getTitle());
		System.out.println("Author: "+this.getAuthor());
		System.out.println("publisher: "+this.getPublisher());
		System.out.println("Language: "+this.getLanguage());
		System.out.println("EntryDate: "+this.getEntryDate());
		System.out.println("Quantity: "+this.getQuantity());
		System.out.println("UnitPrice: "+this.getUnitPice());
	}
	public double Calculate_total() {
		// TODO Auto-generated method stub
		return 0;
	}
	public abstract double Calculate_discount();
}
class TEXTBOOK extends boOK{
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public TEXTBOOK() {
		this.status = "";
	}
	public TEXTBOOK(String bookID, String title, String author,String language ,String entryDate, String publisher, double quantity, double unitPrice, String status) {
		super();
		this.status = status;
	}
	
	void input() {
		super.input();
		Scanner objSc = new Scanner(System.in);
		System.out.print("Status: ");
		this.setStatus(objSc.nextLine());
	}
	void output() {
		super.output();
		System.out.println("Status: "+this.getStatus());
	}
	public double Calculate_total() {
		double total = 0;
		total = this.getQuantity() * this.getUnitPice() - this.Calculate_discount();
		return total;
	}
	public double Calculate_discount() {
		double dis = 0;
		if(this.getStatus().equals("new")) {
			dis = this.getQuantity()*this.getUnitPice()*0.4;
		}else {
			dis = this.getQuantity()*this.getUnitPice()*0.8;
		}
		return dis;
	}
}
class STORYBOOK extends boOK{
	String storyGenre, setting;
	double tax;
	public String getStoryGenre() {
		return storyGenre;
	}
	public void setStoryGenre(String storyGenre) {
		this.storyGenre = storyGenre;
	}
	public String getSetting() {
		return setting;
	}
	public void setSetting(String setting) {
		this.setting = setting;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public STORYBOOK() {
		this.setting = "";
		this.storyGenre = "";
		this.tax = 0;
	}
	public STORYBOOK(String bookID,String title, String author,String language, String entryDate, String publisher, double quantity, double unitPrice, String storyGenre, String setting, double tax) {
		super();
		this.setting = setting;
		this.storyGenre = storyGenre;
		this.tax = tax;
	}
	void input() {
		super.input();
		Scanner objSc = new Scanner(System.in);
		System.out.print("storyGenre: ");
		this.setStoryGenre(objSc.nextLine());
		System.out.print("setting: ");
		this.setSetting(objSc.nextLine());
		System.out.print("tax: ");
		this.setTax(objSc.nextDouble());
	}
	void output() {
		super.output();
		System.out.println("storyGenre "+this.getStoryGenre() + "setting "+this.getSetting() + "tax "+this.getTax());
	}
	public double Calculate_total() {
		double total = 0;
		total = this.getQuantity() * this.getUnitPice() + this.getTax() - this.Calculate_discount();
		return total;
	}
	public double Calculate_discount() {
		double dis = 0;
		dis = this.getQuantity() * this.getUnitPice() *0.04;
		return dis;
	}
}
class BOOKLisT{
	ArrayList<boOK> list = new ArrayList<boOK>();
	int n = 0;
	private int nextBookID;
	void input() throws IOException{
		boOK[] book = new boOK[100];
		char chon, loai;
		do {
			System.out.println("TEXTBOOK(T) OR STORYBOOK(S) (T/S)");
			loai = (char) System.in.read();
			if(loai == 'T'||loai =='t') {
				book[n] = new TEXTBOOK();
			}else {
				book[n] = new STORYBOOK();
			}
			list.add(book[n]);
			System.in.skip(loai);
			book[n++].input();
			System.out.println("continue or stop(C/S)");
			chon = (char) System.in.read();
			System.in.skip(chon);
			if((n==100)||(chon =='S')||(chon =='s')) {
				break;
			}
		}while(true);
	}
	void output() {
		for(int i=0; i<list.size(); i++) {
			list.get(i).output();
		}
	}
	public void sort() {
		list.sort((o1, o2) ->Double.compare(o1.Calculate_total(), o2.Calculate_total()));
	}
	void findBook(String bookID) {
		int k=0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBookID().contains(bookID)) {
				k=i;
				System.out.println("Yes!!");
				break;
			}else {
				System.out.println("No");
			}
		}
	}
	void delete(String bookID) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBookID().contains(bookID)) {
				list.remove(i);
			}
		}
	}
	void update(String bookID) {
		for(int i = 0; i<list.size();i++) {
			if(list.get(i).getBookID().contains(bookID)) {
				list.get(i).setPublisher("kim dong");
				list.set(i, list.get(i));
			}
		}
	}
	void FileBook() throws IOException{
		BookFile.writeToFile(this);
		System.out.println("Product infor mat  ion has bee n written to the bo  ok.txt");
	}
	void menu() throws IOException{
		int chon = 0; 
		Scanner objSc =  new Scanner(System.in);
		do {
			System.out.println("|---------*MENU*--------|");
			System.out.println("|1. Add"
					+ " new             |");
			System.out.println("|2. Sh  w list           |");
			System.out.println("|3. Sort                |");
			System.out.println("|4. Upd   ate              |");
			System.out.println("|5. F  ind                |");
			System.out.println("|6. Delet   e              |");
			System.out.println("|7. Ghi Fi  le            |");
			System.out.println("|0. Ex              |");
			System.out.println("|---------END-----------|");
			System.out.println("Enter your choice: ");
			chon = objSc.nextInt();
			objSc.nextLine();
			switch(chon){
			case 1:
				input();
				break;
			case 2:
				output();
				break;
			case 3:
				sort();
				break;
			case 4:
				update("1");
				break;
			case 5:
				findBook("0");
				break;
			case 6:
				delete("1");
				break;
			case 7:
				writeToFile();
			}
		}while(chon!=0);
	}
	private void writeToFile() throws IOException {
		BookFile.writeToFile(this);
		System.out.print("Product information has been recorded in the file book.txt");
		
	}
}
class BookFile{
	public static void writeToFile(BOOKLisT bookLisT) throws IOException {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\book.txt"))){
			for(boOK book : bookLisT.list) {
				bw.write("Title Book: "+book.getTitle()+"\n");
				bw.write("Price Book: "+book.getUnitPice()+"\n");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
public class Thuchanh2{
	public static void main(String[] args) throws IOException {
		BOOKLisT list = new BOOKLisT();
		list.menu();
	}
}
