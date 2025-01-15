<%
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
	    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	    response.setDateHeader("Expires", 0); // Proxies
	    
	    session = request.getSession(false);
	    if (session.getAttribute("username") == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="welcome.css" type="text/css">
</head>
<body>
    <div class="nav">
        <ul class="nav-links">
            <li>About</li>
            <li>Shop</li>
            <li>Account</li>
        </ul>
        <form action="Logout" method="get">
            <button class="btn" type="submit">LOGOUT</button>
        </form>
    </div>
    <div class="title">
        Welcome,&nbsp; ${username}
    </div>
</body>
</html>