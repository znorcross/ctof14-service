<?xml version="1.0" encoding="UTF-8" ?> 
<html
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns:c="http://java.sun.com/jsp/jstl/core"
xmlns:fn="http://java.sun.com/jsp/jstl/functions" >
  <head>
    <jsp:directive.page contentType="text/html;charset=UTF-8"></jsp:directive.page> 
    <link rel="stylesheet" type="text/css" href="https://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css"><jsp:text/></link>
    <script type="text/javascript" src="https://accounts-e2e.intuit.com/IUS-Plugins/v2/scripts/ius.min.js" data-widgets="sign-in"><jsp:text/></script>
  </head>
  <body bgcolor="white">
    Welcome to the CTOF 14 Services Exercise Sample<br/>
    <div id="ius-sign-in-widget"></div>
      <script type="text/javascript"><![CDATA[
  intuit.ius.signIn.setup({ 
        offeringId: 'Intuit.cto.iam.ius',    
        onSignInSuccess: function() { window.location = 'index.jsp'; } 
    }); 
]]>
      </script>      
  </body>
</html>