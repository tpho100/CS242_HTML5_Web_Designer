package master.model;

/**
 * Created by Thanh-Phong on 12/1/2015.
 */
public class HTMLParagraph extends HTMLObject {
    private String paragraph;
    private String objectType = "Paragraph";

    public HTMLParagraph(){
        paragraph = null;
    }

    public HTMLParagraph(String paragraph){
        this.paragraph = paragraph;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }
}
