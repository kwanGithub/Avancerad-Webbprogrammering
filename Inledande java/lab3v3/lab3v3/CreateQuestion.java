package lab3v3;

/**
 * This class is to define how a question object should be.
 * 
 * @author Kevin Truong
 * @version 1.3
 */
public class CreateQuestion 
{
	/** The capital name. */
	private String capital;

	/** The country name. */
	private String country;

	/**
	 * To create a new question.
	 * A question must be associated to a {country, capital}
	 * 
	 * @param Country is the country name
	 * @param captial is the countrys capital
	 */
	public CreateQuestion(final String country, final String capital) 
	{
		this.country = country;
		this.capital = capital;
	}

	/**
	 * @return Capital returns name of the Capital
	 */
	public String getCapital() 
	{
		return capital;
	}

	/**
	 * @return coutyir returns name of the Country
	 */
	public String getCountry() 
	{
		return country;
	}

}
