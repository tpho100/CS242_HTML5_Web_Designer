package master.model;

import javafx.scene.image.Image;
/*
 * Created by Thanh-Phong on 12/2/2015.
 */
public class HTMLHeader extends HTMLObject {

    private String objectType = "Header";
    private String headerText;
    private Image headerImage;

    public HTMLHeader(String headerText, Image headerImage){
        this.headerText = headerText;
        this.headerImage = headerImage;
    }

    public HTMLHeader(String headerText){
        this.headerText = headerText;
    }

    public String getHeaderType(){
        if( (headerImage == null) && (headerText == null) ) {
            return "EMPTY";
        }else if( (headerImage == null) && (headerText != null) ){
            return "TEXT";
        }
        else{
            return "IMAGE";
        }
    }

    public HTMLHeader(Image headerImage){
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
