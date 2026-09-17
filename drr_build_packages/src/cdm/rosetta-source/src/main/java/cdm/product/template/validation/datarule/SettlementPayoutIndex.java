package cdm.product.template.validation.datarule;

import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
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
@RosettaDataRule("SettlementPayoutIndex")
@ImplementedBy(SettlementPayoutIndex.Default.class)
public interface SettlementPayoutIndex extends Validator<SettlementPayout> {
	
	String NAME = "SettlementPayoutIndex";
	String DEFINITION = "if underlier -> Observable -> Index exists then settlementTerms -> cashSettlementTerms exists";
	
	class Default implements SettlementPayoutIndex {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPayout settlementPayout) {
			ComparisonResult result = executeDataRule(settlementPayout);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPayout", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPayout", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SettlementPayout settlementPayout) {
			try {
				if (exists(MapperS.of(settlementPayout).<Underlier>map("getUnderlier", _settlementPayout -> _settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex())).getOrDefault(false)) {
					return exists(MapperS.of(settlementPayout).<SettlementTerms>map("getSettlementTerms", _settlementPayout -> _settlementPayout.getSettlementTerms()).<CashSettlementTerms>mapC("getCashSettlementTerms", settlementTerms -> settlementTerms.getCashSettlementTerms()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementPayoutIndex {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPayout settlementPayout) {
			return Collections.emptyList();
		}
	}
}
