package de.hska.wi.awp.datasource.event;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.portlet.Event;
import javax.portlet.faces.BridgeEventHandler;
import javax.portlet.faces.event.EventNavigationResult;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import com.liferay.faces.bridge.event.EventPayloadWrapper;

import de.hska.wi.awp.datasource.bean.burndownchartstorypointbean.BurnDownViewBean;
import de.hska.wi.awp.datasource.bean.openclosedbean.OpenClosedViewBean;
import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil;


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
 			BurnDownViewBean burnDownViewBean = getBurnDownViewBean(facesContext);
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
  			BurnDownViewBean burnDownViewBean = getBurnDownViewBean(facesContext);
  			burnDownViewBean.setProjektId(projektId);
  			burnDownViewBean.setStudenthskaId(null);
  			  			
  			String fromAction = null;
  			String outcome = "ipc.customerSelected";
  			eventNavigationResult = new EventNavigationResult(fromAction, outcome); 
        	 
         }
         
         return eventNavigationResult;
	}
	
	
	protected BurnDownViewBean getBurnDownViewBean(FacesContext facesContext) {
		String elExpression = "#{burnDownViewBean}";
		ELContext elContext = facesContext.getELContext();
		ValueExpression valueExpression = facesContext.getApplication().getExpressionFactory().createValueExpression(
				elContext, elExpression, BurnDownViewBean.class);

		return (BurnDownViewBean) valueExpression.getValue(elContext);
	}
	
	
	

}
