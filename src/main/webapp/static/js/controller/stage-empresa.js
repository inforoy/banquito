
    $( "#btnModificar" ).click(function() {

        var isValid = validateGeneral();

        if( isValid ){// Ajax init
            var parametros = {
                "razonSocial" : $("#inputRazonSocial").val(),
                "ruc" : $("#inputRuc").val(),
                "fechaCreacion" : $("#inputFechaCreacion").val(),
                "descripcion" : $("#inputDescripcion").val(),
                "direccion" : $("#inputDireccion").val(),
                "representanteLegalNombres" : $("#inputNombres").val(),
                "representanteLegalPaterno" : $("#inputPaterno").val(),
                "representanteLegalMaterno" : $("#inputMaterno").val()
            };

            $.ajax({
                data:  parametros,
                url:   'registrarEmpresa.htm',
                type:  'get',
                beforeSend: function () {
                    $("#divMessage").html("Procesando, espere por favor...");
                },
                success:  function (response) {
                    desHabilitarCampos();
                    var object = jQuery.parseJSON( response );
                    responseSuccess(object);

                    console.log("Success"+response);
                },
                error : function(e) {
                    responseError(e);
                    console.log("ERROR: ", e);
                },
                done : function(e) {
                    console.log("DONE"+e);
                }
            });// Ajax end

        } // isValid

    });// Click Buttom

    function responseSuccess(data){
        // agrega la clase de success al idModal
        // obtener el mensaje se exito y MUESTRA
        alert(data.message);
    }

    function responseError(error){
        // agrega la clase de error al idModal
        // obtener el mensaje se error y MUESTRA
        alert(error.message);
    }

    function validateGeneral(){
        var isValid = true;

        isValid =  validarRazonSocial(isValid);

        return isValid;
    }

    function habilitarCampos() {
        $("#inputRazonSocial").removeAttr("disabled");
        $("#inputRuc").removeAttr("disabled");
        $("#inputFechaCreacion").removeAttr("disabled");
        $("#inputDescripcion").removeAttr("disabled");
        $("#inputDireccion").removeAttr("disabled");

        $("#inputNombres").removeAttr("disabled");
        $("#inputPaterno").removeAttr("disabled");
        $("#inputMaterno").removeAttr("disabled");
    }

    function desHabilitarCampos() {
        $("#inputRazonSocial").attr("disabled","disabled");
        $("#inputRuc").attr("disabled","disabled");
        $("#inputFechaCreacion").attr("disabled","disabled");
        $("#inputDescripcion").attr("disabled","disabled");
        $("#inputDireccion").attr("disabled","disabled");

        $("#inputNombres").attr("disabled","disabled");
        $("#inputPaterno").attr("disabled","disabled");
        $("#inputMaterno").attr("disabled","disabled");
    }


$( "#btnRegistrar" ).click(function() {
    //$("#formRegistrarEmpresa").validate();
    console.log("llamada para envio");
    console.log("enviando");
    $( "#formRegistrarEmpresa" ).submit();
    console.log("ternimo el envio");
});

    function validarRazonSocial(){

        var isValid = true;
    /*
        var required = "Este campo es obligatorio.";
        var razonSocial = $("#inputRuc").val();

        if(razonSocial == null || razonSocial.length == 0 || /^\s+$/.test(razonSocial) ){
            isValid = false;
            $("#inputRuc").parent().parent().attr("class","form-group has-error has-feedback");
            $("#inputRuc").parent().children("span").text( required ).show();
            $("#inputRuc").parent().append("<span id='iconotexto' class='glyphicon glyphicon-remove form-control-feedback'></span>");
        }

        if(razonSocial.length < 11 ){
            isValid = false;
            $("#inputRuc").parent().parent().attr("class","form-group has-error has-feedback");
            $("#inputRuc").parent().children("span").text( required ).show();
            $("#inputRuc").parent().append("<span id='iconotexto' class='glyphicon glyphicon-remove form-control-feedback'></span>");
        }
    */
        return isValid;
    }