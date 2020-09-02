<jsp:include page="header.jsp"/>

<header>
    <div class="container">
      
  <c:choose>
  <c:when test="${not empty message }">
    <p class="alert ${messageClass}">${message }</p>
  <%
    session.setAttribute("message", null);
    session.setAttribute("messageClass", null);
  %>
  </c:when>
  </c:choose>


  <div id="search">
    <form action="/Project1/search" method="GET">
    
        <fieldset id="search-fieldset">
            <legend>Please enter your local path to your log folder and the keyword to search for</legend>
            <label for="file-path">Log Folder Path:</label>
            <input type="text" name="filePath" id="file-path">
            <label for="key-word">Keyword:</label>
            <input type="text" name="keyword" id="key-word"> </br>
            <input type = "submit" value = "Submit" onClick="return empty()" />
    
            <p>Recommended keywords: exception, error</p>
        </fieldset>
    
    </form>
    </div>
    <p>Your results:</p>
    ${list}
    <div>

    </div>

    
<jsp:include page="footer.jsp"/>