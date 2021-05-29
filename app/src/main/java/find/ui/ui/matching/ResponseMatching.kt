package find.ui.ui.matching

data class ResponseMatching(
    val userSequence: Int,
    val profileImageUrl: String,
    val nickName: String,
    val age: Int,
    val job: String,
    val location: String,
    val directMessage: String
)
