package cdm.legaldocumentation.master.isla.validation;

import cdm.legaldocumentation.master.isla.GlobalMasterSecuritiesLendingAgreement;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GlobalMasterSecuritiesLendingAgreementValidator implements Validator<GlobalMasterSecuritiesLendingAgreement> {

	private List<ComparisonResult> getComparisonResults(GlobalMasterSecuritiesLendingAgreement o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GlobalMasterSecuritiesLendingAgreement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GlobalMasterSecuritiesLendingAgreement", ValidationResult.ValidationType.CARDINALITY, "GlobalMasterSecuritiesLendingAgreement", path, "", res.getError());
				}
				return success("GlobalMasterSecuritiesLendingAgreement", ValidationResult.ValidationType.CARDINALITY, "GlobalMasterSecuritiesLendingAgreement", path, "");
			})
			.collect(toList());
	}

}
