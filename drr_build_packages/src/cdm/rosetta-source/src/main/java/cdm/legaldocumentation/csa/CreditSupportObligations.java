package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CreditSupportObligationsMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the Credit Support Obligations applicable to the Initial Margin Credit Support Annex.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(c)" * name "Credit Support Obligations"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(d)" * name "Credit Support Obligations"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(c) " * name "Credit Support Obligations"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CreditSupportObligations", builder=CreditSupportObligations.CreditSupportObligationsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CreditSupportObligations", model="cdm", builder=CreditSupportObligations.CreditSupportObligationsBuilderImpl.class, version="6.23.0")
public interface CreditSupportObligations extends RosettaModelObject {

	CreditSupportObligationsMeta metaData = new CreditSupportObligationsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Delivery Amount (VM) has the meaning specified in Paragraph 3(a), unless otherwise specified here.
	 */
	String getDeliveryAmount();
	/**
	 * Return Amount (VM) has the meaning specified in Paragraph 3(a), unless otherwise specified here.
	 */
	String getReturnAmount();
	/**
	 * The selection of Margin Approach applicable to the agreement.
	 */
	MarginApproach getMarginApproach();
	/**
	 * The Other Eligible Support election. If not specified, this election is deemed as not applicable.
	 */
	String getOtherEligibleSupport();
	/**
	 * The amount of net exposure that a party is willing to bear in relation to the other party before it requires asking for collateral.
	 *
	 * Body ISDA
	 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
	 * paragraph "13 General Principles" * clause "(c )(vi)(A)" * name "Threshold"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(d)(vi)(A)" * name "Threshold"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(c )(vi)(A)" * name "Threshold"
	 *
	 * Provision 
	 *
	 */
	Threshold getThreshold();
	/**
	 * The net amount of exposure reached before collateral has to be posted or returned.
	 *
	 * Body ISDA
	 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
	 * paragraph "13 General Principles" * clause "(c )(vi)(B)" * name "Minimum Transfer Amount"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(d)(vi)(B)" * name "Minimum Transfer Amount"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(c )(vi)(B)" * name "Minimum Transfer Amount"
	 *
	 * Provision 
	 *
	 */
	MinimumTransferAmount getMinimumTransferAmount();
	/**
	 * The rounding methodology applicable to the Delivery Amount and the Return Amount in terms of nearest integral multiple of Base Currency units.
	 *
	 * Body ISDA
	 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
	 * paragraph "13 General Principles" * clause "(c)(vi)( C )" * name "Rounding"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(d)(vi)( C )" * name "Rounding"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(c)(vi)( C )" * name "Rounding"
	 *
	 * Provision 
	 *
	 */
	CollateralRounding getRounding();
	/**
	 * The time by which the transfer of collateral must take place when different from the Regular Settlement Day as a result of parties&#39; election.
	 */
	BespokeTransferTiming getBespokeTransferTiming();
	/**
	 * The specification of Credit Support Obligations applicable to Variation Margin agreements.
	 */
	CreditSupportObligationsVariationMargin getCreditSupportObligationsVariationMargin();
	/**
	 *
	 * Body ISDA
	 * Corpus Annex CSA_NewYork_1994 1994 New York Law Credit Support Annex  
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_English_1995 1995 English Law Credit Support Annex  
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Deed CSD_English_1995 1995 English Law Credit Support Deed  
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_English_2016 2016 English Law Variation Margin Credit Support Annex  
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_NewYork_2016 2016 New York Law Variation Margin Credit Support Annex  
	 *
	 * Provision 
	 *
	 */
	List<? extends CSAThreshold> getLegacyThreshold();
	/**
	 *
	 * Body ISDA
	 * Corpus Annex CSA_NewYork_1994 1994 New York Law Credit Support Annex  
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_English_1995 1995 English Law Credit Support Annex  
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Deed CSD_English_1995 1995 English Law Credit Support Deed  
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_English_2016 2016 English Law Variation Margin Credit Support Annex  
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_NewYork_2016 2016 New York Law Variation Margin Credit Support Annex  
	 *
	 * Provision 
	 *
	 */
	List<? extends CSAMinimumTransferAmount> getLegacyMinimumTransferAmount();
	/**
	 * In respect of a Valuation Date, the amount of collateral which a party is entitled to demand to be transferred to it as a Delivery Amount.
	 */
	LegacyDeliveryAmount getLegacyDeliveryAmount();
	/**
	 * In respect of a Valuation Date, the amount of collateral which a party is entitled to demand to be recalled to it as a Return Amount.
	 */
	LegacyReturnAmount getLegacyReturnAmount();
	/**
	 * The total amount one counterparty must deliver to the other at any time: the combination of the Exposure to that party and the net Independent Amounts it must post, minus any agreed Threshold.
	 */
	CreditSupportAmount getCreditSupportAmount();
	/**
	 * Specification of transfer / settlement timing for cash and securities collateral assuming that the notice is provided before the Notification Time (and with a 1LBD lag introduced if the notice is delivered after the Notification Time), and that securities allow for a further Local Business Day for transfer / settlement.
	 */
	CollateralTransferTiming getCollateralTransferTiming();

	/*********************** Build Methods  ***********************/
	CreditSupportObligations build();
	
	CreditSupportObligations.CreditSupportObligationsBuilder toBuilder();
	
