package dk.acto.blackdragon.service;

import dk.acto.blackdragon.model.AuthorData;

import java.net.MalformedURLException;
import java.net.URL;

public class MyAuthorDataFactory implements AuthorDataFactory {
    @Override
    public AuthorData create() throws MalformedURLException {
        String name = "Osama Mansour";
        URL linkedInProfile = new URL("https://www.linkedin.com/in/osama-mansour-783571265/");
        URL solutionRepository = new URL("https://github.com/OsamaMansour25/black-dragon-java");
        return AuthorData.builder()
                .name(name)
                .linkedInProfile(linkedInProfile)
                .solutionRepository(solutionRepository)
                .build();
    }
}
