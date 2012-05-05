<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="cn.jhc.ch06.TitlesBean3"%>
<%@page import="cn.jhc.ch03.BookBean"%>
<%@page import="java.util.*"%>
<html>
<head>
<title>ebooks</title>
<meta http-equiv=Content-Type content="text/html; charset=UTF-8">
<link href="/books/images/main.css" type=text/css rel=stylesheet>
</head>
<body>
<center>
<table cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff
	background=/books/images/top1bg.jpg border=0>
	<tbody>
		<tr>
			<td width=778>&nbsp;</td>
		</tr>
	</tbody>
</table>
<table class=center height=100 cellSpacing=0 cellPadding=0 width=778
	bgColor=#ffffff border=0>
	<tbody>
		<tr>
			<td align=middle width=150><img title="" height=100
				src="/books/images/logo.jpg" width=100 border=0></td>
			<td width=58>&nbsp;</td>
			<td vAlign=top width=110><img height=90 src="/books/images/top1.jpg"
				width=70 border=0></td>
			<td vAlign=top width=110><img height=90 src="/books/images/top2.jpg"
				width=70 border=0></td>
			<td vAlign=top width=110><img height=90 src="/books/images/top3.jpg"
				width=70 border=0></td>
			<td vAlign=top width=110><img height=90 src="/books/images/top4.jpg"
				width=70 border=0></td>
			<td width=130></td>
		</tr>
	</tbody>
</table>

<table class=center cellSpacing=0 cellPadding=0 width=778
	bgColor=#ffffff border=0>
	<tbody>
	<tr>
		<td style="FONT-SIZE: 1px" bgColor=#b0b0b0 colSpan=19 height=1></td>
		</tr>
	</tbody>
</table>
<table cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff border=0>
	<tbody>
		<tr>
			<td style="FONT-SIZE: 1px" bgColor=#dcdcdc height=3></td>
		</tr>
		<tr>
			<td align=right background=/books/images/bn01.gif height=120>&nbsp;</td>
		</tr>
	</tbody>
</table>

<table height=15 cellSpacing=0 cellPadding=0 width=778 border=0>
	<tbody>
		<tr>
			<td style="FONT-SIZE: 10px; LINE-HEIGHT: 10px"
				background=/books/images/bnbg1.gif height=15></td>
		</tr>
	</tbody>
</table>
<table cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff border=0>
	<tbody>
		<tr>
			<td vAlign=top width=168 height=400>
			<table class=center height="100%" cellSpacing=0 cellPadding=0
				width=168 bgColor=#ffffff background=/books/images/leftbg.gif border=0>
				<tbody>

					<tr>
						<td class=lefttd vAlign=top align=middle><br>
						</td>
					</tr>
				</tbody>
			</table>
			</td>
			<td vAlign=top align=middle width=610>
			<table cellSpacing=0 cellPadding=0 width="98%"
				background=/books/images/top01.gif border=0>
				<tbody>
					<tr>
						<td align=left height=25><img height=11
							src="/books/images/icon1.gif" width=31> 图书列表</td>
					</tr>
				</tbody>
			</table>
			<br>
			<table style="TEXT-ALIGN: center" cellSpacing=0 cellPadding=0
				width=590 border=0>
				<tbody>
				<!--   显示内容开始  -->
<%

	  TitlesBean3 titlesBean = new TitlesBean3();
      List titles = titlesBean.getTitles();
      BookBean currentBook;

      // store titles in session for further use
      session.setAttribute( "titles", titles );
      for(int i=0;i<titles.size();i++){
        currentBook = ( BookBean ) titles.get(i);
      if(i%3==0){
      	%>
      	
      	<tr>
      	<%
      	}
      %>
      <td>
						<table cellSpacing=0 cellPadding=0 width=180
							background=/books/images/bg.jpg border=0>
							<tbody>
								<tr>
									<td vAlign=bottom height=30>&nbsp;&nbsp; <a href = 
               "displayBook.jsp?isbn=<%= currentBook.getISBN() %>">&nbsp;&nbsp;&nbsp;&nbsp; <%= subStr(currentBook.getTitle() + ", " +
                   currentBook.getEditionNumber() + "e") %></a></td>
								</tr>
								<tr align=middle>
									<td height=120><a href="displayBook.jsp?isbn=<%= currentBook.getISBN() %>"><img
										height=110 src="/books/images/<%=currentBook.getImageFile() %>" width=90
										border=0></a></td>
								</tr>
							</tbody>
						</table>
						<br>
						</td>
      
      <%
      	if(i%3==2){
      	%>
      	
      	</tr>
      	<%
      	}
      }
  %>


					<!--   显示内容结束  -->
				</tbody>
			</table>
			<br>
			</td>
		</tr>
	</tbody>
</table>
<table class=center cellSpacing=0 cellPadding=0 width=778
	bgColor=#ffffff border=0>
	<tbody>
		<tr>
			<td align=middle background=/books/images/bk.gif height=50></td>
		</tr>
	</tbody>
</table>

</center>
</body>
</html>
<%!

	public String subStr(String str){
		if(str==null || "".equals(str))
			return "";
		if(str.length()>20)
			return str.substring(0,20)+"...";
		else
			return str;
	}
 %>

