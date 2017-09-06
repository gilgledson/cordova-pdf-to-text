package convert.pdf.to.text;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class Pdf extends CordovaPlugin{

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("convert")) {
            try {     
            	String url  = data.getString(0);
            	String page = data.getString(1);
			    PdfReader reader = new PdfReader(url);
			    int n = reader.getNumberOfPages(); 
			    String str=PdfTextExtractor.getTextFromPage(reader, page); //Extracting the content from a particular page.
			    reader.close();
			    callbackContext.success(str);
			    return true;
			} catch (Exception e) {
			   return e;
			}

        }else{
            return false;
        }
    }


}