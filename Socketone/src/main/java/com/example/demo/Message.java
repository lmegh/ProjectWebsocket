package com.example.demo;

import lombok.*;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Entity
@Table(name = "message")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "sender_name")
    private String senderName;
	
	@Column(name= "receiver_name")
    private String receiverName;
	
	@Column(name= "message")
    private String message;
	
	@Column(name= "date")
    private String date;
	
	@Column(name= "status")
    private Status status;
	
	@Column(name= "seen", columnDefinition = "boolean default false")
    private Boolean seen;
	
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

    
}