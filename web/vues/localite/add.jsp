<%--
  Created by IntelliJ IDEA.
  User: Bocar BA
  Date: 14/12/2019
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 Veuillez saisir les informations suivants:
    <form action="../../src/presentation/Main" method="post">
        <label>Nom</label>
        <input type="text" name="Nom"><br>
        <label>Latitude</label>
        <input type="number" name="Latitude"><br>
        <label>Longitude</label>
        <input type="number" name="Longitude"><br>
        <button type="submit" name="Valider" value="Valider">Valider</button>
    </form>
</body>
</html>
