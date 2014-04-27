<?xml version="1.0" encoding="UTF-8" ?> 
<html
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns:c="http://java.sun.com/jsp/jstl/core"
xmlns:fn="http://java.sun.com/jsp/jstl/functions" >
  <head>
    <jsp:directive.page contentType="text/html;charset=UTF-8"></jsp:directive.page> 
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.0.3.js"><jsp:text/></script>
  </head>
  <body bgcolor="white">
    Welcome to the CTOF 14 Services Exercise Sample<br/>
    <br/>
    Consuming another service through code<br/>
    
    <div>
      <script type="text/javascript"><![CDATA[
  $(document).ready(function() {
    $('#findBest').click(function() {
      $.ajax({
        url:'api/testConsumer/'+$('#realmId').val(),
        contentType:"application/json; charset=utf-8",
        dataType: 'json',
        type: 'GET'
      }).done(function(data) {
          $('#result').text(data.result);
      }).fail(function( jqXHR, textStatus, errorThrown) {
        console.log('always.'+textStatus);
      });
    });
  });
]]>
      </script>      
      RealmID: <input id="realmId" type="text"/><br/>
      <button id="findBest">Find best restaurant</button>
      <div>
        Results:
        <div id='result'></div>
      </div>
    </div>
  </body>
</html>