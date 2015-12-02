package master.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thanh-Phong on 12/1/2015.
 */
public class HTMLList extends HTMLObject {

    private List<String> listElements;
    private String objectType = "List";

    public HTMLList(List<String> listElements){
        this.listElements = new ArrayList<String>();
        this.listElements = listElements;
    }

    public HTMLList(){
        this.listElements = new ArrayList<String>();
    }

    public List<String> getListElements() {
        return listElements;
    }

    public void setListElements(List<String> listElements) {
        this.listElements = listElements;
    }
}
