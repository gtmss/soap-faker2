package com.example.fakerclient2.services;

import com.example.fakerclient2.mapper.SimpleSourceDestinationMapper;
import com.example.fakerclient2.model.Address;
import com.example.fakerclient2.model.Users;
import com.example.fakerclient2.wsdl.Company;
import com.example.fakerclient2.wsdl.Geo;
import com.example.fakerclient2.wsdl.SoapUsers;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T18:24:00+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class SimpleSourceDestinationMapperImpl implements SimpleSourceDestinationMapper {

    @Override
    public SoapUsers usersToSoapUsers(Users users) {
        if ( users == null ) {
            return null;
        }

        SoapUsers soapUsers = new SoapUsers();

        if ( users.getId() != null ) {
            soapUsers.setId( users.getId() );
        }
        soapUsers.setName( users.getName() );
        soapUsers.setUsername( users.getUsername() );
        soapUsers.setEmail( users.getEmail() );
        soapUsers.setPhone( users.getPhone() );
        soapUsers.setWebsite( users.getWebsite() );
        soapUsers.setAddress( addressToAddress( users.getAddress() ) );
        soapUsers.setCompany( companyToCompany( users.getCompany() ) );

        return soapUsers;
    }

    @Override
    public Users soapUsersToUsers(SoapUsers soapUsers) {
        if ( soapUsers == null ) {
            return null;
        }

        Users users = new Users();

        users.setId( soapUsers.getId() );
        users.setName( soapUsers.getName() );
        users.setUsername( soapUsers.getUsername() );
        users.setEmail( soapUsers.getEmail() );
        users.setPhone( soapUsers.getPhone() );
        users.setWebsite( soapUsers.getWebsite() );
        users.setAddress( addressToAddress1( soapUsers.getAddress() ) );
        users.setCompany( companyToCompany1( soapUsers.getCompany() ) );

        return users;
    }

    protected Geo geoToGeo(com.example.fakerclient2.model.Geo geo) {
        if ( geo == null ) {
            return null;
        }

        Geo geo1 = new Geo();

        if ( geo.getId() != null ) {
            geo1.setId( geo.getId() );
        }
        if ( geo.getLat() != null ) {
            geo1.setLat( geo.getLat() );
        }
        if ( geo.getLng() != null ) {
            geo1.setLng( geo.getLng() );
        }

        return geo1;
    }

    protected com.example.fakerclient2.wsdl.Address addressToAddress(Address address) {
        if ( address == null ) {
            return null;
        }

        com.example.fakerclient2.wsdl.Address address1 = new com.example.fakerclient2.wsdl.Address();

        if ( address.getId() != null ) {
            address1.setId( address.getId() );
        }
        address1.setStreet( address.getStreet() );
        address1.setSuite( address.getSuite() );
        address1.setCity( address.getCity() );
        address1.setZipcode( address.getZipcode() );
        address1.setGeo( geoToGeo( address.getGeo() ) );

        return address1;
    }

    protected Company companyToCompany(com.example.fakerclient2.model.Company company) {
        if ( company == null ) {
            return null;
        }

        Company company1 = new Company();

        if ( company.getId() != null ) {
            company1.setId( company.getId() );
        }
        company1.setCatchPhrase(company.getCatchPhrase());
        company1.setName( company.getName() );
        company1.setBs( company.getBs() );

        return company1;
    }

    protected com.example.fakerclient2.model.Geo geoToGeo1(Geo geo) {
        if ( geo == null ) {
            return null;
        }

        com.example.fakerclient2.model.Geo geo1 = new com.example.fakerclient2.model.Geo();

        geo1.setId( geo.getId() );
        geo1.setLat( geo.getLat() );
        geo1.setLng( geo.getLng() );

        return geo1;
    }

    protected Address addressToAddress1(com.example.fakerclient2.wsdl.Address address) {
        if ( address == null ) {
            return null;
        }

        Address address1 = new Address();

        address1.setStreet( address.getStreet() );
        address1.setSuite( address.getSuite() );
        address1.setCity( address.getCity() );
        address1.setZipcode( address.getZipcode() );
        address1.setGeo( geoToGeo1( address.getGeo() ) );
        address1.setId( address.getId() );

        return address1;
    }

    protected com.example.fakerclient2.model.Company companyToCompany1(Company company) {
        if ( company == null ) {
            return null;
        }

        com.example.fakerclient2.model.Company company1 = new com.example.fakerclient2.model.Company();

        company1.setId( company.getId() );
        company1.setCatchPhrase(company.getCatchPhrase());
        company1.setName( company.getName() );
        company1.setBs( company.getBs() );

        return company1;
    }
}
