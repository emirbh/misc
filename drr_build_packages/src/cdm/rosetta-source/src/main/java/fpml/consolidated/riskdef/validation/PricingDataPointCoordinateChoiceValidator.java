package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.GenericDimension;
import fpml.consolidated.riskdef.PricingDataPointCoordinateChoice;
import fpml.consolidated.riskdef.TimeDimension;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PricingDataPointCoordinateChoiceValidator implements Validator<PricingDataPointCoordinateChoice> {

	private List<ComparisonResult> getComparisonResults(PricingDataPointCoordinateChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("term", (TimeDimension) o.getTerm() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiration", (TimeDimension) o.getExpiration() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (BigDecimal) o.getStrike() != null ? 1 : 0, 0, 1), 
				checkCardinality("generic", (GenericDimension) o.getGeneric() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingDataPointCoordinateChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingDataPointCoordinateChoice", ValidationResult.ValidationType.CARDINALITY, "PricingDataPointCoordinateChoice", path, "", res.getError());
				}
				return success("PricingDataPointCoordinateChoice", ValidationResult.ValidationType.CARDINALITY, "PricingDataPointCoordinateChoice", path, "");
			})
			.collect(toList());
	}

}
