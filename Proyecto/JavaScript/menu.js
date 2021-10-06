let btnMenu = document.getElementById('btn-menu');
let navegacion = document.getElementById('navegacion');
btnMenu.addEventListener('click', function(){
    navegacion.classList.toggle('mostrar');
});