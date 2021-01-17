package org.example.Lab3Spring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@XmlRootElement(name="employee")
@Table
@ToString(of = {"id","text"})
public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @JsonView(Views.Id.class)
        private Long id;
        @JsonView(Views.IdName.class)
        private String text;

        @Column(updatable = false)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonView(Views.FullMessage.class)
        private LocalDateTime creationDate;


    public Long getId() {
        return id;
    }
    @XmlElement
    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }
    @XmlElement
    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    @XmlElement
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) && Objects.equals(text, employee.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }

}

