
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Covid</title>
<!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>


<!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script type="text/javascript">
$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
});
</script>

<script type="text/javascript" src="js/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css"/>
 
<script type="text/javascript" src="js/jquery.dataTables.js"></script>

<script type="text/javascript" src="js/bootstrapValidator.js"></script>

<link rel="stylesheet" href="css/bootstrapValidator.css"/>
<style type="text/css">
/*/Covid-1/src/main/resources/static/js/jquery.dataTables.min.js
    DEMO STYLE
*/

@import "https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";
body {
    font-family: 'Poppins', sans-serif;
    background: #fafafa;
    font-size: 14px;
}

p {
    font-family: 'Poppins', sans-serif;
    font-size: 1.1em;
    font-weight: 300;
    line-height: 1.7em;
    color: #999;
}

a,
a:hover,
a:focus {
    color: inherit;
    text-decoration: none;
    transition: all 0.3s;
}

.navbar {
    padding: 15px 10px;
    background: #fff;
    border: none;
    border-radius: 0;
    margin-bottom: 40px;
    box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1);
}

.navbar-btn {
    box-shadow: none;
    outline: none !important;
    border: none;
}

.line {
    width: 100%;
    height: 1px;
    border-bottom: 1px dashed #ddd;
    margin: 40px 0;
}

/* ---------------------------------------------------
    SIDEBAR STYLE
----------------------------------------------------- */

.wrapper {
    display: flex;
    width: 100%;
    align-items: stretch;
}

#sidebar {
    min-width: 250px;
    max-width: 250px;
    background: #379088;
    color: #fff;
    transition: all 0.3s;
}

#sidebar.active {
    margin-left: -250px;
}

#sidebar .sidebar-header {
    padding: 20px;
    background: #5e83b1;
}

#sidebar ul.components {
    padding: 20px 0;
    border-bottom: 1px solid #47748b;
}

#sidebar ul p {
    color: #fff;
    padding: 10px;
}

#sidebar ul li a {
    padding: 10px;
    font-size: 1.1em;
    display: block;
}

#sidebar ul li a:hover {
    color: #5e83b1;
    background: #fff;
}

#sidebar ul li.active>a,
a[aria-expanded="true"] {
    color: #fff;
    background: #5e83b1;
}

a[data-toggle="collapse"] {
    position: relative;
}

.dropdown-toggle::after {
    display: block;
    position: absolute;
    top: 50%;
    right: 20px;
    transform: translateY(-50%);
}

ul ul a {
    font-size: 0.9em !important;
    padding-left: 30px !important;
    background: #5e83b1;
}

ul.CTAs {
    padding: 20px;
}

ul.CTAs a {
    text-align: center;
    font-size: 0.9em !important;
    display: block;
    border-radius: 5px;
    margin-bottom: 5px;
}

a.download {
    background: #fff;
    color: #7386D5;
}

a.article,
a.article:hover {
    background: #6d7fcc !important;
    color: #fff !important;
}

/* ---------------------------------------------------
    CONTENT STYLE
----------------------------------------------------- */

#content {
    width: 100%;
    padding: 20px;
    min-height: 100vh;
    transition: all 0.3s;
}

/* ---------------------------------------------------
    MEDIAQUERIES
----------------------------------------------------- */

@media (max-width: 768px) {
    #sidebar {
        margin-left: -250px;
    }
    #sidebar.active {
        margin-left: 0;
    }
    #sidebarCollapse span {
        display: none;
    }
    #imgCentral{
    	width: 50%;
    }
}
</style>
</head>
<body>
<div class="wrapper">
       <jsp:include page="Sidebar.jsp" />

        <!-- Page Content  -->
        <div id="content">
			<jsp:include page="Nav.jsp" />
	<div class="container">
		<br>
				<div id="divDocente">
					<table id="id_table_docente">
						<thead>
							<tr>
								<th style="width: 30%">ID</th>
								<th style="width: 30%">Documento Identidad</th>
								<th style="width: 20%">Estado</th>
								<th style="width: 30%">Celular</th>
								<th style="width: 20%">Nacionalidad</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>
		<div class="modal fade" id="idModalRegistra" >
			<div class="modal-dialog" style="width: 60%">
		
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-ok-sign"></span>Registro</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
						<form action="registroCifras" id="id_form"> 
				
							<div class="form-group">
								<label class="control-label" for="id_nombre">Nuevos Casos</label>
								<input class="form-control" type="text" id="id_nombre" name="nombre" placeholder="Ingrese el nombre" maxlength="40">    
							</div>
							
							<div class="form-group">
								<label class="control-label" for="id_dni">Casos Totales</label>
								<input class="form-control" type="text" id="id_dni" name="dni" placeholder="Ingrese el dni" maxlength="8">    
							</div>
							
							<div class="form-group">
								<label class="control-label" for="id_correo">Fallecidos</label>
								<input class="form-control" type="text" id="id_correo" name="correo" placeholder="Ingrese el correo" maxlength="100">    
							</div>
							<div class="form-group">
								<label class="control-label" for="id_correo">Recuperados</label>
								<input class="form-control" type="text" id="id_correo" name="correo" placeholder="Ingrese el correo" maxlength="100">    
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary" >Guardar</button>
							</div>
					</form>
				
				</div>
			</div>
		</div>
			
		</div>
				
			</div>
       </div>
    </div>
