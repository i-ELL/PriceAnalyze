package analyzer.services;

import java.util.List;
import java.util.Optional;

import analyzer.models.Shop;

public interface ShopService {

    boolean addShop(Shop shop);

    List<Shop> findAll();
    Shop save(Shop shop);

}