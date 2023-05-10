package com.zara.princingapp.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link Price}<br/>
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
@Entity
@Table(name = "PRICE")
@Getter
public class Price {

  @Column(name = "ID")
  @Id
  Integer id;

  @Column(name = "BRAND_ID")
  Integer brandId;

  @Column(name = "START_DATE")
  LocalDateTime startDate;

  @Column(name = "END_DATE")
  LocalDateTime endDate;

  @Column(name = "PRICE_LIST")
  Integer priceList;

  @Column(name = "PRODUCT_ID")
  Integer productId;

  @Column(name = "PRIORITY")
  Integer priority;

  @Column(name = "PRICE")
  Double priceValue;

  @Column(name = "CURR")
  String currency;

}
