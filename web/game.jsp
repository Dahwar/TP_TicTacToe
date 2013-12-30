<%-- 
    Document   : game
    Created on : 11 déc. 2013, 15:46:35
    Author     : Florent
--%>

<%@page import="fr.uha.ensisa.fl.tictactoe.TicTacToe" %>
<%@page import="fr.uha.ensisa.fl.tictactoe.TicTacToe.State"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tic Tac Toe !</title>
    </head>
    <body>
        <h1>Tic Tac Toe !</h1>
        <table>
            <% TicTacToe ttt = (TicTacToe) request.getSession().getAttribute("model"); %>
            <%for(int i=0;i<3;i++) {%>
            <tr>
                <%for(int j=0;j<3;j++) {%>
                    <% 
                    State stateCell = ttt.getStateCell(i, j);
                    %>
                    <td>
                        <% if(stateCell==State.EMPTY) { %>
                            <% if(!ttt.win()) { %><a href="gameServlet?x=<%=i%>&y=<%=j%>"><% } %><img src="images/blank.png" /> <% if(!ttt.win()) { %></a><% } %>
                        <% } if(stateCell==State.CROSS) { %>
                            <img src="images/cross.png" />
                        <% } if(stateCell==State.RING) { %>
                            <img src="images/ring.png" />
                        <% } %>
                    </td>
                <% } %>
            </tr>
            <%}%>
        </table>
        <% String win = (String) request.getSession().getAttribute("win"); %>
        <% if(win.equals("me")) { %>
        <h2>Vous avez gagné ! :)</h2>
        <% } %>
        <% if(win.equals("computer")) { %>
        <h2>L'ordinateur a gagné :/</h2>
        <% } %>
        <% if(win.equals("null") && !ttt.haveCellEmpty()) { %>
        <h2>Match nul !</h2>
        <% } %>
        <% if(ttt.win() || !ttt.haveCellEmpty()) { %>
        <form action="index.jsp">
            <input type="submit" name="replay" value="Recommencer !" />
        </form>
        <% } %>
    </body>
</html>
