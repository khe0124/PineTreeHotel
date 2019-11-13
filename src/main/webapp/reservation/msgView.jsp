<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp"%>

<div class="hero-wrap" style="background-image: url('images/bg_1.jpg');">
	<div class="overlay"></div>
	<div class="container">
		<div
			class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
			<div
				class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
				<div class="text">
					<p class="breadcrumbs mb-2">
						<span class="mr-2"><a href="index.html">Home</a></span> <span>About</span>
					</p>
					<h1 class="mb-4 bread">Pinetree Hotel</h1>
				</div>
			</div>
		</div>
	</div>
</div>
<section class="ftco-section bg-light" style="text-align: center;">
	<div class="container">
		<div class="col-12">
			<div class='content'>
				<dl>
					<dd>${msg1 != null ? img : ""}${msg1}</dd>
					<dd>${msg2 != null ? img : ""}${msg2}</dd>
					<dd>${msg3 != null ? img : ""}${msg3}</dd>
				</dl>
				<p>${link1} ${link2} ${link3}</p>
			</div>
		</div>
	</div>
</section>


<%@ include file="../main/footer.jsp"%>