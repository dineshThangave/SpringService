package com.application.bean;
// Generated Feb 4, 2016 1:30:06 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserLogin generated by hbm2java
 */
@Entity
@Table(name="user_login"
    ,catalog="android"
)
public class UserLogin  implements java.io.Serializable {


     private Integer pk;
     private String userName;
     private String password;
     private Date createdTime;
     private boolean active;
     private Date lastActiveTime;
     private Date updatedTime;
//     private Set userDetailses = new HashSet(0);

    public UserLogin() {
    }

	
    public UserLogin(String userName, String password, Date createdTime, boolean active, Date updatedTime) {
        this.userName = userName;
        this.password = password;
        this.createdTime = createdTime;
        this.active = active;
        this.updatedTime = updatedTime;
    }
    public UserLogin(String userName, String password, Date createdTime, boolean active, Date lastActiveTime, Date updatedTime, Set userDetailses) {
       this.userName = userName;
       this.password = password;
       this.createdTime = createdTime;
       this.active = active;
       this.lastActiveTime = lastActiveTime;
       this.updatedTime = updatedTime;
//       this.userDetailses = userDetailses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="pk", unique=true, nullable=false)
    public Integer getPk() {
        return this.pk;
    }
    
    public void setPk(Integer pk) {
        this.pk = pk;
    }

    
    @Column(name="user_name", nullable=false, length=300)
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    @Column(name="password", nullable=false, length=300)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="created_time", nullable=false, length=10)
    public Date getCreatedTime() {
        return this.createdTime;
    }
    
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    
    @Column(name="active", nullable=false)
    public boolean isActive() {
        return this.active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_active_time", length=19)
    public Date getLastActiveTime() {
        return this.lastActiveTime;
    }
    
    public void setLastActiveTime(Date lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_time", nullable=false, length=19)
    public Date getUpdatedTime() {
        return this.updatedTime;
    }
    
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

//@OneToMany(fetch=FetchType.LAZY, mappedBy="userLogin")
//    public Set getUserDetailses() {
//        return this.userDetailses;
//    }
//    
//    public void setUserDetailses(Set userDetailses) {
//        this.userDetailses = userDetailses;
//    }




}


