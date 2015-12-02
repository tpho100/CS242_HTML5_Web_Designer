package master.model;

/**
 * Created by Thanh-Phong on 12/1/2015.
 */
public class HTMLFooter extends HTMLObject {
    private String footer;
    private String objectType = "Footer";

    public HTMLFooter(){
        footer = null;
    }

    public HTMLFooter(String footer){
        this.footer = footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getFooter() {
        return footer;
    }
}
