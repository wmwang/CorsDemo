# CORS Demo

Cross Origin Resource Sharing hands on example.

## About

Modern Browsers restrict dynamic access of server resources to the origin of the currenlty loaded website, as a security feature.  
However, modern web architectures often consist of modular services, and require the client to access resources of multiple origins. In this case the browser restrictions can be relaxed with the *Cross Origin Resource Sharing* protocol.  
This repository hosts a minimal project to demonstrate a simple CORS use case and highlight the relevant configurations and code.

## Scenario

Repository components and demo functioning

### Components

 * A simple [webpage, accessible via file-system](index.html).
 * A *ContentProvider*, hosting [a single resource on port 8081](http://127.0.0.1:8081/resource).

### Demo functioning

The browser displays the simple webpage. Embedded in the webpage is a button to trigger JavaScript code that accesses a resource, located on the *ContentProvider*.

 * Without a CORS configuration, access to the *ContentProvider*'s resource is blocked by the client browser.
 * A special HTTP/OPTIONS request/reply, called *CORS Preflight* allows to override the blocking.
 * The next section illustrates the required server-side (ContentProvider) changes to enable the required endpoint.

## CORS Preflight Endpoint

The CORS Preflight protocol is activated by the browser, prior to every access to a resource hosted on a server other than the currently displayed webpage. (There are some exceptions, but these are not relevant for this demo).  
This protocol runs on top of HTTP and effectively means that a single request / reply call occurs between client and resource hoster:
 * The client uses the HTTP/OPTIONS method to indicate which resource is requested (including additional request details in the header).
 * The server replies with header information that indicated whether the original page server is an enabled location.
 * Only if this preflight message exchange was successful, the browser allows access to the foreign resource.

In *Spring Boot* the HTTP/OPTIONS endpoint is enabled with a special annotation that decorated the RestController. See [```ContentProviderController:16```](src/main/java/eu/kartoffelquadrat/contentprovider/ContentProviderController.java):  
```
    @CrossOrigin
```

## Test it

 * Power up the *Content Provider*: mvn clean spring-boot:run
 * Test the *Content Provider* backend: [[GET]: ```http://127.0.0.1:8081/resource```](http://127.0.0.1:8081/resource)
 * Access the simple webpage, located on your filesystem at [```index.html```](index.html). Open it with your browser.
 * Hit the button, make sure a success message appears.

## Contact / Pull Requests

 * Author: Maximilian Schiedermeier ![email](email.png)
 * Github: Kartoffelquadrat
 * Webpage: https://www.cs.mcgill.ca/~mschie3
 * License: [MIT](https://opensource.org/licenses/MIT)


