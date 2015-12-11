package master.model;

import javafx.scene.image.Image;

/**
 * Created by Thanh-Phong on 12/3/2015.
 */
public class HTMLImage extends HTMLObject {

    /**
     * Wrapper for standard images. Supports all standard types
     * such as PNG, JPEG, etc.
     */

    private String objectType;
    private Image image;

    public HTMLImage(Image image){
        this.image = image;
        objectType = "IMAGE";
    }

    public HTMLImage(){
        objectType = "IMAGE";
    }

    @Override
    public String getObjectType() {
        return objectType;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
