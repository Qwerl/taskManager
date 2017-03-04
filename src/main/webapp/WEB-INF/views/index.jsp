<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <spring:url value="/resources/core/js/jquery.js" var="jqueryJs"/>
  <script src="${jqueryJs}"></script>
</head>

<body>
<div>
  <h1>ЗДАРОВА</h1>
</div>
<div id="tasks">
</div>
<script type="text/javascript">
  $(document).ready(function () {
    getTasks();
  });
  function getTasks() {
    $.ajax({
      type: 'POST',
      url: '/task',
      dataType: 'json',
      async: true,
      success: function (data) {
        $('#tasks').append('<table />');
        data.forEach(function (element) {
          $('#tasks').find('table').append('<tr><td>' + element.name + '</td></tr>');
        })
      },
      error: function (jqXHR, textStatus, errorThrown) {
        alert(jqXHR.status + ' ' + jqXHR.responseText);
      }
    });
  }
</script>
</body>

</html>