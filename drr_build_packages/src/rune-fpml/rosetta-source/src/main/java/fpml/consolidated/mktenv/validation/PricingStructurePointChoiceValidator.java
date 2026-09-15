package fpml.consolidated.mktenv.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.mktenv.PricingStructurePointChoice;
import fpml.consolidated.riskdef.PricingDataPointCoordinate;
import fpml.consolidated.riskdef.PricingDataPointCoordinateReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PricingStructurePointChoiceValidator implements Validator<PricingStructurePointChoice> {

	private List<ComparisonResult> getComparisonResults(PricingStructurePointChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("coordinate", (PricingDataPointCoordinate) o.getCoordinate() != null ? 1 : 0, 0, 1), 
				checkCardinality("coordinateReference", (PricingDataPointCoordinateReference) o.getCoordinateReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingStructurePointChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingStructurePointChoice", ValidationResult.ValidationType.CARDINALITY, "PricingStructurePointChoice", path, "", res.getError());
				}
				return success("PricingStructurePointChoice", ValidationResult.ValidationType.CARDINALITY, "PricingStructurePointChoice", path, "");
			})
			.collect(toList());
	}

}
