package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.CdeSchedule2;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CdeSchedule2Validator implements Validator<CdeSchedule2> {

	private List<ComparisonResult> getComparisonResults(CdeSchedule2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cdeEffectiveDateOfTheNotionalAmountLeg2", (Date) o.getCdeEffectiveDateOfTheNotionalAmountLeg2() != null ? 1 : 0, 0, 1), 
				checkCardinality("cdeEndDateOfTheNotionalAmountLeg2", (Date) o.getCdeEndDateOfTheNotionalAmountLeg2() != null ? 1 : 0, 0, 1), 
				checkCardinality("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2", (BigDecimal) o.getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CdeSchedule2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CdeSchedule2", ValidationResult.ValidationType.CARDINALITY, "CdeSchedule2", path, "", res.getError());
				}
				return success("CdeSchedule2", ValidationResult.ValidationType.CARDINALITY, "CdeSchedule2", path, "");
			})
			.collect(toList());
	}

}
