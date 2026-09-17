package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.AllocationReportingStatus;
import fpml.consolidated.doc.ClearingStatusValue;
import fpml.consolidated.doc.ConfirmationMethod;
import fpml.consolidated.doc.EndUserExceptionDeclaration;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.ExecutionType;
import fpml.consolidated.doc.ExecutionVenueType;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.PortfolioName;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.doc.ShortSale;
import fpml.consolidated.doc.TradeProcessingTimestamps;
import fpml.consolidated.doc.VerificationMethod;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.CollateralizationType;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyTradeInformationValidator implements Validator<PartyTradeInformation> {

	private List<ComparisonResult> getComparisonResults(PartyTradeInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("accountReference", (AccountReference) o.getAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingRole", (ReportingRole) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("isAccountingHedge", (Boolean) o.getIsAccountingHedge() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionDateTime", (ExecutionDateTime) o.getExecutionDateTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("timestamps", (TradeProcessingTimestamps) o.getTimestamps() != null ? 1 : 0, 0, 1), 
				checkCardinality("intentToAllocate", (Boolean) o.getIntentToAllocate() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationStatus", (AllocationReportingStatus) o.getAllocationStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("intentToClear", (Boolean) o.getIntentToClear() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingStatus", (ClearingStatusValue) o.getClearingStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralizationType", (CollateralizationType) o.getCollateralizationType() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralPortfolio", (PortfolioName) o.getCollateralPortfolio() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralPortfolioInitialMargin", (PortfolioName) o.getCollateralPortfolioInitialMargin() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralPortfolioVariationMargin", (PortfolioName) o.getCollateralPortfolioVariationMargin() != null ? 1 : 0, 0, 1), 
				checkCardinality("endUserException", (Boolean) o.getEndUserException() != null ? 1 : 0, 0, 1), 
				checkCardinality("endUserExceptionDeclaration", (EndUserExceptionDeclaration) o.getEndUserExceptionDeclaration() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonStandardTerms", (Boolean) o.getNonStandardTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("offMarketPrice", (Boolean) o.getOffMarketPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("largeSizeTrade", (Boolean) o.getLargeSizeTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("blockTradeIndicator", (Boolean) o.getBlockTradeIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionType", (ExecutionType) o.getExecutionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionVenueType", (ExecutionVenueType) o.getExecutionVenueType() != null ? 1 : 0, 0, 1), 
				checkCardinality("verificationMethod", (VerificationMethod) o.getVerificationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("confirmationMethod", (ConfirmationMethod) o.getConfirmationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("compressedTrade", (Boolean) o.getCompressedTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("isSecuritiesFinancing", (Boolean) o.getIsSecuritiesFinancing() != null ? 1 : 0, 0, 1), 
				checkCardinality("shortSale", (ShortSale) o.getShortSale() != null ? 1 : 0, 0, 1), 
				checkCardinality("isCommodityHedge", (Boolean) o.getIsCommodityHedge() != null ? 1 : 0, 0, 1), 
				checkCardinality("isDisputed", (Boolean) o.getIsDisputed() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyTradeInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyTradeInformation", ValidationResult.ValidationType.CARDINALITY, "PartyTradeInformation", path, "", res.getError());
				}
				return success("PartyTradeInformation", ValidationResult.ValidationType.CARDINALITY, "PartyTradeInformation", path, "");
			})
			.collect(toList());
	}

}
