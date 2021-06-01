package find.ui.ui.found

data class ResponseFound(
    val userSequence: Int,
    val profileImageUrl: String,
    val nickName: String,
    val age: Int,
    val job: String,
    val company: String,
    val location: String,
    val directMessage: String
)
