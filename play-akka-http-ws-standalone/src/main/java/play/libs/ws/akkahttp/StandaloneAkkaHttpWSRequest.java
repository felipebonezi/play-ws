package play.libs.ws.akkahttp;

import akka.actor.ActorSystem;
import akka.stream.Materializer;
import play.api.libs.ws.akkahttp.StandaloneAkkaHttpWSRequest$;
import play.libs.ws.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

import static scala.compat.java8.FutureConverters.toJava;

public final class StandaloneAkkaHttpWSRequest implements StandaloneWSRequest {

  private final play.api.libs.ws.StandaloneWSRequest request;

  StandaloneAkkaHttpWSRequest(String url, ActorSystem sys, Materializer mat) {
    this.request = StandaloneAkkaHttpWSRequest$.MODULE$.apply(url, sys, mat);
  }

  private StandaloneAkkaHttpWSRequest(play.api.libs.ws.StandaloneWSRequest request) {
    this.request = request;
  }

  /**
   * Perform a GET on the request asynchronously.
   *
   * @return a promise to the response
   */
  @Override
  public CompletionStage<? extends StandaloneWSResponse> get() {
    return toJava(request.get()).thenApply(StandaloneAkkaHttpWSResponse::new);
  }

  /**
   * Perform a PATCH on the request asynchronously.
   *
   * @param body the BodyWritable
   * @return a promise to the response
   */
  @Override
  public CompletionStage<? extends StandaloneWSResponse> patch(BodyWritable body) {
     return toJava(request.patch(null, body.toScala()))
      .thenApply(r -> new StandaloneAkkaHttpWSResponse((play.api.libs.ws.StandaloneWSResponse)r));
  }

  /**
   * Perform a POST on the request asynchronously.
   *
   * @param body the BodyWritable
   * @return a promise to the response
   */
  @Override
  public CompletionStage<? extends StandaloneWSResponse> post(BodyWritable body) {
    return toJava(request.post(null, body.toScala()))
      .thenApply(r -> new StandaloneAkkaHttpWSResponse((play.api.libs.ws.StandaloneWSResponse)r));
  }

  /**
   * Perform a PUT on the request asynchronously.
   *
   * @param body the BodyWritable
   * @return a promise to the response
   */
  @Override
  public CompletionStage<? extends StandaloneWSResponse> put(BodyWritable body) {
    return toJava(request.put(null, body.toScala()))
      .thenApply(r -> new StandaloneAkkaHttpWSResponse((play.api.libs.ws.StandaloneWSResponse)r));
  }

  /**
   * Perform a DELETE on the request asynchronously.
   *
   * @return a promise to the response
   */
  @Override
  public CompletionStage<? extends StandaloneWSResponse> delete() {
    return toJava(request.delete()).thenApply(StandaloneAkkaHttpWSResponse::new);
  }

  /**
   * Perform a HEAD on the request asynchronously.
   *
   * @return a promise to the response
   */
  @Override
  public CompletionStage<? extends StandaloneWSResponse> head() {
    return toJava(request.head()).thenApply(StandaloneAkkaHttpWSResponse::new);
  }

  /**
   * Perform an OPTIONS on the request asynchronously.
   *
   * @return a promise to the response
   */
  @Override
  public CompletionStage<? extends StandaloneWSResponse> options() {
    return toJava(request.options()).thenApply(StandaloneAkkaHttpWSResponse::new);
  }

  /**
   * Executes an arbitrary method on the request asynchronously.
   *
   * @param method The method to execute
   * @return a promise to the response
   */
  @Override
  public CompletionStage<? extends StandaloneWSResponse> execute(String method) {
    return null;
  }

  /**
   * Executes an arbitrary method on the request asynchronously.  Should be used with setMethod().
   *
   * @return a promise to the response
   */
  @Override
  public CompletionStage<? extends StandaloneWSResponse> execute() {
    return null;
  }

  /**
   * Executes this request and streams the response body.
   * <p>
   * Use {@code response.bodyAsSource()} with this method.
   *
   * @return a promise to the response
   */
  @Override
  public CompletionStage<? extends StandaloneWSResponse> stream() {
    return toJava(request.stream()).thenApply(StandaloneAkkaHttpWSResponse::new);
  }

  /**
   * Sets the HTTP method this request should use, where the no args execute() method is invoked.
   *
   * @param method the HTTP method.
   * @return the modified WSRequest.
   */
  @Override
  public StandaloneWSRequest setMethod(String method) {
    return null;
  }

  /**
   * Set the body this request should use.
   *
   * @param body the body of the request.
   * @return the modified WSRequest.
   */
  @Override
  public StandaloneWSRequest setBody(BodyWritable body) {
    return null;
  }

