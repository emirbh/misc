package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbUnderlyingAssetTypeEnum")
public enum AnnaDsbUnderlyingAssetTypeEnum {

	/**
	 * Agriculture
	 */
	@RosettaEnumValue(value = "Agriculture", displayName = "Agriculture") 
	AGRICULTURE("Agriculture", "Agriculture"),
	
	/**
	 * Basis Swap (Float - Float)
	 */
	@RosettaEnumValue(value = "Basis_Swap_Float_Float_", displayName = "Basis Swap (Float - Float)") 
	BASIS_SWAP_FLOAT_FLOAT("Basis_Swap_Float_Float_", "Basis Swap (Float - Float)"),
	
	/**
	 * In case the product has multiple underliers
	 */
	@RosettaEnumValue(value = "Basket", displayName = "Basket") 
	BASKET("Basket", "Basket"),
	
	/**
	 * family of standardized credit derivative indices, where the underlying reference entities are a defined basket of credit from a particular geographic region (for instance, Asia, North America, Europe, etc.), and/or credit rating level (for instance Emerging Markets, high yield, investment grade, etc.); credit default indices trade in standard maturities, and the reference entities are typically the most liquid; the reference portfolio is reassessed periodically to maintain this
	 */
	@RosettaEnumValue(value = "CDS_on_Index", displayName = "CDS on Index") 
	CDS_ON_INDEX("CDS_on_Index", "CDS on Index"),
	
	/**
	 * a synthetic CDO based on a CDS index where each tranche references a different segment of the loss distribution of the underlying CDS index; each tranche has a different priority of claims on the principal and interest flows from the collateral pool, and are traditionally portioned into rising levels of seniority
	 */
	@RosettaEnumValue(value = "CDS_on_Index_Tranche", displayName = "CDS on Index Tranche") 
	CDS_ON_INDEX_TRANCHE("CDS_on_Index_Tranche", "CDS on Index Tranche"),
	
	/**
	 * a CDS where the underlying risk is a single reference entity or single reference obligation
	 */
	@RosettaEnumValue(value = "CDS_on_Single_Name", displayName = "CDS on Single Name") 
	CDS_ON_SINGLE_NAME("CDS_on_Single_Name", "CDS on Single Name"),
	
	/**
	 * Energy
	 */
	@RosettaEnumValue(value = "Energy", displayName = "Energy") 
	ENERGY("Energy", "Energy"),
	
	/**
	 * Environmental
	 */
	@RosettaEnumValue(value = "Environmental", displayName = "Environmental") 
	ENVIRONMENTAL("Environmental", "Environmental"),
	
	/**
	 * Fertilizer
	 */
	@RosettaEnumValue(value = "Fertilizer", displayName = "Fertilizer") 
	FERTILIZER("Fertilizer", "Fertilizer"),
	
	/**
	 * Fixed - Fixed
	 */
	@RosettaEnumValue(value = "Fixed_Fixed", displayName = "Fixed - Fixed") 
	FIXED_FIXED("Fixed_Fixed", "Fixed - Fixed"),
	
	/**
	 * Fixed - Floating
	 */
	@RosettaEnumValue(value = "Fixed_Floating", displayName = "Fixed - Floating") 
	FIXED_FLOATING("Fixed_Floating", "Fixed - Floating"),
	
	/**
	 * Forward
	 */
	@RosettaEnumValue(value = "Forward", displayName = "Forward") 
	FORWARD("Forward", "Forward"),
	
	/**
	 * Forwards
	 */
	@RosettaEnumValue(value = "Forwards", displayName = "Forwards") 
	FORWARDS("Forwards", "Forwards"),
	
	/**
	 * Freight
	 */
	@RosettaEnumValue(value = "Freight", displayName = "Freight") 
	FREIGHT("Freight", "Freight"),
	
	/**
	 * Futures
	 */
	@RosettaEnumValue(value = "Futures", displayName = "Futures") 
	FUTURES("Futures", "Futures"),
	
	/**
	 * Index
	 */
	@RosettaEnumValue(value = "Index", displayName = "Index") 
	INDEX("Index", "Index"),
	
	/**
	 * a synthetic Collaterized Debt Obligation (CDO) based on a CDS index where each tranche references a different segment of the loss distribution of the underlying CDS index; each tranche has a different priority of claims on the principal and interest flows from the collateral pool, and are traditionally portioned into rising levels of seniority
	 */
	@RosettaEnumValue(value = "Index_Tranche", displayName = "Index Tranche") 
	INDEX_TRANCHE("Index_Tranche", "Index Tranche"),
	
