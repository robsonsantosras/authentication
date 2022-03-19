package boasentregas.user.util;

public class Base64 {

    public static String[] decriptAuthentication(String authentication)
    {
        String tokenHeader = authentication.substring(6);

        byte[] decodedBytes = java.util.Base64.getDecoder().decode(tokenHeader);
        String decodedString = new String(decodedBytes);

        String[] user = decodedString.split(":");

        return user;
    }
}
