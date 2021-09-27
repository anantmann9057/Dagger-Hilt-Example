package com.example.daggerhilt.data

data class Marvel(
	var copyright: String? = null,
	var code: String? = null,
	var data: Data? = null,
	var attributionHTML: String? = null,
	var attributionText: String? = null,
	var etag: String? = null,
	var status: String? = null
)

data class Data(
	val total: String? = null,
	val offset: String? = null,
	val limit: String? = null,
	val count: String? = null,
	val results: List<ResultsItem?>? = null
)

data class ItemsItem(
	val name: String? = null,
	val resourceURI: String? = null,
	val type: String? = null
)

data class Thumbnail(
	val path: String? = null,
	val extension: String? = null
)

data class ResultsItem(
	val urls: List<UrlsItem?>? = null,
	val thumbnail: Thumbnail? = null,
	val stories: Stories? = null,
	val series: Series? = null,
	val comics: Comics? = null,
	val name: String? = null,
	val description: String? = null,
	val modified: String? = null,
	val id: String? = null,
	val resourceURI: String? = null,
	val events: Events? = null
)

data class UrlsItem(
	val type: String? = null,
	val url: String? = null
)

data class Stories(
	val collectionURI: String? = null,
	val available: String? = null,
	val returned: String? = null,
	val items: List<ItemsItem?>? = null
)

data class Events(
	val collectionURI: String? = null,
	val available: String? = null,
	val returned: String? = null,
	val items: List<ItemsItem?>? = null
)

data class Series(
	val collectionURI: String? = null,
	val available: String? = null,
	val returned: String? = null,
	val items: List<ItemsItem?>? = null
)

data class Comics(
	val collectionURI: String? = null,
	val available: String? = null,
	val returned: String? = null,
	val items: List<ItemsItem?>? = null
)

