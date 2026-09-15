package fpml.consolidated.mktenv.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.AnyAssetReference;
import fpml.consolidated.mktenv.FxCurveValuation;
import fpml.consolidated.mktenv.FxRateSet;
import fpml.consolidated.mktenv.TermCurve;
import fpml.consolidated.riskdef.ValuationScenarioReference;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.PricingStructureReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxCurveValuationValidator implements Validator<FxCurveValuation> {

	private List<ComparisonResult> getComparisonResults(FxCurveValuation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("definitionRef", (String) o.getDefinitionRef() != null ? 1 : 0, 0, 1), 
				checkCardinality("objectReference", (AnyAssetReference) o.getObjectReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationScenarioReference", (ValuationScenarioReference) o.getValuationScenarioReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("baseDate", (IdentifiedDate) o.getBaseDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("spotDate", (IdentifiedDate) o.getSpotDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("inputDataDate", (IdentifiedDate) o.getInputDataDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("endDate", (IdentifiedDate) o.getEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("buildDateTime", (ZonedDateTime) o.getBuildDateTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementCurrencyYieldCurve", (PricingStructureReference) o.getSettlementCurrencyYieldCurve() != null ? 1 : 0, 0, 1), 
				checkCardinality("forecastCurrencyYieldCurve", (PricingStructureReference) o.getForecastCurrencyYieldCurve() != null ? 1 : 0, 0, 1), 
				checkCardinality("spotRate", (FxRateSet) o.getSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxForwardCurve", (TermCurve) o.getFxForwardCurve() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxForwardPointsCurve", (TermCurve) o.getFxForwardPointsCurve() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCurveValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCurveValuation", ValidationResult.ValidationType.CARDINALITY, "FxCurveValuation", path, "", res.getError());
				}
				return success("FxCurveValuation", ValidationResult.ValidationType.CARDINALITY, "FxCurveValuation", path, "");
			})
			.collect(toList());
	}

}
