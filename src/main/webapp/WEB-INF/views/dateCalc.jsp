<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 08.08.17
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style/general.css" />"> -->
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style/main.css"/>">
</head>

<jsp:include page="header.jsp"/>

<body>
<div class="fixed">
    <h1>Calculate Number Of Days Off Between Two Dates</h1>
    <form name="f" id="f" class="large bg-r pn" method="post" action="/dayOff">
        <div class="form-row">
            <!-- First date: -->
            <div class="five columns">
                <h2>Start Date</h2>
                <div class="date-select">
                    <div class="left"><label for="d1">Day:</label><input placeholder="dd" type="text"
                                                                         maxlength="2" size="3" id="d1"
                                                                         name="startDateDay">
                        <span class="fld-aid">&nbsp;.&nbsp;</span>
                    </div>
                    <div class="left"><label for="m1">Month:</label><input placeholder="mm" type="text"
                                                                           maxlength="2" size="3"
                                                                           id="m1" name="startDateMonth">
                        <span class="fld-aid">&nbsp;.&nbsp;</span>
                    </div>
                    <div class="left"><label for="y1">Year:</label><input placeholder="yyyy" type="text"
                                                                          maxlength="4" size="5" id="y1"
                                                                          name="startDateYear">
                    </div>
                </div>
            </div>
            <div class="two columns"></div>

            <!-- Second date: -->
            <div class="five columns">
                <h2>End Date</h2>
                <div class="date-select">
                    <div class="left"><label for="d2">Day:</label><input placeholder="dd" type="text"
                                                                         maxlength="2" size="3" id="d2"
                                                                         name="endDateDay">
                        <span class="fld-aid">&nbsp;.&nbsp;</span>
                    </div>
                    <div class="left"><label for="m2">Month:</label><input placeholder="mm" type="text"
                                                                           maxlength="2" size="3"
                                                                           id="m2" name="endDateMonth">
                        <span class="fld-aid">&nbsp;.&nbsp;</span>
                    </div>
                    <div class="left"><label for="y2">Year:</label><input placeholder="yyyy" type="text"
                                                                          maxlength="4" size="5" id="y2"
                                                                          name="endDateYear">
                    </div>
                </div>
            </div>
        </div>

        <div class="form-row">
            <div class="twelve columns"><label
                    type="checkbox" name="ti" id="ti" value="on" checked="">Include end date in calculation (1 day is
                added)</label>
            </div>
        </div>
        <div class="form_footer"><input type="submit" id="subbut2" value="Calculate"></div>
    </form>

    <!-- вторник 8 август 2017 г. -->

    <c:if test="${result != null}">
        <div class="bx-result">
            <div class="row">
                <div class="eight columns"><p>From and including:
                    <strong>${startDate.dayOfWeek} ${startDate.dayOfMonth} ${startDate.month} ${startDate.year} </strong><br>To,
                    but <strong>not</strong> including
                    <strong>${endDate.dayOfWeek} ${endDate.dayOfMonth} ${endDate.month} ${endDate.year} </strong></p>
                    <h2>Result: <c:out value="${result}"/> days</h2>
                </div>
            </div>
        </div>
    </c:if>
</div>
</body>
</html>