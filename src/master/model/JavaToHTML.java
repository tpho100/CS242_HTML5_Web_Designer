package master.model; /**
 *
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
/**
 * @author DAVID MOSTO
 *
 */
public class JavaToHTML implements HTMLStringDefinitions {
	static String htmlString;
	static String originalFileName;
	static String newFileName;

	// HTML File Strings
	static String titleString = "";
	static String styleSheetString = "";
	static String bodyString = "";
	static String headerString = "";
	static String headerImgString = "";
	static String headerH1String = "";
	static String navString = "";
	static String navNameString = "";
	static String navLinkString = "";
	static String sectionString = "";
	static List<List<String>> sectionStringMatrix = new ArrayList<List<String>>();
	static List<String> sectionH2String = new ArrayList<>();
	static String footerString = "";

	public JavaToHTML(){

	}

	public static void main(String[] args) {

		htmlString = "";
		originalFileName = "index.html";
		newFileName = "test";

		readFromFile( path + originalFileName );

		List<List<String>> testMatrix = new ArrayList<List<String>>();
		List<String> testH2List = new ArrayList<>();

		List<String> testList1 = new ArrayList<>();

		testList1.add("text1");
		testList1.add("ul:List Object 1;List Object 2;List Object 3");
		testList1.add("ol:List Object 1;List Object 2;List Object 3");
		testList1.add("img:images/test.png");

		testMatrix.add(testList1);

		List<String> testList2 = new ArrayList<>();

		testList2.add("text1");
		testList2.add("img:images/test.png");

		testMatrix.add(testList2);

		List<String> testList3 = new ArrayList<>();

		testList3.add("text1");
		testList3.add("ul:List Object 1;List Object 2;List Object 3");
		testList3.add("ol:List Object 1;List Object 2;List Object 3");

		testMatrix.add(testList3);

		testH2List.add("Header 1");
		testH2List.add("");
		testH2List.add("Header 3");

		setTitleFromGUI("Hello");
		setStyleSheetFromGUI("styles");
		setHeaderFromGUI("Hello Header", "test.png");
		//setHeaderFromGUI("Hello Header");
		setNavFromGUI("Test 0;Test 1;Test 2;Test 3","#;#;#;#");
		setSectionFromGUI(testMatrix, testH2List);
		setFooterFromGUI("Test Footer");
		writeToFile( newFileName , path);

	}

