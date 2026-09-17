package fpml.consolidated.valuation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.asset.AnyAssetReference;
import fpml.consolidated.riskdef.Valuation;
import fpml.consolidated.riskdef.ValuationScenarioReference;
import fpml.consolidated.shared.FxRate;
import fpml.consolidated.valuation.meta.AssetValuationMeta;
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
 * Provision A structure that holds a set of measures about an asset, including possibly their sensitivities.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that holds a set of measures about an asset, including possibly their sensitivities.
 *
 */
@RosettaDataType(value="AssetValuation", builder=AssetValuation.AssetValuationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AssetValuation", model="fpml", builder=AssetValuation.AssetValuationBuilderImpl.class, version="2.1.1")
public interface AssetValuation extends Valuation {

	AssetValuationMeta metaData = new AssetValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision One or more numerical measures relating to the asset, possibly together with sensitivities of that measure to pricing inputs.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision One or more numerical measures relating to the asset, possibly together with sensitivities of that measure to pricing inputs.
	 *
	 */
	List<? extends Quotation> getQuote();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the rate of a currency conversion that may have been used to compute valuations.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the rate of a currency conversion that may have been used to compute valuations.
	 *
	 */
	List<? extends FxRate> getFxRate();

	/*********************** Build Methods  ***********************/
	AssetValuation build();
	
	AssetValuation.AssetValuationBuilder toBuilder();
	
	static AssetValuation.AssetValuationBuilder builder() {
		return new AssetValuation.AssetValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetValuation> getType() {
		return AssetValuation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.class, getObjectReference());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processRosetta(path.newSubPath("quote"), processor, Quotation.class, getQuote());
		processRosetta(path.newSubPath("fxRate"), processor, FxRate.class, getFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetValuationBuilder extends AssetValuation, Valuation.ValuationBuilder {
		Quotation.QuotationBuilder getOrCreateQuote(int index);
		@Override
		List<? extends Quotation.QuotationBuilder> getQuote();
		FxRate.FxRateBuilder getOrCreateFxRate(int index);
		@Override
		List<? extends FxRate.FxRateBuilder> getFxRate();
		@Override
		AssetValuation.AssetValuationBuilder setId(String id);
		@Override
		AssetValuation.AssetValuationBuilder setDefinitionRef(String definitionRef);
		@Override
		AssetValuation.AssetValuationBuilder setObjectReference(AnyAssetReference objectReference);
		@Override
		AssetValuation.AssetValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		AssetValuation.AssetValuationBuilder addQuote(Quotation quote);
		AssetValuation.AssetValuationBuilder addQuote(Quotation quote, int idx);
		AssetValuation.AssetValuationBuilder addQuote(List<? extends Quotation> quote);
		AssetValuation.AssetValuationBuilder setQuote(List<? extends Quotation> quote);
		AssetValuation.AssetValuationBuilder addFxRate(FxRate fxRate);
		AssetValuation.AssetValuationBuilder addFxRate(FxRate fxRate, int idx);
		AssetValuation.AssetValuationBuilder addFxRate(List<? extends FxRate> fxRate);
		AssetValuation.AssetValuationBuilder setFxRate(List<? extends FxRate> fxRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
			processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getObjectReference());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processRosetta(path.newSubPath("quote"), processor, Quotation.QuotationBuilder.class, getQuote());
			processRosetta(path.newSubPath("fxRate"), processor, FxRate.FxRateBuilder.class, getFxRate());
		}
		

		AssetValuation.AssetValuationBuilder prune();
	}

	/*********************** Immutable Implementation of AssetValuation  ***********************/
	class AssetValuationImpl extends Valuation.ValuationImpl implements AssetValuation {
		private final List<? extends Quotation> quote;
		private final List<? extends FxRate> fxRate;
		
		protected AssetValuationImpl(AssetValuation.AssetValuationBuilder builder) {
			super(builder);
			this.quote = ofNullable(builder.getQuote()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fxRate = ofNullable(builder.getFxRate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quote")
		public List<? extends Quotation> getQuote() {
			return quote;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fxRate")
		public List<? extends FxRate> getFxRate() {
			return fxRate;
		}
		
		@Override
		public AssetValuation build() {
			return this;
		}
		
		@Override
		public AssetValuation.AssetValuationBuilder toBuilder() {
			AssetValuation.AssetValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetValuation.AssetValuationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuote()).ifPresent(builder::setQuote);
			ofNullable(getFxRate()).ifPresent(builder::setFxRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AssetValuation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!ListEquals.listEquals(fxRate, _that.getFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetValuation {" +
				"quote=" + this.quote + ", " +
				"fxRate=" + this.fxRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AssetValuation  ***********************/
	class AssetValuationBuilderImpl extends Valuation.ValuationBuilderImpl implements AssetValuation.AssetValuationBuilder {
	
		protected List<Quotation.QuotationBuilder> quote = new ArrayList<>();
		protected List<FxRate.FxRateBuilder> fxRate = new ArrayList<>();
		
		@Override
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quote")
		public List<? extends Quotation.QuotationBuilder> getQuote() {
			return quote;
		}
		
		@Override
		public Quotation.QuotationBuilder getOrCreateQuote(int index) {
			if (quote==null) {
				this.quote = new ArrayList<>();
			}
			return getIndex(quote, index, () -> {
						Quotation.QuotationBuilder newQuote = Quotation.builder();
						return newQuote;
					});
		}
		
		@Override
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fxRate")
		public List<? extends FxRate.FxRateBuilder> getFxRate() {
			return fxRate;
		}
		
		@Override
		public FxRate.FxRateBuilder getOrCreateFxRate(int index) {
			if (fxRate==null) {
				this.fxRate = new ArrayList<>();
			}
			return getIndex(fxRate, index, () -> {
						FxRate.FxRateBuilder newFxRate = FxRate.builder();
						return newFxRate;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public AssetValuation.AssetValuationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("definitionRef")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definitionRef")
		@Override
		public AssetValuation.AssetValuationBuilder setDefinitionRef(String _definitionRef) {
			this.definitionRef = _definitionRef == null ? null : _definitionRef;
			return this;
		}
		
		@RosettaAttribute("objectReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("objectReference")
		@Override
		public AssetValuation.AssetValuationBuilder setObjectReference(AnyAssetReference _objectReference) {
			this.objectReference = _objectReference == null ? null : _objectReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationScenarioReference")
		@Override
		public AssetValuation.AssetValuationBuilder setValuationScenarioReference(ValuationScenarioReference _valuationScenarioReference) {
			this.valuationScenarioReference = _valuationScenarioReference == null ? null : _valuationScenarioReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public AssetValuation.AssetValuationBuilder addQuote(Quotation _quote) {
			if (_quote != null) {
				this.quote.add(_quote.toBuilder());
			}
			return this;
		}
		
		@Override
		public AssetValuation.AssetValuationBuilder addQuote(Quotation _quote, int idx) {
			getIndex(this.quote, idx, () -> _quote.toBuilder());
			return this;
		}
		
		@Override
		public AssetValuation.AssetValuationBuilder addQuote(List<? extends Quotation> quotes) {
			if (quotes != null) {
				for (final Quotation toAdd : quotes) {
					this.quote.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public AssetValuation.AssetValuationBuilder setQuote(List<? extends Quotation> quotes) {
			if (quotes == null) {
				this.quote = new ArrayList<>();
			} else {
				this.quote = quotes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fxRate")
		@Override
		public AssetValuation.AssetValuationBuilder addFxRate(FxRate _fxRate) {
			if (_fxRate != null) {
				this.fxRate.add(_fxRate.toBuilder());
			}
			return this;
		}
		
		@Override
		public AssetValuation.AssetValuationBuilder addFxRate(FxRate _fxRate, int idx) {
			getIndex(this.fxRate, idx, () -> _fxRate.toBuilder());
			return this;
		}
		
		@Override
		public AssetValuation.AssetValuationBuilder addFxRate(List<? extends FxRate> fxRates) {
			if (fxRates != null) {
				for (final FxRate toAdd : fxRates) {
					this.fxRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fxRate")
		@Override
		public AssetValuation.AssetValuationBuilder setFxRate(List<? extends FxRate> fxRates) {
			if (fxRates == null) {
				this.fxRate = new ArrayList<>();
			} else {
				this.fxRate = fxRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AssetValuation build() {
			return new AssetValuation.AssetValuationImpl(this);
		}
		
		@Override
		public AssetValuation.AssetValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetValuation.AssetValuationBuilder prune() {
			super.prune();
			quote = quote.stream().filter(b->b!=null).<Quotation.QuotationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			fxRate = fxRate.stream().filter(b->b!=null).<FxRate.FxRateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuote()!=null && getQuote().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFxRate()!=null && getFxRate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetValuation.AssetValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AssetValuation.AssetValuationBuilder o = (AssetValuation.AssetValuationBuilder) other;
			
			merger.mergeRosetta(getQuote(), o.getQuote(), this::getOrCreateQuote);
			merger.mergeRosetta(getFxRate(), o.getFxRate(), this::getOrCreateFxRate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AssetValuation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!ListEquals.listEquals(fxRate, _that.getFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetValuationBuilder {" +
				"quote=" + this.quote + ", " +
				"fxRate=" + this.fxRate +
			'}' + " " + super.toString();
		}
	}
}
