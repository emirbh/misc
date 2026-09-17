package cdm.event.common.validation.datarule;

import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.event.common.BillingSummary;
import cdm.event.common.RecordAmountTypeEnum;
import cdm.event.common.Transfer;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("BillingSummaryGrandTotal")
@ImplementedBy(BillingSummaryGrandTotal.Default.class)
public interface BillingSummaryGrandTotal extends Validator<BillingSummary> {
	
	String NAME = "BillingSummaryGrandTotal";
	String DEFINITION = "if summaryAmountType = RecordAmountTypeEnum -> GrandTotal then summaryTransfer exists and summaryTransfer -> payerReceiver is absent";
	
	class Default implements BillingSummaryGrandTotal {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BillingSummary billingSummary) {
			ComparisonResult result = executeDataRule(billingSummary);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BillingSummary", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BillingSummary", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(BillingSummary billingSummary) {
			try {
				if (areEqual(MapperS.of(billingSummary).<RecordAmountTypeEnum>map("getSummaryAmountType", _billingSummary -> _billingSummary.getSummaryAmountType()), MapperS.of(RecordAmountTypeEnum.GRAND_TOTAL), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(billingSummary).<Transfer>map("getSummaryTransfer", _billingSummary -> _billingSummary.getSummaryTransfer())).andNullSafe(notExists(MapperS.of(billingSummary).<Transfer>map("getSummaryTransfer", _billingSummary -> _billingSummary.getSummaryTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BillingSummaryGrandTotal {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BillingSummary billingSummary) {
			return Collections.emptyList();
		}
	}
}
