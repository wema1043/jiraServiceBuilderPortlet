package de.hska.wi.awp.datasource.event;

import java.io.Serializable;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.portlet.Event;
import javax.portlet.faces.BridgeEventHandler;
import javax.portlet.faces.event.EventNavigationResult;

import com.liferay.faces.bridge.event.EventPayloadWrapper;

import de.hska.wi.awp.datasource.bean.burndownchartstorypointbean.BurnDownModelBean;


public class BurnDownChartStoryPointEventHandler  implements BridgeEventHandler{

	@Override
	public EventNavigationResult handleEvent(FacesContext facesContext, Event event) {
		 EventNavigationResult eventNavigationResult = null;
         String eventQName = event.getQName().toString();

         if (eventQName.equals("{http://liferay.com/events}ipc.studentSelected")) {
             System.out.print("EVENT RECIVED STUDENT");
             
             Serializable value = event.getValue();
             

             
            if (value instanceof EventPayloadWrapper) {
 				value = ((EventPayloadWrapper) value).getWrapped();
 			}

 			String hskaId = (String) value;
 			BurnDownModelBean burnDownViewBean = getBurnDownViewBean(facesContext);
 			burnDownViewBean.setStudenthskaId(hskaId);
 			burnDownViewBean.setProjektId(null);

 			String fromAction = null;
 			String outcome = "ipc.customerSelected";
 			eventNavigationResult = new EventNavigationResult(fromAction, outcome);
             
         }

         if(eventQName.equals("{http://liferay.com/events}ipc.projectSelected")) {
        	 System.out.print("EVENT RECIVED PROJECT");
        	 
        	 
        	 Serializable value = event.getValue();
             
             if (value instanceof EventPayloadWrapper) {
  				value = ((EventPayloadWrapper) value).getWrapped();
  			}

  			String projektId = (String) value;
  			BurnDownModelBean burnDownViewBean = getBurnDownViewBean(facesContext);
  			burnDownViewBean.setProjektId(projektId);
  			burnDownViewBean.setStudenthskaId(null);
  			  			
  			String fromAction = null;
  			String outcome = "ipc.customerSelected";
  			eventNavigationResult = new EventNavigationResult(fromAction, outcome); 
        	 
         }
         
         return eventNavigationResult;
	}
	
	
	protected BurnDownModelBean getBurnDownViewBean(FacesContext facesContext) {
		String elExpression = "#{burnDownViewBean}";
		ELContext elContext = facesContext.getELContext();
		ValueExpression valueExpression = facesContext.getApplication().getExpressionFactory().createValueExpression(
				elContext, elExpression, BurnDownModelBean.class);

		return (BurnDownModelBean) valueExpression.getValue(elContext);
	}
	
	
	

}
