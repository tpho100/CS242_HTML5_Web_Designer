package master.model;

/**
 * Created by Thanh-Phong on 12/1/2015.
 */
public class HTMLParagraph extends HTMLObject {

    /**
     * Object representation of an HTML paragraph
     * It is basically a String
     */

    private String paragraph;
    private String objectType;
    private String openTag = "<p>";
    private String closeTag = "</p>";

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


    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public String getHTMLCode() {
        return openTag + paragraph + closeTag;
    }
}
