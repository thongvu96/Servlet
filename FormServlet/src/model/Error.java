/**
 * Error.java
 * Sep 21, 2018
 */
package model;

import java.io.Serializable;

/**
 * @author VuThong
 */
public class Error implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