  /**
   * Set headers to the request.  Note that duplicate headers are allowed
   * by the HTTP specification, and removing a header is not available
   * through this API. Any existing header will be discarded here.
   *
   * @param headers the headers
   * @return the modified WSRequest.
   */
  @Override
  public StandaloneWSRequest setHeaders(Map<String, List<String>> headers) {
    return null;
  }

  /**
   * Adds a header to the request.  Note that duplicate headers are allowed
   * by the HTTP specification, and removing a header is not available
   * through this API. Existent headers will be preserved.
   *
   * @param name  the header name
   * @param value the header value
   * @return the modified WSRequest.
   */
  @Override
  public StandaloneWSRequest addHeader(String name, String value) {
    return null;
  }

  /**
   * Sets the query string to query.
   *
   * @param query the fully formed query string
   * @return the modified WSRequest.
   */
  @Override
  public StandaloneWSRequest setQueryString(String query) {
    return null;
  }

  /**
   * Adds a query parameter with the given name, this can be called repeatedly and will preserve existing values.
   * Duplicate query parameters are allowed.
   *
   * @param name  the query parameter name
   * @param value the query parameter value
   * @return the modified WSRequest.
   */
  @Override
  public StandaloneWSRequest addQueryParameter(String name, String value) {
    return null;
  }

  /**
   * Sets the query string parameters. This will discard existing values.
   *
   * @param params the query string parameters
   * @return the modified WSRequest.
   */
  @Override
  public StandaloneWSRequest setQueryString(Map<String, List<String>> params) {
    return null;
  }

  /**
   * Add a new cookie. This can be called repeatedly and will preserve existing cookies.
   *
   * @param cookie the cookie to be added
   * @return the modified WSRequest.
   * @see #addCookies(WSCookie...)
   * @see #setCookies(List)
   */
  @Override
  public StandaloneWSRequest addCookie(WSCookie cookie) {
    return null;
  }

  /**
   * Add new cookies. This can be called repeatedly and will preserve existing cookies.
   *
   * @param cookies the list of cookies to be added
   * @return the modified WSRequest.
   * @see #addCookie(WSCookie)
   * @see #setCookies(List)
   */
  @Override
  public StandaloneWSRequest addCookies(WSCookie... cookies) {
    return null;
  }

  /**
   * Set the request cookies. This discard the existing cookies.
   *
   * @param cookies the cookies to be used.
   * @return the modified WSRequest.
   */
  @Override
  public StandaloneWSRequest setCookies(List<WSCookie> cookies) {
    return null;
  }

  /**
   * Sets the authentication header for the current request using BASIC authentication.
   *
   * @param userInfo a string formed as "username:password".
   * @return the modified WSRequest.
   */
  @Override
  public StandaloneWSRequest setAuth(String userInfo) {
    return null;
  }

  /**
   * Sets the authentication header for the current request using BASIC authentication.
   *
   * @param username the basic auth username
   * @param password the basic auth password
   * @return the modified WSRequest.
   */
  @Override
  public StandaloneWSRequest setAuth(String username, String password) {
    return null;
  }

  /**
   * Sets the authentication header for the current request.
   *
   * @param username the username
   * @param password the password
   * @param scheme   authentication scheme
   * @return the modified WSRequest.
   */
  @Override
  public StandaloneWSRequest setAuth(String username, String password, WSAuthScheme scheme) {
    return new StandaloneAkkaHttpWSRequest(request.withAuth(username, password, toScala(scheme)));
  }

  /**
   * Sets an (OAuth) signature calculator.
   *
   * @param calculator the signature calculator
   * @return the modified WSRequest
   */
  @Override
  public StandaloneWSRequest sign(WSSignatureCalculator calculator) {
    return null;
  }

  /**
   * Sets whether redirects (301, 302) should be followed automatically.
   *
   * @param followRedirects true if the request should follow redirects
   * @return the modified WSRequest
   */
  @Override
  public StandaloneWSRequest setFollowRedirects(boolean followRedirects) {
    return null;
  }

  /**
   * Sets the virtual host as a "hostname:port" string.
   *
   * @param virtualHost the virtual host
   * @return the modified WSRequest
   */
  @Override
  public StandaloneWSRequest setVirtualHost(String virtualHost) {
    return new StandaloneAkkaHttpWSRequest(request.withVirtualHost(virtualHost));
  }

