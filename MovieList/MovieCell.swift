// create table view cell to display movie title and poster image with parameters title and posterImage
// Compare this snippet from MovieList/MovieCell.swift

import UIKit

class MovieCell: UITableViewCell {
    private let titleLabel = UILabel()
    private let posterImageView = UIImageView()
    static let reuseIdentifier = "cell"
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        configureTitleLabel()
        configurePosterImageView()
        addSubview()
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func configureTitleLabel() {
        titleLabel.numberOfLines = 0
        titleLabel.font = UIFont.preferredFont(forTextStyle: .title1)
    }
    
    private func configurePosterImageView() {
        posterImageView.contentMode = .scaleToFill
        posterImageView.frame = CGRect(x: 0, y: 0, width: 100, height: 100)
    }
    
    private func addSubview() {
        contentView.addSubview(titleLabel)
        contentView.addSubview(posterImageView)

        titleLabel.translatesAutoresizingMaskIntoConstraints = false
        titleLabel.topAnchor.constraint(equalTo: contentView.topAnchor).isActive = true
        titleLabel.leadingAnchor.constraint(equalTo: contentView.leadingAnchor).isActive = true
        titleLabel.widthAnchor.constraint(equalToConstant: 250).isActive = true
        titleLabel.bottomAnchor.constraint(equalTo: contentView.bottomAnchor).isActive = true

        posterImageView.translatesAutoresizingMaskIntoConstraints = false
        posterImageView.topAnchor.constraint(equalTo: contentView.topAnchor).isActive = true
        posterImageView.leadingAnchor.constraint(equalTo: titleLabel.trailingAnchor).isActive = true
        posterImageView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor).isActive = true
        posterImageView.bottomAnchor.constraint(equalTo: contentView.bottomAnchor).isActive = true
    }
    
    func configure(with title: String, posterImage: UIImage?) {
        titleLabel.text = title
        posterImageView.image = posterImage
    }
}







