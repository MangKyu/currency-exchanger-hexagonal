$(document).ready(function(){

    getExchangeRate();

    $("#targetCurrency").change(function(){
        getExchangeRate();
    });

    $("#exchangeButton").on('click', function () {
        exchange();
    });

});

function getExchangeRate() {
    $.ajax({
        url: "/api/exchange-rates",
        type: "GET",
        data: {
            "source": $("#sourceCurrency").val(),
            "target": $("#targetCurrency").val(),
        },
        success: function(response) {
            $("#exchangeRateText").text(response.rate)
            $("#exchangeUnitText").text(response.unit)
        },
        error: function(e) {
            alert("Error Occurred");
        }
    });

}

function exchange() {
    $.ajax({
        url: "/api/exchange",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            "amount": $("#amount").val(),
            "sourceCurrency": $("#sourceCurrency").val(),
            "targetCurrency": $("#targetCurrency").val()
        }),
        success: function(response) {
            $("#resultDiv").show();
            $("#resultText").text(response.amount)
            $("#currencyText").text(response.currency)
        },
        error: function (e) {
            if (e.responseJSON.errors) {
                alert(e.responseJSON.errors[0].message);
            } else {
                alert("Error Occurred");
            }

            $("#resultDiv").hide();
        }
    });
}