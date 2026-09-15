package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbAdditionalSubProductEnum")
public enum AnnaDsbAdditionalSubProductEnum {

	@RosettaEnumValue(value = "ALUA") 
	ALUA("ALUA", null),
	
	@RosettaEnumValue(value = "ALUM") 
	ALUM("ALUM", null),
	
	@RosettaEnumValue(value = "BAKK") 
	BAKK("BAKK", null),
	
	@RosettaEnumValue(value = "BDSL") 
	BDSL("BDSL", null),
	
	@RosettaEnumValue(value = "BRNT") 
	BRNT("BRNT", null),
	
	@RosettaEnumValue(value = "BRNX") 
	BRNX("BRNX", null),
	
	@RosettaEnumValue(value = "BRWN") 
	BRWN("BRWN", null),
	
	@RosettaEnumValue(value = "BSLD") 
	BSLD("BSLD", null),
	
	@RosettaEnumValue(value = "CBLT") 
	CBLT("CBLT", null),
	
	@RosettaEnumValue(value = "CCOA") 
	CCOA("CCOA", null),
	
	@RosettaEnumValue(value = "CERE") 
	CERE("CERE", null),
	
	@RosettaEnumValue(value = "CNDA") 
	CNDA("CNDA", null),
	
	@RosettaEnumValue(value = "COND") 
	COND("COND", null),
	
	@RosettaEnumValue(value = "COPR") 
	COPR("COPR", null),
	
	@RosettaEnumValue(value = "CORN") 
	CORN("CORN", null),
	
	@RosettaEnumValue(value = "DBCR") 
	DBCR("DBCR", null),
	
	@RosettaEnumValue(value = "DSEL") 
	DSEL("DSEL", null),
	
	@RosettaEnumValue(value = "DUBA") 
	DUBA("DUBA", null),
	
	@RosettaEnumValue(value = "ERUE") 
	ERUE("ERUE", null),
	
	@RosettaEnumValue(value = "ESPO") 
	ESPO("ESPO", null),
	
	@RosettaEnumValue(value = "ETHA") 
	ETHA("ETHA", null),
	
	@RosettaEnumValue(value = "EUAA") 
	EUAA("EUAA", null),
	
	@RosettaEnumValue(value = "EUAE") 
	EUAE("EUAE", null),
	
	@RosettaEnumValue(value = "FITR") 
	FITR("FITR", null),
	
	@RosettaEnumValue(value = "FOIL") 
	FOIL("FOIL", null),
	
	@RosettaEnumValue(value = "FUEL") 
	FUEL("FUEL", null),
	
	@RosettaEnumValue(value = "FWHT") 
	FWHT("FWHT", null),
	
	@RosettaEnumValue(value = "GASP") 
	GASP("GASP", null),
	
	@RosettaEnumValue(value = "GOIL") 
	GOIL("GOIL", null),
	
	@RosettaEnumValue(value = "GOLD") 
	GOLD("GOLD", null),
	
	@RosettaEnumValue(value = "GSLN") 
	GSLN("GSLN", null),
	
	@RosettaEnumValue(value = "HEAT") 
	HEAT("HEAT", null),
	
	@RosettaEnumValue(value = "IRON") 
	IRON("IRON", null),
	
	@RosettaEnumValue(value = "JTFL") 
	JTFL("JTFL", null),
	
	@RosettaEnumValue(value = "KERO") 
	KERO("KERO", null),
	
	@RosettaEnumValue(value = "LAMP") 
	LAMP("LAMP", null),
	
	@RosettaEnumValue(value = "LEAD") 
	LEAD("LEAD", null),
	
	@RosettaEnumValue(value = "LLSO") 
	LLSO("LLSO", null),
	
	@RosettaEnumValue(value = "LNGG") 
	LNGG("LNGG", null),
	
	@RosettaEnumValue(value = "MARS") 
	MARS("MARS", null),
	
	@RosettaEnumValue(value = "MOLY") 
	MOLY("MOLY", null),
	
	@RosettaEnumValue(value = "MWHT") 
	MWHT("MWHT", null),
	
	@RosettaEnumValue(value = "NAPH") 
	NAPH("NAPH", null),
	
	@RosettaEnumValue(value = "NASC") 
	NASC("NASC", null),
	
	@RosettaEnumValue(value = "NBPG") 
	NBPG("NBPG", null),
	
	@RosettaEnumValue(value = "NCGG") 
	NCGG("NCGG", null),
	
	@RosettaEnumValue(value = "NGLO") 
	NGLO("NGLO", null),
	
	@RosettaEnumValue(value = "NICK") 
	NICK("NICK", null),
	
	@RosettaEnumValue(value = "OFFP") 
	OFFP("OFFP", null),
	
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null),
	
	@RosettaEnumValue(value = "PKLD") 
	PKLD("PKLD", null),
	
	@RosettaEnumValue(value = "PLDM") 
	PLDM("PLDM", null),
	
	@RosettaEnumValue(value = "PTNM") 
	PTNM("PTNM", null),
	
	@RosettaEnumValue(value = "RICE") 
	RICE("RICE", null),
	
	@RosettaEnumValue(value = "ROBU") 
	ROBU("ROBU", null),
	
	@RosettaEnumValue(value = "RPSD") 
	RPSD("RPSD", null),
	
	@RosettaEnumValue(value = "SLVR") 
	SLVR("SLVR", null),
	
	@RosettaEnumValue(value = "SOYB") 
	SOYB("SOYB", null),
	
	@RosettaEnumValue(value = "STEL") 
	STEL("STEL", null),
	
	@RosettaEnumValue(value = "TAPI") 
	TAPI("TAPI", null),
	
	@RosettaEnumValue(value = "TINN") 
	TINN("TINN", null),
	
	@RosettaEnumValue(value = "TNKR") 
	TNKR("TNKR", null),
	
	@RosettaEnumValue(value = "TTFG") 
	TTFG("TTFG", null),
	
	@RosettaEnumValue(value = "URAL") 
	URAL("URAL", null),
	
	@RosettaEnumValue(value = "WHSG") 
	WHSG("WHSG", null),
	
	@RosettaEnumValue(value = "WTIO") 
	WTIO("WTIO", null),
	
	@RosettaEnumValue(value = "ZINC") 
	ZINC("ZINC", null)
;
	private static Map<String, AnnaDsbAdditionalSubProductEnum> values;
	static {
        Map<String, AnnaDsbAdditionalSubProductEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbAdditionalSubProductEnum instance : AnnaDsbAdditionalSubProductEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbAdditionalSubProductEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbAdditionalSubProductEnum fromDisplayName(String name) {
		AnnaDsbAdditionalSubProductEnum value = values.get(name);
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
