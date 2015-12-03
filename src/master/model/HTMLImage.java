package master.model;

import javafx.scene.image.Image;

/**
 * Created by Thanh-Phong on 12/3/2015.
 */
public class HTMLImage extends HTMLObject {

    private String objectType;
    private Image image;
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

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

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    private String imageFileName;
}
