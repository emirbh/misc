package cdm.legaldocumentation.csa.validation;

import cdm.base.datetime.CustomisableOffset;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.ExceptionEnum;
import cdm.legaldocumentation.csa.PledgeeRepresentativeRider;
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

public class PledgeeRepresentativeRiderValidator implements Validator<PledgeeRepresentativeRider> {

	private List<ComparisonResult> getComparisonResults(PledgeeRepresentativeRider o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isApplicable", (Boolean) o.getIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("party", (CounterpartyRoleEnum) o.getParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("representativeTerms", (String) o.getRepresentativeTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("representativeEvent", (ExceptionEnum) o.getRepresentativeEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("representativeEventTerms", (String) o.getRepresentativeEventTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("representativeEndDate", (CustomisableOffset) o.getRepresentativeEndDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PledgeeRepresentativeRider o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PledgeeRepresentativeRider", ValidationResult.ValidationType.CARDINALITY, "PledgeeRepresentativeRider", path, "", res.getError());
				}
				return success("PledgeeRepresentativeRider", ValidationResult.ValidationType.CARDINALITY, "PledgeeRepresentativeRider", path, "");
			})
			.collect(toList());
	}

}
