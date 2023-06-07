function setPageFilters() {
    const urlParams = new URLSearchParams(window.location.search);
    const gender = urlParams.get("gender");
    const status_ = urlParams.get("status");
    const role = urlParams.get("role");
    const sortBy = urlParams.get("sortBy");
    const order = urlParams.get("order");
  
    if (gender) {
      document.getElementById("genderSelect").value = gender;
    }
    if (role) {
      document.getElementById("roleSelect").value = role;
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
  }
  
window.addEventListener("load", setPageFilters);
function navigateToFilterAndSort() {
    var gender = document.getElementById("genderSelect").value;
    var status = document.getElementById("statusSelect").value;
    var role = document.getElementById("roleSelect").value;
    var sortBy=document.getElementById("sortBySelect").value;
    var order=document.getElementById("orderSelect").value;

    var url = "/admin/user-list?";
    var filters = [];

    if (gender) {
        filters.push("gender=" + gender);
    }
    if (status) {
        filters.push("status=" + status);
    }
    if (role) {
        filters.push("role=" + role);
    }
    if(sortBy) {
        filters.push("sortBy="+sortBy);
    }
    if(order) {
        filters.push("order="+order);
    }
    url += filters.join("&");
    

    // Navigate to the filtered URL
    window.location.href = url;
}