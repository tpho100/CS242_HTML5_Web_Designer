package master.controller;

import master.model.HTMLHeader;
import master.model.HTMLObject;
import master.model.HTMLSection;

/**
 * Created by Thanh-Phong on 12/7/2015.
 */
public class testclass {

    //Test class for checking object types and casting unknown objects
    public static void main(String args[]){
        HTMLSection section = new HTMLSection();
        section.addHTMLObject(new HTMLHeader("some footer"));

        HTMLObject object = section.getSectionObject(0);

        if( object instanceof HTMLSection){
            try{
                System.out.println("I'm a section");
                HTMLHeader header = (HTMLHeader) object;
                System.out.println(header.getHeaderText());
            }catch(ClassCastException cce){
                System.out.println("Did not properly cast");
            }

        }

    }
}
