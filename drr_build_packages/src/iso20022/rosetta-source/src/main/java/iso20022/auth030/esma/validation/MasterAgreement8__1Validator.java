package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AgreementType2Choice__1;
import iso20022.auth030.esma.MasterAgreement8__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MasterAgreement8__1Validator implements Validator<MasterAgreement8__1> {

	private List<ComparisonResult> getComparisonResults(MasterAgreement8__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tp", (AgreementType2Choice__1) o.getTp() != null ? 1 : 0, 1, 1), 
				checkCardinality("vrsn", (String) o.getVrsn() != null ? 1 : 0, 0, 1), 
				checkCardinality("othrMstrAgrmtDtls", (String) o.getOthrMstrAgrmtDtls() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreement8__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreement8__1", ValidationResult.ValidationType.CARDINALITY, "MasterAgreement8__1", path, "", res.getError());
				}
				return success("MasterAgreement8__1", ValidationResult.ValidationType.CARDINALITY, "MasterAgreement8__1", path, "");
			})
			.collect(toList());
	}

}
