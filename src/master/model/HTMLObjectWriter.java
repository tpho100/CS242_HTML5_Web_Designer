package master.model;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import javax.swing.text.html.HTML;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private List<List<String>> Matrix = new ArrayList<List<String>>();
    private List<String> H2List = new ArrayList<>();


    public String getHtmlString() {
        return htmlString;
    }

    public void setHtmlString(String htmlString) {
        this.htmlString = htmlString;
    }

    public void getHTMLWebsiteToText(WebPage webpage){

        List<HTMLSection> sections = webpage.getSections();

        if(webpage.getHeader() != null){
            HTMLHeader header = webpage.getHeader();
            //write header if one exists

            if(header.getHeaderType().equals("IMAGE")){
                HTMLImage image=new HTMLImage(header.getHeaderImage());
                ApplicationManager.getInstance().getHtmlGenerator().setHeaderFromGUI("",image.getImageName());
                writeImage(image);
            }else if(header.getHeaderType().equals("TEXT")){
                ApplicationManager.getInstance().getHtmlGenerator().setHeaderFromGUI(header.getHeaderText());
            }else if(header.getHeaderType().equals("IMAGE&TEXT")) {
                HTMLImage image = new HTMLImage(header.getHeaderImage());
                writeImage(image);
                ApplicationManager.getInstance().getHtmlGenerator().setHeaderFromGUI(header.getHeaderText(),image.getImageName());
            }else{

            }
        }
        else
        {
            ApplicationManager.getInstance().getHtmlGenerator().setHeaderFromGUI("");
        }
        List<String> content = new ArrayList<>();
        for(HTMLSection s : sections){
            if(s.getSectionHeading() != null){
                H2List.add(s.getSectionNumber(),s.getSectionHeading());
            }

            for(HTMLObject o : s.getSectionComponents()){
                if(o instanceof HTMLParagraph){
                    HTMLParagraph paragraph = (HTMLParagraph) o;
                    content.add(((HTMLParagraph) o).getParagraph());

                }else if(o instanceof HTMLList){
                    HTMLList list = (HTMLList) o;
                    String elements = "ul:";
                    for( String listElement : list.getListElements()){
                        elements=elements+listElement+";";
                    }
                    elements=elements.substring(0,elements.length()-1);
                    content.add(elements);

                }else if(o instanceof HTMLImage){
                    HTMLImage image = (HTMLImage) o;
                    content.add("img:images/"+image.getImageName());
                    writeImage(image);
                }
            }
            Matrix.add(content);
        }
        ApplicationManager.getInstance().getHtmlGenerator().setSectionFromGUI(Matrix,H2List);

        if(webpage.getFooter() != null){
            ApplicationManager.getInstance().getHtmlGenerator().setFooterFromGUI(webpage.getFooter());
        }
        else
        {
            ApplicationManager.getInstance().getHtmlGenerator().setFooterFromGUI("");
        }
        HTMLImage image=new HTMLImage();
        image.setCount(0);
    }

    public void writeImage(HTMLImage image) //Writes JavaFx image to file
    {
        Image someImage = image.getImage();
        //write image
        File dir = new File(ApplicationManager.getInstance().getProjectDirectory()+"\\images");
        File imageFile = new File(dir,image.getImageName());
        BufferedImage bImage = SwingFXUtils.fromFXImage(someImage,null);
        try{
            ImageIO.write(bImage, "png", imageFile);
        }catch(Exception e){
            System.err.println("Problem writing image file");
        }
    }
}
