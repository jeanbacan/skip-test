/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skip.service.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NaturalId;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "customer_generator", sequenceName = "customer_sequence", initialValue = 28)
	@GeneratedValue(generator = "customer_generator")
	private Long id;

	@Column(nullable = false)
	@NaturalId
	private String name;
	
	@Column(nullable = false)
	@NaturalId
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date creation;
	
	@Column(nullable = false)
	@NaturalId
	private String password;

	protected Customer() {
	}

	public Customer(Long id, String name, String email, String address, Date creation, String password) {
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Date getCreation() {
		return creation;
	}

	public String getPassword() {
		return password;
	}

}
