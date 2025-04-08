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
    <p>montant: </p></p><input type="number" name="montant" id="montant">
    <input type="Submit" Value="Submit">
</form>

 


 <a href="depenseFormServlet">Depense_link</a>   
</body>
</html>