package drr.regulation.cftc.rewrite.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.ExecutionVenueTypeEnum;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.upi.AnnaDsbUpiRequestAndType;
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart43;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbNotionalScheduleEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CFTCNonReportablePart43Validator implements Validator<CFTCNonReportablePart43> {

	private List<ComparisonResult> getComparisonResults(CFTCNonReportablePart43 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("enrichment", (EnrichmentData) o.getEnrichment() != null ? 1 : 0, 0, 1), 
				checkCardinality("preUpiData", (AnnaDsbUpiRequestAndType) o.getPreUpiData() != null ? 1 : 0, 0, 1), 
				checkCardinality("postUpiData", (AnnaDsbUpiRecord) o.getPostUpiData() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalSchedule", (AnnaDsbNotionalScheduleEnum) o.getNotionalSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingAssetType", (String) o.getUnderlyingAssetType() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentType", (AnnaDsbInstrumentTypeEnum) o.getInstrumentType() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryType", (AnnaDsbDeliveryTypeEnum) o.getDeliveryType() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterparty1Format", (PartyIdentifierFormatEnum) o.getCounterparty1Format() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterparty2Format", (PartyIdentifierFormatEnum) o.getCounterparty2Format() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionVenueType", (ExecutionVenueTypeEnum) o.getExecutionVenueType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCNonReportablePart43 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CFTCNonReportablePart43", ValidationResult.ValidationType.CARDINALITY, "CFTCNonReportablePart43", path, "", res.getError());
				}
				return success("CFTCNonReportablePart43", ValidationResult.ValidationType.CARDINALITY, "CFTCNonReportablePart43", path, "");
			})
			.collect(toList());
	}

}
