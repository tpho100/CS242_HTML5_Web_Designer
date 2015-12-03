package master.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thanh-Phong on 12/1/2015.
 */
public class HTMLList extends HTMLObject {

    private List<String> listElements;
    private String objectType;
    private int index;

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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
