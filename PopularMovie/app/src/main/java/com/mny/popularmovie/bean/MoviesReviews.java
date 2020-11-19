package com.mny.popularmovie.bean;

import java.util.List;

public class MoviesReviews {

    /**
     * id : 531219
     * page : 1
     * results : [{"author":"TinyLilRobot","content":"A lot was changed in this remake and I thought it would irk me. After about twenty minutes I thought I had been wrong, the opening had some originality and it seemed like something fresh. then they arrived at the Hotel and Anne Hathaway came on the scene like a wrecking ball. Any potential that this movie had was suffocated by Hathaways incredibly poor performance. Watch Anjelica Huston's performance in the original and you will see the MASSIVE difference in ability. Hathaway's performance is akin to an amateur impressionist. It feel more like an insult than an homage by Hathaway, she put zero effort or spirit into this character. Her accent is atrocious and her presence is almost nonexistent. Also the CGI already looks cheap, c'mon they had better puppets in the 80's. All witches now have joker smiles and shark teeth? This could've really been a good movie and it is just marred by an extremely poor performance from the lead villain, an overuse of cheap effects, poor pacing, lack of originality in the second half and a horrendous ending. The only highlights of this movie are Octavia Spencer and Jahzir Bruno who do a fantastic job of filling and updating their roles. Unfortunately as most fans know, Jahzir spends the second half of the movie as a poorly CGI'd mouse. Leaving Octavia Spencer to carry the entirety of the movie from there on out almost seems like a cruel prank. Tucci is decent as is Codie Eastwick as Bruno but there characters are so poorly written and used they practically add nothing. The addition of a third mouse is also meaningless and changes nothing in the story. Ultimately this movie is a far worse version of the first one. They actually managed to tell less of the story, give characters less development, and have worse effects than a movie made over 30 years ago. Some of this may have been forgivable if they added any decent original concepts but again this is a poor retread with no added substance. Its disheartening to see so many big names attached to this film. Guillermo Del Toro should not put this on his IMBD page. Of course your children will like it, they like Peppa Pig.","id":"5f9befe390ea4b00397d9b3b","url":"https://www.themoviedb.org/review/5f9befe390ea4b00397d9b3b"},{"author":"SWITCH.","content":"When you hear the names Robert Zemeckis, Guillermo del Toro and Alfonso Cuaron, you expect something visually engaging. These three names paired with Dahl's work could have been something really special, but this is just another bland adaption. The more you compare it to both the source material and previous adaptions, it comes across as bland and missing the mark. The same could be said about the star-studded cast led by Hathaway and Octavia Spencer, with Stanley Tucci playing the forgettable hotel owner. This team really could have made something unique, but this is not it, witch. - Chris dos Santos  Read Chris' full article... https://www.maketheswitch.com.au/article/review-the-witches-horrifying-for-all-the-wrong-reasons","id":"5f9d1dbcbc8abc003830e4fa","url":"https://www.themoviedb.org/review/5f9d1dbcbc8abc003830e4fa"}]
     * total_pages : 1
     * total_results : 2
     */

    private int id;
    private int page;
    private int total_pages;
    private int total_results;
    private List<ResultsBean> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * author : TinyLilRobot
         * content : A lot was changed in this remake and I thought it would irk me. After about twenty minutes I thought I had been wrong, the opening had some originality and it seemed like something fresh. then they arrived at the Hotel and Anne Hathaway came on the scene like a wrecking ball. Any potential that this movie had was suffocated by Hathaways incredibly poor performance. Watch Anjelica Huston's performance in the original and you will see the MASSIVE difference in ability. Hathaway's performance is akin to an amateur impressionist. It feel more like an insult than an homage by Hathaway, she put zero effort or spirit into this character. Her accent is atrocious and her presence is almost nonexistent. Also the CGI already looks cheap, c'mon they had better puppets in the 80's. All witches now have joker smiles and shark teeth? This could've really been a good movie and it is just marred by an extremely poor performance from the lead villain, an overuse of cheap effects, poor pacing, lack of originality in the second half and a horrendous ending. The only highlights of this movie are Octavia Spencer and Jahzir Bruno who do a fantastic job of filling and updating their roles. Unfortunately as most fans know, Jahzir spends the second half of the movie as a poorly CGI'd mouse. Leaving Octavia Spencer to carry the entirety of the movie from there on out almost seems like a cruel prank. Tucci is decent as is Codie Eastwick as Bruno but there characters are so poorly written and used they practically add nothing. The addition of a third mouse is also meaningless and changes nothing in the story. Ultimately this movie is a far worse version of the first one. They actually managed to tell less of the story, give characters less development, and have worse effects than a movie made over 30 years ago. Some of this may have been forgivable if they added any decent original concepts but again this is a poor retread with no added substance. Its disheartening to see so many big names attached to this film. Guillermo Del Toro should not put this on his IMBD page. Of course your children will like it, they like Peppa Pig.
         * id : 5f9befe390ea4b00397d9b3b
         * url : https://www.themoviedb.org/review/5f9befe390ea4b00397d9b3b
         */

        private String author;
        private String content;
        private String id;
        private String url;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
