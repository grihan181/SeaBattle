function connect() {
    socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/' + [[${roomNumber}]], function (shot) {
            showShooting(JSON.parse(shot.body));
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
    userShot = false;
    console.log(userShot);
    stompClient.send("/app/shots/" + [[${roomNumber}]], {}, JSON.stringify({'x': i, 'y':j, 'symbol': symbol}));
}

function showShooting(shot) {
    if(shot.symbol == "❌") {
        document.getElementById(shot.x + '' + shot.y).innerHTML = "❌";
        document.getElementById(shot.x + '' + shot.y).style.backgroundColor = "red";
    } else {
        document.getElementById(shot.x + '' + shot.y).innerHTML = "•";
    }
}