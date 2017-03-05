<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <spring:url value="/resources/core/js/jquery.js" var="jqueryJs"/>
  <script src="${jqueryJs}"></script>
</head>

<body>
<div>
  <h1>Tasks:</h1>
</div>
<div id="tasks"></div>

<div id="account"></div>
<div id="account_tasks"></div>

<script type="text/javascript">
  $(document).ready(function () {
    getTasks();
    getAccountName(1);
    getTasksByAccountId(1);
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

  function getAccountName(accountId) {
    $.ajax({
      type: 'POST',
      url: 'account/' + accountId,
      dataType: 'json',
      async: true,
      success: function (data) {
        $('#account').append('<h1>' + data.username + '<h1/>');
      },
      error: function (jqXHR, textStatus, errorThrown) {
        alert(jqXHR.status + ' ' + jqXHR.responseText);
      }
    });
  }

  function getTasksByAccountId(accountId) {
    $.ajax({
      type: 'POST',
      url: 'account/' + accountId + '/task',
      dataType: 'json',
      async: true,
      success: function (data) {
        $('#account_tasks').append('<table />');
        data.forEach(function (element) {
          $('#account_tasks').find('table').append('<tr><td>' + element.name + '</td></tr>');
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