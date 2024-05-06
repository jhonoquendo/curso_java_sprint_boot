// Call the dataTables jQuery plugin
$(document).ready(async function() {
    //on ready
});

async function login(){

    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    if(email === ''  || password === ''){
        alert("Todos los campos son obligatorios");
        return;
    }

    let data = {
        email: email,
        password:password
    }

    const response = await fetch("api/login", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    const res = await response.text();

    if(res !== "FAIL"){
        localStorage.token = res.token;
        localStorage.email = data.email;
        window.location.href = "users.html";
        return;
    }

    alert("Las credenciales son incorrectas");
}