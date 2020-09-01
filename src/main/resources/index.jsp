<jsp:include page="header.jsp"/>

<h2>Logger Manager by Will Hibbard</h2>

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

<div id="view">
	<form action="/Project1/view" method="GET">
		<label for="file-path">Log Folder Path:</label>
		<input type="text" name="filePath" id="file-path">
		<input type = "submit" value = "Submit" onClick="return empty()" />
</div>


<!--<script type="application/javascript" src="index.js" ></script> -->
<jsp:include page="footer.jsp"/>