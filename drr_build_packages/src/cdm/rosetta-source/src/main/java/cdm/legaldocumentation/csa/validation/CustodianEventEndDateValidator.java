package cdm.legaldocumentation.csa.validation;

import cdm.base.datetime.CustomisableOffset;
import cdm.legaldocumentation.csa.CustodianEventEndDate;
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

public class CustodianEventEndDateValidator implements Validator<CustodianEventEndDate> {

	private List<ComparisonResult> getComparisonResults(CustodianEventEndDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("daysAfterCustodianEvent", (CustomisableOffset) o.getDaysAfterCustodianEvent() != null ? 1 : 0, 1, 1), 
				checkCardinality("releaseDate", (CustomisableOffset) o.getReleaseDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("safekeepingPeriodExpiry", (CustomisableOffset) o.getSafekeepingPeriodExpiry() != null ? 1 : 0, 0, 1), 
				checkCardinality("dateOfTimelyStatement", (CustomisableOffset) o.getDateOfTimelyStatement() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustodianEventEndDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustodianEventEndDate", ValidationResult.ValidationType.CARDINALITY, "CustodianEventEndDate", path, "", res.getError());
				}
				return success("CustodianEventEndDate", ValidationResult.ValidationType.CARDINALITY, "CustodianEventEndDate", path, "");
			})
			.collect(toList());
	}

}
