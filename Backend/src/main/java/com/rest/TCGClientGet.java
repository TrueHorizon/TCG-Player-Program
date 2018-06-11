package com.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
* This class recreates the follow curl request in Java code to access the
* TCGPlayer API. This curl is the inital request for the ACCESS_TOKEN
* which is good for up to 2 weeks or until the expiration date in the response.
*
* curl --include --request POST \
* --header "application/x-www-form-urlencoded" \
* --header "X-Tcg-Access-Token: ACCESS_TOKEN" \
* --data-binary "grant_type=client_credentials&client_id=PUBLIC_KEY&client_secret=PRIVATE_KEY" \
* 'https://api.tcgplayer.com/token'
*
* The --header line with the ACCESS_TOKEN is optional and returned upon
* the initial request to be stored for use for 2 weeks.
* (see the expire date in the response.)
**/

public class TCGClientGet {
	// These form the --data-binary in the curl request.
	private static final String PUBLIC_KEY = "";
	private static final String PRIVATE_KEY = "";
	private static final String POST_PARAMS =
	"grant_type=client_credentials&client_id=" + PUBLIC_KEY +
	"&client_secret=" + PRIVATE_KEY;

	// curl request to e
	public TCGClientGet() {
		try {
			URL url = new URL("https://api.tcgplayer.com/token");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setDoOutput(true);
			OutputStream outstream = conn.getOutputStream();
			outstream.write(POST_PARAMS.getBytes());
			outstream.flush();
			outstream.close();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
			  (conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
