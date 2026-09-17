package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.LegacyValuationDate;
import cdm.legaldocumentation.csa.ValuationDateDateEnum;
import cdm.legaldocumentation.csa.ValuationDateDayEnum;
import cdm.legaldocumentation.csa.ValuationDateFrequencyEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LegacyValuationDateValidator implements Validator<LegacyValuationDate> {

	private List<ComparisonResult> getComparisonResults(LegacyValuationDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("date", (ValuationDateDateEnum) o.getDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("day", (ValuationDateDayEnum) o.getDay() != null ? 1 : 0, 0, 1), 
				checkCardinality("calendarDay", (BigDecimal) o.getCalendarDay() != null ? 1 : 0, 0, 1), 
				checkCardinality("frequency", (ValuationDateFrequencyEnum) o.getFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalLanguage", (String) o.getAdditionalLanguage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyValuationDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegacyValuationDate", ValidationResult.ValidationType.CARDINALITY, "LegacyValuationDate", path, "", res.getError());
				}
				return success("LegacyValuationDate", ValidationResult.ValidationType.CARDINALITY, "LegacyValuationDate", path, "");
			})
			.collect(toList());
	}

}
