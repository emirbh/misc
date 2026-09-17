package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.AccessConditionsElections;
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

public class AccessConditionsElectionsValidator implements Validator<AccessConditionsElections> {

	private List<ComparisonResult> getComparisonResults(AccessConditionsElections o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (CounterpartyRoleEnum) o.getParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("illegality", (Boolean) o.getIllegality() != null ? 1 : 0, 1, 1), 
				checkCardinality("forceMajeure", (Boolean) o.getForceMajeure() != null ? 1 : 0, 1, 1), 
				checkCardinality("taxEvent", (Boolean) o.getTaxEvent() != null ? 1 : 0, 1, 1), 
				checkCardinality("taxEventUponMerger", (Boolean) o.getTaxEventUponMerger() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditEventUponMerger", (Boolean) o.getCreditEventUponMerger() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccessConditionsElections o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccessConditionsElections", ValidationResult.ValidationType.CARDINALITY, "AccessConditionsElections", path, "", res.getError());
				}
				return success("AccessConditionsElections", ValidationResult.ValidationType.CARDINALITY, "AccessConditionsElections", path, "");
			})
			.collect(toList());
	}

}
