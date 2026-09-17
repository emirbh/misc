package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.ExceptionEnum;
import cdm.legaldocumentation.csa.RegimeTerms;
import cdm.legaldocumentation.csa.RetrospectiveEffect;
import cdm.legaldocumentation.csa.SimmException;
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

public class RegimeTermsValidator implements Validator<RegimeTerms> {

	private List<ComparisonResult> getComparisonResults(RegimeTerms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (CounterpartyRoleEnum) o.getParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("isApplicable", (ExceptionEnum) o.getIsApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("asSpecified", (String) o.getAsSpecified() != null ? 1 : 0, 0, 1), 
				checkCardinality("simmException", (SimmException) o.getSimmException() != null ? 1 : 0, 0, 1), 
				checkCardinality("retrospectiveEffect", (RetrospectiveEffect) o.getRetrospectiveEffect() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegimeTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegimeTerms", ValidationResult.ValidationType.CARDINALITY, "RegimeTerms", path, "", res.getError());
				}
				return success("RegimeTerms", ValidationResult.ValidationType.CARDINALITY, "RegimeTerms", path, "");
			})
			.collect(toList());
	}

}
