<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="signup.css" type="text/css">
</head>
<body>
    <div class="container">
		<h1>Create an account</h1>
        <div class="form">
            <form action="signupform" method="post">

                    <label for="firstname">Name</label>
                    <div class="name">
                        <div class="form-group">
                            <input 
                            	type="text" 
                            	name="firstname" 
                            	placeholder="First name" 
               					maxlength="30"
               					title="First name should be less than 30 characters and can only have letters."
                            	value="${firstNameValue}" 
                            	required>
                            <div class="error">${firstnameerror}</div>
                        </div>
                        <div class="form-group">
                            <input 
                            	type="text" 
                            	name="middlename" 
                            	placeholder="Middle name"
                            	maxlength="30"
               					title="Middle name should be less than 30 characters and can only have letters."
                            	value="${middleNameValue}">
                            <div class="error">${middlenameerror}</div>
                        </div>
                        <div class="form-group">
                            <input 
                            	type="text" 
                            	name="lastname" 
                            	placeholder="Last name" 
                            	maxlength="30"
               					title="Last name should be less than 30 characters and can only have letters."
                            	value="${lastNameValue}">
                            <div class="error">${lastnameerror}</div>
                        </div>
                    </div>
            
                    <label for="email">Email</label>
                    <input type="email" 
                    name="email" 
                    placeholder="Enter email" 
                    title="It must start with letters, numbers, or special characters like _ + & * -, followed by a domain name with a valid extension (e.g., example@domain.com)."
                    value="${emailValue}" 
                    required>
                    <div class="error">${emailerror}</div>
                
                    <label for="number">Phone Number</label>
                    <input 
                    	type="tel"  
                    	name="number" 
                    	placeholder="Enter phone number" 
                    	title="Enter a valid mobile number with 10 digits. Avoid spaces, letters, or special characters."
                    	value="${phoneNumberValue}" 
                    	required>
                    <div class="error">${numbererror}</div>
                
                    <label for="username">Username</label>
                    <input 
                    	type="text" 
                    	name="username" 
                    	placeholder="Enter username" 
                    	minlength="6"
               			maxlength="30"
               			title="Username must be 6-30 characters long, contain letters, underscore and numbers. Should start with letter."
                    	value="${usernameValue}"
                    	required>
                    <div class="error">${usernameerror}</div>
                
                    <label for="password">Password</label>
                    <input 
                    	type="password" 
                    	name="password" 
                    	placeholder="Create a password" 
                    	minlength="8"
               			maxlength="20"
               			title="Password must be 8-20 characters long, contain letters and numbers."
                    	value="${passwordValue}" 
                    	required>
                    <div class="error">${passworderror}</div>

                <button type="submit" class="btn">SIGNUP</button>
            </form>
        </div>
        <div class="signuplink">Already have an account? <a href="login.jsp">Login here</a></div>
    </div>
    
</body>
</html>