package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.metafields.FieldWithMetaRegimeNameEnum;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportableJurisdictionInformationValidator implements Validator<ReportableJurisdictionInformation> {

	private List<ComparisonResult> getComparisonResults(ReportableJurisdictionInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("regimeName", (FieldWithMetaRegimeNameEnum) o.getRegimeName() != null ? 1 : 0, 1, 1), 
				checkCardinality("supervisoryBody", (FieldWithMetaSupervisoryBodyEnum) o.getSupervisoryBody() != null ? 1 : 0, 0, 1), 
				checkCardinality("transactionInformation", (TransactionInformation) o.getTransactionInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyInformation", (List<? extends JurisdictionPartyInformation>) o.getPartyInformation() == null ? 0 : o.getPartyInformation().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableJurisdictionInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportableJurisdictionInformation", ValidationResult.ValidationType.CARDINALITY, "ReportableJurisdictionInformation", path, "", res.getError());
				}
				return success("ReportableJurisdictionInformation", ValidationResult.ValidationType.CARDINALITY, "ReportableJurisdictionInformation", path, "");
			})
			.collect(toList());
	}

}
