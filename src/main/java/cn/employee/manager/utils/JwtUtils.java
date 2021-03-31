package cn.employee.manager.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.collect.Maps;
import io.jsonwebtoken.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

/**
 * Jwt工具类
 *
 * @author: LiAnDong
 * @since 2020-01-12
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtUtils {

    private String secret;

    /**
     * 失效时间ms
     */
    private long ttl;

    /**
     * 生成token
     *
     * @param userId
     * @return
     */
    public String createToken(String userId) {
        Map<String, Object> claims = Maps.newHashMap();
        return doCreateToken(userId, claims);
    }

    /**
     * 生成token
     *
     * @param userId
     * @param claims
     * @return
     */
    public String createToken(String userId, Map<String, Object> claims) {
        return doCreateToken(userId, claims);
    }

    private String doCreateToken(String userId, Map<String, Object> claims) {
        long nowMillis = System.currentTimeMillis();
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .setSubject(userId)
                .signWith(SignatureAlgorithm.HS256, secret);
        if (ttl > 0) {
            jwtBuilder.setExpiration(new Date(nowMillis + ttl));
        }
        return jwtBuilder.compact();
    }

    /**
     * 获取用户id从token中
     *
     * @param token
     * @return
     */
    public String getUserId(String token) {
        return getClaimFromToken(token).getSubject();
    }

    /**
     * 获取payload
     *
     * @param token
     * @return
     */
    public Claims getClaimFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(this.secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            claims = e.getClaims();
        }
        return claims;
    }

    /**
     * 获取token过期时间
     *
     * @param token
     * @return
     */
    public Date getExpiration(String token) {
        return getClaimFromToken(token).getExpiration();
    }

    /**
     * 判断token是否过期
     *
     * @param token
     * @return
     */
    public boolean tokenExpiredStatus(String token) {
        Date expiration = getExpiration(token);
        return expiration.after(new Date());
    }

    public Map<String, Claim> verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(this.secret);
        JWTVerifier verifier = JWT.require(algorithm)
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        return claims;
    }

}