	/**
	 * Inflation rate index
	 */
	@RosettaEnumValue(value = "Inflation_Rate_Index", displayName = "Inflation Rate Index") 
	INFLATION_RATE_INDEX("Inflation_Rate_Index", "Inflation Rate Index"),
	
	/**
	 * Interest Rate Index
	 */
	@RosettaEnumValue(value = "Interest_Rate_Index", displayName = "Interest Rate Index") 
	INTEREST_RATE_INDEX("Interest_Rate_Index", "Interest Rate Index"),
	
	/**
	 * Metals
	 */
	@RosettaEnumValue(value = "Metals", displayName = "Metals") 
	METALS("Metals", "Metals"),
	
	/**
	 * Multi Commodity
	 */
	@RosettaEnumValue(value = "Multi_Commodity", displayName = "Multi Commodity") 
	MULTI_COMMODITY("Multi_Commodity", "Multi Commodity"),
	
	/**
	 * Options
	 */
	@RosettaEnumValue(value = "Options", displayName = "Options") 
	OPTIONS("Options", "Options"),
	
	@RosettaEnumValue(value = "Other", displayName = "Other") 
	OTHER("Other", "Other"),
	
	/**
	 * Overnight Index Swap (OIS)
	 */
	@RosettaEnumValue(value = "Overnight_Index_Swap_OIS_", displayName = "Overnight Index Swap (OIS)") 
	OVERNIGHT_INDEX_SWAP_OIS("Overnight_Index_Swap_OIS_", "Overnight Index Swap (OIS)"),
	
	/**
	 * Paper
	 */
	@RosettaEnumValue(value = "Paper", displayName = "Paper") 
	PAPER("Paper", "Paper"),
	
	/**
	 * Polypropylene Products
	 */
	@RosettaEnumValue(value = "Polypropylene_Products", displayName = "Polypropylene Products") 
	POLYPROPYLENE_PRODUCTS("Polypropylene_Products", "Polypropylene Products"),
	
	/**
	 * the underlying risk is a single reference entity or reference obligation
	 */
	@RosettaEnumValue(value = "Single_Name", displayName = "Single Name") 
	SINGLE_NAME("Single_Name", "Single Name"),
	
	/**
	 * single equity stock
	 */
	@RosettaEnumValue(value = "Single_Stock", displayName = "Single Stock") 
	SINGLE_STOCK("Single_Stock", "Single Stock"),
	
	/**
	 * a forward on an FX transaction in which two parties agree to buy one currency against selling another currency at an agreed price for settlement on the spot date
	 */
	@RosettaEnumValue(value = "Spot", displayName = "Spot") 
	SPOT("Spot", "Spot"),
	
	/**
	 * Swap
	 */
	@RosettaEnumValue(value = "Swap", displayName = "Swap") 
	SWAP("Swap", "Swap"),
	
	@RosettaEnumValue(value = "Swaps", displayName = "Swaps") 
	SWAPS("Swaps", "Swaps"),
	
	/**
	 * the variability of movements in a security or underlying instrument&#39;s price; it is a measure of the amount by which an asset&#39;s price is expected to fluctuate over a given period of time; it is normally measured by the annual standard deviation of daily price changes
	 */
	@RosettaEnumValue(value = "Volatility", displayName = "Volatility") 
	VOLATILITY("Volatility", "Volatility"),
	
	/**
	 * an interest rate swap in which the fixed rate cash flows are compounded and paid once on the expiration data, rather than periodically; the payments on the other side (which can be based on a floating rate or a fixed rate) follow typical swap payment schedules
	 */
	@RosettaEnumValue(value = "Zero_Coupon", displayName = "Zero Coupon") 
	ZERO_COUPON("Zero_Coupon", "Zero Coupon")
;
	private static Map<String, AnnaDsbUnderlyingAssetTypeEnum> values;
	static {
        Map<String, AnnaDsbUnderlyingAssetTypeEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbUnderlyingAssetTypeEnum instance : AnnaDsbUnderlyingAssetTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbUnderlyingAssetTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbUnderlyingAssetTypeEnum fromDisplayName(String name) {
		AnnaDsbUnderlyingAssetTypeEnum value = values.get(name);
		if (value == null) {
			throw new IllegalArgumentException("No enum constant with display name \"" + name + "\".");
		}
		return value;
	}

	@Override
	public String toString() {
		return toDisplayString();
	}

	public String toDisplayString() {
		return displayName != null ?  displayName : rosettaName;
	}
}
