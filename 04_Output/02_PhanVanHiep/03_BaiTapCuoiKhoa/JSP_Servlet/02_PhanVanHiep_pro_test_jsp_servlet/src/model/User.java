/**
 * Copyright(C) 2020  Luvina Software
 * User.java, Jun 16, 2020 Phan Van Hiep
 */
package model;

/**
 * Description:  
 * @author Phan Van Hiep
 */
public class User {
	private int id;
	private String name;
	private String birthday;
	private String birthPlace;
	/**
	 * 
	 */
	public User() {
		super();
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the birthPlace
	 */
	public String getBirthPlace() {
		return birthPlace;
	}
	/**
	 * @param birthPlace the birthPlace to set
	 */
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	
}
