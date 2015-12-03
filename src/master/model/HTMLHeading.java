package master.model;

/**
 * Created by Thanh-Phong on 12/1/2015.
 */
public class HTMLHeading extends HTMLObject{

    private String heading;
    private String objectType;

    @Override
    public String getObjectType() {
        return objectType;
    }

    public HTMLHeading(){
        objectType = "HEADING";
    }

    public HTMLHeading(String heading){
        this.heading = heading;
        objectType = "HEADING";
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
}
