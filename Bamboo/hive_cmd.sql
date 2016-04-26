-- # All commands from the ISEP'15 Big Data Projetc

-- # Hcat is used to creat the external table
-- # load the whole folder of files
LOAD DATA INPATH '/user/panda/enernoc/' OVERWRITE INTO TABLE panda.all_records;

-- # ======== fillin time: s / bucket weight: / partion weight:

-- # depending of the scope of the studied we fill the work table

-- #######################################################################################
CREATE TABLE tibet.work_table_site_axis(
  datetime STRING,
  values ARRAY<FLOAT>
)
COMMENT 'Work table, values containe all sites measures for the same datetime.'
PARTITIONED BY (season STRING)
CLUSTERED BY(datetime) INTO 4 BUCKETS
ROW FORMAT DELIMITED   
FIELDS TERMINATED BY ','
STORED AS ORC;

-- # 

FROM view_work_table
INSERT OVERWRITE TABLE work_table_site_axis PARTITION (season)
SELECT dttm_utc AS datetime,
COLLECT_LIST(value) AS values
season(dttm_utc) AS season
GROUP BY dttm_utc ORDER BY dttm_utc;

-- ########### fillin time: 24:51s / lines: 105407 / bucket weight: / partion weight:

-- -------------------------------------------------------------------- ANSWER: QUESTION 1

SELECT datetime AS datetime, arraysum(values) AS total
FROM work_table_site_axis 
ORDER BY datetime;

-- time: 2:08s
-- stage: 1
-- nbr of lines: 105407 
|	datetime	|	total	|
---------------- -------------
|2015-01-01 00:	|	*****	|
|2015-01-01 01:	|	*****	|
|2015-01-01 02:	|	*****	|
-- ---------------------------------------------------------------------------------------

-- -------------------------------------------------------------------- ANSWER: QUESTION 3

SELECT getweek(datetime) AS week, SUM(arraysum(values)) AS total
FROM work_table_site_axis
GROUP BY getweek(datetime)
ORDER BY week;

-- time: 2:12s
-- stage: 1
-- nbr of lines: 105407 
|	datetime	|	total	|
---------------- -------------
|weeek nbr n	|	*****	|
|weeek nbr n+1	|	*****	|
|weeek nbr n+2	|	*****	|
-- ---------------------------------------------------------------------------------------

-- #######################################################################################

CREATE TABLE tibet.work_table_industry_axis(
  datetime STRING,
  values ARRAY<FLOAT>
)
COMMENT 'Work table, values containe all sites measures for the same industry,datetime.'
PARTITIONED BY (industry STRING)
CLUSTERED BY(datetime) INTO 25 BUCKETS
ROW FORMAT DELIMITED   
FIELDS TERMINATED BY ','
STORED AS ORC;

-- # fill the time based axis table

FROM view_work_table
INSERT OVERWRITE TABLE work_table_industry_axis PARTITION (industry)
SELECT dttm_utc AS dttm_utc,
COLLECT_LIST(value) AS values, 
industry AS industry
GROUP BY dttm_utc, industry  ORDER BY dttm_utc;

-- ######## fillin time: 38m88s / lines: 105407*4 / bucket weight: / partion weight:

-- -------------------------------------------------------------------- ANSWER: QUESTION 2
SELECT datetime AS datetime, industry AS sector, arrayavg(values) AS total
FROM work_table_industry_axis
ORDER BY datetime, sector;

-- time: 3:52s
-- stage: 2
-- nbr of lines: 105407 * 4
|	datetime	| 	sector 	|	total	|
---------------- ----------- -----------
|2015-01-01 00:	| Education	|	*****	|
|2015-01-01 01:	| Education	|	*****	|
|2015-01-01 02:	| Education	|	*****	|
-- ---------------------------------------------------------------------------------------

-- -------------------------------------------------------------------- ANSWER: QUESTION 4
SELECT getweek(datetime) AS week, industry AS sector, AVG(arrayavg(values)) AS total
FROM work_table_industry_axis
GROUP BY industry, getweek(datetime)
ORDER BY week; 

-- time: 3:58s
-- stage: 1
-- nbr of lines: 105407 
|	datetime	| 	sector 	|	total	|
---------------- ----------- -----------
|weeek nbr n	| Education	|	*****	|
|weeek nbr n+1	| Education	|	*****	|
|weeek nbr n+2	| Education	|	*****	|
-- ---------------------------------------------------------------------------------------


CREATE TABLE tibet.work_table_day_axis(
  date STRING,
  season STRING,
  value FLOAT,
  site_id STRING,
  sub_industry STRING, 
  sq_ft BIGINT,
  lat FLOAT,
  lng FLOAT 
)
COMMENT 'Work table, value col correspond to one day/site.'
PARTITIONED BY (industry STRING)
CLUSTERED BY(site_id) INTO 25 BUCKETS
ROW FORMAT DELIMITED   
FIELDS TERMINATED BY ','
STORED AS ORC;


FROM all_sites JOIN ( SELECT
  to_date(dttm_utc) AS date,
  SUM(value) AS value, filename(INPUT__FILE__NAME) AS site_id FROM all_records
  GROUP BY filename(INPUT__FILE__NAME), to_date(dttm_utc) ORDER BY date
  ) 
