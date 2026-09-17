package cdm.legaldocumentation.transaction.validation;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.transaction.UnderlierSubstitutionProvision;
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

public class UnderlierSubstitutionProvisionValidator implements Validator<UnderlierSubstitutionProvision> {

	private List<ComparisonResult> getComparisonResults(UnderlierSubstitutionProvision o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("whoMaySubstitute", (List<CounterpartyRoleEnum>) o.getWhoMaySubstitute() == null ? 0 : o.getWhoMaySubstitute().size(), 1, 2), 
				checkCardinality("disputingParty", (CounterpartyRoleEnum) o.getDisputingParty() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnderlierSubstitutionProvision o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UnderlierSubstitutionProvision", ValidationResult.ValidationType.CARDINALITY, "UnderlierSubstitutionProvision", path, "", res.getError());
				}
				return success("UnderlierSubstitutionProvision", ValidationResult.ValidationType.CARDINALITY, "UnderlierSubstitutionProvision", path, "");
			})
			.collect(toList());
	}

}
