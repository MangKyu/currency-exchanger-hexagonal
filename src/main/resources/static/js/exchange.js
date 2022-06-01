$(document).ready(function(){

    getExchangeRate();

    $("#targetCurrency").change(function(){
        getExchangeRate();
    });

});

function getExchangeRate() {

    $.ajax({
        url: "/api/exchange-rates",
        data: {
            "source": $("#sourceCurrency").val(),
            "target": $("#targetCurrency").val(),
        },
        type: "GET",
        success: function(response) {
            $("#exchangeRateText").text(response.rate)
            $("#exchangeUnitText").text(response.unit)
        },
        error: function(xhr) {

        }
    });

}

