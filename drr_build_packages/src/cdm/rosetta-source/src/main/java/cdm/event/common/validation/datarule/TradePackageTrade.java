package cdm.event.common.validation.datarule;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.IdentifiedList;
import cdm.base.staticdata.identifier.Identifier;
import cdm.event.common.ExecutionDetails;
import cdm.event.common.Trade;
import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("TradePackageTrade")
@ImplementedBy(TradePackageTrade.Default.class)
public interface TradePackageTrade extends Validator<Trade> {
	
	String NAME = "TradePackageTrade";
	String DEFINITION = "if executionDetails -> packageReference exists then executionDetails -> packageReference -> componentId -> assignedIdentifier contains tradeIdentifier -> assignedIdentifier";
	
	class Default implements TradePackageTrade {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trade trade) {
			ComparisonResult result = executeDataRule(trade);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Trade", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Trade", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Trade trade) {
			try {
				if (exists(MapperS.of(trade).<ExecutionDetails>map("getExecutionDetails", _trade -> _trade.getExecutionDetails()).<IdentifiedList>map("getPackageReference", executionDetails -> executionDetails.getPackageReference())).getOrDefault(false)) {
					return contains(MapperS.of(trade).<ExecutionDetails>map("getExecutionDetails", _trade -> _trade.getExecutionDetails()).<IdentifiedList>map("getPackageReference", executionDetails -> executionDetails.getPackageReference()).<Identifier>mapC("getComponentId", identifiedList -> identifiedList.getComponentId()).<AssignedIdentifier>mapC("getAssignedIdentifier", identifier -> identifier.getAssignedIdentifier()), MapperS.of(trade).<TradeIdentifier>mapC("getTradeIdentifier", _trade -> _trade.getTradeIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradePackageTrade {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trade trade) {
			return Collections.emptyList();
		}
	}
}
