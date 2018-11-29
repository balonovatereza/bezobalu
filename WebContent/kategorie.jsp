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
			ArrayList<Kategorie> vyfiltrovaneKategorie = (ArrayList<Kategorie>) request
					.getAttribute("vyfiltrovaneKategorie");
			ArrayList<Produkt> vyfiltrovaneProdukty = (ArrayList<Produkt>) request.getAttribute("vyfiltrovaneProdukty");
			int idMesta = Integer.parseInt(request.getParameter("idMesta"));
		%>

		<%
			if (vyfiltrovaneKategorie != null) {
				for (Kategorie jednaKategorie : vyfiltrovaneKategorie) {
		%>
			<a class="tlacitko tlacitko-vetsi" href="kalkulace?idMesta=<%=idMesta%>&idKategorie=<%=jednaKategorie.getIdKategorie()%>" ><%=jednaKategorie.getNazev()%></a>
		
		<%
			}
			}
		%>
	</form>
</body>
</html>