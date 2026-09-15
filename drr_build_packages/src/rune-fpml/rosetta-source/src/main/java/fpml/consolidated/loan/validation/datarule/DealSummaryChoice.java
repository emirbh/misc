package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.DealSummary;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("DealSummaryChoice")
@ImplementedBy(DealSummaryChoice.Default.class)
public interface DealSummaryChoice extends Validator<DealSummary> {
	
	String NAME = "DealSummaryChoice";
	String DEFINITION = "if issuedAmount exists then currency is absent else issuedAmount is absent and currentDealAmount is absent";
	
	class Default implements DealSummaryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DealSummary dealSummary) {
			ComparisonResult result = executeDataRule(dealSummary);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DealSummary", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DealSummary", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DealSummary dealSummary) {
			try {
				if (exists(MapperS.of(dealSummary).<NonNegativeMoney>map("getIssuedAmount", _dealSummary -> _dealSummary.getIssuedAmount())).getOrDefault(false)) {
					return notExists(MapperS.of(dealSummary).<Currency>map("getCurrency", _dealSummary -> _dealSummary.getCurrency()));
				}
				return notExists(MapperS.of(dealSummary).<NonNegativeMoney>map("getIssuedAmount", _dealSummary -> _dealSummary.getIssuedAmount())).andNullSafe(notExists(MapperS.of(dealSummary).<MoneyWithParticipantShare>map("getCurrentDealAmount", _dealSummary -> _dealSummary.getCurrentDealAmount())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DealSummaryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DealSummary dealSummary) {
			return Collections.emptyList();
		}
	}
}
