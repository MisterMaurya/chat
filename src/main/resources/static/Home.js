let loginUserId;
let imageProfile;
const girlPhoto = ["https://i.pinimg.com/736x/be/bc/19/bebc1944d4b38689a6f527c69a5844ab.jpg",
    "https://i.pinimg.com/originals/cf/ab/1e/cfab1e91af14fbd7c172fd0e9ed660e8.png",
    "https://i.pinimg.com/736x/9c/da/f0/9cdaf0cfcaff852a422166ddf0245fee.jpg",
    "https://i.pinimg.com/originals/aa/e1/19/aae119481d5f19adc27301aae1bdf94a.jpg",
    "https://i.pinimg.com/originals/5d/ae/15/5dae15d6bcc12f1f06924bc429596712.jpg"
];

const boyImages = [
    "https://i7.pngguru.com/preview/286/149/247/black-hair-drawing-eye-eye.jpg",
    "https://i7.pngguru.com/preview/286/149/247/black-hair-drawing-eye-eye.jpg",
    "https://pm1.narvii.com/6065/024fd28235b0022699e1e72090070a50d7662ca7_hq.jpg",
    "https://i.pinimg.com/236x/e6/c5/c7/e6c5c77cab863a75b947f16a5e1504ed--anime-jungs-kagerou-project.jpg",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRr8Jcf1sKGB4aX6I3LaK287FJHJfSKRaQjBw&usqp=CAU"
];

function register() {
    const params = {
        email: document.querySelector('#inputEmail4').value,
        password: document.querySelector('#inputPassword4').value,
        firstName: document.querySelector('#firstName').value,
        lastName: document.querySelector('#lastName').value,
        gender: document.getElementById("gridRadios1").checked ? "MALE" : "FEMALE"
    };

    const http = new XMLHttpRequest();
    http.open('POST', '/api/v1/user');
    http.setRequestHeader('Content-type', 'application/json');
    http.send(JSON.stringify(params)); // Make sure to stringify
    http.onload = function () {
        /*   let alertBox = "";*/
        if (this.status === 201) {
            /*alertBox = document.getElementById("alertBox");
            alertBox.hidden = false;
            alertBox.className = "alert alert-success";
            alertBox.innerHTML = JSON.parse(this.responseText).firstName + ' you successfully register';*/

            alert(JSON.parse(this.responseText).firstName + ' you successfully register');
            document.getElementById("prospects_form").reset();
            document.getElementById("logIn").hidden = false;
            document.getElementById("signUp").hidden = true;
            document.getElementById("showSignUp").hidden = false;
            document.getElementById("showLogIn").hidden = true;
        } else {
            alert(JSON.parse(this.responseText).message);
            /*   console.log("Here");
               alertBox = document.getElementById("alertBox");
               alertBox.innerHTML = ;
               alertBox.className = "alert alert-danger";
               alertBox.hidden=false;*/
        }
    }
}

function hideShow() {
    if (document.getElementById("signUp").hidden === true) {
        /*      document.getElementById("alertBox").hidden = true;*/
        document.getElementById("logIn").hidden = true;
        document.getElementById("signUp").hidden = false;
        document.getElementById("showSignUp").hidden = true;
        document.getElementById("showLogIn").hidden = false;
    } else {
        document.getElementById("logIn").hidden = false;
        document.getElementById("signUp").hidden = true;
        document.getElementById("showSignUp").hidden = false;
        document.getElementById("showLogIn").hidden = true;
    }
}

function loginBuddy() {
    const params = {
        email: document.querySelector('#inputEmail4Login').value,
        password: document.querySelector('#inputPassword4Login').value,
    };
    const http = new XMLHttpRequest();
    http.open('POST', '/api/v1/login');
    http.setRequestHeader('Content-type', 'application/json');
    http.send(JSON.stringify(params));

    http.onload = function () {
        /*let alertBox = null;*/
        if (this.status === 200) {
            let elementById = document.getElementById("loginSuccess");
            elementById.hidden = false;
            document.getElementById("showSignUp").hidden = true;
            document.getElementById("logIn").hidden = true;
            let x = JSON.parse(this.responseText);
            loginUserId = x.id;
            imageProfile = x.gender === "MALE" ? boyImages[Math.floor(Math.random() * boyImages.length)] :
                girlPhoto[Math.floor(Math.random() * girlPhoto.length)];
            console.log("Login User Id  :: " + loginUserId);
            document.getElementById("profileName").innerText = x.firstName + ' ' + x.lastName;
            document.getElementById("profilePic").src=imageProfile;
        } else {
            /*  alertBox = document.getElementById("alertBox");
              alertBox.innerHTML = JSON.parse(this.responseText).message;
              alertBox.className = "alert alert-danger";
              alertBox.hidden = false;*/
            alert(JSON.parse(this.responseText).message);
        }
    }
}

