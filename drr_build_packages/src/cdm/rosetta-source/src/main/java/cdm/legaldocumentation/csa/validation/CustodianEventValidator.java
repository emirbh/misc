package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CustodianEvent;
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

public class CustodianEventValidator implements Validator<CustodianEvent> {

	private List<ComparisonResult> getComparisonResults(CustodianEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isApplicable", (Boolean) o.getIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("endDate", (CustodianEventEndDate) o.getEndDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustodianEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustodianEvent", ValidationResult.ValidationType.CARDINALITY, "CustodianEvent", path, "", res.getError());
				}
				return success("CustodianEvent", ValidationResult.ValidationType.CARDINALITY, "CustodianEvent", path, "");
			})
			.collect(toList());
	}

}
