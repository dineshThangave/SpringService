package com.application.bean;
// Generated Feb 4, 2016 1:30:06 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserContact generated by hbm2java
 */
@Entity
@Table(name="user_contact"
    ,catalog="android"
)
public class UserContact  implements java.io.Serializable {


     private Integer pk;
     private ContactType contactType;
     private UserDetails userDetails;
     private String phoneNo;
     private String emailId;
     private boolean phoneVerified;
     private boolean emailIdVerified;
     private String facebookId;
     private Date createdTime;
     private Date updateTime;
     private boolean active;

    public UserContact() {
    }

    public UserContact(ContactType contactType, UserDetails userDetails, String phoneNo, String emailId, boolean phoneVerified, boolean emailIdVerified, String facebookId, Date createdTime, Date updateTime, boolean active) {
       this.contactType = contactType;
       this.userDetails = userDetails;
       this.phoneNo = phoneNo;
       this.emailId = emailId;
       this.phoneVerified = phoneVerified;
       this.emailIdVerified = emailIdVerified;
       this.facebookId = facebookId;
       this.createdTime = createdTime;
       this.updateTime = updateTime;
       this.active = active;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="pk", unique=true, nullable=false)
    public Integer getPk() {
        return this.pk;
    }
    
    public void setPk(Integer pk) {
        this.pk = pk;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="contact_type_fk", nullable=false)
    public ContactType getContactType() {
        return this.contactType;
    }
    
    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_details_fk", nullable=false)
    public UserDetails getUserDetails() {
        return this.userDetails;
    }
    
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    
    @Column(name="phone_no", nullable=false, length=300)
    public String getPhoneNo() {
        return this.phoneNo;
    }
    
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    
    @Column(name="email_id", nullable=false, length=300)
    public String getEmailId() {
        return this.emailId;
    }
    
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    
    @Column(name="phone_verified", nullable=false)
    public boolean isPhoneVerified() {
        return this.phoneVerified;
    }
    
    public void setPhoneVerified(boolean phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    
    @Column(name="email_id_verified", nullable=false)
    public boolean isEmailIdVerified() {
        return this.emailIdVerified;
    }
    
    public void setEmailIdVerified(boolean emailIdVerified) {
        this.emailIdVerified = emailIdVerified;
    }

    
    @Column(name="facebook_id", nullable=false, length=300)
    public String getFacebookId() {
        return this.facebookId;
    }
    
    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_time", nullable=false, length=19)
    public Date getCreatedTime() {
        return this.createdTime;
    }
    
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_time", nullable=false, length=19)
    public Date getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    
    @Column(name="active", nullable=false)
    public boolean isActive() {
        return this.active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }




}

