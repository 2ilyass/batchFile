package com.ensa;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringBatchFileApplication {

	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/ensa/conf/spring-conf.xml");
//		PersonneDao dao = (PersonneDao) context.getBean("personneDaoImpl");
//		Personne personne = new Personne(1215, "ghassane", "lem", "Marocain");
//		dao.ajoutPersonne(personne);
//		
		

		Job job = (Job) ctx.getBean("importPersonnes");
        JobParametersBuilder jobBuilder= new JobParametersBuilder();
        JobParameters jobParameters = jobBuilder.toJobParameters();
		JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher"); 
		JobExecution execution = jobLauncher.run(job, jobParameters);
		System.out.println("Completion Status : " + execution.getStatus());
		
		
	}
	

}

