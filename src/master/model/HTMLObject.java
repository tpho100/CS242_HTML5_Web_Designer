package master.model;

/**
 * Created by Thanh-Phong on 12/1/2015.
 */
public class HTMLObject {

    /**
     * Tagger for HTML objects. All HTML webcomponents
     * inherit from this object. Every HTML object contains an objectType
     * such as Header, Image, List, Paragraph, or Section
     *
     * HTML tags are partially implemented into their
     * corresponding objects
     */

    private String objectType;
    private String openTag;
    private String closeTag;

    public HTMLObject(){
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

    public String getHTMLTags(){
        return openTag+closeTag;
    }
}
