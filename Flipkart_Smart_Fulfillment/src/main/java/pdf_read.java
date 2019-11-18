
	import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
	/**
	* This is an example on how to extract words from PDF document
	*/

public class pdf_read  extends PDFTextStripper {
    
    static List<String> lines = new ArrayList<String>();
    public pdf_read() throws IOException {
    }
    /**
     * @throws IOException If there is an error parsing the document.
     */
    public static List<String> readPdf(String str) throws IOException {
        PDDocument document = null;
//        String fileName = "C:/Users/hp/Downloads/Flipkart-PickList-P150319-F91630687C04-15-Mar-2019-01-20.pdf";
        try {
            document = PDDocument.load( new File(str) );
            PDFTextStripper stripper = new pdf_read();
            stripper.setSortByPosition( true );
            stripper.setStartPage( 0 );
            stripper.setEndPage( document.getNumberOfPages() );
            Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
            stripper.writeText(document, dummy);
            
            // print lines
//            for(String line:lines){
//                System.out.println(line); 
//            }
//            List<String> s=lines;
//            int n=s.size();
//            for(int i=0;i<n;i++){
//            	System.out.println("Number of line is"+i+"-->"+s.get(i));
//            }
        }
        finally {
            if( document != null ) {
                document.close();
            }
        }
        return lines;
    }
    /**
     * Override the default functionality of PDFTextStripper.writeString()
     */
    @Override
    protected void writeString(String str, List<TextPosition> textPositions) throws IOException {
        lines.add(str);
        // you may process the line here itself, as and when it is obtained
    }}