<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entitie.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Create Depense</h1>
<form action="DepenseServlet" method="Post">
    <p>Credit: </p><select name="Credit" id="Credit">
     <%
            List<Credit> credits = (List<Credit>) request.getAttribute("credits");
            if (credits != null) {
                for Credit credit : credits) {
        %>
        <option value="<%=credit.getId() %>"><%= credit.getLibelle()  %></option>
          <%
                }
            }
        %>
    </select>
    <p>montant: </p></p><input type="number" name="montant" id="montant">
    <input type="date" name="date" id="date">
    <input type="submit" value="Submit">
</form>
     <a href="creditFormServlet">retour</a>
</body>
</html>