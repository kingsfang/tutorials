<html xmlns="http://www.w3.org/1999/html">

<head>
    <title> param 4 page </title>
    <script src="jquery-1.4.min.js" type="text/javascript"></script>
</head>

<body>

<script>

    $.ajax({
        type: 'POST',
        url: '/param5',
        data: '{ "name": "kevin", "age": 88 }',
        contentType: "application/json"
    });

</script>

</body>


</html>