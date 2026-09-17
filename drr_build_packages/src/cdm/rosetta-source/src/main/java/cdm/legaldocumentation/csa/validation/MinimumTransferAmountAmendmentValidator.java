package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.AmendmentEffectiveDate;
import cdm.legaldocumentation.csa.ElectiveAmountElection;
import cdm.legaldocumentation.csa.MinimumTransferAmountAmendment;
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

public class MinimumTransferAmountAmendmentValidator implements Validator<MinimumTransferAmountAmendment> {

	private List<ComparisonResult> getComparisonResults(MinimumTransferAmountAmendment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isApplicable", (Boolean) o.getIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (AmendmentEffectiveDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyElections", (List<? extends ElectiveAmountElection>) o.getPartyElections() == null ? 0 : o.getPartyElections().size(), 0, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MinimumTransferAmountAmendment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MinimumTransferAmountAmendment", ValidationResult.ValidationType.CARDINALITY, "MinimumTransferAmountAmendment", path, "", res.getError());
				}
				return success("MinimumTransferAmountAmendment", ValidationResult.ValidationType.CARDINALITY, "MinimumTransferAmountAmendment", path, "");
			})
			.collect(toList());
	}

}
