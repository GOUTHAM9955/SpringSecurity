package com.telusko.OAuthSecurityApp;
//IN THIS PROJECT WE WILL TAKE A LOOK AT OAUTH
/*
Imagine you go to a coffee shop that offers free Wi-Fi, but to access it, you need to log in using your Google or Facebook account.
You’re not directly giving the coffee shop your Google password — instead, you authorize Google to confirm your identity./
	•	“Login with Google/Facebook/Apple” → When you sign in to apps or websites using your social media accounts.
	•	Payment Gateways → When apps let you pay with PayPal or Stripe without sharing your payment details.
	•	Fitness Apps → When you allow a fitness app to access your Google Fit or Apple Health data.

 */

/*
To enable OAuth we have to add OAuth2 Client dependency.. we didn't add SpringSecurity separately
	If you don't override the existing security spring will still redirect you to login page
	We override it in SecurityConfig class like in previous project
	We override it in SecurityConfig class like in previous project... check this class

✅ Step 1: Create a Project in GCP
	1.	Go to → Google Cloud Console.
	2.	Click on “Select a Project” → “New Project”.
	3.	Give your project a name (e.g., my-oauth-app) and click Create.

Step 2: Enable OAuth 2.0 API
	1.	In the GCP console, go to:
APIs & Services → Library.
	2.	Search for:
“Google+ API” or “Google Identity Platform”.
	3.	Click Enable.

✅ Step 3: Create OAuth 2.0 Credentials
	1.	Go to:
APIs & Services → Credentials → Create Credentials → OAuth 2.0 Client ID.
	2.	Select “Web application” as the application type.
	3.	Set the Authorized redirect URIs:
		For Local: http://localhost:8080/login/oauth2/code/google
		For Production: https://yourdomain.com/login/oauth2/code/google

	4.	Click Create.
	5.	Copy the Client ID and Client Secret.

✅ Step 4: Add OAuth Configuration in application.properties or application.yml
	spring.security.oauth2.client.registration.google.client-id=YOUR_CLIENT_ID
	spring.security.oauth2.client.registration.google.client-secret=YOUR_CLIENT_SECRET
	spring.security.oauth2.client.registration.google.scope=profile, email
	spring.security.oauth2.client.registration.google.redirect-uri={baseUrl}/login/oauth2/code/google
	spring.security.oauth2.client.provider.google.token-uri=https://oauth2.googleapis.com/token
	spring.security.oauth2.client.provider.google.authorization-uri=https://accounts.google.com/o/oauth2/auth
	spring.security.oauth2.client.provider.google.user-info-uri=https://www.googleapis.com/oauth2/v3/userinfo
	spring.security.oauth2.client.provider.google.user-name-attribute=sub

✅ Step 5: Add OAuth Configuration in SecurityConfig.java

✅ Step 6: Create the Login and Home Pages
 */

/*
Likewise we can use app's like github to make this OAuth calls
We have implemented for Google and GitHub for making OAuth Class
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OAuthSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthSecurityAppApplication.class, args);
	}

}
