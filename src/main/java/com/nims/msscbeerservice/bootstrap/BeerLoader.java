package com.nims.msscbeerservice.bootstrap;

import com.nims.msscbeerservice.domain.Beer;
import com.nims.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// at startup because its a spring component,
// this gets picked up and created by spring context
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    // spring will inject a BeerRepository implementation
    // which is provided by Spring Data JPA
    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                    .beerName("Mango Bops")
                    .beerStyle("IPA")
                    .quantityToBrew(100)
                    .minOnHand(11)
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal("11.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ale")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("No Hammers On The Bar")
                    .beerStyle("PALE_ale")
                    .quantityToBrew(300)
                    .minOnHand(13)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("13.95"))
                    .build());
        }
        System.out.println("Loaded Beers: " + beerRepository.count());
    }
}
