# Covid19_API

Here I am are using someone else API (Volley) paulsmithkc and the license is given in the project.
I am trying to build a Library that Is easy for the beginner to fetch the Covid-19 data and build App this is my first library for Android Studio.

In this library, I made this Library to Fetch covid19india.org API data In Which it contain :
{
	
	1). Covid State(Only contain India state data ) and Countries Data.
	2). Here Data Update Every 1hr per day.
	3). In-State u can fetch State name, active cases, recovered cases, confirmed, death cases Data.
	4). In-Countries u can fetch Flags, names, country cases, Today cases, death cases, today death cases, recovered cases Data.
	5). This API is easy to use and user friendly.	
}


In this, u don't require to write JSON code u have simply write :
{

	Covid19 covid = new Covid19(this,this);

	@Override

	public void OnStateDataReceived(ArrayList<State> states){

	String State_Name = states.get(0).getSTATE_NAME(); }
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
	
