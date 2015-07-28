package com.kct.list;

public class Task implements java.io.Serializable{
	private int id;
    private String title;
    private String tag;
    private String date;
    private String comment;
//    private int imageUrl;
    
    public Task() {
    	title = "";
    	tag = "個人";
    	date = "";
    	comment = "";
    }
    
    public Task(String title, String tag, String date, String comment){
//		this.id = id;
        this.title = title;
        this.tag = tag;
//        this.imageUrl = imageUrl;
        this.date = date;
        this.comment = comment;
    }
    
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
    
    

}
