package de.hpi.bpmn.serialization.erdf.templates;

import de.hpi.bpmn.DiagramObject;
import de.hpi.bpmn.IntermediateMultipleEvent;
import de.hpi.bpmn.serialization.erdf.ERDFSerializationContext;

public class IntermediateMultipleEventTemplate extends NonConnectorTemplate {

	private static BPMN2ERDFTemplate instance;

	public static BPMN2ERDFTemplate getInstance() {
		if (instance == null) {
			instance = new IntermediateMultipleEventTemplate();
		}
		return instance;
	}	

	public StringBuilder getCompletedTemplate(DiagramObject diagramObject,
			ERDFSerializationContext transformationContext) {

		IntermediateMultipleEvent e = (IntermediateMultipleEvent) diagramObject;
		
		StringBuilder s = getResourceStartPattern(transformationContext.getResourceIDForDiagramObject(e));
		if (e.isThrowing()) {
			appendOryxField(s,"type",STENCIL_URI + "#IntermediateMultipleEventThrowing");
		}
		else {
			appendOryxField(s,"type",STENCIL_URI + "#IntermediateMultipleEventCatching");
		}
		appendOryxField(s,"eventtype","Intermediate");
		appendStandardFields(s);
		appendOryxField(s,"trigger","Multiple");
		appendResourceEndPattern(s, e, transformationContext);
		
		return s;
	}

}
