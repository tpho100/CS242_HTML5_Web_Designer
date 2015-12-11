package master.model;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thanh-Phong on 11/24/2015.
 */
public class WebPage extends HTMLObject{

    /**
     * Object representation of a website
     * A webpage has 1 header, 1 footer, and multiple sections
     * The multiple sections are handled using an ArrayList so that
     * the number of sections can easily be added, deleted, searched, etc.
     */

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

    public void addSection(int index, HTMLSection section){
        sections.add(index, section);
    }

    public void addSection(HTMLSection section){
        sections.add(section);
    }

    public void removeSection(int index){
        sections.remove(index);
    }

    public void setSection(int index, HTMLSection section){
        sections.set(index, section);
    }

    public void clearHeader(){
        header = null;
    }

    public void clearFooter(){
        footer = null;
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
