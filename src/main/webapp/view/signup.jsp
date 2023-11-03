<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Signup</title>
  <link
          href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
          rel="stylesheet"
  />
  <link href="<c:url value="/view/loginstyle.css"/>" rel="stylesheet" type="text/css" >
  <script src=<c:url value="/view/signupscript.js"/> type="text/javascript"></script>
    <style>
        @import url(https://fonts.googleapis.com/css2?family=Poppins:wght@300&family=Press+Start+2P&display=swap);
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }
        .container{
            height: 100vh;
            width: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
            background-image: url("/food.jpg");
            background-size: 100%;
            column-gap: 30px;
        }
        .form{
            position: absolute;
            max-width: 430px;
            width: 100%;
            padding: 30px;
            border-radius: 6px;
            background: #FFF;
        }
        header{
            font-size: 28px;
            font-weight: 600;
            color: #232836;
            text-align: center;
        }
        form{
            margin-top: 30px;
        }
        .form .field{
            position: relative;
            height: 50px;
            width: 100%;
            margin-top: 20px;
            border-radius: 6px;
        }
        .field input,
        .field button{
            height: 100%;
            width: 100%;
            border: none;
            font-size: 16px;
            font-weight: 400;
            border-radius: 6px;
        }
        .field input{
            padding: 0 15px;
            border: 1px solid#CACACA;
        }
        .eye-icon{
            position: absolute;
            top: 50%;
            right: 10px;
            transform: translateY(-50%);
            font-size: 18px;
            color: #8b8b8b;
            cursor: pointer;
            padding: 5px;
        }
        .field button{
            color: #fff;
            background-color: #0171d3;
            transition: all 0.3s ease;
            cursor: pointer;
        }
        .field button:hover{
            background-color: #016dcb;
        }
        .form-link{
            text-align: center;
            margin-top: 10px;
        }
        .form-link span,
        .form-link a{
            font-size: 14px;
            font-weight: 400;
            color: #232836;
        }
        .form a{
            color: #0171d3;
            text-decoration: none;
        }
        .form-content a:hover{
            text-decoration: underline;
        }
        .line{
            position: relative;
            height: 1px;
            width: 100%;
            margin: 36px 0;
            background-color: #d4d4d4;
        }
        .icon{
            text-align: center;
        }
        .form-content .error{
            display: flex;
            align-items: center;
            margin-top: 6px;
            color: red;
            font-size: 14px;
            display: none;
        }
        .error .error-icon{
            margin-right: 6px;
            font-size: 15px;
        }
        .create-password .error{
            align-items: flex-start;
        }
        .create-password .error-icon{
            margin-top: 4px;
        }
        .invalid .error{
            display: flex;
        }
        .invalid input{
            border-color: red;
        }
        .user-list{

        }
        @media screen and (max-width: 400px) {
            .form{
                padding: 20px 10px;
            }
        }
    </style>
</head>
<body>
<section class="container forms">
  <div class="form signup">
    <div class="form-content">
      <header>SIGNUP</header>
      <form class="signup" method="post" action="/whattoeat?action=login">
        <div class="username-field">
          <div class="field input-field">
            <input
                    type="text"
                    placeholder="Enter your username"
                    name="username"
                    class="username"
            />
          </div>
          <span class="error email-error">
                <i class="bx bx-error-circle error-icon"></i>
                <p class="error-text username-text">Please enter your username</p>
              </span>
        </div>
        <div class="email-field">
          <div class="field input-field">
            <input type="text" placeholder="Enter your email" name="email" class="email"/>
          </div>
          <span class="error email-error">
                <i class="bx bx-error-circle error-icon"></i>
                <p class="error-text email-text">Please enter a valid email</p>
              </span>
        </div>
        <div class="password-field">
          <div class="field input-field create-password">
            <input type="password" placeholder="Enter your password" name="password" class="password"/>
            <i class="bx bx-hide eye-icon"></i>
          </div>
          <span class="error password-error create-password">
                <i class="bx bx-error-circle error-icon"></i>
                <p class="error-text">
                  Please enter at least 8 characters with number, small and
                  capital letter
                </p>
              </span>
        </div>
        <div class="cPassword-field">
          <div class="field input-field confirm-password">
            <input
                    type="password"
                    placeholder="Confirm password"
                    class="password cPassword"
            />
            <i class="bx bx-hide eye-icon"></i>
          </div>
          <span class="error cPassword-error confirm-password">
                <i class="bx bx-error-circle error-icon"></i>
                <p class="error-text">Password don't match</p>
              </span>
        </div>
        <div class="field button-field">
          <button>SIGNUP</button>
        </div>
        <div class="form-link">
              <span
              >Already have an account?
                <a href="/whattoeat?action=login" class="link login-link">Login</a></span
              >
        </div>
      </form>
    </div>
    <div class="line"></div>
    <div class="icon">
      <i class="bx bxs-popsicle"></i>
      <i class="bx bxs-sushi"></i>
      <i class="bx bxs-pear"></i>
      <i class="bx bxs-cheese"></i>
      <i class="bx bxs-baguette"></i>
      <i class="bx bxs-bowl-rice"></i>
      <i class="bx bxs-pizza"></i>
      <i class="bx bxs-cookie"></i>
    </div>
  </div>
