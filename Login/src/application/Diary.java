package application;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Diary {

	private String title;
	private String entry;
	private int userId;
	private Date datePosted;


	public Diary(String title, String entry, int id, Date date) {
		// TODO Auto-generated constructor stub

		this.title = title;
		this.entry = entry;
		this.userId = id ;
		this.datePosted = date;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getEntry() {
		return entry;
	}


	public void setEntry(String entry) {
		this.entry = entry;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public Date getDatePosted() {
		return datePosted;
	}


	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}
	
	
	public String toString() 
    { 
		SimpleDateFormat format =  new SimpleDateFormat("EEE MMM dd yyyy");
        return format.format(datePosted) + "\t " + title ; 
    }

}