	/*
	 	Main Reader & Writers of File
  	*/
	public static void readFromFile(String fileName){
		String FileName = fileName;
		File originalFile = new File(FileName); // Loads the Template File
		try {
			// Read from the HTML File originalFile and stores it within the String htmlString
			htmlString = FileUtils.readFileToString( originalFile );
			// Initial Calls to break down htmlString and store them in their respective locations
			getTitleFromHTML();
			getStyleSheetFromHTML();
			getBodyString();
			getHeaderString();
			getHeaderImgString();
			getHeaderH1String();
			getNavString();
			getSectionString();
			getFooterString();
			//writeToFile(fileName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void writeToFile(String fileName, String savePath){
		String FileName = fileName + html;
		File newFile = new File( savePath +"\\"+ FileName );
		try {
			// Takes htmlString and writes it to the file newFile
			FileUtils.writeStringToFile(newFile, htmlString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 	Setter for the File Names
	*/
	public static void setOriginalFile(String changeFileName){
		originalFileName = changeFileName;
		return;
	}
	public static void setNewFile(String changeFileName){
		newFileName = changeFileName;
		return;
	}

	/*
	 	Getters from HTML File
	*/

	// Returns the title to titleString
	public static String getTitleFromHTML(){
		int beginIndex; // Location of "<" in "<!--$titleBegin-->"
		int endIndex; // Location of ">" in "<!--$titleEnd-->"
		String titleB = "<title>";
		String titleE = "</title>";

		try {
			beginIndex = htmlString.indexOf(titleBeginComment)+titleBeginComment.length();
			endIndex = htmlString.indexOf(titleEndComment);
			titleString = htmlString.substring(beginIndex, endIndex);
			titleString = titleString.replaceAll("\\r", "");
			titleString = titleString.replaceAll("\\n", "");
			titleString = titleString.replaceAll("\\t", "");
			titleString = titleString.replaceAll(titleB, "");
			titleString = titleString.replaceAll(titleE, "");
			titleString = titleString.trim();
		} catch (StringIndexOutOfBoundsException ignored){

		}

		return titleString;
	}
	// Returns the style sheet to styleSheetString
	public static String getStyleSheetFromHTML(){
		int beginIndex;
		int endIndex;
		String styleSheetB = "<link href=\"";
		String styleSheetE = "\" rel=\"stylesheet\" type=\"text/css\"/>";

		try {
			beginIndex = htmlString.indexOf(styleSheetBegin)+styleSheetBegin.length();
			endIndex = htmlString.indexOf(styleSheetEnd);
			styleSheetString = htmlString.substring(beginIndex, endIndex);
			styleSheetString = styleSheetString.replaceAll("\\r", "");
			styleSheetString = styleSheetString.replaceAll("\\n", "");
			styleSheetString = styleSheetString.replaceAll("\\t", "");
			styleSheetString = styleSheetString.replaceAll(styleSheetB, "");
			styleSheetString = styleSheetString.replaceAll(styleSheetE, "");
			styleSheetString = styleSheetString.trim();
		} catch (StringIndexOutOfBoundsException ignored){

		}

		return styleSheetString;
	}
	// returns the body to bodyString
	public static String getBodyString(){
		int beginIndex;
		int endIndex;
		String bodyB = "<body>";
		String bodyE = "</body>";

		try {
			beginIndex = htmlString.indexOf(bodyBeginComment)+bodyBeginComment.length();
			endIndex = htmlString.indexOf(bodyEndComment);
			bodyString = htmlString.substring(beginIndex, endIndex);
			bodyString = bodyString.replaceAll(bodyB, "");
			bodyString = bodyString.replaceAll(bodyE, "");
		} catch (StringIndexOutOfBoundsException ignored){

		}

		return bodyString;
	}
	// returns the header to the headerString
	public static String getHeaderString(){
		int beginIndex;
		int endIndex;
		String headerB = "<header>";
		String headerE = "</header>";

		try {
			beginIndex = htmlString.indexOf(headerBegin)+headerBegin.length();
			endIndex = htmlString.indexOf(headerEnd);
			headerString = htmlString.substring(beginIndex, endIndex);
			headerString = headerString.replaceAll(headerB, "");
			headerString = headerString.replaceAll(headerE, "");
		} catch (StringIndexOutOfBoundsException ignored){

		}

		return headerString;
	}
	// returns the header image to headerImgString
	public static String getHeaderImgString(){
		int beginIndex;
		int endIndex;
		String headerImgB = "<a href=\"index.html\"><img src=\"images/";
		String headerImgE = "\"/></a>";

		try {
			beginIndex = htmlString.indexOf(headerImgBegin)+headerImgBegin.length();
			endIndex = htmlString.indexOf(headerImgEnd);
			headerImgString = htmlString.substring(beginIndex, endIndex);
			headerImgString = headerImgString.replaceAll("\\r", "");
			headerImgString = headerImgString.replaceAll("\\n", "");
			headerImgString = headerImgString.replaceAll("\\t", "");
			headerImgString = headerImgString.replaceAll(headerImgB, "");
			headerImgString = headerImgString.replaceAll(headerImgE, "");
			headerImgString = headerImgString.trim();
		} catch (StringIndexOutOfBoundsException ignored){

		}

		return headerImgString;
	}
	// returns the header h1 to the headerH1String
	public static String getHeaderH1String(){
		int beginIndex;
		int endIndex;
		String headerH1B = "<h1>";
		String headerH1E = "</h1>";

		try {
			beginIndex = htmlString.indexOf(headerH1Begin)+headerH1Begin.length();
			endIndex = htmlString.indexOf(headerH1End);
			headerH1String = htmlString.substring(beginIndex, endIndex);
			headerH1String = headerH1String.replaceAll("\\r", "");
			headerH1String = headerH1String.replaceAll("\\n", "");
			headerH1String = headerH1String.replaceAll("\\t", "");
			headerH1String = headerH1String.replaceAll(headerH1B, "");
			headerH1String = headerH1String.replaceAll(headerH1E, "");
			headerH1String = headerH1String.trim();
		} catch(StringIndexOutOfBoundsException ignored){

		}

		return headerH1String;
	}
	// returns the navigation to the navString
	public static void getNavString(){
		int beginIndex;
		int endIndex;
		boolean flag = true;
		String tempLink;
		String tempName;
		String navB = "<nav>";
		String navE = "</nav>";
		String tabLinkB = "<a href=\"";
		String tabLinkE = "\">";
		String tabNameB = "\">";
		String tabNameE = "</a>";
		int endComma;

		try {
			beginIndex = htmlString.indexOf(navBegin)+navBegin.length();
			endIndex = htmlString.indexOf(navEnd);
			navString = htmlString.substring(beginIndex, endIndex);
			navString = navString.replaceAll("\\r", "");
			navString = navString.replaceAll("\\n", "");
			navString = navString.replaceAll("\\t", "");
			navString = navString.replaceAll(navB, "");
			navString = navString.replaceAll(navE, "");
			navString = navString.trim();

			while (flag){
				if ( navString.contains("<a href=") ){
					beginIndex = navString.indexOf(tabLinkB)+tabLinkB.length();
					endIndex = navString.indexOf(tabLinkE);
					tempLink = navString.substring(beginIndex, endIndex);
					navLinkString = navLinkString + tempLink + ";";

					beginIndex = navString.indexOf(tabNameB)+tabNameB.length();
					endIndex = navString.indexOf(tabNameE);
					tempName = navString.substring(beginIndex, endIndex);
					navNameString = navNameString + tempName + ";";

					navString = navString.substring(endIndex + tabNameE.length());
					navString = navString.trim();
				}
				else{
					endComma = navLinkString.lastIndexOf(";");
					navLinkString = navLinkString.substring(0, endComma);
					endComma = navNameString.lastIndexOf(";");
					navNameString = navNameString.substring(0, endComma);
					flag = false;
				}
			}
		} catch (StringIndexOutOfBoundsException ignored){

		}
	} // Links stored in navNameString, names stored in navNameString
	public static void getSectionString(){ // Headers stored in sectionH2String, rest of data stored in sectionStringMatrix
		int beginIndex;
		int endIndex;
		int tempBeginIndex;
		int tempEndIndex;
		int removeBeginIndex;
		int removeEndIndex;
		String removeString;
		boolean sectionFlag = true;
		boolean contentFlag = true;
		boolean listFlag = true;
		String sectionB = "<section>";
		String sectionE = "</section>";
		String tempSectionString;
		String tempContentString;
		String tempListString;
		String tempListComplete;


		try {
			beginIndex = htmlString.indexOf(sectionBegin)+sectionBegin.length();
			endIndex = htmlString.indexOf(sectionEnd);
			sectionString = htmlString.substring(beginIndex, endIndex);
			sectionString = sectionString.replaceAll("\\r", "");
			sectionString = sectionString.replaceAll("\\n", "");
			sectionString = sectionString.replaceAll("\\t", "");
			sectionString = sectionString.replaceAll(sectionB, "");
			sectionString = sectionString.replaceAll(sectionE, "");
			sectionString = sectionString.trim();

			while (sectionFlag){
				if (sectionString.contains(bodySectionBegin)){
					tempBeginIndex = sectionString.indexOf(bodySectionBegin);
					tempEndIndex = sectionString.indexOf("-->", tempBeginIndex)+("-->").length();
					tempSectionString = sectionString.substring(tempBeginIndex, tempEndIndex);
					beginIndex = sectionString.indexOf(tempSectionString)+tempSectionString.length();

					tempBeginIndex = sectionString.indexOf(bodySectionEnd);
					tempEndIndex = sectionString.indexOf("-->", tempBeginIndex)+("-->").length();
					tempSectionString = sectionString.substring(tempBeginIndex, tempEndIndex);
					endIndex = sectionString.indexOf(tempSectionString);

					tempSectionString = sectionString.substring(beginIndex, endIndex);
					tempSectionString = tempSectionString.trim();

					if (tempSectionString.contains("<h2>")){
						tempBeginIndex = tempSectionString.indexOf(sectionH2Begin);
						tempEndIndex = tempSectionString.indexOf("-->", tempBeginIndex)+("-->").length();
						tempContentString = tempSectionString.substring(tempBeginIndex, tempEndIndex);
						removeBeginIndex = tempSectionString.indexOf(tempContentString);
						beginIndex = tempSectionString.indexOf(tempContentString)+tempContentString.length();

						tempBeginIndex = tempSectionString.indexOf(sectionH2End);
						tempEndIndex = tempSectionString.indexOf("-->", tempBeginIndex)+("-->").length();
						tempContentString = tempSectionString.substring(tempBeginIndex, tempEndIndex);
						removeEndIndex = tempSectionString.indexOf(tempContentString)+tempContentString.length();
						endIndex = tempSectionString.indexOf(tempContentString);

						tempContentString = tempSectionString.substring(beginIndex, endIndex);
						tempContentString = tempContentString.trim();
						tempContentString = tempContentString.replace("<h2>", "");
						tempContentString = tempContentString.replace("</h2>", "");

						removeString = tempSectionString.substring(removeBeginIndex,removeEndIndex);
						tempSectionString = tempSectionString.replace(removeString, "");
						tempSectionString = tempSectionString.trim();
						sectionH2String.add(tempContentString);
					}
					else{
						sectionH2String.add("");
					}

					List<String> row = new ArrayList<String>();

					while (contentFlag){
						if (!tempSectionString.equals("")){
							tempBeginIndex = 0;
							tempEndIndex = tempSectionString.indexOf("-->", tempBeginIndex)+("-->").length();
							tempContentString = tempSectionString.substring(tempBeginIndex, tempEndIndex);
							removeBeginIndex = tempSectionString.indexOf(tempContentString);
							beginIndex = tempSectionString.indexOf(tempContentString)+tempContentString.length();

							if ( tempContentString.contains(paragraphBegin) ){ // Paragraph
								tempBeginIndex = tempSectionString.indexOf(paragraphEnd);
								tempEndIndex = tempSectionString.indexOf("-->", tempBeginIndex)+("-->").length();
								tempContentString = tempSectionString.substring(tempBeginIndex, tempEndIndex);
								removeEndIndex = tempSectionString.indexOf(tempContentString)+tempContentString.length();
								endIndex = tempSectionString.indexOf(tempContentString);

								tempContentString = tempSectionString.substring(beginIndex, endIndex);
								tempContentString = tempContentString.trim();
								tempContentString = tempContentString.replace("<p>", "");
								tempContentString = tempContentString.replace("</p>", "");

								removeString = tempSectionString.substring(removeBeginIndex,removeEndIndex);
								tempSectionString = tempSectionString.replace(removeString, "");
								tempSectionString = tempSectionString.trim();
								row.add(tempContentString);
							}
							else if (tempContentString.contains(uListBegin)){
								tempListComplete = "";
								tempBeginIndex = tempSectionString.indexOf(uListEnd);
								tempEndIndex = tempSectionString.indexOf("-->", tempBeginIndex)+("-->").length();
								tempContentString = tempSectionString.substring(tempBeginIndex, tempEndIndex);
								removeEndIndex = tempSectionString.indexOf(tempContentString)+tempContentString.length();
								endIndex = tempSectionString.indexOf(tempContentString);

								tempContentString = tempSectionString.substring(beginIndex, endIndex);
								tempContentString = tempContentString.trim();
								tempContentString = tempContentString.replace("<ul>", "");
								tempContentString = tempContentString.replace("</ul>", "");
								tempContentString = tempContentString.trim();

								removeString = tempSectionString.substring(removeBeginIndex,removeEndIndex);
								tempSectionString = tempSectionString.replace(removeString, "");
								tempSectionString = tempSectionString.trim();

								while(listFlag){
									if (tempContentString.contains("<li>")){
										tempBeginIndex = tempContentString.indexOf("<li>");
										tempEndIndex = tempContentString.indexOf("</li>");

										tempListString = tempContentString.substring(tempBeginIndex+("<li>").length(),tempEndIndex);
										tempListComplete = tempListComplete + tempListString + ";";
										removeString = tempContentString.substring(tempBeginIndex, tempEndIndex+("</li>").length());
										tempContentString = tempContentString.replace(removeString, "");
										tempContentString = tempContentString.trim();
									}
									else{
										listFlag = false;
										tempEndIndex = tempListComplete.lastIndexOf(";");
										tempListComplete = tempListComplete.substring(0, tempEndIndex);
										tempListComplete = "ul:" + tempListComplete;
									}
								}

								listFlag = true;

								row.add(tempListComplete);
							}
							else if (tempContentString.contains(oListBegin)){
								tempListComplete = "";
								tempBeginIndex = tempSectionString.indexOf(oListEnd);
								tempEndIndex = tempSectionString.indexOf("-->", tempBeginIndex)+("-->").length();
								tempContentString = tempSectionString.substring(tempBeginIndex, tempEndIndex);
								removeEndIndex = tempSectionString.indexOf(tempContentString)+tempContentString.length();
								endIndex = tempSectionString.indexOf(tempContentString);

								tempContentString = tempSectionString.substring(beginIndex, endIndex);
								tempContentString = tempContentString.trim();
								tempContentString = tempContentString.replace("<ol>", "");
								tempContentString = tempContentString.replace("</ol>", "");
								tempContentString = tempContentString.trim();

								removeString = tempSectionString.substring(removeBeginIndex,removeEndIndex);
								tempSectionString = tempSectionString.replace(removeString, "");
								tempSectionString = tempSectionString.trim();

								while(listFlag){
									if (tempContentString.contains("<li>")){
										tempBeginIndex = tempContentString.indexOf("<li>");
										tempEndIndex = tempContentString.indexOf("</li>");

										tempListString = tempContentString.substring(tempBeginIndex+("<li>").length(),tempEndIndex);
										tempListComplete = tempListComplete + tempListString + ";";
										removeString = tempContentString.substring(tempBeginIndex, tempEndIndex+("</li>").length());
										tempContentString = tempContentString.replace(removeString, "");
										tempContentString = tempContentString.trim();
									}
									else{
										listFlag = false;
										tempEndIndex = tempListComplete.lastIndexOf(";");
										tempListComplete = tempListComplete.substring(0, tempEndIndex);
										tempListComplete = "ol:" + tempListComplete;
									}
								}

								listFlag = true;

								row.add(tempListComplete);
							}
							else if (tempContentString.contains(imgBegin)){
								tempBeginIndex = tempSectionString.indexOf(imgEnd);
								tempEndIndex = tempSectionString.indexOf("-->", tempBeginIndex)+("-->").length();
								tempContentString = tempSectionString.substring(tempBeginIndex, tempEndIndex);
								removeEndIndex = tempSectionString.indexOf(tempContentString)+tempContentString.length();
								endIndex = tempSectionString.indexOf(tempContentString);

								tempContentString = tempSectionString.substring(beginIndex, endIndex);
								tempContentString = tempContentString.trim();
								tempContentString = tempContentString.replace("<img src=\"", "");
								tempContentString = tempContentString.replace("\"/>", "");
								tempContentString = tempContentString.replace("\" />", "");
								removeString = tempSectionString.substring(removeBeginIndex,removeEndIndex);
								tempSectionString = tempSectionString.replace(removeString, "");
								tempSectionString = tempSectionString.trim();
								row.add("img:" + tempContentString);
							}
						}
						else{
							contentFlag = false;
							sectionStringMatrix.add(row);

							tempBeginIndex = sectionString.indexOf(bodySectionBegin);
							tempEndIndex = sectionString.indexOf("-->", tempBeginIndex)+("-->").length();
							tempSectionString = sectionString.substring(tempBeginIndex, tempEndIndex);
							beginIndex = sectionString.indexOf(tempSectionString);

							tempBeginIndex = sectionString.indexOf(bodySectionEnd);
							tempEndIndex = sectionString.indexOf("-->", tempBeginIndex)+("-->").length();
							tempSectionString = sectionString.substring(tempBeginIndex, tempEndIndex);
							endIndex = sectionString.indexOf(tempSectionString)+tempSectionString.length();

							tempSectionString = sectionString.substring(beginIndex, endIndex);
							tempSectionString = tempSectionString.trim();
							sectionString = sectionString.replace(tempSectionString, "");
							sectionString = sectionString.trim();

							if (sectionString.contains(dividerBegin)){
								beginIndex = sectionString.indexOf(dividerBegin);
								endIndex = sectionString.indexOf(dividerEnd)+dividerEnd.length();
								tempSectionString = sectionString.substring(beginIndex, endIndex);
								sectionString = sectionString.replace(tempSectionString, "");
								sectionString = sectionString.trim();
							}
						}
					}
					contentFlag = true;
				}
				else{
					sectionFlag = false;
				}
			}
		} catch(StringIndexOutOfBoundsException ignored){

		}
	}
	// returns the footer to the footerString
	public static String getFooterString(){
		int beginIndex;
		int endIndex;
		String footerB = "<footer>";
		String footerE = "</footer>";
		String footerH4B = "<h4>";
		String footerH4E = "</h4>";

		try {
			beginIndex = htmlString.indexOf(footerBegin)+footerBegin.length();
			endIndex = htmlString.indexOf(footerEnd);
			footerString = htmlString.substring(beginIndex, endIndex);
			footerString = footerString.replaceAll(footerB, "");
			footerString = footerString.replaceAll(footerE, "");
			footerString = footerString.replaceAll("\\r", "");
			footerString = footerString.replaceAll("\\n", "");
			footerString = footerString.replaceAll("\\t", "");
			footerString = footerString.replaceAll("<h4>", "");
			footerString = footerString.replaceAll("</h4>", "");
			footerString = footerString.trim();
		} catch (StringIndexOutOfBoundsException ignored){

		}

		return footerString;
	}

	/*
		Variable Getters
		General Purpose is to Return any extra values would not be returned
		from just the running of their general getter functions.
	*/
	public static String getNavNameString(){
		return navNameString;
	}
	public static String getNavLinkString(){
		return navLinkString;
	}
	public static List<String> getSectionH2String(){
		return sectionH2String;
	}
	public static List<List<String>> getSectionStringMatrix() {
		return sectionStringMatrix;
	}

	/*
	 	Setters to HTML File
	*/
	public static boolean setTitleFromGUI(String title_String){
		int beginIndex; // Location of "<" in "<!--$titleBegin-->"
		int endIndex; // Location of ">" in "<!--$titleEnd-->"
		String titleB = "<title>";
		String titleE = "</title>";
		String titleString_NEW;

		try {
			beginIndex = htmlString.indexOf(titleBeginComment);
			endIndex = htmlString.indexOf(titleEndComment)+titleEndComment.length();
			titleString = htmlString.substring(beginIndex, endIndex);
			titleString_NEW = titleBeginComment + "\r\n" + titleB + title_String + titleE + "\r\n" + titleEndComment;
			htmlString = htmlString.replace(titleString, titleString_NEW);
			//writeToFile(newFileName);
			//readFromFile(newFileName);
			return true;
		} catch (StringIndexOutOfBoundsException ignored){
			return false;
		}

	}
	public static boolean setStyleSheetFromGUI(String styleSheet_String){
		int beginIndex;
		int endIndex;
		String styleSheetB = "<link href=\"";
		String styleSheetE = "\" rel=\"stylesheet\" type=\"text/css\"/>";
		String styleSheetString_NEW;

		try {
			beginIndex = htmlString.indexOf(styleSheetBegin);
			endIndex = htmlString.indexOf(styleSheetEnd)+styleSheetEnd.length();
			styleSheetString = htmlString.substring(beginIndex, endIndex);
			styleSheetString_NEW = styleSheetBegin + "\r\n" + styleSheetB + styleSheet_String + ".css" + styleSheetE + "\r\n" + styleSheetEnd;
			htmlString = htmlString.replace(styleSheetString, styleSheetString_NEW);
			//writeToFile(newFileName);
			//readFromFile(newFileName);
			return true;
		} catch (StringIndexOutOfBoundsException ignored){
			return false;
		}
	}
	public static boolean setHeaderFromGUI(String headerH1_String, String headerImg_String){ // Initial for if there is an IMG&Test or Just IMG
		int beginIndex;
		int endIndex;
		String headerB = "<header>";
		String headerE = "</header>";
		String headerImgB = "<a href=\"index.html\"><img src=\"images/";
		String headerImgE = "\"/></a>";
		String headerH1B = "<h1>";
		String headerH1E = "</h1>";

		String headerString_NEW;

		try {
			beginIndex = htmlString.indexOf(headerBegin);
			endIndex = htmlString.indexOf(headerEnd)+headerEnd.length();
			headerString = htmlString.substring(beginIndex, endIndex);
			headerString_NEW = headerBegin + "\r\n" + headerB + "\r\n" + headerImgBegin + "\r\n" + headerImgB + headerImg_String + headerImgE + "\r\n" + headerImgEnd + "\r\n" + headerH1Begin + "\r\n" + headerH1B + headerH1_String + headerH1E + "\r\n" + headerH1End + "\r\n" + headerE + "\r\n" + headerEnd;
			htmlString = htmlString.replace(headerString, headerString_NEW);
			//writeToFile(newFileName);
			//readFromFile(newFileName);
			return true;
		} catch (StringIndexOutOfBoundsException ignored){
			return false;
		}
	}
	public static boolean setHeaderFromGUI(String headerH1_String){ // Overloaded if there is only Text
		int beginIndex;
		int endIndex;
		String headerB = "<header>";
		String headerE = "</header>";

		String headerH1B = "<h1>";
		String headerH1E = "</h1>";

		String headerString_NEW;

		try {
			beginIndex = htmlString.indexOf(headerBegin);
			endIndex = htmlString.indexOf(headerEnd)+headerEnd.length();
			headerString = htmlString.substring(beginIndex, endIndex);
			headerString_NEW = headerBegin + "\r\n" + headerB + "\r\n" + headerH1Begin + "\r\n" + headerH1B + headerH1_String + headerH1E + "\r\n" + headerH1End + "\r\n" + headerE + "\r\n" + headerEnd;
			htmlString = htmlString.replace(headerString, headerString_NEW);
			//writeToFile(newFileName);
			//readFromFile(newFileName);
			return true;
		} catch (StringIndexOutOfBoundsException ignored){
			return false;
		}
	}
	public static boolean setNavFromGUI(String navName_String, String navLink_String){
		int beginIndex;
		int endIndex;
		String navB = "<nav>";
		String navE = "</nav>";
		String navLinkB = "<a href=\"";
		String navLinkE = "\"/>";
		String navNameB = "";
		String navNameE = "</a>";

		String navName_TempString = navName_String; // Used
		String navLink_TempString = navLink_String;

		String tempName;
		String tempLink;
		int location;

		boolean containsSemicolon = true;

		String navString_NEW = navBegin + "\r\n" + navB + "\r\n";

		try {
			beginIndex = htmlString.indexOf(navBegin);
			endIndex = htmlString.indexOf(navEnd)+navEnd.length();
			navString = htmlString.substring(beginIndex, endIndex);
			while ( containsSemicolon ){
				if (navName_TempString.contains(";")){
					location = navName_TempString.indexOf(";");
					tempName = navName_TempString.substring(0, location);
					navName_TempString = navName_TempString.replaceFirst(tempName + ";", "");

					location = navLink_TempString.indexOf(";");
					tempLink = navLink_TempString.substring(0, location);
					navLink_TempString = navLink_TempString.replaceFirst(tempLink + ";", "");

					navString_NEW = navString_NEW + navLinkB + tempLink + navLinkE + navNameB + tempName + navNameE + "\r\n";
				}
				else {
					tempName = navName_TempString;
					navName_TempString = navName_TempString.replace(tempName, "");

					tempLink = navLink_TempString;
					navLink_TempString = navLink_TempString.replace(tempLink, "");

					navString_NEW = navString_NEW + navLinkB + tempLink + navLinkE + navNameB + tempName + navNameE + "\r\n" + navE + "\r\n" + navEnd;
					containsSemicolon = false;
				}
			}

			htmlString = htmlString.replace(navString, navString_NEW);

			return true;
		} catch (StringIndexOutOfBoundsException ignored){
			return false;
		}
	}
	public static boolean setSectionFromGUI(List<List<String>> section_StringMatrix, List<String> sectionH2_String){
		int beginIndex;
		int endIndex;
		String sectionB = "<section>";
		String sectionE = "</section>";
		String sectionH2B = "<h2>";
		String sectionH2E = "</h2>";
		String sectionPB = "<p>";
		String sectionPE = "</p>";
		String sectionULB = "<ul>";
		String sectionULE = "</ul>";
		String sectionOLB = "<ol>";
		String sectionOLE = "</ol>";
		String sectionLIB = "<li>";
		String sectionLIE = "</li>";
		String sectionImgB = "<img src=\"";
		String sectionImgE = "\"/>";

		boolean tempFlag = true;
		int location;

		List<String> tempSectionList;
		int sizeMatrix;
		int sizeMatrixList;
		int sizeH2List;

		String tempSectionValue;
		String tempH2Value;

		String tempListValue;

		String replaceDivider;
		int beginReplaceDivider;
		int endReplaceDivider;

		String sectionString_NEW = sectionBegin + "\r\n";

		try {
			beginIndex = htmlString.indexOf(sectionBegin);
			endIndex = htmlString.indexOf(sectionEnd)+sectionEnd.length();
			sectionString = htmlString.substring(beginIndex, endIndex);

			if ( !section_StringMatrix.isEmpty() && !sectionH2_String.isEmpty() ){
				sizeMatrix = section_StringMatrix.size();
				sizeH2List = sectionH2_String.size();
				if (sizeH2List == sizeMatrix){
					for (int i = 0; i < sizeMatrix; i++){
						tempH2Value = sectionH2_String.get(i);
						tempSectionList = section_StringMatrix.get(i);

						if (!tempH2Value.equals("")){
							sectionString_NEW = sectionString_NEW + bodySectionBegin + i + commentEnding + "\r\n" + sectionB + "\r\n" + sectionH2Begin + i + commentEnding + "\r\n" + sectionH2B + tempH2Value + sectionH2E + "\r\n" + sectionH2End + i + commentEnding + "\r\n";
						}
						else
						{
							sectionString_NEW = sectionString_NEW + bodySectionBegin + i + commentEnding + "\r\n" + sectionB + "\r\n";
						}

						if (!tempSectionList.isEmpty()){
							sizeMatrixList = tempSectionList.size();
							for ( int j = 0; j < sizeMatrixList; j++){
								tempSectionValue = tempSectionList.get(j);
								if (tempSectionValue.contains("ul:")){
									sectionString_NEW = sectionString_NEW + uListBegin + i + "." + j + commentEnding + "\r\n" + sectionULB + "\r\n";
									tempSectionValue = tempSectionValue.replace("ul:", "");
									while(tempFlag){
										if (tempSectionValue.contains(";")){
											location = tempSectionValue.indexOf(";");
											tempListValue = tempSectionValue.substring(0, location);
											tempSectionValue = tempSectionValue.replaceFirst(tempListValue + ";", "");
											sectionString_NEW = sectionString_NEW + sectionLIB + tempListValue + sectionLIE + "\r\n";
										}
										else {
											tempListValue = tempSectionValue;
											tempSectionValue = tempSectionValue.replaceFirst(tempListValue, "");

											sectionString_NEW = sectionString_NEW + sectionLIB + tempListValue + sectionLIE + "\r\n" + sectionULE + "\r\n" + uListEnd + i + "." + j + commentEnding + "\r\n";

											tempFlag = false;
										}
									}
									tempFlag = true;
								}
								else if (tempSectionValue.contains("ol:")){
									sectionString_NEW = sectionString_NEW + oListBegin + i + "." + j + commentEnding + "\r\n" + sectionOLB + "\r\n";
									tempSectionValue = tempSectionValue.replace("ol:", "");
									while(tempFlag){
										if (tempSectionValue.contains(";")){
											location = tempSectionValue.indexOf(";");
											tempListValue = tempSectionValue.substring(0, location);
											tempSectionValue = tempSectionValue.replaceFirst(tempListValue + ";", "");
											sectionString_NEW = sectionString_NEW + sectionLIB + tempListValue + sectionLIE + "\r\n";
										}
										else {
											tempListValue = tempSectionValue;
											tempSectionValue = tempSectionValue.replaceFirst(tempListValue, "");

											sectionString_NEW = sectionString_NEW + sectionLIB + tempListValue + sectionLIE + "\r\n" + sectionOLE + "\r\n" + oListEnd + i + "." + j + commentEnding + "\r\n";

											tempFlag = false;
										}
									}
									tempFlag = true;
								}
								else if (tempSectionValue.contains("img:")){
									tempSectionValue = tempSectionValue.replace("img:", "");
									sectionString_NEW = sectionString_NEW + imgBegin + i + "." + j + commentEnding + "\r\n" + sectionImgB + tempSectionValue + sectionImgE + "\r\n" + imgEnd + i + "." + j + commentEnding + "\r\n";
								}
								else{
									sectionString_NEW = sectionString_NEW + paragraphBegin + i + "." + j + commentEnding + "\r\n" + sectionPB + tempSectionValue + sectionPE + "\r\n" + paragraphEnd + i + "." + j + commentEnding + "\r\n";
								}
							}
							if ( i != sizeMatrix-1 ){
								sectionString_NEW = sectionString_NEW + sectionE + "\r\n" + bodySectionEnd + i + commentEnding + "\r\n\r\n" + dividerBegin + "\r\n" + divider + "\r\n" + dividerEnd + "\r\n\r\n";
							}
							else
							{
								sectionString_NEW = sectionString_NEW + sectionE + "\r\n" + bodySectionEnd + i + commentEnding + "\r\n";
							}

						}
						else{
							if ( i != sizeMatrix-1 ){
								sectionString_NEW = sectionString_NEW + sectionE + "\r\n" + bodySectionEnd + i + commentEnding + "\r\n\r\n" + dividerBegin + "\r\n" + divider + "\r\n" + dividerEnd + "\r\n\r\n";
							}
							else
							{
								sectionString_NEW = sectionString_NEW + sectionE + "\r\n" + bodySectionEnd + i + commentEnding + "\r\n";
							}
						}

					}
					sectionString_NEW = sectionString_NEW + sectionEnd + "\r\n";

				}
				else{
					sectionString_NEW = sectionString_NEW + sectionEnd + "\r\n";
				}
			}
			else{
				sectionString_NEW = sectionString_NEW + sectionEnd + "\r\n";
			}

			htmlString = htmlString.replace(sectionString, sectionString_NEW);

			return true;
		} catch (StringIndexOutOfBoundsException ignored){
			return false;
		}
	}
	public static boolean setFooterFromGUI(String footer_String){
		int beginIndex;
		int endIndex;
		String footerB = "<footer>";
		String footerE = "</footer>";
		String footerH4B = "<h4>";
		String footerH4E = "</h4>";

		try {
			beginIndex = htmlString.indexOf(footerBegin);
			endIndex = htmlString.indexOf(footerEnd)+footerEnd.length();
			footerString = htmlString.substring(beginIndex, endIndex);
			footer_String = footerBegin + "\r\n" + footerB + "\r\n" + footerH4B + footer_String + footerH4E + "\r\n" + footerE + "\r\n" + footerEnd;
			htmlString = htmlString.replace(footerString, footer_String);
			//writeToFile(newFileName);
			//readFromFile(newFileName);
			return true;
		} catch (StringIndexOutOfBoundsException ignored){
			return false;
		}
	}
}