package com.midlife.exams.config.filter;

import com.midlife.exams.config.Constants;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger log = Logger.getLogger("JWTAuthorizationFilter");

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        UsernamePasswordAuthenticationToken token = getAuthentication(request);
        if(token==null){
            chain.doFilter(request,response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(token);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(Constants.TOKEN_HEADER);
        if (StringUtils.isEmpty(token) || !token.startsWith(Constants.TOKEN_PREFIX)) {
            return null;
        }
        byte[] signInKey = Constants.JWT_SECRET.getBytes();
        try {
            Jws<Claims> parsedToken = Jwts.parser().setSigningKey(signInKey).parseClaimsJws(token.replace("Bearer ", ""));
            String userName = parsedToken.getBody().getSubject();
            if (StringUtils.isEmpty(userName)) {
                return null;
            }
            List<SimpleGrantedAuthority> roles = ((List<?>) parsedToken.getBody()
                    .get("rol"))
                    .stream()
                    .map(auth -> new SimpleGrantedAuthority((String) auth))
                    .collect(Collectors.toList());
            return new UsernamePasswordAuthenticationToken(userName, "", roles);
        } catch (ExpiredJwtException exception) {
            log.warning("Request to parse expired JWT : {" + token + "} failed : {" + exception.getMessage() + "}");

        } catch (UnsupportedJwtException exception) {
            log.warning("Request to parse unsupported JWT  : {" + token + "} failed : {" + exception.getMessage() + "}");
        } catch (MalformedJwtException exception) {
            log.warning("Request to parse invalid JWT : : {" + token + "} failed : {" + exception.getMessage() + "}");
        } catch (SignatureException exception) {
            log.warning("Request to parse JWT with invalid signature :  : {" + token + "} failed : {" + exception.getMessage() + "}");
        } catch (IllegalArgumentException exception) {
            log.warning("Request to parse empty or null JWT :  : {" + token + "} failed : {" + exception.getMessage() + "}");
        }
        return null;
    }

}
