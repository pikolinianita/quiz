const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/gs-guide-websocket'
});

let name = "Idiot";

messageDiv = '<div class="message mt-3 mb-3 " id="chat1-message-1"><div class="author text-primary">!!User!!</div>!!Msg!!</div>';

stompClient.onConnect = (frame) => {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/chat', (msg) => {
        processMessage(msg.body);
    });
    getHistory();
};

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    stompClient.activate();
}

function disconnect() {
    stompClient.deactivate();
    setConnected(false);
    console.log("Disconnected");
}

function assignName() {
    name =  $("#name").val();
    alert("Your name is " + name);
}

function sendMessage() {
    stompClient.publish({
        destination: "/app/msg",
        body: JSON.stringify({'user': name, 'message': $("#message-input").val()})
    });
    $("#message-input").val("");
}

function getHistory() {
    stompClient.publish({
        destination: "/app/history",
        body: "GetHistoryCall"
    });
}

function appendMessage(m){
    let msg = messageDiv.replace("!!User!!", m.user).replace("!!Msg!!",  m.message);
    $("#chat1-messages").append("<tr><td>" + msg + "</td></tr>");
    scrollToBottom();
}

function appendPicture(m){
console.log(m);
    let msg = messageDiv.replace("!!User!!", m.user).replace("!!Msg!!",m.pictureID + "<br> This is a Picture");
    $("#chat2-messages").append("<tr><td>" + msg + "</td></tr>");
    scrollToBottom();
}

function processMessage(message) {
    let m = JSON.parse(message);
    if (m.type === "MESSAGE") {
         appendMessage(m)
    } else if (m.type === "PICTURE"){
         appendPicture(m);
    }
}

 function scrollToBottom() {
        let chatDiv = $("#chat1-messages");
        chatDiv.scrollTop(chatDiv.prop("scrollHeight"));
    }

$(function () {
    $("form").on('submit', (e) => e.preventDefault());
    $( "#connect" ).click(() => connect());
    $( "#disconnect" ).click(() => disconnect());
    $( "#assignName" ).click(() => assignName());
    $( "#messageBtn" ).click(() => sendMessage());

});