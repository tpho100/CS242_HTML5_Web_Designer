package master.model;

/**
 * Created by Thanh-Phong on 12/1/2015.
 */
public class HTMLParagraph extends HTMLObject {
    private String paragraph;
    private String objectType;
    private int index;

    @Override
    public String getObjectType() {
        return objectType;
    }

    public HTMLParagraph(){
       objectType = "PARAGRAPH";
    }

    public HTMLParagraph(String paragraph){
        objectType = "PARAGRAPH";
        this.paragraph = paragraph;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }
}
