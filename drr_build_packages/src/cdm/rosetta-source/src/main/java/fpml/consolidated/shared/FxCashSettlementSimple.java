package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.FxCashSettlementSimpleMeta;
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
 * Provision A type that is used for describing cash settlement of a variance or volatility swap option. It includes the settlement currency together with the spot currency exchange required to calculate the settlement currency amount.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that is used for describing cash settlement of a variance or volatility swap option. It includes the settlement currency together with the spot currency exchange required to calculate the settlement currency amount.
 *
 */
@RosettaDataType(value="FxCashSettlementSimple", builder=FxCashSettlementSimple.FxCashSettlementSimpleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxCashSettlementSimple", model="fpml", builder=FxCashSettlementSimple.FxCashSettlementSimpleBuilderImpl.class, version="2.1.1")
public interface FxCashSettlementSimple extends RosettaModelObject {

	FxCashSettlementSimpleMeta metaData = new FxCashSettlementSimpleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency in which cash settlement occurs.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency in which cash settlement occurs.
	 *
	 */
	Currency getSettlementCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference Currency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference Currency.
	 *
	 */
	Currency getReferenceCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Quoted currency pair.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Quoted currency pair.
	 *
	 */
	List<? extends FxFixing> getFixing();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Settlement Rate Source and Fixing Date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Settlement Rate Source and Fixing Date.
	 *
	 */
	List<? extends FxRateSourceFixing> getRateSourceFixing();

	/*********************** Build Methods  ***********************/
	FxCashSettlementSimple build();
	
	FxCashSettlementSimple.FxCashSettlementSimpleBuilder toBuilder();
	
	static FxCashSettlementSimple.FxCashSettlementSimpleBuilder builder() {
		return new FxCashSettlementSimple.FxCashSettlementSimpleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxCashSettlementSimple> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxCashSettlementSimple> getType() {
		return FxCashSettlementSimple.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("referenceCurrency"), processor, Currency.class, getReferenceCurrency());
		processRosetta(path.newSubPath("fixing"), processor, FxFixing.class, getFixing());
		processRosetta(path.newSubPath("rateSourceFixing"), processor, FxRateSourceFixing.class, getRateSourceFixing());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxCashSettlementSimpleBuilder extends FxCashSettlementSimple, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateSettlementCurrency();
		@Override
		Currency.CurrencyBuilder getSettlementCurrency();
		Currency.CurrencyBuilder getOrCreateReferenceCurrency();
		@Override
		Currency.CurrencyBuilder getReferenceCurrency();
		FxFixing.FxFixingBuilder getOrCreateFixing(int index);
		@Override
		List<? extends FxFixing.FxFixingBuilder> getFixing();
		FxRateSourceFixing.FxRateSourceFixingBuilder getOrCreateRateSourceFixing(int index);
		@Override
		List<? extends FxRateSourceFixing.FxRateSourceFixingBuilder> getRateSourceFixing();
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder setSettlementCurrency(Currency settlementCurrency);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder setReferenceCurrency(Currency referenceCurrency);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder addFixing(FxFixing fixing);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder addFixing(FxFixing fixing, int idx);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder addFixing(List<? extends FxFixing> fixing);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder setFixing(List<? extends FxFixing> fixing);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder addRateSourceFixing(FxRateSourceFixing rateSourceFixing);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder addRateSourceFixing(FxRateSourceFixing rateSourceFixing, int idx);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder addRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixing);
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder setRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixing);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("referenceCurrency"), processor, Currency.CurrencyBuilder.class, getReferenceCurrency());
			processRosetta(path.newSubPath("fixing"), processor, FxFixing.FxFixingBuilder.class, getFixing());
			processRosetta(path.newSubPath("rateSourceFixing"), processor, FxRateSourceFixing.FxRateSourceFixingBuilder.class, getRateSourceFixing());
		}
		

		FxCashSettlementSimple.FxCashSettlementSimpleBuilder prune();
	}

	/*********************** Immutable Implementation of FxCashSettlementSimple  ***********************/
	class FxCashSettlementSimpleImpl implements FxCashSettlementSimple {
		private final Currency settlementCurrency;
		private final Currency referenceCurrency;
		private final List<? extends FxFixing> fixing;
		private final List<? extends FxRateSourceFixing> rateSourceFixing;
		
		protected FxCashSettlementSimpleImpl(FxCashSettlementSimple.FxCashSettlementSimpleBuilder builder) {
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.referenceCurrency = ofNullable(builder.getReferenceCurrency()).map(f->f.build()).orElse(null);
			this.fixing = ofNullable(builder.getFixing()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.rateSourceFixing = ofNullable(builder.getRateSourceFixing()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementCurrency")
		public Currency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("referenceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceCurrency")
		public Currency getReferenceCurrency() {
			return referenceCurrency;
		}
		
		@Override
		@RosettaAttribute("fixing")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixing")
		public List<? extends FxFixing> getFixing() {
			return fixing;
		}
		
		@Override
		@RosettaAttribute("rateSourceFixing")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("rateSourceFixing")
		public List<? extends FxRateSourceFixing> getRateSourceFixing() {
			return rateSourceFixing;
		}
		
		@Override
		public FxCashSettlementSimple build() {
			return this;
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder toBuilder() {
			FxCashSettlementSimple.FxCashSettlementSimpleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxCashSettlementSimple.FxCashSettlementSimpleBuilder builder) {
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getReferenceCurrency()).ifPresent(builder::setReferenceCurrency);
			ofNullable(getFixing()).ifPresent(builder::setFixing);
			ofNullable(getRateSourceFixing()).ifPresent(builder::setRateSourceFixing);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCashSettlementSimple _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			if (!ListEquals.listEquals(fixing, _that.getFixing())) return false;
			if (!ListEquals.listEquals(rateSourceFixing, _that.getRateSourceFixing())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			_result = 31 * _result + (fixing != null ? fixing.hashCode() : 0);
			_result = 31 * _result + (rateSourceFixing != null ? rateSourceFixing.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCashSettlementSimple {" +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"referenceCurrency=" + this.referenceCurrency + ", " +
				"fixing=" + this.fixing + ", " +
				"rateSourceFixing=" + this.rateSourceFixing +
			'}';
		}
	}

	/*********************** Builder Implementation of FxCashSettlementSimple  ***********************/
	class FxCashSettlementSimpleBuilderImpl implements FxCashSettlementSimple.FxCashSettlementSimpleBuilder {
	
		protected Currency.CurrencyBuilder settlementCurrency;
		protected Currency.CurrencyBuilder referenceCurrency;
		protected List<FxFixing.FxFixingBuilder> fixing = new ArrayList<>();
		protected List<FxRateSourceFixing.FxRateSourceFixingBuilder> rateSourceFixing = new ArrayList<>();
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementCurrency")
		public Currency.CurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateSettlementCurrency() {
			Currency.CurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
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
		@RosettaAttribute("fixing")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixing")
		public List<? extends FxFixing.FxFixingBuilder> getFixing() {
			return fixing;
		}
		
		@Override
		public FxFixing.FxFixingBuilder getOrCreateFixing(int index) {
			if (fixing==null) {
				this.fixing = new ArrayList<>();
			}
			return getIndex(fixing, index, () -> {
						FxFixing.FxFixingBuilder newFixing = FxFixing.builder();
						return newFixing;
					});
		}
		
		@Override
		@RosettaAttribute("rateSourceFixing")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("rateSourceFixing")
		public List<? extends FxRateSourceFixing.FxRateSourceFixingBuilder> getRateSourceFixing() {
			return rateSourceFixing;
		}
		
		@Override
		public FxRateSourceFixing.FxRateSourceFixingBuilder getOrCreateRateSourceFixing(int index) {
			if (rateSourceFixing==null) {
				this.rateSourceFixing = new ArrayList<>();
			}
			return getIndex(rateSourceFixing, index, () -> {
						FxRateSourceFixing.FxRateSourceFixingBuilder newRateSourceFixing = FxRateSourceFixing.builder();
						return newRateSourceFixing;
					});
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementCurrency")
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("referenceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceCurrency")
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder setReferenceCurrency(Currency _referenceCurrency) {
			this.referenceCurrency = _referenceCurrency == null ? null : _referenceCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixing")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fixing")
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder addFixing(FxFixing _fixing) {
			if (_fixing != null) {
				this.fixing.add(_fixing.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder addFixing(FxFixing _fixing, int idx) {
			getIndex(this.fixing, idx, () -> _fixing.toBuilder());
			return this;
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder addFixing(List<? extends FxFixing> fixings) {
			if (fixings != null) {
				for (final FxFixing toAdd : fixings) {
					this.fixing.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("fixing")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fixing")
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder setFixing(List<? extends FxFixing> fixings) {
			if (fixings == null) {
				this.fixing = new ArrayList<>();
			} else {
				this.fixing = fixings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("rateSourceFixing")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("rateSourceFixing")
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder addRateSourceFixing(FxRateSourceFixing _rateSourceFixing) {
			if (_rateSourceFixing != null) {
				this.rateSourceFixing.add(_rateSourceFixing.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder addRateSourceFixing(FxRateSourceFixing _rateSourceFixing, int idx) {
			getIndex(this.rateSourceFixing, idx, () -> _rateSourceFixing.toBuilder());
			return this;
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder addRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixings) {
			if (rateSourceFixings != null) {
				for (final FxRateSourceFixing toAdd : rateSourceFixings) {
					this.rateSourceFixing.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("rateSourceFixing")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("rateSourceFixing")
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder setRateSourceFixing(List<? extends FxRateSourceFixing> rateSourceFixings) {
			if (rateSourceFixings == null) {
				this.rateSourceFixing = new ArrayList<>();
			} else {
				this.rateSourceFixing = rateSourceFixings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxCashSettlementSimple build() {
			return new FxCashSettlementSimple.FxCashSettlementSimpleImpl(this);
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder prune() {
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			if (referenceCurrency!=null && !referenceCurrency.prune().hasData()) referenceCurrency = null;
			fixing = fixing.stream().filter(b->b!=null).<FxFixing.FxFixingBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			rateSourceFixing = rateSourceFixing.stream().filter(b->b!=null).<FxRateSourceFixing.FxRateSourceFixingBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getReferenceCurrency()!=null && getReferenceCurrency().hasData()) return true;
			if (getFixing()!=null && getFixing().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRateSourceFixing()!=null && getRateSourceFixing().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxCashSettlementSimple.FxCashSettlementSimpleBuilder o = (FxCashSettlementSimple.FxCashSettlementSimpleBuilder) other;
			
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getReferenceCurrency(), o.getReferenceCurrency(), this::setReferenceCurrency);
			merger.mergeRosetta(getFixing(), o.getFixing(), this::getOrCreateFixing);
			merger.mergeRosetta(getRateSourceFixing(), o.getRateSourceFixing(), this::getOrCreateRateSourceFixing);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCashSettlementSimple _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			if (!ListEquals.listEquals(fixing, _that.getFixing())) return false;
			if (!ListEquals.listEquals(rateSourceFixing, _that.getRateSourceFixing())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			_result = 31 * _result + (fixing != null ? fixing.hashCode() : 0);
			_result = 31 * _result + (rateSourceFixing != null ? rateSourceFixing.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCashSettlementSimpleBuilder {" +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"referenceCurrency=" + this.referenceCurrency + ", " +
				"fixing=" + this.fixing + ", " +
				"rateSourceFixing=" + this.rateSourceFixing +
			'}';
		}
	}
}
