<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="login.css" type=text/css>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>

    <div class="container">
        <h1>Login</h1>
        <div class="form">
            <form action="loginform" method="post">
                <label for="username">Username</label>
                <input 
                	type="username" 
                	name="username" 
                	placeholder="Enter username" 
                	minlength="6"
               		maxlength="30"
               		title="Username must be 6-30 characters long, contain letters, underscore and numbers. Should start with letter."
                	required>

                <label for="password">Password</label>
                <input 
                	type="password" 
                	name="password" 
                	placeholder="Enter password"
               		minlength="8"
               		maxlength="20"
               		title="Password must be 8-20 characters long, contain letters and numbers." 
                	required>

                <button type="submit" class="btn">LOGIN</button>

            </form>
        </div>
        <p class="signuplink">
            Don't have an account? <a href="signup.jsp">Sign Up</a>
        </p>
        
        <p class="error">${loginerror}</p>
    </div>
</body>
</html>