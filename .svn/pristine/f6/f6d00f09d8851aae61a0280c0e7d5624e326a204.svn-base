package springmvc.parse;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonParserUtil {

	public static EchoServiceCreds getServiceInstance(
			String servicesInJsonFormat, String serviceInstanceName)
			throws ServiceParserException {

		JsonElement json = new JsonParser().parse(servicesInJsonFormat);
		JsonObject jsonobj = json.getAsJsonObject();
		JsonElement elem = jsonobj.get("echo-1.0");
		if (elem != null) {
			JsonArray jsonArray = elem.getAsJsonArray();

			for (int i = 0; i < jsonArray.size(); i++) {
				jsonobj = jsonArray.get(i).getAsJsonObject();
				String name = jsonobj.get("name").toString();
				name = removeQuotes(name);
				if (name.equalsIgnoreCase(serviceInstanceName)) {
					jsonobj = jsonobj.get("credentials").getAsJsonObject();
					EchoServiceCreds creds = new EchoServiceCreds();
					creds.setName(removeQuotes(jsonobj.get("name").toString()));
					creds.setHost(removeQuotes(jsonobj.get("host").toString()));
					creds.setPort(Integer.valueOf(jsonobj.get("port")
							.toString()));
					creds.setUser(removeQuotes(jsonobj.get("user").toString()));
					creds.setUsername(removeQuotes(jsonobj.get("username")
							.toString()));
					creds.setPassword(removeQuotes(jsonobj.get("password")
							.toString()));
					return creds;
				}
			}
			throw new ServiceParserException("Echo service instane '"
					+ serviceInstanceName + "' is not bound to the application");
		} else {
			throw new ServiceParserException(
					"Echo service 1.0 is not bound to the application");
		}
	}

	private static String removeQuotes(String str) {
		str = str.substring(1, str.length() - 1);
		return str;
	}
}
