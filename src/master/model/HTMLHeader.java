package master.model;

import javafx.scene.image.Image;
/*
 * Created by Thanh-Phong on 12/2/2015.
 */
public class HTMLHeader extends HTMLObject {

    /**
     * Wrapper for HTML Headers
     * HTMLHeader can either be a picture, text, or both.
     * This object manages itself if the header is missing an image
     * or text.
     */

    private String objectType;
    private String headerText;
    private Image headerImage;
    private String openTag = "<header>";
    private String closeTag = "</header>";
    private String headerTextOpenTag = "<H1>";
    private String headerTextCloseTag = "</H1>";
    private String headerImageOpenTag = "<a href=";

    @Override
    public String getObjectType() {
        return objectType;
    }

    public HTMLHeader(String headerText, Image headerImage){
        objectType = "HEADER";
        this.headerText = headerText;
        this.headerImage = headerImage;
    }

    public HTMLHeader(String headerText){
        objectType = "HEADER";
        this.headerText = headerText;
    }

    public String getHeaderType(){
        if( (headerImage == null) && (headerText == null) ) {
            return "EMPTY";
        }else if( (headerImage == null) && (headerText != null) ){
            return "TEXT";
        }
        else if( (headerImage != null) && (headerText == null) ){
            return "IMAGE";
        }else{
            return "IMAGE&TEXT";
        }
    }

    public HTMLHeader(Image headerImage){
        objectType = "HEADER";
        this.headerImage = headerImage;
    }

    public Image getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(Image headerImage) {
        this.headerImage = headerImage;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public String getHeaderText() {
        return headerText;
    }
}
