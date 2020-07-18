import java.util.Scanner ;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
/**
 * Class for generating citations
 *
 * @author (Irwin Frimpong)
 * @version (Version 1)
 */
public class Citation_Generator
{
    // instance variables - replace the example below with your own
    private ArrayList<String> auth_l , auth_f ;
    private String title , year ;

    /**
     * Constructor for objects of class Citation_Generator
     */
    public Citation_Generator()
    {
        auth_l = new ArrayList<String>() ;
        auth_f = new ArrayList<String>() ;

    }

    // Main Method of Progran
    public static void main (String[] args){
        Citation_Generator test_MLA = new Citation_Generator() ;
        test_MLA.run() ;
    }

    public void run() {
        // Create an instance of MLA Source Generator
        Citation_Generator test = new Citation_Generator();
        //System.out.println (test.MLA_journal_cite()) ;      .
        test.createCitation() ;

    }

    /**
     * Method to for asking the user for paramters needed for citation
     *
     * @return String MLA citation of a requested
     */
    public void createCitation() {
        // Intiaizing Scanner for using input
        Scanner sel= new Scanner(System.in) ;
        int selection=0; // Hold the  Choice of the user
        int num_sources ; // Hold the number of citations that the user wants to process
        try {
            // Intializing Print Writer
            File file = new File ("Citation_Output.txt") ;
            PrintWriter ptwt = new PrintWriter(file) ;

            //ptwt.println("Testing the Printing") ;

            // First ask what type of citation they would be perfoming
            System.out.println ("*****************************" ) ;
            System.out.println ("* Select The Type Of Source *" ) ;
            System.out.println ("*    (1)  Book              *" ) ;
            System.out.println ("*    (2) Online Article     *" ) ;
            System.out.println ("*    (3) Journal Article    *" ) ;
            System.out.println ("*****************************" ) ;

            System.out.println(" \n How many sources will you be citing: " ) ;
            num_sources = sel.nextInt();

            for ( int i =0; i < num_sources ; i++) {
                // Find out the selection of the user
                System.out.println ( " Selection: " ) ;
                selection= sel.nextInt();

                while ( selection < 1 || selection > 3) { // Error checkubg
                    // Then use a series of if statemtents to decifer what constructor to call to create the citaition
                    System.out.println ( " Selection: " ) ;
                    selection= sel.nextInt();
                }

                // Scanner used to take in user in
                Scanner reader = new Scanner (System.in) ;

                if ( selection == 1 ) { // Book Selection

                     System.out.println (" Book Title: " ) ;
                     title = reader.nextLine() ;

                     // //Debugging
                     System.out.println ( " Title: " + title) ;

                     System.out.println (" Author's Last Name: ") ;
                     auth_l = reader.nextLine() ;

                     // Debugging
                     System.out.println ( " Author's Last Name " + auth_l) ;

                     System.out.println ( "Author's First Name: ") ;
                     auth_f = reader.nextLine() ;

                     System.out.println ( "City of Publication: ") ;
                     String COP = reader.nextLine();

                     System.out.println ( "Publisher: " ) ;
                     String PUB = reader.nextLine() ;

                     System.out.println ( "Year: " ) ;
                     year = reader.nextLine() ;

                     System.out.println ( "Pages: " ) ;
                     String pgs = reader.nextLine();

                     //Create an instance of MLA Source with Parameters
                     MLA_Source book = new MLA_Source ( title, auth_f , auth_l , COP, PUB, year,pgs) ;
                    //Printing Out the Citation
                     System.out.println (book.MLA_book_cite()) ;
                    ptwt.println(book.MLA_book_cite()) ;
                }
                else if ( selection == 2 ) { // Online Article Selection

                    System.out.println (" Article Title: " ) ;
                    title = reader.nextLine() ;

                    // Ask for # Authors
                    System.out.println ( " Number of Authors: " ) ;
                    int num_auth = reader.nextInt();

                    for ( int j = 0; j <num_auth ; j++) {

                        Scanner reader1 = new Scanner (System.in) ;

                        System.out.println (" Author[" + (j+1) +"]'s Last Name: ") ;
                        auth_l.add(reader1.nextLine()) ;

                        System.out.println ( "Author [" + (j+1) +"]'s First Name: ") ;
                        auth_f.add(reader1.nextLine());
                    }

                    System.out.println ( "Website Title: " );
                    String web_tit = reader.nextLine() ;

                    System.out.println ( "Publisher: " ) ;
                    String PUB = reader.nextLine() ;

                    System.out.println ( "URL: " );
                    String url = reader.nextLine() ;

                    System.out.println ( "Date of Publication: " ) ;
                    String DOP = reader.nextLine() ;

                    System.out.println ( "Date Acccessed: " ) ;
                    String DOA = reader.nextLine();

                    //Creating Instance of MLA Citiatin of an article online
                    MLA_Source article = new MLA_Source( title, auth_f, auth_l, web_tit, PUB, url, DOP,DOA);
                    //Printing Out Citatoin
                    System.out.println ( article.MLA_article_cite() ) ;
                    ptwt.println (article.MLA_article_cite());

                }
                else if (selection == 3) { // Journal Article

                     System.out.println( "Journal Article Title: " ) ;
                     title = reader.nextLine() ;

                    System.out.println( "Journal Title: " ) ;
                    String j_title = reader.nextLine() ;

                         System.out.println (" Author's Last Name: ") ;
                         auth_l = reader.nextLine() ;

                         System.out.println ( "Author's First Name: ") ;
                         auth_f = reader.nextLine() ;

                         System.out.println ( " Volume # : " );
                         String vol = reader.nextLine();

                         System.out.println ( "Issue: " ) ;
                         String issue = reader.nextLine() ;

                         System.out.println ( "Year: " ) ;
                         year = reader.nextLine();

                         System.out.println ("Pages: " ) ;
                         String pgs = reader.nextLine();

                         //Creating instance of MLA Citation of a journal article
                         MLA_Source journal = new MLA_Source (auth_f , auth_l, title, j_title , vol, issue , year, pgs, 1);
                         // Printing Out Citation
                         System.out.println ( journal.MLA_journal_cite()) ;
                         ptwt.println( journal.MLA_journal_cite());

                }

            }
            // CLosing print writer
            ptwt.close();
        }
        catch (Exception e) {
            System.out.println ("Exception occured " + e);

        }
    }

}
