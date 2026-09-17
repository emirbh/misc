package cdm.product.template.validation.datarule;

import cdm.product.template.TradableProduct;
import cdm.product.template.TradeLot;
import cdm.product.template.functions.PriceQuantityTriangulation;
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
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("TradableProductPriceQuantityTriangulation")
@ImplementedBy(TradableProductPriceQuantityTriangulation.Default.class)
public interface TradableProductPriceQuantityTriangulation extends Validator<TradableProduct> {
	
	String NAME = "TradableProductPriceQuantityTriangulation";
	String DEFINITION = "PriceQuantityTriangulation(tradeLot) = True";
	
	class Default implements TradableProductPriceQuantityTriangulation {
	
		@Inject protected PriceQuantityTriangulation priceQuantityTriangulation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradableProduct tradableProduct) {
			ComparisonResult result = executeDataRule(tradableProduct);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradableProduct", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradableProduct", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradableProduct tradableProduct) {
			try {
				return areEqual(MapperS.of(priceQuantityTriangulation.evaluate(MapperS.of(tradableProduct).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).getMulti())), MapperS.of(true), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradableProductPriceQuantityTriangulation {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradableProduct tradableProduct) {
			return Collections.emptyList();
		}
	}
}
