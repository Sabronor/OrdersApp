
function sendObject(){
    let xhr = getRequestObj("post", "customer/add", "application/json");

    xhr.send(JSON.stringify(createJSON()));

    inputClear();
}

function createJSON(){
    return {
        "name" : document.getElementById("name").value,
        "lastName" : document.getElementById("lastName").value,
        "city" : document.getElementById("city").value,
        "phone" : document.getElementById("phone").value
    }
}

function inputClear(){
    let inputCollection = document.getElementsByTagName("input");

    for(let i = 0; i < inputCollection.length; i++){
        inputCollection.item(i).value = "";
    }
}

function getRequestObj(type, url, content){
    let xhr = new XMLHttpRequest();

    xhr.open(type, url, true);
    xhr.setRequestHeader("Content-Type", content);

    return xhr;
}