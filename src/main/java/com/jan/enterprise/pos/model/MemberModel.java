package com.jan.enterprise.pos.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Jinendra Bakliwal
 *
 */
@Data 
@Entity
@Table(name = "jan_member")
@EqualsAndHashCode (callSuper = false)
public class MemberModel extends BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int memberId;
	
	private String member_First_Name;
	private String member_Last_Name;
	private String member_Middle_Name;
	private String username;
	@Column(length = 60)
	private String password;
	private String address_Line_1;
	private String tehsil;
	private String district;
	private String state;
	private String zip;
	private String mobile;
	private String email;
	private String notes;
	private int memberTypeId;
	private boolean isUsing2FA;
	private String secret;
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "jan_member_roles", joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "memberId"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Collection<Role> roles;
	
    @OneToOne(targetEntity = ShopMasterModel.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id", foreignKey = @ForeignKey(name = "FK_SHOP_MASTER"))
    private ShopMasterModel shopMasterModel;

//    public User() {
//        super();
//        this.secret = Base32.random();
//        this.enabled = false;
//    }


//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = (prime * result) + ((email == null) ? 0 : email.hashCode());
//        return result;
//    }
//
//    @Override
//    public boolean equals(final Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final User user = (User) obj;
//        if (!email.equals(user.email)) {
//            return false;
//        }
//        return true;
//    }

//    @Override
//    public String toString() {
//        final StringBuilder builder = new StringBuilder();
//        builder.append("User [id=").append(id).append(", firstName=").append(firstName).append(", lastName=").append(lastName).append(", email=").append(email).append(", password=").append(password).append(", enabled=").append(enabled).append(", isUsing2FA=")
//                .append(isUsing2FA).append(", secret=").append(secret).append(", roles=").append(roles).append("]");
//        return builder.toString();
//    }
}
