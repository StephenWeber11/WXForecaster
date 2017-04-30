<%-- 
    Document   : forecasting101
    Created on : Apr 25, 2017, 7:38:27 PM
    Author     : Stephen
--%>

<%@include file="/header.jsp" %>
<div class="grid-container">
    <div class="grid-100" id="forecast101">
        <div class="grid-25" id="forecastSideBar">
            <h3 class="center">Weather data resources</h3>
            <br/>
            <ul>
                <li><a href="http://www.twisterdata.com/">Twister Data</a></li>
                <li><a href="http://www.aos.wisc.edu/weather/wx_obs/Satellite.html">University of Wisconsin Satellite</a></li>
                <li><a href="http://www.wxforecaster.com/">WxForecaster Models</a></li>
                <li><a href="http://weather.rap.ucar.edu/surface/">US Surface Observations</a></li>
                <li><a href="https://www.wunderground.com/wundermap">WunderMap</a></li>
                <li><a href="http://www.spc.noaa.gov/">NOAA Storm Prediction Center(SPC)</a></li>
                <li><a href="http://mp1.met.psu.edu/~fxg1/ewall.html">Penn State E-Wall (Advanced)</a></li>
            </ul>
            <br/>
            <iframe src="https://www.youtube.com/embed/9Kk3uVFjzcg" frameborder="0" allowfullscreen></iframe>
            <br/><br/>
            <iframe src="https://www.youtube.com/embed/bd7DcVnrSL8" frameborder="0" allowfullscreen></iframe>
        </div>
        <div class="grid-75">
            <h3 class="center">Forecasting Tips Courtesy of Meteorologist Jeff Haby</h3>
            <h4>How to read & understand MOS data</h4>
            <br/>
            <p><strong>MOS</strong> stands for <strong>Model Output Statistics</strong>. They are an integral part of putting together a specific temperature forecast and precipitation forecast. 
                In fact, just about every forecaster will use MOS to help with their forecast. Forecasters that do not use MOS are at a huge disadvantage to those that do. 
                If you are using the NWS forecast, that forecast is likely being made from a forecaster developing a specific forecast by using MOS and their forecast intellect. 
                What I do is treat the NWS forecast as another model. I will write down the forecast from each model MOS and the NWS. 
                Then I will develop my own conclusion from looking at weather data and models and integrate that with the guidance from the models and the weather service.</p>
            <br/>
            <br/>
            <p>Examine the MOS each day for your forecast location. Compare how well each models MOS verifies for the particular weather situation each day. 
                Use the MOS as a guide to your forecast process. Once you understand MOS and you go through the rest of the forecast trick essays then you will 
                get knowledge of how you can outforecast MOS. 
            </p>
            <br/>
            <br/>
            <h4>Forecasting Surface Temperature</h4>
            <h5>Low Temperatures</h5>
            <p>Suppose the MOS for the primary forecast models have lows of 23 F, 25 F and 27 F. This gives a model consensus of (23+25+27)/3 = 25 F. If there is Cold Air Advection occurring aloft 
                such as winds blowing in colder air from the northwest, the actual low will tend to be colder than what MOS consensus indicates. The models may not pick up on cold air mixing down to 
                the surface. This forecast trick works best when the surface wind speed and direction continues to advect colder air in at night and there is even more significant Cold Air Advection 
                moving in aloft at 850 mb. In other words, Cold Air Advection is increasing with height.</p>
            <br/>
            <p>Suppose the MOS for the primary forecast models have lows of 37 F, 39 F and 40 F. If there is Warm Air Advection occurring aloft such as winds blowing in warmer air from the south, the
                actual low will tend to be warmer than what MOS consensus indicates. The models may not pick up on warm air mixing down to the surface. This forecast trick works best when the surface 
                wind speed and direction continues to advect warmer air in at night and there is even more significant Warm Air Advection moving in aloft at 850 mb. In other words, Warm Air Advection 
                increasing with height.</p>
            <h5>High Temperatures</h5>
            <p>Suppose the MOS for the primary forecast models have highs of 70 F, 69 F and 71 F. If there is Cold Air Advection occurring aloft such as winds blowing in colder air from the northwest, 
                the actual high will tend to be colder than what MOS consensus indicates. The models may not pick up on cold air mixing down to the surface. Study the models for Cold Air Advection increasing 
                with height during the day.</p>
            <br/>
            <p>Suppose the MOS for the primary forecast models have highs of 78 F, 75 F and 80 F. If there is Warm Air Advection occurring aloft such as winds blowing in warmer air from the south, the actual high 
                will tend to be warmer than what MOS consensus indicates. The models may not pick up on warm air mixing down to the surface. Study the models for Warm Air Advection increasing with height during the 
                day.</p>
            <br/>
            <br/>
            <h4>Understanding POP and QPF</h4>
            <p>The models will often throw in some low POP (Probability of Precipitation) especially when there are clouds in the model forecast. When precipitation is very unlikely but clouds are likely you will often 
                see 6 and 12 hour POPs in the single digits or teens. The advice is to not fret over these numbers. When the POP is less than 30% it is very unlikely it will precipitate. After looking over other data you 
                may conclude to not even put any chance of precipitation in the forecast at all. If you notice the QPF (Quantitative Precipitation Forecast) is 0 and there is a POP value given such as 12% according to the model, 
                then that is a clue the precipitation threat is very minimal. This is especially true if there is no instability and thus no chance for isolated afternoon thunderstorms.</p>
            <br/>
            <p>If there is instability then you may want to include a chance for isolated thunderstorms when the POP and QPF are low (but not too low on POP). The models do not predict isolated thunderstorm convection very well. 
                The model will spread the rain over the forecast area and decrease the QPF amounts since the model has no way of knowing exactly where the thunderstorms will develop. In reality, most of the forecast area will end
                up with 0 QPF while isolated areas can get quite a bit of rainfall if the thunderstorms develop.</p>
            <br/>
            <p>Model forecasted QPFs of 0 (no precip), 1 (less than 10th inch) and the low end of 2 (10th to a quarter inch) are not very significant amounts. When these type QPF numbers occur with a POP of less than 40% it is very 
                unlikely it will rain. However, you must look at all data available to make certain (all models and all weather data). Rules of thumb can always bust and the model may not be picking up on the precipitation event as 
                well as it should. Again, if there is instability then that is a clue it could be an isolated or scattered thunderstorm situation.</p>
            <br/>
            <p>When both the POP gets over 40% and the QPF is 3 or higher on several models, then a significant precipitation event is looking much more favorable. </p>
            
            <br/>
            <p class="referenceRight">&copy; Meteorologist Jeff Haby @ <a href="http://theweatherprediction.com">The Weather Prediction</a></p>
        </div>
    </div>
</div>

<%@include file="/footer.jsp" %>