</section>
<c:forEach var="user" items="${listUser}">
        <table class="user-list">
    <tr>
        <td class="username-list"><c:out value="${user.username}"/></td>
        <td class="email-list"><c:out value="${user.email}"/></td>
    </tr>
        </table>
</c:forEach>
<script>
    window.onload=function(){
        const signupForm = document.querySelector(".signup"),
            usernameField = document.querySelector(".username-field"),
            usernameInput = usernameField.querySelector(".username"),
            usernameError = document.querySelector(".username-text"),
            emailField = document.querySelector(".email-field"),
            emailInput = emailField.querySelector(".email"),
            emailError = document.querySelector(".email-text"),
            passField = document.querySelector(".password-field"),
            passInput = passField.querySelector(".password"),
            cPassField = document.querySelector(".cPassword-field"),
            cPassInput = cPassField.querySelector(".cPassword"),
            usernameList = document.querySelectorAll(".username-list"),
            emailList = document.querySelectorAll(".email-list"),
            pwShowHide = document.querySelectorAll(".eye-icon");

        pwShowHide.forEach((eyeIcon) => {
            eyeIcon.addEventListener("click", () => {
                let pwFields =
                    eyeIcon.parentElement.parentElement.querySelectorAll(".password");
                pwFields.forEach((password) => {
                    if (password.type === "password") {
                        password.type = "text";
                        eyeIcon.classList.replace("bx-hide", "bx-show");
                        return;
                    }
                    password.type = "password";
                    eyeIcon.classList.replace("bx-show", "bx-hide");
                });
            });
        });


        function checkName(){
            for(let i = 0;i <usernameList.length;i++){
                if(usernameList[i].innerHTML == usernameInput.value){
                    usernameError.innerHTML = "Username has been taken";
                    return usernameField.classList.add("invalid");
                }
            }
            if (usernameInput.value == "") {
                usernameError.innerHTML = "Please enter your username";
                return usernameField.classList.add("invalid");
            }
            usernameField.classList.remove("invalid");
        }

        function checkEmail() {
            for(let i = 0;i <emailList.length;i++){
                if(emailList[i].innerHTML == emailInput.value){
                    emailError.innerHTML = "Email address has been registered";
                    return emailField.classList.add("invalid");
                }
            }
            const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
            if (!emailInput.value.match(emailPattern)) {
                emailError.innerHTML = "Invalid email";
                return emailField.classList.add("invalid");
            }
            if (emailInput.value == "") {
                emailError.innerHTML = "Please enter your username";
                return emailField.classList.add("invalid");
            }
            emailField.classList.remove("invalid");
        }

        function createPass() {
            const passPattern =
                /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d@$!%*?&]{8,}$/;
            if (!passInput.value.match(passPattern)) {
                return passField.classList.add("invalid");
            }
            passField.classList.remove("invalid");
        }

        function confirmPass() {
            if (passInput.value !== cPassInput.value || cPassInput.value == "") {
                return cPassField.classList.add("invalid");
            }
            cPassField.classList.remove("invalid");
        }

        signupForm.addEventListener("submit", (e) => {
            checkName();
            checkEmail();
            createPass();
            confirmPass();
            usernameInput.addEventListener("keyup", checkName);
            emailInput.addEventListener("keyup", checkEmail);
            passInput.addEventListener("keyup", createPass);
            cPassInput.addEventListener("keyup",confirmPass);
            if(!emailField.classList.contains("invalid") &&
                !usernameField.classList.contains("invalid") &&
                !passField.classList.contains("invalid") &&
                !cPassField.classList.contains("invalid")){
            } else {
                e.preventDefault();
            }
        });
    }
</script>
</body>
</html>
