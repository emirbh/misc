package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("NotionalCurrency2TypeEnum")
public enum NotionalCurrency2TypeEnum {

	/**
	 * Interest
	 */
	@RosettaEnumValue(value = "Intrst") 
	INTRST("Intrst", null),
	
	/**
	 * FX
	 */
	@RosettaEnumValue(value = "FX") 
	FX("FX", null)
;
	private static Map<String, NotionalCurrency2TypeEnum> values;
	static {
        Map<String, NotionalCurrency2TypeEnum> map = new ConcurrentHashMap<>();
		for (NotionalCurrency2TypeEnum instance : NotionalCurrency2TypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NotionalCurrency2TypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NotionalCurrency2TypeEnum fromDisplayName(String name) {
		NotionalCurrency2TypeEnum value = values.get(name);
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
