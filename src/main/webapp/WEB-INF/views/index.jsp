<%@ page import="core.GameField" %>
<%@ page import="core.GameFieldImpl" %>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <sec:csrfMetaTags/>
    <title></title>
      <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

      <script >
          jQuery(document).bind('keydown', function (evt){
              var headers = {};
              var csrfHeader = $("meta[name='_csrf_header']").attr("content");
              var csrfToken = $("meta[name='_csrf']").attr("content");
              headers[csrfHeader] = csrfToken;

              $.ajax({
                  url: "/" + evt.which,
                  type : "POST",
                  async: true,
                  headers: headers,
                  success : function(response) {

                          document.getElementById("test").innerHTML = response;


                  }
              });
          });
      </script>

  </head>
   <body>
   <div>
       <h1>Title : ${title}</h1>
       <h3> <a href="/login">login  </a>
           <a href="/registration"> registration</a> </h3>
       <sec:authorize access="hasRole('ROLE_USER')">
           <!-- For login user -->
           <c:url value="/j_spring_security_logout" var="logoutUrl" />
           <form action="${logoutUrl}" method="post" id="logoutForm">
               <input type="hidden" name="${_csrf.parameterName}"
                      value="${_csrf.token}" />
           </form>
           <script>
               function formSubmit() {
                   document.getElementById("logoutForm").submit();
               }
           </script>

           <c:if test="${pageContext.request.userPrincipal.name != null}">
               <h2>
                   User : ${pageContext.request.userPrincipal.name} | <a
                       href="javascript:formSubmit()"> Logout</a>
               </h2>
           </c:if>


       </sec:authorize>
       <a href="/newGame"><h2>New game</h2></a>
   </div>
<div id="test">
    ${gameFieldd}


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
