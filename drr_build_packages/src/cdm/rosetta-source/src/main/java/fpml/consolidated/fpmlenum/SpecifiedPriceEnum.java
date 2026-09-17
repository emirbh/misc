package fpml.consolidated.fpmlenum;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 */
@RosettaEnum("SpecifiedPriceEnum")
public enum SpecifiedPriceEnum {

	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Afternoon fixing reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "Afternoon") 
	AFTERNOON("Afternoon", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Ask price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "Ask") 
	ASK("Ask", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Bid price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "Bid") 
	BID("Bid", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Closing price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "Closing") 
	CLOSING("Closing", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the High price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "High") 
	HIGH("High", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Index price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "Index") 
	INDEX("Index", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Average of the Bid and Ask prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "MeanOfBidAndAsk") 
	MEAN_OF_BID_AND_ASK("MeanOfBidAndAsk", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Locational Marginal price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "LocationalMarginal") 
	LOCATIONAL_MARGINAL("LocationalMarginal", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Low price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "Low") 
	LOW("Low", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Marginal Hourly price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "MarginalHourly") 
	MARGINAL_HOURLY("MarginalHourly", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Market Clearing price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "MarketClearing") 
	MARKET_CLEARING("MarketClearing", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Average of the High and Low prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "MeanOfHighAndLow") 
	MEAN_OF_HIGH_AND_LOW("MeanOfHighAndLow", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Morning fixing reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "Morning") 
	MORNING("Morning", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Official price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "Official") 
	OFFICIAL("Official", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Opening price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "Opening") 
	OPENING("Opening", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Official Settlement Price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "OSP") 
	OSP("OSP", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Settlement price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "Settlement") 
	SETTLEMENT("Settlement", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Spot price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "Spot") 
	SPOT("Spot", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Average of the Midpoint of prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "Midpoint") 
	MIDPOINT("Midpoint", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the National Single price reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "NationalSingle") 
	NATIONAL_SINGLE("NationalSingle", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Volume Weighted Average of prices effective on the Pricing Date reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "WeightedAverage") 
	WEIGHTED_AVERAGE("WeightedAverage", null),
	
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Specified Price shall be the Non-volume Weighted Average of prices effective on the Pricing Date reported in or by the relevant Price Source as specified in the relevant Confirmation.
	 *
	 */
	@RosettaEnumValue(value = "UnWeightedAverage") 
	UN_WEIGHTED_AVERAGE("UnWeightedAverage", null)
;
	private static Map<String, SpecifiedPriceEnum> values;
	static {
        Map<String, SpecifiedPriceEnum> map = new ConcurrentHashMap<>();
		for (SpecifiedPriceEnum instance : SpecifiedPriceEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SpecifiedPriceEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SpecifiedPriceEnum fromDisplayName(String name) {
		SpecifiedPriceEnum value = values.get(name);
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
