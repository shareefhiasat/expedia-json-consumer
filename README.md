Sorry if i forgot anything , but i doubt it.

#Check On Heroku
https://expedia-json-consumer.herokuapp.com/ i hope its still up. :)

#How to Run On Your Local SandBox
1. Following Heroku ( Optional ).
2. Install JDK 1.8 , it was developed by.
3. I Used <b>Intellij</b> its awesome.
4. Run `public static void main(String[] args) throws Exception {
                      SpringApplication.run(MainEmulation.class, args);
                  }`

5. go to http://localhost:5000 
(If you use heroku to run and build 5000 is default)
you can change from application.properties
`server.port=5000`

6. You Can Run Junit Tests, but keep in mind the database test will work
only if you configure it from `application.local.properites` rename it to
`application.properites` and change url/user/pass/driver(its mysql default) etc...
and un comment the code where the comment
`enable below in local sandbox if you want db test` exists.

7. for junit cases for testing API calls , i made upon public
expedia url which may change due to data changes
i recommend to run it on local database with predefiend known state
to have stable reliable expected results. but which i dont have ;D.
            
8. clone the project (https://github.com/shareefhiasat/expedia-json-consumer)
9. mvn clean install    /*import mavent dependencies*/ 
10. run via IDE or `heroku local:start` or `heroku local:web`

# What i learned ?

1) Spring Theme Leaf
2) Reflection in details designing
3) Designing Json facilities, architecture
4) Differences in json libraries and when to use each one
http://blog.takipi.com/the-ultimate-json-library-json-simple-vs-gson-vs-jackson-vs-json/
5) Spring Boot.
6) Googling and resolving more exception.

# What i would have learned if i had more time ?
1. learn bootstrap testing
https://alvinalexander.com/java/jwarehouse/netty-4.1/transport/src/test/java/io/netty/bootstrap/BootstrapTest.java.shtml

2. I tried jersey-client.jar
http://www.mkyong.com/webservices/jax-rs/restful-java-client-with-jersey-client/

3. More about spring boot.



# What Expedia Should Know ?

1.<b>Question</b> 1: how much you <b>Expedia</b> trust your responses?

<b>Details:</b>
mean who dose insert hotem description are there security checks for 
scripts and injections ? because when i escaped your response that has
™,℠ etc.. it got escaped so it showed as &trad; and i disabled 
html escaping on your jsons which is not so heatly isnt it ?

2.<b>Question</b> 2: since the data changes in the offers API, how much
performance will be affected if some one made <b>millions of calls</b> 
to your API.

3.<b>Question</b> 3: One of the API says we should do this with <b>colon</b>
//todo ASK expedia the link in github is wrong it sends one of the parameters as &minTripStartDate=:2000-05-03 we must remove the colon so it works

4.<b>Question</b> 3: am just curious ; what is drr?

# What Improvment can be done ?

1) I would try this next time :) <b>boon JSON APi</b>
  is faster than gson
  https://plus.google.com/108227213807945109821/posts/3FN38bTVqcA

2) I would <b>add</b> some <b>interceptors</b> for security reasons checks.

3) I would defenitly try to <b>improve and fix anti patterns</b>
in my <b>static</b> methods , into injectable beans , and services.

4) I would apply and <b>activate spring profiles</b> 
http://www.baeldung.com/spring-testing-separate-data-source

5) I would <b>Remove Constants</b> into properties files
http://www.baeldung.com/spring-testing-separate-data-source

6) If i would work with databases i would apply JNDI to avoid
memory leaks.

7) Apply Design patter commander and strategy for the different API
calls to be more maintainable and testable.

# java-getting-started

[![CircleCI](https://circleci.com/gh/heroku/java-getting-started.svg?style=svg)](https://circleci.com/gh/heroku/java-getting-started)

A barebones Java app, which can easily be deployed to Heroku.

This application supports the [Getting Started with Java on Heroku](https://devcenter.heroku.com/articles/getting-started-with-java) article - check it out.

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

## Running Locally

Make sure you have Java and Maven installed.  Also, install the [Heroku CLI](https://cli.heroku.com/).

```sh
$ git clone https://github.com/heroku/java-getting-started.git
$ cd java-getting-started
$ mvn install
$ heroku local:start
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

If you're going to use a database, ensure you have a local `.env` file that reads something like this:

```
DATABASE_URL=postgres://localhost:5432/java_database_name
```

## Deploying to Heroku

```sh
$ heroku create
$ git push heroku master
$ heroku open
```

## Documentation

For more information about using Java on Heroku, see these Dev Center articles:

- [Java on Heroku](https://devcenter.heroku.com/categories/java)
