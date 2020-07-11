var stompClient = null;

function connect() {
    var socket = new SockJS('http://localhost:8090/gs1');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Really Connected: ' + frame);
        /*      stompClient.subscribe('/buddy-chatter/topic/greetings', function (greeting) {
                  function showGreeting(content) {
                      listmaker(JSON.parse(greeting.body).content);
                  }
                  showGreeting(JSON.parse(greeting.body).content);
              });*/
    });


}

/*function listmaker(elementById1) {
    let elementById = document.getElementById("message");
    var node = document.createElement("LI");// Create a <li> node
    node.className = "list-group-item";
    var textnode = document.createTextNode(elementById1);         // Create a text node
    node.appendChild(textnode);                              // Append the text to <li>
    elementById.appendChild(node);
}*/

/*function sendName() {
    var elementById1 = document.getElementById("myId").value;
    if (elementById1 === '')
        return;
    document.getElementById("myId").value = '';
    listmaker(elementById1);
    stompClient.send("/buddy-chatter/hello", {}, elementById1);
}*/

/*
function test() {
    console.log("Called");
    $('.alert').alert("Hiiiiiiiiiii");
}*/
