# A Basic Grails App with Authentication

This example creates a basic camera inventory application with Grails and adds authentication with Okta. See the corresponding blog posts for more info:

* [Build Server Side Authentication in Grails with OAuth 2.0 and Okta](https://developer.okta.com/blog/2018/04/19/okta-with-grails) - creates initial application and adds OAuth 2.0 support
* [Build a Basic CRUD Application with Grails and Okta](https://developer.okta.com/blog/2018/06/04/okta-with-grails-part2) - adds additional endpoints and secures them with annotations

**Prerequisites:** 

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Grails](http://grails.org/index.html)

> [Okta](https://developer.okta.com/) has Authentication and User Management APIs that reduce development time with instant-on, scalable user infrastructure. Okta's intuitive API and expert support make it easy for developers to authenticate, manage, and secure users and roles in any application.

* [Getting Started](#getting-started)
* [Links](#links)
* [Help](#help)
* [License](#license)

## Getting Started

To install this example application, run the following commands:

```bash
git clone https://github.com/oktadeveloper/okta-grails-example.git
cd okta-grails-example
```

This will get a copy of the project installed locally. You can run the application with:
 
```bash
grails run-app
```

### Setup Okta

Log in to your Okta Developer account (or [sign up](https://developer.okta.com/signup/) if you don’t have an account) and navigate to **Applications** > **Add Application**. Click **Single-Page App**, click **Next**, and give the app a name you’ll remember. Click **Done**.

#### Server Configuration

Open `grails-app/conf/application.yml` and replace `{yourOktaDomain}`, `<Okta Client ID>`, and `<Okta Client Secret>` in the following code block. 

```yaml
okta:
    api_key: '<Okta Client ID>'         
    api_secret: '<Okta Client Secret>'
    userInfoUrl: 'https://{yourOktaDomain}.com/oauth2/default/v1/userinfo'
    authorizeUrl: 'https://{yourOktaDomain}.com/oauth2/default/v1/authorize'
    tokenUrl: 'https://{yourOktaDomain}.com/oauth2/default/v1/token'
    scopes: 'email profile openid'
```

**NOTE:** The value of `{yourOktaDomain}` should be something like `dev-123456.oktapreview`. Make sure you don't include `-admin` in the value!

## Links

This example uses the following libraries provided by Okta:

* [Okta JWT Verifier](https://github.com/okta/okta-oidc-js/tree/master/packages/jwt-verifier)
* [Okta Sign-In Widget](https://github.com/okta/okta-signin-widget)

## Help

Please post any questions as comments on the [blog post](https://developer.okta.com/blog/2018/06/04/okta-with-grails-part2), or visit our [Okta Developer Forums](https://devforum.okta.com/). You can also email developers@okta.com if would like to create a support ticket.

## License

Apache 2.0, see [LICENSE](LICENSE).
