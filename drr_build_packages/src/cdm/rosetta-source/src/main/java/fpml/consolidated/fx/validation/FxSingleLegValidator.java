package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.DealtCurrencyEnum;
import fpml.consolidated.fpmlenum.FxTenorPeriodEnum;
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.fx.FxSingleLeg;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FxCashSettlement;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Period;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxSingleLegValidator implements Validator<FxSingleLeg> {

	private List<ComparisonResult> getComparisonResults(FxSingleLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("exchangedCurrency1", (Payment) o.getExchangedCurrency1() != null ? 1 : 0, 1, 1), 
				checkCardinality("exchangedCurrency2", (Payment) o.getExchangedCurrency2() != null ? 1 : 0, 1, 1), 
				checkCardinality("dealtCurrency", (DealtCurrencyEnum) o.getDealtCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("tenorName", (FxTenorPeriodEnum) o.getTenorName() != null ? 1 : 0, 0, 1), 
				checkCardinality("tenorPeriod", (Period) o.getTenorPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("valueDate", (ZonedDateTime) o.getValueDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency1ValueDate", (ZonedDateTime) o.getCurrency1ValueDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency2ValueDate", (ZonedDateTime) o.getCurrency2ValueDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeRate", (ExchangeRate) o.getExchangeRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonDeliverableSettlement", (FxCashSettlement) o.getNonDeliverableSettlement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSingleLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxSingleLeg", ValidationResult.ValidationType.CARDINALITY, "FxSingleLeg", path, "", res.getError());
				}
				return success("FxSingleLeg", ValidationResult.ValidationType.CARDINALITY, "FxSingleLeg", path, "");
			})
			.collect(toList());
	}

}
