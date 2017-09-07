/*global cordova, module*/


module.exports = {
    Getpage: function (file,page, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "PDFConvert", "Getpage", [file,page]);
    }
};
