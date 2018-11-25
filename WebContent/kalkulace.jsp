<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BezObalu</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
    <h1>BezObalu</h1>
    <select name="kategorie">
      <option value="Káva, čokoláda, čaje">Káva, čokoláda, čaje</option>
      		<ul>
      		<li><a href="#">Caj</a></li>
      		</ul>
      <option value="idKategorie"><%=getNazevKategorie()%></option>
      <option value="Mouky, krupice, kaše">Mouky, krupice, kaše</option>
      <option value="Obiloviny a výrobky z nich">Obiloviny a výrobky z nich</option>
      <option value="Ochucovadla">Ochucovadla</option>
      <option value="Oříšky, semena a sušené ovoce">Oříšky, semena a sušené ovoce</option>
      <option value="Pochutiny">Pochutiny</option>
      <option value="Těstoviny">Těstoviny</option>
      <option value="Koření">Koření</option>
      <option value="Zelenina">Zelenina</option>
      <option value="Mléčné výrobky">Mléčné výrobky</option>
      <option value="Ostatní">Ostatní</option>
      <option value="Kosmetikas">Kosmetika</option>
      <option value="Rostlinne napoje v prášku">Rostlinne napoje v prášku</option>
      <option value="Konopny sortiment">Konopny sortiment</option>
    </select>
    <br>
    
	   
    
  </body>
</html>