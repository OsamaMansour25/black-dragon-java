package dk.acto.blackdragon.service;

import dk.acto.blackdragon.model.AuthorData;

import java.net.MalformedURLException;

public interface AuthorDataFactory {
    AuthorData create() throws MalformedURLException;
}
