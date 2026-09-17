package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.legaldocumentation.csa.IneligibleCreditSupport;
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

public class IneligibleCreditSupportValidator implements Validator<IneligibleCreditSupport> {

	private List<ComparisonResult> getComparisonResults(IneligibleCreditSupport o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("totalIneligibilityDate", (String) o.getTotalIneligibilityDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("transferIneligibilityDate", (String) o.getTransferIneligibilityDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("specifiedParty", (List<? extends ReferenceWithMetaParty>) o.getSpecifiedParty() == null ? 0 : o.getSpecifiedParty().size(), 0, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IneligibleCreditSupport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IneligibleCreditSupport", ValidationResult.ValidationType.CARDINALITY, "IneligibleCreditSupport", path, "", res.getError());
				}
				return success("IneligibleCreditSupport", ValidationResult.ValidationType.CARDINALITY, "IneligibleCreditSupport", path, "");
			})
			.collect(toList());
	}

}
