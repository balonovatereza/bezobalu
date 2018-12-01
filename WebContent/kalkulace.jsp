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
<link
	href="https://cdn.jsdelivr.net/npm/tailwindcss/dist/tailwind.min.css"
	rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
</head>
<body>
	<section id="container">
		<%@ include file="header.jsp"%>
		<br> <a class="tlacitko tlacitko-kalkulace"
			href="kategorie?idMesta=<%=request.getParameter("idMesta")%>">Zpátky
			na kategorie</a> <br> Název vybrané kategorie :

		<%
 	ArrayList<Produkt> vyfiltrovaneProdukty = (ArrayList<Produkt>) request.getAttribute("vyfiltrovaneProdukty");
 	Kategorie nazevKategorie = (Kategorie) request.getAttribute("zobrazKategorii");
 	out.print(nazevKategorie.getNazev());
 %>

		<form action="kalkulace" method="get">
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
			</select> <input id="gramy" class="custom-select" name="gramy" type="number"
				placeholder="0 g" /> <input type="hidden" name="idMesta"
				value="<%=request.getParameter("idMesta")%>"> <input
				type="hidden" name="idKategorie"
				value="<%=request.getParameter("idKategorie")%>">
			<button class="tlacitko tlacitko-kalkulace" name="action"
				value="spocitej" type="submit">Spočítej</button>
			<%--<textarea class="custom-select seznamVypoctu"  name="comment" form="usrform" placeholder=" seznam výpočtů">výpočet :</textarea> --%>

			<br>
			<button class="tlacitko tlacitkoGramy" type="button"
				onclick="document.getElementById('gramy').value =(document.getElementById('gramy').value.length > 0 ? parseInt(document.getElementById('gramy').value) : 0) + 50  ">50g</button>
			<button class="tlacitko tlacitkoGramy" type="button"
				onclick="document.getElementById('gramy').value =(document.getElementById('gramy').value.length > 0 ? parseInt(document.getElementById('gramy').value) : 0) + 100  ">100g</button>
			<button class="tlacitko tlacitkoGramy" type="button"
				onclick="document.getElementById('gramy').value =(document.getElementById('gramy').value.length > 0 ? parseInt(document.getElementById('gramy').value) : 0) + 200  ">200g</button>
			<button class="tlacitko tlacitkoGramy" type="button"
				onclick="document.getElementById('gramy').value =(document.getElementById('gramy').value.length > 0 ? parseInt(document.getElementById('gramy').value) : 0) + 250  ">250g</button>
			<button class="tlacitko tlacitkoGramy" type="button"
				onclick="document.getElementById('gramy').value =(document.getElementById('gramy').value.length > 0 ? parseInt(document.getElementById('gramy').value) : 0) + 500  ">500g</button>
		</form>

		<br>
		<strong> Výsledná cena : <%
			out.print(request.getAttribute("vypocet"));
		%> Kč
		</strong><br> <br>
		<%
			ArrayList<String> seznamVypoctu = (ArrayList<String>) request.getSession().getAttribute("seznamVypoctu");

			if (seznamVypoctu != null) {
		%>
		<ul>
			<%
				for (String radek : seznamVypoctu) {
			%>
			<li>
				<%
					out.print(radek);
				%>
			</li>
			<%
				}
				}
			%>

		</ul>
		<br>
		<form action="kalkulace" method="post">
			<input class="custom-select" name="email" type="email"
				placeholder=" muj@email.cz" />
			<button class="tlacitko tlacitko-kalkulace" name="action"
				value="odeslat" type="submit">Odešli</button>
		</form>
	</section>
</body>
</html>