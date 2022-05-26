package com.mangkyu.currency.exchanger.app.exchange.adapter.currencyapis;

import com.google.gson.Gson;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeErrorCode;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static com.mangkyu.currency.exchanger.app.exchange.testbase.ExchangeTestBase.sourceCurrency;
import static com.mangkyu.currency.exchanger.app.exchange.testbase.ExchangeTestBase.targetCurrency;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class RestCurrentExchangeRateCallerTest {

    private CurrentExchangeRateCaller target;

    private RestTemplate restTemplate;

    @BeforeEach
    void init() {
        this.restTemplate = mock(RestTemplate.class);
        target = new RestCurrentExchangeRateCaller(restTemplate, new Gson(), new CurrentExchangeRateProperties("https://www.naver.com", "mykey"));
    }

    @Test
    void API호출_실패응답() {
        doReturn(successFalseString())
                .when(restTemplate)
                .exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class));

        final ExchangeException result = assertThrows(ExchangeException.class, () -> target.call(sourceCurrency, targetCurrency));

        assertThat(result.getErrorCode()).isEqualTo(ExchangeErrorCode.FETCH_EXCHANGE_RATE_FAIL);
    }

    @Test
    void API호출_성공응답() {
        doReturn(successTrueString())
                .when(restTemplate)
                .exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class));

        final CurrentExchangeRateResponse result = target.call(sourceCurrency, targetCurrency);

        assertThat(result).isNotNull();
    }

    private ResponseEntity<String> successTrueString() {
        return ResponseEntity.ok("{ \"success\": true, \"timestamp\": 1653465724, \"source\": \"USD\", \"quotes\": { \"USDAED\": 3.67301, \"USDAFN\": 89.163896, \"USDALL\": 112.105344, \"USDAMD\": 455.156721, \"USDANG\": 1.799971, \"USDAOA\": 418.4096, \"USDARS\": 119.062267, \"USDAUD\": 1.409453, \"USDAWG\": 1.8, \"USDAZN\": 1.700902, \"USDBAM\": 1.823992, \"USDBBD\": 2.016516, \"USDBDT\": 87.83965, \"USDBGN\": 1.828945, \"USDBHD\": 0.376963, \"USDBIF\": 2052.850002, \"USDBMD\": 1, \"USDBND\": 1.372092, \"USDBOB\": 6.876376, \"USDBRL\": 4.819703, \"USDBSD\": 0.998699, \"USDBTC\": 3.3688823e-05, \"USDBTN\": 77.510795, \"USDBWP\": 12.011247, \"USDBYN\": 3.371321, \"USDBYR\": 19600, \"USDBZD\": 2.013177, \"USDCAD\": 1.283155, \"USDCDF\": 2004.999718, \"USDCHF\": 0.96146, \"USDCLF\": 0.030093, \"USDCLP\": 830.360262, \"USDCNY\": 6.668905, \"USDCOP\": 3978.05, \"USDCRC\": 672.128472, \"USDCUC\": 1, \"USDCUP\": 26.5, \"USDCVE\": 102.831324, \"USDCZK\": 23.025996, \"USDDJF\": 177.796222, \"USDDKK\": 6.96231, \"USDDOP\": 55.139677, \"USDDZD\": 145.37798, \"USDEGP\": 18.534506, \"USDERN\": 15.000001, \"USDETB\": 51.854201, \"USDEUR\": 0.93579, \"USDFJD\": 2.154295, \"USDFKP\": 0.818331, \"USDGBP\": 0.79708, \"USDGEL\": 2.859895, \"USDGGP\": 0.818331, \"USDGHS\": 7.765229, \"USDGIP\": 0.818331, \"USDGMD\": 53.950239, \"USDGNF\": 8821.389935, \"USDGTQ\": 7.663462, \"USDGYD\": 208.956616, \"USDHKD\": 7.84965, \"USDHNL\": 24.539889, \"USDHRK\": 7.048023, \"USDHTG\": 112.840692, \"USDHUF\": 359.279565, \"USDIDR\": 14614.3, \"USDILS\": 3.34905, \"USDIMP\": 0.818331, \"USDINR\": 77.51645, \"USDIQD\": 1457.68829, \"USDIRR\": 42350.000277, \"USDISK\": 129.990019, \"USDJEP\": 0.818331, \"USDJMD\": 154.618832, \"USDJOD\": 0.708998, \"USDJPY\": 127.114984, \"USDKES\": 116.603045, \"USDKGS\": 79.497165, \"USDKHR\": 4056.226398, \"USDKMF\": 458.303496, \"USDKPW\": 900.000222, \"USDKRW\": 1263.450176, \"USDKWD\": 0.30584, \"USDKYD\": 0.832245, \"USDKZT\": 416.22524, \"USDLAK\": 13246.81986, \"USDLBP\": 1510.333122, \"USDLKR\": 359.548532, \"USDLRD\": 152.249773, \"USDLSL\": 15.679499, \"USDLTL\": 2.95274, \"USDLVL\": 0.60489, \"USDLYD\": 4.770609, \"USDMAD\": 9.96167, \"USDMDL\": 19.076081, \"USDMGA\": 4035.372729, \"USDMKD\": 57.659015, \"USDMMK\": 1849.151773, \"USDMNT\": 3075.770799, \"USDMOP\": 8.07485, \"USDMRO\": 356.999828, \"USDMUR\": 43.252142, \"USDMVR\": 15.424974, \"USDMWK\": 815.604848, \"USDMXN\": 19.8759, \"USDMYR\": 4.392504, \"USDMZN\": 63.829426, \"USDNAD\": 15.680039, \"USDNGN\": 415.18022, \"USDNIO\": 35.784419, \"USDNOK\": 9.595565, \"USDNPR\": 124.01438, \"USDNZD\": 1.54194, \"USDOMR\": 0.384993, \"USDPAB\": 0.998713, \"USDPEN\": 3.711531, \"USDPGK\": 3.519834, \"USDPHP\": 52.339846, \"USDPKR\": 200.944796, \"USDPLN\": 4.29787, \"USDPYG\": 6847.835717, \"USDQAR\": 3.640995, \"USDRON\": 4.625024, \"USDRSD\": 109.955025, \"USDRUB\": 56.024982, \"USDRWF\": 1025.893061, \"USDSAR\": 3.751099, \"USDSBD\": 8.123525, \"USDSCR\": 13.136529, \"USDSDG\": 445.960177, \"USDSEK\": 9.833505, \"USDSGD\": 1.374445, \"USDSHP\": 1.377398, \"USDSLL\": 12814.999811, \"USDSOS\": 583.999894, \"USDSRD\": 21.101496, \"USDSTD\": 20697.981008, \"USDSVC\": 8.738389, \"USDSYP\": 2512.450518, \"USDSZL\": 15.654647, \"USDTHB\": 34.223011, \"USDTJS\": 12.494311, \"USDTMT\": 3.51, \"USDTND\": 3.031026, \"USDTOP\": 2.31195, \"USDTRY\": 16.299065, \"USDTTD\": 6.777521, \"USDTWD\": 29.511597, \"USDTZS\": 2326.000128, \"USDUAH\": 29.362722, \"USDUGX\": 3652.870519, \"USDUSD\": 1, \"USDUYU\": 40.159099, \"USDUZS\": 11061.038162, \"USDVEF\": 213830222338.07285, \"USDVND\": 23205, \"USDVUV\": 114.265663, \"USDWST\": 2.579343, \"USDXAF\": 611.731846, \"USDXAG\": 0.045592, \"USDXAU\": 0.000538, \"USDXCD\": 2.70255, \"USDXDR\": 0.739908, \"USDXOF\": 611.731846, \"USDXPF\": 112.549814, \"USDYER\": 250.250177, \"USDZAR\": 15.690197, \"USDZMK\": 9001.200271, \"USDZMW\": 17.128375, \"USDZWL\": 321.999592 } }");
    }

    private ResponseEntity<String> successFalseString() {
        return ResponseEntity.ok("{ \"success\": false, \"error\": { \"code\": 101, \"type\": \"invalid_access_key\", \"info\": \"You have not supplied a valid API Access Key. [Technical Support: support@apilayer.com]\" } }");
    }

}