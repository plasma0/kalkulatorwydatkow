<%--
  Created by IntelliJ IDEA.
  User: koka
  Date: 11.12.17
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>${title}</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script>
        function valide() {
            var pas = document.getElementById('password').value;
            var cof = document.getElementById('confirm').value;
            if(pas==cof)
            {
                console.log("TRIGGER");
                document.getElementById('pasc').style.visibility="hidden";
                document.getElementById('sbt').disabled = false;
            }
            else
            {
                console.log("TRIGGER2");
                document.getElementById('pasc').style.visibility="visible";
                document.getElementById('sbt').disabled = true;
            }
        }
        function load(docName)
        {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function()
            {
                if(this.readyState == 4 && this.status == 200)
                {
                    document.getElementById("navs").style.display = 'none';
                    document.getElementById("frm").innerHTML = this.responseText;
                }
            };
            xhttp.open("GET",docName,true);
            xhttp.send();
        }
    </script>
  </head>
  <body>
  <img src="http://i.dailymail.co.uk/i/pix/2014/02/01/article-2550245-1B225D3100000578-998_634x433.jpg" width=400 height=300/>
  <br>
  <p id="navs">
    <button class="btn btn-primary" type="button" onClick="load('/login')">${login}</button>
    <button class="btn btn-primary" type="button" onClick="load('/create')">${add}</button>
  </p>
  <p id="frm"></p>
  </body>
</html>
