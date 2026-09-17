package cdm.legaldocumentation.master.validation;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.master.MasterAgreementClauseVariant;
import cdm.legaldocumentation.master.MasterAgreementVariantIdentifierEnum;
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

public class MasterAgreementClauseVariantValidator implements Validator<MasterAgreementClauseVariant> {

	private List<ComparisonResult> getComparisonResults(MasterAgreementClauseVariant o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (MasterAgreementVariantIdentifierEnum) o.getIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterparty", (List<CounterpartyRoleEnum>) o.getCounterparty() == null ? 0 : o.getCounterparty().size(), 0, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreementClauseVariant o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreementClauseVariant", ValidationResult.ValidationType.CARDINALITY, "MasterAgreementClauseVariant", path, "", res.getError());
				}
				return success("MasterAgreementClauseVariant", ValidationResult.ValidationType.CARDINALITY, "MasterAgreementClauseVariant", path, "");
			})
			.collect(toList());
	}

}
