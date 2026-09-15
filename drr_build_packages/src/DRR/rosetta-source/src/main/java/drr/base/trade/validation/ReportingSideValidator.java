package drr.base.trade.validation;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.ReportingSide;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportingSideValidator implements Validator<ReportingSide> {

	private List<ComparisonResult> getComparisonResults(ReportingSide o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportingParty", (ReferenceWithMetaParty) o.getReportingParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("reportingCounterparty", (ReferenceWithMetaParty) o.getReportingCounterparty() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyResponsibleForReporting", (ReferenceWithMetaParty) o.getPartyResponsibleForReporting() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportSubmittingParty", (ReferenceWithMetaParty) o.getReportSubmittingParty() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingSide o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportingSide", ValidationResult.ValidationType.CARDINALITY, "ReportingSide", path, "", res.getError());
				}
				return success("ReportingSide", ValidationResult.ValidationType.CARDINALITY, "ReportingSide", path, "");
			})
			.collect(toList());
	}

}
