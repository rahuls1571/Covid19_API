# Covid19_API

Here we are using someone else API (Volley) paulsmithkc.



In this project, I made this API to Fetch covid19india.org server data In Which contain :
{
	
	1). Covid State(Only contain India state data ) and Countries Data.
	2). Here Data Update Every 1hr per day.
	3). In-State u can fetch State name, active cases, recovered cases, confirmed, death cases Data.
	4). In-Countries u can fetch Flags, names, country cases, Today cases, death cases, today death cases, recovered cases Data.
	5). This API is easy to use and user friendly.
	
	
}


Setp 1 : Add it in your root build.gradle at the end of repositories :

allprojects
{
	
	repositories
		{
			...
			maven { url 'https://jitpack.io' }
		}
}
  
Step 2: Add the dependency :

	dependencies
 	 	{
	        implementation 'com.github.rahuls1571:Covid19_API:1.0.0'
		}
	
