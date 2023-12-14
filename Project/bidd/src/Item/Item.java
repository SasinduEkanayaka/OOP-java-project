package Item;

public class Item{
	
	private int code;
	private String title;	
	private String category;
	private String sprice;	
	private String description;
	private String bidtime;
	

	
	
	public Item(int code, String title, String category, String sprice, String description, String bidtime) {
		super();
		this.code = code;
		this.title = title;
		this.category = category;
		this.sprice = sprice;
		this.description = description;
		this.bidtime = bidtime;
		
	}
	
	
	
	public Item(String title, String category, String sprice, String description, String bidtime) {
		super();
		this.title = title;
		this.category = category;
		this.sprice = sprice;
		this.description = description;
		this.bidtime = bidtime;
		
	}



	public int getcode() {
		return code;
	}
	public String gettitle() {
		return title;
	}
	public String getcategory() {
		return category;
	}
	public String getsprice() {
		return sprice;
	}
	public String getdescription() {
		return description;
	}
	public String getbidtime() {
		return bidtime;
	}
	

}