AS tab ON tab.site_id  = all_sites.site_id
INSERT OVERWRITE TABLE work_table_day_axis PARTITION (industry)
SELECT tab.date AS date,
season(tab.date) AS season,
tab.value AS value,
tab.site_id AS site_id,
all_sites.sub_industry AS sub_industry, 
all_sites.sq_ft AS sq_ft, 
all_sites.lat AS lat, 
all_sites.lng AS lng,
all_sites.industry AS industry
ORDER BY date, site_id;

-- ########### fillin time: 16:38s / lines: 365 * 100 / stage: 5 

-- -------------------------------------------------------------------- ANSWER: QUESTION 5

SELECT industry, SUM(value/sq_ft) AS ratio FROM work_table_day_axis 
GROUP BY industry 
ORDER BY ratio;

-- time: 3:32s
-- stage: 2
-- nbr of lines: 4
|	industry	|	ratio	|
---------------- -------------
|weeek nbr n	|	*****	|
|weeek nbr n+1	|	*****	|
|weeek nbr n+2	|	*****	|
-- ---------------------------------------------------------------------------------------


-- ----------------------------------------------------------------- ANSWER: QUESTION 5BIS

SELECT industry, season(date) AS season, SUM(value/sq_ft) AS ratio
FROM work_table_day_axis  GROUP BY industry, season(date)
ORDER BY ratio;

-- time: 3:48s
-- stage: 2
-- nbr of lines: 16
|	industry	|	season 	|	ratio 	|
---------------- ----------- -------------
|   Education	|  WINTER	|	*****	|
|	   ...		|  SUMMER	|	*****	|
|	   ...		|  SPRING	|	*****	|
-- ---------------------------------------------------------------------------------------

-- -------------------------------------------------------------------- ANSWER: QUESTION 6

SELECT industry, ratio(value, sq_ft) AS ratio FROM work_table_day_axis 
GROUP BY industry ORDER BY industry;


-- time: 3:03s
-- stage: 2
-- nbr of lines: 4 
|	industry	|	ration 	|
---------------- -------------
|   Education	|	*****	|
|	   ...		|	*****	|
|	   ...		|	*****	|
-- ---------------------------------------------------------------------------------------

-- ----------------------------------------------------------------- ANSWER: QUESTION 6BIS

SELECT industry, ratio(value, sq_ft) AS ratio, season FROM work_table_day_axis 
GROUP BY industry, season ORDER BY season;


-- time: 3:42s
-- stage: 2
-- nbr of lines: 16 
|	industry	|	season 	|	ratio 	|
---------------- ----------- -------------
|   Education	|  WINTER	|	*****	|
|	   ...		|  SUMMER	|	*****	|
|	   ...		|  SPRING	|	*****	|
-- --------------------------------------------------------------------------------------

-- -------------------------------------------------------------------- ANSWER: QUESTION 7
-- SELECT site_id, MAX(value) AS maximun FROM work_table_day_axis 
-- GROUP BY site_id ORDER BY site_id;

FROM (SELECT MAX(value) AS maximum, site_id AS id FROM work_table_day_axis GROUP BY site_id) AS tbl 
JOIN work_table_day_axis ON work_table_day_axis.site_id = tbl.id
SELECT tbl.id, work_table_day_axis.date, tbl.maximum WHERE site_id = tbl.id and value= tbl.maximum;

-- time: 4:39s
-- stage: 3
-- nbr of lines: 100
|	    id		|	 max 	|
---------------- -------------
|		1		|	*****	|
|		2		|	*****	|
|		3		|	*****	|
-- ---------------------------------------------------------------------------------------




CREATE VIEW view_<description>(
 field1,
 field2,
 field3,
 ...
) AS SELECT (<your query>)
-- # to get the solution we simply perform a SELECT * FROM <my_view>


analyze table work_table_site_axis partition(season) compute statistics;
analyze table work_table_day_axis partition(industry) compute statistics;
analyze table work_table_day_axis partition(industry) compute statistics;

-- # Util fonctions
DROP TEMPORARY FUNCTION [function_name];
-- DELETE JAR Bamboo-0.0.1-SNAPSHOT.jar;
DESCRIBE EXTENDED work_table_records;
DESCRIBE FORMATTED work_table_records;

--DROP TEMPORARY FUNCTION getweek;
--DROP TEMPORARY FUNCTION getday;
--DROP TEMPORARY FUNCTION filename;
--DROP TEMPORARY FUNCTION season;
--DROP TEMPORARY FUNCTION sumover;
--DROP TEMPORARY FUNCTION avgover;

-- ### IMPORT JARS
-- % filename
-- % org.isep.pandas.udf.FileName

-- % getweek
-- % org.isep.pandas.udf.Week

-- % getday
-- % org.isep.pandas.udf.Day

-- % season
-- % org.isep.pandas.udf.Season

-- % arraysum
-- % org.isep.pandas.udf.ArraySum

-- % arrayavg
-- % org.isep.pandas.udf.ArrayAvg

-- % sumover
-- % org.isep.pandas.udaf.SumOver