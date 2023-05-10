package com.zara.princingapp.controller;

import com.zara.princingapp.model.Price;
import com.zara.princingapp.service.PriceService;
import com.zara.princingapp.util.PriceNotExistException;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link PriceController}<br/>
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
@RestController
@RequestMapping("/price")
public class PriceController {

  @Autowired
  private PriceService priceService;

  @GetMapping
  ResponseEntity<Price> getEmployee(@RequestParam Integer brandId,
                                    @RequestParam Integer productId,
                                    @RequestParam
                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                    LocalDateTime date) {
    Price price;
    try {
      price = priceService.getPrice(brandId, productId, date);
      return ResponseEntity.ok().body(price);
    } catch (PriceNotExistException e) {
      return ResponseEntity.notFound().build();
    }
  }


}
