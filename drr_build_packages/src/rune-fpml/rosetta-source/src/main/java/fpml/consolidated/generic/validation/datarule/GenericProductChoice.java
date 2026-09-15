package fpml.consolidated.generic.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.generic.GenericProduct;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("GenericProductChoice")
@ImplementedBy(GenericProductChoice.Default.class)
public interface GenericProductChoice extends Validator<GenericProduct> {
	
	String NAME = "GenericProductChoice";
	String DEFINITION = "if buyerPartyReference exists or sellerPartyReference exists then buyerPartyReference exists and sellerPartyReference exists and counterpartyReference is absent else buyerPartyReference is absent and sellerPartyReference is absent and buyerAccountReference is absent and sellerAccountReference is absent";
	
	class Default implements GenericProductChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericProduct genericProduct) {
			ComparisonResult result = executeDataRule(genericProduct);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "GenericProduct", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "GenericProduct", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(GenericProduct genericProduct) {
			try {
				if (exists(MapperS.of(genericProduct).<PartyReference>map("getBuyerPartyReference", _genericProduct -> _genericProduct.getBuyerPartyReference())).orNullSafe(exists(MapperS.of(genericProduct).<PartyReference>map("getSellerPartyReference", _genericProduct -> _genericProduct.getSellerPartyReference()))).getOrDefault(false)) {
					return exists(MapperS.of(genericProduct).<PartyReference>map("getBuyerPartyReference", _genericProduct -> _genericProduct.getBuyerPartyReference())).andNullSafe(exists(MapperS.of(genericProduct).<PartyReference>map("getSellerPartyReference", _genericProduct -> _genericProduct.getSellerPartyReference()))).andNullSafe(notExists(MapperS.of(genericProduct).<PartyReference>mapC("getCounterpartyReference", _genericProduct -> _genericProduct.getCounterpartyReference())));
				}
				return notExists(MapperS.of(genericProduct).<PartyReference>map("getBuyerPartyReference", _genericProduct -> _genericProduct.getBuyerPartyReference())).andNullSafe(notExists(MapperS.of(genericProduct).<PartyReference>map("getSellerPartyReference", _genericProduct -> _genericProduct.getSellerPartyReference()))).andNullSafe(notExists(MapperS.of(genericProduct).<AccountReference>map("getBuyerAccountReference", _genericProduct -> _genericProduct.getBuyerAccountReference()))).andNullSafe(notExists(MapperS.of(genericProduct).<AccountReference>map("getSellerAccountReference", _genericProduct -> _genericProduct.getSellerAccountReference())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements GenericProductChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericProduct genericProduct) {
			return Collections.emptyList();
		}
	}
}
