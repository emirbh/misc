package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.SimpleIRSwapMeta;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.ProductReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Identifies a simple underlying asset that is a swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Identifies a simple underlying asset that is a swap.
 *
 */
@RosettaDataType(value="SimpleIRSwap", builder=SimpleIRSwap.SimpleIRSwapBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SimpleIRSwap", model="fpml", builder=SimpleIRSwap.SimpleIRSwapBuilderImpl.class, version="2.1.1")
public interface SimpleIRSwap extends UnderlyingAsset {

	SimpleIRSwapMeta metaData = new SimpleIRSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the term of the simple swap, e.g. 5Y.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the term of the simple swap, e.g. 5Y.
	 *
	 */
	Period getTerm();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the frequency at which the swap pays, e.g. 6M.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the frequency at which the swap pays, e.g. 6M.
	 *
	 */
	Period getPaymentFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The day count basis for the swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The day count basis for the swap.
	 *
	 */
	DayCountFraction getDayCountFraction();

	/*********************** Build Methods  ***********************/
	SimpleIRSwap build();
	
	SimpleIRSwap.SimpleIRSwapBuilder toBuilder();
	
	static SimpleIRSwap.SimpleIRSwapBuilder builder() {
		return new SimpleIRSwap.SimpleIRSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SimpleIRSwap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SimpleIRSwap> getType() {
		return SimpleIRSwap.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.class, getInstrumentType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.class, getClearanceSystem());
		processRosetta(path.newSubPath("definition"), processor, ProductReference.class, getDefinition());
		processRosetta(path.newSubPath("term"), processor, Period.class, getTerm());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SimpleIRSwapBuilder extends SimpleIRSwap, UnderlyingAsset.UnderlyingAssetBuilder {
		Period.PeriodBuilder getOrCreateTerm();
		@Override
		Period.PeriodBuilder getTerm();
		Period.PeriodBuilder getOrCreatePaymentFrequency();
		@Override
		Period.PeriodBuilder getPaymentFrequency();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		@Override
		SimpleIRSwap.SimpleIRSwapBuilder setId(String id);
		@Override
		SimpleIRSwap.SimpleIRSwapBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		SimpleIRSwap.SimpleIRSwapBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		SimpleIRSwap.SimpleIRSwapBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		SimpleIRSwap.SimpleIRSwapBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		SimpleIRSwap.SimpleIRSwapBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		SimpleIRSwap.SimpleIRSwapBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		SimpleIRSwap.SimpleIRSwapBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		SimpleIRSwap.SimpleIRSwapBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		SimpleIRSwap.SimpleIRSwapBuilder setDescription(String description);
		@Override
		SimpleIRSwap.SimpleIRSwapBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		SimpleIRSwap.SimpleIRSwapBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		SimpleIRSwap.SimpleIRSwapBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		SimpleIRSwap.SimpleIRSwapBuilder setDefinition(ProductReference definition);
		SimpleIRSwap.SimpleIRSwapBuilder setTerm(Period term);
		SimpleIRSwap.SimpleIRSwapBuilder setPaymentFrequency(Period paymentFrequency);
		SimpleIRSwap.SimpleIRSwapBuilder setDayCountFraction(DayCountFraction dayCountFraction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.InstrumentTypeBuilder.class, getInstrumentType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("term"), processor, Period.PeriodBuilder.class, getTerm());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
		}
		

		SimpleIRSwap.SimpleIRSwapBuilder prune();
	}

	/*********************** Immutable Implementation of SimpleIRSwap  ***********************/
	class SimpleIRSwapImpl extends UnderlyingAsset.UnderlyingAssetImpl implements SimpleIRSwap {
		private final Period term;
		private final Period paymentFrequency;
		private final DayCountFraction dayCountFraction;
		
		protected SimpleIRSwapImpl(SimpleIRSwap.SimpleIRSwapBuilder builder) {
			super(builder);
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("term")
		public Period getTerm() {
			return term;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentFrequency")
		public Period getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public SimpleIRSwap build() {
			return this;
		}
		
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder toBuilder() {
			SimpleIRSwap.SimpleIRSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SimpleIRSwap.SimpleIRSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTerm()).ifPresent(builder::setTerm);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SimpleIRSwap _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimpleIRSwap {" +
				"term=" + this.term + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SimpleIRSwap  ***********************/
	class SimpleIRSwapBuilderImpl extends UnderlyingAsset.UnderlyingAssetBuilderImpl implements SimpleIRSwap.SimpleIRSwapBuilder {
	
		protected Period.PeriodBuilder term;
		protected Period.PeriodBuilder paymentFrequency;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("term")
		public Period.PeriodBuilder getTerm() {
			return term;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTerm() {
			Period.PeriodBuilder result;
			if (term!=null) {
				result = term;
			}
			else {
				result = term = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentFrequency")
		public Period.PeriodBuilder getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreatePaymentFrequency() {
			Period.PeriodBuilder result;
			if (paymentFrequency!=null) {
				result = paymentFrequency;
			}
			else {
				result = paymentFrequency = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes != null) {
				for (final InstrumentType toAdd : instrumentTypes) {
					this.instrumentType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes == null) {
				this.instrumentType = new ArrayList<>();
			} else {
				this.instrumentType = instrumentTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("term")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("term")
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder setTerm(Period _term) {
			this.term = _term == null ? null : _term.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountFraction")
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@Override
		public SimpleIRSwap build() {
			return new SimpleIRSwap.SimpleIRSwapImpl(this);
		}
		
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder prune() {
			super.prune();
			if (term!=null && !term.prune().hasData()) term = null;
			if (paymentFrequency!=null && !paymentFrequency.prune().hasData()) paymentFrequency = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTerm()!=null && getTerm().hasData()) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimpleIRSwap.SimpleIRSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SimpleIRSwap.SimpleIRSwapBuilder o = (SimpleIRSwap.SimpleIRSwapBuilder) other;
			
			merger.mergeRosetta(getTerm(), o.getTerm(), this::setTerm);
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::setPaymentFrequency);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SimpleIRSwap _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimpleIRSwapBuilder {" +
				"term=" + this.term + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}' + " " + super.toString();
		}
	}
}
