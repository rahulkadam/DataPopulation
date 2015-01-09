package com.bluestone.bazarscan.exception;

public class BSException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3694570524114294771L;
	public String message;
	public BSException()
	{
		System.out.println("Exception Occur");
	}
	public BSException(String msg)
	{
		this.message=msg;
		System.out.println(msg);
	}
	
	public String getMessage()
	{
		return message;
	}
}
