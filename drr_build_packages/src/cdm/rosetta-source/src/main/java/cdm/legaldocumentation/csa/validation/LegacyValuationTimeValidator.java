package cdm.legaldocumentation.csa.validation;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.legaldocumentation.csa.LegacyValuationTime;
import cdm.legaldocumentation.csa.ValuationTimeDayEnum;
import cdm.legaldocumentation.csa.ValuationTimeEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.time.LocalTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LegacyValuationTimeValidator implements Validator<LegacyValuationTime> {

	private List<ComparisonResult> getComparisonResults(LegacyValuationTime o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("day", (ValuationTimeDayEnum) o.getDay() != null ? 1 : 0, 0, 1), 
				checkCardinality("time", (ValuationTimeEnum) o.getTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("hourminutetime", (LocalTime) o.getHourminutetime() != null ? 1 : 0, 0, 1), 
				checkCardinality("timezone", (BusinessCenterEnum) o.getTimezone() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalLanguage", (String) o.getAdditionalLanguage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyValuationTime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegacyValuationTime", ValidationResult.ValidationType.CARDINALITY, "LegacyValuationTime", path, "", res.getError());
				}
				return success("LegacyValuationTime", ValidationResult.ValidationType.CARDINALITY, "LegacyValuationTime", path, "");
			})
			.collect(toList());
	}

}
