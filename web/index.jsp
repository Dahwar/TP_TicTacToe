<%-- 
    Document   : index
    Created on : 11 déc. 2013, 14:36:06
    Author     : Florent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tic Tac Toe !</title>
    </head>
    <body>
        <h1>Tic Tac Toe !</h1>
        <form action="entryServlet">
            <input type="submit" name="user" value="Je commence..." />
            <input type="submit" name="computer" value="L'ordinateur commence..." />
        </form>
    </body>
</html>
