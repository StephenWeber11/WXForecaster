$(document).ready(function(){
   
   if(window.location.href.indexOf("thank-you.jsp") > -1){
       console.log("yes");
       var delay = 5000;
       setTimeout(function(){
           window.location = "/WxForecaster/main.jsp"; 
       },delay);
   }
    
});