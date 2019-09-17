var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#thread").show();
    }
    else {
        $("#thread").hide();
    }
    $("#words").html("");
}

function connect() {
    var socket = new SockJS('/falcon-assignment');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/words', function (word) {
            showWord(JSON.parse(word.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendWord() {
    //client.send(destination, header, body)
    stompClient.send("/app/hello", {}, JSON.stringify({'content': $("#word").val()}));
}

function showWord(word) {
    $("#words").append("<tr><td>" + word + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendWord(); });
});