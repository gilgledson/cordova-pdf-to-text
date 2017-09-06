package cordova.pdf.to.text;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Pdf extends CordovaPlugin{

    @Override
    public String execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("convert")) {
            try {     
            	/*String url  = data.getString(0);
            	String page = data.getString(1);
			    PdfReader reader = new PdfReader(url);
			    int n = reader.getNumberOfPages(); 
			    String str=PdfTextExtractor.getTextFromPage(reader, page); //Extracting the content from a particular page.
			    reader.close();
			    callbackContext.success(str);
			    return true;*/
                  //Loading an existing document
                  File file = new File(data[0]);
                  PDDocument document = PDDocument.load(file);

                  //Instantiate PDFTextStripper class
                  PDFTextStripper pdfStripper = new PDFTextStripper();

                  //Retrieving text from PDF document
                  String text = pdfStripper.getText(document);
                  // System.out.println(text);
                  callbackContext.success(text);
                  //Closing the document
                  document.close();

			} catch (Exception e) {
			   callbackContext.error(e);
			}

        }else{
            return false;
        }
    }


}