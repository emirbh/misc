package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.ExchangeTradedContractUnderlyer;
import fpml.consolidated.asset.ExchangeTradedOption;
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

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExchangeTradedOptionValidator implements Validator<ExchangeTradedOption> {

	private List<ComparisonResult> getComparisonResults(ExchangeTradedOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentId", (List<? extends InstrumentId>) o.getInstrumentId() == null ? 0 : o.getInstrumentId().size(), 1, 0), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (IdentifiedCurrency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeId", (ExchangeId) o.getExchangeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearanceSystem", (ClearanceSystem) o.getClearanceSystem() != null ? 1 : 0, 0, 1), 
				checkCardinality("definition", (ProductReference) o.getDefinition() != null ? 1 : 0, 0, 1), 
				checkCardinality("multiplier", (BigDecimal) o.getMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("contractReference", (String) o.getContractReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationDate", (AdjustableOrRelativeDate) o.getExpirationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (BigDecimal) o.getStrike() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikeCurrency", (Currency) o.getStrikeCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikeUnits", (PriceQuoteUnits) o.getStrikeUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionType", (PutCallEnum) o.getOptionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseStyle", (ExerciseStyleEnum) o.getExerciseStyle() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyer", (ExchangeTradedContractUnderlyer) o.getUnderlyer() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeTradedOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExchangeTradedOption", ValidationResult.ValidationType.CARDINALITY, "ExchangeTradedOption", path, "", res.getError());
				}
				return success("ExchangeTradedOption", ValidationResult.ValidationType.CARDINALITY, "ExchangeTradedOption", path, "");
			})
			.collect(toList());
	}

}
