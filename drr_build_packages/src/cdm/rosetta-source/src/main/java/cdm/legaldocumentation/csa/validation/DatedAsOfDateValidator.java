package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.DatedAsOfDate;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DatedAsOfDateValidator implements Validator<DatedAsOfDate> {

	private List<ComparisonResult> getComparisonResults(DatedAsOfDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("csaDatedAsOfDate", (Date) o.getCsaDatedAsOfDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterAgreementDatedAsOfDate", (Date) o.getMasterAgreementDatedAsOfDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("csaMadeOn", (Date) o.getCsaMadeOn() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalLanguage", (String) o.getAdditionalLanguage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DatedAsOfDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DatedAsOfDate", ValidationResult.ValidationType.CARDINALITY, "DatedAsOfDate", path, "", res.getError());
				}
				return success("DatedAsOfDate", ValidationResult.ValidationType.CARDINALITY, "DatedAsOfDate", path, "");
			})
			.collect(toList());
	}

}
