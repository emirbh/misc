package cdm.product.template.meta;

import cdm.product.template.TradableProduct;
import cdm.product.template.validation.TradableProductTypeFormatValidator;
import cdm.product.template.validation.TradableProductValidator;
import cdm.product.template.validation.datarule.TradableProductCalculationAgentIndependent;
import cdm.product.template.validation.datarule.TradableProductCalculationAgentMandatoryEarlyTermination;
import cdm.product.template.validation.datarule.TradableProductCalculationAgentOptionalEarlyTermination;
import cdm.product.template.validation.datarule.TradableProductExerciseNoticeReceiverPartyCancelableProvision;
import cdm.product.template.validation.datarule.TradableProductExerciseNoticeReceiverPartyExtendibleProvision;
import cdm.product.template.validation.datarule.TradableProductExerciseNoticeReceiverPartyManual;
import cdm.product.template.validation.datarule.TradableProductExerciseNoticeReceiverPartyOptionalEarlyTermination;
import cdm.product.template.validation.datarule.TradableProductForwardPayout_PredeterminedClearingOrganizationParty;
import cdm.product.template.validation.datarule.TradableProductNotionalAdjustment;
import cdm.product.template.validation.datarule.TradableProductOptionPayout_PredeterminedClearingOrganizationParty;
import cdm.product.template.validation.datarule.TradableProductPerformancePayout_ExtraordinaryDividendsParty;
import cdm.product.template.validation.datarule.TradableProductPredeterminedClearingOrganizationParty;
import cdm.product.template.validation.datarule.TradableProductPriceQuantityTriangulation;
import cdm.product.template.validation.exists.TradableProductOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=TradableProduct.class)
public class TradableProductMeta implements RosettaMetaData<TradableProduct> {

	@Override
	public List<Validator<? super TradableProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradableProduct>create(TradableProductPriceQuantityTriangulation.class),
			factory.<TradableProduct>create(TradableProductNotionalAdjustment.class),
			factory.<TradableProduct>create(TradableProductPerformancePayout_ExtraordinaryDividendsParty.class),
			factory.<TradableProduct>create(TradableProductOptionPayout_PredeterminedClearingOrganizationParty.class),
			factory.<TradableProduct>create(TradableProductForwardPayout_PredeterminedClearingOrganizationParty.class),
			factory.<TradableProduct>create(TradableProductPredeterminedClearingOrganizationParty.class),
			factory.<TradableProduct>create(TradableProductExerciseNoticeReceiverPartyManual.class),
			factory.<TradableProduct>create(TradableProductExerciseNoticeReceiverPartyOptionalEarlyTermination.class),
			factory.<TradableProduct>create(TradableProductExerciseNoticeReceiverPartyCancelableProvision.class),
			factory.<TradableProduct>create(TradableProductExerciseNoticeReceiverPartyExtendibleProvision.class),
			factory.<TradableProduct>create(TradableProductCalculationAgentIndependent.class),
			factory.<TradableProduct>create(TradableProductCalculationAgentOptionalEarlyTermination.class),
			factory.<TradableProduct>create(TradableProductCalculationAgentMandatoryEarlyTermination.class)
		);
	}
	
	@Override
	public List<Function<? super TradableProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradableProduct> validator(ValidatorFactory factory) {
		return factory.<TradableProduct>create(TradableProductValidator.class);
	}

	@Override
	public Validator<? super TradableProduct> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradableProduct>create(TradableProductTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradableProduct> validator() {
		return new TradableProductValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradableProduct> typeFormatValidator() {
		return new TradableProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradableProduct, Set<String>> onlyExistsValidator() {
		return new TradableProductOnlyExistsValidator();
	}
}
