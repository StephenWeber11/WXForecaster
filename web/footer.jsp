<%-- 
    Document   : footer
    Created on : Apr 25, 2017, 7:02:53 PM
    Author     : Stephen
--%>
</div>
<div id="footer">
    <div class="grid-container">
        <div class="grid-100">
            <div id="footerBorder">
                <div class="grid-100">
                    <div class="grid-25">
                        <div id="footerNav">
                            <ul>
                                <li><a href="user?action=how">Forecasting 101</a></li>
                                <li><a href="forecast?action=view-forecasts">View Forecasts</a></li>
                                <c:if test="${sessionScope.theAdmin != null}">
                                    <li><a href="forecast?action=admin">Admin</a></li>  
                                </c:if>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
                <div class="grid-50">
                    <div id="copyright">
                        &copy; Stephen Weber 2017
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>                                
