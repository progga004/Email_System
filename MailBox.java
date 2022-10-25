//Name: Progga Paromita Dutta
//Id:114751436
//Recitation Section:5

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
/**
 * This is a class which is implemented to control the mailbox system
 * @author progga
 *
 */
public class MailBox implements Serializable {
  private Folder inbox; // new e-mails go here
  private Folder trash; // when an email is deleted it comes here
  public ArrayList<Folder>folders;
  public static MailBox mailbox;
  private int size2=0;
  String amPm[]={"AM","PM"};
  String month[]= {"1","2","3","4","5",
		  "6","7","8","9","10","11","12"};
  
 /**
  * this is a no-argument constructor which sets the default value to the mailbox 
  */
  public MailBox()
  {
	  inbox=new Folder();
	  trash=new Folder();
	  folders=new ArrayList<Folder>();
	  folders.add(inbox);
	  folders.add(trash);
	  folders.get(0).setName("Inbox");
	  folders.get(1).setName("Trash");

	 
  }
  /**
   * @return the size of the folders
   */
  public int getSize()
  {
	  return folders.size();
  }
 /**
  * A method which adds the folder to the bundle of folders
  * @param folder-the folder that has to be added to the folders
  * @throws IllegalArgumentException when the existing folder is present
  */
  public void addFolder(Folder folder)throws IllegalArgumentException
  {
	  try {
	  for(Folder str:folders)
	  {
		  if(str.getName()!=null && str.getName().equals(folder.getName()))
		  {
			  throw new IllegalArgumentException("No duplicate name can be given");
		  }
	  }
	  }
	  catch(IllegalArgumentException e)
	  {
		  System.out.println(e.getMessage());
	  }
	  
	  folders.add(folder);// add the folder
	 
	  
		  
  }
  /**
   * A delete method which deletes a folder from the folders
   * @param name-the name of the folder that has to be deleted
   */
  public void deleteFolder(String name)
  {
	  folders.remove(name);
	  
  }
  /**
   * A method which adds an e-mail to the inbox folder
   */
  public void composeEmail()
  {
	  Scanner input=new Scanner(System.in);
	  System.out.println("Enter recipient(To):");
	  String to=input.nextLine();
	  System.out.println("Enter carbon copy recipients(CC):");
	  String cc=input.nextLine();
	  System.out.println("Enter blind carbon copy recipients(BCC):");
	  String bcc=input.nextLine();
	  System.out.println("Enter subject line:");
	  String subject=input.nextLine();
	  System.out.println("Enter body:");
	  String body=input.nextLine();
	  Email email=new Email(to,cc,bcc,subject,body);
	  inbox.addEmail(email);
	  
	  
  }
  /**
   * A method which deletes the e-mail and adds it to the trash folder
   * @param email-the email that has to be added to trash folder
   */
  public void deleteEmail(Email email)
  {
	 trash.addEmail(email);
	 size2++;
  }
  /**
   * A method which clears the e-mails from the trash
   */
  public void clearTrash()
  {
	  int i=1;
	  for( i=1;i<=size2;i++)
	  {
		  trash.removeEmail(i);
	  }
	  System.out.println((i-1)+" item(s) has succesfully deleted");
  }
  /**
   * This is a method which prints the e-mails of a specified folder
   * @param s-the name of the folder that has to be set
   */
  public void print(String s)
  {
	  for(int i=0;i<folders.size();i++)
	  {
		  System.out.format("%-21s|        %8s        |  %-24s","Index","Time","Subject");
		  System.out.println();
		  System.out.println("-----------------------------------------------------------------");
		  if(folders.get(i).getName().equals("Inbox")) {
		          for( int j=0;j<inbox.getEmails().size();j++) {
		            System.out.format("%-21d| %d:%d%s %s/%d/%d       |%8s",(i+1),inbox.getEmails().get(i).getTimestamp().get(Calendar.HOUR),
		    		inbox.getEmails().get(i).getTimestamp().get(Calendar.MINUTE),
		    		amPm[inbox.getEmails().get(i).getTimestamp().get(Calendar.AM_PM)],
		    		month[inbox.getEmails().get(i).getTimestamp().get(Calendar.MONTH)],
		    		inbox.getEmails().get(i).getTimestamp().get(Calendar.DATE),
		    		inbox.getEmails().get(i).getTimestamp().get(Calendar.YEAR),inbox.getEmails().get(i).getSubject());
		       System.out.println();
		 
		  
		  }
			  break;}
		  else if(folders.get(i).getName().equals("Trash"))
		  {
			  for(int j=0;j<trash.getEmails().size();j++) {
				  System.out.format("%-21d| %d:%d%s %s/%d/%d       |%8s",(i+1),trash.getEmails().get(i).getTimestamp().get(Calendar.HOUR),
				    		trash.getEmails().get(i).getTimestamp().get(Calendar.MINUTE),
				    		amPm[trash.getEmails().get(i).getTimestamp().get(Calendar.AM_PM)],
				    		month[trash.getEmails().get(i).getTimestamp().get(Calendar.MONTH)],
				    		trash.getEmails().get(i).getTimestamp().get(Calendar.DATE),
				    		trash.getEmails().get(i).getTimestamp().get(Calendar.YEAR),trash.getEmails().get(i).getSubject());
				       System.out.println();
			  } break;
		  }
	  }
	  
  }
  /**
   * A method which prints the folder contents by folder name
   * @param q-the contents of the folder that has to passed
   */
  public void print(Folder q)
  {
	  System.out.format("%-21s|        %8s        |  %-24s","Index","Time","Subject");
	  System.out.println();
	  System.out.println("-----------------------------------------------------------------");
	  for(int i=0;i<q.getEmails().size();i++)
	  {
		  System.out.format("%-21d| %d:%d%s %s/%d/%d       |%8s",(i+1),q.getEmails().get(i).getTimestamp().get(Calendar.HOUR),
		    		q.getEmails().get(i).getTimestamp().get(Calendar.MINUTE),
		    		amPm[q.getEmails().get(i).getTimestamp().get(Calendar.AM_PM)],
		    		month[q.getEmails().get(i).getTimestamp().get(Calendar.MONTH)],
		    		q.getEmails().get(i).getTimestamp().get(Calendar.DATE),
		    		q.getEmails().get(i).getTimestamp().get(Calendar.YEAR),q.getEmails().get(i).getSubject());
		       System.out.println();
	  }
  }
  /**
   * this is a method which moves an e-mail to a targeted folder
   * @param email-the e-mail that has to be moved
   * @param target-the target folder where it has to be moved
   */
  public void moveEmail(Email email,Folder target)
  {
	  boolean p=false;
	  for(Folder str:folders)
	  {
		  if(str.getName()!=null && str.getName().equals(target.getName()))
		  {
			  p=true;
			  target.addEmail(email);
			  break;
		  }
		  
	  }
	  if(!p)
	  {
		 inbox.addEmail(email);// if not found the target folder, moves it to the in-box folder
		 
	  }
	 
	  
	  
  }
  /**
   * This is a method which return the folder by its name
   * @param name-the name that has to be found
   * @return the folder 
   */
  
