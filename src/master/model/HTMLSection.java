package master.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thanh-Phong on 12/2/2015.
 */
public class HTMLSection extends HTMLObject {

    //Object IDs
    private String objectType;

    //Section Object components
    private int sectionNumber;
    private String sectionHeading;
    private List<HTMLObject> sectionComponents;

    public HTMLSection(){
        sectionComponents = new ArrayList<>();
        objectType = "SECTION";
    }

    public HTMLSection(int sectionNumber, String sectionHeading){
        objectType = "SECTION";
        this.sectionNumber = sectionNumber;
        this.sectionHeading = sectionHeading;
        sectionComponents = new ArrayList<>();
    }

    public void addHTMLObject(HTMLObject htmlObject){
        sectionComponents.add(htmlObject);
    }

    public void removeHTMLObject(int index){
        sectionComponents.remove(index);
    }

    public List<HTMLObject> getSectionComponents(){
        return sectionComponents;
    }

    public void setSectionComponents(List<HTMLObject> sectionComponents){
        this.sectionComponents = sectionComponents;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public void setSectionHeading(String sectionHeading) {
        this.sectionHeading = sectionHeading;
    }

    public String getSectionHeading() {
        return sectionHeading;
    }

    public List<Integer> getParagraphLocations(){
        List<Integer> indexes = new ArrayList<>();

        for( int i = 0; i < sectionComponents.size(); i++){
            if( sectionComponents.get(i).getObjectType().equals("PARAGRAPH") ){
                indexes.add(i);
            }
        }
        return indexes;
    }

    public List<Integer> getImageLocations(){
        List<Integer> indexes = new ArrayList<>();

        for( int i = 0; i < sectionComponents.size(); i++){
            if( sectionComponents.get(i).getObjectType().equals("IMAGE") ){
                indexes.add(i);
            }
        }
        return indexes;
    }

    public List<Integer> getListLocations(){
        List<Integer> indexes = new ArrayList<>();

        for( int i = 0; i < sectionComponents.size(); i++){
            if( sectionComponents.get(i).getObjectType().equals("LIST") ){
                indexes.add(i);
            }
        }
        return indexes;
    }
}
