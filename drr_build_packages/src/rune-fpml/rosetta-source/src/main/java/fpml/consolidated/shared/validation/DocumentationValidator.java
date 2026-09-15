package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BrokerConfirmation;
import fpml.consolidated.shared.CreditSupportAgreement;
import fpml.consolidated.shared.Documentation;
import fpml.consolidated.shared.MasterAgreement;
import fpml.consolidated.shared.MasterConfirmation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DocumentationValidator implements Validator<Documentation> {

	private List<ComparisonResult> getComparisonResults(Documentation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("masterAgreement", (MasterAgreement) o.getMasterAgreement() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterConfirmation", (MasterConfirmation) o.getMasterConfirmation() != null ? 1 : 0, 0, 1), 
				checkCardinality("brokerConfirmation", (BrokerConfirmation) o.getBrokerConfirmation() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditSupportAgreement", (CreditSupportAgreement) o.getCreditSupportAgreement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Documentation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Documentation", ValidationResult.ValidationType.CARDINALITY, "Documentation", path, "", res.getError());
				}
				return success("Documentation", ValidationResult.ValidationType.CARDINALITY, "Documentation", path, "");
			})
			.collect(toList());
	}

}