  public Folder getFolder(String name)
  {
	  Folder target=new Folder();
	  for(Folder str:folders)
	  {
		  if(str.getName()!=null && str.getName().equals(name))
		  {
			  target=str;
			  break;
		  }
	  }
	  return target;
  }
  /**
   * This is a method which shows a list of folders
   */
  public void showFolder()
  {
	  System.out.println("Folders");
	  for(int i=0;i<folders.size();i++)
	  {
		  System.out.println(folders.get(i).getName());
	  }
  }
  
  /**
   * This is the main method which makes use of all the classes
   * @param args-unused
   */
  public static void main (String[]args)
  {
	 // trying to find whether the mailbox.obj file exists or not
	  try {
		  ObjectInputStream fin=new ObjectInputStream(new FileInputStream("mailbox.obj"));
		  mailbox=(MailBox)fin.readObject();
		  fin.close();
	  }
	  catch(Exception e)// throws exception
	  {
		  System.out.println("Previous save not found,starting with an empty mailbox.");
		  mailbox=new MailBox();
	  }
	  MailBox p=new MailBox();
	  Folder q=new Folder();
	  Email e=new Email();
	  char ch,ch1;
	  do {
		  System.out.println("Mailbox");
		  System.out.println("----------");
		  System.out.println("Inbox");
		  System.out.println("Trash");
		  System.out.println("A - Add folder");
		  System.out.println("R - Remove folder");
		  System.out.println("C - Compose email");
		  System.out.println("F - Open folder");
		  System.out.println("I - Open Inbox");
		  System.out.println("T - Open Trash");
		  System.out.println("E - Empty Trash");
		  System.out.println("Q - Quit");
		  Scanner input=new Scanner(System.in);
		  System.out.println("Enter a user option:");
		  ch=input.next().charAt(0);
		  ch1=Character.toUpperCase(ch);
		  switch(ch1)
		  {
		  case'A':
		  {
			  // asks for folder name
			  // creates and adds the folder with the specified name to the list of folders
			  input.nextLine();
			  System.out.println("Enter folder name:");
			  String st=input.nextLine();
			  q.setName(st);// q is a folder and sets the folder name
			  p.addFolder(q);// add the folder to the folders bundle
			  break;
			  
		  }
		  case'C':
		  {
			  // asks for the email specification and creates a new email and adds it
			  // to the in-box
			  
			  p.composeEmail();
			  System.out.println("Email successfully added to Inbox");
			  break;
		  }
		  case 'I':
		  {
			  // opens the folder sub-menu for the in-box
			  
			  p.print(p.inbox);
			  folderSubmenu(p,p.inbox,e,q,p.trash);
			  break;
			  
		  }
		  

		  case'F':
		  {
			  // prompts the user for folder name
			  // if folder is found, then folder sub-menu is opened for that specific folder
			  // displays all the e-mails in the folder
			  input.nextLine();
			  System.out.println("Enter folder name:");
			  String st=input.nextLine();
			  Folder target=p.getFolder(st);
			  System.out.format("%-21s|        %8s        |  %-24s","Index","Time","Subject");
			  System.out.println();
			  System.out.println("-----------------------------------------------------------------");
			  for(int i=0;i<target.getEmails().size();i++)
			  {
				  System.out.format("%-21d| %d:%d%s %s/%d/%d       |%8s",(i+1),target.getEmails().get(i).getTimestamp().get(Calendar.HOUR),
				    		target.getEmails().get(i).getTimestamp().get(Calendar.MINUTE),
				    		p.amPm[target.getEmails().get(i).getTimestamp().get(Calendar.AM_PM)],
				    		p.month[target.getEmails().get(i).getTimestamp().get(Calendar.MONTH)],
				    		target.getEmails().get(i).getTimestamp().get(Calendar.DATE),
				    		target.getEmails().get(i).getTimestamp().get(Calendar.YEAR),target.getEmails().get(i).getSubject());
				      System.out.println();
			  }
			  folderSubmenu(p,q,e,p.inbox,p.trash);
			  break;
		  }
		  case 'R':
		  {
			  // asks for folder name
			  // removes the folder if the given name of the folder exists
			  input.nextLine();
			  System.out.println("Enter the folder name:");
			  String st=input.nextLine();
			  for(int i=0;i<p.folders.size();i++)
			  {
				  if(p.folders.get(i).getName().equals(st))//name is found
				  {
					 if(st.equals("Inbox")) 
					 {
						 p.deleteFolder(st);;
						 break;
					 }
					 else if(st.equals("Trash"))
					 {
						 p.deleteFolder(st);
						 break;
					 }
					 else
					 {
						
						 p.deleteFolder(st);
						
						 break;
					 }
				  }
				  else
				  {
					  System.out.println("Folder is not found");
					  break;
				  }
			  }
			  break;
		  }
		  case 'T':
		  {
			  // opens the folder sub-menu for the trash
			  p.print(p.trash);
			  folderSubmenu(p,p.trash,e,q,p.inbox);
			  break;
		  }
		  case 'E':
		  {
			  // empties trash folder of all e-mails
			  p.clearTrash();
			  
			  break;
		  }
		  case 'Q':
		  {
			  // quits the program
			  // writes the objects to the file
			  
			 try {
			 ObjectOutputStream fout=new ObjectOutputStream(new FileOutputStream("mailbox.obj"));
			 fout.writeObject(mailbox);
			 fout.close();
		  }
			 catch(IOException a)// throws exception
			 {
				 
			 }
			 System.out.println("Program successfully exited and mailbox saved");
			 break;
		  
		  }
		  }
	  
  }while(ch1!='Q');
  
  }
  

