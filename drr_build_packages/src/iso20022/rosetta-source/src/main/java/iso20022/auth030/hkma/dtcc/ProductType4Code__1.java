package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the underlying type of product or financial instrument.
 * @version ${project.version}
 */
@RosettaEnum("ProductType4Code__1")
public enum ProductType4Code__1 {

	/**
	 * Identifies categories of instruments that are credits.
	 */
	@RosettaEnumValue(value = "CRDT") 
	CRDT("CRDT", null),
	
	/**
	 * Identifies categories of currency instruments.
	 */
	@RosettaEnumValue(value = "CURR") 
	CURR("CURR", null),
	
	/**
	 * Identifies the nature or type of an equity.
	 */
	@RosettaEnumValue(value = "EQUI") 
	EQUI("EQUI", null),
	
	/**
	 * Identifies categories of instruments that are interest rates based.
	 */
	@RosettaEnumValue(value = "INTR") 
	INTR("INTR", null),
	
	/**
	 * Identifies categories of instruments that are commodities.
	 */
	@RosettaEnumValue(value = "COMM") 
	COMM("COMM", null)
;
	private static Map<String, ProductType4Code__1> values;
	static {
        Map<String, ProductType4Code__1> map = new ConcurrentHashMap<>();
		for (ProductType4Code__1 instance : ProductType4Code__1.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ProductType4Code__1(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ProductType4Code__1 fromDisplayName(String name) {
		ProductType4Code__1 value = values.get(name);
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
