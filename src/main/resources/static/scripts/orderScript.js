
var customersPath = "customer/getAll";
var executorPath = "executor/getAll";
var typesPath = "/types";
var executorWithType = "executor/get?type=";

function generateOptionInSelector(path){
    let xhr = getRequestObj("post", path, null);

    xhr.onload = function(){
        if(this.status == 200){
            let JsonArray = JSON.parse(this.response);

            if(path == typesPath) {
                fillSelect("work", JsonArray);
            }
            else {
                fillSelect("customer", JsonArray);
            }
        }
    }


    xhr.send(null);
}

function fillExecutorWithType(type){
    executorArray = [];

    let xhr = getRequestObj("post", executorWithType + type, "application/json");

    xhr.onload = function(){
        if(this.status == 200){
            executorArray = JSON.parse(this.response);
        }

        fillSelect("executor", executorArray);
    }

    xhr.send(JSON.stringify(type));
}

function fillSelect(selectId, JsonArray){
    let selectElement = document.getElementById(selectId);

    JsonArray.forEach(element => {
        let option = document.createElement("option");

        option.dataset.id = element["id"];

        option.innerHTML = element[Object.keys(element)[1]]
        
        selectElement.appendChild(option);
    });
}

function fillsCustomersAndTypes(){
    generateOptionInSelector(customersPath);
    generateOptionInSelector(typesPath);
}

function onTypeChange(){
    let executorSelector = document.getElementById("executor");


    while(executorSelector.firstChild){
        executorSelector.firstChild.remove();
    }

    executorSelector.appendChild(document.createElement("option"));

    if(document.getElementById("work").selectedIndex == 0) return;

    fillExecutorWithType(document.getElementById("work").selectedIndex);
}

function sendOrder(){
    let xhr = getRequestObj("post", "order/add", "application/json");

    console.log(createJSON());

    xhr.send(JSON.stringify(createJSON()));

    document.getElementById("customer").selectedIndex = 0;
}

function createJSON(){
    let customerSelector = document.getElementById("customer");
    let executorSelector = document.getElementById("executor");

    return {
        "customer" : customerSelector.selectedOptions[0].dataset.id,
        "executor" : executorSelector.selectedOptions[0].dataset.id
    };
}

window.onload = function(){
    generateOptionInSelector(customersPath);
    generateOptionInSelector(typesPath);
}


function getRequestObj(type, url, content){
    let xhr = new XMLHttpRequest();

    xhr.open(type, url, true);
    xhr.setRequestHeader("Content-Type", content);

    return xhr;
}

