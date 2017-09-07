package cordova.pdf.to.text;

import java.io.File;
import java.io.IOException;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.pdfbox;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Pdf extends CordovaPlugin{

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) {

        if (action.equals("convert")) {
            try {    
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
                  return true;

      } catch (Exception e) {
         callbackContext.error(e);
      }

        }else{
            return false;
        }
    }


}