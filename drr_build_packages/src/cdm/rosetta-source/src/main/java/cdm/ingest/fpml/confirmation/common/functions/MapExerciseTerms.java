package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.ExerciseTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityAmericanExercise;
import fpml.consolidated.com.CommodityEuropeanExercise;
import fpml.consolidated.com.CommodityPhysicalEuropeanExercise;
import fpml.consolidated.eqd.EquityAmericanExercise;
import fpml.consolidated.eqd.EquityBermudaExercise;
import fpml.consolidated.eqd.EquityEuropeanExercise;
import fpml.consolidated.fx.FxAmericanExercise;
import fpml.consolidated.fx.FxDigitalAmericanExercise;
import fpml.consolidated.fx.FxEuropeanExercise;
import fpml.consolidated.shared.AmericanExercise;
import fpml.consolidated.shared.BermudaExercise;
import fpml.consolidated.shared.EuropeanExercise;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapExerciseTerms.MapExerciseTermsDefault.class)
public abstract class MapExerciseTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAmericanExerciseTerms mapAmericanExerciseTerms;
	@Inject protected MapBermudaExerciseTerms mapBermudaExerciseTerms;
	@Inject protected MapCommodityAmericanExerciseTerms mapCommodityAmericanExerciseTerms;
	@Inject protected MapCommodityEuropeanExerciseTerms mapCommodityEuropeanExerciseTerms;
	@Inject protected MapCommodityPhysicalEuropeanExercise mapCommodityPhysicalEuropeanExercise;
	@Inject protected MapEquityAmericanExerciseTerms mapEquityAmericanExerciseTerms;
	@Inject protected MapEquityBermudaExerciseTerms mapEquityBermudaExerciseTerms;
	@Inject protected MapEquityEuropeanExerciseTerms mapEquityEuropeanExerciseTerms;
	@Inject protected MapEuropeanExerciseTerms mapEuropeanExerciseTerms;
	@Inject protected MapExerciseProcedure mapExerciseProcedure;
	@Inject protected MapFxAmericanExerciseTerms mapFxAmericanExerciseTerms;
	@Inject protected MapFxDigitalAmericanExercise mapFxDigitalAmericanExercise;
	@Inject protected MapFxEuropeanExerciseTerms mapFxEuropeanExerciseTerms;

	/**
	* @param fpmlExercise 
	* @param fpmlExerciseProcedure 
	* @param fpmlAutomaticExercise 
	* @param fpmlBuyerPartyReference 
	* @param fpmlSellerPartyReference 
	* @param cdmCounterpartyList 
	* @return exerciseTerms 
	*/
	public ExerciseTerms evaluate(Exercise fpmlExercise, ExerciseProcedure fpmlExerciseProcedure, Boolean fpmlAutomaticExercise, PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
		ExerciseTerms.ExerciseTermsBuilder exerciseTermsBuilder = doEvaluate(fpmlExercise, fpmlExerciseProcedure, fpmlAutomaticExercise, fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList);
		
		final ExerciseTerms exerciseTerms;
		if (exerciseTermsBuilder == null) {
			exerciseTerms = null;
		} else {
			exerciseTerms = exerciseTermsBuilder.build();
			objectValidator.validate(ExerciseTerms.class, exerciseTerms);
		}
		
		return exerciseTerms;
	}

	protected abstract ExerciseTerms.ExerciseTermsBuilder doEvaluate(Exercise fpmlExercise, ExerciseProcedure fpmlExerciseProcedure, Boolean fpmlAutomaticExercise, PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends cdm.product.template.ExerciseProcedure> cdmExerciseProcedure(Exercise fpmlExercise, ExerciseProcedure fpmlExerciseProcedure, Boolean fpmlAutomaticExercise, PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapExerciseTermsDefault extends MapExerciseTerms {
		@Override
		protected ExerciseTerms.ExerciseTermsBuilder doEvaluate(Exercise fpmlExercise, ExerciseProcedure fpmlExerciseProcedure, Boolean fpmlAutomaticExercise, PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			ExerciseTerms.ExerciseTermsBuilder exerciseTerms = ExerciseTerms.builder();
			return assignOutput(exerciseTerms, fpmlExercise, fpmlExerciseProcedure, fpmlAutomaticExercise, fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList);
		}
		
		protected ExerciseTerms.ExerciseTermsBuilder assignOutput(ExerciseTerms.ExerciseTermsBuilder exerciseTerms, Exercise fpmlExercise, ExerciseProcedure fpmlExerciseProcedure, Boolean fpmlAutomaticExercise, PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			if (fpmlExercise == null) {
				exerciseTerms = null;
			} else if (fpmlExercise instanceof EuropeanExercise) {
				final EuropeanExercise europeanExercise = (EuropeanExercise) fpmlExercise;
				exerciseTerms = toBuilder(mapEuropeanExerciseTerms.evaluate(europeanExercise, cdmExerciseProcedure(fpmlExercise, fpmlExerciseProcedure, fpmlAutomaticExercise, fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList).get(), null));
			} else if (fpmlExercise instanceof EquityEuropeanExercise) {
				final EquityEuropeanExercise equityEuropeanExercise = (EquityEuropeanExercise) fpmlExercise;
				exerciseTerms = toBuilder(mapEquityEuropeanExerciseTerms.evaluate(equityEuropeanExercise, cdmExerciseProcedure(fpmlExercise, fpmlExerciseProcedure, fpmlAutomaticExercise, fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList).get()));
			} else if (fpmlExercise instanceof CommodityEuropeanExercise) {
				final CommodityEuropeanExercise commodityEuropeanExercise = (CommodityEuropeanExercise) fpmlExercise;
				exerciseTerms = toBuilder(mapCommodityEuropeanExerciseTerms.evaluate(commodityEuropeanExercise, cdmExerciseProcedure(fpmlExercise, fpmlExerciseProcedure, fpmlAutomaticExercise, fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList).get()));
			} else if (fpmlExercise instanceof FxEuropeanExercise) {
				final FxEuropeanExercise fxEuropeanExercise = (FxEuropeanExercise) fpmlExercise;
				exerciseTerms = toBuilder(mapFxEuropeanExerciseTerms.evaluate(fxEuropeanExercise, cdmExerciseProcedure(fpmlExercise, fpmlExerciseProcedure, fpmlAutomaticExercise, fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList).get()));
			} else if (fpmlExercise instanceof BermudaExercise) {
				final BermudaExercise bermudaExercise = (BermudaExercise) fpmlExercise;
				exerciseTerms = toBuilder(mapBermudaExerciseTerms.evaluate(bermudaExercise, cdmExerciseProcedure(fpmlExercise, fpmlExerciseProcedure, fpmlAutomaticExercise, fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList).get()));
			} else if (fpmlExercise instanceof EquityBermudaExercise) {
				final EquityBermudaExercise equityBermudaExercise = (EquityBermudaExercise) fpmlExercise;
				exerciseTerms = toBuilder(mapEquityBermudaExerciseTerms.evaluate(equityBermudaExercise, cdmExerciseProcedure(fpmlExercise, fpmlExerciseProcedure, fpmlAutomaticExercise, fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList).get()));
			} else if (fpmlExercise instanceof AmericanExercise) {
				final AmericanExercise americanExercise = (AmericanExercise) fpmlExercise;
				exerciseTerms = toBuilder(mapAmericanExerciseTerms.evaluate(americanExercise, cdmExerciseProcedure(fpmlExercise, fpmlExerciseProcedure, fpmlAutomaticExercise, fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList).get()));
			} else if (fpmlExercise instanceof EquityAmericanExercise) {
				final EquityAmericanExercise equityAmericanExercise = (EquityAmericanExercise) fpmlExercise;
				exerciseTerms = toBuilder(mapEquityAmericanExerciseTerms.evaluate(equityAmericanExercise, cdmExerciseProcedure(fpmlExercise, fpmlExerciseProcedure, fpmlAutomaticExercise, fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList).get()));
			} else if (fpmlExercise instanceof CommodityAmericanExercise) {
				final CommodityAmericanExercise commodityAmericanExercise = (CommodityAmericanExercise) fpmlExercise;
				exerciseTerms = toBuilder(mapCommodityAmericanExerciseTerms.evaluate(commodityAmericanExercise, cdmExerciseProcedure(fpmlExercise, fpmlExerciseProcedure, fpmlAutomaticExercise, fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList).get()));
			} else if (fpmlExercise instanceof FxAmericanExercise) {
				final FxAmericanExercise fxAmericanExercise = (FxAmericanExercise) fpmlExercise;
				exerciseTerms = toBuilder(mapFxAmericanExerciseTerms.evaluate(fxAmericanExercise, cdmExerciseProcedure(fpmlExercise, fpmlExerciseProcedure, fpmlAutomaticExercise, fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList).get()));
			} else if (fpmlExercise instanceof FxDigitalAmericanExercise) {
				final FxDigitalAmericanExercise fxDigitalAmericanExercise = (FxDigitalAmericanExercise) fpmlExercise;
				exerciseTerms = toBuilder(mapFxDigitalAmericanExercise.evaluate(fxDigitalAmericanExercise, cdmExerciseProcedure(fpmlExercise, fpmlExerciseProcedure, fpmlAutomaticExercise, fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList).get()));
			} else if (fpmlExercise instanceof CommodityPhysicalEuropeanExercise) {
				final CommodityPhysicalEuropeanExercise commodityPhysicalEuropeanExercise = (CommodityPhysicalEuropeanExercise) fpmlExercise;
				exerciseTerms = toBuilder(mapCommodityPhysicalEuropeanExercise.evaluate(commodityPhysicalEuropeanExercise, cdmExerciseProcedure(fpmlExercise, fpmlExerciseProcedure, fpmlAutomaticExercise, fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList).get()));
			} else {
				exerciseTerms = null;
			}
			
			return Optional.ofNullable(exerciseTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends cdm.product.template.ExerciseProcedure> cdmExerciseProcedure(Exercise fpmlExercise, ExerciseProcedure fpmlExerciseProcedure, Boolean fpmlAutomaticExercise, PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			if (exists(MapperS.of(fpmlExerciseProcedure)).orNullSafe(exists(MapperS.of(fpmlAutomaticExercise))).getOrDefault(false)) {
				return MapperS.of(mapExerciseProcedure.evaluate(fpmlExerciseProcedure, fpmlBuyerPartyReference, fpmlSellerPartyReference, fpmlAutomaticExercise, cdmCounterpartyList));
			}
			return MapperS.<cdm.product.template.ExerciseProcedure>ofNull();
		}
	}
}
