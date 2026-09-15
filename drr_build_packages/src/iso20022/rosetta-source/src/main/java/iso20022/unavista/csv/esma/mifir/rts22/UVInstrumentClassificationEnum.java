package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The classification of the underlying instrument that is used in accordance with the XML schema published by ESMA
 * @version ${project.version}
 */
@RosettaEnum("UVInstrumentClassificationEnum")
public enum UVInstrumentClassificationEnum {

	/**
	 * Instrument received by the buyer wich consists of a single instrument
	 */
	@RosettaEnumValue(value = "SwapInSingle") 
	SWAP_IN_SINGLE("SwapInSingle", null),
	
	/**
	 * Instrument received by the buyer wich consists of multiple instruments
	 */
	@RosettaEnumValue(value = "SwapInBasket") 
	SWAP_IN_BASKET("SwapInBasket", null),
	
	/**
	 * Instrument paid by the buyer wich consists of a single instrument
	 */
	@RosettaEnumValue(value = "SwapOutSingle") 
	SWAP_OUT_SINGLE("SwapOutSingle", null),
	
	/**
	 * Instrument paid by the buyer wich consists of multiple instruments
	 */
	@RosettaEnumValue(value = "SwapOutBasket") 
	SWAP_OUT_BASKET("SwapOutBasket", null),
	
	/**
	 * Underlying of any other type of transaction, instrument consists of a single instrument
	 */
	@RosettaEnumValue(value = "OtherSingle") 
	OTHER_SINGLE("OtherSingle", null),
	
	/**
	 * Underlying of any other type of transaction, instrument consists of multiple instruments
	 */
	@RosettaEnumValue(value = "OtherBasket") 
	OTHER_BASKET("OtherBasket", null)
;
	private static Map<String, UVInstrumentClassificationEnum> values;
	static {
        Map<String, UVInstrumentClassificationEnum> map = new ConcurrentHashMap<>();
		for (UVInstrumentClassificationEnum instance : UVInstrumentClassificationEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	UVInstrumentClassificationEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static UVInstrumentClassificationEnum fromDisplayName(String name) {
		UVInstrumentClassificationEnum value = values.get(name);
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
