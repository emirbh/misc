package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.AmountSchedule;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AmountScheduleValidator implements Validator<AmountSchedule> {

	private List<ComparisonResult> getComparisonResults(AmountSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (BigDecimal) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (List<? extends FieldWithMetaString>) o.getCurrency() == null ? 0 : o.getCurrency().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AmountSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AmountSchedule", ValidationResult.ValidationType.CARDINALITY, "AmountSchedule", path, "", res.getError());
				}
				return success("AmountSchedule", ValidationResult.ValidationType.CARDINALITY, "AmountSchedule", path, "");
			})
			.collect(toList());
	}

}
