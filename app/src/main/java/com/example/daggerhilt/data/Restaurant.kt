package com.example.daggerhilt.data

data class Restaurant(
	val uid: String? = null,
	val hours: Hours? = null,
	val address: String? = null,
	val review: String? = null,
	val name: String? = null,
	val description: String? = null,
	val logo: String? = null,
	val phoneNumber: String? = null,
	val id: Int? = null,
	val type: String? = null
)

data class Wednesday(
	val opensAt: String? = null,
	val closesAt: String? = null,
	val isClosed: Boolean? = null
)

data class Friday(
	val opensAt: String? = null,
	val closesAt: String? = null,
	val isClosed: Boolean? = null
)

data class Saturday(
	val opensAt: String? = null,
	val closesAt: String? = null,
	val isClosed: Boolean? = null
)

data class Sunday(
	val opensAt: String? = null,
	val closesAt: String? = null,
	val isClosed: Boolean? = null
)

data class Thursday(
	val opensAt: String? = null,
	val closesAt: String? = null,
	val isClosed: Boolean? = null
)

data class Hours(
	val sunday: Sunday? = null,
	val saturday: Saturday? = null,
	val tuesday: Tuesday? = null,
	val wednesday: Wednesday? = null,
	val thursday: Thursday? = null,
	val friday: Friday? = null,
	val monday: Monday? = null
)

data class Tuesday(
	val opensAt: String? = null,
	val closesAt: String? = null,
	val isClosed: Boolean? = null
)

data class Monday(
	val opensAt: String? = null,
	val closesAt: String? = null,
	val isClosed: Boolean? = null
)

