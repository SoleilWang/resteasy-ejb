package com.alex.wang.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "T_Name")
public class NameEntity {
    @Id
    @SequenceGenerator(name = "SEQ_BCC_EVENT_ID", sequenceName = "SEQ_BCC_EVENT_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BCC_EVENT_ID")
    private Long id;
    
    @Column(name = "Name", nullable = false)
    private String Name;
   
    
    public NameEntity() {   
    }
    
    public NameEntity(Long id, String name) {
        super();
        this.id = id;
        Name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    @Override
    public String toString() {
        return "NameEntity [id=" + id + ", Name=" + Name + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }

}
