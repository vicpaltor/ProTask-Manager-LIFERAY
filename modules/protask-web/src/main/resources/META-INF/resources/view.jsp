<%@ include file="/init.jsp" %>

<h1>Mis Tareas</h1>

<portlet:renderURL var="addEntryURL">
    <portlet:param name="mvcPath" value="/edit.jsp" />
</portlet:renderURL>

<!--Botón visual usando la librería AUI (AlloyUI/Clay) -->
<aui:button-row>
    <aui:button cssClass="btn btn-primary" href="<%= addEntryURL %>" value="Nueva Tarea" />
</aui:button-row>


<%
    // Recuperamos la lista
    List<Task> lista = (List<Task>) request.getAttribute("listaDeTareas");

    // Si es null, creamos una lista vacía usando Java estándar (más seguro)
    if (lista == null) {
        lista = new java.util.ArrayList<Task>();
    }
%>

<liferay-ui:search-container total="<%= lista.size() %>">

    <liferay-ui:search-container-results results="<%= lista %>" />

    <liferay-ui:search-container-row
        className="com.miempresa.protask.model.Task"
        modelVar="unaTarea">

        <liferay-ui:search-container-column-text
            name="header.id"
            property="taskId"
        />

        <liferay-ui:search-container-column-text
            name="header.title"
            property="title"
        />

        <liferay-ui:search-container-column-text
            name="header.description"
            property="description"
        />

        <%-- Cálculo del Estado --%>
        <%
            String estadoKey = (unaTarea.getStatus() == 0) ? "status.pending" : "status.completed";
        %>

        <liferay-ui:search-container-column-text
            name="header.status"
            value="<%= estadoKey %>"
            translate="<%= true %>"
        />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

</liferay-ui:search-container>