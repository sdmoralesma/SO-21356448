SO-21356448
===========

This project tries to resolve some issues related to extended persistence context and stateful beans. This is the question : http://stackoverflow.com/questions/21356448/jpa-entity-found-by-find-in-a-stateful-ejb-extended-is-not-managed/21415276

SetUp:

- Glassfish 4 / 3.1.2.2
- Java EE 6/7


If you have a problem connecting to JavaDB check this:
http://stackoverflow.com/questions/21154400/unable-to-start-derby-database-from-netbeans-7-4

-UPDATE 1: Checking this example looks like GF4 is not following the spec.

-UPDATE 2: Glassfish team will release a patch for next GF version> https://java.net/jira/browse/GLASSFISH-20968
