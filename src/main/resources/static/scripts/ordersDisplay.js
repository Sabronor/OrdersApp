
var currentPage = 0;


function getAllOrders(){
    let xhr = getRequestObj("post", "order/getOrders/" + currentPage, null);

    xhr.onload = function(){
        if(this.status == 200){
            let objects = JSON.parse(this.response);
            
            if(objects.length > 0){
                clearTable();
                
                objects.forEach(row =>{
                    createRow(row);
                });
            }
            changeButtonStatus(objects);
        }
    }

    xhr.send(null);
}

function createRow(row){
    let rowElement = document.createElement("tr");

    let columnCustomerName = document.createElement("td");
    let columnCustomerLastName = document.createElement("td");

    let columnExecutorName = document.createElement("td");
    let columnExecutorLastName = document.createElement("td");

    let columnWorkType = document.createElement("td");

    columnCustomerName.innerHTML = row["customer"]["name"];
    columnCustomerLastName.innerHTML = row["customer"]["lastName"];
    
    columnExecutorName.innerHTML = row["executor"]["name"];
    columnExecutorLastName.innerHTML = row["executor"]["lastName"];

    columnWorkType.innerHTML = row["executor"]["type"]["type"];

    rowElement.appendChild(columnCustomerName);
    rowElement.appendChild(columnCustomerLastName);
    rowElement.appendChild(columnExecutorName);
    rowElement.appendChild(columnExecutorLastName);
    rowElement.appendChild(columnWorkType);

    document.getElementById("orders").appendChild(rowElement);
}

function getRequestObj(type, url, content){
    let xhr = new XMLHttpRequest();

    xhr.open(type, url, true);
    xhr.setRequestHeader("Content-Type", content);

    return xhr;
}

function clearTable(){
    let trElements = document.getElementsByTagName("tr");
    while(trElements[1]) trElements[1].remove();
}

function nextPage(){
    currentPage++;
    getAllOrders();
}

function prevPage(){
    currentPage--;
    getAllOrders();
}

function changeButtonStatus(arr){
    if(arr.length < 10){
        document.getElementById("next").style.display = "none";
    }else{
        document.getElementById("next").style.display = "block";
    }

    if(currentPage > 0){
        document.getElementById("prev").style.display = "block";
    }else{
        document.getElementById("prev").style.display = "none";
    }
}


window.onload = function(){
    getAllOrders();
}