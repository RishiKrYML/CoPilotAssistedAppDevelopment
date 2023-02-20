// write movie provider to fetch movies from the "https://api.sampleapis.com/movies/animation" api

// Path: MovieList/MovieProvider.swift

import Foundation
import UIKit

class MovieProvider {
    
    func fetchMovies(completion: @escaping ([Movie]) -> Void) {
        guard let url = URL(string: "https://api.sampleapis.com/movies/animation") else {
            return
        }
        
        URLSession.shared.dataTask(with: url) { data, _, _ in
            guard let data = data else {
                return
            }
            
            let movies = try! JSONDecoder().decode([Movie].self, from: data)
      
            DispatchQueue.main.async {
                completion(movies)
            }
        }.resume()
    }

    func fetchImage(from url: String, completion: @escaping (UIImage?) -> Void) {
        guard let url = URL(string: url) else {
            return
        }
        
        URLSession.shared.dataTask(with: url) { data, _, _ in
            guard let data = data else {
                return
            }
            
            let image = UIImage(data: data)
            
            DispatchQueue.main.async {
                completion(image)
            }
        }.resume()
    }
}