<script type="text/javascript">
console.log("inicio");
$.getJSON("cargaTipoDocumento", {}, function(data){
	console.log("inicio2");
	$.each(data.lstTipoDoc, function(index,item){
		$("#id_act_tipodoc").append("<option value="+item.idTipoDocumento +">"+ item.descripcion +"</option>");
	});
});

$.getJSON("cargaNacionalidad", {}, function(data){
	console.log("inicio2");
	$.each(data.lstNacionalidad, function(index,item){
		$("#id_act_pais").append("<option value="+item.idNacionalidad +">"+ item.nombreNacionalidad +"</option>");
	});
});

$.getJSON("cargaEstado", {}, function(data){
	console.log("inicio2");
	$.each(data.lstEstado, function(index,item){
		$("#id_act_estado").append("<option value="+item.idEstado +">"+ item.descripcion +"</option>");
	});
});

function editar(idpersona,nundoc,numcel,idrol,idtipodoc,idnacio, idestado){
	$('input[id=id_ID]').val(idpersona);
	$('input[id=id_act_numdoc]').val(nundoc);
	$('input[id=id_act_cel]').val(numcel);
	$('select[id=id_act_tipodoc]').val(idtipodoc);
	$('select[id=id_act_pais]').val(idnacio);
	$('select[id=id_act_estado]').val(idestado);
	$('input[id=id_act_idrol]').val(idrol);
	$('#idModalActualiza').modal("show");
}

//$("#id_table_docente").DataTable().destroy();
$("#id_table_docente tbody").empty(); 

var tablaDocente="",filaTabla="";
$.getJSON("cargaPersona",{},
		  function(data){
	$.each(data,function(index,item){
		//if(item.estado != undefined){
			var editar='<button type="button" class="btn btn-info" onclick="editar('
			+item.idPersona+','+"'"+item.numDoc+"'"+','+"'"+item.numcel+"'"+','+"'"+item.rol.idRol+"'"+
			','+"'"+item.tipoDocumento.idTipoDocumento+"'"+','+"'"+item.nacionalidad.idNacionalidad+"'"+','+"'"+estado.idEstado+"'"+
			')">Editar</button>';
			
			var eliminar='<button type="button" class="btn btn-btn-danger">Eliminar</button>';
		   filaTabla+="<tr><td>"+item.numDoc+"</td>"+		 
				  						  "<td>"+item.estado.descripcion+"</td>"+
				  						  "<td>"+item.numcel+"</td>"+
				  						  "<td>"+item.nacionalidad.nombreNacionalidad+"</td>"+
										  "<td>"+editar+"</td>"+
		  								  "<td>"+eliminar+"</td></tr>";			
				//}
			})
		$("#id_table_docente tbody").append(filaTabla);
		//$("#id_table_docente").DataTable().draw();
		$("#id_table_docente").DataTable({
			"language": {
		        "lengthMenu": "_MENU_ registros por pagina",
		        "zeroRecords": "No existen registros",
		        "info": "Pagina _PAGE_ de _PAGES_",
		        "infoEmpty": "Sin registros",
		        "infoFiltered": "(Filtro de _MAX_ registros)",
		        "search": "Buscar:",
			    "paginate": {
			        "first":      "First",
			        "last":       "Last",
			        "next":       "Siguiente",
			        "previous":   "Anterior"
			    }
		    },
		    "pagingType": "simple"
		    
		});
});


</script>

</body>
</html>