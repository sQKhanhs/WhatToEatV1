window.onload = function () {
    const loginForm = document.querySelector(".login"),
        emailField = document.querySelector(".email-field"),
        emailInput = emailField.querySelector(".email"),
        emailError = document.querySelector(".email-text"),
        passField = document.querySelector(".password-field"),
        passInput = passField.querySelector(".password"),
        passError = document.querySelector(".password-text"),
        pwShowHide = document.querySelectorAll(".eye-icon"),
        emailList = document.querySelectorAll(".email-list"),
        passList = document.querySelectorAll(".password-list");

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
    var emailId = -1;
    var passId = 0;
    function checkEmail() {
        for (let i = 0; i < emailList.length; i++) {
            if (emailList[i].innerHTML !== emailInput.value && emailInput.value !== "") {
                emailError.innerHTML = "Invalid email";
                emailField.classList.add("invalid");
            } else{
                emailId = emailList[i].id;
                emailField.classList.remove("invalid");
                break;
            }
        }
        if(emailInput.value == ""){
            emailError.innerHTML = "Please enter your email";
            return emailField.classList.add("invalid");
        }
    }
    function checkPass() {
        for (let i = 0; i < passList.length; i++) {
            if (passList[i].innerHTML !== passInput.value && passInput.value !== "") {
                passError.innerHTML = "Invalid password";
                passField.classList.add("invalid");
            } else {
                if(passList[i].id = emailId ) {
                    passId = passList[i].id;
                    break;
                }
            }
        }
        if(passInput.value == ""){
            passError.innerHTML = "Please enter your password";
            return passField.classList.add("invalid");
        }
        if(passId != emailId){
            passField.classList.add("invalid");
        } else{
            passField.classList.remove("invalid");
        }
    }

    loginForm.addEventListener("submit", (e) => {
        checkEmail();
        checkPass();
        if (!emailField.classList.contains("invalid") &&
            !passField.classList.contains("invalid")){
        } else {
            e.preventDefault();
        }
    });
    emailInput.addEventListener("click",(e) => {
        emailField.classList.remove("invalid")
    });
    passInput.addEventListener("click",(e) => {
        passField.classList.remove("invalid")
    });
}
