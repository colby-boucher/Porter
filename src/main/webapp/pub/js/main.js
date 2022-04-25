const loginbutton = document.getElementById('registersubmit');
loginbutton.addEventListener('click', validate);




function validate(e) {
    for (let x = 0; x < 10; x++){
        console.log('The number is ' + x);
    }

    e.preventDefault();

    const fNameEle=document.getElementById("fNameId")
    const lNameEle=document.getElementById("lNameId")
    const emailEle=document.getElementById("emailId")
    const passwordEle=document.getElementById("passwordId")
    const confirmEle=document.getElementById("confirmId")

    const fNameValue=document.getElementById("fNameId").value;
    const lNameValue=document.getElementById("lNameId").value;
    const emailValue=document.getElementById("emailId").value;
    const passwordValue=document.getElementById("passwordId").value;
    const confirmValue=document.getElementById("confirmId").value;

    let flag = true;

    const messageEle = document.createElement("small");

    fNameEle.previousElementSibling.innerHTML=" ";
    lNameEle.previousElementSibling.innerHTML=" ";
    emailEle.previousElementSibling.innerHTML=" ";
    passwordEle.previousElementSibling.innerHTML=" ";
    confirmEle.previousElementSibling.innerHTML=" ";

    if(fNameValue.match(/\s/) !=null){
        console.log("Please do not use whitespace.");
        fNameEle.style.borderColor="red";
        fNameEle.previousElementSibling.innerHTML="Please do not use whitespace.";
        flag = false;
    }
    if (fNameValue==""){
        console.log("First Name is required");
        fNameEle.className="warning";
        fNameEle.previousElementSibling.innerHTML="First name is required.";
        flag = false;
    }
    if (lNameValue==""){
        console.log("Last Name is required");
        lNameEle.className="warning"
        lNameEle.previousElementSibling.innerHTML="Last name is required";
        flag = false;
    }
    if (emailValue==""){
        console.log("Email is required");
        emailEle.previousElementSibling.innerHTML="Email is required";
        emailEle.className="warning"
        flag = false;
    }
    if (passwordValue==""){
        console.log("Password is required");
        passwordEle.previousElementSibling.innerHTML="Password is required";
        passwordEle.className="warning"
        flag = false
    }
    if (confirmValue==""){
        console.log("Password must be validated");
        confirmEle.className="warning"
        confirmEle.previousElementSibling.innerHTML="Password must be validated";
        flag = false
    }
    if (passwordValue !== confirmValue){
        passwordEle.className="warning"
        confirmEle.className="warning"
        confirmEle.previousElementSibling.innerHTML="Password does not match";
        console.log("Password and Confirm Password values do not match");

    }
    if (passwordValue.length < 8 || passwordValue.length > 25 ) {
        passwordEle.className="warning"
        passwordEle.previousElementSibling.innerHTML="Password must be between 8 and 25 characters";
        console.log("Your password must be between 8 and 25 characters");
        flag = false
    }
    if(passwordValue.match(/[a-z]/i) == null || passwordValue.match(/[0-9]/) == null){
        passwordEle.className="warning"
        passwordEle.previousElementSibling.innerHTML="Please use a number and a letter.";
        console.log("Please use a number and a letter.");
        flag = false
    }


    if (flag == true){
        alert("Login validated!")
    }

}
