<%@ include file="/init.jsp" %>

<h1>Nueva Tarea</h1>

<portlet:actionURL name="addTask" var="addTaskURL" />

<aui:form action="<%= addTaskURL.toString() %>" name="fm">
    <aui:fieldset>
        <!-- Título (Obligatorio) -->
        <aui:input name="title" label="label.title">
            <aui:validator name="required" />
        </aui:input>

        <!-- Descripción (Área de texto) -->
        <aui:input name="description" label="label.description" type="textarea" />

        <!-- Fecha de Vencimiento -->
        <aui:input name="dueDate" label="label.dueDate" type="date" />
    </aui:fieldset>

    <aui:button-row>
        <!-- Botón Submit (envía la ActionURL) -->
        <aui:button type="submit" value="Guardar" />

        <!-- Botón Cancelar (vuelve atrás) -->
        <aui:button type="cancel" href="<%= renderResponse.createRenderURL().toString() %>" />
    </aui:button-row>

</aui:form>