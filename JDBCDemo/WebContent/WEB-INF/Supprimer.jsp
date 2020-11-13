<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supprimer</title>
</head>
<body>

<form method="post" action="Helloworld">
<fieldset>
                <legend>Supprimer Un pays</legend>
                <p>Vous voulez supprimer un pays c'est par ici</p>
                
				<label for="nom">Nom</label>
                <input type="text" id="nom" name="nom" size="20" maxlength="20" />
                <br />
                <input type="submit" value="Valider" />
                <br />
            </fieldset>

</form>
<ul>
        <c:forEach var="pays" items="${Lpays}">
            <li><c:out value="${pays.id}" /> <c:out value="${pays.nom}" /></li>
        </c:forEach>
    </ul>    

</body>
</html>