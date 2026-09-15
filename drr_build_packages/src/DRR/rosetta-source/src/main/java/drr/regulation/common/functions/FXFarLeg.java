package drr.regulation.common.functions;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDS;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Swap;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.util.datetime.functions.AdjustableOrAdjustedOrRelativeDateResolution;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FXFarLeg.FXFarLegDefault.class)
public abstract class FXFarLeg implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableOrAdjustedOrRelativeDateResolution adjustableOrAdjustedOrRelativeDateResolution;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected Qualify_ForeignExchange_NDS qualify_ForeignExchange_NDS;
	@Inject protected Qualify_ForeignExchange_Swap qualify_ForeignExchange_Swap;

	/**
	* @param product 
	* @return farLegPayout 
	*/
	public SettlementPayout evaluate(NonTransferableProduct product) {
		SettlementPayout.SettlementPayoutBuilder farLegPayoutBuilder = doEvaluate(product);
		
		final SettlementPayout farLegPayout;
		if (farLegPayoutBuilder == null) {
			farLegPayout = null;
		} else {
			farLegPayout = farLegPayoutBuilder.build();
			objectValidator.validate(SettlementPayout.class, farLegPayout);
		}
		
		return farLegPayout;
	}

	protected abstract SettlementPayout.SettlementPayoutBuilder doEvaluate(NonTransferableProduct product);

	protected abstract MapperC<? extends SettlementPayout> settlementPayout(NonTransferableProduct product);

	public static class FXFarLegDefault extends FXFarLeg {
		@Override
		protected SettlementPayout.SettlementPayoutBuilder doEvaluate(NonTransferableProduct product) {
			SettlementPayout.SettlementPayoutBuilder farLegPayout = SettlementPayout.builder();
			return assignOutput(farLegPayout, product);
		}
		
		protected SettlementPayout.SettlementPayoutBuilder assignOutput(SettlementPayout.SettlementPayoutBuilder farLegPayout, NonTransferableProduct product) {
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Swap.evaluate(economicTermsForProduct.evaluate(product)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDS.evaluate(economicTermsForProduct.evaluate(product))))).andNullSafe(exists(settlementPayout(product).<SettlementTerms>map("getSettlementTerms", _settlementPayout -> _settlementPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", settlementTerms -> settlementTerms.getSettlementDate()).<Date>map("getValueDate", settlementDate -> settlementDate.getValueDate()))).getOrDefault(false)) {
				farLegPayout = toBuilder(settlementPayout(product)
					.max(item -> item.<SettlementTerms>map("getSettlementTerms", _settlementPayout -> _settlementPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", settlementTerms -> settlementTerms.getSettlementDate()).<Date>map("getValueDate", settlementDate -> settlementDate.getValueDate())).get());
			} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Swap.evaluate(economicTermsForProduct.evaluate(product)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDS.evaluate(economicTermsForProduct.evaluate(product))))).andNullSafe(exists(settlementPayout(product).<SettlementTerms>map("getSettlementTerms", _settlementPayout -> _settlementPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", settlementTerms -> settlementTerms.getSettlementDate()).<AdjustableOrAdjustedOrRelativeDate>map("getAdjustableOrRelativeDate", settlementDate -> settlementDate.getAdjustableOrRelativeDate()))).getOrDefault(false)) {
				farLegPayout = toBuilder(settlementPayout(product)
					.max(item -> MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(item.<SettlementTerms>map("getSettlementTerms", _settlementPayout -> _settlementPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", settlementTerms -> settlementTerms.getSettlementDate()).<AdjustableOrAdjustedOrRelativeDate>map("getAdjustableOrRelativeDate", settlementDate -> settlementDate.getAdjustableOrRelativeDate()).get()))).get());
			} else {
				farLegPayout = null;
			}
			
			return Optional.ofNullable(farLegPayout)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends SettlementPayout> settlementPayout(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout());
		}
	}
}
