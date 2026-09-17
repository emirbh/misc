package cdm.product.common.settlement.validation.datarule;

import cdm.base.datetime.Period;
import cdm.base.staticdata.asset.credit.NotDomesticCurrency;
import cdm.base.staticdata.asset.credit.ObligationCategoryEnum;
import cdm.base.staticdata.asset.credit.SpecifiedCurrency;
import cdm.product.common.settlement.DeliverableObligations;
import cdm.product.common.settlement.LoanParticipation;
import cdm.product.common.settlement.PCDeliverableObligationCharac;
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
@RosettaDataRule("DeliverableObligationsFpML_cd_34")
@ImplementedBy(DeliverableObligationsFpML_cd_34.Default.class)
public interface DeliverableObligationsFpML_cd_34 extends Validator<DeliverableObligations> {
	
	String NAME = "DeliverableObligationsFpML_cd_34";
	String DEFINITION = "if category exists and category = ObligationCategoryEnum -> ReferenceObligationsOnly then acceleratedOrMatured is absent and accruedInterest is absent and assignableLoan is absent and consentRequiredLoan is absent and directLoanParticipation is absent and excluded is absent and fullFaithAndCreditObLiability is absent and generalFundObligationLiability is absent and indirectLoanParticipation is absent and listed is absent and maximumMaturity is absent and notBearer is absent and notContingent is absent and notDomesticCurrency is absent and notDomesticIssuance is absent and notDomesticLaw is absent and notSovereignLender is absent and notSubordinated is absent and othReferenceEntityObligations is absent and revenueObligationLiability is absent and specifiedCurrency is absent and transferable is absent";
	
	class Default implements DeliverableObligationsFpML_cd_34 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeliverableObligations deliverableObligations) {
			ComparisonResult result = executeDataRule(deliverableObligations);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DeliverableObligations", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DeliverableObligations", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DeliverableObligations deliverableObligations) {
			try {
				if (exists(MapperS.of(deliverableObligations).<ObligationCategoryEnum>map("getCategory", _deliverableObligations -> _deliverableObligations.getCategory())).andNullSafe(areEqual(MapperS.of(deliverableObligations).<ObligationCategoryEnum>map("getCategory", _deliverableObligations -> _deliverableObligations.getCategory()), MapperS.of(ObligationCategoryEnum.REFERENCE_OBLIGATIONS_ONLY), CardinalityOperator.All)).getOrDefault(false)) {
					return notExists(MapperS.of(deliverableObligations).<Boolean>map("getAcceleratedOrMatured", _deliverableObligations -> _deliverableObligations.getAcceleratedOrMatured())).andNullSafe(notExists(MapperS.of(deliverableObligations).<Boolean>map("getAccruedInterest", _deliverableObligations -> _deliverableObligations.getAccruedInterest()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<PCDeliverableObligationCharac>map("getAssignableLoan", _deliverableObligations -> _deliverableObligations.getAssignableLoan()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<PCDeliverableObligationCharac>map("getConsentRequiredLoan", _deliverableObligations -> _deliverableObligations.getConsentRequiredLoan()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<LoanParticipation>map("getDirectLoanParticipation", _deliverableObligations -> _deliverableObligations.getDirectLoanParticipation()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<String>map("getExcluded", _deliverableObligations -> _deliverableObligations.getExcluded()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<Boolean>map("getFullFaithAndCreditObLiability", _deliverableObligations -> _deliverableObligations.getFullFaithAndCreditObLiability()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<Boolean>map("getGeneralFundObligationLiability", _deliverableObligations -> _deliverableObligations.getGeneralFundObligationLiability()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<LoanParticipation>map("getIndirectLoanParticipation", _deliverableObligations -> _deliverableObligations.getIndirectLoanParticipation()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<Boolean>map("getListed", _deliverableObligations -> _deliverableObligations.getListed()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<Period>map("getMaximumMaturity", _deliverableObligations -> _deliverableObligations.getMaximumMaturity()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<Boolean>map("getNotBearer", _deliverableObligations -> _deliverableObligations.getNotBearer()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<Boolean>map("getNotContingent", _deliverableObligations -> _deliverableObligations.getNotContingent()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<NotDomesticCurrency>map("getNotDomesticCurrency", _deliverableObligations -> _deliverableObligations.getNotDomesticCurrency()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<Boolean>map("getNotDomesticIssuance", _deliverableObligations -> _deliverableObligations.getNotDomesticIssuance()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<Boolean>map("getNotDomesticLaw", _deliverableObligations -> _deliverableObligations.getNotDomesticLaw()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<Boolean>map("getNotSovereignLender", _deliverableObligations -> _deliverableObligations.getNotSovereignLender()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<Boolean>map("getNotSubordinated", _deliverableObligations -> _deliverableObligations.getNotSubordinated()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<String>map("getOthReferenceEntityObligations", _deliverableObligations -> _deliverableObligations.getOthReferenceEntityObligations()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<Boolean>map("getRevenueObligationLiability", _deliverableObligations -> _deliverableObligations.getRevenueObligationLiability()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<SpecifiedCurrency>map("getSpecifiedCurrency", _deliverableObligations -> _deliverableObligations.getSpecifiedCurrency()))).andNullSafe(notExists(MapperS.of(deliverableObligations).<Boolean>map("getTransferable", _deliverableObligations -> _deliverableObligations.getTransferable())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DeliverableObligationsFpML_cd_34 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeliverableObligations deliverableObligations) {
			return Collections.emptyList();
		}
	}
}
