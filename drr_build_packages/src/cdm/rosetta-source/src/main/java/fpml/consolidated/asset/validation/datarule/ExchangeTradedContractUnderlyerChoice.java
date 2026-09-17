package fpml.consolidated.asset.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.ExchangeTradedContractUnderlyer;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ExchangeTradedContractUnderlyerChoice")
@ImplementedBy(ExchangeTradedContractUnderlyerChoice.Default.class)
public interface ExchangeTradedContractUnderlyerChoice extends Validator<ExchangeTradedContractUnderlyer> {
	
	String NAME = "ExchangeTradedContractUnderlyerChoice";
	String DEFINITION = "if floatingRateIndex exists then quotedCurrencyPair is absent and underlyingAsset is absent else if quotedCurrencyPair exists then floatingRateIndex is absent and indexTenor is absent and underlyingAsset is absent else if underlyingAsset exists then floatingRateIndex is absent and quotedCurrencyPair is absent and indexTenor is absent else False";
	
	class Default implements ExchangeTradedContractUnderlyerChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeTradedContractUnderlyer exchangeTradedContractUnderlyer) {
			ComparisonResult result = executeDataRule(exchangeTradedContractUnderlyer);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExchangeTradedContractUnderlyer", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExchangeTradedContractUnderlyer", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ExchangeTradedContractUnderlyer exchangeTradedContractUnderlyer) {
			try {
				if (exists(MapperS.of(exchangeTradedContractUnderlyer).<FloatingRateIndex>map("getFloatingRateIndex", _exchangeTradedContractUnderlyer -> _exchangeTradedContractUnderlyer.getFloatingRateIndex())).getOrDefault(false)) {
					return notExists(MapperS.of(exchangeTradedContractUnderlyer).<QuotedCurrencyPair>map("getQuotedCurrencyPair", _exchangeTradedContractUnderlyer -> _exchangeTradedContractUnderlyer.getQuotedCurrencyPair())).andNullSafe(notExists(MapperS.of(exchangeTradedContractUnderlyer).<Asset>mapC("getUnderlyingAsset", _exchangeTradedContractUnderlyer -> _exchangeTradedContractUnderlyer.getUnderlyingAsset())));
				}
				if (exists(MapperS.of(exchangeTradedContractUnderlyer).<QuotedCurrencyPair>map("getQuotedCurrencyPair", _exchangeTradedContractUnderlyer -> _exchangeTradedContractUnderlyer.getQuotedCurrencyPair())).getOrDefault(false)) {
					return notExists(MapperS.of(exchangeTradedContractUnderlyer).<FloatingRateIndex>map("getFloatingRateIndex", _exchangeTradedContractUnderlyer -> _exchangeTradedContractUnderlyer.getFloatingRateIndex())).andNullSafe(notExists(MapperS.of(exchangeTradedContractUnderlyer).<Period>map("getIndexTenor", _exchangeTradedContractUnderlyer -> _exchangeTradedContractUnderlyer.getIndexTenor()))).andNullSafe(notExists(MapperS.of(exchangeTradedContractUnderlyer).<Asset>mapC("getUnderlyingAsset", _exchangeTradedContractUnderlyer -> _exchangeTradedContractUnderlyer.getUnderlyingAsset())));
				}
				if (exists(MapperS.of(exchangeTradedContractUnderlyer).<Asset>mapC("getUnderlyingAsset", _exchangeTradedContractUnderlyer -> _exchangeTradedContractUnderlyer.getUnderlyingAsset())).getOrDefault(false)) {
					return notExists(MapperS.of(exchangeTradedContractUnderlyer).<FloatingRateIndex>map("getFloatingRateIndex", _exchangeTradedContractUnderlyer -> _exchangeTradedContractUnderlyer.getFloatingRateIndex())).andNullSafe(notExists(MapperS.of(exchangeTradedContractUnderlyer).<QuotedCurrencyPair>map("getQuotedCurrencyPair", _exchangeTradedContractUnderlyer -> _exchangeTradedContractUnderlyer.getQuotedCurrencyPair()))).andNullSafe(notExists(MapperS.of(exchangeTradedContractUnderlyer).<Period>map("getIndexTenor", _exchangeTradedContractUnderlyer -> _exchangeTradedContractUnderlyer.getIndexTenor())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExchangeTradedContractUnderlyerChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeTradedContractUnderlyer exchangeTradedContractUnderlyer) {
			return Collections.emptyList();
		}
	}
}
