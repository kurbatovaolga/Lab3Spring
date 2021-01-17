package org.example.Lab3Spring.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="employee")
public class EmployeeXML {
    @XmlElement
    List<Employee> employee = new ArrayList<>();

    public EmployeeXML(){}

    public EmployeeXML(List<Employee> employees){this.employee = employees;}

    public List<Employee> getAllAEmployees(){return this.employee;}
}
