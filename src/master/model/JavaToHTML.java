package master.model; /**
 * 
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
/**
 * @author DAVIDMOSTO
 *
 */
public class JavaToHTML implements HTMLStringDefinitions {
	static String htmlString;
	static File originalFile;
	
	JavaToHTML(){
		htmlString = "";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String originalFileName;
		originalFileName = templateName;
		readFromFile( originalFileName + html );

		String title = "This is a Test Title";
		titleEditor( title );

		String[][] bodyContent = new String[][]{
			{"p0.0", "ul:Hello world;Next World;Loren Ipsum", "p0.1", "p0.2", "p0.3"},
			{"p1.0", "{Test Header1}p1.1", "p1.2"},
			{"{Test Header 2}p2.0", "p2.1", "ol:{Test List}Hello world;Next World;Loren Ipsum", "p2.3"}
		};

		String[] navLinks = new String[]{"nav0", "nav1", "nav2", "nav3"};
		String[] navTabs = new String[]{"Nav 0", "Nav 1", "Nav 2", "Nav 3"};

		bodyEditor(navLinks, navTabs, bodyContent);
		
		String newFileName = "index";
		writeToFile( newFileName + html );
		
	}

	public static void readFromFile(String fileName){
		originalFile = new File( path + fileName); // Loads the Template File
		try {
			htmlString = FileUtils.readFileToString(originalFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void writeToFile(String fileName){
		File newHtmlFile = new File( path + fileName );
		try {
			FileUtils.writeStringToFile(newHtmlFile, htmlString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void titleEditor(String title){
		int titleBeginIndex; // Location of "<" in "<!--$titleBegin-->"
		int titleEndIndex; // Location of ">" in "<!--$titleEnd-->"
		String titleSubstring;
		String titleNewSubstring;
		
		titleBeginIndex = htmlString.indexOf(titleBeginComment);
		titleEndIndex = htmlString.indexOf(titleEndComment)+titleEndComment.length();
		titleSubstring = htmlString.substring(titleBeginIndex, titleEndIndex);
		titleNewSubstring = titleBegin + "\t" + title + titleEnd;
		htmlString = htmlString.replace(titleSubstring, titleNewSubstring);
	}
	
	// bodySection[a][b], a: Section Number, b: Section Content
	public static void bodyEditor(String[] navLinks, String[] navTabs, String[][] bodySection){
		int bodyBeginIndex; // Location of "<" in "<!--$bodyBegin-->"
		int bodyEndIndex; // Location of ">" in "<!--$bodyEnd-->"
		String bodySubstring;
		String bodyNewSubstring;
		int bodyColumnLength;
		int bodyRowLength;
		
		//int bodyBeginSectionIndex;
		//int bodyEndSectionIndex;
		
		String tempString;
		
		String bodySectionBeginComplete;
		String bodySectionEndComplete;

		String paragraphBeginComplete;
		String paragraphEndComplete;
		String sectionString;
		
		String contentHeader;
		String originalString;
		
		String listBeginComplete;
		String listEndComplete;
		List<String> listValues = new ArrayList<String>();
		
		int listLocation1;
		int listLocation2;
		
		bodyBeginIndex = htmlString.indexOf(bodyBeginComment);
		bodyEndIndex = htmlString.indexOf(bodyEndComment)+bodyEndComment.length();
		bodySubstring = htmlString.substring(bodyBeginIndex, bodyEndIndex);

		bodyNewSubstring = bodyBeginComment + "\n" + navEditor(navLinks, navTabs);

		bodyColumnLength = bodySection.length;

		
		for ( int matrixColumnLength = 0; matrixColumnLength < bodyColumnLength; matrixColumnLength++ ){
			bodySectionBeginComplete = "\t" + bodySectionBegin + matrixColumnLength + commentEnding;
			bodySectionEndComplete = "\t" + bodySectionEnd + matrixColumnLength + commentEnding + "\n";
			bodyRowLength = bodySection[matrixColumnLength].length;
			sectionString = "";
			listValues.clear();
			
			for ( int matrixRowLength = 0; matrixRowLength < bodyRowLength; matrixRowLength++ ){
				if ( bodySection[matrixColumnLength][matrixRowLength].contains("ul:") ){
					listBeginComplete = "\t\t" + uListBegin + matrixColumnLength + "." + matrixRowLength + commentEnding;
					listEndComplete = "\t\t" + uListEnd + matrixColumnLength + "." + matrixRowLength + commentEnding;

					originalString = bodySection[matrixColumnLength][matrixRowLength];
					contentHeader = headerCheck(originalString);
					if ( originalString.contains("}") ){
						listLocation1 = 0;
						listLocation2 = originalString.indexOf("}")+1;
						tempString = originalString.substring(listLocation1, listLocation2);
						originalString = originalString.replace(tempString, "");
					}
					else {
						listLocation1 = 0;
						listLocation2 = originalString.indexOf(":")+1;
						tempString = originalString.substring(listLocation1, listLocation2);
						originalString = originalString.replace(tempString, "");
					}

					sectionString = sectionString + "\n" + listBeginComplete;

					if (!contentHeader.equals("")){
						sectionString = sectionString + "\n\t\t" + "<h2>" + contentHeader + "</h2>";
					}

					sectionString = sectionString + "\n\t\t" + "<ul>";

					while ( originalString.contains(";") ){
						listLocation1 = 0;
						listLocation2 = originalString.indexOf(";");
						tempString = originalString.substring(listLocation1, listLocation2);
						listValues.add(tempString);

						listLocation2++;
						tempString = originalString.substring(listLocation1, listLocation2);
						originalString = originalString.replace(tempString, "");
					}

					listLocation1 = 0;
					listLocation2 = originalString.length();
					tempString = originalString.substring(listLocation1, listLocation2);
					listValues.add(tempString);

					for ( int lengthList = 0; lengthList < listValues.size(); lengthList++ ){
						sectionString = sectionString + "\n\t\t\t" + "<li>" + listValues.get(lengthList) + "</li>";
					}

					sectionString = sectionString + "\n\t\t" + "</ul>" + "\n" + listEndComplete;

				}
				else if ( bodySection[matrixColumnLength][matrixRowLength].contains("ol:") ){
					listBeginComplete = "\t\t" + oListBegin + matrixColumnLength + "." + matrixRowLength + commentEnding;
					listEndComplete = "\t\t" + oListEnd + matrixColumnLength + "." + matrixRowLength + commentEnding;

					originalString = bodySection[matrixColumnLength][matrixRowLength];
					contentHeader = headerCheck(originalString);
					if ( originalString.contains("}") ){
						listLocation1 = 0;
						listLocation2 = originalString.indexOf("}")+1;
						tempString = originalString.substring(listLocation1, listLocation2);
						originalString = originalString.replace(tempString, "");
					}
					else {
						listLocation1 = 0;
						listLocation2 = originalString.indexOf(":")+1;
						tempString = originalString.substring(listLocation1, listLocation2);
						originalString = originalString.replace(tempString, "");
					}

					sectionString = sectionString + "\n" + listBeginComplete;

					if (!contentHeader.equals("")){
						sectionString = sectionString + "\n\t\t" + "<h2>" + contentHeader + "</h2>";
					}

					sectionString = sectionString + "\n\t\t" + "<ol>";

					while ( originalString.contains(";") ){
						listLocation1 = 0;
						listLocation2 = originalString.indexOf(";");
						tempString = originalString.substring(listLocation1, listLocation2);
						listValues.add(tempString);

						listLocation2++;
						tempString = originalString.substring(listLocation1, listLocation2);
						originalString = originalString.replace(tempString, "");
					}

					listLocation1 = 0;
					listLocation2 = originalString.length();
					tempString = originalString.substring(listLocation1, listLocation2);
					listValues.add(tempString);

					for ( int lengthList = 0; lengthList < listValues.size(); lengthList++ ){
						sectionString = sectionString + "\n\t\t\t" + "<li>" + listValues.get(lengthList) + "</li>";
					}

					sectionString = sectionString + "\n\t\t" + "</ol>" + "\n" + listEndComplete;

				}
				else{
					originalString = bodySection[matrixColumnLength][matrixRowLength];
					contentHeader = headerCheck(originalString);
					if ( originalString.contains("}") ){
						listLocation1 = 0;
						listLocation2 = originalString.indexOf("}")+1;
						tempString = originalString.substring(listLocation1, listLocation2);
						originalString = originalString.replace(tempString, "");
					}
					paragraphBeginComplete = "\t\t" + paragraphBegin + matrixColumnLength + "." + matrixRowLength + commentEnding;
					paragraphEndComplete = "\t\t" + paragraphEnd + matrixColumnLength + "." + matrixRowLength + commentEnding;

					sectionString = sectionString + "\n" + paragraphBeginComplete;
					if (!contentHeader.equals("")){
						sectionString = sectionString + "\n\t\t" + "<h2>" + contentHeader + "</h2>";
					}

					sectionString = sectionString + "\n\t\t" + "<p>" + originalString + "</p>" + "\n" + paragraphEndComplete;
				}

			}

			bodyNewSubstring = bodyNewSubstring + "\n" + bodySectionBeginComplete + "\n\t" + "<section>";
			bodyNewSubstring = bodyNewSubstring + sectionString;
			bodyNewSubstring = bodyNewSubstring + "\n\t" + "</section>" + "\n" + bodySectionEndComplete;

		}

		bodyNewSubstring = bodyNewSubstring + "\n" + bodyEndComment;

		htmlString = htmlString.replace(bodySubstring, bodyNewSubstring);
	}

	public static String headerCheck(String content){
		String header;
		int bracket1;
		int bracket2;
		if (content.contains("{")){
			bracket1 = content.indexOf("{");
			bracket2 = content.indexOf("}");
			header = content.substring(bracket1+1, bracket2);
		}
		else
		{
			header = "";
		}
		return header;
	}

	public static String navEditor(String[] navLinks, String[] navTabs){
		String newNavSubstring = "";

		for ( int arrayLength = 0; arrayLength < navLinks.length; arrayLength++ ){
			newNavSubstring = newNavSubstring + "\n\t\t" + urlBegin + "\"" + navLinks[arrayLength] + ".html\">";
			newNavSubstring = newNavSubstring + navTabs[arrayLength] + urlEnd;
		}
		newNavSubstring = "\n\t" + navBegin + newNavSubstring + "\n\t" + navEnd + "\n";
		return newNavSubstring;
	}
	
	@SuppressWarnings("unused")
	public static String headerEditor(String imageName, String headerName){
		String newHeaderSubstring = "";

		/*for ( int arrayLength = 0; arrayLength < navLinks.length; arrayLength++ ){
			newNavSubstring = newNavSubstring + "\n\t\t" + urlAppend + "\"" + navLinks[arrayLength] + ".html\">";
			newNavSubstring = newNavSubstring + navTabs[arrayLength] + "</a>";
		}*/
		//newNavSubstring = "\n\t" + navBegin + newNavSubstring + "\n\t" + navEnd + "\n";
		return newHeaderSubstring;
	}
}