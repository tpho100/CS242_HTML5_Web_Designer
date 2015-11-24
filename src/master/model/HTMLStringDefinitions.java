package master.model; /**
 * 
 */

/**
 * @author dmost_000
 *
 */
public interface HTMLStringDefinitions {
	String path = "path/";
	String html = ".html";
	String templateName = "template";
	String urlAppend = "<a href=";
	
	String titleBeginComment = "<!--$titleBegin-->";
	String titleEndComment = "<!--$titleEnd-->";
	String titleBegin = titleBeginComment+"\n\t"+"<title>";
	String titleEnd = "</title>"+"\n\t"+titleEndComment;
	
	String bodyBeginComment = "<!--$bodyBegin-->";
	String bodyEndComment = "<!--$bodyEnd-->";

	String navBeginComment = "<!--$navBegin-->";
	String navEndComment = "<!--$navEnd-->";
	String navBegin = navBeginComment + "\n\t" + "<nav>";
	String navEnd = "</nav>" + "\n\t" + navEndComment;
	
	// Will be appended to the end of any comment that had more then one
	String commentEnding = "-->";

	String bodySectionBegin = "<!--$bodySectionBegin";
	String bodySectionEnd = "<!--$bodySectionEnd";
		
	String paragraphBegin = "<!--$pBegin";
	String paragraphEnd = "<!--$pEnd";
	
	String uListBegin = "<!--$ulBegin";
	String uListEnd = "<!--$ulEnd";
	
	String oListBegin = "<!--$olBegin";
	String oListEnd = "<!--$olEnd";
}
