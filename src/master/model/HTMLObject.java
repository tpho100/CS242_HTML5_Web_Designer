package master.model;

/**
 * Created by Thanh-Phong on 12/1/2015.
 */
public class HTMLObject {

    private String objectType;

    public HTMLObject(){
        objectType = null;
    }

    public HTMLObject(String objectType){
        this.objectType = objectType;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
}
