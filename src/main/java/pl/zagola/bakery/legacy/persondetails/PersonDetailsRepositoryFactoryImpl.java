package pl.zagola.bakery.legacy.persondetails;

public class PersonDetailsRepositoryFactoryImpl implements PersonDetailsRepositoryFactory {

    @Override
    public PersonDetailsRepository createPersonDetails() {
        return new PersonDetailsRepositoryListBased();
    }
}