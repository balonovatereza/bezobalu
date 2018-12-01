<%@page import="cz.czechitas.bezobalu.servlets.*"%>
<%@page import="cz.czechitas.bezobalu.bean.*"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BezObalu-kategorie</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<h1>BezObalu</h1>

	<form action="kalkulace" method="get">
		<%
			ArrayList<Kategorie> vyfiltrovaneKategorie = (ArrayList<Kategorie>) request.getAttribute("vyfiltrovaneKategorie");
		%>
	
			<%
				if (vyfiltrovaneKategorie != null) {
					for (Kategorie jednaKategorie : vyfiltrovaneKategorie) {
			%>
			<button class="tlacitko tlacitko-vetsi" name="action" value="<%=jednaKategorie.getIdKategorie()%>"><%=jednaKategorie.getNazev()%>
			</button>

			<%
				}
				}
			%>
			</form>
</body>
</html>