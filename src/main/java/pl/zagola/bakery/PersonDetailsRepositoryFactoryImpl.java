package pl.zagola.bakery;

public class PersonDetailsRepositoryFactoryImpl implements PersonDetailsRepositoryFactory {

    @Override
    public PersonDetailsRepository createPersonDetails() {
        return new PersonDetailsRepositoryListBased();
    }
}