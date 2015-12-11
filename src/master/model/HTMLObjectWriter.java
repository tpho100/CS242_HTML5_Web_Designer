package master.model;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

    public void getHTMLWebsiteToText(WebPage webpage, String fileName, String filePath){

        List<HTMLSection> sections = webpage.getSections();

        if(webpage.getHeader() != null){
            HTMLHeader header = webpage.getHeader();
            //write header if one exists

            if(header.getHeaderType().equals("IMAGE")){
                //write only header image
            }else if(header.getHeaderType().equals("TEXT")){
                //write only header text
            }else if(header.getHeaderType().equals("IMAGE&TEXT")) {
                //TODO figure out how to save image to disk, since JavaFX images have no direct save method
//                try {
//                    // retrieve image
//                    BufferedImage image = header.getHeaderImage();
//                    File outputfile = new File("saved.png");
//                    ImageIO.write(image, "png", outputfile);
//                } catch (IOException e) {
//
//                }
//                ApplicationManager.getInstance().getHtmlGenerator().setHeaderFromGUI(header.getHeaderText(),header.getHeaderImage().);
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

                    //TODO Figure out how to write single lines into list structure
                    //ApplicationManager.getInstance().getHtmlGenerator().getSectionStringMatrix().add(0,);

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
            ApplicationManager.getInstance().getHtmlGenerator().setFooterFromGUI(webpage.getFooter());
        }
    }
}
