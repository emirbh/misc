package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbUnderlierIDSourceEnum")
public enum AnnaDsbUnderlierIDSourceEnum {

	/**
	 * CCY
	 */
	@RosettaEnumValue(value = "CCY") 
	CCY("CCY", null),
	
	/**
	 * Commodity Index
	 */
	@RosettaEnumValue(value = "COIDX") 
	COIDX("COIDX", null),
	
	/**
	 * Commodity Reference Price
	 */
	@RosettaEnumValue(value = "COMM") 
	COMM("COMM", null),
	
	/**
	 * Credit Index
	 */
	@RosettaEnumValue(value = "CRIDX") 
	CRIDX("CRIDX", null),
	
	/**
	 * CUSIP code of the underlying instrument
	 */
	@RosettaEnumValue(value = "CUSIP") 
	CUSIP("CUSIP", null),
	
	/**
	 * Equity Index
	 */
	@RosettaEnumValue(value = "EQIDX") 
	EQIDX("EQIDX", null),
	
	/**
	 * FIGI code of the underlying instrument
	 */
	@RosettaEnumValue(value = "FIGI") 
	FIGI("FIGI", null),
	
	/**
	 * FPML
	 */
	@RosettaEnumValue(value = "FPML") 
	FPML("FPML", null),
	
	/**
	 * ISIN code of the underlying instrument
	 */
	@RosettaEnumValue(value = "ISIN") 
	ISIN("ISIN", null),
	
	/**
	 * In case the instrument is referring to an issuer, rather than to one single instrument, the LEI code of the Issuer
	 */
	@RosettaEnumValue(value = "LEI") 
	LEI("LEI", null),
	
	/**
	 * Underlying Instrument Index Prop
	 */
	@RosettaEnumValue(value = "PROP") 
	PROP("PROP", null),
	
	/**
	 * RIC of the underlying instrument
	 */
	@RosettaEnumValue(value = "RIC") 
	RIC("RIC", null),
	
	/**
	 * SEDOL code of the underlying instrument
	 */
	@RosettaEnumValue(value = "SEDOL") 
	SEDOL("SEDOL", null),
	
	/**
	 * Unique Product Identifier as defined by ISO 4914
	 */
	@RosettaEnumValue(value = "UPI") 
	UPI("UPI", null)
;
	private static Map<String, AnnaDsbUnderlierIDSourceEnum> values;
	static {
        Map<String, AnnaDsbUnderlierIDSourceEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbUnderlierIDSourceEnum instance : AnnaDsbUnderlierIDSourceEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbUnderlierIDSourceEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbUnderlierIDSourceEnum fromDisplayName(String name) {
		AnnaDsbUnderlierIDSourceEnum value = values.get(name);
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
