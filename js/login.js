function loginUser() {
    let email = document.forms["login_frm"]["login_email"].value;
    let pass = document.forms["login_frm"]["login_pass"].value;

    if(email == "" || pass == "") {
        alert("Please enter password and email");
        return
    }


    const creds = {
        "id" : email,
        "pass" : pass,
        "name" : "<not-filled>"
    }
    
    Login(creds);
}




function signupUser() {
    let name = document.forms["signup-frm"]["sign_name"].value;
    let email = document.forms["signup-frm"]["sign_email"].value;
    let pass = document.forms["signup-frm"]["sign_pass"].value;

    const creds = {
        "id" : email,
        "pass" : pass,
        "name" : name
    }

    SignUp(creds);
}

async function Login(creds) {
    console.log(creds)
    // let creds = JSON.parse(creds)

    url = localStorage.getItem('website') + "/api/v1/login/authenticate/user/token=" + generateToken(creds.id);

    const config = {
        method : 'POST',
        headers : {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json',
        },
        body : JSON.stringify(creds)
    }

    const token = await fetch (url, config).then((res) => res.text());

    console.log(token)

    if(token == 'N/A') {
        // Do Login failed action
    }
    else {
        localStorage.setItem("token", token);
        window.open("/placeholders/post-login.html", "_self")
    }
}

/*
    TODO: 
    - SignUP
    - Customer
    - Get Products
    - Redundancy Checks
    - Login and SignUp seem redundant, check on this further
*/

async function SignUp(creds) { //Params

    url = localStorage.getItem('website') + "/api/v1/login/new/user/token=" + generateToken(creds.id);

    const config = {
        method: 'POST',
        headers : {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json',
        },
        body : JSON.stringify(creds)
    }

    const token = await fetch (url, config).then((res) => res.text());

    console.log(token);


    if(token == 'User Exists') {
        // Do user existing action
    } else {
        localStorage.setItem("token", token);
        // Get additional user details and finish 
    }
}

  

function generateToken(username) {
    // Perform a better login action here
    return username;
}


