package pl.zagola.bakery.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.zagola.bakery.persondetails.PersonDetails;
import pl.zagola.bakery.address.Address;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    private PersonDetails personDetails;
    private Address address;


    @Override
    public String toString() {
        return "Client{" +
                "address=" + address +
                ", personDetails=" + personDetails +
                '}';
    }
}