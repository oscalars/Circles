CREATE TABLE Login                  --Detta känns enklast att göra för att hantera inloggningen.
(                              --Så när en user skapas läggs dom först till här, sen i users tablet.
    username TEXT PRIMARY KEY,
    hash     BYTEA NOT NULL,
    salt     BYTEA NOT NULL
);

CREATE TABLE Users (
    username TEXT PRIMARY KEY,
    darkmode BOOLEAN DEFAULT FALSE
    --Vad mer kan vi tänkas behöva lagra här? Kommer inte på något just nu.
    --Att ta fram cirklar som en user är med i, gör vi ju genom att filtrera ut från CircleMembers där
    --användaren finns med.
);

CREATE TABLE Circles
(
    id INT PRIMARY KEY,
    name TEXT NOT NULL,         ---Enklare att hantera enskilda medlemmar genom att ha dom i eget table.
    creator TEXT NOT NULL,      ---Samma sak gäller för filmer. Enklare att ha separat table istället för listor.
    timestart TEXT NOT NULL,
    timeend TEXT NOT NULL
);

CREATE TABLE Movies
(
    name TEXT,
    id INT UNIQUE NOT NULL,
    description TEXT NOT NULL,
    year INT NOT NULL,
    posterURL TEXT DEFAULT '',
    PRIMARY KEY (name, year)
);

CREATE TABLE CircleMembers
(
    id INT,
    member TEXT,
    PRIMARY KEY (id, member),
    FOREIGN KEY (id) REFERENCES Circles(id)
);

CREATE TABLE MovieInCircle
(                               --Tänker en view för att med ett query få fram en cirkels alla filmer.
    circleid INT,               --Update nedan :-)
    movieid INT,
    PRIMARY KEY(circleid, movieid),
    FOREIGN KEY (circleid) REFERENCES Circles(id),
    FOREIGN KEY (movieid) REFERENCES Movies(id)
);

CREATE VIEW CircleMovies AS
    SELECT circleid, Circles.name AS circle_name, movieid, movie_name, description, year, posterURL
    FROM Circles LEFT OUTER JOIN
        (SELECT circleid, movieid, name AS movie_name, description, year, posterURL
        FROM Movieincircle LEFT OUTER JOIN Movies
ON movieid = Movies.id) As w
    ON w.circleid = Circles.id;