package com.labs.lawcart.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="matters")
public class Matter  implements Serializable
	 {
	 	private static final long serialVersionUID = 1L;
	 	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	 	private Integer id;
	 	
	 	@OneToOne(cascade=CascadeType.PERSIST)
		@JoinColumn(name="user_id")
		private User user;
	 	
	 	@Column(length=1024)
		private String description;
	 	
	 	@Temporal(TemporalType.TIMESTAMP)
		@Column(name="open_date")
		private Date openDate ;
	 	
	 	@Temporal(TemporalType.TIMESTAMP)
		@Column(name="close_date")
		private Date closeDate ;
	 	
	 	@Temporal(TemporalType.TIMESTAMP)
		@Column(name="pending_date")
		private Date pendingDate ;
	 	
	 	private String status;
	 	
	 	@Column(name="pending_area")
	 	private String practiceArea;
	 	
	 	@Column(name="client_ref_no")
	 	private String clientReferenceNo;
	 	
	 	@Column(name="resp_attorney")
	 	private String responsibleAttorney;
	 	
	 	@Column(name="location")
	 	private String location;
	 	
	 	
	 	
	 	
	 	

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getOpenDate() {
			return openDate;
		}

		public void setOpenDate(Date openDate) {
			this.openDate = openDate;
		}

		public Date getCloseDate() {
			return closeDate;
		}

		public void setCloseDate(Date closeDate) {
			this.closeDate = closeDate;
		}

		public Date getPendingDate() {
			return pendingDate;
		}

		public void setPendingDate(Date pendingDate) {
			this.pendingDate = pendingDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getPracticeArea() {
			return practiceArea;
		}

		public void setPracticeArea(String practiceArea) {
			this.practiceArea = practiceArea;
		}

		public String getClientReferenceNo() {
			return clientReferenceNo;
		}

		public void setClientReferenceNo(String clientReferenceNo) {
			this.clientReferenceNo = clientReferenceNo;
		}

		public String getResponsibleAttorney() {
			return responsibleAttorney;
		}

		public void setResponsibleAttorney(String responsibleAttorney) {
			this.responsibleAttorney = responsibleAttorney;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	 	
	 	
	 	
	 	

}
