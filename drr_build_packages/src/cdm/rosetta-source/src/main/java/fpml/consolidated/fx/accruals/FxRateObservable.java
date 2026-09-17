package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fx.accruals.meta.FxRateObservableMeta;
import fpml.consolidated.shared.FxInformationSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
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
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="FxRateObservable", builder=FxRateObservable.FxRateObservableBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxRateObservable", model="fpml", builder=FxRateObservable.FxRateObservableBuilderImpl.class, version="2.1.1")
public interface FxRateObservable extends RosettaModelObject {

	FxRateObservableMeta metaData = new FxRateObservableMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision FX rate to be observed. The Quoted Currency Pair that is used across the product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision FX rate to be observed. The Quoted Currency Pair that is used across the product.
	 *
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Information source for fixing the exchange rate. It is the same for all fixing periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Information source for fixing the exchange rate. It is the same for all fixing periods.
	 *
	 */
	FxInformationSource getInformationSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Contains the currency exchange rates information used to cross between the traded currencies for non-base currency FX contracts.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Contains the currency exchange rates information used to cross between the traded currencies for non-base currency FX contracts.
	 *
	 */
	List<? extends FxCrossRateObservable> getCrossRate();

	/*********************** Build Methods  ***********************/
	FxRateObservable build();
	
	FxRateObservable.FxRateObservableBuilder toBuilder();
	
