
async function Login(creds) {
    let params = JSON.parse(creds)

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
*/

function generateToken(username) {
    // Perform a better login action here
    return username;
}