  /**
   * Sets the request timeout duration. Java {@link Duration} class does not have a specific instance
   * to represent an infinite timeout, but according to the docs, in practice, you can somehow emulate
   * it:
   * <p>
   * <blockquote>
   * A physical duration could be of infinite length. For practicality, the duration is stored
   * with constraints similar to Instant. The duration uses nanosecond resolution with a maximum
   * value of the seconds that can be held in a long. This is greater than the current estimated
   * age of the universe.
   * </blockquote>
   * <p>
   * Play WS uses the convention of setting a duration with negative value to have an infinite timeout.
   * So you will have:
   * <p>
   * <pre>java.time.Duration timeout = Duration.ofSeconds(-1);</pre>.
   *
   * In practice, you can also have an extreme long duration, like:
   *
   * <pre>java.time.Duration timeout = Duration.ofMillis(Long.MAX_VALUE);</pre>
   *
   * And, as the {@link Duration} docs states, this will be good enough since this duration is greater than
   * the current estimate age of the universe.
   *
   * @param timeout the request timeout in milliseconds. A duration of -1 indicates an infinite request timeout.
   * @return the modified WSRequest.
   */
  @Override
  public StandaloneWSRequest setRequestTimeout(Duration timeout) {
    return new StandaloneAkkaHttpWSRequest(request.withRequestTimeout(toScala(timeout)));
  }

  /**
   * Adds a request filter.
   *
   * @param filter a transforming filter.
   * @return the modified request.
   */
  @Override
  public StandaloneWSRequest setRequestFilter(WSRequestFilter filter) {
    return null;
  }

  /**
   * Set the content type.  If the request body is a String, and no charset parameter is included, then it will
   * default to UTF-8.
   *
   * @param contentType The content type
   * @return the modified WSRequest
   */
  @Override
  public StandaloneWSRequest setContentType(String contentType) {
    return null;
  }

  /**
   * @return the URL of the request.  This has not passed through an internal request builder and so will not be signed.
   */
  @Override
  public String getUrl() {
    return null;
  }

  /**
   * @return the headers (a copy to prevent side-effects). This has not passed through an internal request builder and so will not be signed.
   */
  @Override
  public Map<String, List<String>> getHeaders() {
    return null;
  }

  /**
   * Get all the values of header with the specified name. If there are no values for
   * the header with the specified name, than an empty List is returned.
   *
   * @param name the header name.
   * @return all the values for this header name.
   */
  @Override
  public List<String> getHeaderValues(String name) {
    return null;
  }

  /**
   * Get the value of the header with the specified name. If there are more than one values
   * for this header, the first value is returned. If there are no values, than an empty
   * Optional is returned.
   *
   * @param name the header name
   * @return the header value
   */
  @Override
  public Optional<String> getHeader(String name) {
    return Optional.empty();
  }

  /**
   * @return the query parameters (a copy to prevent side-effects). This has not passed through an internal request builder and so will not be signed.
   */
  @Override
  public Map<String, List<String>> getQueryParameters() {
    return null;
  }

  /**
   * @return the auth username, null if not an authenticated request.
   */
  @Override
  public String getUsername() {
    return null;
  }

  /**
   * @return the auth password, null if not an authenticated request
   */
  @Override
  public String getPassword() {
    return null;
  }

  /**
   * @return the auth scheme, null if not an authenticated request.
   */
  @Override
  public WSAuthScheme getScheme() {
    return null;
  }

  /**
   * @return the signature calculator (example: OAuth), null if none is set.
   */
  @Override
  public WSSignatureCalculator getCalculator() {
    return null;
  }

  /**
   * Gets the original request timeout duration, passed into the request as input.
   *
   * @return the timeout duration.
   */
  @Override
  public Duration getRequestTimeoutDuration() {
    return null;
  }

  /**
   * @return true if the request is configure to follow redirect, false if it is configure not to, null if nothing is configured and the global client preference should be used instead.
   */
  @Override
  public boolean getFollowRedirects() {
    return false;
  }

  /**
   * @return the content type, if any, or null.
   */
  @Override
  public String getContentType() {
    return null;
  }

  private play.api.libs.ws.WSAuthScheme toScala(WSAuthScheme scheme) {
    if (scheme.equals(WSAuthScheme.BASIC))
      return play.api.libs.ws.WSAuthScheme.BASIC$.MODULE$;
    else if (scheme.equals(WSAuthScheme.DIGEST))
      return play.api.libs.ws.WSAuthScheme.DIGEST$.MODULE$;
    else if (scheme.equals(WSAuthScheme.KERBEROS))
      return play.api.libs.ws.WSAuthScheme.KERBEROS$.MODULE$;
    else if (scheme.equals(WSAuthScheme.NTLM))
      return play.api.libs.ws.WSAuthScheme.NTLM$.MODULE$;
    else if (scheme.equals(WSAuthScheme.SPNEGO))
      return play.api.libs.ws.WSAuthScheme.SPNEGO$.MODULE$;
    else throw new IllegalArgumentException("Unknown scheme " + scheme);
  }

  private scala.concurrent.duration.Duration toScala(Duration duration) {
    return scala.concurrent.duration.Duration.fromNanos(duration.getNano());
  }
}