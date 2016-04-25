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
        <form method="post" action="login.jsp">
            <center>
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Login Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Korisnicko ime</td>
                        <td><input type="text" name=userKorisnika value="" /></td>
                    </tr>
                    <tr>
                        <td>Lozinka</td>
                        <td><input type="password" name="passKorisnika" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Niste registrovani! <a href="Register.jsp">Registrujte se ovde</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>