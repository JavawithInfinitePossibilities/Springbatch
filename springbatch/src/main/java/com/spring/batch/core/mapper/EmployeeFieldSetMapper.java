/**
 * 
 */
package com.spring.batch.core.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.spring.batch.core.bean.Employee;

/**
 * @author Siddhant sahu
 *
 */
public class EmployeeFieldSetMapper implements FieldSetMapper<Employee> {

	private final static Logger LOGGER = Logger.getLogger(EmployeeFieldSetMapper.class);
	final private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	public Employee mapFieldSet(FieldSet fieldSet) throws BindException {
		final Employee employee = new Employee();
		employee.setEmpId(fieldSet.readInt(0));
		employee.setFirstName(fieldSet.readString(1));
		employee.setMiddleName(fieldSet.readString(2));
		employee.setLastName(fieldSet.readString(3));
		employee.setEmpEmail(fieldSet.readString(4));
		employee.setEmpPhone(fieldSet.readString(5));
		// default format yyyy-MM-dd
		final String date = fieldSet.readString(6);
		try {
			employee.setDob(dateFormat.parse(date));
		} catch (ParseException e) {
			LOGGER.equals(e);
		}
		LOGGER.info(":===> " + employee);
		return employee;
	}

}
