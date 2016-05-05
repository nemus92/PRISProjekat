<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
<title></title>
<body>
<div class="container">

<br><br><br><br>
			<header>
				<h1><span>Autobuska stanica</span>			
				</h1>
            </header>  
            <br><br><br>
<div  class="form">
<form id="contactform" method="post" action="../RegisterServlet" class="login">

<div><p class="contact"><label for="username">Ime:</label></p><input type="text" name="imeKorisnika" value=""></div>
<div><p class="contact"><label for="username">Prezime:</label></p><input type="text" name="prezimeKorisnika" value=""></div>
<div><p class="contact"><label for="username">Adresa:</label></p><input type="text" name="adresaKorisnika" value=""></div>
<div><p class="contact"><label for="username">JMBG:</label></p><input type="text" name="jmbgKorisnika" value=""></div>
<div><p class="contact"><label for="username">Korisnicko ime:</label></p><input type="text" name="userKorisnika" value=""></div>
<div><p class="contact"><label for="username">Lozinka:</label></p><input type="text" name="passKorisnika" value=""></div>
<br>
<input type="submit" value="Registrujte se">
</form>
</div>
<br>
<div align="center">${msg}</div>
<br>
<div align="center"><a href="/AutobuskaStanicaWeb/menu/MainPage.jsp"><span><span><span>Menu</span></span></span></a></div>

<br><br>
</div>
</body>
</html>