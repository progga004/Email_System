//Name:Progga Paromita Dutta
// Id:114751436
// Recitation section: 5
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Comparator;
/**
 * This class is implemented to store information about a particular email
 * @author Progga
 *
 */
public class Email implements Serializable,Comparable{

	private String to;
	private String cc;
	private String bcc;
	private String subject;
	private String body;
	private GregorianCalendar timestamp;
	/**
	 * This is a no argument constructor which sets the default value to the instance variables
	 */
	public Email()
	{
		
	}
	/**
	 * This is an argument constructor which is used to construct an object of the instance variable
	 * @param to-the recipient to whom an e-mail is sent
	 * @param cc-the carbon copy recipients
	 * @param bcc-the black carbon copy recipients
	 * @param subject-the subject of the email
	 * @param body-the body of the email
	 */
	public Email(String to,String cc, String bcc,String subject,String body)
	{
		this.to=to;
		this.cc=cc;
		this.bcc=bcc;
		this.subject=subject;
		this.body=body;
		timestamp=new GregorianCalendar();
	}
	/**
	 * @return the literal to field
	 */
	public String getTo()
	{
		return to;
	}
	/**
	 * @return the literal cc field
	 */
	public String getCc()
	{
		return cc;
	}
	/**
	 * @return the literal bcc field
	 */
	public String getBcc()
	{
		return bcc;
	}
	/**
	 * @return the literal subject field
	 */
	public String getSubject()
	{
		return subject;
	}
	/**
	 * @return the literal body field
	 */
	public String getBody()
	{
		return body;
	}
	/**
	 * @return the time when the email was created
	 */
	public GregorianCalendar getTimestamp()
	{
		return timestamp;
	}
	/**
	 * This is a setter method which sets the to field
	 * @param to-the to field that has to be set
	 */
	public void setTo(String to)
	{
		this.to=to;
	}
	/**
	 * This is a setter method which sets the cc field
	 * @param cc-the cc field that has to be set
	 */
	public void setCc(String cc)
	{
		this.cc=cc;
	}
	/**
	 * This is a setter method which sets the bcc field 
	 * @param bcc-the bcc field that has to be set
	 */
	public void setBcc(String bcc)
	{
		this.bcc=bcc;
	}
	/**
	 * This is a setter method which sets the subject field 
	 * @param subject-the subject field that has to be set
	 */
	public void setSubject(String Subject)
	{
		this.subject=subject;
	}
	/**
	 * This is a setter method which sets the body field 
	 * @param body-the body field that has to be set
	 */
	public void setBody(String body)
	{
		this.body=body;
	}
	/**
	 * This is a setter method which sets the time of the email creation
	 * @param timestamp-the time field that has to be set when created
	*/
	public void setTimestamp(GregorianCalendar timestamp)
	{
		this.timestamp=timestamp;
	}
	/**
	 * This is a comparator method to compare the subject of the objects in ascending order
	 */
	public static Comparator<Email>stu1=new Comparator<Email>() {
	 public int compare(Email e1,Email e2)
	 {
		 String subject1=e1.getSubject().toUpperCase();
		 String subject2=e2.getSubject().toUpperCase();
		 return subject1.compareTo(subject2);// ascending order
	 }
	};
	/**
	 * This is a comparator method to compare the subjects of the e-mails and arrange them in descending order
	 */
	public static Comparator<Email>stu2=new Comparator<Email>() {
		 public int compare(Email e1,Email e2)
		 {
			 String subject1=e1.getSubject().toUpperCase();
			 String subject2=e2.getSubject().toUpperCase();
			 return subject2.compareTo(subject1);// descending order
		 }
		};
	/**
	 * This is a comparator method which compares the date in ascending order
	 */
		public static Comparator<Email> stu3=new Comparator<Email>()
		{
			public int compare(Email e1,Email e2)
			{
				GregorianCalendar first1=e1.getTimestamp(); 
				GregorianCalendar first2=e2.getTimestamp(); 
				return first1.compareTo(first2); 
			}
			
		}; 
		/**
		 * This is a comparator method which compares the date in descending order
		 */
		public static Comparator<Email> stu4=new Comparator<Email>()
		{
			public int compare(Email e1,Email e2)
			{
				GregorianCalendar first1=e1.getTimestamp(); 
				GregorianCalendar first2=e2.getTimestamp(); 
				return first2.compareTo(first1); 
			}
			
		}; 
		/**
		 * A method which represents the string
		 */
	public String toString()
	{
		return ""+getTimestamp().get(Calendar.DAY_OF_YEAR);
	}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	
	
	
	
	
	

		
	
	
}
