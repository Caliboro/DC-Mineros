<%-- 
 
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <script src="/jquery/jquery-1.10.2.js" type="text/javascript"></script>
        <script src="/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Estilo.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="header">
			<ul class="nav">
				<li><a href="">Inicio</a></li>
				<li><a href="">Recursos Humanos</a>
					<ul>
                                            <li><a href="<%= request.getContextPath()+"/Contratacion" %>">Iniciar Contratación</a></li>
						<li><a href="<%= request.getContextPath()+"/Perfil_trabajador" %>">Perfil del Trabajador</a></li>
						<li><a href="<%= request.getContextPath()+"/Examenes" %>">Gestionar Exámenes</a></li>
						<li><a href="<%= request.getContextPath()+"/Documentos_trabajador" %>">Gestionar Documentos</a>
						</li>
					</ul>
				</li>
				<li><a href="">Reportabilidad</a>
					<ul>
						<li><a href="<%= request.getContextPath()+"/Avance_obras" %>">Reporte de Obras</a></li>
						<li><a href="<%= request.getContextPath()+"/Estado_contratos" %>">Estado Contratos</a></li>
						<li><a href="<%= request.getContextPath()+"/Obras_equipos" %>">Obras por Equipos</a></li>
                                                <li><a href="<%= request.getContextPath()+"/Obras_trabajadores" %>">Obras por Trabajador</a></li>
					</ul>
				</li>
				<li><a href="">Contratos</a>
                                    <ul>
						<li><a href="<%= request.getContextPath()+"/Ingresar_obras" %>">Ingresar Avance de Obras</a></li>
						<li><a href="<%= request.getContextPath()+"/Avances_no_ingresados" %>">Avances no Ingresados</a></li>
						<li><a href="<%= request.getContextPath()+"/Editar_Avance" %>">Editar Avances de Obras</a></li>
					</ul>
                                
                                </li>
                                <li><a href="">Centro Documental</a>
                                    <ul>
						<li><a href="<%= request.getContextPath()+"/Doc_RRHH" %>">Documentos RRHH</a></li>
						<li><a href="<%= request.getContextPath()+"/Doc_Contratos" %>">Documentos Contratos</a></li>
                                                <li><a href="<%= request.getContextPath()+"/Otros" %>">Otros Documentos</a></li>
					</ul>
                                
                                </li>
                                <li>
                                    <a>Bienvenido a DC Mineros <% String var = (String)request.getSession().getAttribute("error");
                                                                   out.print(var);%>
                                    </a>
                                </li>  
			</ul>
		</div>
    </body>
</html>
