$(document).on("ready", function() {
	$('#consultar').click(function() {
            window.location.href = "reporte.html";
	});
        
        $("#actualizar").click(function() {
            window.location.href = "pago.html";
	});
        
        $('#buscarVehiculo').click(function() {
            $.get('http://localhost:8080/VehicleTax/webresources/Service/' + $('#placa').val(), function(data) {
                updateFields(data);
                $('#actualizarVehiculo').removeAttr("disabled");
            });
	});
        
        $('#actualizarVehiculo').click(function() {
            var vehiculo = {id:$('#idVehiculo').val(),placa:$('#placa').val(),modelo:$('#modelo').val(),uso:$('#uso').val(),marca:$('#marca').val(),linea:$('#linea').val(),capacidad:$('#capacidad').val()};
            $.ajax({
                url: 'http://localhost:8080/VehicleTax/webresources/Service',
                type: 'POST',
                contentType: "application/json",
                data: JSON.stringify(vehiculo)
            }).done(function(data) {
                updateFields(data);
                alert('Vehiculo Actualizado!!!');
            })
            .error(function(data) {
                alert('Error Actualizado Vehiculo!!!');
            });
	});
        
        $("#actualizarContribuyente").click(function() {
            alert('actualizarContribuyente');
	});
        
        $("#calcularLiquidacion").click(function() {
            var exp = $('#formula').val();
            var result = replaceExpression(exp);
            $('#resultado').val(result);
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
            return $('#'+expression).val();
        }
        
        function updateFields(data) {
            $('#idVehiculo').val(data.id);
            $('#modelo').val(data.modelo);
            $('#uso').val(data.uso);
            $('#marca').val(data.marca);
            $('#linea').val(data.linea);
            $('#capacidad').val(data.capacidad);
        }
});