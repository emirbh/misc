package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Whether the financial instrument is admitted to trading, or traded on a trading venue or for which a request for admission was made
 * @version 7.7.0
 */
@RosettaEnum("TradableOnTradingVenueEnum")
public enum TradableOnTradingVenueEnum {

	/**
	 * The financial instrument is admitted to trading, or traded on a trading venue or a request for admission was made
	 */
	@RosettaEnumValue(value = "Admitted") 
	ADMITTED("Admitted", null),
	
	/**
	 * The financial instrument is not admitted to trading or traded on a trading venue or no request for admission has been made
	 */
	@RosettaEnumValue(value = "NotAdmitted") 
	NOT_ADMITTED("NotAdmitted", null),
	
	/**
	 * If the reporting party cannot determine whether the instrument is listed or not, as per jurisdictional requirements
	 */
	@RosettaEnumValue(value = "Unknown") 
	UNKNOWN("Unknown", null)
;
	private static Map<String, TradableOnTradingVenueEnum> values;
	static {
        Map<String, TradableOnTradingVenueEnum> map = new ConcurrentHashMap<>();
		for (TradableOnTradingVenueEnum instance : TradableOnTradingVenueEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	TradableOnTradingVenueEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static TradableOnTradingVenueEnum fromDisplayName(String name) {
		TradableOnTradingVenueEnum value = values.get(name);
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