	static CreditSupportObligations.CreditSupportObligationsBuilder builder() {
		return new CreditSupportObligations.CreditSupportObligationsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditSupportObligations> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditSupportObligations> getType() {
		return CreditSupportObligations.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("deliveryAmount"), String.class, getDeliveryAmount(), this);
		processor.processBasic(path.newSubPath("returnAmount"), String.class, getReturnAmount(), this);
		processRosetta(path.newSubPath("marginApproach"), processor, MarginApproach.class, getMarginApproach());
		processor.processBasic(path.newSubPath("otherEligibleSupport"), String.class, getOtherEligibleSupport(), this);
		processRosetta(path.newSubPath("threshold"), processor, Threshold.class, getThreshold());
		processRosetta(path.newSubPath("minimumTransferAmount"), processor, MinimumTransferAmount.class, getMinimumTransferAmount());
		processRosetta(path.newSubPath("rounding"), processor, CollateralRounding.class, getRounding());
		processRosetta(path.newSubPath("bespokeTransferTiming"), processor, BespokeTransferTiming.class, getBespokeTransferTiming());
		processRosetta(path.newSubPath("creditSupportObligationsVariationMargin"), processor, CreditSupportObligationsVariationMargin.class, getCreditSupportObligationsVariationMargin());
		processRosetta(path.newSubPath("legacyThreshold"), processor, CSAThreshold.class, getLegacyThreshold());
		processRosetta(path.newSubPath("legacyMinimumTransferAmount"), processor, CSAMinimumTransferAmount.class, getLegacyMinimumTransferAmount());
		processRosetta(path.newSubPath("legacyDeliveryAmount"), processor, LegacyDeliveryAmount.class, getLegacyDeliveryAmount());
		processRosetta(path.newSubPath("legacyReturnAmount"), processor, LegacyReturnAmount.class, getLegacyReturnAmount());
		processRosetta(path.newSubPath("creditSupportAmount"), processor, CreditSupportAmount.class, getCreditSupportAmount());
		processRosetta(path.newSubPath("collateralTransferTiming"), processor, CollateralTransferTiming.class, getCollateralTransferTiming());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditSupportObligationsBuilder extends CreditSupportObligations, RosettaModelObjectBuilder {
		MarginApproach.MarginApproachBuilder getOrCreateMarginApproach();
		@Override
		MarginApproach.MarginApproachBuilder getMarginApproach();
		Threshold.ThresholdBuilder getOrCreateThreshold();
		@Override
		Threshold.ThresholdBuilder getThreshold();
		MinimumTransferAmount.MinimumTransferAmountBuilder getOrCreateMinimumTransferAmount();
		@Override
		MinimumTransferAmount.MinimumTransferAmountBuilder getMinimumTransferAmount();
		CollateralRounding.CollateralRoundingBuilder getOrCreateRounding();
		@Override
		CollateralRounding.CollateralRoundingBuilder getRounding();
		BespokeTransferTiming.BespokeTransferTimingBuilder getOrCreateBespokeTransferTiming();
		@Override
		BespokeTransferTiming.BespokeTransferTimingBuilder getBespokeTransferTiming();
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder getOrCreateCreditSupportObligationsVariationMargin();
		@Override
		CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder getCreditSupportObligationsVariationMargin();
		CSAThreshold.CSAThresholdBuilder getOrCreateLegacyThreshold(int index);
		@Override
		List<? extends CSAThreshold.CSAThresholdBuilder> getLegacyThreshold();
		CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder getOrCreateLegacyMinimumTransferAmount(int index);
		@Override
		List<? extends CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder> getLegacyMinimumTransferAmount();
		LegacyDeliveryAmount.LegacyDeliveryAmountBuilder getOrCreateLegacyDeliveryAmount();
		@Override
		LegacyDeliveryAmount.LegacyDeliveryAmountBuilder getLegacyDeliveryAmount();
		LegacyReturnAmount.LegacyReturnAmountBuilder getOrCreateLegacyReturnAmount();
		@Override
		LegacyReturnAmount.LegacyReturnAmountBuilder getLegacyReturnAmount();
		CreditSupportAmount.CreditSupportAmountBuilder getOrCreateCreditSupportAmount();
		@Override
		CreditSupportAmount.CreditSupportAmountBuilder getCreditSupportAmount();
		CollateralTransferTiming.CollateralTransferTimingBuilder getOrCreateCollateralTransferTiming();
		@Override
		CollateralTransferTiming.CollateralTransferTimingBuilder getCollateralTransferTiming();
		CreditSupportObligations.CreditSupportObligationsBuilder setDeliveryAmount(String deliveryAmount);
		CreditSupportObligations.CreditSupportObligationsBuilder setReturnAmount(String returnAmount);
		CreditSupportObligations.CreditSupportObligationsBuilder setMarginApproach(MarginApproach marginApproach);
		CreditSupportObligations.CreditSupportObligationsBuilder setOtherEligibleSupport(String otherEligibleSupport);
		CreditSupportObligations.CreditSupportObligationsBuilder setThreshold(Threshold threshold);
		CreditSupportObligations.CreditSupportObligationsBuilder setMinimumTransferAmount(MinimumTransferAmount minimumTransferAmount);
		CreditSupportObligations.CreditSupportObligationsBuilder setRounding(CollateralRounding rounding);
		CreditSupportObligations.CreditSupportObligationsBuilder setBespokeTransferTiming(BespokeTransferTiming bespokeTransferTiming);
		CreditSupportObligations.CreditSupportObligationsBuilder setCreditSupportObligationsVariationMargin(CreditSupportObligationsVariationMargin creditSupportObligationsVariationMargin);
		CreditSupportObligations.CreditSupportObligationsBuilder addLegacyThreshold(CSAThreshold legacyThreshold);
		CreditSupportObligations.CreditSupportObligationsBuilder addLegacyThreshold(CSAThreshold legacyThreshold, int idx);
		CreditSupportObligations.CreditSupportObligationsBuilder addLegacyThreshold(List<? extends CSAThreshold> legacyThreshold);
		CreditSupportObligations.CreditSupportObligationsBuilder setLegacyThreshold(List<? extends CSAThreshold> legacyThreshold);
		CreditSupportObligations.CreditSupportObligationsBuilder addLegacyMinimumTransferAmount(CSAMinimumTransferAmount legacyMinimumTransferAmount);
		CreditSupportObligations.CreditSupportObligationsBuilder addLegacyMinimumTransferAmount(CSAMinimumTransferAmount legacyMinimumTransferAmount, int idx);
		CreditSupportObligations.CreditSupportObligationsBuilder addLegacyMinimumTransferAmount(List<? extends CSAMinimumTransferAmount> legacyMinimumTransferAmount);
		CreditSupportObligations.CreditSupportObligationsBuilder setLegacyMinimumTransferAmount(List<? extends CSAMinimumTransferAmount> legacyMinimumTransferAmount);
		CreditSupportObligations.CreditSupportObligationsBuilder setLegacyDeliveryAmount(LegacyDeliveryAmount legacyDeliveryAmount);
		CreditSupportObligations.CreditSupportObligationsBuilder setLegacyReturnAmount(LegacyReturnAmount legacyReturnAmount);
		CreditSupportObligations.CreditSupportObligationsBuilder setCreditSupportAmount(CreditSupportAmount creditSupportAmount);
		CreditSupportObligations.CreditSupportObligationsBuilder setCollateralTransferTiming(CollateralTransferTiming collateralTransferTiming);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("deliveryAmount"), String.class, getDeliveryAmount(), this);
			processor.processBasic(path.newSubPath("returnAmount"), String.class, getReturnAmount(), this);
			processRosetta(path.newSubPath("marginApproach"), processor, MarginApproach.MarginApproachBuilder.class, getMarginApproach());
			processor.processBasic(path.newSubPath("otherEligibleSupport"), String.class, getOtherEligibleSupport(), this);
			processRosetta(path.newSubPath("threshold"), processor, Threshold.ThresholdBuilder.class, getThreshold());
			processRosetta(path.newSubPath("minimumTransferAmount"), processor, MinimumTransferAmount.MinimumTransferAmountBuilder.class, getMinimumTransferAmount());
			processRosetta(path.newSubPath("rounding"), processor, CollateralRounding.CollateralRoundingBuilder.class, getRounding());
			processRosetta(path.newSubPath("bespokeTransferTiming"), processor, BespokeTransferTiming.BespokeTransferTimingBuilder.class, getBespokeTransferTiming());
			processRosetta(path.newSubPath("creditSupportObligationsVariationMargin"), processor, CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder.class, getCreditSupportObligationsVariationMargin());
			processRosetta(path.newSubPath("legacyThreshold"), processor, CSAThreshold.CSAThresholdBuilder.class, getLegacyThreshold());
			processRosetta(path.newSubPath("legacyMinimumTransferAmount"), processor, CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder.class, getLegacyMinimumTransferAmount());
			processRosetta(path.newSubPath("legacyDeliveryAmount"), processor, LegacyDeliveryAmount.LegacyDeliveryAmountBuilder.class, getLegacyDeliveryAmount());
			processRosetta(path.newSubPath("legacyReturnAmount"), processor, LegacyReturnAmount.LegacyReturnAmountBuilder.class, getLegacyReturnAmount());
			processRosetta(path.newSubPath("creditSupportAmount"), processor, CreditSupportAmount.CreditSupportAmountBuilder.class, getCreditSupportAmount());
			processRosetta(path.newSubPath("collateralTransferTiming"), processor, CollateralTransferTiming.CollateralTransferTimingBuilder.class, getCollateralTransferTiming());
		}
		

