package drr.base.trade;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Enumeration representing the type of venue where a trade could be executed.
 * @version 7.7.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/execution-venue-type"
 *
 * Provision 
 *
 */
@RosettaEnum("ExecutionVenueTypeEnum")
public enum ExecutionVenueTypeEnum {

	/**
	 * Registered Designated Contract Market.
	 */
	@RosettaEnumValue(value = "DCM") 
	DCM("DCM", null),
	
	/**
	 * Electronic Trading Platform as defined in the Japanese Financial Instruments and Exchange Act.
	 */
	@RosettaEnumValue(value = "ETP") 
	ETP("ETP", null),
	
	/**
	 * Registered Multilateral Trading Facility (MiFID and MiFID II) - Pursuant to MiFID II, refers to a multilateral system operated by an investment firm or market operator, which brings together multiple third-party buying and selling interests in financial instruments in the system, in accordance with non-discretionary rules, in a way that results in a contract in accordance with the provisions of Title II of the MiFID II.
	 */
	@RosettaEnumValue(value = "MTF") 
	MTF("MTF", null),
	
	/**
	 * Bilateral execution between counterparties not pursuant to the rules of a SEF or DCM.
	 */
	@RosettaEnumValue(value = "OffFacility") 
	OFF_FACILITY("OffFacility", null),
	
	/**
	 * Organised Trading Facility (MiFID II). A multilateral system which is not a regulated market or MTF and in which multiple third party buying and selling interests in bonds, structured finance product, emissions allowances or derivatives are able to interact in the system in a way which results in a contract.
	 */
	@RosettaEnumValue(value = "OTF") 
	OTF("OTF", null),
	
	/**
	 * Registered Swaps Execution Facility.
	 */
	@RosettaEnumValue(value = "SEF") 
	SEF("SEF", null)
;
	private static Map<String, ExecutionVenueTypeEnum> values;
	static {
        Map<String, ExecutionVenueTypeEnum> map = new ConcurrentHashMap<>();
		for (ExecutionVenueTypeEnum instance : ExecutionVenueTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ExecutionVenueTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ExecutionVenueTypeEnum fromDisplayName(String name) {
		ExecutionVenueTypeEnum value = values.get(name);
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
