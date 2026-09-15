package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.OrganisationIdentification15Choice__1;
import iso20022.auth030.esma.PTRREvent2__1;
import iso20022.auth030.esma.RiskReductionService1Code__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PTRREvent2__1Validator implements Validator<PTRREvent2__1> {

	private List<ComparisonResult> getComparisonResults(PTRREvent2__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tchnq", (RiskReductionService1Code__1) o.getTchnq() != null ? 1 : 0, 1, 1), 
				checkCardinality("svcPrvdr", (OrganisationIdentification15Choice__1) o.getSvcPrvdr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PTRREvent2__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PTRREvent2__1", ValidationResult.ValidationType.CARDINALITY, "PTRREvent2__1", path, "", res.getError());
				}
				return success("PTRREvent2__1", ValidationResult.ValidationType.CARDINALITY, "PTRREvent2__1", path, "");
			})
			.collect(toList());
	}

}
