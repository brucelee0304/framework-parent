var Ext;
DynamicLoading.css(rootPath + '/resources/css/theme-triton-all.css');
DynamicLoading.js(rootPath + '/extjs/classic/ext-all.js');
CONFIG.restRoot=rootPath;
var intervalObj = setInterval(function () {
  if (Ext) {
    clearInterval(intervalObj);
    DynamicLoading.js(rootPath + '/app/login.js');
  }
}, 50);