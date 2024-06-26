package fr.hackathon.apiback.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.hackathon.apiback.application.dto.permission.JwtPayload;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class PermissionsFilter implements Filter {

    private String[] adminMethodAllowed ={
            "nouveau-catalogue", "get-all-catalogues", "get-catalogue-by-id", "modifie-catalogue", "supprimer-catalogue",
            "nouveau-produit", "get-all-produits", "get-produit-by-id", "modifie-produit", "supprimer-produit",
            "nouveau-utilisateur", "get-utilisateur-by-id", "modifie-utilisateur", "modifie-utilisateur"
    };

    private String[] userMethodAllowed = {
            "get-all-catalogues", "get-catalogue-by-id", "get-all-produits", "get-produit-by-id"
    };

    private String[] modMethodAllowed = {
            "nouveau-catalogue", "get-all-catalogues", "get-catalogue-by-id", "modifie-catalogue",
            "nouveau-produit", "get-all-produits", "get-produit-by-id", "modifie-produit",
            "nouveau-utilisateur", "get-utilisateur-by-id", "modifie-utilisateur", "modifie-utilisateur"
    };

    private Map<String, String[]> whiteListMap= new HashMap<>();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        final String authorizationHeader = httpServletRequest.getHeader("Authorization");

        if (authorizationHeader == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Missing or invalid Authorization header");
        }

        final String[] authHeaderSplit = authorizationHeader.split(" ");
        final String jwtToken = authHeaderSplit[1];
        try {
            // Decode the payload
            final String[] tokenParts = jwtToken.split("\\.");
            final String encodedPayload = tokenParts[1];
            final byte[] decodedBytes = Base64.getUrlDecoder().decode(encodedPayload);
            final String decodedPayload = new String(decodedBytes, StandardCharsets.UTF_8);

            // Map to object
            final ObjectMapper objectMapper = new ObjectMapper();
            final JwtPayload jwtPayload = objectMapper.readValue(decodedPayload, JwtPayload.class);

            // Verification of permissions
            final String requestUri = httpServletRequest.getRequestURI();
            final String[] uriParts = requestUri.split("/");

            boolean allowed = false;
            for (String role : jwtPayload.getRoles()){
                final String[] allowedMethods = whiteListMap.getOrDefault(role, new String[]{});
                if (Arrays.asList(allowedMethods).contains(uriParts[3])){
                    allowed = true;
                    break;
                }
            }

            if (allowed) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access forbidden for this role and method");
            }

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid JWT token", e);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        whiteListMap.put("ROLE_ADMIN", adminMethodAllowed);
        whiteListMap.put("ROLE_MODERATOR", modMethodAllowed);
        whiteListMap.put("ROLE_USER", userMethodAllowed);

    }
}
