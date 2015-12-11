package master.model;

import java.io.File;
import java.util.List;

/**
 * Created by Thanh-Phong on 12/2/2015.
 */
public class ApplicationManager {

    /**
     * When this object is invoked, a new instance of 1 WebPage will be made
     * All information being added, removed, or changed must be done through this class
     * This class keeps the WebPage instance alive until the user quits the program
     */

    private final static ApplicationManager instance = new ApplicationManager();
    private WebPage currentWebPage = new WebPage(); //Used for website data
    private JavaToHTML htmlGenerator = new JavaToHTML(); //Helper class

    private String projectName;
    private File projectFolder;
    private String projectDirectory;
    private String template = "template1"; //Default template selected.

    public static ApplicationManager getInstance(){
        return instance;
    }
    public WebPage getCurrentWebPage(){
        return currentWebPage;
    }
    public void changeTemplate(String template){
        this.template = template;
        System.out.println("Changed template to: " + template);
        //needs more code to copy appropriate CSS file to project directory
    }
    public void addSectionToWebPage( HTMLSection section ){
        currentWebPage.addSection(section);
        System.out.println("Added new section to webpage");
    }
    public void removeSectionFromWebPage(int index){
        currentWebPage.removeSection(index);
        System.out.println("Removed section at: " + index);
    }
    public void clearWebPageHeader(){
        currentWebPage.clearHeader();
    }
    public void clearWebPageFooter(){
        currentWebPage.clearFooter();
    }
    public void setWebPageHeader(HTMLHeader header){
        currentWebPage.setHeader(header);
    }
    public void setWebPageFooter(String footer){
        currentWebPage.setFooter(footer);
    }
    public void setProjectName(String projectName){
        this.projectName = projectName;
        //use this name to name the project directory folder
    }
    public void setProjectDirectory(String projectDirectory){
        this.projectDirectory = projectDirectory;
        //needs more code to create project directory
    }
    public void setProjectFolder(File folder){
        this.projectFolder = folder;
    }
    public File getProjectFolder() {
        return projectFolder;
    }
    public String getProjectDirectory() {
        return projectDirectory;
    }
    public String getProjectName() {
        return projectName;
    }
    public List<HTMLSection> getSectionsFromWebPage(){
        return currentWebPage.getSections();
    }

    public JavaToHTML getHtmlGenerator() //Added by James
    {
        return htmlGenerator;
    }
    public String getTemplate()
    {
        return template;
    }
}
