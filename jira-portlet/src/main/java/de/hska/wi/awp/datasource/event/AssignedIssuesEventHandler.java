/**
 * 
 */
package de.hska.wi.awp.datasource.event;

import java.io.Serializable;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.portlet.Event;
import javax.portlet.faces.BridgeEventHandler;
import javax.portlet.faces.event.EventNavigationResult;

import com.liferay.faces.bridge.event.EventPayloadWrapper;

import de.hska.wi.awp.datasource.bean.assignedissues.AssignedIssuesBackingBean;


/**
 * Eventhandler for the assigned issues portlet
 * @author Chris Ramroth
 * 
 */
public class AssignedIssuesEventHandler implements BridgeEventHandler{
	
	/* (non-Javadoc)
	 * @see javax.portlet.faces.BridgeEventHandler#handleEvent(javax.faces.context.FacesContext, javax.portlet.Event)
	 */
	@Override
	public EventNavigationResult handleEvent(FacesContext facesContext, Event event) {
		 EventNavigationResult eventNavigationResult = null;
         String eventQName = event.getQName().toString();
         
         

         if (eventQName.equals("{http://liferay.com/events}ipc.studentSelected")) {
             System.out.print("EVENT RECIVED Assigned Issues STUDENT");
             
             Serializable value = event.getValue();
             
             if (value instanceof EventPayloadWrapper) {
  				value = ((EventPayloadWrapper) value).getWrapped();
  			}

  			String hskaId = (String) value;
  			AssignedIssuesBackingBean assignedIssues = getAssignedIssues(facesContext);
  			assignedIssues.setStudentHskaId(hskaId);
  			assignedIssues.setProjectHskaId(null);

  			String fromAction = null;
  			String outcome = "ipc.studentSelected";
  			eventNavigationResult = new EventNavigationResult(fromAction, outcome);
         }

         if(eventQName.equals("{http://liferay.com/events}ipc.projectSelected")) {
        	 System.out.print("EVENT RECIVED Assigned Issues PROJECT");
        	 
        	 Serializable value = event.getValue();
             
             if (value instanceof EventPayloadWrapper) {
  				value = ((EventPayloadWrapper) value).getWrapped();
  			}

  			String projectId = (String) value;
  			AssignedIssuesBackingBean assignedIssues = getAssignedIssues(facesContext);
  			assignedIssues.setProjectHskaId(projectId);
  			assignedIssues.setStudentHskaId(null);
<<<<<<< HEAD

=======
>>>>>>> chris

  			String fromAction = null;
  			String outcome = "ipc.projectSelected";
  			eventNavigationResult = new EventNavigationResult(fromAction, outcome);
         }
         
         return eventNavigationResult;
	}
	protected AssignedIssuesBackingBean getAssignedIssues(FacesContext facesContext) {
		String elExpression = "#{assignedIssues}";
		ELContext elContext = facesContext.getELContext();
		ValueExpression valueExpression = facesContext.getApplication().getExpressionFactory().createValueExpression(
				elContext, elExpression, AssignedIssuesBackingBean.class);

		return (AssignedIssuesBackingBean) valueExpression.getValue(elContext);
	}

}
