package master.model; /**
 *
 */

/**
 * @author DAVIDMOSTO
 *
 */
public interface HTMLStringDefinitions {
	String path = "./path/template/";
	String templateName = "template";
	String html = ".html";

	String urlBegin = "<a href=";
	String urlEnd = "</a>";

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

	String sectionBegin = "<!--$sectionBegin-->";
	String sectionEnd = "<!--$sectionEnd-->";
	String sectionH2Begin = "<!--$sectionH2Begin";
	String sectionH2End = "<!--$sectionH2End";

	String paragraphBegin = "<!--$pBegin";
	String paragraphEnd = "<!--$pEnd";

	String uListBegin = "<!--$ulBegin";
	String uListEnd = "<!--$ulEnd";

	String oListBegin = "<!--$olBegin";
	String oListEnd = "<!--$olEnd";

	String headerBegin = "<!--$headerBegin-->";
	String headerEnd = "<!--$headerEnd-->";

	String headerImgBegin = "<!--$headerImgBegin-->";
	String headerImgEnd = "<!--$headerImgEnd-->";

	String headerH1Begin = "<!--$headerH1Begin-->";
	String headerH1End = "<!--$headerH1End-->";

	String styleSheetBegin = "<!--$styleSheetBegin-->";
	String styleSheetEnd = "<!--$styleSheetEnd-->";

	String dividerBegin = "<!--$dividerBegin-->";
	String dividerEnd = "<!--$dividerEnd-->";
}
