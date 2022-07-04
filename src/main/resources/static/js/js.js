

function enviarDatos(){
    const adminUsuario = document.getElementById("usuario").value;
    const adminContraseña = document.getElementById("contrasena").value;
    console.log(adminUsuario);
    
    var url = "http://localhost:8080/admin/"+adminUsuario+"/"+adminContraseña;
    window.location.href = url;
    
     
}


