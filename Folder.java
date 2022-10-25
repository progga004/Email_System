//Name: Progga Paromita Dutta
// Id: 114751436
// Recitation Section:5

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
/**
 * This is class which is implemented to store the information about a particular folder
 * @author progga
 *
 */
public class Folder  implements Serializable {
	private ArrayList<Email>emails;
	private String name;
	private String currentSortingMethod;
	/**
	 * This is a no argument constructor which sets the default value of the instance variables
	 */
	public Folder()
	{
		emails=new ArrayList<Email>();
		name=null;
		currentSortingMethod="0";
	}
	/**
	 * @return the bundles of e-mails
	 */
	public ArrayList<Email> getEmails()
	{
		return emails;
	}
	/**
	 * @return the name of the folder
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @return the current sorting method
	 */
	public String getSortingMethod()
	{
		return currentSortingMethod;
	}
	/**
	 * This is a setter method which sets an email to the list of e-mails
	 * @param emails-the information of an e-mail that has to be set
	 */
	public void setEmails(ArrayList<Email>emails)
	{
		this.emails=emails;
	}
	/**
	 * This is a setter method which sets the name of the folder
	 * @param name-the name that has to be set
	 */
	public void setName(String name)
	{
		this.name=name;
	}
	/**
	 * This is a setter method which sets the current sorting method 
	 * @param currentSortingMethod-the sorting method that has to be set
	 */
	public void setSortingMethod(String currentSortingMethod)
	{
		this.currentSortingMethod=currentSortingMethod;
	}
	/**
	 * This is method which adds an e-mail to the list of e-mails
	 * @param email-the information about a particular e-mail that has to be set
	 */
	public void addEmail(Email email)
	{
		if(currentSortingMethod.equals("0"))// if its date descending
			
		{
			
			emails.add(email);
			sortByDateDescending();
		}
		else if(currentSortingMethod.equals("1"))
		{
			emails.add(email);
			sortByDateAscending();
		}
		else if(currentSortingMethod.equals("2"))
		{
			emails.add(email);
			sortBySubjectAscending();
		}
		else if(currentSortingMethod.equals("3"))
		{
			emails.add(email);
			sortBySubjectDescending();
		}
		
	}
	/**
	 * This is a remove method which removes an e-mail from the list of e-mails from a particular index
	 * @param index-the index that has to be removed
	 * @return information about that particular removed e-mail
	 */
	public Email removeEmail(int index)
	{
		return emails.remove(index-1);
	}
	/**
	 * A method which sorts the e-mails according to subject ascending order
	 */
	public void sortBySubjectAscending()
	{ 
		emails.sort((o1, o2) -> o1.getSubject().compareTo(o2.getSubject()));
		currentSortingMethod="2";
		
	}
	/**
	 * A method which sorts the e-mails according to subject descending order
	 */
	public void sortBySubjectDescending()
	{
		emails.sort((o1, o2) -> o2.getSubject().compareTo(o1.getSubject()));
		currentSortingMethod="3";
		
	}
	/**
	 * A method which sorts the e-mails by date ascending
	 */
	public void sortByDateAscending()
	{
		Collections.sort(emails,Email.stu4); 
		currentSortingMethod="1";
		
	}
	/**
	 * A method which sorts the e-mails by date descending
	 */
	public void sortByDateDescending()
	{
		Collections.sort(emails,Email.stu3);
        currentSortingMethod="0";
		
		
	}
	
	/**
	 * This a method to show the e-mails at a particular index
	 * @param index-the index where the e-mail has to be shown
	 */
	public void showEmails(int index)
	{
		if(index>=1 && index<=emails.size())
		{
			System.out.printf("To: %s",emails.get(index-1).getTo());
			System.out.println();
			System.out.printf("CC: %s",emails.get(index-1).getCc());
			System.out.println();
			System.out.printf("BCC: %s",emails.get(index-1).getBcc());
			System.out.println();
			System.out.printf("Subject: %s",emails.get(index-1).getSubject());
			System.out.println();
			System.out.printf( "%s",emails.get(index-1).getBody());
			System.out.println();
			
		}
	}
	
	

}
