package com.shop.shop.config;

import com.shop.shop.model.Client;
import com.shop.shop.model.Order;
import com.shop.shop.model.Product;
import com.shop.shop.model.enums.OrderStatus;
import com.shop.shop.model.enums.ProductCategory;
import com.shop.shop.repository.ClientRepository;
import com.shop.shop.repository.OrderRepository;
import com.shop.shop.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ClientOrderProductConfig {
    @Bean
    CommandLineRunner commandLineRunnerClient(ClientRepository clientRepository, OrderRepository orderRepository,
                                              ProductRepository productRepository) {
        return args -> {
            Client client1 = new Client(1L, "Maria Adam", "Paris, Rue de la Concorde, No. 5",
                    "maria1@yahoo.com", new BCryptPasswordEncoder().encode("12345678"),
                    "0722345628");
            Client client2 = new Client(2L, "Dana Marin", "Bucharest, N. Leroy, No. 10",
                    "dana1@yahoo.com", new BCryptPasswordEncoder().encode("12345678"),
                    "0723174259");
            Client client3 = new Client(3L, "Marian Dragan", "Rabat, Charles de Gaulle, No. 15",
                    "marian1@yahoo.com", new BCryptPasswordEncoder().encode("12345678"),
                    "0724581654");


            clientRepository.saveAll(List.of(client1, client2, client3));

            Order order1 = new Order(1L, "order gladiolus", 14280, 23.1, OrderStatus.COMPLETED,
                    LocalDate.of(2022, 8, 3), client2);
            Order order2 = new Order(2L, "order hyacinth", 14281, 15.28, OrderStatus.REFUNDED,
                            LocalDate.of(2021, 10, 25), client2);
            Order order3 = new Order(3L, "order freesia", 14282, 43.75, OrderStatus.PENDING,
                    LocalDate.of(2018, 3, 2), client1);
            Order order4 = new Order(4L, "order peonies", 14283, 28.34, OrderStatus.CANCELLED,
                            LocalDate.of(2023, 6, 23), client1);
            Order order5 = new Order(5L, "order paunches", 14284, 73.52, OrderStatus.SHIPPED,
                    LocalDate.of(2019, 5, 12), client3);
            Order order6 = new Order(6L, "order lilac", 14285, 140.25, OrderStatus.COMPLETED,
                    LocalDate.of(2021, 4, 18), client3);

            orderRepository.saveAll(List.of(order1, order2, order3, order4, order5, order6));

            Product product1 = new Product(1L, "Tulips 1", "tulip bulbs 1", 22.3,
                    ProductCategory.GARDEN);
            Product product2 = new Product(2L, "Freesia 2", "freesia double bulbs 2", 401.57,
                    ProductCategory.HOUSE);
            Product product3 = new Product(3L, "Roses 3", "red roses 3", 208.7,
                    ProductCategory.BOUQUETS);
            Product product4 = new Product(4L, "Lilac 4", "royal red lilac 4", 18.25,
                    ProductCategory.ORNAMENTAL);
            Product product5 = new Product(5L, "Geranium 5", "potted geranium 5", 4200.8,
                    ProductCategory.SEEDS);

            productRepository.saveAll(List.of(product1, product2, product3, product4, product5));
        };
    }
}
