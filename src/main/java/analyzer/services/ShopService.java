package analyzer.services;

import java.util.List;

import analyzer.domain.models.Shop;

public interface ShopService {

    boolean addShop(Shop shop);

    List<Shop> findAll();
    Shop save(Shop shop);

}