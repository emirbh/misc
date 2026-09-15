package drr.regulation.common.trade.contract;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("MasterAgreementEnum")
public enum MasterAgreementEnum {

	/**
	 * ISDA Master Agreement
	 */
	@RosettaEnumValue(value = "ISDA") 
	ISDA("ISDA", null),
	
	/**
	 * ISDA-FIA Cleared Derivatives Execution Agreement
	 */
	@RosettaEnumValue(value = "CDEA") 
	CDEA("CDEA", null),
	
	/**
	 * European Master Agreement and the Derivatives Annex (Banking Federation of the European Union)
	 */
	@RosettaEnumValue(value = "EUMA") 
	EUMA("EUMA", null),
	
	/**
	 * Master Agreement Relating to transactions on Forward Financial Instruments (Federation Bancaire Francaise)
	 */
	@RosettaEnumValue(value = "FMAT") 
	FMAT("FMAT", null),
	
	/**
	 * German Master Agreement for Financial derivatives and Addendum for Options on Stock Exchange Indices or Securities
	 */
	@RosettaEnumValue(value = "DERV") 
	DERV("DERV", null),
	
	/**
	 * Contrato Marco de Operaciones Financieras
	 */
	@RosettaEnumValue(value = "CMOP") 
	CMOP("CMOP", null),
	
	/**
	 * Swiss Master Agreement for OTC Derivatives Instruments
	 */
	@RosettaEnumValue(value = "CHMA") 
	CHMA("CHMA", null),
	
	/**
	 * EFET General Agreement Concerning the Delivery and Acceptance of Electricity or EFET General Agreement Concerning The Delivery And Acceptance of Natural Gas
	 */
	@RosettaEnumValue(value = "EFMA") 
	EFMA("EFMA", null),
	
	/**
	 * ICMA Global Master Agreement for REPO Trades
	 */
	@RosettaEnumValue(value = "GMRA") 
	GMRA("GMRA", null),
	
	/**
	 * ISLA Global Master Agreement for Securities Lending
	 */
	@RosettaEnumValue(value = "GMSL") 
	GMSL("GMSL", null),
	
	/**
	 * A Bespoke (custom) Master Agreement, including one-off agreements for transactions
	 */
	@RosettaEnumValue(value = "BIAG") 
	BIAG("BIAG", null),
	
	/**
	 * ISDA/IIFM Tahawwut (Hedging) Master Agreement (TMA)
	 */
	@RosettaEnumValue(value = "IDMA") 
	IDMA("IDMA", null),
	
	/**
	 * Other
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null),
	
	@RosettaEnumValue(value = "FPCA") 
	FPCA("FPCA", null)
;
	private static Map<String, MasterAgreementEnum> values;
	static {
        Map<String, MasterAgreementEnum> map = new ConcurrentHashMap<>();
		for (MasterAgreementEnum instance : MasterAgreementEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MasterAgreementEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MasterAgreementEnum fromDisplayName(String name) {
		MasterAgreementEnum value = values.get(name);
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
