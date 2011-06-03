$(document).ready(function() { 

	jQuery.validator.addMethod("itemFormAlfaNum", function(value, element) {
        return this.optional(element) || /^[a-z0-9\_]+$/i.test(value);
    }, "Este campo solo puede contener numeros, letras y el caracter '_'");
	
	jQuery.validator.addMethod("itemFormNum", function(value, element) {
        return this.optional(element) || /^[0-9]+$/i.test(value);
    }, "Este campo solo puede contener numeros");
	
	jQuery.validator.addMethod("itemFormChar", function(value, element) {
        return this.optional(element) || /^[a-z]+$/i.test(value);
    }, "Este campo solo puede contener letras");
		
	$("#login").validate({
        rules: {
        	   txtUser: {
                    required: true,
                    minlength: 6
               },
               txtPass: {
                    required: true,
                    minlength: 4
                }
        },
        messages: {                            
        	txtUser:{
                    required: "Debe escribir un nombre de usuario",
                    minlength: "Debe tener una longitud minima de 6 caracteres"
                },
                txtPass:{
                    required: "Es necesario escribir una contraseña",
                    minlength: "Debe tener una longitud minima de 4 caracteres"
                }
        }
        /*errorPlacement: function(error, element){
            error.appendTo(element.parent());
        }*/
    });
	
	
	$("#agregarReparacion").validate({
        rules: {

               txtCosto: {
                    required: true,
                    minlength: 4
                }
        },
        messages: {                            

                txtCosto:{
                    required: "Es necesario escribir un costo",
                    minlength: "Debe tener una longitud minima de 4 caracteres"
                }
        }
        /*errorPlacement: function(error, element){
            error.appendTo(element.parent());
        }*/
    });
}); 