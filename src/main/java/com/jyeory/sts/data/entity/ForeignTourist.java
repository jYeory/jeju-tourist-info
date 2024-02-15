package com.jyeory.sts.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foreign_tourist")
public class ForeignTourist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx", nullable = false)
	private Integer id;

	@Column(name = "dtYearMonth", nullable = false, length = 6)
	private String dtYearMonth;

	@Column(name = "sightsName", nullable = false, length = 100)
	private String sightsName;

	@Column(name = "payType", nullable = false, length = 100)
	private String payType;

	@Column(name = "userCnt", nullable = false)
	private Integer userCnt;

}