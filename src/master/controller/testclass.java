package master.controller;

import com.sun.javaws.HtmlOptions;
import master.model.HTMLFooter;
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
        section.addHTMLObject(new HTMLFooter("some footer"));

        HTMLObject object = section.getSectionObject(0);

        if( object instanceof HTMLFooter){
            try{
                System.out.println("I'm a footer");
                HTMLFooter footer = (HTMLFooter) object;
                System.out.println(footer.getFooter());
            }catch(ClassCastException cce){
                System.out.println("Did not properly cast");
                HTMLFooter footer2 = (HTMLFooter) object;
                System.out.println(footer2.getFooter());
            }

        }

    }
}
