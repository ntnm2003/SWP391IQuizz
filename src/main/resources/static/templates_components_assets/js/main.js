
let navigation = document.querySelector('.navbar__content');
let menuToggle = document.querySelector('.menuToggle');
let header = document.querySelector('header');

menuToggle.onclick = function () {
    header.classList.toggle('open');
}

