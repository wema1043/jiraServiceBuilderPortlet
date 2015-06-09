package de.hska.wi.awp.datasource.event;

import javax.faces.context.FacesContext;
import javax.portlet.Event;
import javax.portlet.faces.BridgeEventHandler;
import javax.portlet.faces.event.EventNavigationResult;

import de.hska.wi.awp.datasource.bean.burndownchartstorypointbean.BurnDownViewBean;

public class BurnDownChartStoryPointEventHandler  implements BridgeEventHandler{

	@Override
	public EventNavigationResult handleEvent(FacesContext facesContext, Event event) {
		 EventNavigationResult eventNavigationResult = null;
         String eventQName = event.getQName().toString();

         if (eventQName.equals("{http://liferay.com/events}ipc.studentSelected")) {
             System.out.print("EVENT RECIVED BurnDown STUDENT");
             
         }

         if(eventQName.equals("{http://liferay.com/events}ipc.projectSelected")) {
        	 System.out.print("EVENT RECIVED BurnDown PROJECT");
         }
         
         return eventNavigationResult;
	}

}
