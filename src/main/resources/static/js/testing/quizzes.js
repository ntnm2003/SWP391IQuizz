function setPageFilters() {
    const urlParams = new URLSearchParams(window.location.search);
    const type = urlParams.get("testtype");
    const subject = urlParams.get("subject");
    const sortBy = urlParams.get("sortBy");
    const order = urlParams.get("order");
    const searchValue=urlParams.get("searchValue");
    if (type) {
        document.getElementById("typeSelect").value = type;
    }
    if (subject) {
        document.getElementById("subjectSelect").value = subject;
    }

    if (sortBy) {
        document.getElementById("sortBySelect").value = sortBy;
    }
    if (order) {
        document.getElementById("orderSelect").value = order;
    }
    if(searchValue){
        document.getElementById("search").value=searchValue;
    }
}

window.addEventListener("load", setPageFilters);
function navigateToInteract() {
    var type = document.getElementById("typeSelect").value;
    var subject = document.getElementById("subjectSelect").value;
    var sortBy=document.getElementById("sortBySelect").value;
    var order=document.getElementById("orderSelect").value;
    var searchValue=document.getElementById("search").value;

    var url = "/testingcontent/quizzeslist?";
    var filters = [];

    if(searchValue){
        filters.push("searchValue=" + searchValue);
    }
    if (type) {
        filters.push("type=" + type);
    }

    if (subject) {
        filters.push("subject=" + subject);
    }
    if(sortBy) {
        filters.push("sortBy="+sortBy);
    }
    if(order) {
        filters.push("order="+order);
    }
    url += filters.join("&");

    window.location.href = url;

}
function moveOn(pageNo){

    var type = document.getElementById("typeSelect").value;
    var subject = document.getElementById("subjectSelect").value;
    var sortBy=document.getElementById("sortBySelect").value;
    var order=document.getElementById("orderSelect").value;
    var searchValue=document.getElementById("search").value;

    var url = "/testingcontent/quizzeslist?pageNo=" + (parseInt(pageNo) + 1)+"&";

    var filters = [];

    if(searchValue){
        filters.push("searchValue=" + searchValue);
    }
    if (type) {
        filters.push("type=" + type);
    }

    if (subject) {
        filters.push("subject=" + subject);
    }
    if(sortBy) {
        filters.push("sortBy="+sortBy);
    }
    if(order) {
        filters.push("order="+order);
    }
    url += filters.join("&");

    window.location.href = url;
}

function moveBack(pageNo){
    var type = document.getElementById("typeSelect").value;
    var subject = document.getElementById("subjectSelect").value;
    var sortBy=document.getElementById("sortBySelect").value;
    var order=document.getElementById("orderSelect").value;
    var searchValue=document.getElementById("search").value;

    var url = "/testingcontent/quizzeslist?pageNo=" + (parseInt(pageNo) + 1)+"&";

    var filters = [];

    if(searchValue){
        filters.push("searchValue=" + searchValue);
    }
    if (type) {
        filters.push("type=" + type);
    }

    if (subject) {
        filters.push("subject=" + subject);
    }
    if(sortBy) {
        filters.push("sortBy="+sortBy);
    }
    if(order) {
        filters.push("order="+order);
    }
    url += filters.join("&");

    window.location.href = url;
}
function showPopup() {
    document.getElementById("popupForm").style.display = "block";
}

function hidePopup() {
    document.getElementById("popupForm").style.display = "none";
}
$('.js-input' ).keyup(function() {
    if( $(this).val() ) {
        $(this).addClass('not-empty');
    } else {
        $(this).removeClass('not-empty');
    }
});
function closeDiv() {
    const divToClose = document.querySelector('.div-to-close');
    divToClose.style.display = 'none';
}

const closeButton = document.querySelector('.close-button');
closeButton.addEventListener('click', closeDiv);