	static FxRateObservable.FxRateObservableBuilder builder() {
		return new FxRateObservable.FxRateObservableBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxRateObservable> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxRateObservable> getType() {
		return FxRateObservable.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("informationSource"), processor, FxInformationSource.class, getInformationSource());
		processRosetta(path.newSubPath("crossRate"), processor, FxCrossRateObservable.class, getCrossRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxRateObservableBuilder extends FxRateObservable, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		FxInformationSource.FxInformationSourceBuilder getOrCreateInformationSource();
		@Override
		FxInformationSource.FxInformationSourceBuilder getInformationSource();
		FxCrossRateObservable.FxCrossRateObservableBuilder getOrCreateCrossRate(int index);
		@Override
		List<? extends FxCrossRateObservable.FxCrossRateObservableBuilder> getCrossRate();
		FxRateObservable.FxRateObservableBuilder setId(String id);
		FxRateObservable.FxRateObservableBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxRateObservable.FxRateObservableBuilder setInformationSource(FxInformationSource informationSource);
		FxRateObservable.FxRateObservableBuilder addCrossRate(FxCrossRateObservable crossRate);
		FxRateObservable.FxRateObservableBuilder addCrossRate(FxCrossRateObservable crossRate, int idx);
		FxRateObservable.FxRateObservableBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRate);
		FxRateObservable.FxRateObservableBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("informationSource"), processor, FxInformationSource.FxInformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("crossRate"), processor, FxCrossRateObservable.FxCrossRateObservableBuilder.class, getCrossRate());
		}
		

		FxRateObservable.FxRateObservableBuilder prune();
	}

	/*********************** Immutable Implementation of FxRateObservable  ***********************/
	class FxRateObservableImpl implements FxRateObservable {
		private final String id;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final FxInformationSource informationSource;
		private final List<? extends FxCrossRateObservable> crossRate;
		
		protected FxRateObservableImpl(FxRateObservable.FxRateObservableBuilder builder) {
			this.id = builder.getId();
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.informationSource = ofNullable(builder.getInformationSource()).map(f->f.build()).orElse(null);
			this.crossRate = ofNullable(builder.getCrossRate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("informationSource")
		public FxInformationSource getInformationSource() {
			return informationSource;
		}
		
		@Override
		@RosettaAttribute("crossRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("crossRate")
		public List<? extends FxCrossRateObservable> getCrossRate() {
			return crossRate;
		}
		
		@Override
		public FxRateObservable build() {
			return this;
		}
		
		@Override
		public FxRateObservable.FxRateObservableBuilder toBuilder() {
			FxRateObservable.FxRateObservableBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxRateObservable.FxRateObservableBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
			ofNullable(getCrossRate()).ifPresent(builder::setCrossRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxRateObservable _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!ListEquals.listEquals(crossRate, _that.getCrossRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (crossRate != null ? crossRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateObservable {" +
				"id=" + this.id + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"informationSource=" + this.informationSource + ", " +
				"crossRate=" + this.crossRate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxRateObservable  ***********************/
	class FxRateObservableBuilderImpl implements FxRateObservable.FxRateObservableBuilder {
	
		protected String id;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected FxInformationSource.FxInformationSourceBuilder informationSource;
		protected List<FxCrossRateObservable.FxCrossRateObservableBuilder> crossRate = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("informationSource")
		public FxInformationSource.FxInformationSourceBuilder getInformationSource() {
			return informationSource;
		}
		
		@Override
		public FxInformationSource.FxInformationSourceBuilder getOrCreateInformationSource() {
			FxInformationSource.FxInformationSourceBuilder result;
			if (informationSource!=null) {
				result = informationSource;
			}
			else {
				result = informationSource = FxInformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("crossRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("crossRate")
		public List<? extends FxCrossRateObservable.FxCrossRateObservableBuilder> getCrossRate() {
			return crossRate;
		}
		
		@Override
		public FxCrossRateObservable.FxCrossRateObservableBuilder getOrCreateCrossRate(int index) {
			if (crossRate==null) {
				this.crossRate = new ArrayList<>();
			}
			return getIndex(crossRate, index, () -> {
						FxCrossRateObservable.FxCrossRateObservableBuilder newCrossRate = FxCrossRateObservable.builder();
						return newCrossRate;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxRateObservable.FxRateObservableBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxRateObservable.FxRateObservableBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("informationSource")
		@Override
		public FxRateObservable.FxRateObservableBuilder setInformationSource(FxInformationSource _informationSource) {
			this.informationSource = _informationSource == null ? null : _informationSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("crossRate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("crossRate")
		@Override
		public FxRateObservable.FxRateObservableBuilder addCrossRate(FxCrossRateObservable _crossRate) {
			if (_crossRate != null) {
				this.crossRate.add(_crossRate.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxRateObservable.FxRateObservableBuilder addCrossRate(FxCrossRateObservable _crossRate, int idx) {
			getIndex(this.crossRate, idx, () -> _crossRate.toBuilder());
			return this;
		}
		
		@Override
		public FxRateObservable.FxRateObservableBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRates) {
			if (crossRates != null) {
				for (final FxCrossRateObservable toAdd : crossRates) {
					this.crossRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("crossRate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("crossRate")
		@Override
		public FxRateObservable.FxRateObservableBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRates) {
			if (crossRates == null) {
				this.crossRate = new ArrayList<>();
			} else {
				this.crossRate = crossRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxRateObservable build() {
			return new FxRateObservable.FxRateObservableImpl(this);
		}
		
		@Override
		public FxRateObservable.FxRateObservableBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateObservable.FxRateObservableBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (informationSource!=null && !informationSource.prune().hasData()) informationSource = null;
			crossRate = crossRate.stream().filter(b->b!=null).<FxCrossRateObservable.FxCrossRateObservableBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getInformationSource()!=null && getInformationSource().hasData()) return true;
			if (getCrossRate()!=null && getCrossRate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateObservable.FxRateObservableBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxRateObservable.FxRateObservableBuilder o = (FxRateObservable.FxRateObservableBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::setInformationSource);
			merger.mergeRosetta(getCrossRate(), o.getCrossRate(), this::getOrCreateCrossRate);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxRateObservable _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!ListEquals.listEquals(crossRate, _that.getCrossRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (crossRate != null ? crossRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRateObservableBuilder {" +
				"id=" + this.id + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"informationSource=" + this.informationSource + ", " +
				"crossRate=" + this.crossRate +
			'}';
		}
	}
}
