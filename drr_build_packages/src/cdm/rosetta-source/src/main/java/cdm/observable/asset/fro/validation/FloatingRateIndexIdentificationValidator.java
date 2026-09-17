package cdm.observable.asset.fro.validation;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.observable.asset.fro.FloatingRateIndexIdentification;
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

public class FloatingRateIndexIdentificationValidator implements Validator<FloatingRateIndexIdentification> {

	private List<ComparisonResult> getComparisonResults(FloatingRateIndexIdentification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingRateIndex", (FieldWithMetaFloatingRateIndexEnum) o.getFloatingRateIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (ISOCurrencyCodeEnum) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("froType", (String) o.getFroType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateIndexIdentification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateIndexIdentification", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexIdentification", path, "", res.getError());
				}
				return success("FloatingRateIndexIdentification", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexIdentification", path, "");
			})
			.collect(toList());
	}

}
