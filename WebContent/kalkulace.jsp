<%@page import="cz.czechitas.bezobalu.servlets.*"%>
<%@page import="cz.czechitas.bezobalu.bean.*"%>
<%@page import="cz.czechitas.bezobalu.dao.*"%>
<%@page import="cz.czechitas.bezobalu.controllers.*"%>
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
	<button class="tlacitko tlacitko-vetsi" name="action" value="vyfiltrujKategorie" type="submit"></button>	
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
		<br>
	</form>

	<form action="kalkulace" method="get">	
	    <input class="custom-select" name="gramy" type="number" placeholder=" množství v gramech"/>
	  	<button class="tlacitko tlacitko-vetsi" name="action" value="spocitej" type="submit">Výpočet</button>
	  	<textarea class="custom-select seznamVypoctu"  name="comment" form="usrform" placeholder=" seznam výpočtů">seznam výpočtů :</textarea>
	  	<br>
		<button class="tlacitko tlacitkoGramy" type="button">12g</button>
		<button class="tlacitko tlacitkoGramy" type="button">200g</button>
		<button class="tlacitko tlacitkoGramy" type="button">500g</button>
	</form>
	<br>
	<br>
	
	
	
	<form action="kalkulace" method="post">
		<input class="custom-select" name="email" type="email" placeholder=" muj@email.cz"/>
		<button class="tlacitko tlacitko-vetsi" name="action" value="odeslat" type="submit">Odešli na email</button>
	</form>



</body>
</html>