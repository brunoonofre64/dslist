package io.github.brunoonofre64.dslist.infrastructure.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class CustomAuthorizationFilterConfig extends OncePerRequestFilter {

    private static final String BEARER = "Bearer ";
    private final String jwtSecret;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        log.info("Request sendo realizado na aplicacao.");

        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER)) {

            try {
                String token = authorizationHeader.substring(BEARER.length());
                Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(token);
                String email = decodedJWT.getSubject();
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, null, null);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                filterChain.doFilter(request, response);

            } catch (Exception ex) {
                log.error("Mensagem erro de autorizacao: {}", ex.getMessage());
                response.setHeader("error", ex.getMessage());
                response.setStatus(HttpStatus.FORBIDDEN.value());
            }

        } else {
            filterChain.doFilter(request, response);
        }
    }
}
