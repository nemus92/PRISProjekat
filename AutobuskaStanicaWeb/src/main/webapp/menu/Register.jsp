<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
<link rel="stylesheet" type="text/css" href="/AutobuskaStanicaWeb/style.css" media="all" />
<link rel="stylesheet" type="text/css" href="/AutobuskaStanicaWeb/demo.css" media="all" />
<title></title>
</head>
 <body>
        <form method="post" action="register.jsp">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Registracija</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Ime</td>
                        <td><input type="text" name="imeKorisnika" value="" /></td>
                    </tr>
                    <tr>
                        <td>Prezime</td>
                        <td><input type="text" name="prezimeKorisnika" value="" /></td>
                    </tr>
                    <tr>
                        <td>Adresa</td>
                        <td><input type="text" name="adresaKorisnika" value="" /></td>
                    </tr>
                    <tr>
                        <td>JMBG</td>
                        <td><input type="text" name="jmbgKorisnika" value="" /></td>
                    </tr>
                    <tr>
                        <td>Korisnicko ime</td>
                        <td><input type="text" name="userKorisnika" value="" /></td>
                    </tr>
                    <tr>
                        <td>Lozinka</td>
                        <td><input type="password" name="passKorisnika" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Potvrdi" /></td>
                        <td><input type="reset" value="Obrisi" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Vec ste regisrtovani! <a href="Login.jsp">Uloguj se ovde</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>