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
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
</head>
<body>
<section id="container">
<%@ include file="header.jsp"%>
<div class="container md">
	
	<form action="kalkulace" method="get">
	<br>
	<br>
	Název vybrané kategorie :
	
		<%	
			ArrayList<Produkt> vyfiltrovaneProdukty = (ArrayList<Produkt>) request.getAttribute("vyfiltrovaneProdukty");
			Kategorie nazevKategorie = (Kategorie) request.getAttribute("zobrazKategorii");
			out.print(nazevKategorie.getNazev());
			%>
	<%--<br>
	<br>
	Seznam produktů:
	<br>
	<br>
			<%
			if (vyfiltrovaneProdukty != null) {
					for (Produkt jedenProdukt : vyfiltrovaneProdukty) {
			%>
	
			<ul>
 				 <li><%=jedenProdukt.getNazev()%></li>
			</ul>
			<%
				}
				}
			%>
	--%>
	
	<%--
	<button class="tlacitko tlacitko-vetsi" name="action" value="vyfiltrujProdukty" type="submit">Vyber
			produkt</button>
	--%>
	</form>
	
	
	<br>
	<br>

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
		</select>	
	    <input id="gramy" class="custom-select" name="gramy" type="number" placeholder="Množství v gramech"/>
        <input type="hidden" name="idMesta" value="<%=request.getParameter("idMesta")%>">
        <input type="hidden" name="idKategorie" value="<%=request.getParameter("idKategorie")%>">
	  	<button class="tlacitko tlacitko-vetsi" name="action" value="spocitej" type="submit">Výpočet</button>
	  	<textarea class="custom-select seznamVypoctu"  name="comment" form="usrform" placeholder=" seznam výpočtů">výpočet :</textarea>
	  	<br>
		<button class="tlacitko tlacitkoGramy" type="button" onclick="document.getElementById('gramy').value = parseInt(document.getElementById('gramy').value) + 12 ">12g</button>
        <button class="tlacitko tlacitkoGramy" type="button" onclick="document.getElementById('gramy').value =parseInt(document.getElementById('gramy').value) + 250 ">250g</button>
        <button class="tlacitko tlacitkoGramy" type="button" onclick="document.getElementById('gramy').value =parseInt(document.getElementById('gramy').value) + 500 ">500g</button>
		<br>
		<%
		ArrayList<String> seznamVypoctu = (ArrayList<String>) request.getAttribute("seznamVypoctu");
		out.print("boruvky 25g 100kc");
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
	</form>
	<br>
	<br>
	 
	
	<form action="kalkulace" method="post">
		<input class="custom-select" name="email" type="email" placeholder=" muj@email.cz"/>
		<button class="tlacitko tlacitko-vetsi" name="action" value="odeslat" type="submit">Odešli na email</button>
	</form>


</div>
</section>
</body>
</html>