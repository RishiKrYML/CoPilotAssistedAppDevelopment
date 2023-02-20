// create a data model for movie with properties id, title, posterUrl
struct Movie: Identifiable, Codable {
    let id: Int
    let title: String
    let posterURL: String
}
