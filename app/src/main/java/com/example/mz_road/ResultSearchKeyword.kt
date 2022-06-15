package com.example.mz_road

data class ResultSearchKeyword(
    var documents: List<Place> // 검색 결과
)

data class Place(
    var place_name: String, // 장소명, 업체명
    var address_name: String, // 전체 지번 주소
    var road_address_name: String, // 전체 도로명 주소


)


