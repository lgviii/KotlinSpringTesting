package com.reference.testing

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "ACCOUNT")
data class ToDoListItems(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 1,
	val name: String = "",
	val balance: BigDecimal = BigDecimal(0))
