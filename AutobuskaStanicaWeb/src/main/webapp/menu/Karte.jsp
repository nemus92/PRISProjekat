<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="karte" class="projekatBeans.CenaKarteBean" scope="page"></jsp:useBean>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
<link rel="stylesheet" type="text/css" href="/ProjekatNemanjaWeb/style.css" media="all" />
<link rel="stylesheet" type="text/css" href="/ProjekatNemanjaWeb/demo.css" media="all" />
<title>Promena cene karte</title>
</head>
<body>
<div class="container">

<br><br><br><br>
			<header>
				<h1><span>Autobuska stanica</span>			
				</h1>
            </header>  
            <br><br><br>
<div  class="form">
<table>
<tr>
		<td><label>Cena:</label></td>
</tr>
<c:forEach items="${karte.cenaKarte}" var="ka">
		<tr>
		<td><div>${ka.cenaKarte}&nbsp;</div></td>
		<tr>
		<td><div><a href="/AutobuskaStanicaWeb/IzmeniKartuServlet?idKarta=${ka.idKarta}">Izmeni</a></div></td>
		</tr> <tr></tr>
</c:forEach>


</table>
<br><br>
</div>
<br>
<div>${msg}</div>
<br>
<div align="center"><a href="/AutobuskaStanicaWeb/menu/MainPage.jsp">Meni</a></div>
</div>
</body>
</html>