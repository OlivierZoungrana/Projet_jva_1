<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier</title>
</head>

<style>
body, p, legend, label, input {
    font: normal 8pt verdana, helvetica, sans-serif;
}

fieldset {
    padding: 10px;
    border: 1px #0568CD solid;
}

legend {
    font-weight: bold;
    color: #0568CD;
}

/* Forms --------------------------------------------------------------------------------------- */

form label {
    float: left;
    width: 200px;
    margin: 3px 0px 0px 0px;
}

form input {
    margin: 3px 3px 0px 0px;
    border: 1px #999 solid;
}

form input.sansLabel {
    margin-left: 200px;
}

form .requis {
    color: #c00;
}

h1{

text-align: center;
}


</style>
<body>

<form method="post" action="Helloworld">
<fieldset>
                <legend>Pour Modifier un pays</legend>
                <p>Pour modifier un pays c'est ici  </p>
                
                <label for="id">Id</label>
                <input type="number" id="id" name="id" size= "20" maxlength="20"/>
                <br>
                <br>
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