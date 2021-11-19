package com.studentapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Data
@Getter
@Setter
@ToString
@Entity
public class Projects {

	@Id
	private String projid;
	private String projname;
private int durationInmonth;
}
