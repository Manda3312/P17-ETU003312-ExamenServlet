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
    <h1>Create Credit</h1>
    
<form action="creditServlet" methode="Post">
    <p>Libelle: </p><input type="text" name="Libelle" id="Libelle">
    <p>-ontant: </p></p><input type="number" name="montant" id="montant">
    <input type="Submit" Value="Submit">
</form>

 <h1>Credit List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Libelle</th>
            <th>montant</th>
            <th>rest</th>
        </tr>
        <%
            List<Credit> employees = (List<Credit>) request.getAttribute("credits");
            if (employees != null) {
                for (Credit employee : employees) {
        %>
            <tr>
                <td><%= employee.getId() %></td>
                <td><%= employee.getLibelle() %></td>
                <td><%= employee.getMontant() %></td>
                <td><%= employee.getRest() %></td>
            </tr>
        <%
                }
            }
        %>
    </table>


 <a href="depenseFormServlet">Depense</a>   
</body>
</html>
