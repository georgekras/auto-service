	<%@ page language="java" import="javax.servlet.jsp.PageContext" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="static/css/main.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
	<!-- icon in title -->
	<link rel="icon" href="static/images/logo_little.png" type="image/x-icon">
	
<title>Mercedes-Benz.yy</title>
</head>


<body>

<style>
#navbarSupportedContent {
	
	padding-left: 30px;
}

.carousel-control-prev-icon, .carousel-control-next-icon{
	height: 50px;
	width: 50px;
}


</style>




<div class="container-fluid p-0"">
	<div id="page-align" class="radius3">
		<jsp:include page="header.jsp"/> 
	</div>		
</div>	
	
	<div class="container-fluid p-0" >
		<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
			<ol class="carousel-indicators">
				<li class="active" data-target="#carouselExampleIndicators" 
				data-slide-to="0">
				</li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1">
				</li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2">
				</li>
				<li data-target="#carouselExampleIndicators" data-slide-to="3">
				</li>
			</ol>
			<div class="carousel-inner">
			
				<div class="carousel-item active">
					<img src="static/images/img_01.png" alt="" class="d-block w-100">
				</div>
				<div class="carousel-item">
					<img src="static/images/img_02.png" alt="" class="d-block w-100">
				</div>
				<div class="carousel-item">
					<img src="static/images/img_03.png" alt="" class="d-block w-100">
				</div>
				<div class="carousel-item">
					<img src="static/images/img_04.png" alt="" class="d-block w-100">
				</div>
			</div>
			
			<a href="#carouselExampleIndicators" class="carousel-control-prev" 
			role="button" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a href="#carouselExampleIndicators" class="carousel-control-next" 
				role="button" data-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>				
			
		</div>
	</div>
	
	<div class="container-fluid">
			<div class="container">
				<div class="row text-end">
				<div class="col"><img src="static/images/a-klasse.png" alt="" class="w-100"><h5>A-Klasse<h5></div>
				<div class="col"><img src="static/images/b-klasse.png" alt="" class="w-100"><h5>B-Klasse<h5></div>
				<div class="col"><img src="static/images/c-klasse.png" alt="" class="w-100"><h5>C-Klasse<h5></div>
				<div class="col"><img src="static/images/e-klasse.png" alt="" class="w-100"><h5>E-Klasse<h5></div>
				<div class="col"><img src="static/images/g-klasse.png" alt="" class="w-100"><h5>G-Klasse<h5></div>
				<div class="col"><img src="static/images/gl-klasse.png" alt="" class="w-100"><h5>GL-Klasse<h5></div>
				<div class="col"><img src="static/images/s-klasse.png" alt="" class="w-100"><h5>S-Klasse<h5></div>
				<div class="col"><img src="static/images/gt-klasse.png" alt="" class="w-100"><h5> AMG GT<h5></div>
			</div>
		</div>
</div>


<c:if test="${not empty sessionScope.admin}">


<div>	
	<jsp:include page="footer.jsp"/> 
	
</div>	
	
</body>
</html>