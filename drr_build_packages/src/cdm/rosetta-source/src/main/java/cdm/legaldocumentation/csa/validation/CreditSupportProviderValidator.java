package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CreditSupportProvider;
import cdm.legaldocumentation.csa.CreditSupportProviderElection;
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

public class CreditSupportProviderValidator implements Validator<CreditSupportProvider> {

	private List<ComparisonResult> getComparisonResults(CreditSupportProvider o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("creditSupportProviderElection", (List<? extends CreditSupportProviderElection>) o.getCreditSupportProviderElection() == null ? 0 : o.getCreditSupportProviderElection().size(), 2, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportProvider o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditSupportProvider", ValidationResult.ValidationType.CARDINALITY, "CreditSupportProvider", path, "", res.getError());
				}
				return success("CreditSupportProvider", ValidationResult.ValidationType.CARDINALITY, "CreditSupportProvider", path, "");
			})
			.collect(toList());
	}

}
