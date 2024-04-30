// Call the dataTables jQuery plugin
$(document).ready(async function() {
    //on ready
});

async function createUser(){

    let name = document.getElementById("name").value;
    let last_name = document.getElementById("last_name").value;
    let email = document.getElementById("email").value;
    let tel = document.getElementById("tel").value;
    let password = document.getElementById("password").value;
    let repassword = document.getElementById("repassword").value;

    if(name === '' || last_name === '' || email === '' || tel === '' || password === ''){
        alert("Todos los campos son obligatorios");
        return;
    }

    if(password !== repassword){
        alert("Las contraseñas no son iguales!");
        return;
    }

    let data = {
        name: name,
        last_name: last_name,
        email: email,
        tel: tel,
        password:password
    }

    const response = await fetch("api/user", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    alert("Usuario creado");
}