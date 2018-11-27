<%@page import="cz.czechitas.bezobalu.servlets.*"%>
<%@page import="cz.czechitas.bezobalu.bean.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BezObalu-kalkulace</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>BezObalu</h1>

	<form action="kalkulace" method="get">
		<%
			
			ArrayList<Produkt> vyfiltrovaneProdukty = (ArrayList<Produkt>) request.getAttribute("vyfiltrovaneProdukty");
		%>
		<br>
		
	<select class="custom-select" name="produkt">
			<%
				if (vyfiltrovaneProdukty != null) {
					for (Produkt jedenProdukt : vyfiltrovaneProdukty) {
			%>
			<option value="<%=jedenProdukt.getIdProduktu()%>"><%=jedenProdukt.getNazev()%></option>
			<%
				}
				}
			%>

	</select>
	
	<button class="tlacitko tlacitko-vetsi" name="action" value="vyfiltrujProdukty" type="submit">Vyber
			produkt</button>


		<br>

		
	</form>


	<form action="spocitej" method="get">	
	    <input name="gramy" type="number" />
	     <br>
		<button class="tlacitko" type="button">12g</button>
		<button class="tlacitko" type="button">200g</button>
		<button class="tlacitko" type="button">500g</button>
		<button class="tlacitko tlacitko-vetsi" name="action" value="spocitej" type="submit">Vypocet</button>

	</form>
	<br>
	<br>
	<form action="odeslat" method="post">
		<input name="email" type="email" />
		<button class="tlacitko tlacitko-vetsi" name="action" value="odeslat" type="submit">Odesli na email</button>
	</form>



</body>
</html>