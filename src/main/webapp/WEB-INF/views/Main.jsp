<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>eCredit</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/core/extjs/resources/css/ext-all.css">

    <style type="text/css">
      .application {
        background-image: url(${pageContext.request.contextPath}/static/core/images/application.png) !important;
      }
      .pending {
        background-image: url(${pageContext.request.contextPath}/static/core/images/pending.png) !important;
      }
      .process {
        background-image: url(${pageContext.request.contextPath}/static/core/images/process.png) !important;
      }
      .pie {
        background-image: url(${pageContext.request.contextPath}/static/core/images/pie.png) !important;
      }
    </style>

  </head>

  <body>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/core/extjs/ext-debug.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/app.js"></script>
  </body>
</html>