package com.zara.princingapp.repository;

import com.zara.princingapp.model.Price;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link PriceRepository}<br/>
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
public interface PriceRepository extends JpaRepository<Price, Integer> {

  List<Price>
      findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
              Integer brandId,
              Integer productId,
              LocalDateTime date1,
              LocalDateTime date2);

}
