<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<div class="hero-wrap"
		style="background-image: url('../images/bg_1.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
				<div
					class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
					<div class="text">
						<p class="breadcrumbs mb-2">
							<span class="mr-2"><a href="index.do">Home</a></span> <span>About</span>
						</p>
						<h1 class="mb-4 bread">Account</h1>
					</div>
				</div>
			</div>
		</div>
	</div>


	<section class="ftco-section bg-light">
		<div class="container-fluid">
        	<h1 class="mt-4 text-center">회원상세정보</h1>
			<div class="row">
			<div class="col-md-12 mb-4">
            <!-- Nav tabs -->
			<ul class="nav nav-tabs">
			  <li class="nav-item">
			    <a class="nav-link active" data-toggle="tab" href="#acinfo">회원정보</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" data-toggle="tab" href="#myrv">예약내역</a>
			  </li>			  
			</ul>
			
			<!-- Tab panes -->
			<div class="tab-content">
			 <div class="tab-pane container my-5 active" id="acinfo">
			  	<div class="col-md-9">
			 <c:if test="${dto==null }">
				<p>회원정보가 없습니다.</p>
			</c:if>
			
			<c:if test="${dto!=null }">
				<table class="table">
					<tr>
						<th>회원아이디</th>
						<td>${dto.ac_id }</td>
					</tr>
					<tr>
						<th>한글이름</th>
						<td>${dto.ac_name_kor }</td>
					</tr>
					<tr>
						<th>영문이름</th>
						<td>${dto.ac_name_eng }</td>
					</tr>
					<tr>
						<th>연락처</th>
						<td>${dto.ac_phone }</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${dto.ac_email }</td>
					</tr>
					<tr>
						<th>멤버쉽등급</th>
						<c:choose>
			        		<c:when test="${dto.ac_grade eq '1' }">
			        			<td>Classic</td>
			        		</c:when>
			        		<c:when test="${dto.ac_grade eq '2' }">
			        			<td>Plus</td>
			        		</c:when>
			        		<c:when test="${dto.ac_grade eq '3' }">
			        			<td>Premium</td>
			        		</c:when>
			        	</c:choose>
					</tr>
					<tr>
						<th>누적숙박수</th>
						<td>${dto.ac_stay }</td>
					</tr>
					<tr>
						<th>가입일자</th>
						<td>${dto.ac_date }</td>
					</tr>
					<tr>
						<th>최종로그인</th>
						<td>${dto.ac_logindate }</td>
					</tr>
					<tr>
				  		<td colspan ="2">
					  		<input type="button" class="btn btn-primary" value="정보수정" onclick="location.href='memberupdate.do'">
					  		<input type="button" class="btn btn-danger" value="회원탈퇴" onclick="location.href='memberdelete.do'">
						</td>
					</tr>
				</table>
			</c:if>
			  </div>
			  </div>
			  <div class="tab-pane container my-5 fade" id="myrv">
			  	  	<div class="">
				 <c:if test="${olist==null }">
					<p>예약정보가 없습니다.</p>
				</c:if>
				<table class="table">
					<tr>
						<th>예약번호</th>
						<th>회원아이디</th>
						<th>예약날짜</th>
						<th>결제카드</th>
						<th>카드번호</th>
						<th>유효기간</th>
						<th>성명(한글)</th>
						<th>성명(영문)</th>
						<th>포인트</th>
						<th>전화번호</th>
						<th>총 결제금액</th>
					</tr>
				<c:forEach var="odto" items="${olist }">
					<tr>
						<td>
							${odto.od_no }
						</td>
						<td>
							${odto.ac_id }
						</td>
						<td>
							${odto.cart_date.substring(0,10) }
						</td>
						<td>
							${odto.od_card }
						</td>
						<td>	
							${odto.od_card_no }
						</td>
						<td>
							${odto.od_card_date }
						</td>
						<td>
							${odto.od_name_kor }
						</td>
						<td>
							${odto.od_name_eng }
						</td>
						<td>
							${odto.od_point }
						</td>
						<td>
							${odto.od_phone }
						</td>
						<td>
							${odto.od_total } 원
						</td>
					</tr>
				</c:forEach>
					<tr>
				  		<td colspan ="11">
					  		<input type="button" class="btn btn-primary" value="정보수정" onclick="location.href='memberupdate.do'">
					  		<input type="button" class="btn btn-danger" value="회원탈퇴" onclick="location.href='memberdelete.do'">
						</td>
					</tr>
				</table>
			  </div>
			  
			  </div>
			</div>
     	 </div>
    </div>
    <!-- /#page-content-wrapper -->
            
            
          </div>
    </section>
        
  <!-- /#wrapper -->
<%@ include file="../footer.jsp"%>