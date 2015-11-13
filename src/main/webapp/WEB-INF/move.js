/**
 * Created by employee on 11/13/15.
 */
document.body.addEventListener("keydown", function(e) {
    var xhr = new XMLHttpRequest();
    var body = 'option=' + encodeURIComponent("" + e.keyCode);
    xhr.open("POST", "/", true)
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
    xhr.onreadystatechange = function()
    {
        if (xhr.readyState == 4 && xhr.status == 200)
        {
        }
    }
    xhr.send(body);
    console.log(e.keyCode);
});