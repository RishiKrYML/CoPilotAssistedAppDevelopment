//
//  ViewController.swift
//  MovieList
//
//  Created by Madan AR on 19/02/23.
//

import UIKit

class ViewController: UIViewController {

   private var movies = [Movie]()
   private var tableView = UITableView()
   private let movieProvider = MovieProvider()

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        configureTableView()
        addSubview()
        fetchMovies()
    }

    // configure table view
    private func configureTableView() {
        tableView.delegate = self
        tableView.dataSource = self
        tableView.register(MovieCell.self, forCellReuseIdentifier: MovieCell.reuseIdentifier)
    }

    private func addSubview() {
        view.addSubview(tableView)

        tableView.translatesAutoresizingMaskIntoConstraints = false
        tableView.topAnchor.constraint(equalTo: view.topAnchor).isActive = true
        tableView.leadingAnchor.constraint(equalTo: view.leadingAnchor).isActive = true
        tableView.trailingAnchor.constraint(equalTo: view.trailingAnchor).isActive = true
        tableView.bottomAnchor.constraint(equalTo: view.bottomAnchor).isActive = true

    }

    // fetch movies from the api
    private func fetchMovies() {
        movieProvider.fetchMovies { [weak self] movies in
            self?.movies = movies
            self?.tableView.reloadData()
        }
    }
}

extension ViewController: UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return movies.count
    }

    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
       let cell = tableView.dequeueReusableCell(withIdentifier: MovieCell.reuseIdentifier, for: indexPath) as! MovieCell
       movieProvider.fetchImage(from: movies[indexPath.row].posterURL) { image in
           DispatchQueue.main.async {
               cell.configure(with: self.movies[indexPath.row].title, posterImage: image)
           }
         }
        return cell
    }

    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        100
    }
}

