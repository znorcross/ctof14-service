<?xml version="1.0" encoding="UTF-8" ?> 
<html
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns:c="http://java.sun.com/jsp/jstl/core"
xmlns:fn="http://java.sun.com/jsp/jstl/functions" >
  <head>
    <jsp:directive.page contentType="text/html;charset=UTF-8"></jsp:directive.page> 
    <link rel="stylesheet" type="text/css" href="https://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css"><jsp:text/></link>
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.0.3.js"><jsp:text/></script>
    <script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"><jsp:text/></script>
  </head>
  <body bgcolor="white">
    Welcome to the CTOF 14 Services Exercise Sample<br/>
    <br/>
    Service Consumption Test<br/>
    
    <div>
      Task service<br/>
      <script type="text/javascript"><![CDATA[
  $(document).ready(function() {
    $('#tasksTable').dataTable({
      "bProcessing": true,
      "sAjaxSource": "rest/v1/tasks",
      "sAjaxDataProp": "",
      "aoColumns": [
            { "mData": "id" },
            { "mData": "name" }
        ]
    });

    $('#addTask').click(function() {
      $.ajax({url:'rest/v1/tasks', type: 'PUT', data: {name: $('#taskName').value}});
    });
  });
]]>
      </script>      
      <input id="taskName" type="text"/><br/>
      <button id="addTask">Add Task</button>
      <table id="tasksTable">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Row 1 Data 1</td>
            <td>Row 1 Data 2</td>
          </tr>
          <tr>
            <td>Row 2 Data 1</td>
            <td>Row 2 Data 2</td>
          </tr>
        </tbody>
      </table>
    </div>
  </body>
</html>