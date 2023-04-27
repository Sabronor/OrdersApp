
function getAllType(){
    let xhr = getRequestObj("post", "/types", null);

    xhr.onload = function(){
        if(xhr.status == 200){
            fillSelector(JSON.parse(this.response));
        }
    }

    xhr.send(null);

}

function fillSelector(array){
    array.forEach(type => {
        let optionElement = document.createElement("option");

        optionElement.dataset.id = type["id"];
        optionElement.innerHTML = type["type"];

        document.getElementById("types").appendChild(optionElement);
    });
}


function sendExecutor(){
    let xhr = getRequestObj("post", "executor/add", "application/json");

    xhr.send(JSON.stringify(createJSON()));

    inputClear();
}



function createJSON(){
    return {
        "name" : document.getElementById("name").value,
        "lastName" : document.getElementById("lastName").value,
        "type" : document.getElementById("types").selectedOptions[0].dataset.id
    };
}



window.onload = function(){
    getAllType();
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