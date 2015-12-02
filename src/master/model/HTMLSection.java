package master.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thanh-Phong on 12/2/2015.
 */
public class HTMLSection extends HTMLObject {

    //Object IDs
    private String objectType = "Section";

    //Object components
    private int sectionNumber;
    private String sectionHeading;

    private List<HTMLObject> sectionComponents;

    public HTMLSection(){
        sectionNumber = 0;
        sectionHeading = "Default Heading";
    }

    public HTMLSection(int sectionNumber, String sectionHeading){
        this.sectionHeading = sectionHeading;
    }

}
