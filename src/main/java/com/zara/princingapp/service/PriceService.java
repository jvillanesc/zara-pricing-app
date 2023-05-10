package com.zara.princingapp.service;

import com.zara.princingapp.model.Price;
import com.zara.princingapp.repository.PriceRepository;
import com.zara.princingapp.util.PriceNotExistException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link PriceService}<br/>
 * <b>Copyright</b>: &Copy; 2023 Zara INC;. <br/>
 * <b>Company</b>: Zara INC. <br/>
 *
 * @author Zara INC. <br/>
 *         <u>Service Provider</u>: Capilote SAC<br/>
 *         <u>Developed by</u>: <br/>
 *         <ul>
 *         <li>Jose Villanes C. (Capilote)</li>
 *         </ul>
 *         <u>Changes</u>:<br/>
 *         <ul>
 *         <li>Mar. 10, 2023 Creation class.</li>
 *         </ul>
 * @version 1.0
 */
@Service
public class PriceService {

  @Autowired
  PriceRepository priceRepository;

  /**
   * Get price match parameters.
   *
   * @return Price
   */
  public Price getPrice(Integer brandId, Integer productId, LocalDateTime date) {
    List<Price> prices = priceRepository
            .findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
               brandId,
               productId,
               date,
               date);
    return prices.stream()
            .max(Comparator.comparing(Price::getPriority))
            .orElseThrow(PriceNotExistException::new);
  }

}
