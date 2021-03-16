package com.task.dekadabackend.model;

import com.sun.istack.Nullable;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name="TBL_EMAIL")
@ToString
@NoArgsConstructor
public class Email {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Nullable
    @Column(name="from")
    private String from;

    @Nullable
    @Column(name="mail_to")
    private String mailTo;

    @Column(name="subject")
    private String subject;

    @Column(name="name")
    private String name;

    @Column(name="location")
    private String location;

    @Column(name="sign")
    private String sign;

    @Column(name="message")
    private String message;

    @Column(name="title")
    private String title;

    @Transient
    private Map<String, Object> props;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }

}