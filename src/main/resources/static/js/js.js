
function enviarDatosAdmin(){
    const adminUsuario = document.getElementById("usuario").value;
    const adminContraseña = document.getElementById("contrasena").value;
    console.log(adminUsuario);
    localStorage.setItem('perfilUsuario',JSON.stringify(adminUsuario));
    localStorage.setItem('perfilContraseña',JSON.stringify(adminContraseña));
    var url = "http://localhost:8080/admin/"+adminUsuario+"/"+adminContraseña;
    window.location.href = url;
    
}

function enviarDatosCliente(){
    const clienteUsuario = document.getElementById("usuario").value;
    const clienteContraseña = document.getElementById("contrasena").value;
    console.log(clienteUsuario);
    localStorage.setItem('perfilUsuario',JSON.stringify(clienteUsuario));
    localStorage.setItem('perfilContraseña',JSON.stringify(clienteContraseña));
    var url = "http://localhost:8080/cliente/"+clienteUsuario+"/"+clienteContraseña;
    window.location.href = url;
    
}

function recuperarUsuarioYContraseñaAdmin(){
    var usuario = JSON.parse(localStorage.getItem('perfilUsuario'));
    var contrasena = JSON.parse(localStorage.getItem('perfilContraseña'));
    var url = "http://localhost:8080/admin/"+usuario+"/"+contrasena;
    window.location.href = url;
}

function recuperarUsuarioYContraseñaCliente(){
    var usuario = JSON.parse(localStorage.getItem('perfilUsuario'));
    var contrasena = JSON.parse(localStorage.getItem('perfilContraseña'));
    var url = "http://localhost:8080/cliente/"+usuario+"/"+contrasena;
    window.location.href = url;
}

function recuperarUsuario(){
    var usuario = JSON.parse(localStorage.getItem('perfilUsuario'));
    document.getElementById("userField").textContent = usuario;
}

window.onload = function(){
    recuperarUsuario();
};






