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
<title>BezObalu -vyber město</title>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<section id="container">
		<%@ include file="header.jsp"%>
		<div>
			<ul>
				<li>Hlavní myšlenka obchodu <strong>BezObalu</strong> je
					snížení zátěže přírody nadbytečnými plastovými obaly
				</li>

				<li>Aplikace slouží k rychlému porovnání cen zboží z <strong>BezObalu</strong>
					s cenou zboží z konvenčních obchodů, kde se prodává zabalené v
					různých gramážích
				</li>

				<li>Cena sortimentu <strong>BezObalu</strong> vychází ve
					srovnání s cenou u maloobchodníků výhodněji (pokud srovnáváme
					podobnou kvalitu surovin), protože často je cena produktu z 20 až
					50% tvořena právě obalem
				</li>

				<li>Můžete si vybrat mezi prodejnami
					<%
					ArrayList<Mesto> vsechnaMesta = (ArrayList<Mesto>) request.getAttribute("vsechnaMesta");
							int max = vsechnaMesta.size();
							int count = 0;
							if (vsechnaMesta != null) {
								for (Mesto jednoMesto : vsechnaMesta) {
									count=count+1;
				%> <%=jednoMesto.getNazev()%> <%
 	if (count<(max-1)) {
 				out.print(", ");
 			} else if (count==(max-1)) {
 				out.print(" a ");
 			} else {
 				out.print("");
 			}
 		}
 	}
 %>
				</li>
			</ul>
		</div>
		<br> <br>
		<div class="divTownPicker">


			<%
				if (vsechnaMesta != null) {
					for (Mesto jednoMesto : vsechnaMesta) {
			%>
			<a class="tlacitko tlacitko-mesto"
				href="kategorie?idMesta=<%=jednoMesto.getIdMesta()%>"><%=jednoMesto.getNazev()%></a>

			<%
				}
				}
			%>
		</div>

	</section>
</body>
</html>