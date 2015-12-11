package master.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thanh-Phong on 12/2/2015.
 */
public class HTMLSection extends HTMLObject {
    /**
     * Wrapper for HTML sections
     * an HTML section is basically an object with one heading
     * and a list of HTMLObjects. The HTML Objects can be
     * lists, images, paragraphs, or more sections
     */

    //Object IDs
    private String objectType;

    //Section Object components
    private int sectionNumber;
    private String sectionHeading;
    private List<HTMLObject> sectionComponents;
    private String openTag = "<section>";
    private String closeTag = "</section>";

    @Override
    public String getHTMLTags() {
        return super.getHTMLTags();
    }

    @Override
    public String getObjectType() {
        return objectType;
    }

    public HTMLSection(){
        sectionComponents = new ArrayList<>();
        objectType = "SECTION";
    }


    public HTMLSection( HTMLSection section ){
        for( int i = 0; i < section.getSectionComponents().size(); i++ ){
            sectionComponents.add( section.getSectionObject(i) );
        }
    }

    public void setHTMLObject(int index, HTMLObject obj){
        sectionComponents.set(index, obj);
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

    public void addHTMLObject( int index, HTMLObject htmlObject ){
        sectionComponents.add(index, htmlObject);
    }

    public HTMLObject getSectionObject(int index){
        return sectionComponents.get(index);
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

        //System.out.println("There exists a section component" + sectionComponents.size());
        if(sectionComponents.size() > 0){
            for( int i = 0; i < sectionComponents.size(); i++){
                if( sectionComponents.get(i).getObjectType().equals("PARAGRAPH") ){
                    indexes.add(i);
                }
            }
        }

        return indexes;
    }

    public List<Integer> getImageLocations(){
        List<Integer> indexes = new ArrayList<>();
        if(sectionComponents.size() > 0){
            for( int i = 0; i < sectionComponents.size(); i++){
                if( sectionComponents.get(i).getObjectType().equals("IMAGE") ){
                    indexes.add(i);
                }
            }
        }


        return indexes;
    }

    public List<Integer> getListLocations(){
        List<Integer> indexes = new ArrayList<>();
        int sc = sectionComponents.size();
        //System.out.println("sc size: "+sc);
        //try{
            if(sc > 0){
                for( int i = 0; i < sc; i++){
                    HTMLObject objt = sectionComponents.get(i);
                    //System.out.println(objt);
                    //System.out.println("i"+ i);
                    if( sectionComponents.get(i).getObjectType().equals("LIST")){
                        indexes.add(i);
                    }
                }
            }
        //}catch(Exception e){
            //System.err.println(e.getMessage());
            //System.err.println(e.getCause());
            //System.err.println(e.getStackTrace());
        //}


        return indexes;
    }
}
