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
<link href="https://cdn.jsdelivr.net/npm/tailwindcss/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<section id="container">
<%@ include file="header.jsp"%>
<div class="container md">
	<form action="kalkulace" method="get">
	
		<%	
			ArrayList<Produkt> vyfiltrovaneProdukty = (ArrayList<Produkt>) request.getAttribute("vyfiltrovaneProdukty");
		%>
	<select class="custom-select" name="idProduktu">
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
	
	<button class="tlacitko tlacitko-kalkulace" name="action" value="vyfiltrujProdukty" type="submit">Vyber
			produkt</button>

		<br>
		<br>
	</form>

	<form action="spocitej" method="get">	
	    <input class="custom-select" name="gramy" type="number" placeholder="Množství v gramech"/>
	  	<button class="tlacitko tlacitko-kalkulace" name="action" value="spocitej" type="submit">Výpočet</button>
	  	<textarea class="custom-select"  name="comment" form="usrform" placeholder=" seznam výpočtů">seznam výpočtů :</textarea>
	  	<br>
		<button class="tlacitko tlacitkoGramy" type="button">12g</button>
		<button class="tlacitko tlacitkoGramy" type="button">200g</button>
		<button class="tlacitko tlacitkoGramy" type="button">500g</button>
	</form>
	<br>
	<br>
	
	
	
	<form action="kalkulace" method="post">
		<input class="custom-select" name="email" type="email" placeholder=" muj@email.cz"/>
		<button class="tlacitko tlacitko-kalkulace" name="action" value="odeslat" type="submit">Odešli na email</button>
	</form>


</div>
</section>
</body>
</html>