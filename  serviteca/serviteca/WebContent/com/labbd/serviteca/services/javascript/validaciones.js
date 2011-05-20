$(document).ready(function() { 

	jQuery.validator.addMethod("txtUser", function(value, element) {
        return this.optional(element) || /^[a-z0-9\_]+$/i.test(value);
    }, "El usuario solo puede contener numeros, letras y el caracter '_'");
	
	jQuery.validator.addMethod("txtPass", function(value, element) {
        return this.optional(element) || /^[a-z0-9\_]+$/i.test(value);
    }, "La contrase�a contiene caracteres no validos");
	
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
                    required: "Es necesario escribir una contrase�a",
                    minlength: "Debe tener una longitud minima de 4 caracteres"
                }
        }
        /*errorPlacement: function(error, element){
            error.appendTo(element.parent());
        }*/
    });
}); 