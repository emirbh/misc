package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.InflationCalculationMethodEnum;
import fpml.consolidated.fpmlenum.InflationCalculationStyleEnum;
import fpml.consolidated.ird.FinalPrincipalExchangeCalculation;
import fpml.consolidated.ird.InflationRate;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.InterpolationMethod;
import fpml.consolidated.shared.MainPublication;
import fpml.consolidated.shared.Offset;
import fpml.consolidated.shared.RateSourcePage;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InflationRateValidator implements Validator<InflationRate> {

	private List<ComparisonResult> getComparisonResults(InflationRate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("inflationRateIndex", (FloatingRateIndex) o.getInflationRateIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("inflationLag", (Offset) o.getInflationLag() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexSource", (RateSourcePage) o.getIndexSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("mainPublication", (MainPublication) o.getMainPublication() != null ? 1 : 0, 0, 1), 
				checkCardinality("interpolationMethod", (InterpolationMethod) o.getInterpolationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialIndexLevel", (BigDecimal) o.getInitialIndexLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallbackBondApplicable", (Boolean) o.getFallbackBondApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationMethod", (InflationCalculationMethodEnum) o.getCalculationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationStyle", (InflationCalculationStyleEnum) o.getCalculationStyle() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalPrincipalExchangeCalculation", (FinalPrincipalExchangeCalculation) o.getFinalPrincipalExchangeCalculation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InflationRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InflationRate", ValidationResult.ValidationType.CARDINALITY, "InflationRate", path, "", res.getError());
				}
				return success("InflationRate", ValidationResult.ValidationType.CARDINALITY, "InflationRate", path, "");
			})
			.collect(toList());
	}

}
