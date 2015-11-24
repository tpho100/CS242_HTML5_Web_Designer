package master.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thanh-Phong on 11/24/2015.
 */
public class WebPage extends ArrayList{

    private List<String> headings = new ArrayList<String>();
    private List<String> footers = new ArrayList<String>();
    private List<String> sections = new ArrayList<String>();
    private List<String> paragraphs = new ArrayList<String>();
    private List< List<String> > weblists = new ArrayList< List<String> >(); //Basically a list of lists.

    public List<String> getFooters() {
        return footers;
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
