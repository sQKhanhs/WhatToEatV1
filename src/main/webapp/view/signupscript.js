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
