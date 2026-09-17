package cdm.event.common.meta;

import cdm.event.common.Trade;
import cdm.event.common.validation.TradeTypeFormatValidator;
import cdm.event.common.validation.TradeValidator;
import cdm.event.common.validation.datarule.TradeAdditionalFixedPaymentsMortgages;
import cdm.event.common.validation.datarule.TradeBarrierDerterminationAgent;
import cdm.event.common.validation.datarule.TradeClearedDate;
import cdm.event.common.validation.datarule.TradeCreditEventsMortgages;
import cdm.event.common.validation.datarule.TradeCreditEventsPhysicalSettlementMatrix;
import cdm.event.common.validation.datarule.TradeDeliverableObligationsPhysicalSettlementMatrix;
import cdm.event.common.validation.datarule.TradeDeterminingParty;
import cdm.event.common.validation.datarule.TradeDisruptionEventsDeterminingParty;
import cdm.event.common.validation.datarule.TradeExtraordinaryEvents;
import cdm.event.common.validation.datarule.TradeFloatingAmountEventsMortgages;
import cdm.event.common.validation.datarule.TradeFpML_cd_1;
import cdm.event.common.validation.datarule.TradeFpML_cd_11;
import cdm.event.common.validation.datarule.TradeFpML_cd_19;
import cdm.event.common.validation.datarule.TradeFpML_cd_20;
import cdm.event.common.validation.datarule.TradeFpML_cd_23;
import cdm.event.common.validation.datarule.TradeFpML_cd_24;
import cdm.event.common.validation.datarule.TradeFpML_cd_25;
import cdm.event.common.validation.datarule.TradeFpML_cd_32;
import cdm.event.common.validation.datarule.TradeFpML_cd_7;
import cdm.event.common.validation.datarule.TradeFpML_cd_8;
import cdm.event.common.validation.datarule.TradeFpML_ird_8;
import cdm.event.common.validation.datarule.TradeHedgingParty;
import cdm.event.common.validation.datarule.TradeObligationsPhysicalSettlementMatrix;
import cdm.event.common.validation.datarule.TradePackageTrade;
import cdm.event.common.validation.datarule.TradeRestructuringPhysicalSettlementMatrix;
import cdm.event.common.validation.datarule.TradeSettlementPayout;
import cdm.event.common.validation.exists.TradeOnlyExistsValidator;
import cdm.product.template.TradableProduct;
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
@RosettaMeta(model=Trade.class)
public class TradeMeta implements RosettaMetaData<Trade> {

	@Override
	public List<Validator<? super Trade>> dataRules(ValidatorFactory factory) {
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
			factory.<TradableProduct>create(TradableProductCalculationAgentMandatoryEarlyTermination.class),
			factory.<Trade>create(TradeSettlementPayout.class),
			factory.<Trade>create(TradePackageTrade.class),
			factory.<Trade>create(TradeDeliverableObligationsPhysicalSettlementMatrix.class),
			factory.<Trade>create(TradeObligationsPhysicalSettlementMatrix.class),
			factory.<Trade>create(TradeCreditEventsPhysicalSettlementMatrix.class),
			factory.<Trade>create(TradeRestructuringPhysicalSettlementMatrix.class),
			factory.<Trade>create(TradeAdditionalFixedPaymentsMortgages.class),
			factory.<Trade>create(TradeFloatingAmountEventsMortgages.class),
			factory.<Trade>create(TradeCreditEventsMortgages.class),
			factory.<Trade>create(TradeHedgingParty.class),
			factory.<Trade>create(TradeDeterminingParty.class),
			factory.<Trade>create(TradeBarrierDerterminationAgent.class),
			factory.<Trade>create(TradeClearedDate.class),
			factory.<Trade>create(TradeFpML_cd_1.class),
			factory.<Trade>create(TradeFpML_cd_7.class),
			factory.<Trade>create(TradeFpML_cd_8.class),
			factory.<Trade>create(TradeFpML_cd_11.class),
			factory.<Trade>create(TradeFpML_cd_19.class),
			factory.<Trade>create(TradeFpML_cd_20.class),
			factory.<Trade>create(TradeFpML_cd_23.class),
			factory.<Trade>create(TradeFpML_cd_24.class),
			factory.<Trade>create(TradeFpML_cd_25.class),
			factory.<Trade>create(TradeFpML_cd_32.class),
			factory.<Trade>create(TradeFpML_ird_8.class),
			factory.<Trade>create(TradeExtraordinaryEvents.class),
			factory.<Trade>create(TradeDisruptionEventsDeterminingParty.class)
		);
	}
	
	@Override
	public List<Function<? super Trade, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Trade> validator(ValidatorFactory factory) {
		return factory.<Trade>create(TradeValidator.class);
	}

	@Override
	public Validator<? super Trade> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Trade>create(TradeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Trade> validator() {
		return new TradeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Trade> typeFormatValidator() {
		return new TradeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Trade, Set<String>> onlyExistsValidator() {
		return new TradeOnlyExistsValidator();
	}
}