		CreditSupportObligations.CreditSupportObligationsBuilder prune();
	}

	/*********************** Immutable Implementation of CreditSupportObligations  ***********************/
	class CreditSupportObligationsImpl implements CreditSupportObligations {
		private final String deliveryAmount;
		private final String returnAmount;
		private final MarginApproach marginApproach;
		private final String otherEligibleSupport;
		private final Threshold threshold;
		private final MinimumTransferAmount minimumTransferAmount;
		private final CollateralRounding rounding;
		private final BespokeTransferTiming bespokeTransferTiming;
		private final CreditSupportObligationsVariationMargin creditSupportObligationsVariationMargin;
		private final List<? extends CSAThreshold> legacyThreshold;
		private final List<? extends CSAMinimumTransferAmount> legacyMinimumTransferAmount;
		private final LegacyDeliveryAmount legacyDeliveryAmount;
		private final LegacyReturnAmount legacyReturnAmount;
		private final CreditSupportAmount creditSupportAmount;
		private final CollateralTransferTiming collateralTransferTiming;
		
		protected CreditSupportObligationsImpl(CreditSupportObligations.CreditSupportObligationsBuilder builder) {
			this.deliveryAmount = builder.getDeliveryAmount();
			this.returnAmount = builder.getReturnAmount();
			this.marginApproach = ofNullable(builder.getMarginApproach()).map(f->f.build()).orElse(null);
			this.otherEligibleSupport = builder.getOtherEligibleSupport();
			this.threshold = ofNullable(builder.getThreshold()).map(f->f.build()).orElse(null);
			this.minimumTransferAmount = ofNullable(builder.getMinimumTransferAmount()).map(f->f.build()).orElse(null);
			this.rounding = ofNullable(builder.getRounding()).map(f->f.build()).orElse(null);
			this.bespokeTransferTiming = ofNullable(builder.getBespokeTransferTiming()).map(f->f.build()).orElse(null);
			this.creditSupportObligationsVariationMargin = ofNullable(builder.getCreditSupportObligationsVariationMargin()).map(f->f.build()).orElse(null);
			this.legacyThreshold = ofNullable(builder.getLegacyThreshold()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.legacyMinimumTransferAmount = ofNullable(builder.getLegacyMinimumTransferAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.legacyDeliveryAmount = ofNullable(builder.getLegacyDeliveryAmount()).map(f->f.build()).orElse(null);
			this.legacyReturnAmount = ofNullable(builder.getLegacyReturnAmount()).map(f->f.build()).orElse(null);
			this.creditSupportAmount = ofNullable(builder.getCreditSupportAmount()).map(f->f.build()).orElse(null);
			this.collateralTransferTiming = ofNullable(builder.getCollateralTransferTiming()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryAmount")
		public String getDeliveryAmount() {
			return deliveryAmount;
		}
		
		@Override
		@RosettaAttribute("returnAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("returnAmount")
		public String getReturnAmount() {
			return returnAmount;
		}
		
		@Override
		@RosettaAttribute("marginApproach")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marginApproach")
		public MarginApproach getMarginApproach() {
			return marginApproach;
		}
		
		@Override
		@RosettaAttribute("otherEligibleSupport")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherEligibleSupport")
		public String getOtherEligibleSupport() {
			return otherEligibleSupport;
		}
		
		@Override
		@RosettaAttribute("threshold")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("threshold")
		public Threshold getThreshold() {
			return threshold;
		}
		
		@Override
		@RosettaAttribute("minimumTransferAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("minimumTransferAmount")
		public MinimumTransferAmount getMinimumTransferAmount() {
			return minimumTransferAmount;
		}
		
		@Override
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rounding")
		public CollateralRounding getRounding() {
			return rounding;
		}
		
		@Override
		@RosettaAttribute("bespokeTransferTiming")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeTransferTiming")
		public BespokeTransferTiming getBespokeTransferTiming() {
			return bespokeTransferTiming;
		}
		
		@Override
		@RosettaAttribute("creditSupportObligationsVariationMargin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditSupportObligationsVariationMargin")
		public CreditSupportObligationsVariationMargin getCreditSupportObligationsVariationMargin() {
			return creditSupportObligationsVariationMargin;
		}
		
		@Override
		@RosettaAttribute("legacyThreshold")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("legacyThreshold")
		public List<? extends CSAThreshold> getLegacyThreshold() {
			return legacyThreshold;
		}
		
		@Override
		@RosettaAttribute("legacyMinimumTransferAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("legacyMinimumTransferAmount")
		public List<? extends CSAMinimumTransferAmount> getLegacyMinimumTransferAmount() {
			return legacyMinimumTransferAmount;
		}
		
		@Override
		@RosettaAttribute("legacyDeliveryAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legacyDeliveryAmount")
		public LegacyDeliveryAmount getLegacyDeliveryAmount() {
			return legacyDeliveryAmount;
		}
		
		@Override
		@RosettaAttribute("legacyReturnAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legacyReturnAmount")
		public LegacyReturnAmount getLegacyReturnAmount() {
			return legacyReturnAmount;
		}
		
		@Override
		@RosettaAttribute("creditSupportAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportAmount")
		public CreditSupportAmount getCreditSupportAmount() {
			return creditSupportAmount;
		}
		
		@Override
		@RosettaAttribute("collateralTransferTiming")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralTransferTiming")
		public CollateralTransferTiming getCollateralTransferTiming() {
			return collateralTransferTiming;
		}
		
		@Override
		public CreditSupportObligations build() {
			return this;
		}
		
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder toBuilder() {
			CreditSupportObligations.CreditSupportObligationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportObligations.CreditSupportObligationsBuilder builder) {
			ofNullable(getDeliveryAmount()).ifPresent(builder::setDeliveryAmount);
			ofNullable(getReturnAmount()).ifPresent(builder::setReturnAmount);
			ofNullable(getMarginApproach()).ifPresent(builder::setMarginApproach);
			ofNullable(getOtherEligibleSupport()).ifPresent(builder::setOtherEligibleSupport);
			ofNullable(getThreshold()).ifPresent(builder::setThreshold);
			ofNullable(getMinimumTransferAmount()).ifPresent(builder::setMinimumTransferAmount);
			ofNullable(getRounding()).ifPresent(builder::setRounding);
			ofNullable(getBespokeTransferTiming()).ifPresent(builder::setBespokeTransferTiming);
			ofNullable(getCreditSupportObligationsVariationMargin()).ifPresent(builder::setCreditSupportObligationsVariationMargin);
			ofNullable(getLegacyThreshold()).ifPresent(builder::setLegacyThreshold);
			ofNullable(getLegacyMinimumTransferAmount()).ifPresent(builder::setLegacyMinimumTransferAmount);
			ofNullable(getLegacyDeliveryAmount()).ifPresent(builder::setLegacyDeliveryAmount);
			ofNullable(getLegacyReturnAmount()).ifPresent(builder::setLegacyReturnAmount);
			ofNullable(getCreditSupportAmount()).ifPresent(builder::setCreditSupportAmount);
			ofNullable(getCollateralTransferTiming()).ifPresent(builder::setCollateralTransferTiming);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportObligations _that = getType().cast(o);
		
			if (!Objects.equals(deliveryAmount, _that.getDeliveryAmount())) return false;
			if (!Objects.equals(returnAmount, _that.getReturnAmount())) return false;
			if (!Objects.equals(marginApproach, _that.getMarginApproach())) return false;
			if (!Objects.equals(otherEligibleSupport, _that.getOtherEligibleSupport())) return false;
			if (!Objects.equals(threshold, _that.getThreshold())) return false;
			if (!Objects.equals(minimumTransferAmount, _that.getMinimumTransferAmount())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			if (!Objects.equals(bespokeTransferTiming, _that.getBespokeTransferTiming())) return false;
			if (!Objects.equals(creditSupportObligationsVariationMargin, _that.getCreditSupportObligationsVariationMargin())) return false;
			if (!ListEquals.listEquals(legacyThreshold, _that.getLegacyThreshold())) return false;
			if (!ListEquals.listEquals(legacyMinimumTransferAmount, _that.getLegacyMinimumTransferAmount())) return false;
			if (!Objects.equals(legacyDeliveryAmount, _that.getLegacyDeliveryAmount())) return false;
			if (!Objects.equals(legacyReturnAmount, _that.getLegacyReturnAmount())) return false;
			if (!Objects.equals(creditSupportAmount, _that.getCreditSupportAmount())) return false;
			if (!Objects.equals(collateralTransferTiming, _that.getCollateralTransferTiming())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryAmount != null ? deliveryAmount.hashCode() : 0);
			_result = 31 * _result + (returnAmount != null ? returnAmount.hashCode() : 0);
			_result = 31 * _result + (marginApproach != null ? marginApproach.hashCode() : 0);
			_result = 31 * _result + (otherEligibleSupport != null ? otherEligibleSupport.hashCode() : 0);
			_result = 31 * _result + (threshold != null ? threshold.hashCode() : 0);
			_result = 31 * _result + (minimumTransferAmount != null ? minimumTransferAmount.hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			_result = 31 * _result + (bespokeTransferTiming != null ? bespokeTransferTiming.hashCode() : 0);
			_result = 31 * _result + (creditSupportObligationsVariationMargin != null ? creditSupportObligationsVariationMargin.hashCode() : 0);
			_result = 31 * _result + (legacyThreshold != null ? legacyThreshold.hashCode() : 0);
			_result = 31 * _result + (legacyMinimumTransferAmount != null ? legacyMinimumTransferAmount.hashCode() : 0);
			_result = 31 * _result + (legacyDeliveryAmount != null ? legacyDeliveryAmount.hashCode() : 0);
			_result = 31 * _result + (legacyReturnAmount != null ? legacyReturnAmount.hashCode() : 0);
			_result = 31 * _result + (creditSupportAmount != null ? creditSupportAmount.hashCode() : 0);
			_result = 31 * _result + (collateralTransferTiming != null ? collateralTransferTiming.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportObligations {" +
				"deliveryAmount=" + this.deliveryAmount + ", " +
				"returnAmount=" + this.returnAmount + ", " +
				"marginApproach=" + this.marginApproach + ", " +
				"otherEligibleSupport=" + this.otherEligibleSupport + ", " +
				"threshold=" + this.threshold + ", " +
				"minimumTransferAmount=" + this.minimumTransferAmount + ", " +
				"rounding=" + this.rounding + ", " +
				"bespokeTransferTiming=" + this.bespokeTransferTiming + ", " +
				"creditSupportObligationsVariationMargin=" + this.creditSupportObligationsVariationMargin + ", " +
				"legacyThreshold=" + this.legacyThreshold + ", " +
				"legacyMinimumTransferAmount=" + this.legacyMinimumTransferAmount + ", " +
				"legacyDeliveryAmount=" + this.legacyDeliveryAmount + ", " +
				"legacyReturnAmount=" + this.legacyReturnAmount + ", " +
				"creditSupportAmount=" + this.creditSupportAmount + ", " +
				"collateralTransferTiming=" + this.collateralTransferTiming +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditSupportObligations  ***********************/
	class CreditSupportObligationsBuilderImpl implements CreditSupportObligations.CreditSupportObligationsBuilder {
	
		protected String deliveryAmount;
		protected String returnAmount;
		protected MarginApproach.MarginApproachBuilder marginApproach;
		protected String otherEligibleSupport;
		protected Threshold.ThresholdBuilder threshold;
		protected MinimumTransferAmount.MinimumTransferAmountBuilder minimumTransferAmount;
		protected CollateralRounding.CollateralRoundingBuilder rounding;
		protected BespokeTransferTiming.BespokeTransferTimingBuilder bespokeTransferTiming;
		protected CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder creditSupportObligationsVariationMargin;
		protected List<CSAThreshold.CSAThresholdBuilder> legacyThreshold = new ArrayList<>();
		protected List<CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder> legacyMinimumTransferAmount = new ArrayList<>();
		protected LegacyDeliveryAmount.LegacyDeliveryAmountBuilder legacyDeliveryAmount;
		protected LegacyReturnAmount.LegacyReturnAmountBuilder legacyReturnAmount;
		protected CreditSupportAmount.CreditSupportAmountBuilder creditSupportAmount;
		protected CollateralTransferTiming.CollateralTransferTimingBuilder collateralTransferTiming;
		
		@Override
		@RosettaAttribute("deliveryAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryAmount")
		public String getDeliveryAmount() {
			return deliveryAmount;
		}
		
		@Override
		@RosettaAttribute("returnAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("returnAmount")
		public String getReturnAmount() {
			return returnAmount;
		}
		
		@Override
		@RosettaAttribute("marginApproach")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marginApproach")
		public MarginApproach.MarginApproachBuilder getMarginApproach() {
			return marginApproach;
		}
		
		@Override
		public MarginApproach.MarginApproachBuilder getOrCreateMarginApproach() {
			MarginApproach.MarginApproachBuilder result;
			if (marginApproach!=null) {
				result = marginApproach;
			}
			else {
				result = marginApproach = MarginApproach.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherEligibleSupport")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherEligibleSupport")
		public String getOtherEligibleSupport() {
			return otherEligibleSupport;
		}
		
		@Override
		@RosettaAttribute("threshold")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("threshold")
		public Threshold.ThresholdBuilder getThreshold() {
			return threshold;
		}
		
		@Override
		public Threshold.ThresholdBuilder getOrCreateThreshold() {
			Threshold.ThresholdBuilder result;
			if (threshold!=null) {
				result = threshold;
			}
			else {
				result = threshold = Threshold.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minimumTransferAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("minimumTransferAmount")
		public MinimumTransferAmount.MinimumTransferAmountBuilder getMinimumTransferAmount() {
			return minimumTransferAmount;
		}
		
		@Override
		public MinimumTransferAmount.MinimumTransferAmountBuilder getOrCreateMinimumTransferAmount() {
			MinimumTransferAmount.MinimumTransferAmountBuilder result;
			if (minimumTransferAmount!=null) {
				result = minimumTransferAmount;
			}
			else {
				result = minimumTransferAmount = MinimumTransferAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rounding")
		public CollateralRounding.CollateralRoundingBuilder getRounding() {
			return rounding;
		}
		
		@Override
		public CollateralRounding.CollateralRoundingBuilder getOrCreateRounding() {
			CollateralRounding.CollateralRoundingBuilder result;
			if (rounding!=null) {
				result = rounding;
			}
			else {
				result = rounding = CollateralRounding.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bespokeTransferTiming")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeTransferTiming")
		public BespokeTransferTiming.BespokeTransferTimingBuilder getBespokeTransferTiming() {
			return bespokeTransferTiming;
		}
		
		@Override
		public BespokeTransferTiming.BespokeTransferTimingBuilder getOrCreateBespokeTransferTiming() {
			BespokeTransferTiming.BespokeTransferTimingBuilder result;
			if (bespokeTransferTiming!=null) {
				result = bespokeTransferTiming;
			}
			else {
				result = bespokeTransferTiming = BespokeTransferTiming.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditSupportObligationsVariationMargin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditSupportObligationsVariationMargin")
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder getCreditSupportObligationsVariationMargin() {
			return creditSupportObligationsVariationMargin;
		}
		
		@Override
		public CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder getOrCreateCreditSupportObligationsVariationMargin() {
			CreditSupportObligationsVariationMargin.CreditSupportObligationsVariationMarginBuilder result;
			if (creditSupportObligationsVariationMargin!=null) {
				result = creditSupportObligationsVariationMargin;
			}
			else {
				result = creditSupportObligationsVariationMargin = CreditSupportObligationsVariationMargin.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legacyThreshold")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("legacyThreshold")
		public List<? extends CSAThreshold.CSAThresholdBuilder> getLegacyThreshold() {
			return legacyThreshold;
		}
		
		@Override
		public CSAThreshold.CSAThresholdBuilder getOrCreateLegacyThreshold(int index) {
			if (legacyThreshold==null) {
				this.legacyThreshold = new ArrayList<>();
			}
			return getIndex(legacyThreshold, index, () -> {
						CSAThreshold.CSAThresholdBuilder newLegacyThreshold = CSAThreshold.builder();
						return newLegacyThreshold;
					});
		}
		
		@Override
		@RosettaAttribute("legacyMinimumTransferAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("legacyMinimumTransferAmount")
		public List<? extends CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder> getLegacyMinimumTransferAmount() {
			return legacyMinimumTransferAmount;
		}
		
		@Override
		public CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder getOrCreateLegacyMinimumTransferAmount(int index) {
			if (legacyMinimumTransferAmount==null) {
				this.legacyMinimumTransferAmount = new ArrayList<>();
			}
			return getIndex(legacyMinimumTransferAmount, index, () -> {
						CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder newLegacyMinimumTransferAmount = CSAMinimumTransferAmount.builder();
						return newLegacyMinimumTransferAmount;
					});
		}
		
		@Override
		@RosettaAttribute("legacyDeliveryAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legacyDeliveryAmount")
		public LegacyDeliveryAmount.LegacyDeliveryAmountBuilder getLegacyDeliveryAmount() {
			return legacyDeliveryAmount;
		}
		
		@Override
		public LegacyDeliveryAmount.LegacyDeliveryAmountBuilder getOrCreateLegacyDeliveryAmount() {
			LegacyDeliveryAmount.LegacyDeliveryAmountBuilder result;
			if (legacyDeliveryAmount!=null) {
				result = legacyDeliveryAmount;
			}
			else {
				result = legacyDeliveryAmount = LegacyDeliveryAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legacyReturnAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legacyReturnAmount")
		public LegacyReturnAmount.LegacyReturnAmountBuilder getLegacyReturnAmount() {
			return legacyReturnAmount;
		}
		
		@Override
		public LegacyReturnAmount.LegacyReturnAmountBuilder getOrCreateLegacyReturnAmount() {
			LegacyReturnAmount.LegacyReturnAmountBuilder result;
			if (legacyReturnAmount!=null) {
				result = legacyReturnAmount;
			}
			else {
				result = legacyReturnAmount = LegacyReturnAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditSupportAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportAmount")
		public CreditSupportAmount.CreditSupportAmountBuilder getCreditSupportAmount() {
			return creditSupportAmount;
		}
		
		@Override
		public CreditSupportAmount.CreditSupportAmountBuilder getOrCreateCreditSupportAmount() {
			CreditSupportAmount.CreditSupportAmountBuilder result;
			if (creditSupportAmount!=null) {
				result = creditSupportAmount;
			}
			else {
				result = creditSupportAmount = CreditSupportAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralTransferTiming")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralTransferTiming")
		public CollateralTransferTiming.CollateralTransferTimingBuilder getCollateralTransferTiming() {
			return collateralTransferTiming;
		}
		
		@Override
		public CollateralTransferTiming.CollateralTransferTimingBuilder getOrCreateCollateralTransferTiming() {
			CollateralTransferTiming.CollateralTransferTimingBuilder result;
			if (collateralTransferTiming!=null) {
				result = collateralTransferTiming;
			}
			else {
				result = collateralTransferTiming = CollateralTransferTiming.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("deliveryAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryAmount")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setDeliveryAmount(String _deliveryAmount) {
			this.deliveryAmount = _deliveryAmount == null ? null : _deliveryAmount;
			return this;
		}
		
		@RosettaAttribute("returnAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("returnAmount")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setReturnAmount(String _returnAmount) {
			this.returnAmount = _returnAmount == null ? null : _returnAmount;
			return this;
		}
		
		@RosettaAttribute("marginApproach")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marginApproach")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setMarginApproach(MarginApproach _marginApproach) {
			this.marginApproach = _marginApproach == null ? null : _marginApproach.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherEligibleSupport")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherEligibleSupport")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setOtherEligibleSupport(String _otherEligibleSupport) {
			this.otherEligibleSupport = _otherEligibleSupport == null ? null : _otherEligibleSupport;
			return this;
		}
		
		@RosettaAttribute("threshold")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("threshold")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setThreshold(Threshold _threshold) {
			this.threshold = _threshold == null ? null : _threshold.toBuilder();
			return this;
		}
		
		@RosettaAttribute("minimumTransferAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("minimumTransferAmount")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setMinimumTransferAmount(MinimumTransferAmount _minimumTransferAmount) {
			this.minimumTransferAmount = _minimumTransferAmount == null ? null : _minimumTransferAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rounding")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setRounding(CollateralRounding _rounding) {
			this.rounding = _rounding == null ? null : _rounding.toBuilder();
			return this;
		}
		
		@RosettaAttribute("bespokeTransferTiming")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bespokeTransferTiming")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setBespokeTransferTiming(BespokeTransferTiming _bespokeTransferTiming) {
			this.bespokeTransferTiming = _bespokeTransferTiming == null ? null : _bespokeTransferTiming.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditSupportObligationsVariationMargin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditSupportObligationsVariationMargin")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setCreditSupportObligationsVariationMargin(CreditSupportObligationsVariationMargin _creditSupportObligationsVariationMargin) {
			this.creditSupportObligationsVariationMargin = _creditSupportObligationsVariationMargin == null ? null : _creditSupportObligationsVariationMargin.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legacyThreshold")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legacyThreshold")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder addLegacyThreshold(CSAThreshold _legacyThreshold) {
			if (_legacyThreshold != null) {
				this.legacyThreshold.add(_legacyThreshold.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder addLegacyThreshold(CSAThreshold _legacyThreshold, int idx) {
			getIndex(this.legacyThreshold, idx, () -> _legacyThreshold.toBuilder());
			return this;
		}
		
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder addLegacyThreshold(List<? extends CSAThreshold> legacyThresholds) {
			if (legacyThresholds != null) {
				for (final CSAThreshold toAdd : legacyThresholds) {
					this.legacyThreshold.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("legacyThreshold")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("legacyThreshold")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setLegacyThreshold(List<? extends CSAThreshold> legacyThresholds) {
			if (legacyThresholds == null) {
				this.legacyThreshold = new ArrayList<>();
			} else {
				this.legacyThreshold = legacyThresholds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("legacyMinimumTransferAmount")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legacyMinimumTransferAmount")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder addLegacyMinimumTransferAmount(CSAMinimumTransferAmount _legacyMinimumTransferAmount) {
			if (_legacyMinimumTransferAmount != null) {
				this.legacyMinimumTransferAmount.add(_legacyMinimumTransferAmount.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder addLegacyMinimumTransferAmount(CSAMinimumTransferAmount _legacyMinimumTransferAmount, int idx) {
			getIndex(this.legacyMinimumTransferAmount, idx, () -> _legacyMinimumTransferAmount.toBuilder());
			return this;
		}
		
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder addLegacyMinimumTransferAmount(List<? extends CSAMinimumTransferAmount> legacyMinimumTransferAmounts) {
			if (legacyMinimumTransferAmounts != null) {
				for (final CSAMinimumTransferAmount toAdd : legacyMinimumTransferAmounts) {
					this.legacyMinimumTransferAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("legacyMinimumTransferAmount")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("legacyMinimumTransferAmount")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setLegacyMinimumTransferAmount(List<? extends CSAMinimumTransferAmount> legacyMinimumTransferAmounts) {
			if (legacyMinimumTransferAmounts == null) {
				this.legacyMinimumTransferAmount = new ArrayList<>();
			} else {
				this.legacyMinimumTransferAmount = legacyMinimumTransferAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("legacyDeliveryAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("legacyDeliveryAmount")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setLegacyDeliveryAmount(LegacyDeliveryAmount _legacyDeliveryAmount) {
			this.legacyDeliveryAmount = _legacyDeliveryAmount == null ? null : _legacyDeliveryAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legacyReturnAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("legacyReturnAmount")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setLegacyReturnAmount(LegacyReturnAmount _legacyReturnAmount) {
			this.legacyReturnAmount = _legacyReturnAmount == null ? null : _legacyReturnAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditSupportAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditSupportAmount")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setCreditSupportAmount(CreditSupportAmount _creditSupportAmount) {
			this.creditSupportAmount = _creditSupportAmount == null ? null : _creditSupportAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralTransferTiming")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralTransferTiming")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder setCollateralTransferTiming(CollateralTransferTiming _collateralTransferTiming) {
			this.collateralTransferTiming = _collateralTransferTiming == null ? null : _collateralTransferTiming.toBuilder();
			return this;
		}
		
		@Override
		public CreditSupportObligations build() {
			return new CreditSupportObligations.CreditSupportObligationsImpl(this);
		}
		
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder prune() {
			if (marginApproach!=null && !marginApproach.prune().hasData()) marginApproach = null;
			if (threshold!=null && !threshold.prune().hasData()) threshold = null;
			if (minimumTransferAmount!=null && !minimumTransferAmount.prune().hasData()) minimumTransferAmount = null;
			if (rounding!=null && !rounding.prune().hasData()) rounding = null;
			if (bespokeTransferTiming!=null && !bespokeTransferTiming.prune().hasData()) bespokeTransferTiming = null;
			if (creditSupportObligationsVariationMargin!=null && !creditSupportObligationsVariationMargin.prune().hasData()) creditSupportObligationsVariationMargin = null;
			legacyThreshold = legacyThreshold.stream().filter(b->b!=null).<CSAThreshold.CSAThresholdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			legacyMinimumTransferAmount = legacyMinimumTransferAmount.stream().filter(b->b!=null).<CSAMinimumTransferAmount.CSAMinimumTransferAmountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (legacyDeliveryAmount!=null && !legacyDeliveryAmount.prune().hasData()) legacyDeliveryAmount = null;
			if (legacyReturnAmount!=null && !legacyReturnAmount.prune().hasData()) legacyReturnAmount = null;
			if (creditSupportAmount!=null && !creditSupportAmount.prune().hasData()) creditSupportAmount = null;
			if (collateralTransferTiming!=null && !collateralTransferTiming.prune().hasData()) collateralTransferTiming = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryAmount()!=null) return true;
			if (getReturnAmount()!=null) return true;
			if (getMarginApproach()!=null && getMarginApproach().hasData()) return true;
			if (getOtherEligibleSupport()!=null) return true;
			if (getThreshold()!=null && getThreshold().hasData()) return true;
			if (getMinimumTransferAmount()!=null && getMinimumTransferAmount().hasData()) return true;
			if (getRounding()!=null && getRounding().hasData()) return true;
			if (getBespokeTransferTiming()!=null && getBespokeTransferTiming().hasData()) return true;
			if (getCreditSupportObligationsVariationMargin()!=null && getCreditSupportObligationsVariationMargin().hasData()) return true;
			if (getLegacyThreshold()!=null && getLegacyThreshold().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLegacyMinimumTransferAmount()!=null && getLegacyMinimumTransferAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLegacyDeliveryAmount()!=null && getLegacyDeliveryAmount().hasData()) return true;
			if (getLegacyReturnAmount()!=null && getLegacyReturnAmount().hasData()) return true;
			if (getCreditSupportAmount()!=null && getCreditSupportAmount().hasData()) return true;
			if (getCollateralTransferTiming()!=null && getCollateralTransferTiming().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportObligations.CreditSupportObligationsBuilder o = (CreditSupportObligations.CreditSupportObligationsBuilder) other;
			
			merger.mergeRosetta(getMarginApproach(), o.getMarginApproach(), this::setMarginApproach);
			merger.mergeRosetta(getThreshold(), o.getThreshold(), this::setThreshold);
			merger.mergeRosetta(getMinimumTransferAmount(), o.getMinimumTransferAmount(), this::setMinimumTransferAmount);
			merger.mergeRosetta(getRounding(), o.getRounding(), this::setRounding);
			merger.mergeRosetta(getBespokeTransferTiming(), o.getBespokeTransferTiming(), this::setBespokeTransferTiming);
			merger.mergeRosetta(getCreditSupportObligationsVariationMargin(), o.getCreditSupportObligationsVariationMargin(), this::setCreditSupportObligationsVariationMargin);
			merger.mergeRosetta(getLegacyThreshold(), o.getLegacyThreshold(), this::getOrCreateLegacyThreshold);
			merger.mergeRosetta(getLegacyMinimumTransferAmount(), o.getLegacyMinimumTransferAmount(), this::getOrCreateLegacyMinimumTransferAmount);
			merger.mergeRosetta(getLegacyDeliveryAmount(), o.getLegacyDeliveryAmount(), this::setLegacyDeliveryAmount);
			merger.mergeRosetta(getLegacyReturnAmount(), o.getLegacyReturnAmount(), this::setLegacyReturnAmount);
			merger.mergeRosetta(getCreditSupportAmount(), o.getCreditSupportAmount(), this::setCreditSupportAmount);
			merger.mergeRosetta(getCollateralTransferTiming(), o.getCollateralTransferTiming(), this::setCollateralTransferTiming);
			
			merger.mergeBasic(getDeliveryAmount(), o.getDeliveryAmount(), this::setDeliveryAmount);
			merger.mergeBasic(getReturnAmount(), o.getReturnAmount(), this::setReturnAmount);
			merger.mergeBasic(getOtherEligibleSupport(), o.getOtherEligibleSupport(), this::setOtherEligibleSupport);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportObligations _that = getType().cast(o);
		
			if (!Objects.equals(deliveryAmount, _that.getDeliveryAmount())) return false;
			if (!Objects.equals(returnAmount, _that.getReturnAmount())) return false;
			if (!Objects.equals(marginApproach, _that.getMarginApproach())) return false;
			if (!Objects.equals(otherEligibleSupport, _that.getOtherEligibleSupport())) return false;
			if (!Objects.equals(threshold, _that.getThreshold())) return false;
			if (!Objects.equals(minimumTransferAmount, _that.getMinimumTransferAmount())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			if (!Objects.equals(bespokeTransferTiming, _that.getBespokeTransferTiming())) return false;
			if (!Objects.equals(creditSupportObligationsVariationMargin, _that.getCreditSupportObligationsVariationMargin())) return false;
			if (!ListEquals.listEquals(legacyThreshold, _that.getLegacyThreshold())) return false;
			if (!ListEquals.listEquals(legacyMinimumTransferAmount, _that.getLegacyMinimumTransferAmount())) return false;
			if (!Objects.equals(legacyDeliveryAmount, _that.getLegacyDeliveryAmount())) return false;
			if (!Objects.equals(legacyReturnAmount, _that.getLegacyReturnAmount())) return false;
			if (!Objects.equals(creditSupportAmount, _that.getCreditSupportAmount())) return false;
			if (!Objects.equals(collateralTransferTiming, _that.getCollateralTransferTiming())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryAmount != null ? deliveryAmount.hashCode() : 0);
			_result = 31 * _result + (returnAmount != null ? returnAmount.hashCode() : 0);
			_result = 31 * _result + (marginApproach != null ? marginApproach.hashCode() : 0);
			_result = 31 * _result + (otherEligibleSupport != null ? otherEligibleSupport.hashCode() : 0);
			_result = 31 * _result + (threshold != null ? threshold.hashCode() : 0);
			_result = 31 * _result + (minimumTransferAmount != null ? minimumTransferAmount.hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			_result = 31 * _result + (bespokeTransferTiming != null ? bespokeTransferTiming.hashCode() : 0);
			_result = 31 * _result + (creditSupportObligationsVariationMargin != null ? creditSupportObligationsVariationMargin.hashCode() : 0);
			_result = 31 * _result + (legacyThreshold != null ? legacyThreshold.hashCode() : 0);
			_result = 31 * _result + (legacyMinimumTransferAmount != null ? legacyMinimumTransferAmount.hashCode() : 0);
			_result = 31 * _result + (legacyDeliveryAmount != null ? legacyDeliveryAmount.hashCode() : 0);
			_result = 31 * _result + (legacyReturnAmount != null ? legacyReturnAmount.hashCode() : 0);
			_result = 31 * _result + (creditSupportAmount != null ? creditSupportAmount.hashCode() : 0);
			_result = 31 * _result + (collateralTransferTiming != null ? collateralTransferTiming.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportObligationsBuilder {" +
				"deliveryAmount=" + this.deliveryAmount + ", " +
				"returnAmount=" + this.returnAmount + ", " +
				"marginApproach=" + this.marginApproach + ", " +
				"otherEligibleSupport=" + this.otherEligibleSupport + ", " +
				"threshold=" + this.threshold + ", " +
				"minimumTransferAmount=" + this.minimumTransferAmount + ", " +
				"rounding=" + this.rounding + ", " +
				"bespokeTransferTiming=" + this.bespokeTransferTiming + ", " +
				"creditSupportObligationsVariationMargin=" + this.creditSupportObligationsVariationMargin + ", " +
				"legacyThreshold=" + this.legacyThreshold + ", " +
				"legacyMinimumTransferAmount=" + this.legacyMinimumTransferAmount + ", " +
				"legacyDeliveryAmount=" + this.legacyDeliveryAmount + ", " +
				"legacyReturnAmount=" + this.legacyReturnAmount + ", " +
				"creditSupportAmount=" + this.creditSupportAmount + ", " +
				"collateralTransferTiming=" + this.collateralTransferTiming +
			'}';
		}
	}
}
