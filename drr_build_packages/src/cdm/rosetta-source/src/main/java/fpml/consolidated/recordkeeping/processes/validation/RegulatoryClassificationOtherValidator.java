package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationOther;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SupervisoryBody;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryClassificationOtherValidator implements Validator<RegulatoryClassificationOther> {

	private List<ComparisonResult> getComparisonResults(RegulatoryClassificationOther o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("supervisoryBody", (SupervisoryBody) o.getSupervisoryBody() != null ? 1 : 0, 1, 1), 
				checkCardinality("reportingRole", (ReportingRole) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationOther o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryClassificationOther", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationOther", path, "", res.getError());
				}
				return success("RegulatoryClassificationOther", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationOther", path, "");
			})
			.collect(toList());
	}

}
