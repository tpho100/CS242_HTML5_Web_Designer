package master.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thanh-Phong on 11/24/2015.
 */
public class WebPage{

    private List<String> headings = new ArrayList<String>();
    private List<String> sections = new ArrayList<String>();
    private List<String> paragraphs = new ArrayList<String>();
    private List< List<String> > weblists = new ArrayList< List<String> >(); //Basically a list of lists.

    private String footer;
    private String header;

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getHeader(){
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<String> getHeadings() {
        return headings;
    }

    public List<String> getParagraphs() {
        return paragraphs;
    }

    public List<String> getSections() {
        return sections;
    }

    public List<List<String>> getWeblists() {
        return weblists;
    }

}
