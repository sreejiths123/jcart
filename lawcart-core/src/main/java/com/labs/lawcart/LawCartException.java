/**
 * 
 */
package com.labs.lawcart;

/**
 * @author Siva
 *
 */
public class LawCartException  extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public LawCartException()
	{
		super();
	}

	public LawCartException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LawCartException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public LawCartException(String message)
	{
		super(message);
	}

	public LawCartException(Throwable cause)
	{
		super(cause);
	}
	
}
