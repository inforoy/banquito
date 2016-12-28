
console.log("init");
var count = '${listSocioCount}';
if(parseInt(count) > 0){
    var listSocio = ' ${listSocio} ';

}

function cargarDatos(listadoSocios){
    for(var i=0; i<listadoSocios.length; i++){
        var agencia = listadoSocios[i].agencia;
        var idPersona = listadoSocios[i].idPersona;
        var codigoSocio = listadoSocios[i].codigoSocio;
        var nombreEmpresa = listadoSocios[i].nombreEmpresa;
        var fechaIngreso = listadoSocios[i].fechaIngreso;
        $('#tableSocio').append('<tr>')
            .append('<td>agencia</td>')
            .append('<td>idPersona</td>')
            .append('<td><span class="label label-success">codigoSocio</span></td>')
            .append('<td>nombreEmpresa</td>')
            .append('<td>fechaIngreso</td>')
            .append('</tr>');

    }
}