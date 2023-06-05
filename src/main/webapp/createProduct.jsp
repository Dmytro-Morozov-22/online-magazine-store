<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Cabinet</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">

	<link rel="stylesheet" href="css/productCSS.css">
	
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="firstBlock">
		<h1>Add product!</h1>
	

	<div class="container-fluid">
		<div class="row">
			<form class="createProduct">
				<div class="form-group">
				<!-- 	<label for="productName">Product name:</label>  -->
					<input type="text" class="form-control productName" placeholder="Name of product">
				</div>

				<div class="form-group">
				<!-- 	<label for="productDescription">Product description:</label>  -->
					<input type="text" class="form-control productDescription" placeholder="Description of product">
				</div>

				<div class="form-group">
					<!-- <label for="productPrice">Product price:</label>  -->
					<input type="number" class="form-control productPrice" placeholder="Price of product">
				</div>


				<div class="col text-center">
  					<button class="btn btn-success createProduct styleButton">Submit</button>
				</div>


				
			</form>
		</div>
	</div>

</div>

<div style="height:100px"></div>

	<div style="width:100%; height:120px" ></div>


	<jsp:include page="footer.jsp"></jsp:include>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
		integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

	<script src="js/header.js"></script>
	<script src="js/serverCalls.js"></script>

</body>
</html>