package master.model;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thanh-Phong on 11/24/2015.
 */
public class WebPage extends HTMLObject{

    private HTMLHeader header;
    private String footer;
    private List<HTMLSection> sections;

    public WebPage(){
        header = null;
        footer = null;
        sections = new ArrayList<>();
    }

    public WebPage(HTMLHeader header, String footer){
        this.header = header;
        this.footer = footer;
        sections = new ArrayList<>();
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public HTMLHeader getHeader(){
        return header;
    }

    public void setHeader(HTMLHeader header) {
        this.header = header;
    }

    public List<HTMLSection> getSections() {
        return sections;
    }

    public void setSections(List<HTMLSection> sections) {
        this.sections = sections;
    }
}
