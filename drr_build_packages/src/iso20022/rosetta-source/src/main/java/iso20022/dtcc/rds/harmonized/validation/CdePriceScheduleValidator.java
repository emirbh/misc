package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.CdePriceSchedule;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CdePriceScheduleValidator implements Validator<CdePriceSchedule> {

	private List<ComparisonResult> getComparisonResults(CdePriceSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cdeUnadjustedEffectiveDateOfPrice", (Date) o.getCdeUnadjustedEffectiveDateOfPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("cdeUnadjustedEndDateOfPrice", (Date) o.getCdeUnadjustedEndDateOfPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("cdePrice", (BigDecimal) o.getCdePrice() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CdePriceSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CdePriceSchedule", ValidationResult.ValidationType.CARDINALITY, "CdePriceSchedule", path, "", res.getError());
				}
				return success("CdePriceSchedule", ValidationResult.ValidationType.CARDINALITY, "CdePriceSchedule", path, "");
			})
			.collect(toList());
	}

}
