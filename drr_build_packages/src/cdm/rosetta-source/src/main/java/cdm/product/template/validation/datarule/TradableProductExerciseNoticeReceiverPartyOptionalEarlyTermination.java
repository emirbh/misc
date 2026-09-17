package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.template.EarlyTerminationProvision;
import cdm.product.template.EconomicTerms;
import cdm.product.template.ExerciseNotice;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionalEarlyTermination;
import cdm.product.template.TerminationProvision;
import cdm.product.template.TradableProduct;
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
@RosettaDataRule("TradableProductExerciseNoticeReceiverPartyOptionalEarlyTermination")
@ImplementedBy(TradableProductExerciseNoticeReceiverPartyOptionalEarlyTermination.Default.class)
public interface TradableProductExerciseNoticeReceiverPartyOptionalEarlyTermination extends Validator<TradableProduct> {
	
	String NAME = "TradableProductExerciseNoticeReceiverPartyOptionalEarlyTermination";
	String DEFINITION = "if product -> economicTerms -> terminationProvision -> earlyTerminationProvision -> optionalEarlyTermination -> exerciseNotice -> exerciseNoticeReceiver exists then ancillaryParty -> role contains AncillaryRoleEnum -> ExerciseNoticeReceiverPartyOptionalEarlyTermination and if ancillaryParty -> role contains AncillaryRoleEnum -> ExerciseNoticeReceiverPartyOptionalEarlyTermination then product -> economicTerms -> terminationProvision -> earlyTerminationProvision -> optionalEarlyTermination -> exerciseNotice -> exerciseNoticeReceiver exists";
	
	class Default implements TradableProductExerciseNoticeReceiverPartyOptionalEarlyTermination {
	
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
				if (exists(MapperS.of(tradableProduct).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<TerminationProvision>map("getTerminationProvision", economicTerms -> economicTerms.getTerminationProvision()).<EarlyTerminationProvision>map("getEarlyTerminationProvision", terminationProvision -> terminationProvision.getEarlyTerminationProvision()).<OptionalEarlyTermination>map("getOptionalEarlyTermination", earlyTerminationProvision -> earlyTerminationProvision.getOptionalEarlyTermination()).<ExerciseNotice>mapC("getExerciseNotice", optionalEarlyTermination -> optionalEarlyTermination.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", exerciseNotice -> exerciseNotice.getExerciseNoticeReceiver())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (contains(MapperS.of(tradableProduct).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).<AncillaryRoleEnum>map("getRole", ancillaryParty -> ancillaryParty.getRole()), MapperS.of(AncillaryRoleEnum.EXERCISE_NOTICE_RECEIVER_PARTY_OPTIONAL_EARLY_TERMINATION)).getOrDefault(false)) {
						ifThenElseResult = exists(MapperS.of(tradableProduct).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<TerminationProvision>map("getTerminationProvision", economicTerms -> economicTerms.getTerminationProvision()).<EarlyTerminationProvision>map("getEarlyTerminationProvision", terminationProvision -> terminationProvision.getEarlyTerminationProvision()).<OptionalEarlyTermination>map("getOptionalEarlyTermination", earlyTerminationProvision -> earlyTerminationProvision.getOptionalEarlyTermination()).<ExerciseNotice>mapC("getExerciseNotice", optionalEarlyTermination -> optionalEarlyTermination.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", exerciseNotice -> exerciseNotice.getExerciseNoticeReceiver()));
					} else {
						ifThenElseResult = ComparisonResult.ofEmpty();
					}
					return contains(MapperS.of(tradableProduct).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).<AncillaryRoleEnum>map("getRole", ancillaryParty -> ancillaryParty.getRole()), MapperS.of(AncillaryRoleEnum.EXERCISE_NOTICE_RECEIVER_PARTY_OPTIONAL_EARLY_TERMINATION)).andNullSafe(ifThenElseResult);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradableProductExerciseNoticeReceiverPartyOptionalEarlyTermination {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradableProduct tradableProduct) {
			return Collections.emptyList();
		}
	}
}
