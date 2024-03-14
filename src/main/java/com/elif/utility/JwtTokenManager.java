package com.elif.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.elif.exception.OtelException;
import com.elif.exception.ErrorType;
import com.elif.utility.Enum.ERole;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenManager {


    private final String secretKey="KoiHNe1b1tyide61UO4VICqOFAMkkHPpJltHt6R2Cj6U";

    private final String issuer="elifbilgeadam";

    private String audience="bilgeAdam";


    public Optional<String> createToken(String id){
        String token = null;
        Date date = new Date(System.currentTimeMillis()+(1000*60*5));
        try {
            token = JWT.create()
                    .withAudience(audience)
                    .withIssuer(issuer)
                    .withIssuedAt(new Date())
                    .withExpiresAt(date)
                    .withClaim("id",id)
                    .sign(Algorithm.HMAC512(secretKey));
            return Optional.of(token);

        } catch (Exception e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<String> createToken(String id, ERole role){
        String token = null;
        Date date = new Date(System.currentTimeMillis()+(1000*60*5));
        try {
            token = JWT.create()
                    .withAudience(audience)
                    .withIssuer(issuer)
                    .withIssuedAt(new Date())
                    .withExpiresAt(date)
                    .withClaim("id",id)
                    .withClaim("role",role.toString())
                    .sign(Algorithm.HMAC512(secretKey));
            return Optional.of(token);

        } catch (Exception e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public Boolean validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(issuer).withAudience(audience).build();
            DecodedJWT decodedJWT = verifier.verify(token);

            if(decodedJWT == null){
                return false;
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
            throw new OtelException(ErrorType.INVALID_TOKEN);
        }
        return true;
    }

    public Optional<String> getIdFromToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(issuer).withAudience(audience).build();
            DecodedJWT decodedJWT = verifier.verify(token);

            if(decodedJWT == null){
                throw new OtelException(ErrorType.INVALID_TOKEN);
            }
            String id = decodedJWT.getClaim("id").asString();
            return Optional.of(id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new OtelException(ErrorType.INVALID_TOKEN);
        }
    }

    public Optional<String> getRoleFromToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(issuer).withAudience(audience).build();
            DecodedJWT decodedJWT = verifier.verify(token);

            if(decodedJWT == null){
                throw new OtelException(ErrorType.INVALID_TOKEN);
            }
            String role = decodedJWT.getClaim("role").asString();
            return Optional.of(role);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new OtelException(ErrorType.INVALID_TOKEN);
        }
    }






}
