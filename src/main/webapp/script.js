// const toggleBtn = document.getElementsByClassName('toggle-btn')[0]
// const navBarLinks = document.getElementsByClassName('navbar-links')[0]
// // let active='false';
// toggleBtn.addEventListener('click', () => {
//     navBarLinks.classList.toggle('active')
// })

// const newPassword = document.getElementById("newPassword").value 
// const currPassword = document.getElementById("currPassword").value
// const name = document.getElementById("name")

function validate() {
    let email = document.getElementById("email").value;
    let ifsc = document.getElementById("ifsc").value;
    let pan = document.getElementById("pan").value;
    let aadhar = document.getElementById("aadhar").value
//    console.log(email);

    let regx = /^([a-zA-Z0-9\._]+)@([a-zA-Z0-9])+(\.)([a-z]+)(.[a-z]+)?$/
    if (email.match(regx)) {
        console.log('You have provided a valid email ID');
    }
    else {
        if (email == '') {
            alert(`Email field can't be empty`);
        } else {
            console.log('You have provided an Invalid email ID');
        }
    }

    let regxIfsc = /[A-Z]{4}[0-9]{7}/
    if(ifsc.match(regxIfsc)){
        console.log('Valid IFSC code');
    }
    else{
        console.log('Invalid IFSC code');
    }

    let regxPan = /[A-Z]{5}[0-9]{4}[A-Z]{1}/

    if(pan.match(regxPan)){
        console.log('Valid PAN Card ID');
    }

    else{
        console.log('Invalid PAN Card ID');
    }

    let regxAadhar = /[A-Z]{5}[0-9]{4}[A-Z]{1}/

    if(aadhar.match(regxAadhar)){
        console.log('Valid Aadhar Card ID');
    }

    else{
        console.log('Invalid Aadhar Card ID');
    }
}