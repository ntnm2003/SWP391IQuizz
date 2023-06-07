function setPageFilters() {
    const urlParams = new URLSearchParams(window.location.search);
    const type = urlParams.get("type");
    const status_ = urlParams.get("status");
    const sortBy = urlParams.get("sortBy");
    const order = urlParams.get("order");
    const value=urlParams.get("value");
  
    if (type) {
        document.getElementById("typeSelect").value = type;
    }
    if (status_) {
        document.getElementById("statusSelect").value = status_;
    }
    if (sortBy) {
        document.getElementById("sortBySelect").value = sortBy;
    }
    if (order) {
        document.getElementById("orderSelect").value = order;
    }
    if(value){
        document.getElementById("search").value = value;
    }
}
  
window.addEventListener("load", setPageFilters);
function navigateToInteract() {
    var type = document.getElementById("typeSelect").value;
    var status = document.getElementById("statusSelect").value;
    var sortBy=document.getElementById("sortBySelect").value;
    var order=document.getElementById("orderSelect").value;
    var value=document.getElementById("search").value;
    var url = "/admin/search-setting?value="+value+"&";
    var filters = [];

    if (type) {
        filters.push("type=" + type);
    }
    if (status) {
        filters.push("status=" + status);
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
    var status = document.getElementById("statusSelect").value;
    var sortBy=document.getElementById("sortBySelect").value;
    var order=document.getElementById("orderSelect").value;
    var value=document.getElementById("search").value;
    
    var url = "/admin/search-setting?value="+value+"&pageNo=" + (parseInt(pageNo) + 1) + "&";
    var filters = [];

    if (type) {
        filters.push("type=" + type);
    }
    if (status) {
        filters.push("status=" + status);
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
    var status = document.getElementById("statusSelect").value;
    var sortBy = document.getElementById("sortBySelect").value;
    var order = document.getElementById("orderSelect").value;
    var value=document.getElementById("search").value;

    var url = "/admin/search-setting?value="+value+"&pageNo=" + (parseInt(pageNo) - 1) + "&";
    var filters = [];

    if (type) {
        filters.push("type=" + gender);
    }
    if (status) {
        filters.push("status=" + status);
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