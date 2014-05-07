$(document).on('ready', function() {
	$('#consultar').click(function() {
            window.location.href = 'reporte.html';
	});
        
        $('#actualizar').click(function() {
            window.location.href = 'pago.html';
	});
        
        $('#buscarVehiculo').click(function() {
            $.get('http://localhost:8080/VehicleTax/webresources/Service/' + $('#placa').val(), function(data) {
                updateFieldsVehiculo(data);
                $('#actualizarVehiculo').removeAttr('disabled');
                $.get('http://localhost:8080/VehicleTax/webresources/Service/Contribuyente/' + $('#idcontribuyente').val(), function(data) {
                    updateFieldsContribuyente(data);
                    $('#actualizarContribuyente').removeAttr('disabled');
                });
            });
	});
        
        $('#actualizarVehiculo').click(function() {
            var vehiculo = {id:$('#idvehiculo').val(),placa:$('#placa').val(),modelo:$('#modelo').val(),uso:$('#uso').val(),marca:$('#marca').val(),linea:$('#linea').val(),capacidad:$('#capacidad').val(),idcontribuyente:$('#idcontribuyente').val()};
            $.ajax({
                url: 'http://localhost:8080/VehicleTax/webresources/Service',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(vehiculo)
            }).done(function(data) {
                updateFieldsVehiculo(data);
                alert('Vehiculo Actualizado!!!');
            })
            .error(function(data) {
                alert('Error Actualizado Vehiculo!!!');
            });
	});
        
        $('#actualizarContribuyente').click(function() {
            var contribuyente = {id:$('#idcontribuyente').val(),identificacion:$('#identificacion').val(),direccion:$('#direccion').val(),nombre:$('#nombre').val(),ciudad:$('#ciudad').val()};
            $.ajax({
                url: 'http://localhost:8080/VehicleTax/webresources/Service',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(contribuyente)
            }).done(function(data) {
                updateFieldsContribuyente(data);
                alert('Contribuyente Actualizado!!!');
            })
            .error(function(data) {
                alert('Error Actualizado Contribuyente!!!');
            });
	});
        
        $('#calcularLiquidacion').click(function() {
            var exp = $('#formula').val();
            var result = replaceExpression(exp);
            $('#resultado').val(result);
            $('#pagarLiquidacion').removeAttr('disabled');
	});
        
        $('#pagarLiquidacion').click(function() {
            $('#generarComprobante').removeAttr('disabled');
            $('#actualizarVehiculo').attr("disabled", "disabled");
            $('#actualizarContribuyente').attr("disabled", "disabled");
            $('#pagarLiquidacion').attr("disabled", "disabled");
            $('#resultado').val('');
            clearFieldsVehiculo();
            clearFieldsContribuyente();
	});
        
        $('#consultarPagados').click(function() {
            alert('consultarPagados');
	});
        
        $('#consultarPendientes').click(function() {
            alert('consultarPendientes');
	});
        
        $('#generarComprobante').click(function() {
            alert('generarComprobante');
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
        
        function updateFieldsVehiculo(data) {
            $('#idvehiculo').val(data.id);
            $('#modelo').val(data.modelo);
            $('#uso').val(data.uso);
            $('#marca').val(data.marca);
            $('#linea').val(data.linea);
            $('#capacidad').val(data.capacidad);
            $('#idcontribuyente').val(data.idcontribuyente);
        }
        
        function clearFieldsVehiculo() {
            $('#idvehiculo').val('');
            $('#modelo').val('');
            $('#uso').val('');
            $('#marca').val('');
            $('#linea').val('');
            $('#capacidad').val('');
            $('#idcontribuyente').val('');
        }
        
        function updateFieldsContribuyente(data) {
            $('#identificacion').val(data.identificacion);
            $('#nombre').val(data.nombre);
            $('#direccion').val(data.direccion);
            $('#ciudad').val(data.ciudad);
        }
        
        function clearFieldsContribuyente() {
            $('#identificacion').val('');
            $('#nombre').val('');
            $('#direccion').val('');
            $('#ciudad').val('');
        }
});