package fpml.consolidated.sec.lending.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.ExtensionStyleEnum;
import fpml.consolidated.fpmlenum.SecLendCallingPartyEnum;
import fpml.consolidated.fpmlenum.SecurityLendingDurationEnum;
import fpml.consolidated.repo.AdjustableOffset;
import fpml.consolidated.repo.PartyNoticePeriod;
import fpml.consolidated.repo.SecurityValuation;
import fpml.consolidated.sec.lending.SecLendCollateralProvisions;
import fpml.consolidated.sec.lending.SecLendFeeCalculation;
import fpml.consolidated.sec.lending.SecLendInitiation;
import fpml.consolidated.sec.lending.SecLendRebateCalculation;
import fpml.consolidated.sec.lending.SecLendTermination;
import fpml.consolidated.sec.lending.SecurityLending;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PositiveMoney;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecurityLendingValidator implements Validator<SecurityLending> {

	private List<ComparisonResult> getComparisonResults(SecurityLending o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("lenderPartyReference", (PartyReference) o.getLenderPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("lenderAccountReference", (AccountReference) o.getLenderAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("borrowerPartyReference", (PartyReference) o.getBorrowerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("borrowerAccountReference", (AccountReference) o.getBorrowerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("principal", (SecurityValuation) o.getPrincipal() != null ? 1 : 0, 1, 1), 
				checkCardinality("initiation", (SecLendInitiation) o.getInitiation() != null ? 1 : 0, 1, 1), 
				checkCardinality("termination", (SecLendTermination) o.getTermination() != null ? 1 : 0, 0, 1), 
				checkCardinality("duration", (SecurityLendingDurationEnum) o.getDuration() != null ? 1 : 0, 1, 1), 
				checkCardinality("extensionStyle", (ExtensionStyleEnum) o.getExtensionStyle() != null ? 1 : 0, 0, 1), 
				checkCardinality("extensionPeriod", (AdjustableOffset) o.getExtensionPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("callingParty", (SecLendCallingPartyEnum) o.getCallingParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("callDate", (AdjustableOrRelativeDate) o.getCallDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("noticePeriod", (AdjustableOffset) o.getNoticePeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyNoticePeriod", (List<? extends PartyNoticePeriod>) o.getPartyNoticePeriod() == null ? 0 : o.getPartyNoticePeriod().size(), 0, 2), 
				checkCardinality("fee", (SecLendFeeCalculation) o.getFee() != null ? 1 : 0, 0, 1), 
				checkCardinality("rebate", (SecLendRebateCalculation) o.getRebate() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("dividendRate", (BigDecimal) o.getDividendRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("minimumBillingAmount", (PositiveMoney) o.getMinimumBillingAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("rebatePaymentFrequency", (Frequency) o.getRebatePaymentFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralProvisions", (SecLendCollateralProvisions) o.getCollateralProvisions() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityLending o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecurityLending", ValidationResult.ValidationType.CARDINALITY, "SecurityLending", path, "", res.getError());
				}
				return success("SecurityLending", ValidationResult.ValidationType.CARDINALITY, "SecurityLending", path, "");
			})
			.collect(toList());
	}

}
