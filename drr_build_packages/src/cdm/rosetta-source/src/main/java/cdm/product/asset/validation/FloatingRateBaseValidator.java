package cdm.product.asset.validation;

import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.product.asset.FloatingRateBase;
import cdm.product.asset.SpreadSchedule;
import cdm.product.template.StrikeSchedule;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FloatingRateBaseValidator implements Validator<FloatingRateBase> {

	private List<ComparisonResult> getComparisonResults(FloatingRateBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rateOption", (ReferenceWithMetaInterestRateIndex) o.getRateOption() != null ? 1 : 0, 0, 1), 
				checkCardinality("spreadSchedule", (SpreadSchedule) o.getSpreadSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("capRateSchedule", (StrikeSchedule) o.getCapRateSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("floorRateSchedule", (StrikeSchedule) o.getFloorRateSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateBase", ValidationResult.ValidationType.CARDINALITY, "FloatingRateBase", path, "", res.getError());
				}
				return success("FloatingRateBase", ValidationResult.ValidationType.CARDINALITY, "FloatingRateBase", path, "");
			})
			.collect(toList());
	}

}
