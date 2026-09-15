package drr.enrichment.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbUpiRequestTypeEnum")
public enum AnnaDsbUpiRequestTypeEnum {

	@RosettaEnumValue(value = "ProductRequest") 
	PRODUCT_REQUEST("ProductRequest", null),
	
	@RosettaEnumValue(value = "UnderlyingProductRequest") 
	UNDERLYING_PRODUCT_REQUEST("UnderlyingProductRequest", null)
;
	private static Map<String, AnnaDsbUpiRequestTypeEnum> values;
	static {
        Map<String, AnnaDsbUpiRequestTypeEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbUpiRequestTypeEnum instance : AnnaDsbUpiRequestTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbUpiRequestTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbUpiRequestTypeEnum fromDisplayName(String name) {
		AnnaDsbUpiRequestTypeEnum value = values.get(name);
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
