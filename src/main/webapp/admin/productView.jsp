<%@page import="controller.admin.stockadd"%>
<%@page import="controller.admin.getstock"%>
<%@page import="dto.Stock"%>
<%@page import="dto.Category"%>
<%@page import="dao.ProductDao"%>
<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	ArrayList<Product> pList =ProductDao.getProductDao().getProductList();
	ArrayList<Category> cList=ProductDao.getProductDao().getCategoryList();
%>
	<div>
		<table id="producttable" class="table table-hover">
			<tr>
				<th width="5%">제품번호</th>
				<th width="5%">제품이미지</th>
				<th width="5%">제품명</th>
				<th width="5%">가격</th>
				<th width="5%">할인율</th>
				<th width="5%">판매금액</th>
				<th width="5%">제품상태</th>
				<th width="5%">카테고리</th>
				<th width="5%">사이즈</th>
				<th width="5%">색상</th>
				<th width="5%">재고수량</th>
				<th width="5%">수정일</th>
				<th width="5%">비고(삭제,재고채우기)</th>
			</tr>
			<%for(Product p : pList){
				float price=p.getPprice()*(1-p.getPdiscount());
				%>
				<tr>
					<td id="th<%=p.getPno()%>"><%=p.getPno()%></td>
					<td><img src="/jsvweb/admin/productimg/<%=p.getPimg()%>"></td>
					<td><%=p.getPname()%></td>
					<td><%=p.getPprice()%></td>
					<td><%=p.getPdiscount()*100%>%</td>
					<td><%=price%>원</td>
					<td><%=p.getPactive()%></td>
					<td><%=cList.get(p.getCno()-1).getCname()%></td>
					<th><select id="colorbox<%=p.getPno()%>" onchange="getamount(<%=p.getPno()%>">
						<%ArrayList<Stock> sList=ProductDao.getProductDao().getStock(p.getPno());
						for(Stock s:sList){
						%>
						<option><%=s.getScolor()%></option>
						<%}%>
					</select></th>
					<th><select>
					<%for(Stock s:sList){
						%>
						<option><%=s.getSsize()%></option>
						<%}%>
					</select></th>
					<th>
					<%if(!sList.isEmpty()){ %>
					<%if(sList.get(0).getSamount()==0){ %>
					<span id='amount<%=p.getPno()%>'>해당 사이즈색상에 재고없음</span>
					<%}else{ %>
					<span id='amount<%=p.getPno()%>'><%=sList.get(0).getSamount()%></span>
					<%} }else{%>
						<span>재고 없음</span><%
					}%>
					</th>
					<td><% if( !sList.isEmpty() ){ // 재고리스트가 비어 있지 않으면 %>
						<% if(sList.get(0).getSamount() == 0 ){ // 재고리스트의 첫번쨰 재고정보가 0이면 %>
							<span id="datebox<%=p.getPno()%>"> - </span> 
						<% }else{ %>
							<span id="datebox<%=p.getPno()%>"> <%=sList.get(0).getUpdatedate() %> </span> 
					<% }%>
					<%}else{ // 재고리스트가 비어 있으면 %>
							<span id="datebox<%=p.getPno()%>"> - </span> 
					<%} %></td>
					<td></td>
					<td>
					<button>제품 삭제</button>
					<button>제품 수정</button>
					<button onclick="pnomove(<%=p.getPno()%>)" data-bs-toggle="modal" data-bs-target="#activemodal">상태 변경</button>
					<button onclick="getstock(<%=p.getPno()%>)" data-bs-toggle="modal" data-bs-target="#stockmodal">재고 변경</button>
					</td>
				</tr>
			<%} %>
		</table>
		<!-- 상태변경 부트스트랩 모달 -->
		<div class="modal" tabindex="-1" id="activemodal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">제품 상태 변경</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		      	<table id="stocklistbox">
		      	
		      	</table>
		        <p>변경할 상태를 선택해주세요</p>
		        <input type="hidden" id="modalinput">
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" onclick="activechange(0)">준비</button>
		        <button type="button" class="btn btn-primary" onclick="activechange(1)">판매</button>
		        <button type="button" class="btn btn-primary" onclick="activechange(2)">품절</button>
		        <button type="button" class="btn btn-primary" onclick="activechange(3)">중단</button>
		        <button id="modalclosebtn" type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
		      </div>
		    </div>
		  </div>
		</div>
		<!-- 재고변경 모달 구역 -->
		<div class="modal" tabindex="-1" id="stockmodal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">제품 재고 변경</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
			     <div class="modal-body">  <!-- 모달 내용  -->
		      	<table id="stocklistbox">
		      		
		      	</table>
		      	<div id="updatebox" style="display: none;">
		      		재고번호 : <input type="hidden" id="sno"> 
		      		재고수량 : <input type="text" id="samount">
		      	</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" onclick="stockupdate()">수정 처리</button>
		        <button id="modalclosebtn2" type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
	<script type="text/javascript" src="/jspweb/js/productlist.js"></script>
</body>
</html>