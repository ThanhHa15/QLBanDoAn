package com.asm.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //Tự động tạo getter, setter, constructor.
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE) //Ngày tạo đơn hàng, mặc định là ngày hiện tại).
	@Column(name = "createdate")
	private Date createDate = new Date();
	private String address;

	@ManyToOne
	@JoinColumn(name = "username") //mỗi đơn hàng thuộc về một tài khoản 
	private Account account;

	@JsonIgnore
	@OneToMany(mappedBy = "order") //Một đơn hàng có thể chứa nhiều chi tiết đơn hàng.
	private List<OrderDetail> orderDetails;
}
