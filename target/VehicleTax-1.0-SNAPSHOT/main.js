$(document).on("ready", function() {
	$("#consultar").click(function() {
            window.location.href = "reporte.html";
	});
        
        $("#actualizar").click(function() {
            window.location.href = "pago.html";
	});
        
        $("#buscarVehiculo").click(function() {
            alert('buscarVehiculo');
	});
        
        $("#actualizarVehiculo").click(function() {
            alert('actualizarVehiculo');
	});
        
        $("#actualizarContribuyente").click(function() {
            alert('actualizarContribuyente');
	});
        
        $("#calcularLiquidacion").click(function() {
            var exp = "<valorbase> + <derechos> + (<descuento> - 30)";
            var result = replaceExpression(exp);
            $("#resultado").val(result);
	});
        
        $("#pagarLiquidacion").click(function() {
            alert('pagarLiquidacion');
	});
        
        function replaceExpression(exp) {
            var finalExp = exp;
            console.log('Inicio: ' + finalExp);
            var match = XRegExp.matchChain(exp, [XRegExp('(?is)<.*?>'), /\w*/]);
            for(var i = 0; i < match.length; i++) {
                if(match[i].length > 0) {
                    finalExp = finalExp.replace('<' + match[i] + '>', GetValue(match[i]));
                }
            }
            return eval(finalExp);
        }
        
        function GetValue(expression) {
            return $('#liquidacion tr#' + expression + ' td').slice(1, 2).text();
        }
});