function validateForm() {
    var x = document.getElementById("idNumber").value;
    if (isNaN(x)) {
        alert("El valor ingresado no es un numero.");
        return false;
    }
}