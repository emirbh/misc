package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.ExchangeTradedContractUnderlyer;
import fpml.consolidated.asset.ExchangeTradedOption;
import fpml.consolidated.asset.InstrumentType;
import fpml.consolidated.asset.PriceQuoteUnits;
import fpml.consolidated.fpmlenum.ExerciseStyleEnum;
import fpml.consolidated.fpmlenum.PutCallEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.ProductReference;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ExchangeTradedOptionOnlyExistsValidator implements ValidatorWithArg<ExchangeTradedOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ExchangeTradedOption> ValidationResult<ExchangeTradedOption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("instrumentId", ExistenceChecker.isSet((List<? extends InstrumentId>) o.getInstrumentId()))
				.put("instrumentType", ExistenceChecker.isSet((List<? extends InstrumentType>) o.getInstrumentType()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("currency", ExistenceChecker.isSet((IdentifiedCurrency) o.getCurrency()))
				.put("exchangeId", ExistenceChecker.isSet((ExchangeId) o.getExchangeId()))
				.put("clearanceSystem", ExistenceChecker.isSet((ClearanceSystem) o.getClearanceSystem()))
				.put("definition", ExistenceChecker.isSet((ProductReference) o.getDefinition()))
				.put("relatedExchangeId", ExistenceChecker.isSet((List<? extends ExchangeId>) o.getRelatedExchangeId()))
				.put("optionsExchangeId", ExistenceChecker.isSet((List<? extends ExchangeId>) o.getOptionsExchangeId()))
				.put("specifiedExchangeId", ExistenceChecker.isSet((List<? extends ExchangeId>) o.getSpecifiedExchangeId()))
				.put("multiplier", ExistenceChecker.isSet((BigDecimal) o.getMultiplier()))
				.put("contractReference", ExistenceChecker.isSet((String) o.getContractReference()))
				.put("expirationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getExpirationDate()))
				.put("strike", ExistenceChecker.isSet((BigDecimal) o.getStrike()))
				.put("strikeCurrency", ExistenceChecker.isSet((Currency) o.getStrikeCurrency()))
				.put("strikeUnits", ExistenceChecker.isSet((PriceQuoteUnits) o.getStrikeUnits()))
				.put("optionType", ExistenceChecker.isSet((PutCallEnum) o.getOptionType()))
				.put("exerciseStyle", ExistenceChecker.isSet((ExerciseStyleEnum) o.getExerciseStyle()))
				.put("underlyer", ExistenceChecker.isSet((ExchangeTradedContractUnderlyer) o.getUnderlyer()))
				.put("settlementType", ExistenceChecker.isSet((SettlementTypeEnum) o.getSettlementType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExchangeTradedOption", ValidationResult.ValidationType.ONLY_EXISTS, "ExchangeTradedOption", path, "");
		}
		return failure("ExchangeTradedOption", ValidationResult.ValidationType.ONLY_EXISTS, "ExchangeTradedOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
