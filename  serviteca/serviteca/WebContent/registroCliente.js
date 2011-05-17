$(document).ready(function(){
                //banner
                $("#banner").attr("src","../Images/banner.png");
                $("#logOut").attr("href","#");
                
                //enviar formulario
                $("#guardar").click(function(){
                    if(($("#tipo").val()=="Juridico") && (($("#nit").val()=="") || ($("#empresa").val()==""))){
                        alert("Debe escribir el nit y nombre de la empresa");
                    }else{                        
                        $("#formulario").submit();
                    }
                });

                //Empresa Json
               $("#nit").blur(function() {                   
                  $.getJSON (
                     "../ControladorCliente",
                     {
                        nit : $("#nit").val(),
                        accion : 'N'
                     },
                     function(data) {
                        var resultado = data.mensaje;                        
                        $("#empresa").val(resultado);
                     }
                    );
               });

                //validate
                $("#login").validate({
                    rules: {
                            email: {
                                required: true,
                                email: true
                            },
                            password: {
                                required: true,
                                minlength: 6,
                                maxlength: 200
                            }
                    },
                    messages: {                            
                            email:{
                                required: "Debe escribir un E-Mail",
                                email: "Debe escribir su E-Mail correctamente"
                            },
                            password:{
                                required: "Es necesario escribir una contraseña",
                                minlength: "Debe tener una longitud minima de 6 caracteres",
                                maxlength: "Sobrepaso la longitud maxima"

                            }
                    },
                    errorPlacement: function(error, element){
                        error.appendTo(element.parent());
                    },
                    success: function(label){
                        label.html("&nbsp;").addClass("checked");
                    }
                });

                //funcion en jQuery para resetear un form
                jQuery.fn.reset = function () {
                    $(this).each (function() { this.reset(); });
                }

                //reset formulario
                $("#resetear").click(function(){
                    $("#formulario").reset();
                });

                //validacion del tipo y cambio de empresa
                $("#tipo").blur(function(){
                    if($("#tipo").val()!="Natural"){
                        $("#trEmpresa").css("visibility","visible");
                        $("#trNit").css("visibility","visible");
                    }else{
                        $("#empresa").val("");
                        $("#trEmpresa").css("visibility","hidden");
                        $("#nit").val("");
                        $("#trNit").css("visibility","hidden");
                    }
                });
});