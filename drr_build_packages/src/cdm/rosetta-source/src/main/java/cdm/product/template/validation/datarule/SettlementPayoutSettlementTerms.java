package cdm.product.template.validation.datarule;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Cash;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
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
@RosettaDataRule("SettlementPayoutSettlementTerms")
@ImplementedBy(SettlementPayoutSettlementTerms.Default.class)
public interface SettlementPayoutSettlementTerms extends Validator<SettlementPayout> {
	
	String NAME = "SettlementPayoutSettlementTerms";
	String DEFINITION = "if underlier -> Observable -> Asset -> Cash exists then settlementTerms exists";
	
	class Default implements SettlementPayoutSettlementTerms {
	
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
				if (exists(MapperS.of(settlementPayout).<Underlier>map("getUnderlier", _settlementPayout -> _settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Cash>map("getCash", asset -> asset.getCash())).getOrDefault(false)) {
					return exists(MapperS.of(settlementPayout).<SettlementTerms>map("getSettlementTerms", _settlementPayout -> _settlementPayout.getSettlementTerms()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementPayoutSettlementTerms {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPayout settlementPayout) {
			return Collections.emptyList();
		}
	}
}
