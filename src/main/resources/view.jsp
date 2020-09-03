<jsp:include page="header.jsp"/>

<div id="view">
    <form action="/Project1/view" method="GET">
        <fieldset id="viewer fieldset">
            <legend>Please enter the log folder path</legend>
            <label for="file-path">Log Folder Path:</label>
            <input type="text" name="filePath" id="file-path">
            <input type = "submit" value = "Submit" onClick="return empty2()" />
        </fieldset>
    </form>
</div>

<div>
    ${path}
    ${list}
</div>

<jsp:include page="footer.jsp"/>