package master.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thanh-Phong on 12/1/2015.
 */
public class HTMLList extends HTMLObject {

    /**
     * Wrapper for HTML lists.
     * An HTMLList is basically a wrapper around
     * an ArrayList.
     */

    private List<String> listElements;
    private String objectType;
    private String openTag = "<ul>";
    private String closeTag = "</ul>";
    private String listItemOpenTag = "<li>";
    private String listItemCloseTag = "</li>";

    @Override
    public String getHTMLCode() {
        String listItems = "";

        for(String s : listElements){
            listItems = listItemOpenTag + s + listItemCloseTag + "\n";
            //returns <li>item1</li> each time
        }

        return openTag + listItems + closeTag;
        //returns <ul>full list items</ul>
    }

    @Override
    public String getObjectType() {
        return objectType;
    }

    public HTMLList(List<String> listElements){
        objectType = "LIST";
        this.listElements = new ArrayList<String>();
        this.listElements = listElements;
    }

    public HTMLList(){
        this.listElements = new ArrayList<String>();
        objectType = "LIST";
    }

    public List<String> getListElements() {
        return listElements;
    }

    public void setListElements(List<String> listElements) {
        this.listElements = listElements;
    }
}
