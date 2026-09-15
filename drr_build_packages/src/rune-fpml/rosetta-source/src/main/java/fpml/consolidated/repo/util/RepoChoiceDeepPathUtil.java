package fpml.consolidated.repo.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Bond;
import fpml.consolidated.asset.ConvertibleBond;
import fpml.consolidated.asset.EquityAsset;
import fpml.consolidated.asset.InstrumentType;
import fpml.consolidated.repo.RepoChoice;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.ProductReference;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class RepoChoiceDeepPathUtil {
	public ExchangeId chooseExchangeId(RepoChoice repoChoice) {
		final MapperS<Bond> bond = MapperS.of(repoChoice).<Bond>map("getBond", _repoChoice -> _repoChoice.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<ExchangeId>map("getExchangeId", _bond -> _bond.getExchangeId()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(repoChoice).<ConvertibleBond>map("getConvertibleBond", _repoChoice -> _repoChoice.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<ExchangeId>map("getExchangeId", _convertibleBond -> _convertibleBond.getExchangeId()).get();
		}
		final MapperS<EquityAsset> equity = MapperS.of(repoChoice).<EquityAsset>map("getEquity", _repoChoice -> _repoChoice.getEquity());
		if (exists(equity).getOrDefault(false)) {
			return equity.<ExchangeId>map("getExchangeId", equityAsset -> equityAsset.getExchangeId()).get();
		}
		return null;
	}
	
	public ClearanceSystem chooseClearanceSystem(RepoChoice repoChoice) {
		final MapperS<Bond> bond = MapperS.of(repoChoice).<Bond>map("getBond", _repoChoice -> _repoChoice.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<ClearanceSystem>map("getClearanceSystem", _bond -> _bond.getClearanceSystem()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(repoChoice).<ConvertibleBond>map("getConvertibleBond", _repoChoice -> _repoChoice.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<ClearanceSystem>map("getClearanceSystem", _convertibleBond -> _convertibleBond.getClearanceSystem()).get();
		}
		final MapperS<EquityAsset> equity = MapperS.of(repoChoice).<EquityAsset>map("getEquity", _repoChoice -> _repoChoice.getEquity());
		if (exists(equity).getOrDefault(false)) {
			return equity.<ClearanceSystem>map("getClearanceSystem", equityAsset -> equityAsset.getClearanceSystem()).get();
		}
		return null;
	}
	
	public List<InstrumentType> chooseInstrumentType(RepoChoice repoChoice) {
		final MapperS<Bond> bond = MapperS.of(repoChoice).<Bond>map("getBond", _repoChoice -> _repoChoice.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<InstrumentType>mapC("getInstrumentType", _bond -> _bond.getInstrumentType()).getMulti();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(repoChoice).<ConvertibleBond>map("getConvertibleBond", _repoChoice -> _repoChoice.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<InstrumentType>mapC("getInstrumentType", _convertibleBond -> _convertibleBond.getInstrumentType()).getMulti();
		}
		final MapperS<EquityAsset> equity = MapperS.of(repoChoice).<EquityAsset>map("getEquity", _repoChoice -> _repoChoice.getEquity());
		if (exists(equity).getOrDefault(false)) {
			return equity.<InstrumentType>mapC("getInstrumentType", equityAsset -> equityAsset.getInstrumentType()).getMulti();
		}
		return Collections.<InstrumentType>emptyList();
	}
	
	public List<InstrumentId> chooseInstrumentId(RepoChoice repoChoice) {
		final MapperS<Bond> bond = MapperS.of(repoChoice).<Bond>map("getBond", _repoChoice -> _repoChoice.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<InstrumentId>mapC("getInstrumentId", _bond -> _bond.getInstrumentId()).getMulti();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(repoChoice).<ConvertibleBond>map("getConvertibleBond", _repoChoice -> _repoChoice.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<InstrumentId>mapC("getInstrumentId", _convertibleBond -> _convertibleBond.getInstrumentId()).getMulti();
		}
		final MapperS<EquityAsset> equity = MapperS.of(repoChoice).<EquityAsset>map("getEquity", _repoChoice -> _repoChoice.getEquity());
		if (exists(equity).getOrDefault(false)) {
			return equity.<InstrumentId>mapC("getInstrumentId", equityAsset -> equityAsset.getInstrumentId()).getMulti();
		}
		return Collections.<InstrumentId>emptyList();
	}
	
	public String chooseDescription(RepoChoice repoChoice) {
		final MapperS<Bond> bond = MapperS.of(repoChoice).<Bond>map("getBond", _repoChoice -> _repoChoice.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<String>map("getDescription", _bond -> _bond.getDescription()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(repoChoice).<ConvertibleBond>map("getConvertibleBond", _repoChoice -> _repoChoice.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<String>map("getDescription", _convertibleBond -> _convertibleBond.getDescription()).get();
		}
		final MapperS<EquityAsset> equity = MapperS.of(repoChoice).<EquityAsset>map("getEquity", _repoChoice -> _repoChoice.getEquity());
		if (exists(equity).getOrDefault(false)) {
			return equity.<String>map("getDescription", equityAsset -> equityAsset.getDescription()).get();
		}
		return null;
	}
	
	public IdentifiedCurrency chooseCurrency(RepoChoice repoChoice) {
		final MapperS<Bond> bond = MapperS.of(repoChoice).<Bond>map("getBond", _repoChoice -> _repoChoice.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<IdentifiedCurrency>map("getCurrency", _bond -> _bond.getCurrency()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(repoChoice).<ConvertibleBond>map("getConvertibleBond", _repoChoice -> _repoChoice.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<IdentifiedCurrency>map("getCurrency", _convertibleBond -> _convertibleBond.getCurrency()).get();
		}
		final MapperS<EquityAsset> equity = MapperS.of(repoChoice).<EquityAsset>map("getEquity", _repoChoice -> _repoChoice.getEquity());
		if (exists(equity).getOrDefault(false)) {
			return equity.<IdentifiedCurrency>map("getCurrency", equityAsset -> equityAsset.getCurrency()).get();
		}
		return null;
	}
	
	public ProductReference chooseDefinition(RepoChoice repoChoice) {
		final MapperS<Bond> bond = MapperS.of(repoChoice).<Bond>map("getBond", _repoChoice -> _repoChoice.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<ProductReference>map("getDefinition", _bond -> _bond.getDefinition()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(repoChoice).<ConvertibleBond>map("getConvertibleBond", _repoChoice -> _repoChoice.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<ProductReference>map("getDefinition", _convertibleBond -> _convertibleBond.getDefinition()).get();
		}
		final MapperS<EquityAsset> equity = MapperS.of(repoChoice).<EquityAsset>map("getEquity", _repoChoice -> _repoChoice.getEquity());
		if (exists(equity).getOrDefault(false)) {
			return equity.<ProductReference>map("getDefinition", equityAsset -> equityAsset.getDefinition()).get();
		}
		return null;
	}
	
	public String chooseId(RepoChoice repoChoice) {
		final MapperS<Bond> bond = MapperS.of(repoChoice).<Bond>map("getBond", _repoChoice -> _repoChoice.getBond());
		if (exists(bond).getOrDefault(false)) {
			return bond.<String>map("getId", _bond -> _bond.getId()).get();
		}
		final MapperS<ConvertibleBond> convertibleBond = MapperS.of(repoChoice).<ConvertibleBond>map("getConvertibleBond", _repoChoice -> _repoChoice.getConvertibleBond());
		if (exists(convertibleBond).getOrDefault(false)) {
			return convertibleBond.<String>map("getId", _convertibleBond -> _convertibleBond.getId()).get();
		}
		final MapperS<EquityAsset> equity = MapperS.of(repoChoice).<EquityAsset>map("getEquity", _repoChoice -> _repoChoice.getEquity());
		if (exists(equity).getOrDefault(false)) {
			return equity.<String>map("getId", equityAsset -> equityAsset.getId()).get();
		}
		return null;
	}
	
}
