package com.example.fakerclient2.config;

import com.example.fakerclient2.client.UsersClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.support.CryptoFactoryBean;

import java.io.IOException;


@Configuration
@Profile("certs")
public class UsersConfiguration {
    @Bean
    public Wss4jSecurityInterceptor securityInterceptor() throws Exception {
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();

        // set security actions
        securityInterceptor.setSecurementActions("Timestamp Signature");

        // sign the request
        securityInterceptor.setSecurementUsername("client");
        securityInterceptor.setSecurementPassword("gatman");
        securityInterceptor.setTimestampPrecisionInMilliseconds(true);
        securityInterceptor.setTimestampStrict(true);
        securityInterceptor.setSecurementSignatureCrypto(getCryptoFactoryBean().getObject());

        // encrypt the request
        securityInterceptor.setSecurementEncryptionUser("server-public");
        securityInterceptor.setSecurementEncryptionCrypto(getCryptoFactoryBean().getObject());
        securityInterceptor.setSecurementEncryptionParts("{Content}{http://spring.io/guides/gs-producing-web-service}getUsersResponse");
        securityInterceptor.setSecurementSignatureKeyIdentifier("DirectReference");
        securityInterceptor.setSecurementSignatureParts("{Element}{http://schemas.xmlsoap.org/soap/envelope/}Body;\n" +
                "{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp");
        securityInterceptor.setValidationSignatureCrypto(getCryptoFactoryBean().getObject());
        securityInterceptor.setValidationSignatureCrypto(getCryptoFactoryBean().getObject());

        securityInterceptor.setValidateResponse(false);
        securityInterceptor.setSecureResponse(true);
        securityInterceptor.setValidationActions("Timestamp Signature");

        return securityInterceptor;
    }

    @Bean
    public CryptoFactoryBean getCryptoFactoryBean() throws IOException {
        CryptoFactoryBean cryptoFactoryBean = new CryptoFactoryBean();
        cryptoFactoryBean.setKeyStorePassword("gatman");
        cryptoFactoryBean.setKeyStoreLocation(new ClassPathResource("keystore/client.jks"));
        return cryptoFactoryBean;
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.fakerclient2.wsdl");
        return marshaller;
    }


    @Bean
    public UsersClient usersClient(Jaxb2Marshaller marshaller) throws Exception {
        UsersClient client = new UsersClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        ClientInterceptor[] interceptors = new ClientInterceptor[]{securityInterceptor()};
        client.setInterceptors(interceptors);

        return client;
    }
}
