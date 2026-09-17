package cdm.legaldocumentation.transaction.additionalterms;

import cdm.legaldocumentation.transaction.Clause;
import cdm.legaldocumentation.transaction.additionalterms.meta.FxDisruptionEventsMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Additional Provisions for a Confirmation of an FX or Currency Option Transaction
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
 * exhibit "II-E"
 *
 * Provision 
 *
 */
@RosettaDataType(value="FxDisruptionEvents", builder=FxDisruptionEvents.FxDisruptionEventsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FxDisruptionEvents", model="cdm", builder=FxDisruptionEvents.FxDisruptionEventsBuilderImpl.class, version="6.23.0")
public interface FxDisruptionEvents extends RosettaModelObject {

	FxDisruptionEventsMeta metaData = new FxDisruptionEventsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(c).(i)"
	 *
	 * Provision 
	 *
	 */
	FxIllegalityOrImpossibilityEnum getIllegalityOrImpossibility();
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(c).(ii)"
	 *
	 * Provision 
	 *
	 */
	FxForceMajeureOrActOfSStateEnum getForceMajeureOrActOfSState();
	/**
	 * Additional Provisions for a Confirmation of an FX or Currency Option Transaction.
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 *
	 * Provision 
	 *
	 */
	EventCurrency getEventCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(d).(xi)"
	 *
	 * Provision 
	 *
	 */
	FxPriceSourceDisruption getPriceSourceDisruption();
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(d).(i)"
	 *
	 * Provision 
	 *
	 */
	FxBenchmarkObligationDefault getBenchmarkObligationDefault();
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(d).(ii)"
	 *
	 * Provision 
	 *
	 */
	FxDualExchangeRate getDualExchangeRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(d).(vii)"
	 *
	 * Provision 
	 *
	 */
	FxInconvertibilityOrNonTransferability getInconvertibilityOrNonTransferability();
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(d).(v)"
	 *
	 * Provision 
	 *
	 */
	GovernmentalAuthorityDefault getGovernmentalAuthorityDefault();
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(d).(vi)"
	 *
	 * Provision 
	 *
	 */
	Illiquidity getIlliquidity();
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(d).(viii)"
	 *
	 * Provision 
	 *
	 */
	MaterialChangeInCircumstance getMaterialChangeInCircumstance();
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(d).(ix)"
	 *
	 * Provision 
	 *
	 */
	Nationalization getNationalization();
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(d).(x)"
	 *
	 * Provision 
	 *
	 */
	PriceMateriality getPriceMateriality();
	/**
	 * Where parties may optionaly describe any extra bespoke agreements about fallback procedure attached to a particular determination role.
	 */
	Clause getFallbackLanguageBespokeTerms();

	/*********************** Build Methods  ***********************/
	FxDisruptionEvents build();
	
	FxDisruptionEvents.FxDisruptionEventsBuilder toBuilder();
	
	static FxDisruptionEvents.FxDisruptionEventsBuilder builder() {
		return new FxDisruptionEvents.FxDisruptionEventsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDisruptionEvents> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxDisruptionEvents> getType() {
		return FxDisruptionEvents.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("illegalityOrImpossibility"), FxIllegalityOrImpossibilityEnum.class, getIllegalityOrImpossibility(), this);
		processor.processBasic(path.newSubPath("forceMajeureOrActOfSState"), FxForceMajeureOrActOfSStateEnum.class, getForceMajeureOrActOfSState(), this);
		processRosetta(path.newSubPath("eventCurrency"), processor, EventCurrency.class, getEventCurrency());
		processRosetta(path.newSubPath("priceSourceDisruption"), processor, FxPriceSourceDisruption.class, getPriceSourceDisruption());
		processRosetta(path.newSubPath("benchmarkObligationDefault"), processor, FxBenchmarkObligationDefault.class, getBenchmarkObligationDefault());
		processRosetta(path.newSubPath("dualExchangeRate"), processor, FxDualExchangeRate.class, getDualExchangeRate());
		processRosetta(path.newSubPath("inconvertibilityOrNonTransferability"), processor, FxInconvertibilityOrNonTransferability.class, getInconvertibilityOrNonTransferability());
		processRosetta(path.newSubPath("governmentalAuthorityDefault"), processor, GovernmentalAuthorityDefault.class, getGovernmentalAuthorityDefault());
		processRosetta(path.newSubPath("illiquidity"), processor, Illiquidity.class, getIlliquidity());
		processRosetta(path.newSubPath("materialChangeInCircumstance"), processor, MaterialChangeInCircumstance.class, getMaterialChangeInCircumstance());
		processRosetta(path.newSubPath("nationalization"), processor, Nationalization.class, getNationalization());
		processRosetta(path.newSubPath("priceMateriality"), processor, PriceMateriality.class, getPriceMateriality());
		processRosetta(path.newSubPath("fallbackLanguageBespokeTerms"), processor, Clause.class, getFallbackLanguageBespokeTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDisruptionEventsBuilder extends FxDisruptionEvents, RosettaModelObjectBuilder {
		EventCurrency.EventCurrencyBuilder getOrCreateEventCurrency();
		@Override
		EventCurrency.EventCurrencyBuilder getEventCurrency();
		FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder getOrCreatePriceSourceDisruption();
		@Override
		FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder getPriceSourceDisruption();
		FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder getOrCreateBenchmarkObligationDefault();
		@Override
		FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder getBenchmarkObligationDefault();
		FxDualExchangeRate.FxDualExchangeRateBuilder getOrCreateDualExchangeRate();
		@Override
		FxDualExchangeRate.FxDualExchangeRateBuilder getDualExchangeRate();
		FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder getOrCreateInconvertibilityOrNonTransferability();
		@Override
		FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder getInconvertibilityOrNonTransferability();
		GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder getOrCreateGovernmentalAuthorityDefault();
		@Override
		GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder getGovernmentalAuthorityDefault();
		Illiquidity.IlliquidityBuilder getOrCreateIlliquidity();
		@Override
		Illiquidity.IlliquidityBuilder getIlliquidity();
		MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder getOrCreateMaterialChangeInCircumstance();
		@Override
		MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder getMaterialChangeInCircumstance();
		Nationalization.NationalizationBuilder getOrCreateNationalization();
		@Override
		Nationalization.NationalizationBuilder getNationalization();
		PriceMateriality.PriceMaterialityBuilder getOrCreatePriceMateriality();
		@Override
		PriceMateriality.PriceMaterialityBuilder getPriceMateriality();
		Clause.ClauseBuilder getOrCreateFallbackLanguageBespokeTerms();
		@Override
		Clause.ClauseBuilder getFallbackLanguageBespokeTerms();
		FxDisruptionEvents.FxDisruptionEventsBuilder setIllegalityOrImpossibility(FxIllegalityOrImpossibilityEnum illegalityOrImpossibility);
		FxDisruptionEvents.FxDisruptionEventsBuilder setForceMajeureOrActOfSState(FxForceMajeureOrActOfSStateEnum forceMajeureOrActOfSState);
		FxDisruptionEvents.FxDisruptionEventsBuilder setEventCurrency(EventCurrency eventCurrency);
		FxDisruptionEvents.FxDisruptionEventsBuilder setPriceSourceDisruption(FxPriceSourceDisruption priceSourceDisruption);
		FxDisruptionEvents.FxDisruptionEventsBuilder setBenchmarkObligationDefault(FxBenchmarkObligationDefault benchmarkObligationDefault);
		FxDisruptionEvents.FxDisruptionEventsBuilder setDualExchangeRate(FxDualExchangeRate dualExchangeRate);
		FxDisruptionEvents.FxDisruptionEventsBuilder setInconvertibilityOrNonTransferability(FxInconvertibilityOrNonTransferability inconvertibilityOrNonTransferability);
		FxDisruptionEvents.FxDisruptionEventsBuilder setGovernmentalAuthorityDefault(GovernmentalAuthorityDefault governmentalAuthorityDefault);
		FxDisruptionEvents.FxDisruptionEventsBuilder setIlliquidity(Illiquidity illiquidity);
		FxDisruptionEvents.FxDisruptionEventsBuilder setMaterialChangeInCircumstance(MaterialChangeInCircumstance materialChangeInCircumstance);
		FxDisruptionEvents.FxDisruptionEventsBuilder setNationalization(Nationalization nationalization);
		FxDisruptionEvents.FxDisruptionEventsBuilder setPriceMateriality(PriceMateriality priceMateriality);
		FxDisruptionEvents.FxDisruptionEventsBuilder setFallbackLanguageBespokeTerms(Clause fallbackLanguageBespokeTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("illegalityOrImpossibility"), FxIllegalityOrImpossibilityEnum.class, getIllegalityOrImpossibility(), this);
			processor.processBasic(path.newSubPath("forceMajeureOrActOfSState"), FxForceMajeureOrActOfSStateEnum.class, getForceMajeureOrActOfSState(), this);
			processRosetta(path.newSubPath("eventCurrency"), processor, EventCurrency.EventCurrencyBuilder.class, getEventCurrency());
			processRosetta(path.newSubPath("priceSourceDisruption"), processor, FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder.class, getPriceSourceDisruption());
			processRosetta(path.newSubPath("benchmarkObligationDefault"), processor, FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder.class, getBenchmarkObligationDefault());
			processRosetta(path.newSubPath("dualExchangeRate"), processor, FxDualExchangeRate.FxDualExchangeRateBuilder.class, getDualExchangeRate());
			processRosetta(path.newSubPath("inconvertibilityOrNonTransferability"), processor, FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder.class, getInconvertibilityOrNonTransferability());
			processRosetta(path.newSubPath("governmentalAuthorityDefault"), processor, GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder.class, getGovernmentalAuthorityDefault());
			processRosetta(path.newSubPath("illiquidity"), processor, Illiquidity.IlliquidityBuilder.class, getIlliquidity());
			processRosetta(path.newSubPath("materialChangeInCircumstance"), processor, MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder.class, getMaterialChangeInCircumstance());
			processRosetta(path.newSubPath("nationalization"), processor, Nationalization.NationalizationBuilder.class, getNationalization());
			processRosetta(path.newSubPath("priceMateriality"), processor, PriceMateriality.PriceMaterialityBuilder.class, getPriceMateriality());
			processRosetta(path.newSubPath("fallbackLanguageBespokeTerms"), processor, Clause.ClauseBuilder.class, getFallbackLanguageBespokeTerms());
		}
		

		FxDisruptionEvents.FxDisruptionEventsBuilder prune();
	}

	/*********************** Immutable Implementation of FxDisruptionEvents  ***********************/
	class FxDisruptionEventsImpl implements FxDisruptionEvents {
		private final FxIllegalityOrImpossibilityEnum illegalityOrImpossibility;
		private final FxForceMajeureOrActOfSStateEnum forceMajeureOrActOfSState;
		private final EventCurrency eventCurrency;
		private final FxPriceSourceDisruption priceSourceDisruption;
		private final FxBenchmarkObligationDefault benchmarkObligationDefault;
		private final FxDualExchangeRate dualExchangeRate;
		private final FxInconvertibilityOrNonTransferability inconvertibilityOrNonTransferability;
		private final GovernmentalAuthorityDefault governmentalAuthorityDefault;
		private final Illiquidity illiquidity;
		private final MaterialChangeInCircumstance materialChangeInCircumstance;
		private final Nationalization nationalization;
		private final PriceMateriality priceMateriality;
		private final Clause fallbackLanguageBespokeTerms;
		
		protected FxDisruptionEventsImpl(FxDisruptionEvents.FxDisruptionEventsBuilder builder) {
			this.illegalityOrImpossibility = builder.getIllegalityOrImpossibility();
			this.forceMajeureOrActOfSState = builder.getForceMajeureOrActOfSState();
			this.eventCurrency = ofNullable(builder.getEventCurrency()).map(f->f.build()).orElse(null);
			this.priceSourceDisruption = ofNullable(builder.getPriceSourceDisruption()).map(f->f.build()).orElse(null);
			this.benchmarkObligationDefault = ofNullable(builder.getBenchmarkObligationDefault()).map(f->f.build()).orElse(null);
			this.dualExchangeRate = ofNullable(builder.getDualExchangeRate()).map(f->f.build()).orElse(null);
			this.inconvertibilityOrNonTransferability = ofNullable(builder.getInconvertibilityOrNonTransferability()).map(f->f.build()).orElse(null);
			this.governmentalAuthorityDefault = ofNullable(builder.getGovernmentalAuthorityDefault()).map(f->f.build()).orElse(null);
			this.illiquidity = ofNullable(builder.getIlliquidity()).map(f->f.build()).orElse(null);
			this.materialChangeInCircumstance = ofNullable(builder.getMaterialChangeInCircumstance()).map(f->f.build()).orElse(null);
			this.nationalization = ofNullable(builder.getNationalization()).map(f->f.build()).orElse(null);
			this.priceMateriality = ofNullable(builder.getPriceMateriality()).map(f->f.build()).orElse(null);
			this.fallbackLanguageBespokeTerms = ofNullable(builder.getFallbackLanguageBespokeTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("illegalityOrImpossibility")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("illegalityOrImpossibility")
		public FxIllegalityOrImpossibilityEnum getIllegalityOrImpossibility() {
			return illegalityOrImpossibility;
		}
		
		@Override
		@RosettaAttribute("forceMajeureOrActOfSState")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forceMajeureOrActOfSState")
		public FxForceMajeureOrActOfSStateEnum getForceMajeureOrActOfSState() {
			return forceMajeureOrActOfSState;
		}
		
		@Override
		@RosettaAttribute("eventCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventCurrency")
		public EventCurrency getEventCurrency() {
			return eventCurrency;
		}
		
		@Override
		@RosettaAttribute("priceSourceDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceSourceDisruption")
		public FxPriceSourceDisruption getPriceSourceDisruption() {
			return priceSourceDisruption;
		}
		
		@Override
		@RosettaAttribute("benchmarkObligationDefault")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("benchmarkObligationDefault")
		public FxBenchmarkObligationDefault getBenchmarkObligationDefault() {
			return benchmarkObligationDefault;
		}
		
		@Override
		@RosettaAttribute("dualExchangeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dualExchangeRate")
		public FxDualExchangeRate getDualExchangeRate() {
			return dualExchangeRate;
		}
		
		@Override
		@RosettaAttribute("inconvertibilityOrNonTransferability")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inconvertibilityOrNonTransferability")
		public FxInconvertibilityOrNonTransferability getInconvertibilityOrNonTransferability() {
			return inconvertibilityOrNonTransferability;
		}
		
		@Override
		@RosettaAttribute("governmentalAuthorityDefault")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("governmentalAuthorityDefault")
		public GovernmentalAuthorityDefault getGovernmentalAuthorityDefault() {
			return governmentalAuthorityDefault;
		}
		
		@Override
		@RosettaAttribute("illiquidity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("illiquidity")
		public Illiquidity getIlliquidity() {
			return illiquidity;
		}
		
		@Override
		@RosettaAttribute("materialChangeInCircumstance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("materialChangeInCircumstance")
		public MaterialChangeInCircumstance getMaterialChangeInCircumstance() {
			return materialChangeInCircumstance;
		}
		
		@Override
		@RosettaAttribute("nationalization")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nationalization")
		public Nationalization getNationalization() {
			return nationalization;
		}
		
		@Override
		@RosettaAttribute("priceMateriality")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceMateriality")
		public PriceMateriality getPriceMateriality() {
			return priceMateriality;
		}
		
		@Override
		@RosettaAttribute("fallbackLanguageBespokeTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackLanguageBespokeTerms")
		public Clause getFallbackLanguageBespokeTerms() {
			return fallbackLanguageBespokeTerms;
		}
		
		@Override
		public FxDisruptionEvents build() {
			return this;
		}
		
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder toBuilder() {
			FxDisruptionEvents.FxDisruptionEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDisruptionEvents.FxDisruptionEventsBuilder builder) {
			ofNullable(getIllegalityOrImpossibility()).ifPresent(builder::setIllegalityOrImpossibility);
			ofNullable(getForceMajeureOrActOfSState()).ifPresent(builder::setForceMajeureOrActOfSState);
			ofNullable(getEventCurrency()).ifPresent(builder::setEventCurrency);
			ofNullable(getPriceSourceDisruption()).ifPresent(builder::setPriceSourceDisruption);
			ofNullable(getBenchmarkObligationDefault()).ifPresent(builder::setBenchmarkObligationDefault);
			ofNullable(getDualExchangeRate()).ifPresent(builder::setDualExchangeRate);
			ofNullable(getInconvertibilityOrNonTransferability()).ifPresent(builder::setInconvertibilityOrNonTransferability);
			ofNullable(getGovernmentalAuthorityDefault()).ifPresent(builder::setGovernmentalAuthorityDefault);
			ofNullable(getIlliquidity()).ifPresent(builder::setIlliquidity);
			ofNullable(getMaterialChangeInCircumstance()).ifPresent(builder::setMaterialChangeInCircumstance);
			ofNullable(getNationalization()).ifPresent(builder::setNationalization);
			ofNullable(getPriceMateriality()).ifPresent(builder::setPriceMateriality);
			ofNullable(getFallbackLanguageBespokeTerms()).ifPresent(builder::setFallbackLanguageBespokeTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDisruptionEvents _that = getType().cast(o);
		
			if (!Objects.equals(illegalityOrImpossibility, _that.getIllegalityOrImpossibility())) return false;
			if (!Objects.equals(forceMajeureOrActOfSState, _that.getForceMajeureOrActOfSState())) return false;
			if (!Objects.equals(eventCurrency, _that.getEventCurrency())) return false;
			if (!Objects.equals(priceSourceDisruption, _that.getPriceSourceDisruption())) return false;
			if (!Objects.equals(benchmarkObligationDefault, _that.getBenchmarkObligationDefault())) return false;
			if (!Objects.equals(dualExchangeRate, _that.getDualExchangeRate())) return false;
			if (!Objects.equals(inconvertibilityOrNonTransferability, _that.getInconvertibilityOrNonTransferability())) return false;
			if (!Objects.equals(governmentalAuthorityDefault, _that.getGovernmentalAuthorityDefault())) return false;
			if (!Objects.equals(illiquidity, _that.getIlliquidity())) return false;
			if (!Objects.equals(materialChangeInCircumstance, _that.getMaterialChangeInCircumstance())) return false;
			if (!Objects.equals(nationalization, _that.getNationalization())) return false;
			if (!Objects.equals(priceMateriality, _that.getPriceMateriality())) return false;
			if (!Objects.equals(fallbackLanguageBespokeTerms, _that.getFallbackLanguageBespokeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (illegalityOrImpossibility != null ? illegalityOrImpossibility.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (forceMajeureOrActOfSState != null ? forceMajeureOrActOfSState.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventCurrency != null ? eventCurrency.hashCode() : 0);
			_result = 31 * _result + (priceSourceDisruption != null ? priceSourceDisruption.hashCode() : 0);
			_result = 31 * _result + (benchmarkObligationDefault != null ? benchmarkObligationDefault.hashCode() : 0);
			_result = 31 * _result + (dualExchangeRate != null ? dualExchangeRate.hashCode() : 0);
			_result = 31 * _result + (inconvertibilityOrNonTransferability != null ? inconvertibilityOrNonTransferability.hashCode() : 0);
			_result = 31 * _result + (governmentalAuthorityDefault != null ? governmentalAuthorityDefault.hashCode() : 0);
			_result = 31 * _result + (illiquidity != null ? illiquidity.hashCode() : 0);
			_result = 31 * _result + (materialChangeInCircumstance != null ? materialChangeInCircumstance.hashCode() : 0);
			_result = 31 * _result + (nationalization != null ? nationalization.hashCode() : 0);
			_result = 31 * _result + (priceMateriality != null ? priceMateriality.hashCode() : 0);
			_result = 31 * _result + (fallbackLanguageBespokeTerms != null ? fallbackLanguageBespokeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruptionEvents {" +
				"illegalityOrImpossibility=" + this.illegalityOrImpossibility + ", " +
				"forceMajeureOrActOfSState=" + this.forceMajeureOrActOfSState + ", " +
				"eventCurrency=" + this.eventCurrency + ", " +
				"priceSourceDisruption=" + this.priceSourceDisruption + ", " +
				"benchmarkObligationDefault=" + this.benchmarkObligationDefault + ", " +
				"dualExchangeRate=" + this.dualExchangeRate + ", " +
				"inconvertibilityOrNonTransferability=" + this.inconvertibilityOrNonTransferability + ", " +
				"governmentalAuthorityDefault=" + this.governmentalAuthorityDefault + ", " +
				"illiquidity=" + this.illiquidity + ", " +
				"materialChangeInCircumstance=" + this.materialChangeInCircumstance + ", " +
				"nationalization=" + this.nationalization + ", " +
				"priceMateriality=" + this.priceMateriality + ", " +
				"fallbackLanguageBespokeTerms=" + this.fallbackLanguageBespokeTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of FxDisruptionEvents  ***********************/
	class FxDisruptionEventsBuilderImpl implements FxDisruptionEvents.FxDisruptionEventsBuilder {
	
		protected FxIllegalityOrImpossibilityEnum illegalityOrImpossibility;
		protected FxForceMajeureOrActOfSStateEnum forceMajeureOrActOfSState;
		protected EventCurrency.EventCurrencyBuilder eventCurrency;
		protected FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder priceSourceDisruption;
		protected FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder benchmarkObligationDefault;
		protected FxDualExchangeRate.FxDualExchangeRateBuilder dualExchangeRate;
		protected FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder inconvertibilityOrNonTransferability;
		protected GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder governmentalAuthorityDefault;
		protected Illiquidity.IlliquidityBuilder illiquidity;
		protected MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder materialChangeInCircumstance;
		protected Nationalization.NationalizationBuilder nationalization;
		protected PriceMateriality.PriceMaterialityBuilder priceMateriality;
		protected Clause.ClauseBuilder fallbackLanguageBespokeTerms;
		
		@Override
		@RosettaAttribute("illegalityOrImpossibility")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("illegalityOrImpossibility")
		public FxIllegalityOrImpossibilityEnum getIllegalityOrImpossibility() {
			return illegalityOrImpossibility;
		}
		
		@Override
		@RosettaAttribute("forceMajeureOrActOfSState")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forceMajeureOrActOfSState")
		public FxForceMajeureOrActOfSStateEnum getForceMajeureOrActOfSState() {
			return forceMajeureOrActOfSState;
		}
		
		@Override
		@RosettaAttribute("eventCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventCurrency")
		public EventCurrency.EventCurrencyBuilder getEventCurrency() {
			return eventCurrency;
		}
		
		@Override
		public EventCurrency.EventCurrencyBuilder getOrCreateEventCurrency() {
			EventCurrency.EventCurrencyBuilder result;
			if (eventCurrency!=null) {
				result = eventCurrency;
			}
			else {
				result = eventCurrency = EventCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceSourceDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceSourceDisruption")
		public FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder getPriceSourceDisruption() {
			return priceSourceDisruption;
		}
		
		@Override
		public FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder getOrCreatePriceSourceDisruption() {
			FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder result;
			if (priceSourceDisruption!=null) {
				result = priceSourceDisruption;
			}
			else {
				result = priceSourceDisruption = FxPriceSourceDisruption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("benchmarkObligationDefault")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("benchmarkObligationDefault")
		public FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder getBenchmarkObligationDefault() {
			return benchmarkObligationDefault;
		}
		
		@Override
		public FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder getOrCreateBenchmarkObligationDefault() {
			FxBenchmarkObligationDefault.FxBenchmarkObligationDefaultBuilder result;
			if (benchmarkObligationDefault!=null) {
				result = benchmarkObligationDefault;
			}
			else {
				result = benchmarkObligationDefault = FxBenchmarkObligationDefault.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dualExchangeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dualExchangeRate")
		public FxDualExchangeRate.FxDualExchangeRateBuilder getDualExchangeRate() {
			return dualExchangeRate;
		}
		
		@Override
		public FxDualExchangeRate.FxDualExchangeRateBuilder getOrCreateDualExchangeRate() {
			FxDualExchangeRate.FxDualExchangeRateBuilder result;
			if (dualExchangeRate!=null) {
				result = dualExchangeRate;
			}
			else {
				result = dualExchangeRate = FxDualExchangeRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("inconvertibilityOrNonTransferability")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inconvertibilityOrNonTransferability")
		public FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder getInconvertibilityOrNonTransferability() {
			return inconvertibilityOrNonTransferability;
		}
		
		@Override
		public FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder getOrCreateInconvertibilityOrNonTransferability() {
			FxInconvertibilityOrNonTransferability.FxInconvertibilityOrNonTransferabilityBuilder result;
			if (inconvertibilityOrNonTransferability!=null) {
				result = inconvertibilityOrNonTransferability;
			}
			else {
				result = inconvertibilityOrNonTransferability = FxInconvertibilityOrNonTransferability.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("governmentalAuthorityDefault")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("governmentalAuthorityDefault")
		public GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder getGovernmentalAuthorityDefault() {
			return governmentalAuthorityDefault;
		}
		
		@Override
		public GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder getOrCreateGovernmentalAuthorityDefault() {
			GovernmentalAuthorityDefault.GovernmentalAuthorityDefaultBuilder result;
			if (governmentalAuthorityDefault!=null) {
				result = governmentalAuthorityDefault;
			}
			else {
				result = governmentalAuthorityDefault = GovernmentalAuthorityDefault.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("illiquidity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("illiquidity")
		public Illiquidity.IlliquidityBuilder getIlliquidity() {
			return illiquidity;
		}
		
		@Override
		public Illiquidity.IlliquidityBuilder getOrCreateIlliquidity() {
			Illiquidity.IlliquidityBuilder result;
			if (illiquidity!=null) {
				result = illiquidity;
			}
			else {
				result = illiquidity = Illiquidity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("materialChangeInCircumstance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("materialChangeInCircumstance")
		public MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder getMaterialChangeInCircumstance() {
			return materialChangeInCircumstance;
		}
		
		@Override
		public MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder getOrCreateMaterialChangeInCircumstance() {
			MaterialChangeInCircumstance.MaterialChangeInCircumstanceBuilder result;
			if (materialChangeInCircumstance!=null) {
				result = materialChangeInCircumstance;
			}
			else {
				result = materialChangeInCircumstance = MaterialChangeInCircumstance.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nationalization")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nationalization")
		public Nationalization.NationalizationBuilder getNationalization() {
			return nationalization;
		}
		
		@Override
		public Nationalization.NationalizationBuilder getOrCreateNationalization() {
			Nationalization.NationalizationBuilder result;
			if (nationalization!=null) {
				result = nationalization;
			}
			else {
				result = nationalization = Nationalization.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceMateriality")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceMateriality")
		public PriceMateriality.PriceMaterialityBuilder getPriceMateriality() {
			return priceMateriality;
		}
		
		@Override
		public PriceMateriality.PriceMaterialityBuilder getOrCreatePriceMateriality() {
			PriceMateriality.PriceMaterialityBuilder result;
			if (priceMateriality!=null) {
				result = priceMateriality;
			}
			else {
				result = priceMateriality = PriceMateriality.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fallbackLanguageBespokeTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackLanguageBespokeTerms")
		public Clause.ClauseBuilder getFallbackLanguageBespokeTerms() {
			return fallbackLanguageBespokeTerms;
		}
		
		@Override
		public Clause.ClauseBuilder getOrCreateFallbackLanguageBespokeTerms() {
			Clause.ClauseBuilder result;
			if (fallbackLanguageBespokeTerms!=null) {
				result = fallbackLanguageBespokeTerms;
			}
			else {
				result = fallbackLanguageBespokeTerms = Clause.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("illegalityOrImpossibility")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("illegalityOrImpossibility")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder setIllegalityOrImpossibility(FxIllegalityOrImpossibilityEnum _illegalityOrImpossibility) {
			this.illegalityOrImpossibility = _illegalityOrImpossibility == null ? null : _illegalityOrImpossibility;
			return this;
		}
		
		@RosettaAttribute("forceMajeureOrActOfSState")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("forceMajeureOrActOfSState")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder setForceMajeureOrActOfSState(FxForceMajeureOrActOfSStateEnum _forceMajeureOrActOfSState) {
			this.forceMajeureOrActOfSState = _forceMajeureOrActOfSState == null ? null : _forceMajeureOrActOfSState;
			return this;
		}
		
		@RosettaAttribute("eventCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventCurrency")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder setEventCurrency(EventCurrency _eventCurrency) {
			this.eventCurrency = _eventCurrency == null ? null : _eventCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceSourceDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceSourceDisruption")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder setPriceSourceDisruption(FxPriceSourceDisruption _priceSourceDisruption) {
			this.priceSourceDisruption = _priceSourceDisruption == null ? null : _priceSourceDisruption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("benchmarkObligationDefault")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("benchmarkObligationDefault")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder setBenchmarkObligationDefault(FxBenchmarkObligationDefault _benchmarkObligationDefault) {
			this.benchmarkObligationDefault = _benchmarkObligationDefault == null ? null : _benchmarkObligationDefault.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dualExchangeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dualExchangeRate")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder setDualExchangeRate(FxDualExchangeRate _dualExchangeRate) {
			this.dualExchangeRate = _dualExchangeRate == null ? null : _dualExchangeRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("inconvertibilityOrNonTransferability")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inconvertibilityOrNonTransferability")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder setInconvertibilityOrNonTransferability(FxInconvertibilityOrNonTransferability _inconvertibilityOrNonTransferability) {
			this.inconvertibilityOrNonTransferability = _inconvertibilityOrNonTransferability == null ? null : _inconvertibilityOrNonTransferability.toBuilder();
			return this;
		}
		
		@RosettaAttribute("governmentalAuthorityDefault")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("governmentalAuthorityDefault")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder setGovernmentalAuthorityDefault(GovernmentalAuthorityDefault _governmentalAuthorityDefault) {
			this.governmentalAuthorityDefault = _governmentalAuthorityDefault == null ? null : _governmentalAuthorityDefault.toBuilder();
			return this;
		}
		
		@RosettaAttribute("illiquidity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("illiquidity")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder setIlliquidity(Illiquidity _illiquidity) {
			this.illiquidity = _illiquidity == null ? null : _illiquidity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("materialChangeInCircumstance")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("materialChangeInCircumstance")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder setMaterialChangeInCircumstance(MaterialChangeInCircumstance _materialChangeInCircumstance) {
			this.materialChangeInCircumstance = _materialChangeInCircumstance == null ? null : _materialChangeInCircumstance.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nationalization")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nationalization")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder setNationalization(Nationalization _nationalization) {
			this.nationalization = _nationalization == null ? null : _nationalization.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceMateriality")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceMateriality")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder setPriceMateriality(PriceMateriality _priceMateriality) {
			this.priceMateriality = _priceMateriality == null ? null : _priceMateriality.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fallbackLanguageBespokeTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fallbackLanguageBespokeTerms")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder setFallbackLanguageBespokeTerms(Clause _fallbackLanguageBespokeTerms) {
			this.fallbackLanguageBespokeTerms = _fallbackLanguageBespokeTerms == null ? null : _fallbackLanguageBespokeTerms.toBuilder();
			return this;
		}
		
		@Override
		public FxDisruptionEvents build() {
			return new FxDisruptionEvents.FxDisruptionEventsImpl(this);
		}
		
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder prune() {
			if (eventCurrency!=null && !eventCurrency.prune().hasData()) eventCurrency = null;
			if (priceSourceDisruption!=null && !priceSourceDisruption.prune().hasData()) priceSourceDisruption = null;
			if (benchmarkObligationDefault!=null && !benchmarkObligationDefault.prune().hasData()) benchmarkObligationDefault = null;
			if (dualExchangeRate!=null && !dualExchangeRate.prune().hasData()) dualExchangeRate = null;
			if (inconvertibilityOrNonTransferability!=null && !inconvertibilityOrNonTransferability.prune().hasData()) inconvertibilityOrNonTransferability = null;
			if (governmentalAuthorityDefault!=null && !governmentalAuthorityDefault.prune().hasData()) governmentalAuthorityDefault = null;
			if (illiquidity!=null && !illiquidity.prune().hasData()) illiquidity = null;
			if (materialChangeInCircumstance!=null && !materialChangeInCircumstance.prune().hasData()) materialChangeInCircumstance = null;
			if (nationalization!=null && !nationalization.prune().hasData()) nationalization = null;
			if (priceMateriality!=null && !priceMateriality.prune().hasData()) priceMateriality = null;
			if (fallbackLanguageBespokeTerms!=null && !fallbackLanguageBespokeTerms.prune().hasData()) fallbackLanguageBespokeTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIllegalityOrImpossibility()!=null) return true;
			if (getForceMajeureOrActOfSState()!=null) return true;
			if (getEventCurrency()!=null && getEventCurrency().hasData()) return true;
			if (getPriceSourceDisruption()!=null && getPriceSourceDisruption().hasData()) return true;
			if (getBenchmarkObligationDefault()!=null && getBenchmarkObligationDefault().hasData()) return true;
			if (getDualExchangeRate()!=null && getDualExchangeRate().hasData()) return true;
			if (getInconvertibilityOrNonTransferability()!=null && getInconvertibilityOrNonTransferability().hasData()) return true;
			if (getGovernmentalAuthorityDefault()!=null && getGovernmentalAuthorityDefault().hasData()) return true;
			if (getIlliquidity()!=null && getIlliquidity().hasData()) return true;
			if (getMaterialChangeInCircumstance()!=null && getMaterialChangeInCircumstance().hasData()) return true;
			if (getNationalization()!=null && getNationalization().hasData()) return true;
			if (getPriceMateriality()!=null && getPriceMateriality().hasData()) return true;
			if (getFallbackLanguageBespokeTerms()!=null && getFallbackLanguageBespokeTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxDisruptionEvents.FxDisruptionEventsBuilder o = (FxDisruptionEvents.FxDisruptionEventsBuilder) other;
			
			merger.mergeRosetta(getEventCurrency(), o.getEventCurrency(), this::setEventCurrency);
			merger.mergeRosetta(getPriceSourceDisruption(), o.getPriceSourceDisruption(), this::setPriceSourceDisruption);
			merger.mergeRosetta(getBenchmarkObligationDefault(), o.getBenchmarkObligationDefault(), this::setBenchmarkObligationDefault);
			merger.mergeRosetta(getDualExchangeRate(), o.getDualExchangeRate(), this::setDualExchangeRate);
			merger.mergeRosetta(getInconvertibilityOrNonTransferability(), o.getInconvertibilityOrNonTransferability(), this::setInconvertibilityOrNonTransferability);
			merger.mergeRosetta(getGovernmentalAuthorityDefault(), o.getGovernmentalAuthorityDefault(), this::setGovernmentalAuthorityDefault);
			merger.mergeRosetta(getIlliquidity(), o.getIlliquidity(), this::setIlliquidity);
			merger.mergeRosetta(getMaterialChangeInCircumstance(), o.getMaterialChangeInCircumstance(), this::setMaterialChangeInCircumstance);
			merger.mergeRosetta(getNationalization(), o.getNationalization(), this::setNationalization);
			merger.mergeRosetta(getPriceMateriality(), o.getPriceMateriality(), this::setPriceMateriality);
			merger.mergeRosetta(getFallbackLanguageBespokeTerms(), o.getFallbackLanguageBespokeTerms(), this::setFallbackLanguageBespokeTerms);
			
			merger.mergeBasic(getIllegalityOrImpossibility(), o.getIllegalityOrImpossibility(), this::setIllegalityOrImpossibility);
			merger.mergeBasic(getForceMajeureOrActOfSState(), o.getForceMajeureOrActOfSState(), this::setForceMajeureOrActOfSState);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDisruptionEvents _that = getType().cast(o);
		
			if (!Objects.equals(illegalityOrImpossibility, _that.getIllegalityOrImpossibility())) return false;
			if (!Objects.equals(forceMajeureOrActOfSState, _that.getForceMajeureOrActOfSState())) return false;
			if (!Objects.equals(eventCurrency, _that.getEventCurrency())) return false;
			if (!Objects.equals(priceSourceDisruption, _that.getPriceSourceDisruption())) return false;
			if (!Objects.equals(benchmarkObligationDefault, _that.getBenchmarkObligationDefault())) return false;
			if (!Objects.equals(dualExchangeRate, _that.getDualExchangeRate())) return false;
			if (!Objects.equals(inconvertibilityOrNonTransferability, _that.getInconvertibilityOrNonTransferability())) return false;
			if (!Objects.equals(governmentalAuthorityDefault, _that.getGovernmentalAuthorityDefault())) return false;
			if (!Objects.equals(illiquidity, _that.getIlliquidity())) return false;
			if (!Objects.equals(materialChangeInCircumstance, _that.getMaterialChangeInCircumstance())) return false;
			if (!Objects.equals(nationalization, _that.getNationalization())) return false;
			if (!Objects.equals(priceMateriality, _that.getPriceMateriality())) return false;
			if (!Objects.equals(fallbackLanguageBespokeTerms, _that.getFallbackLanguageBespokeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (illegalityOrImpossibility != null ? illegalityOrImpossibility.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (forceMajeureOrActOfSState != null ? forceMajeureOrActOfSState.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventCurrency != null ? eventCurrency.hashCode() : 0);
			_result = 31 * _result + (priceSourceDisruption != null ? priceSourceDisruption.hashCode() : 0);
			_result = 31 * _result + (benchmarkObligationDefault != null ? benchmarkObligationDefault.hashCode() : 0);
			_result = 31 * _result + (dualExchangeRate != null ? dualExchangeRate.hashCode() : 0);
			_result = 31 * _result + (inconvertibilityOrNonTransferability != null ? inconvertibilityOrNonTransferability.hashCode() : 0);
			_result = 31 * _result + (governmentalAuthorityDefault != null ? governmentalAuthorityDefault.hashCode() : 0);
			_result = 31 * _result + (illiquidity != null ? illiquidity.hashCode() : 0);
			_result = 31 * _result + (materialChangeInCircumstance != null ? materialChangeInCircumstance.hashCode() : 0);
			_result = 31 * _result + (nationalization != null ? nationalization.hashCode() : 0);
			_result = 31 * _result + (priceMateriality != null ? priceMateriality.hashCode() : 0);
			_result = 31 * _result + (fallbackLanguageBespokeTerms != null ? fallbackLanguageBespokeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruptionEventsBuilder {" +
				"illegalityOrImpossibility=" + this.illegalityOrImpossibility + ", " +
				"forceMajeureOrActOfSState=" + this.forceMajeureOrActOfSState + ", " +
				"eventCurrency=" + this.eventCurrency + ", " +
				"priceSourceDisruption=" + this.priceSourceDisruption + ", " +
				"benchmarkObligationDefault=" + this.benchmarkObligationDefault + ", " +
				"dualExchangeRate=" + this.dualExchangeRate + ", " +
				"inconvertibilityOrNonTransferability=" + this.inconvertibilityOrNonTransferability + ", " +
				"governmentalAuthorityDefault=" + this.governmentalAuthorityDefault + ", " +
				"illiquidity=" + this.illiquidity + ", " +
				"materialChangeInCircumstance=" + this.materialChangeInCircumstance + ", " +
				"nationalization=" + this.nationalization + ", " +
				"priceMateriality=" + this.priceMateriality + ", " +
				"fallbackLanguageBespokeTerms=" + this.fallbackLanguageBespokeTerms +
			'}';
		}
	}
}
