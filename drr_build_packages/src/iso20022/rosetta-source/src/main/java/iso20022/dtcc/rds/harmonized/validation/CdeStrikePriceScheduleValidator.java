package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.CdeStrikePriceSchedule;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CdeStrikePriceScheduleValidator implements Validator<CdeStrikePriceSchedule> {

	private List<ComparisonResult> getComparisonResults(CdeStrikePriceSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cdeUnadjustedEffectiveDateOfStrikePrice", (Date) o.getCdeUnadjustedEffectiveDateOfStrikePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("cdeUnadjustedEndDateOfStrikePrice", (Date) o.getCdeUnadjustedEndDateOfStrikePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("cdeStrikePrice", (BigDecimal) o.getCdeStrikePrice() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CdeStrikePriceSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CdeStrikePriceSchedule", ValidationResult.ValidationType.CARDINALITY, "CdeStrikePriceSchedule", path, "", res.getError());
				}
				return success("CdeStrikePriceSchedule", ValidationResult.ValidationType.CARDINALITY, "CdeStrikePriceSchedule", path, "");
			})
			.collect(toList());
	}

}
