<%@ page import="core.GameField" %>
<%@ page import="core.GameFieldImpl" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
      <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
      <link rel="stylesheet" href="/resources/css/style.css" type="text/css" />
      <script>
          jQuery(document).bind('keydown', function (evt){
//              var direction;
//              switch(evt.which) {
//                  case 37:
//                      direction = "left";
//                      break;
//                  case 38:
//                      direction = "up";
//                      break;
//                  case 39:
//                      direction = "right";
//                      break;
//                  case 40:
//                      direction = "down";
//                      break;
//                  default: direction = "no_direction";
//              }
              $.ajax({
                  url: "/game?option=" + evt.which,
                  type : "POST",
                  async: true,
                  success : function() {

                          document.getElementsByClassName("test").innerHTML = responseText;


                  }
              });
          });
      </script>

  </head>
   <body>

<div id="test">

</div>
   <table>
       <tr><td></td>
           <td><a href="/action/8">up</a></td>
           <td></td>
       </tr>
       <tr><td><a href="/action/4">left</a></td>
           <td></td>
           <td><a href="/action/6">right</a></td>
       </tr>
       <tr><td></td>
           <td><a href="/action/5">down</a></td>
           <td></td>
       </tr>
   </table>




  </body>
</html>
