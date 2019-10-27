$(document).ready(inicio);

	function inicio(){
		
	}
  //Metodo peticionn con ajax
	function cargarDatos(){
		//peticion al Back-end
		$.ajax({
			url:"/usuarios/listar",
			method:"Get",
			//data no se necesitara porque el controller no lo necesita
			success:function(response){
				//Se imprimen los valores en la tabla
				response.forEach(i=>{
					$("tdatos").append(""
							+"<tr>"
							+"<td>"+i.id+"</td>"
							+"<td>"+i.nombre+"</td>"
							+"<td>"+i.direccion+"</td>"
							+"<td>"+i.telefono+"</td>"
							+"<td>"
							+"<button type="button" class="btn btn-success mr-2" data-toggle="modal" data-target="#ModifUsuario">"+ "Editar"+"</button>"
							+"<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#ElimiUsuario">"+ "Eliminar"+"</button>"
							+"</td>"
							+"</tr>");
				});
			},
			error:function(response){
				alert("Error en la peticion"+response);
			}
		});
	});