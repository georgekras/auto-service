<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>sales page</title>
</head>

<body>
	<style>
.sidebar {
	margin-left: 50px;
	width: 350px;
	float: left;
	border-radius: 5px;
	border: 3px solid #343a40;
	padding: 15px;
}

.content {
	margin-left: 480px;
	width: 655px;
}

.footer {
	clear: left;
}

.model {
	width: 60%;
	floar: left;
}

.left-check {
	padding: 5px;
	float: left;
	min-width: 20%;
}

.right-check {
	padding: 5px;
	min-width: 20%;
}

.carcase {
	padding: 5px;
	width: 42%;
	float: left;
}

.year {
	padding: 5px;
	width: 40%;
	clear: left;
}

.footer {
	clear: left;
}
</style>


	<jsp:include page="header.jsp" />

	<div class="common">
		<div class="sidebar">
			<div class="model">
				<legend>Choose model</legend>
				<div class="left-check">

					<div>
						<input type="checkbox" id="aklasse" name="model" value="aklasse" />
						<label for="aklasse">A-Klasse</label>
					</div>
					<div>
						<input type="checkbox" id="bklasse" name="model" value="bklasse" />
						<label for="bklasse">B-Klasse</label>
					</div>
					<div>
						<input type="checkbox" id="cklasse" name="model" value="cklasse" />
						<label for="cklasse">C-Klasse</label>
					</div>
					<div>
						<input type="checkbox" id="eklasse" name="model" value="eklasse" />
						<label for="eklasse">E-Klasse</label>
					</div>
				</div>

				<div class="right-check">
					<div>
						<input type="checkbox" id="gklasse" name="model" value="gklasse" />
						<label for="gklasse">G-Klasse</label>
					</div>
					<div>
						<input type="checkbox" id="glklasse" name="model" value="glklasse" />
						<label for="glklasse">GL-Klasse</label>
					</div>
					<div>
						<input type="checkbox" id="sklasse" name="model" value="sklasse" />
						<label for="sklasse">S-Klasse</label>
					</div>
					<div>
						<input type="checkbox" id="amg" name="model" value="amg" /> <label
							for="amg">AMG</label>
					</div>
				</div>

			</div>

			<div class="carcase">
				<legend>Choose carcase</legend>
				<div>
					<input type="checkbox" id="sedan" name="carcase" value="sedan" />
					<label for="sedan">sedan</label>
				</div>
				<div>
					<input type="checkbox" id="coupe" name="carcase" value="coupe" />
					<label for="coupe">coupe</label>
				</div>
				<div>
					<input type="checkbox" id="wagon" name="carcase" value="wagon" />
					<label for="wagon">wagon</label>
				</div>
			</div>

			<div class="year">
				<legend>Year of issue</legend>
				<select id="year" name="year">
					<option value="">choose a year</option>
					<option value="2018">2018</option>
					<option value="2017">2017</option>
					<option value="2016">2016</option>
					<option value="2015">2015</option>
					<option value="2014">2014</option>
					<option value="2013">2013</option>
					<option value="2012">2012</option>
					<option value="2011">2011</option>
					<option value="2010">2010</option>
					<option value="2009">2009</option>
					<option value="2008">2008</option>
					<option value="2007">2007</option>
				</select>
			</div>

			<div class="fuel">
				<legend>Type of fuel</legend>
				<div>
					<input type="checkbox" id="fuel" name="fuel" value="diesel" /> <label
						for="diesel">diesel</label>
				</div>
				<div>
					<input type="checkbox" id="fuel" name="fuel" value="petrol" /> <label
						for="petrol">petrol</label>
				</div>
				<div>
					<input type="checkbox" id="fuel" name="fuel" value="electric" /> <label
						for="electric">electric</label>
				</div>
			</div>
			<form action="Controller" method="post">
				<input type="hidden" name="command" value="filtrate" /> <input
					class="btn btn-outline-secondary" type="submit" name="filtrate"
					value="filtrate" />
			</form>
		</div>
		<div class="content">
			<div class=content-cars>
				<c:if test="${not empty sessionScope.cars}">
				<c:forEach items="${cars}" var="car">
							 	<p><option value="${car.key}">${car.value}</option></p>
						</c:forEach>
				</c:if>
			</div>

			<form>
				<input type="hidden" name="command" value="to_add_vehicle_page" /><input
					class="btn btn-outline-secondary" type="submit" value="add" />
			</form>
		</div>

	</div>




	<div class="footer">
		<jsp:include page="footer.jsp" />
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>

</body>
</html>