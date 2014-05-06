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
            var value = $('#liquidacion tr#valorbase td').slice(1, 2).text();
            $("#resultado").val(value);
	});
        
        $("#pagarLiquidacion").click(function() {
            alert('pagarLiquidacion');
	});
});