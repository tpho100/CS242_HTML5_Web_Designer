package master.model;

import java.io.File;

/**
 * Created by Thanh-Phong on 12/2/2015.
 */
public class ApplicationManager {

    private final static ApplicationManager instance = new ApplicationManager();
    private WebPage currentWebPage = new WebPage(); //Used for website data
    private JavaToHTML htmlGenerator = new JavaToHTML(); //Helper class

    private String projectName;
    private File projectFolder;
    private String projectDirectory;

    public static ApplicationManager getInstance(){
        return instance;
    }

    public WebPage getCurrentWebPage(){
        return currentWebPage;
    }

    public void addSectionToWebPage( HTMLSection section ){
        currentWebPage.addSection(section);
    }
    public void removeSectionFromWebPage(int index){
        currentWebPage.removeSection(index);
    }
    public void setWebPageHeader(HTMLHeader header){
        currentWebPage.setHeader(header);
    }
    public void setWebPageFooter(String footer){
        currentWebPage.setFooter(footer);
    }
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }
    public void setProjectDirectory(String projectDirectory){
        this.projectDirectory = projectDirectory;
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

}
