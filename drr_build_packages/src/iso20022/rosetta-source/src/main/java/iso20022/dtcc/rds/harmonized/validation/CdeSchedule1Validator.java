package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.CdeSchedule1;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CdeSchedule1Validator implements Validator<CdeSchedule1> {

	private List<ComparisonResult> getComparisonResults(CdeSchedule1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cdeEffectiveDateOfTheNotionalAmountLeg1", (Date) o.getCdeEffectiveDateOfTheNotionalAmountLeg1() != null ? 1 : 0, 0, 1), 
				checkCardinality("cdeEndDateOfTheNotionalAmountLeg1", (Date) o.getCdeEndDateOfTheNotionalAmountLeg1() != null ? 1 : 0, 0, 1), 
				checkCardinality("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1", (BigDecimal) o.getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CdeSchedule1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CdeSchedule1", ValidationResult.ValidationType.CARDINALITY, "CdeSchedule1", path, "", res.getError());
				}
				return success("CdeSchedule1", ValidationResult.ValidationType.CARDINALITY, "CdeSchedule1", path, "");
			})
			.collect(toList());
	}

}
