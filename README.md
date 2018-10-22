# jobhunter



RestAPI calls currently supported

Will need to run data collection package first to store everything in the mysql database

returns all the listings

http://localhost:8080/job-hunt/joblist/all

returns listings with a specific type

http://localhost:8080/job-hunt/joblist/containstype?type=

returns listings with a specific location

http://localhost:8080/job-hunt/joblist/containslocation?location=

returns listings with a specific company

http://localhost:8080/job-hunt/joblist/containscompany?company=

returns listings with a specific title

http://localhost:8080/job-hunt/joblist/containstitle?title=

returns listings with a matching title

http://localhost:8080/job-hunt/joblist/matchtitle?title=

returns listings with a matching description

http://localhost:8080/job-hunt/joblist/matchdescription?description=