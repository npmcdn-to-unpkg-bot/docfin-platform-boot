package com.docfin.platform;

import com.docfin.platform.model.Country;
import com.docfin.platform.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by vinaysharma on 8/17/16.
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    private final CountryRepository repository;

    @Autowired
    public DatabaseLoader(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(Country.create("USA"));
        this.repository.save(Country.create("India"));
    }
}