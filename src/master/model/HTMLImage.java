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
    private int counter = 0;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName + ".png" ;
    }

    public HTMLImage(Image image){
        this.image = image;
        count++;
        counter = count;
        imageName = "image" + counter + ".png";
        objectType = "IMAGE";
    }

    public HTMLImage(){
        count++;
        counter = count;
        imageName = "image" + counter + ".png";
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
    public void setCount(int i)
    {
        this.count=i;
    }
    public int getCount()
    {
        return count;
    }
}
