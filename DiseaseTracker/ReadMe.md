##Disease Tracker

###Description:
There are many Wars with disease fought all over the world. For example, in the past war with
virus like Ebola, Zika, Spanish Flu etc were reported and they spread over multiple countries.
The most recent case is Covid-19 which has affected around 190 countries and is spreading
very fast among the world population.

These diseases usually start from one region and spread through various human/animal
interactions in other regions. However there can be some like famine, hunger, cancer etc which
can start in unrelated places.

Governments all over the world want to control the spread of diseases by taking appropriate
measures for which they need to track the disease at regional level first.
You are required to create a tracker tool which will help to track the diseases.


###Features:

1. Should be able to track multiple Disease Wars.
2. Should be able to capture Affected cases at country, state.
3. One individual can be infected with multiple diseases at a time
4. Should be able to capture cured cases for diseases as well as fatality cases.
5. Should be able to show stats at multiple levels (state/country/global) in an anonymized
manner.

 - Total count = person Affected + person recovered + person passed due to same
disease + person passed due to different war with disease
6. Should be able to show stats at disease level in an anonymized manner.

a. Total count = person Affected + person recovered + person passed due to same
disease + person passed due to different war with disease
Bonus Feature:
7. or admins, details to be available in non-anonymized manner. No access control
expected for admin and non admin, it can be on the basis of input.

###Requirements:
8. Onboard different incidents (name, type, infectionType, transmission type etc)
9. Report as positive case in the tracker with required info, demographics like
(diseaseType, IndividualId, region)
10. Report a cured/fatality case in the tracker: (diseaseType, IndividualDetails, region)
11. Show stats at different levels as in feature 5.
12. For edge cases like having an individual involved in multiple wars getting passed please
count for all the diseases.

###Bonus question:
13. Show non-anonymized reports to area managers for the same area and anonymized for
others.
14. Tracker should be able to show stats for a given country: country level summary, state
wise breakup summary. Show state wise breakup summary for a given disease in a
country
Other Details:
15. Do not use any database or NoSQL store, use the in-memory store for now.
16. Do not create any UI for the application.
17. Write a driver class for the demo purposes. Which will execute all the commands at one
place in the code and test cases.
18. Please prioritize code compilation, execution, and completion.
19. Work on the expected output first and then add good-to-have features of your own.
20. You can choose whatever input format you want as long as all the input parameters are
