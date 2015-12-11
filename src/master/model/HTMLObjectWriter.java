package master.model;

import javafx.scene.image.Image;

import java.util.List;

/**
 * Created by James Dapp on 12/8/2015.
 */
public class HTMLObjectWriter {

    /**
     * This class is used to convert the information in a WebPage object into
     * actual HTML code. The primary information in a webpage are the sections
     * and the primary information in sections are lists, paragraphs, or images.
     * The Object writer checks what each object is and handles each object independently.
     */

    private String htmlString;

    public String getHtmlString() {
        return htmlString;
    }

    public void setHtmlString(String htmlString) {
        this.htmlString = htmlString;
    }

    public void getHTMLWebsiteToText(WebPage webpage, String fileName){
        List<HTMLSection> sections = webpage.getSections();

        if(webpage.getHeader() != null){
            HTMLHeader header = webpage.getHeader();
            //write header if one exists

            if(header.getHeaderType() == "IMAGE"){
                //write only header image
            }else if(header.getHeaderType() == "TEXT"){
                //write only header text
            }else if(header.getHeaderType() == "IMAGE&TEXT") {
                //write header image and text
            }else{

            }
        }

        for(HTMLSection s : sections){

            if(!s.getSectionHeading().isEmpty()){
                //Write section heading first
            }

            for(HTMLObject o : s.getSectionComponents()){
                if(o instanceof HTMLParagraph){
                    HTMLParagraph paragraph = (HTMLParagraph) o;
                    //write paragraph

                }else if(o instanceof HTMLList){
                    HTMLList list = (HTMLList) o;
                    for( String listElement : list.getListElements()){
                        //write list element
                    }

                }else if(o instanceof HTMLImage){
                    HTMLImage image = (HTMLImage) o;
                    Image someImage = image.getImage();
                    //write image
                }
            }
        }

        if(!webpage.getFooter().isEmpty()){
            //write footer
        }
    }
}
