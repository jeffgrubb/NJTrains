# CityService

A lookup service for US Cities by lat/long location. Data provided by simplemaps.com. Data provided includes
all US zip code cities as of the 2010 census.

Using PostgreSQL as a datastore and Eclipse Jetty as an embedded web server.

Search url = /cities/search?lat=x&lon=Y&dist=d

where d = distance from x,y to filter results. Service returns US cities within d statute
miles of x latitude y longitude


