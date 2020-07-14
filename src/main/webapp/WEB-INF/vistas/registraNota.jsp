
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Colegio</title>
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
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

.help-block {
    color: red;
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
					<c:if test="${sessionScope.MENSAJE != null}">
						<div class="alert alert-success fade in" id="success-alert">
						 <a href="#" class="close" data-dismiss="alert">&times;</a>
						 <strong>${sessionScope.MENSAJE}</strong>
						</div>
					</c:if>
					<c:remove var="MENSAJE" />
					<br>
					
					<br>
				<div id="divDocente">
				<br>
					<table id="id_table_curso">
						<thead>
							<tr>
								<th style="width: 10%">ID</th>
								<th style="width: 75%">Curso</th>
								
								<th></th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>
				
    <div class="modal fade" tabindex="-1" role="dialog"  aria-hidden="true" id="idModalActualiza">
			        <div class="modal-dialog" style="width: 60%" role="document">
			            <!-- Modal content-->
			            <div class="modal-content">
			            <div class="modal-body">
			                    <form id="id_form_actualiza" action="saveNota" class="form-horizontal"  accept-charset="UTF-8">
			                            <!-- Step 1 -->
												<div class="card">
													<div class="card-header">
														<h4 class="panel-title">
															Datos
															<button type="button" class="close" data-dismiss="modal">&times;</button>
														</h4>
													</div>
													<div class="card-body">
														
														<div class="form-group">
															
																<input class="form-control" id="id_ID" 
																	name="idcurso" type="hidden" maxlength="8" />
															
														</div>
														<div class="form-group">
															<label class="control-label" for="id_act_descripcion">Descripcion</label>
															<input class="form-control" readonly="readonly" type="text" id="id_act_descripcion" >
														</div>
			
												
														<div class="form-group">
															<label class="col-lg-5 control-label" for="id_act_alu">Alumno</label>
															<div class="col-lg-12">
																<select id="id_act_alu" name="idusuario"
																	class='form-control'>
																	<option value=" ">[Seleccione]</option>
																</select>
															</div>
														</div>

														<div class="form-group">
															<label class="col-lg-5 control-label" for="id_act_eva">Evaluación</label>
															<div class="col-lg-12">
																<select id="id_act_eva" name="idevalucion"
																	class='form-control'>
																	<option value=" ">[Seleccione]</option>
																</select>
															</div>
															</div>
															<div class="form-group">
																<label class="col-lg-5 control-label" for="id_act_not">Nota</label>
																<div class="col-lg-12">
																	<input class="form-control" id="id_act_not" name="descripcion"
																		placeholder="Ingrese la nota" type="number" min="0" max="20" />
																</div>
															</div>


											<div class="form-group">
															<div class="col-lg-12" style="text-align: center;">
																<button type="submit" class="btn btn-primary">Guardar</button>
															</div>
														</div>
													</div>
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

$(function() {
	ListarCurso();
	ListarEvaluacion();
	

});



function ListarEvaluacion(){
	$.getJSON("cargaEvaluacion", {}, function(data){
		console.log("inicio");
		$.each(data, function(index,item){
			$("#id_act_eva").append("<option value="+item.idEvaluacion +">"+ item.descripcion +"</option>");
		});
	});
}


function editar(idCurso,descripcion){
	$('input[id=id_ID]').val(idCurso);
	$('input[id=id_act_descripcion]').val(descripcion);

	var idcurso=$("#id_ID").val();
	$("#id_act_alu").empty();
	$("#id_act_alu").append("<option value="+ " " +">" + "[Seleccione]" + "</option>");
	
	$.getJSON("cargaAlumnoDeCurso", {idcurso:idcurso}, function(data){
		console.log("inicio3");
		$.each(data, function(index,item){
			$("#id_act_alu").append("<option value="+item.usuario.idUsuario +">"+ item.usuario.apellido +" "+ item.usuario.nombre +"</option>");
		});
	});
	


	
	
	
}
function ListarCurso(){
	//$("#id_table_docente").DataTable().destroy();
	$("#id_table_curso tbody").empty(); 

	var tablaDocente="",filaTabla="";
	$.getJSON("cargaCurso",{},
			  function(data){
		$.each(data,function(index,item){
				var editar='<button type="button" class="btn btn-info" data-toggle="modal" data-target="#idModalActualiza"  onclick="editar('
				+item.idCurso+','+"'"+item.descripcion+"'"+
				')">Buscar</button>';
			   filaTabla+="<tr><td>"+item.idCurso+"</td>"+"<td>"+item.descripcion+"</td>"+
			  								  "<td>"+editar+"</td></tr>";		
				})
			$("#id_table_curso tbody").append(filaTabla);
			$("#id_table_curso").DataTable({
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
}

$(document).ready(function() {
    $('#id_form_actualiza').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	"idusuario":{
                    selector: "#id_act_alu",
                    validators:{
                        notEmpty: {
                             message: 'Seleccione al alumno'
                        },
                    }
               },
               "idevalucion":{
                   selector: "#id_act_eva",
                   validators:{
                       notEmpty: {
                            message: 'Seleccione evaluación'
                       },
                   }
              },
               "descripcion" :{
            	   selector: "#id_act_not",
           		validators :{
           		    notEmpty :{
           				message :"La nota es obligatoria"
           		    },
   		            lessThan: {
   		                value: 20,
   		                inclusive: true,
   		                message: 'La edad es menor a 20'
   		            },
   		            greaterThan: {
   		                value: 0,
   		                inclusive: true,
   		                message: 'La edad es mayor a 0'
   		            },
           		}
           	},
                  
        }   
    });

    // Validate the form manually
    $('#validateBtn').click(function() {
        $('#id_form_actualiza').bootstrapValidator('validate');
    });
});


</script>
<script type="text/javascript">
$("#success-alert").fadeTo(1000, 500).slideUp(500, function(){
    $("#success-alert").slideUp(500);
});
</script>

</body>
</html>




