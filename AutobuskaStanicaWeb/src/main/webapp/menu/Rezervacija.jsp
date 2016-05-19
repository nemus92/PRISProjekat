<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="karte" class="projekatBeans.SlobodneKarteBean" scope="page"></jsp:useBean>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
<title>Rezervacija karata</title>
</head>
<body>
<div class="container">

<br><br><br><br>
			<header>
				<h1><span>Autobuska stanica</span>			
				</h1>
            </header>  <br><br><br>
<br>
<div  class="form">
<table>
<tr>
		<td><label>Vrsta:</label></td>
		<td><label>Cena:</label></td>
</tr>
<c:forEach items="${karte.slobodneKarte}" var="kr">
		<tr>
		
		<td><div>${kr.vrstaKarte}&nbsp;</div></td>
		<td><div>${kr.cenaKarte}&nbsp;</div></td>
		
		<tr>
		<td><div><a href="/AutobuskaStanicaWeb/RezervacijaServlet?idKarta=${kr.idKarta}">Rezervisi</a></div></td>
		</tr> <tr></tr>
</c:forEach>


</table>
<br><br>
</div>
<br>
<div align="center">${msg}</div>
<br>
<div align="center"><a href="/AutobuskaStanicaWeb/menu/AutobuskaStanica.jsp"><span><span><span>Meni</span></span></span></a></div> <br><br><br>
</div>
</body>
</html>