package drr.regulation.common.validation;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ASICPartyInformation;
import drr.regulation.common.CFTCPartyInformation;
import drr.regulation.common.CSAPartyInformation;
import drr.regulation.common.ClearingException;
import drr.regulation.common.ESMAPartyInformation;
import drr.regulation.common.FCAPartyInformation;
import drr.regulation.common.HKMAPartyInformation;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.MandatorilyClearableEnum;
import drr.regulation.common.ReportingRoleEnum;
import drr.regulation.common.SECPartyInformation;
import drr.regulation.common.TechnicalRecordId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class JurisdictionPartyInformationValidator implements Validator<JurisdictionPartyInformation> {

	private List<ComparisonResult> getComparisonResults(JurisdictionPartyInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", (ReferenceWithMetaParty) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("mandatorilyClearable", (MandatorilyClearableEnum) o.getMandatorilyClearable() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingException", (ClearingException) o.getClearingException() != null ? 1 : 0, 0, 1), 
				checkCardinality("postPricedIndicator", (Boolean) o.getPostPricedIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("asicPartyInformation", (ASICPartyInformation) o.getAsicPartyInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("cftcPartyInformation", (CFTCPartyInformation) o.getCftcPartyInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("csaPartyInformation", (CSAPartyInformation) o.getCsaPartyInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("secPartyInformation", (SECPartyInformation) o.getSecPartyInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("esmaPartyInformation", (ESMAPartyInformation) o.getEsmaPartyInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("fcaPartyInformation", (FCAPartyInformation) o.getFcaPartyInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("hkmaPartyInformation", (HKMAPartyInformation) o.getHkmaPartyInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingRole", (ReportingRoleEnum) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradingCapacity", (ReportingRoleEnum) o.getTradingCapacity() != null ? 1 : 0, 0, 1), 
				checkCardinality("technicalRecordId", (TechnicalRecordId) o.getTechnicalRecordId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, JurisdictionPartyInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("JurisdictionPartyInformation", ValidationResult.ValidationType.CARDINALITY, "JurisdictionPartyInformation", path, "", res.getError());
				}
				return success("JurisdictionPartyInformation", ValidationResult.ValidationType.CARDINALITY, "JurisdictionPartyInformation", path, "");
			})
			.collect(toList());
	}

}
