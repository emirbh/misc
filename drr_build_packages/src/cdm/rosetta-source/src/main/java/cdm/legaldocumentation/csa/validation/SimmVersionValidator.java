package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.SimmVersion;
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

public class SimmVersionValidator implements Validator<SimmVersion> {

	private List<ComparisonResult> getComparisonResults(SimmVersion o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isSpecified", (Boolean) o.getIsSpecified() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyVersion", (CounterpartyRoleEnum) o.getPartyVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("asSpecified", (String) o.getAsSpecified() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SimmVersion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SimmVersion", ValidationResult.ValidationType.CARDINALITY, "SimmVersion", path, "", res.getError());
				}
				return success("SimmVersion", ValidationResult.ValidationType.CARDINALITY, "SimmVersion", path, "");
			})
			.collect(toList());
	}

}
