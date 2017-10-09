package project3;

import java.awt.Color;
import java.awt.Paint;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute.Space;
import org.jfree.chart.ChartUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(46, "a", "A");
		dataset.setValue(38, "a", "B");
		dataset.setValue(29, "a", "C");
		dataset.setValue(29, "a", "D");
		dataset.setValue(32, "a", "E");
		dataset.setValue(60, "a", "F");
		dataset.setValue(52, "a", "G");

		BarChart barChart = new BarChart("Graphic Header", "xxxxxxxx", "yyyyyyyy", dataset, new Paint[] { Color.blue, Color.cyan, Color.blue, Color.cyan, Color.blue, Color.cyan, Color.blue });
		barChart.pack();
		RefineryUtilities.centerFrameOnScreen(barChart);
		barChart.setVisible(true);

		int width = 680; /* Width of the image */
		int height = 520; /* Height of the image */
		File BarChartFile = null;
		BarChartFile = new File("C:/DEVELOPMENT/barchart.jpg");
		try {
			ChartUtilities.saveChartAsJPEG(BarChartFile, barChart.getBarChart(), width, height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Chart Created Successully.");
		
		WordHandler wordsFileHandler = new WordHandler();
		XWPFDocument document = null;
		try {
			document = new XWPFDocument();
			//Write the Document in file system

		
			
			  FileOutputStream out = new FileOutputStream(new File("C:/DEVELOPMENT/new_doc.docx"));
		
			  wordsFileHandler.setFooter(document);
			  wordsFileHandler.addRightandLeftLogo("C:/DEVELOPMENT/barchart.jpg","C:/DEVELOPMENT/barchart.jpg", document);
			wordsFileHandler.addHeader("Lorem Ipsum.", document);
			wordsFileHandler.addDoubleLine(document);
			wordsFileHandler.addParagraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend orci vitae facilisis scelerisque. "
					+ "Proin erat dolor, euismod quis luctus ut, mollis a purus. Morbi sagittis suscipit tortor, at posuere arcu tempus ac. "
					+ "Donec scelerisque molestie efficitur. Aliquam non consectetur lacus, malesuada dictum libero. Mauris in interdum arcu. "
					+ "Sed et nibh id justo vulputate viverra eget nec leo. Duis gravida, ligula eget aliquam laoreet, nibh nisl eleifend sem, "
					+ "in faucibus nisl est vitae turpis. Quisque pretium, enim ac venenatis pellentesque, nunc ipsum ullamcorper ex, et tempus orci neque nec est. "
					, document);
			wordsFileHandler.addParagraph("Sed vel diam sed magna consequat lacinia. Vivamus blandit mollis lacus non semper. "
					+ "Duis commodo urna sit amet neque cursus finibus. Etiam enim eros, ultrices mattis eleifend quis, vulputate eu mauris. Ut et semper risus, "
					+ "non ultricies sapien. Donec faucibus ultricies quam, sit amet convallis elit eleifend quis. In sed eros ac magna pulvinar egestas eu quis ligula."
					+ " Quisque tristique metus justo, eu laoreet metus efficitur ut.", document);
			wordsFileHandler.addSingleLine(document);
			wordsFileHandler.addParagraph("Nullam at nulla et sem interdum aliquam. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
					+ "Integer lacus dolor, feugiat eu egestas eu, feugiat ac elit. Curabitur fringilla urna ut vestibulum laoreet. Nam non tellus at justo porta dignissim. "
					+ "Fusce ac cursus est, vel sagittis felis. Curabitur pulvinar est quis velit blandit, nec facilisis mauris aliquam. Proin non risus quam. "
					+ "Nulla ornare id nisi id condimentum. Vestibulum aliquet ultrices orci, ac efficitur velit mollis ac.", document);
			wordsFileHandler.addChart("C:/DEVELOPMENT/barchart.jpg", document);
			document.write(out);
			  out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("Docx Written Successully.");
	}
	
}