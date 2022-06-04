let stompClient = null;


function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/' + [[${roomNumber}]], function (greeting) {
            showShooting(JSON.parse(greeting.body).content);
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

function sendShoot(i, j, symbol) {
    stompClient.send("/app/shots/" + [[${roomNumber}]], {}, JSON.stringify({'x': i, 'y':j, 'symbol': symbol}));
}

function showShooting(shot) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
    if(symbol == "❌") {
        document.getElementById(i + '' + j).innerHTML = symbol;
        document.getElementById(i + '' + j).style.backgroundColor = "red";
    } else {
        document.getElementById('e' + i + '' + j).innerHTML = symbol;
    }
}