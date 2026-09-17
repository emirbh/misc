package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.NonDeliverableSettlementMeta;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.SettlementRateOption;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the parameters used when the reference currency of the swapStream is non-deliverable.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the parameters used when the reference currency of the swapStream is non-deliverable.
 *
 */
@RosettaDataType(value="NonDeliverableSettlement", builder=NonDeliverableSettlement.NonDeliverableSettlementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NonDeliverableSettlement", model="fpml", builder=NonDeliverableSettlement.NonDeliverableSettlementBuilderImpl.class, version="2.1.1")
public interface NonDeliverableSettlement extends RosettaModelObject {

	NonDeliverableSettlementMeta metaData = new NonDeliverableSettlementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency in which the swap stream is denominated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency in which the swap stream is denominated.
	 *
	 */
	Currency getReferenceCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date, when expressed as a relative date, on which the currency rate will be determined for the purpose of specifying the amount in deliverable currency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date, when expressed as a relative date, on which the currency rate will be determined for the purpose of specifying the amount in deliverable currency.
	 *
	 */
	FxFixingDate getFxFixingDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date, when expressed as a schedule of date(s), on which the currency rate will be determined for the purpose of specifying the amount in deliverable currency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date, when expressed as a schedule of date(s), on which the currency rate will be determined for the purpose of specifying the amount in deliverable currency.
	 *
	 */
	AdjustableDates getFxFixingSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The rate source for the conversion to the settlement currency. This source is specified through a scheme that reflects the terms of the Annex A to the 1998 FX and Currency Option Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The rate source for the conversion to the settlement currency. This source is specified through a scheme that reflects the terms of the Annex A to the 1998 FX and Currency Option Definitions.
	 *
	 */
	SettlementRateOption getSettlementRateOption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A type defining the parameters to get a new quote when a settlement rate option is disrupted.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A type defining the parameters to get a new quote when a settlement rate option is disrupted.
	 *
	 */
	PriceSourceDisruption getPriceSourceDisruption();

	/*********************** Build Methods  ***********************/
	NonDeliverableSettlement build();
	
	NonDeliverableSettlement.NonDeliverableSettlementBuilder toBuilder();
	
	static NonDeliverableSettlement.NonDeliverableSettlementBuilder builder() {
		return new NonDeliverableSettlement.NonDeliverableSettlementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonDeliverableSettlement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonDeliverableSettlement> getType() {
		return NonDeliverableSettlement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("referenceCurrency"), processor, Currency.class, getReferenceCurrency());
		processRosetta(path.newSubPath("fxFixingDate"), processor, FxFixingDate.class, getFxFixingDate());
		processRosetta(path.newSubPath("fxFixingSchedule"), processor, AdjustableDates.class, getFxFixingSchedule());
		processRosetta(path.newSubPath("settlementRateOption"), processor, SettlementRateOption.class, getSettlementRateOption());
		processRosetta(path.newSubPath("priceSourceDisruption"), processor, PriceSourceDisruption.class, getPriceSourceDisruption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonDeliverableSettlementBuilder extends NonDeliverableSettlement, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateReferenceCurrency();
		@Override
		Currency.CurrencyBuilder getReferenceCurrency();
		FxFixingDate.FxFixingDateBuilder getOrCreateFxFixingDate();
		@Override
		FxFixingDate.FxFixingDateBuilder getFxFixingDate();
		AdjustableDates.AdjustableDatesBuilder getOrCreateFxFixingSchedule();
		@Override
		AdjustableDates.AdjustableDatesBuilder getFxFixingSchedule();
		SettlementRateOption.SettlementRateOptionBuilder getOrCreateSettlementRateOption();
		@Override
		SettlementRateOption.SettlementRateOptionBuilder getSettlementRateOption();
		PriceSourceDisruption.PriceSourceDisruptionBuilder getOrCreatePriceSourceDisruption();
		@Override
		PriceSourceDisruption.PriceSourceDisruptionBuilder getPriceSourceDisruption();
		NonDeliverableSettlement.NonDeliverableSettlementBuilder setReferenceCurrency(Currency referenceCurrency);
		NonDeliverableSettlement.NonDeliverableSettlementBuilder setFxFixingDate(FxFixingDate fxFixingDate);
		NonDeliverableSettlement.NonDeliverableSettlementBuilder setFxFixingSchedule(AdjustableDates fxFixingSchedule);
		NonDeliverableSettlement.NonDeliverableSettlementBuilder setSettlementRateOption(SettlementRateOption settlementRateOption);
		NonDeliverableSettlement.NonDeliverableSettlementBuilder setPriceSourceDisruption(PriceSourceDisruption priceSourceDisruption);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("referenceCurrency"), processor, Currency.CurrencyBuilder.class, getReferenceCurrency());
			processRosetta(path.newSubPath("fxFixingDate"), processor, FxFixingDate.FxFixingDateBuilder.class, getFxFixingDate());
			processRosetta(path.newSubPath("fxFixingSchedule"), processor, AdjustableDates.AdjustableDatesBuilder.class, getFxFixingSchedule());
			processRosetta(path.newSubPath("settlementRateOption"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getSettlementRateOption());
			processRosetta(path.newSubPath("priceSourceDisruption"), processor, PriceSourceDisruption.PriceSourceDisruptionBuilder.class, getPriceSourceDisruption());
		}
		

		NonDeliverableSettlement.NonDeliverableSettlementBuilder prune();
	}

	/*********************** Immutable Implementation of NonDeliverableSettlement  ***********************/
	class NonDeliverableSettlementImpl implements NonDeliverableSettlement {
		private final Currency referenceCurrency;
		private final FxFixingDate fxFixingDate;
		private final AdjustableDates fxFixingSchedule;
		private final SettlementRateOption settlementRateOption;
		private final PriceSourceDisruption priceSourceDisruption;
		
		protected NonDeliverableSettlementImpl(NonDeliverableSettlement.NonDeliverableSettlementBuilder builder) {
			this.referenceCurrency = ofNullable(builder.getReferenceCurrency()).map(f->f.build()).orElse(null);
			this.fxFixingDate = ofNullable(builder.getFxFixingDate()).map(f->f.build()).orElse(null);
			this.fxFixingSchedule = ofNullable(builder.getFxFixingSchedule()).map(f->f.build()).orElse(null);
			this.settlementRateOption = ofNullable(builder.getSettlementRateOption()).map(f->f.build()).orElse(null);
			this.priceSourceDisruption = ofNullable(builder.getPriceSourceDisruption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("referenceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceCurrency")
		public Currency getReferenceCurrency() {
			return referenceCurrency;
		}
		
		@Override
		@RosettaAttribute("fxFixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxFixingDate")
		public FxFixingDate getFxFixingDate() {
			return fxFixingDate;
		}
		
		@Override
		@RosettaAttribute("fxFixingSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxFixingSchedule")
		public AdjustableDates getFxFixingSchedule() {
			return fxFixingSchedule;
		}
		
		@Override
		@RosettaAttribute("settlementRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementRateOption")
		public SettlementRateOption getSettlementRateOption() {
			return settlementRateOption;
		}
		
		@Override
		@RosettaAttribute("priceSourceDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceSourceDisruption")
		public PriceSourceDisruption getPriceSourceDisruption() {
			return priceSourceDisruption;
		}
		
		@Override
		public NonDeliverableSettlement build() {
			return this;
		}
		
		@Override
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder toBuilder() {
			NonDeliverableSettlement.NonDeliverableSettlementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonDeliverableSettlement.NonDeliverableSettlementBuilder builder) {
			ofNullable(getReferenceCurrency()).ifPresent(builder::setReferenceCurrency);
			ofNullable(getFxFixingDate()).ifPresent(builder::setFxFixingDate);
			ofNullable(getFxFixingSchedule()).ifPresent(builder::setFxFixingSchedule);
			ofNullable(getSettlementRateOption()).ifPresent(builder::setSettlementRateOption);
			ofNullable(getPriceSourceDisruption()).ifPresent(builder::setPriceSourceDisruption);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonDeliverableSettlement _that = getType().cast(o);
		
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			if (!Objects.equals(fxFixingDate, _that.getFxFixingDate())) return false;
			if (!Objects.equals(fxFixingSchedule, _that.getFxFixingSchedule())) return false;
			if (!Objects.equals(settlementRateOption, _that.getSettlementRateOption())) return false;
			if (!Objects.equals(priceSourceDisruption, _that.getPriceSourceDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			_result = 31 * _result + (fxFixingDate != null ? fxFixingDate.hashCode() : 0);
			_result = 31 * _result + (fxFixingSchedule != null ? fxFixingSchedule.hashCode() : 0);
			_result = 31 * _result + (settlementRateOption != null ? settlementRateOption.hashCode() : 0);
			_result = 31 * _result + (priceSourceDisruption != null ? priceSourceDisruption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonDeliverableSettlement {" +
				"referenceCurrency=" + this.referenceCurrency + ", " +
				"fxFixingDate=" + this.fxFixingDate + ", " +
				"fxFixingSchedule=" + this.fxFixingSchedule + ", " +
				"settlementRateOption=" + this.settlementRateOption + ", " +
				"priceSourceDisruption=" + this.priceSourceDisruption +
			'}';
		}
	}

	/*********************** Builder Implementation of NonDeliverableSettlement  ***********************/
	class NonDeliverableSettlementBuilderImpl implements NonDeliverableSettlement.NonDeliverableSettlementBuilder {
	
		protected Currency.CurrencyBuilder referenceCurrency;
		protected FxFixingDate.FxFixingDateBuilder fxFixingDate;
		protected AdjustableDates.AdjustableDatesBuilder fxFixingSchedule;
		protected SettlementRateOption.SettlementRateOptionBuilder settlementRateOption;
		protected PriceSourceDisruption.PriceSourceDisruptionBuilder priceSourceDisruption;
		
		@Override
		@RosettaAttribute("referenceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceCurrency")
		public Currency.CurrencyBuilder getReferenceCurrency() {
			return referenceCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateReferenceCurrency() {
			Currency.CurrencyBuilder result;
			if (referenceCurrency!=null) {
				result = referenceCurrency;
			}
			else {
				result = referenceCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxFixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxFixingDate")
		public FxFixingDate.FxFixingDateBuilder getFxFixingDate() {
			return fxFixingDate;
		}
		
		@Override
		public FxFixingDate.FxFixingDateBuilder getOrCreateFxFixingDate() {
			FxFixingDate.FxFixingDateBuilder result;
			if (fxFixingDate!=null) {
				result = fxFixingDate;
			}
			else {
				result = fxFixingDate = FxFixingDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxFixingSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxFixingSchedule")
		public AdjustableDates.AdjustableDatesBuilder getFxFixingSchedule() {
			return fxFixingSchedule;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateFxFixingSchedule() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (fxFixingSchedule!=null) {
				result = fxFixingSchedule;
			}
			else {
				result = fxFixingSchedule = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementRateOption")
		public SettlementRateOption.SettlementRateOptionBuilder getSettlementRateOption() {
			return settlementRateOption;
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder getOrCreateSettlementRateOption() {
			SettlementRateOption.SettlementRateOptionBuilder result;
			if (settlementRateOption!=null) {
				result = settlementRateOption;
			}
			else {
				result = settlementRateOption = SettlementRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceSourceDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceSourceDisruption")
		public PriceSourceDisruption.PriceSourceDisruptionBuilder getPriceSourceDisruption() {
			return priceSourceDisruption;
		}
		
		@Override
		public PriceSourceDisruption.PriceSourceDisruptionBuilder getOrCreatePriceSourceDisruption() {
			PriceSourceDisruption.PriceSourceDisruptionBuilder result;
			if (priceSourceDisruption!=null) {
				result = priceSourceDisruption;
			}
			else {
				result = priceSourceDisruption = PriceSourceDisruption.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("referenceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceCurrency")
		@Override
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder setReferenceCurrency(Currency _referenceCurrency) {
			this.referenceCurrency = _referenceCurrency == null ? null : _referenceCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxFixingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxFixingDate")
		@Override
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder setFxFixingDate(FxFixingDate _fxFixingDate) {
			this.fxFixingDate = _fxFixingDate == null ? null : _fxFixingDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxFixingSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxFixingSchedule")
		@Override
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder setFxFixingSchedule(AdjustableDates _fxFixingSchedule) {
			this.fxFixingSchedule = _fxFixingSchedule == null ? null : _fxFixingSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementRateOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementRateOption")
		@Override
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder setSettlementRateOption(SettlementRateOption _settlementRateOption) {
			this.settlementRateOption = _settlementRateOption == null ? null : _settlementRateOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceSourceDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceSourceDisruption")
		@Override
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder setPriceSourceDisruption(PriceSourceDisruption _priceSourceDisruption) {
			this.priceSourceDisruption = _priceSourceDisruption == null ? null : _priceSourceDisruption.toBuilder();
			return this;
		}
		
		@Override
		public NonDeliverableSettlement build() {
			return new NonDeliverableSettlement.NonDeliverableSettlementImpl(this);
		}
		
		@Override
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder prune() {
			if (referenceCurrency!=null && !referenceCurrency.prune().hasData()) referenceCurrency = null;
			if (fxFixingDate!=null && !fxFixingDate.prune().hasData()) fxFixingDate = null;
			if (fxFixingSchedule!=null && !fxFixingSchedule.prune().hasData()) fxFixingSchedule = null;
			if (settlementRateOption!=null && !settlementRateOption.prune().hasData()) settlementRateOption = null;
			if (priceSourceDisruption!=null && !priceSourceDisruption.prune().hasData()) priceSourceDisruption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReferenceCurrency()!=null && getReferenceCurrency().hasData()) return true;
			if (getFxFixingDate()!=null && getFxFixingDate().hasData()) return true;
			if (getFxFixingSchedule()!=null && getFxFixingSchedule().hasData()) return true;
			if (getSettlementRateOption()!=null && getSettlementRateOption().hasData()) return true;
			if (getPriceSourceDisruption()!=null && getPriceSourceDisruption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonDeliverableSettlement.NonDeliverableSettlementBuilder o = (NonDeliverableSettlement.NonDeliverableSettlementBuilder) other;
			
			merger.mergeRosetta(getReferenceCurrency(), o.getReferenceCurrency(), this::setReferenceCurrency);
			merger.mergeRosetta(getFxFixingDate(), o.getFxFixingDate(), this::setFxFixingDate);
			merger.mergeRosetta(getFxFixingSchedule(), o.getFxFixingSchedule(), this::setFxFixingSchedule);
			merger.mergeRosetta(getSettlementRateOption(), o.getSettlementRateOption(), this::setSettlementRateOption);
			merger.mergeRosetta(getPriceSourceDisruption(), o.getPriceSourceDisruption(), this::setPriceSourceDisruption);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonDeliverableSettlement _that = getType().cast(o);
		
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			if (!Objects.equals(fxFixingDate, _that.getFxFixingDate())) return false;
			if (!Objects.equals(fxFixingSchedule, _that.getFxFixingSchedule())) return false;
			if (!Objects.equals(settlementRateOption, _that.getSettlementRateOption())) return false;
			if (!Objects.equals(priceSourceDisruption, _that.getPriceSourceDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			_result = 31 * _result + (fxFixingDate != null ? fxFixingDate.hashCode() : 0);
			_result = 31 * _result + (fxFixingSchedule != null ? fxFixingSchedule.hashCode() : 0);
			_result = 31 * _result + (settlementRateOption != null ? settlementRateOption.hashCode() : 0);
			_result = 31 * _result + (priceSourceDisruption != null ? priceSourceDisruption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonDeliverableSettlementBuilder {" +
				"referenceCurrency=" + this.referenceCurrency + ", " +
				"fxFixingDate=" + this.fxFixingDate + ", " +
				"fxFixingSchedule=" + this.fxFixingSchedule + ", " +
				"settlementRateOption=" + this.settlementRateOption + ", " +
				"priceSourceDisruption=" + this.priceSourceDisruption +
			'}';
		}
	}
}