  public static void folderSubmenu(MailBox p, Folder q,Email e,Folder r,Folder f)
  {
	  System.out.println("M - Move email");
	  System.out.println("D - Delete email");
	  System.out.println("V - View email contents");
	  System.out.println("SA - Sort by subject line in ascending order");
	  System.out.println("SD - Sort by subject line in descending order");
	  System.out.println("DA -Sort by date in ascending order");
	  System.out.println("DD - Sort by date in descending order");
	  System.out.println("R -Return to mailbox");
	  String s2,s3="";
	  Scanner input=new Scanner(System.in);
	  do {
		  System.out.println("Enter a user option:");
		  s2=input.next();
		  s3=s2.toUpperCase();
		 switch(s3)
		 {
		 case "M":
		 {
			//asks the user for email index
			  //displays a list of folders
			  // asks the user for the input
			  //if the folder not found, cancel the entire operation
			  
			input.nextLine();
			 System.out.println("Enter the index of the mail to remove:");
			 int index=input.nextInt();
			 String move="";
			 move=q.getName();
			 String s=q.getEmails().get(index-1).getSubject();
			 e=q.removeEmail(index);
			 
			 p.showFolder();
			  input.nextLine();
			  System.out.println("Select a folder to move "+s+" to:");
			  String st=input.nextLine();
			  boolean k=false;
			  for(int i=0;i<p.folders.size();i++)
			  {
				  if(p.folders.get(i).getName().equals(st))//name is found
				  
				  { if(st.equalsIgnoreCase("Inbox")) 
					 {
						 
						 p.moveEmail(e, p.inbox);
						 System.out.println(s+" has successfully moved to "+st);
						 System.out.println(move);
						 
						  System.out.println(move+" is empty");
						  k=true;
					 }
					 
					 if(st.equalsIgnoreCase("Trash"))
					 {
						 
						 p.moveEmail(e, p.trash);
						 System.out.println(s+" has successfully moved to "+st);
						 System.out.println(move);
						 System.out.println(move+" is empty");
						 k=true;
					 }
					 else
					 {
						if(r!=p.inbox && r!=p.trash)
						 
						{ p.moveEmail(e, r);
						System.out.println(s+" has successfully moved to "+st);
						   System.out.println(move);
						   System.out.println(move+" is empty");
							k=true;}
						else if(q!=p.inbox && q!=p.trash)
						{
							p.moveEmail(e, q);
							System.out.println(s+" has successfully moved to "+st);
							 System.out.println(move);
							  System.out.println(move+" is empty");
							  k=true;
						}
						else
						{
							p.moveEmail(e, f);
							System.out.println(s+" has successfully moved to "+st);
							 System.out.println(move);
							 System.out.println(move+" is empty");
							 k=true;
						}
						 
						 
						
					 }
					 
					 
				 break; }
				 

					 
			  }
			  if(!k)
			  {
				  
					  System.out.println("File not found for moving");
					  break;
				  
			  }
			  break;
		 }
	
			  
		 
		  case "R":
		  {
			  // return to main menu
			  // this is sub-menu
			  break;
		  }
		  case "V":
		  {
			  //view email contents
			  //asks for email index
			  // prints the info about that particular email
			  input.nextLine();
			  System.out.println("Enter email index:");
			  int n=input.nextInt();
			  String move="";
	
				 move=q.getName();
				 q.showEmails(n);
			     System.out.println(move);
			     System.out.format("%-21s|        %8s        |  %-24s","Index","Time","Subject");System.out.println();
				  System.out.println("-----------------------------------------------------------------");
				  System.out.format("%-21d| %d:%d%s %s/%d/%d       |%8s",1,q.getEmails().get(n-1).getTimestamp().get(Calendar.HOUR),
				    		q.getEmails().get(n-1).getTimestamp().get(Calendar.MINUTE),
				    		p.amPm[q.getEmails().get(n-1).getTimestamp().get(Calendar.AM_PM)],
				    		p.month[q.getEmails().get(n-1).getTimestamp().get(Calendar.MONTH)],
				    		q.getEmails().get(n-1).getTimestamp().get(Calendar.DATE),
				    		q.getEmails().get(n-1).getTimestamp().get(Calendar.YEAR),q.getEmails().get(n-1).getSubject());
				       System.out.println();
				  break;
			 
		  }
		  case "SA":
		  {
			 // sorts the e-mails by subject in ascending order 
			  q.sortBySubjectAscending();
			  break;
		  }
		  case "SD":
		  {
			  // sorts the e-mails by subject in descending order
			  q.sortBySubjectDescending();
			  break;
		  }
		  case "DA":
		  {
			  // sort the e-mails by date ascending order
			  q.sortByDateDescending();
			  
			  break;
		  }
		  case "DD":
		  {
			  // sorts the e-mails by date descending order
			  q.sortByDateDescending();
			   break;
		  }
		  case "D":
		  {
			  // asks to the user for email index
			  // moves the email to trash folder
			  System.out.println("Enter email index:");
			  int n=input.nextInt();
			  p.deleteEmail(q.getEmails().get(n-1));
			 
			  System.out.println(q.getEmails().get(n-1).getSubject()+
					  " has successfully moved to the trash");
			  System.out.println(q.getName());
			  System.out.println(q.getName()+" is empty");
			  q.removeEmail(n);
			  break;
		  }
		 }
	  }while(!s3.equals("R"));
  }}
