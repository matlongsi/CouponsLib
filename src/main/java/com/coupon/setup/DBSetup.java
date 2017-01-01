package com.coupon.setup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBSetup {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/";
	static final String OPS_DB_NAME = "COUPONS_OPS";
	
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "man0jdas";

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		
		try{
			
			//register JDBC driver
			Class.forName(JDBC_DRIVER);

			//open a connection
			System.out.println("Connecting to database server ...");		//log in future
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			//create new database
			sql = "CREATE DATABASE " + OPS_DB_NAME;
			stmt.executeUpdate(sql);
			System.out.println(OPS_DB_NAME + " database created successfully! ");
			
			//select new database for creating tables
			sql = "USE " + OPS_DB_NAME;
			stmt.executeUpdate(sql);
			
			//create tables
			System.out.println("Creating tables:");
			int count = 0;
			sql = "CREATE TABLE coupon_tbl("
					+ "coupon_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "offer_issuer_fk BIGINT UNSIGNED NOT NULL REFERENCES global_location_number_tbl(gln_tbl_id), "
					+ "offer_issuer_clearing_agent_fk BIGINT UNSIGNED DEFAULT NULL REFERENCES global_location_number_tbl(gln_tbl_id), "
					+ "offer_distributor_fk BIGINT UNSIGNED NOT NULL REFERENCES global_location_number_tbl(gln_tbl_id), "
					+ "coupon_offer_fk BIGINT UNSIGNED NOT NULL REFERENCES global_coupon_number_tbl(gcn_tbl_id), "
					+ "start_date_time DATETIME NOT NULL, "
					+ "end_date_time DATETIME NOT NULL, "
					+ "offer_type_code ENUM('MANUFACTURER_COUPON', 'NON_MANUFACTURER_COUPON') NOT NULL, "
					+ "time_zone VARCHAR(50) NOT NULL, "
					+ "status ENUM('SETUP', 'PENDING', 'ACTIVE', 'INACTIVE') NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert  DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (coupon_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". coupon_tbl");

			sql = "CREATE TABLE offer_distribution_detail_tbl("
					+ "odd_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "cpn_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES coupon_tbl(coupon_tbl_id), "
					+ "maximum_offer_acquisitions INT UNSIGNED DEFAULT NULL, "
					+ "total_acquisition_count BIGINT UNSIGNED DEFAULT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (odd_tbl_id), "
					+ "UNIQUE (cpn_tbl_fk)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_distribution_detail_tbl");
	    
			sql = "CREATE TABLE offer_publication_period_tbl("
					+ "opp_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "odd_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES offer_distribution_details_tbl(odd_tbl_id), "
					+ "start_date_time DATETIME NOT NULL, "
					+ "end_date_time DATETIME NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (opp_tbl_id), "
					+ "UNIQUE (odd_tbl_fk)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_publication_period_tbl");
	
			sql = "CREATE TABLE offer_acquisition_period_tbl("
					+ "oap_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "odd_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES offer_distribution_details_tbl(odd_tbl_id), "
					+ "start_date_time DATETIME NOT NULL, "
					+ "end_date_time DATETIME NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (oap_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_acquisition_period_tbl");
	    
			sql = "CREATE TABLE offer_marketing_material_tbl("				
					+ "omm_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "cpn_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES coupon_tbl(coupon_tbl_id), "
					+ "brand_name VARCHAR(50) DEFAULT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (omm_tbl_id), "
					+ "UNIQUE (cpn_tbl_fk)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_marketing_material_tbl");
	    
			sql = "CREATE TABLE offer_short_description_tbl("
					+ "osd_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "omm_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES offer_marketing_material_tbl(omm_tbl_id), "
					+ "short_description VARCHAR(80) NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (osd_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_short_description_tbl");
	    
			sql = "CREATE TABLE offer_long_description_tbl("
					+ "old_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "omm_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES offer_marketing_material_tbl(omm_tbl_id), "
					+ "long_description VARCHAR(200) NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (old_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_long_description_tbl");
	    
			sql = "CREATE TABLE offer_legal_statement_tbl("
					+ "ols_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "omm_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES offer_marketing_material_tbl(omm_tbl_id), "
					+ "legal_statement VARCHAR(1000) NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (ols_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_legal_statement_tbl");
	    
			sql = "CREATE TABLE offer_product_category_tbl("
					+ "opc_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "omm_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES offer_marketing_material_tbl(omm_tbl_id), "
					+ "product_category VARCHAR(80) NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (opc_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_product_category_tbl");
	    
			sql = "CREATE TABLE offer_artwork_tbl("
					+ "oa_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "omm_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES offer_marketing_material_tbl(omm_tbl_id), "	//TODO: align 1:N relationship with XSD
					+ "type_code ENUM('PRODUCT_IMAGE', 'OFFER_VIDEO', 'OFFER_LEAFLET') NOT NULL, "
					+ "file_name VARCHAR(100) NOT NULL, "
					+ "file_format_name VARCHAR(50) NOT NULL, "
					+ "file_uri VARCHAR(100) DEFAULT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (oa_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_artwork_tbl");
	    
			sql = "CREATE TABLE file_content_description_tbl("
					+ "fcd_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "oa_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES offer_artwork_tbl(oa_tbl_id), "
					+ "file_content_description VARCHAR(80) NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (fcd_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". file_content_description_tbl");
	    
			sql = "CREATE TABLE offer_usage_condition_tbl("
					+ "ouc_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "cpn_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES coupon_tbl(coupon_tbl_id), "
					+ "maximum_cumulative_uses TINYINT UNSIGNED DEFAULT NULL, "
					+ "maximum_uses_per_transaction TINYINT UNSIGNED DEFAULT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (ouc_tbl_id), "
					+ "UNIQUE (cpn_tbl_fk)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_usage_condition_tbl");
	    
			sql = "CREATE TABLE offer_financial_settlement_detail_tbl("
					+ "ofsd_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "cpn_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES coupon_tbl(coupon_tbl_id), "
					+ "offer_clearing_instructions VARCHAR(500) DEFAULT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (ofsd_tbl_id), "
					+ "UNIQUE (cpn_tbl_fk)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_financial_settlement_detail_tbl");
	    
			sql = "CREATE TABLE offer_awarder_detail_tbl("
					+ "oad_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "cpn_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES coupon_tbl(coupon_tbl_id), "
					+ "offer_awarder_fk BIGINT UNSIGNED NOT NULL REFERENCES global_location_number_tbl(gln_tbl_id), "
					+ "offer_awarder_clearing_agent_fk BIGINT UNSIGNED DEFAULT NULL REFERENCES global_location_number_tbl(gln_tbl_id), "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (oad_tbl_id), "
					+ "UNIQUE (cpn_tbl_fk, offer_awarder_fk)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_awarder_detail_tbl");
	    
			sql = "CREATE TABLE offer_awarder_point_of_sale_tbl("
					+ "oapos_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "oad_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES offer_awarder_detail_tbl(oad_tbl_id), "
					+ "store_gln_fk BIGINT UNSIGNED DEFAULT NULL REFERENCES global_location_number_tbl(gln_tbl_id), "
					+ "store_internal_id VARCHAR(20) DEFAULT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (oapos_tbl_id), "
					+ "UNIQUE (oad_tbl_fk, store_gln_fk)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_awarder_point_of_sale_tbl");
	    
			sql = "CREATE TABLE offer_redemption_period_tbl("
					+ "orp_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "oad_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES offer_awarder_detail_tbl(oad_tbl_id), "
					+ "start_date_time DATETIME NOT NULL, "
					+ "end_date_time DATETIME NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (orp_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_redemption_period_tbl");
	    
			sql = "CREATE TABLE offer_reward_tbl("
					+ "or_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "cpn_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES coupon_tbl(coupon_tbl_id), "
					+ "reward_type_code ENUM('MONETARY_REWARD', 'LOYALTY_POINTS_REWARD', 'TRADE_ITEM_REWARD') NOT NULL, "
					+ "reward_monetary_amount DECIMAL(10, 2), "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (or_tbl_id), "
					+ "UNIQUE (cpn_tbl_fk)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_reward_tbl");
	    
			sql = "CREATE TABLE offer_reward_loyalty_points_tbl("
					+ "orlp_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "or_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES offer_reward_tbl(or_tbl_id), "
					+ "loyalty_program_name VARCHAR(50) NOT NULL, "
					+ "loyalty_points_quantity INT UNSIGNED NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (orlp_tbl_id), "
					+ "UNIQUE (or_tbl_fk, loyalty_program_name)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_reward_loyalty_points_tbl");
			
			sql = "CREATE TABLE offer_reward_trade_item_tbl("
					+ "orti_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "or_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES offer_reward_tbl(or_tbl_id), "
					+ "trade_item_gtin_fk BIGINT UNSIGNED NOT NULL REFERENCES global_trade_item_number_tbl(gtin_tbl_id), "
					+ "trade_item_quantity SMALLINT UNSIGNED NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (orti_tbl_id), "
					+ "UNIQUE (or_tbl_fk, trade_item_gtin_fk)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_reward_trade_item_tbl");

			sql = "CREATE TABLE purchase_requirement_tbl("
					+ "pr_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "cpn_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES coupon_tbl(coupon_tbl_id), "
					+ "purchase_requirement_type_code ENUM('ALL_SPECIFIED_ITEMS', 'ONE_OF_SPECIFIED_ITEMS', 'ONE_ITEM_PER_GROUP', 'SPECIFIED_PURCHASE_AMOUNT') NOT NULL, "
					+ "purchase_requirement_monetary_amount DECIMAL(10, 2) DEFAULT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (pr_tbl_id), "
					+ "UNIQUE (cpn_tbl_fk)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". purchase_requirement_tbl");
	    
			sql = "CREATE TABLE purchase_requirement_trade_item_tbl("
					+ "prti_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "pr_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES purchase_requirements_tbl(pr_tbl_id), "
					+ "trade_item_gtin_fk BIGINT UNSIGNED NOT NULL REFERENCES global_trade_item_number_tbl(gtin_tbl_id), "
					+ "trade_item_quantity SMALLINT UNSIGNED NOT NULL, "
					+ "trade_item_group VARCHAR(50) DEFAULT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (prti_tbl_id), "
					+ "UNIQUE (pr_tbl_fk, trade_item_gtin_fk)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". purchase_requirement_trade_item_tbl");
	    
			sql = "CREATE TABLE global_location_number_tbl("
					+ "gln_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "company_prefix INT(11) UNSIGNED ZEROFILL NOT NULL, "
					+ "location_reference MEDIUMINT(5) UNSIGNED ZEROFILL NOT NULL, "
					+ "check_digit TINYINT(1) UNSIGNED NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (gln_tbl_id), "
					+ "UNIQUE (company_prefix, location_reference, check_digit)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". global_location_number_tbl");
	    
			sql = "CREATE TABLE global_trade_identification_number_tbl("
					+ "gtin_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "company_prefix INT(11) UNSIGNED ZEROFILL NOT NULL, "
					+ "item_reference MEDIUMINT(5) UNSIGNED ZEROFILL NOT NULL, "
					+ "check_digit TINYINT(1) UNSIGNED NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (gtin_tbl_id), "
					+ "UNIQUE (company_prefix, item_reference, check_digit))"
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". global_trade_identification_number_tbl");
	    
			sql = "CREATE TABLE global_coupon_number_tbl("
					+ "gcn_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "company_prefix INT(11) UNSIGNED ZEROFILL NOT NULL, "
					+ "coupon_reference MEDIUMINT(5) UNSIGNED ZEROFILL NOT NULL, "
					+ "check_digit TINYINT(1) UNSIGNED NOT NULL, "
					+ "serial_component INT(12) UNSIGNED ZEROFILL DEFAULT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (gcn_tbl_id), "
					+ "UNIQUE (company_prefix, coupon_reference, check_digit, serial_component)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". global_coupon_number_tbl");
	    
			sql = "CREATE TABLE global_service_relation_number_tbl("
					+ "gsrn_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "company_prefix INT(11) UNSIGNED ZEROFILL NOT NULL, "
					+ "service_reference INT(10) UNSIGNED ZEROFILL NOT NULL, "
					+ "check_digit TINYINT(1) UNSIGNED NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (gsrn_tbl_id), "
					+ "UNIQUE (company_prefix, service_reference, check_digit)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". global_service_relation_number_tbl");

			sql = "CREATE TABLE offer_setup_tbl("
					+ "offer_setup_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "cpn_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES coupon_tbl(coupon_tbl_id), "
					+ "sender_fk BIGINT UNSIGNED NOT NULL REFERENCES global_location_number_tbl(gln_tbl_id), "
					+ "recipient_fk BIGINT UNSIGNED NOT NULL REFERENCES global_location_number_tbl(gln_tbl_id), "
					+ "init_date_time DATETIME NOT NULL, "
					+ "acknowledgement_date_time DATETIME DEFAULT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (offer_setup_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_setup_tbl");

			sql = "CREATE TABLE offer_notification_tbl("
					+ "offer_notification_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "cpn_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES coupon_tbl(coupon_tbl_id), "
					+ "sender_fk BIGINT UNSIGNED NOT NULL REFERENCES global_location_number_tbl(gln_tbl_id), "
					+ "recipient_fk BIGINT UNSIGNED NOT NULL REFERENCES global_location_number_tbl(gln_tbl_id), "
					+ "init_date_time DATETIME NOT NULL, "
					+ "acknowledgement_date_time DATETIME DEFAULT NULL, "
					+ "response_code ENUM('ACCEPT', 'REJECT', 'CHANGES_NEEDED') DEFAULT NULL, "
					+ "response_date_time DATETIME DEFAULT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (offer_notification_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". offer_notification_tbl");

			sql = "CREATE TABLE coupon_acquisition_tbl("
					+ "coupon_acquisition_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "gcn_tbl_fk BIGINT UNSIGNED DEFAULT NULL REFERENCES global_coupon_number_tbl(gcn_tbl_id), "
					+ "gsrn_tbl_fk BIGINT UNSIGNED DEFAULT NULL REFERENCES global_service_relation_number_tbl(gsrn_tbl_id), "
					+ "alternate_account_id VARCHAR(20) DEFAULT NULL, "
					+ "acquisition_date_time DATETIME DEFAULT NULL, "
					+ "response_code ENUM('REDEEMABLE', 'NOT_REDEEMABLE') DEFAULT NULL, "
					+ "acknowledgement_date_time DATETIME DEFAULT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (coupon_acquisition_id), "
					+ "UNIQUE (gcn_tbl_fk, gsrn_tbl_fk, alternate_account_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". coupon_acquisition_notification_id");

			sql = "CREATE TABLE coupon_redemption_record_tbl("
					+ "coupon_redemption_record_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "store_gln_fk BIGINT UNSIGNED NOT NULL REFERENCES global_location_number_tbl(gln_tbl_id), "
					+ "store_internal_id VARCHAR(20) DEFAULT NULL, "
					+ "pos_terminal_id VARCHAR(20) DEFAULT NULL, "
					+ "coupon_instance_fk BIGINT UNSIGNED DEFAULT NULL REFERENCES global_coupon_number_tbl(gcn_tbl_id), "
					+ "account_number_fk BIGINT UNSIGNED DEFAULT NULL REFERENCES global_service_relation_number_tbl(gsrn_tbl_id), "
					+ "alternate_account_id VARCHAR(20) DEFAULT NULL, "
					+ "redemption_date_time DATETIME DEFAULT NULL, "
					+ "validation_override_reference VARCHAR(20) DEFAULT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (coupon_redemption_record_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". coupon_redemption_record_tbl");

			sql = "CREATE TABLE coupon_reward_tbl("
					+ "cr_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "coupon_redemption_record_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES coupon_redemption_record_tbl(coupon_redemption_record_tbl_id), "
					+ "reward_type_code ENUM('MONETARY_REWARD', 'LOYALTY_POINTS_REWARD', 'TRADE_ITEM_REWARD') DEFAULT NULL, "
					+ "rewarded_monetary_amount DECIMAL(10, 2), "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (cr_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". coupon_reward_tbl");

			sql = "CREATE TABLE coupon_reward_loyalty_points_tbl("
					+ "crlp_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "cr_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES coupon_reward_tbl(cr_tbl_id), "
					+ "loyalty_program_name VARCHAR(50) DEFAULT NULL, "
					+ "rewarded_loyalty_points_quantity INT UNSIGNED NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (crlp_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". coupon_reward_loyalty_points_tbl");

			sql = "CREATE TABLE coupon_reward_trade_item_tbl("
					+ "crti_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "cr_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES coupon_reward_tbl(cr_tbl_id), "
					+ "trade_item_gtin_fk BIGINT UNSIGNED NOT NULL REFERENCES global_trade_item_number_tbl(gtin_tbl_id), "
					+ "trade_item_quantity SMALLINT UNSIGNED NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (crti_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". coupon_reward_trade_item_tbl");

			sql = "CREATE TABLE qualifying_purchase_tbl("
					+ "qp_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "coupon_redemption_record_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES coupon_redemption_record_tbl(coupon_redemption_record_tbl_id), "
					+ "qualifying_purchase_monetary_amount DECIMAL(10, 2), "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (qp_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". qualifying_purchase_tbl");

			sql = "CREATE TABLE qualifying_purchase_trade_item_tbl("
					+ "qpti_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "qp_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES qualifying_purchase_tbl(qp_tbl_id), "
					+ "trade_item_gtin_fk BIGINT UNSIGNED NOT NULL REFERENCES global_trade_item_number_tbl(gtin_tbl_id), "
					+ "trade_item_quantity SMALLINT UNSIGNED NOT NULL, "
					+ "trade_item_group VARCHAR(50) DEFAULT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (qpti_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". qualifying_purchase_trade_item_tbl");

			sql = "CREATE TABLE validate_redemption_record_tbl("
					+ "vrr_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "coupon_instance_fk BIGINT UNSIGNED DEFAULT NULL REFERENCES global_coupon_number_tbl(gcn_tbl_id), "
					+ "awarder_gln_fk BIGINT UNSIGNED NOT NULL REFERENCES global_location_number_tbl(gln_tbl_id), "
					+ "account_number_fk BIGINT UNSIGNED DEFAULT NULL REFERENCES global_service_relation_number_tbl(gsrn_tbl_id), "
					+ "alternate_account_id VARCHAR(20) DEFAULT NULL, "
					+ "validate_date_time DATETIME DEFAULT NULL, "
					+ "redeemable TINYINT(1) NOT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (vrr_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". validate_redemption_record_tbl");

			sql = "CREATE TABLE validate_purchase_tbl("
					+ "vp_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "vrr_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES validate_redemption_record_tbl(vrr_tbl_id), "
					+ "purchase_monetary_amount DECIMAL(10, 2), "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (vp_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". validate_purchase_tbl");

			sql = "CREATE TABLE validate_purchase_trade_item_tbl("
					+ "vpti_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "vp_tbl_fk BIGINT UNSIGNED NOT NULL REFERENCES validate_purchase_tbl(vp_tbl_id), "
					+ "trade_item_gtin_fk BIGINT UNSIGNED NOT NULL REFERENCES global_trade_item_number_tbl(gtin_tbl_id), "
					+ "trade_item_quantity SMALLINT UNSIGNED NOT NULL, "
					+ "trade_item_group VARCHAR(50) DEFAULT NULL, "
					+ "stamp_update DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert DATETIME DEFAULT CURRENT_TIMESTAMP, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (vpti_tbl_id)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". validate_purchase_trade_item_tbl");

		}
		catch(SQLException se) {
		      //handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e) {
		      //handle errors for Class.forName
		      e.printStackTrace();
		}
		finally {
			//finally close resources
			try{
				if(stmt != null)
					stmt.close();
				if(conn != null)
		        	conn.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}

		System.out.println("Database setup complete.");

	}

}
