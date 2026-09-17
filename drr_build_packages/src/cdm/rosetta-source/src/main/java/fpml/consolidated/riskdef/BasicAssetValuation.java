package fpml.consolidated.riskdef;

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
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.riskdef.meta.BasicAssetValuationMeta;
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
 * Provision A structure that holds a set of measures about an asset.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that holds a set of measures about an asset.
 *
 */
@RosettaDataType(value="BasicAssetValuation", builder=BasicAssetValuation.BasicAssetValuationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BasicAssetValuation", model="fpml", builder=BasicAssetValuation.BasicAssetValuationBuilderImpl.class, version="2.1.1")
public interface BasicAssetValuation extends Valuation {

	BasicAssetValuationMeta metaData = new BasicAssetValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision One or more numerical measures relating to the asset, possibly together with sensitivities of that measure to pricing inputs
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision One or more numerical measures relating to the asset, possibly together with sensitivities of that measure to pricing inputs
	 *
	 */
	List<? extends BasicQuotation> getQuote();

	/*********************** Build Methods  ***********************/
	BasicAssetValuation build();
	
	BasicAssetValuation.BasicAssetValuationBuilder toBuilder();
	
	static BasicAssetValuation.BasicAssetValuationBuilder builder() {
		return new BasicAssetValuation.BasicAssetValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasicAssetValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BasicAssetValuation> getType() {
		return BasicAssetValuation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.class, getObjectReference());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processRosetta(path.newSubPath("quote"), processor, BasicQuotation.class, getQuote());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasicAssetValuationBuilder extends BasicAssetValuation, Valuation.ValuationBuilder {
		BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int index);
		@Override
		List<? extends BasicQuotation.BasicQuotationBuilder> getQuote();
		@Override
		BasicAssetValuation.BasicAssetValuationBuilder setId(String id);
		@Override
		BasicAssetValuation.BasicAssetValuationBuilder setDefinitionRef(String definitionRef);
		@Override
		BasicAssetValuation.BasicAssetValuationBuilder setObjectReference(AnyAssetReference objectReference);
		@Override
		BasicAssetValuation.BasicAssetValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		BasicAssetValuation.BasicAssetValuationBuilder addQuote(BasicQuotation quote);
		BasicAssetValuation.BasicAssetValuationBuilder addQuote(BasicQuotation quote, int idx);
		BasicAssetValuation.BasicAssetValuationBuilder addQuote(List<? extends BasicQuotation> quote);
		BasicAssetValuation.BasicAssetValuationBuilder setQuote(List<? extends BasicQuotation> quote);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
			processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getObjectReference());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processRosetta(path.newSubPath("quote"), processor, BasicQuotation.BasicQuotationBuilder.class, getQuote());
		}
		

		BasicAssetValuation.BasicAssetValuationBuilder prune();
	}

	/*********************** Immutable Implementation of BasicAssetValuation  ***********************/
	class BasicAssetValuationImpl extends Valuation.ValuationImpl implements BasicAssetValuation {
		private final List<? extends BasicQuotation> quote;
		
		protected BasicAssetValuationImpl(BasicAssetValuation.BasicAssetValuationBuilder builder) {
			super(builder);
			this.quote = ofNullable(builder.getQuote()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quote")
		public List<? extends BasicQuotation> getQuote() {
			return quote;
		}
		
		@Override
		public BasicAssetValuation build() {
			return this;
		}
		
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder toBuilder() {
			BasicAssetValuation.BasicAssetValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasicAssetValuation.BasicAssetValuationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuote()).ifPresent(builder::setQuote);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BasicAssetValuation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasicAssetValuation {" +
				"quote=" + this.quote +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BasicAssetValuation  ***********************/
	class BasicAssetValuationBuilderImpl extends Valuation.ValuationBuilderImpl implements BasicAssetValuation.BasicAssetValuationBuilder {
	
		protected List<BasicQuotation.BasicQuotationBuilder> quote = new ArrayList<>();
		
		@Override
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quote")
		public List<? extends BasicQuotation.BasicQuotationBuilder> getQuote() {
			return quote;
		}
		
		@Override
		public BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int index) {
			if (quote==null) {
				this.quote = new ArrayList<>();
			}
			return getIndex(quote, index, () -> {
						BasicQuotation.BasicQuotationBuilder newQuote = BasicQuotation.builder();
						return newQuote;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("definitionRef")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definitionRef")
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder setDefinitionRef(String _definitionRef) {
			this.definitionRef = _definitionRef == null ? null : _definitionRef;
			return this;
		}
		
		@RosettaAttribute("objectReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("objectReference")
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder setObjectReference(AnyAssetReference _objectReference) {
			this.objectReference = _objectReference == null ? null : _objectReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationScenarioReference")
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder setValuationScenarioReference(ValuationScenarioReference _valuationScenarioReference) {
			this.valuationScenarioReference = _valuationScenarioReference == null ? null : _valuationScenarioReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder addQuote(BasicQuotation _quote) {
			if (_quote != null) {
				this.quote.add(_quote.toBuilder());
			}
			return this;
		}
		
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder addQuote(BasicQuotation _quote, int idx) {
			getIndex(this.quote, idx, () -> _quote.toBuilder());
			return this;
		}
		
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder addQuote(List<? extends BasicQuotation> quotes) {
			if (quotes != null) {
				for (final BasicQuotation toAdd : quotes) {
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
		public BasicAssetValuation.BasicAssetValuationBuilder setQuote(List<? extends BasicQuotation> quotes) {
			if (quotes == null) {
				this.quote = new ArrayList<>();
			} else {
				this.quote = quotes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public BasicAssetValuation build() {
			return new BasicAssetValuation.BasicAssetValuationImpl(this);
		}
		
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder prune() {
			super.prune();
			quote = quote.stream().filter(b->b!=null).<BasicQuotation.BasicQuotationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuote()!=null && getQuote().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			BasicAssetValuation.BasicAssetValuationBuilder o = (BasicAssetValuation.BasicAssetValuationBuilder) other;
			
			merger.mergeRosetta(getQuote(), o.getQuote(), this::getOrCreateQuote);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BasicAssetValuation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasicAssetValuationBuilder {" +
				"quote=" + this.quote +
			'}' + " " + super.toString();
		}
	}
}