function friendList() {
    document.getElementById("friendListButton").hidden = true;
    const http = new XMLHttpRequest();
    let url = '/api/v1/user/' + loginUserId + '?projection=ff';
    http.open('GET', url);
    http.setRequestHeader('Content-type', 'application/json');
    http.send(null);
    http.onload = function () {
        let mavra;
        if (this.status === 200) {
            console.log(this.status);
            document.getElementById("friend-list").innerHTML = "";
            document.getElementById("dynamicFriendList").hidden = false;
            let parse = JSON.parse(this.responseText);
            var z = parse.findFriend;
            for (i in z) {
                fullName = parse.findFriend[i].fullName;
                fid = parse.findFriend[i].id;
                gender = parse.findFriend[i].gender;
                imageProfile = gender === "MALE" ? boyImages[Math.floor(Math.random() * boyImages.length)] :
                    girlPhoto[Math.floor(Math.random() * girlPhoto.length)];

                let profile = [fid, fullName, imageProfile];
                mavra = '<li class="media d-flex align-items-center mb-3">' +
                    '                    <img src="' + imageProfile + '" class="mr-2" alt="...">' +
                    '                    <div class="media-body ">' +
                    '                        <h6 class="text-capitalize">' + fullName + ' </h6>' +
                    '                    </div>' +
                    '                    <button type="button" id="13" class="btn btn-danger "  value="' + profile + '" onClick="chatBox(this.value)">' +
                    '                        Message' +
                    '                    </button>' +
                    '                </li>';

                /*   mavra = '<li class="friend  border  justify-content-between  pr-2">' +
                       '                        <div class="row  justify-content-center" style="margin-left: 1px;">' +
                       '                            <img src="' + imageProfile + '" alt="">' +
                       '                            <div class=\'name p-2\'>' + fullName +
                       '                            </div>' +
                       '                        </div>' +
                       '                        <button  id="' + fid + '" type="button" class="btn btn-danger "  value="' + profile + '" onClick="chatBox(this.value)">' +
                       '                            Message' +
                       '           </button>' +
                       '                    </li>';*/
                document.getElementById("friend-list").innerHTML += mavra;
            }
        } else {
            console.log("Im here");
        }
    };
}

function chatBox(x) {
    let elementById = document.getElementById("chatBox");
    document.getElementById("showSendButton").hidden = false;
    elementById.hidden = false;
    document.getElementById("msgList").innerHTML = "";
    x = x.split(",");
    document.getElementById("receiverName").innerHTML = x[1];
    document.getElementById("receiverProfileImage").src = x[2];
    document.getElementById("sendButton").value = x[0];
    stompClient.subscribe("/buddy-chatter/receive/" + loginUserId, callback);
}

function sender() {
    let elementById = document.getElementById("msgList");
    let innerTextMsg = document.getElementById("msgTextSend").value;
    console.log(innerTextMsg);
    if (innerTextMsg === '') return;


    var myvar = '<div class="row  justify-content-end mb-1 pr-1">' +
        '                <div class="card text-right" style="width: 18rem;">' +
        '                    <p class="card-text p-2" id="receiverMsg">' + innerTextMsg +
        '                        </p>' +
        '                </div>' +
        '            </div>';


 /*   var myvar = '<div class="row justify-content-start  pl-1 mb-1">' +
        '                <div class="card" style="width: 18rem;">' +
        '                    <p class="card-text p-2">' + innerTextMsg + '</p>' +
        '                </div>' +
        '            </div>';*/



    elementById.innerHTML += myvar;
    document.getElementById("msgTextSend").value = '';
    let receiverId = document.getElementById("sendButton").value;
    let sendText = {'id': receiverId, 'msg': innerTextMsg};

    console.log("RECEIVER ID" + receiverId);
    console.log("LoginUSer ID" + loginUserId);
    console.log(sendText);
    stompClient.send("/buddy-chatter/send", {},
        JSON.stringify(sendText));

    // For ScrollBar
    let messageBody = document.querySelector('#msgList');
    messageBody.scrollTop = messageBody.scrollHeight - messageBody.clientHeight;

}

callback = function (msg) {
    console.log("Login User Id" + loginUserId);
    if (msg.body) {
        let elementById = document.getElementById("msgList");


        var myvar = '<div class="row justify-content-start  pl-1 mb-1">' +
            '                <div class="card" style="width: 18rem;">' +
            '                    <p class="card-text p-2">' + msg.body  + '</p>' +
            '                </div>' +
            '            </div>';


       /* var myvar = '<div class="row  justify-content-end mb-1 pr-1">' +
            '                <div class="card text-right" style="width: 18rem;">' +
            '                    <p class="card-text p-2" id="receiverMsg">' + msg.body +
            '                        </p>' +
            '                </div>' +
            '            </div>';*/


        elementById.innerHTML += myvar;
        // For ScrollBar
        let messageBody = document.querySelector('#msgList');
        messageBody.scrollTop = messageBody.scrollHeight - messageBody.clientHeight;
    }
};









