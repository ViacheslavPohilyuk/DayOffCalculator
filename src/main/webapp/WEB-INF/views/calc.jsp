<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 11.08.17
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style/calc.css"/>">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style/errors.css"/>">
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="fixed">
    <h1>Calculate Number Of Days Off Between Two Dates</h1>

    <sf:form class="large bg-r pn" action="/calc" method="POST" commandName="dateForm">

        <!-- <form name="f" id="f" class="large bg-r pn" method="post" action="/calc"> -->
        <div class="form-row">
            <!-- First date: -->
            <div class="five columns"><h2>Start Date</h2>
                <div class="date-select">
                    <div class="left"><label for="startDateDay">Day:</label>
                        <!--<input placeholder="dd" type="text"
                                                                         maxlength="2" size="3" id="d1"
                                                                         name="startDateDay"> -->
                        <sf:input path="startDateDay" placeholder="dd" maxlength="2" size="3"
                                  cssErrorClass="error"/>
                        <span class="fld-aid">&nbsp;.&nbsp;</span>
                    </div>
                    <div class="left"><label for="startDateMonth">Month:</label>
                        <!--<input tad-va="date" placeholder="mm" type="text"
                                                                           maxlength="2" size="3"
                                                                           id="m1" name="startDateMonth"> -->
                        <sf:input path="startDateMonth" placeholder="mm" maxlength="2" size="3"
                                  cssErrorClass="error"/>
                        <span class="fld-aid">&nbsp;.&nbsp;</span>
                    </div>
                    <div class="left"><label for="startDateYear">Year:</label>
                        <!--<input placeholder="yyyy" type="text"
                                                                          maxlength="4" size="5" id="y1"
                                                                          name="startDateYear"> -->
                        <sf:input path="startDateYear" placeholder="yyyy" maxlength="4" size="3"
                                  cssErrorClass="error"/>
                    </div>
                </div>
            </div>
            <div class="two columns"></div>

            <!-- Second date: -->
            <div class="five columns"><h2>End Date</h2>
                <div class="date-select">
                    <div class="left"><label for="endDateDay">Day:</label>
                        <!--<input placeholder="dd" type="text"
                                                                         maxlength="2" size="3" id="d2"
                                                                         name="endDateDay"> -->
                        <sf:input path="endDateDay" placeholder="dd" maxlength="2" size="3"
                                  cssErrorClass="error"/>
                        <span class="fld-aid">&nbsp;.&nbsp;</span>
                    </div>
                    <div class="left"><label for="endDateMonth">Month:</label>
                        <!-- <input placeholder="mm" type="text"
                                                                           maxlength="2" size="3"
                                                                           id="m2" name="endDateMonth"> -->
                        <sf:input path="endDateMonth" placeholder="mm" maxlength="2" size="3"
                                  cssErrorClass="error"/>
                        <span class="fld-aid">&nbsp;.&nbsp;</span>
                    </div>
                    <div class="left"><label for="endDateYear">Year:</label>
                        <sf:input path="endDateYear" placeholder="yyyy" maxlength="4" size="3"
                                  cssErrorClass="error"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="form-row">
            <div class="twelve columns"><label
                    title="To calculate the duration of something, e.g. a week from Monday to Friday (5 days) - check this box. To calculate an age, uncheck this box. "><input
                    type="checkbox" name="endDayIncluded" id="ti" value="on" checked="">Include end date in calculation
                (1 day is
                added)</label>
            </div>
        </div>
        <div class="form_footer"><input type="submit" id="subbut2" value="Calculate Duration"></div>

        <div class="errors">
            <sf:errors path="*" element="div" cssClass="form-validation-errors"/>

            <div>
                <c:if test="${dateInvalidError != null}">
                    <span>You put incorrect date (For example July can't have 32-th day)</span>
                </c:if>
            </div>
        </div>
    </sf:form>

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
<style>
    div.logo-with-name img {
        top: 22px;
        position: relative;
    }

    .name {
        bottom: 9px;
    }

    .refs {
        bottom: 42px;
    }

    /* .errors {
        bottom: 0px;
        left: 8%;
    } */
</style>
</html>
