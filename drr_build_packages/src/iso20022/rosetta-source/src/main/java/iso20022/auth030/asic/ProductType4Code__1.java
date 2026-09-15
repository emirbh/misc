package iso20022.auth030.asic;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("ProductType4Code__1")
public enum ProductType4Code__1 {

	@RosettaEnumValue(value = "CRDT") 
	CRDT("CRDT", null),
	
	@RosettaEnumValue(value = "CURR") 
	CURR("CURR", null),
	
	@RosettaEnumValue(value = "EQUI") 
	EQUI("EQUI", null),
	
	@RosettaEnumValue(value = "INTR") 
	INTR("INTR", null),
	
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
