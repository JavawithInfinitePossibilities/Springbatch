/**
 * 
 */
package com.spring.batch.core.processor;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.spring.batch.core.bean.Employee;

/**
 * @author Siddhant sahu
 *
 */
@Component(value = "itemProcessor")
public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {
	private final static Logger LOGGER = Logger.getLogger(EmployeeItemProcessor.class);

	public Employee process(Employee employee) throws Exception {
		LOGGER.info("EmployeeItemProcessor..." + employee);
		return employee;
	}

}
