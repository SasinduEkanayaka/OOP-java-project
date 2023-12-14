package cont;

public class Contact{
	
	private int id;
	private String name;	
	private String email;
	private String message;	

	

	
	
	public Contact(int id, String name, String email, String message) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.message = message;
	
		
	}
	
	
	
	public Contact(String name, String email, String message) {
		super();
		this.name = name;
		this.email = email;
		this.message = message;
	
		
	}



	public int getid() {
		return id;
	}
	public String getname() {
		return name;
	}
	public String getemail() {
		return email;
	}
	public String getmessage() {
		return message;
	}


}


