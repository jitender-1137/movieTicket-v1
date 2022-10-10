function signUp() {
  var myHeaders = new Headers();
  myHeaders.append("Accept", "application/json");
  myHeaders.append("Content-Type", "application/json");

  var raw = JSON.stringify({
                "id":"",
                "name": document.getElementById('name').value,
                "username":document.getElementById('username').value,
               "email":document.getElementById('email').value,
               "gender":document.getElementById('gender').value,
               "dob":document.getElementById('dob').value,
               "password":document.getElementById('pwd').value,
               "rePassword":document.getElementById('cpwd').value,
               "termsAndCondtions":document.getElementById('termAndConditons').checked
  });

  var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
  };
  let response;
  fetch("http://localhost:8080/v1/addUser", requestOptions)
    .then(response => response.json())
    .then((result) => {
        console.log('Success:', result);
        if(result.code==200)
            document.getElementById('signupForm').reset();
        alert(result.message);

      });
}