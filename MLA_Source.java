import java.util.*;
/**
 * MLA Citation Class
 *
 * @author (Irwin Frimpong)
 * @version (Version 1)
 */
public class MLA_Source
{
    // Instance variables of information on sources
    private String art_title, author_f, author_l,web_title, publisher, url, DOP, DOA; //DOA: Date of Access // DOP: Date of Publication
    private String journal_title,journal_art_tit,volume, issue_num, year, pgs ;
    private String book_title, COP; //COP - City of Publication

    // Openung and closing paranthesis used for all the citations
    private String open_q = "“" ;
    private String closing_q = "”";

    //Variable Holding The Number of Authors for Publication
    private int num_auth ;  // Be used in the sitaution where we have multiple authors for a publication

    // Optimizing the program in the instance where we hav multiple authors for a piece

    ArrayList<String> auth_l = new ArrayList<String>() ; //Last Names
    ArrayList<String> auth_f = new ArrayList<String>() ; //First Names

    /**
     * Constructor for objects of class MLA_Source
     */
    //Constructor for citing articles
    public MLA_Source(String a_t, ArrayList<String> auth_f, ArrayList<String> auth_l, String w_t, String pub, String web_url, String date , String date_accessed)
    {
        this.art_title = a_t;
        this.auth_f = auth_f;
        this.auth_l = auth_l;
        this.web_title = w_t;
        this.publisher = pub;
        this.url = web_url;
        this.DOP = date;
        this.DOA = date_accessed ;

    }

    //Constructor for citing journals

    public MLA_Source( ArrayList<String> author_f, ArrayList<String> author_l, String jar_t, String j_t,  String vol, String issue, String Year, String pgs, int auth_num)
    {
        this.journal_art_tit = jar_t;
        this.journal_title = j_t ;
        this.auth_f = author_f;
        this.auth_l = author_l;
        this.volume= vol;
        this.issue_num = issue;
        this.year= Year;
        this.pgs = pgs;
        this.num_auth = auth_num ;

    }

    //Constructor for citing books

    public MLA_Source(String b_t, ArrayList<String> auth_f, ArrayList<String>auth_l, String city_pub, String pub, String date_pub, String pgs)
    {
        this.book_title = b_t ;
        this.auth_f = auth_f;
        this.auth_l = auth_l;
        this.COP= city_pub;
        this.publisher= pub;
        this.year= date_pub;
        this.pgs = pgs;

    }

    /**
     * Method to format the authors
     *
     * @return String authors
     */
    public String auth_format()
    {
        // Loop through both arraylist creating a string that will be placed in the place for authors
        String authors ; // Holding the name(s)
        authors = auth_l.get(0) + "," + auth_f.get(0); // First name has to be in tha last name, first name format

        for( int i=1; i<auth_l.size(); i++) { //subsequent author names appear in first name last name format.
            int check = (i-1);
            if ( check == auth_l.size()) {
                authors = ", and " + auth_f + " " + auth_l ;
            }
            else {

                authors= ", " + auth_f + " " + auth_l ;
            }
        }

        return authors;

    }

    /**
     * Method to Create MLA with article
     *
     * @return String MLA Citiation of
     */
    public String MLA_article_cite()
    {

        return auth_format() + "." + " " + open_q + art_title + "." + closing_q +" " + web_title + "," + DOP + "," + url+ "," + "Accessed " + DOA ;
    }

    /**
     * Method to Create MLA for journals
     *
     * @return String MLA Citiation of
     */

    public String MLA_journal_cite()
    {

        return author_l + "," + author_f + "." + open_q + journal_art_tit+ "."+ closing_q + " " + journal_title + "," + " " + volume + "," + " " + issue_num + "," + " " + year + "," + " "+ pgs + "." ;

    }

    /**
     * Method to Create MLA for books
     *
     * @return String MLA Citiation of
     */

    public String MLA_book_cite() {

        return author_l + "," + author_f + ". "+ book_title + ". " + COP +", " + publisher + ", "+ year + "." ;

    }

}

