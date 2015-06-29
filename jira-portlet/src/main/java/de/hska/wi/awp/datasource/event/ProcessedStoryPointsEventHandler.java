package de.hska.wi.awp.datasource.event;

import java.io.Serializable;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.portlet.Event;
import javax.portlet.faces.BridgeEventHandler;
import javax.portlet.faces.event.EventNavigationResult;

import com.liferay.faces.bridge.event.EventPayloadWrapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.hska.wi.awp.datasource.bean.processedStoryPoints.ProcessedStoryPointsStudentModelBean;
import de.hska.wi.awp.datasource.bean.processedStoryPoints.ProcessedStoryPointsProjectModelBean;
import de.hska.wi.awp.datasource.model.JiraUser;
import de.hska.wi.awp.datasource.service.JiraUserLocalServiceUtil;
import de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil;

/**
 * 
 * @author Mihai Sava und Simon Hämmerle
 *
 */
public class ProcessedStoryPointsEventHandler implements BridgeEventHandler{
	/**
	 * Logger Util
	 */
	private static Log log = LogFactoryUtil.getLog(ProcessedStoryPointsEventHandler.class);
	
	@Override
	public EventNavigationResult handleEvent(FacesContext facesContext, Event event) {
		log.info("BEGIN: ProcessedStoryPointsEventHandler-EventNavigationResult");
		 EventNavigationResult eventNavigationResult = null;
         String eventQName = event.getQName().toString();

         if (eventQName.equals("{http://liferay.com/events}ipc.studentSelected")) {
        	 log.info("BEGIN: ProcessedStoryPointsEventHandler-ipc.studentSelected");
             System.out.print("EVENT RECIVED STUDENT - ProcessedStoryPointsEventHandler - ");
             
             Serializable value = event.getValue();
             
            if (value instanceof EventPayloadWrapper) {
 				value = ((EventPayloadWrapper) value).getWrapped();
 			}

 			String hskaId = (String) value;

 			ProcessedStoryPointsStudentModelBean processedStoryPointsStudentModelBean = getProcessedStoryPointsModelBean(facesContext);
 			processedStoryPointsStudentModelBean.setStudentId(hskaId);
 			processedStoryPointsStudentModelBean.setProjectKey(null);
 			System.out.println("hskaId---"+hskaId);
 			
// 			//get Student from InfoSys
// 			Student student = StudentLocalServiceUtil.findByStudenthskaId(hskaId);
 			
// 			//get the project key from this student
// 			Project project = null;
//			try {
//				project = ProjectLocalServiceUtil.getProject(student.getProject_id());
//				System.out.println("Print Project from handler ProcessedStoryPointsEventHandler->"+ project.getProjecthskaId());
//			} catch (SystemException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (PortalException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			//get Jira Project Id (//12345) for this Project Key(//AWP)
 			//workaround for the above implementation - get projectName from JIRA.
 			//get jira user
 			String projectName = JiraUserLocalServiceUtil.getProjectNameForUserId(hskaId);
 			String jiraProjectId = ProjectLocalServiceUtil.getProjectIdForProjectName(projectName);
 			System.out.println("Print jiraProjectId from handler ProcessedStoryPointsEventHandler->"+ jiraProjectId);
 			processedStoryPointsStudentModelBean.setProjectId(jiraProjectId);
			
			// set project id for ProcessedStoryPointsProjectModelBean to null
 			ProcessedStoryPointsProjectModelBean processedStoryPointsProjectModelBean = getProcessedStoryPointsProjectModelBean(facesContext);
 			processedStoryPointsProjectModelBean.setProjectKey(null);
			
 			String fromAction = null;
 			String outcome = "ipc.customerSelected";
 			eventNavigationResult = new EventNavigationResult(fromAction, outcome);
 			
 			log.info("END: ProcessedStoryPointsEventHandler-ipc.studentSelected");
         }

         if(eventQName.equals("{http://liferay.com/events}ipc.projectSelected")) {
        	 log.info("BEGIN: ProcessedStoryPointsEventHandler-ipc.projectSelected");
        	 System.out.print("EVENT RECIVED PROJECT - ProcessedStoryPointsEventHandler - ");
        	 
        	 
        	 Serializable value = event.getValue();
             
             if (value instanceof EventPayloadWrapper) {
  				value = ((EventPayloadWrapper) value).getWrapped();
  			}

  			String projektId = (String) value;
  			
  			ProcessedStoryPointsProjectModelBean processedStoryPointsProjectModelBean = getProcessedStoryPointsProjectModelBean(facesContext);
  			processedStoryPointsProjectModelBean.setProjectKey(projektId);
  			String jiraProjectId = de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil.getProjectIdForProjectName(projektId);
  			processedStoryPointsProjectModelBean.setProjectId(jiraProjectId);
  			
  			ProcessedStoryPointsStudentModelBean processedStoryPointsStudentModelBean = getProcessedStoryPointsModelBean(facesContext);
  			processedStoryPointsStudentModelBean.setStudentId(null);
  			System.out.println("projektId---"+projektId);
  			
  			String fromAction = null;
  			String outcome = "ipc.customerSelected";
  			eventNavigationResult = new EventNavigationResult(fromAction, outcome); 
  			
  			log.info("BEGIN: ProcessedStoryPointsEventHandler-ipc.projectSelected");
         }
         
         return eventNavigationResult;
	}
	
	
	protected ProcessedStoryPointsStudentModelBean getProcessedStoryPointsModelBean(FacesContext facesContext) {
		String elExpression = "#{processedStoryPointsStudentModelBean}";
		ELContext elContext = facesContext.getELContext();
		ValueExpression valueExpression = facesContext.getApplication().getExpressionFactory().createValueExpression(
				elContext, elExpression, ProcessedStoryPointsStudentModelBean.class);

		return (ProcessedStoryPointsStudentModelBean) valueExpression.getValue(elContext);
	}
	
	protected ProcessedStoryPointsProjectModelBean getProcessedStoryPointsProjectModelBean(FacesContext facesContext) {
		String elExpression = "#{processedStoryPointsProjectModelBean}";
		ELContext elContext = facesContext.getELContext();
		ValueExpression valueExpression = facesContext.getApplication().getExpressionFactory().createValueExpression(
				elContext, elExpression, ProcessedStoryPointsProjectModelBean.class);

		return (ProcessedStoryPointsProjectModelBean) valueExpression.getValue(elContext);
	}

}
