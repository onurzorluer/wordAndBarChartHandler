
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;

public class WordHandler {

	private XWPFDocument document = null;
	
	public void addParagraph(String paragraphContent, XWPFDocument doc) {
		// create Paragraph
		XWPFParagraph paragraphOne = doc.createParagraph();
		paragraphOne.setBorderLeft(Borders.DOUBLE);
		paragraphOne.setBorderRight(Borders.DOUBLE);
		XWPFRun paragraphOneRun = paragraphOne.createRun();
		paragraphOneRun.setFontSize(10);

		paragraphOneRun.setText(paragraphContent);
		paragraphOneRun.addBreak();

	}
	
	public void addBoldParagraph(String paragraphContent, XWPFDocument doc) {
		// create Paragraph
		XWPFParagraph paragraphTwo = doc.createParagraph();
		paragraphTwo.setBorderLeft(Borders.DOUBLE);
		paragraphTwo.setBorderRight(Borders.DOUBLE);
		XWPFRun paragraphTwoRun = paragraphTwo.createRun();
		paragraphTwoRun.setBold(true);
		paragraphTwoRun.setFontSize(10);

		paragraphTwoRun.setText(paragraphContent);
		paragraphTwoRun.addBreak();

	}


	public void addHeader(String headerContent, XWPFDocument doc) {
		// Create Header
		XWPFParagraph header = doc.createParagraph();
		header.setAlignment(ParagraphAlignment.CENTER);
		header.setBorderLeft(Borders.DOUBLE);
		header.setBorderRight(Borders.DOUBLE);
		XWPFRun headerRun = header.createRun();
		headerRun.setBold(true);
		headerRun.setFontSize(18);

		headerRun.setText(headerContent);
		headerRun.addBreak();
	}
	
	public void addSecondHeader(String secondHeaderContent, XWPFDocument doc) {
		// Create Second Header
		XWPFParagraph secondHeader = doc.createParagraph();
		XWPFRun headerRun = secondHeader.createRun();
		secondHeader.setAlignment(ParagraphAlignment.CENTER);
		secondHeader.setBorderLeft(Borders.DOUBLE);
		secondHeader.setBorderRight(Borders.DOUBLE);
		headerRun.setBold(true);
		headerRun.setFontSize(14);

		headerRun.setText(secondHeaderContent);
		headerRun.addBreak();
	}
	
	public void addThirdHeader(String thirdHeaderContent, XWPFDocument doc) {
		// Create Second Header
		XWPFParagraph thirdHeader = doc.createParagraph();
		thirdHeader.setBorderLeft(Borders.DOUBLE);
		thirdHeader.setBorderRight(Borders.DOUBLE);
		XWPFRun headerRun = thirdHeader.createRun();
		headerRun.setBold(true);
		headerRun.setFontSize(12);

		headerRun.setText(thirdHeaderContent);
		headerRun.addBreak();
	}

	public void addDoubleLine(XWPFDocument doc) {
		// create Double Line
		XWPFParagraph line = doc.createParagraph();
		line.setBorderBottom(Borders.DOUBLE);
		line.setBorderLeft(Borders.DOUBLE);
		line.setBorderRight(Borders.DOUBLE);
		XWPFRun lineRun = line.createRun();
		lineRun.setText(" ");

	}

	public void addSingleLine(XWPFDocument doc) {
		// create Single Line
		XWPFParagraph line = doc.createParagraph();
		line.setBorderBottom(Borders.SINGLE);
		line.setBorderLeft(Borders.DOUBLE);
		line.setBorderRight(Borders.DOUBLE);
		XWPFRun lineRun = line.createRun();
		lineRun.setText(" ");

	}
	
	public void addBlankLine(XWPFDocument doc) {
		// create Blank Line
		XWPFParagraph line = doc.createParagraph();
		line.setBorderLeft(Borders.DOUBLE);
		line.setBorderRight(Borders.DOUBLE);
		XWPFRun lineRun = line.createRun();
		lineRun.setText(" ");

	}

	public void addChart(String imgFilePath, XWPFDocument doc) {
		XWPFParagraph pictureOne = doc.createParagraph();
		XWPFRun pictureOneRun = pictureOne.createRun();
		// String imgFile = "C:/DEVELOPMENT/denemepng.png";
		FileInputStream is = null;
		try {
			is = new FileInputStream(imgFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pictureOneRun.addBreak();
		pictureOne.setAlignment(ParagraphAlignment.CENTER);
		pictureOne.setBorderLeft(Borders.DOUBLE);
		pictureOne.setBorderRight(Borders.DOUBLE);
		pictureOne.setBorderTop(Borders.DOUBLE);
		pictureOne.setBorderBottom(Borders.DOUBLE);
		try {
			pictureOneRun.addPicture(is, XWPFDocument.PICTURE_TYPE_PNG, imgFilePath, Units.toEMU(420),
					Units.toEMU(280));
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 400x200 pixels
		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void addRightandLeftLogo(String imgFilePathOne, String imgFilePathTwo, XWPFDocument doc)
	{
		XWPFParagraph pictureTwo = doc.createParagraph();
		XWPFRun pictureTwoRun = pictureTwo.createRun();
		// String imgFile = "C:/DEVELOPMENT/denemepng.png";
		FileInputStream is1 = null;
		FileInputStream is2 = null;
		try {
			is1 = new FileInputStream(imgFilePathOne);
			is2 = new FileInputStream(imgFilePathTwo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pictureTwoRun.addBreak();
		pictureTwo.setAlignment(ParagraphAlignment.CENTER);
		pictureTwo.setBorderTop(Borders.DOUBLE);
		pictureTwo.setBorderLeft(Borders.DOUBLE);
		pictureTwo.setBorderRight(Borders.DOUBLE);
		try {
			pictureTwoRun.addPicture(is1, XWPFDocument.PICTURE_TYPE_JPEG, imgFilePathOne, Units.toEMU(120),
					Units.toEMU(120));
			pictureTwoRun.setText("                                                          ");
			pictureTwoRun.addPicture(is2, XWPFDocument.PICTURE_TYPE_JPEG, imgFilePathTwo, Units.toEMU(120),
					Units.toEMU(120));
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 400x200 pixels
		try {
			is1.close();
			is2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addPageNumbers(XWPFDocument document) {
	    CTP ctpFooter = CTP.Factory.newInstance();
	    ctpFooter.addNewR().addNewT();

	    CTR ctr = ctpFooter.addNewR();
	    ctr.addNewRPr();
	    CTFldChar fch = ctr.addNewFldChar();
	    fch.setFldCharType(STFldCharType.BEGIN);
	    ctr = ctpFooter.addNewR();
	    ctr.addNewInstrText().setStringValue(" PAGE ");

	    ctpFooter.addNewR().addNewFldChar().setFldCharType(STFldCharType.SEPARATE);

	    ctpFooter.addNewR().addNewT().setStringValue("1");

	    ctpFooter.addNewR().addNewFldChar().setFldCharType(STFldCharType.END);
	    
	    XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, document);
	    XWPFParagraph[] parsFooter = new XWPFParagraph[1];
	    parsFooter[0] = footerParagraph;

	    CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
	    XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(document, sectPr);
	    policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);
	}
	
	public XWPFDocument getDocument() {
		return document;
	}

	public void setDocument(XWPFDocument document) {
		this.document = document;
	}
}
