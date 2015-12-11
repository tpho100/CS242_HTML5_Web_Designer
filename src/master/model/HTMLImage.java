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
    private String imageName;
    private static int count = 0;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public HTMLImage(Image image){
        this.image = image;
        imageName = "image" + count;
        objectType = "IMAGE";
    }

    public HTMLImage(){
        imageName = "image" + count;
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

    @Override
    public String getHTMLCode() {
        String code = "<img src=\"" + imageName + "\">";
        return code;
    }
}
