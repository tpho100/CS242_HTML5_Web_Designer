package master.model;

/**
 * Created by Thanh-Phong on 12/1/2015.
 */
public class HTMLFooter extends HTMLObject {
    private String footer;
    private String objectType;

    @Override
    public String getObjectType() {
        return objectType;
    }

    public HTMLFooter(){
        objectType = "FOOTER";
    }

    public HTMLFooter(String footer){
        objectType = "FOOTER";
        this.footer = footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getFooter() {
        return footer;
    }
}
