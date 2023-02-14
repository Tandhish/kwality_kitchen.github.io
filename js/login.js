
async function Login(creds) {
    let params = JSON.parse(creds) //Redundant

    url = localStorage.getItem('website') + "api/v1/login/autenticate/user/token=" + generateToken(j.name);

    const config = {
        method : 'POST',
        headers : {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json',
        },
        body : JSON.stringify(params)
    }

    const token = await fetch (url, config).then((res) => res.text());

    if(token == 'N/A') {
        // Do Login failed action
    }
    else {
        localStorage.setItem("token", token);
        // Perform further actions
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
    let params = JSON.parse(creds); //Redundant

    url = localStorage.getItem('website') + "api/v1/login/new/user/token={token}"

    const config = {
        method: 'POST',
        headers : {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json',
        },
        body : JSON.stringify(params)
    }

    const token = await fetch (url, config).then((res) => res.text());

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