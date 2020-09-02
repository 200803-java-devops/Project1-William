<!DOCTYPE html>
<html>
<head><title>Log Manager</title>

    <style>
        .navbar {
            font-weight:bold;
            text-align:center;
            border:1px;
            color:white;
            background-color:navy;
            padding:6px;
        }
        a {
            color:white;
        }
        .project1 {
            font-size:30px;
            color:darkolivegreen;
            font-weight:bold;
            text-align:center;
        }
    </style>

    <!--the script to ensure no blank inputs-->
	<script type="text/javascript">
		function empty()
		{
			var x;
			var y;
			x = document.getElementById("file-path").value;
			y = document.getElementById("key-word").value;
			if (x == "" || y == "")
			{
				alert("Please ensure you do not leave the input boxes blank!");
				return false;
			};
        }
        
        function empty2()
		{
			var x;
			x = document.getElementById("file-path").value;
			if (x == "")
			{
				alert("Please ensure you do not leave the input boxes blank!");
				return false;
			};
        }
        
        function empty3()
		{
            if (window.confirm("Are you sure you want to submit this log file to the developers?"))
            {
                var x;
                x = window.prompt("Please add comments about this log file submission.");
                document.getElementById('comments').value = x;
                console.log("x= " + x);
            } else {
                return false;
            }
        }


    </script>
    
</head>
<body>
    <div class = "project1">Log Manager by Will Hibbard</div>
    <nav class="navbar">
        <div class="container">          
                        <a href="index.jsp" class="functions">Home</a> |
                        <a href="search.jsp" class="functions">Keyword Search</a> |
                        <a href="view.jsp" class="functions">View all logs</a>

            </div>
        </div>
    </nav>
