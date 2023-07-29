package JavaSessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

//import org.json.simple.JSONObject;

import com.google.gson.JsonParser;

//import App.Query;
//import App.Search;
//import App.SearchInfo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class HttpURLConnection_MediaWikiSearch {

	public static void main(String[] args) throws Exception {
		String apiMediaWikiEndpoint = "https://en.wikipedia.org/w/api.php";
		String apiQueryParam = "?action=query&format=json&list=search&continue=-%7C%7C&formatversion=2&srsearch=Software%20Testing&sroffset=10";
		String responseContent = sendAPIRequest(apiMediaWikiEndpoint+apiQueryParam);
		JsonObject parseToJsonObject = parseToJsonObject(responseContent);
		queryJsonObject(parseToJsonObject);
	}
	public static String sendAPIRequest(String apiURL) throws IOException
	{
		String reponseText = "";
		System.out.println("apiURL: " + apiURL);
		try {
//			apiURL = "https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&continue=-%7C%7C&formatversion=2&srsearch=Software%20Testing&sroffset=10";
			URL url = new URL(apiURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();//Parse URL into HttpURLConnection in order to open the connection
			conn.setRequestMethod("GET");
			conn.connect(); //create the connection bridge
			
			int responsecode = conn.getResponseCode();            
			System.out.println("Response code is: " +responsecode);
			if(responsecode != 200)
            {
                throw new RuntimeException("HttpResponseCode: " +responsecode);
            }				
			else
			{
				//Scanner functionality will read the JSON data from the stream
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext())
				{
					reponseText+=sc.nextLine();
				}
				// System.out.println("\nJSON Response in String format"); 
				//Close the stream when reading the data has been finished
				sc.close();
			}
		} catch (MalformedURLException e) {
			System.out.println("Error sending API Request...: ");
			e.printStackTrace();
		}
		 System.out.println("\nJSON Response in String format: " +reponseText ); 
		return reponseText;
	}
	public static JsonObject parseToJsonObject(String strJson) {
		JsonObject jObj = new JsonParser().parse(strJson).getAsJsonObject();
		return jObj;
	}
	public static void queryJsonObject(JsonObject jObj) {
		JsonObject jQueryObj = (JsonObject)jObj.get("query");
		Query query = new Gson().fromJson(jQueryObj.toString(), Query.class);
		
		if(query != null && query.getSearch() != null && query.getSearch().size() > 0) 
		{
			System.out.println("searchinfo: " + query.getSearchinfo().toString());

			int i = 0;
			for (Search search : query.getSearch()) {
				i++;
				System.out.println("Title" + i + ": " + search.getTitle() + " with page id " + search.getPageid());
			}
		}
	}
	public class Query
	{
		private SearchInfo searchinfo;
		public SearchInfo getSearchinfo() { return searchinfo; }
		public void setSearchinfo(SearchInfo searchInfo) { this.searchinfo = searchInfo; }

		private List<Search> search;
		public List<Search> getSearch() { return this.search; }
		public void setSearch(List<Search> searchs) { this.search = searchs; }

		public String toString()
		{
			return searchinfo != null ? searchinfo.toString() : "I'm here Query";
		}
	}

	public class SearchInfo
	{
		private Integer totalhits;

		public Integer getTotalhits() { return totalhits; }

		public void setTotalhits(Integer totalHits) { this.totalhits = totalHits; }

		public String toString()
		{
			return "TotalHits: " + this.totalhits;
		}
	}

	public class Search
	{
		private Integer ns;
		public Integer getNs() { return ns; }
		public void setNs(Integer ns) { this.ns = ns; }

		private String title;
		public String getTitle() { return this.title; } 
		public void setTitle(String title) { this.title = title; }

		Integer pageid;
		public Integer getPageid () { return this.pageid; }
		public void setPageid(Integer pageid) { this.pageid = pageid; }
	}
}
