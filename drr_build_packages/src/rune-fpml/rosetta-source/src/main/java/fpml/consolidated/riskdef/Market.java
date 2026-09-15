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
import fpml.consolidated.riskdef.meta.MarketMeta;
import fpml.consolidated.shared.PricingStructure;
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
 * Provision A collection of pricing inputs.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A collection of pricing inputs.
 *
 */
@RosettaDataType(value="Market", builder=Market.MarketBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Market", model="fpml", builder=Market.MarketBuilderImpl.class, version="2.1.1")
public interface Market extends RosettaModelObject {

	MarketMeta metaData = new MarketMeta();

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
	 * Provision The name of the market, e.g. the USDLIBOR market. Used for description and understandability.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name of the market, e.g. the USDLIBOR market. Used for description and understandability.
	 *
	 */
	String getName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A collection of benchmark instruments and quotes used as inputs to the pricing models.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A collection of benchmark instruments and quotes used as inputs to the pricing models.
	 *
	 */
	QuotedAssetSet getBenchmarkQuotes();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A collection of pricing inputs (curves, volatility matrices, etc.) used to represent the market.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A collection of pricing inputs (curves, volatility matrices, etc.) used to represent the market.
	 *
	 */
	List<? extends PricingStructure> getPricingStructure();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The values of the pricing structure used to represent the markets.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The values of the pricing structure used to represent the markets.
	 *
	 */
	List<? extends PricingStructureValuation> getPricingStructureValuation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The pricing structure used to quote a benchmark instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The pricing structure used to quote a benchmark instrument.
	 *
	 */
	List<? extends PricingMethod> getBenchmarkPricingMethod();

	/*********************** Build Methods  ***********************/
	Market build();
	
	Market.MarketBuilder toBuilder();
	
	static Market.MarketBuilder builder() {
		return new Market.MarketBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Market> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Market> getType() {
		return Market.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("benchmarkQuotes"), processor, QuotedAssetSet.class, getBenchmarkQuotes());
		processRosetta(path.newSubPath("pricingStructure"), processor, PricingStructure.class, getPricingStructure());
		processRosetta(path.newSubPath("pricingStructureValuation"), processor, PricingStructureValuation.class, getPricingStructureValuation());
		processRosetta(path.newSubPath("benchmarkPricingMethod"), processor, PricingMethod.class, getBenchmarkPricingMethod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarketBuilder extends Market, RosettaModelObjectBuilder {
		QuotedAssetSet.QuotedAssetSetBuilder getOrCreateBenchmarkQuotes();
		@Override
		QuotedAssetSet.QuotedAssetSetBuilder getBenchmarkQuotes();
		PricingStructure.PricingStructureBuilder getOrCreatePricingStructure(int index);
		@Override
		List<? extends PricingStructure.PricingStructureBuilder> getPricingStructure();
		PricingStructureValuation.PricingStructureValuationBuilder getOrCreatePricingStructureValuation(int index);
		@Override
		List<? extends PricingStructureValuation.PricingStructureValuationBuilder> getPricingStructureValuation();
		PricingMethod.PricingMethodBuilder getOrCreateBenchmarkPricingMethod(int index);
		@Override
		List<? extends PricingMethod.PricingMethodBuilder> getBenchmarkPricingMethod();
		Market.MarketBuilder setId(String id);
		Market.MarketBuilder setName(String name);
		Market.MarketBuilder setBenchmarkQuotes(QuotedAssetSet benchmarkQuotes);
		Market.MarketBuilder addPricingStructure(PricingStructure pricingStructure);
		Market.MarketBuilder addPricingStructure(PricingStructure pricingStructure, int idx);
		Market.MarketBuilder addPricingStructure(List<? extends PricingStructure> pricingStructure);
		Market.MarketBuilder setPricingStructure(List<? extends PricingStructure> pricingStructure);
		Market.MarketBuilder addPricingStructureValuation(PricingStructureValuation pricingStructureValuation);
		Market.MarketBuilder addPricingStructureValuation(PricingStructureValuation pricingStructureValuation, int idx);
		Market.MarketBuilder addPricingStructureValuation(List<? extends PricingStructureValuation> pricingStructureValuation);
		Market.MarketBuilder setPricingStructureValuation(List<? extends PricingStructureValuation> pricingStructureValuation);
		Market.MarketBuilder addBenchmarkPricingMethod(PricingMethod benchmarkPricingMethod);
		Market.MarketBuilder addBenchmarkPricingMethod(PricingMethod benchmarkPricingMethod, int idx);
		Market.MarketBuilder addBenchmarkPricingMethod(List<? extends PricingMethod> benchmarkPricingMethod);
		Market.MarketBuilder setBenchmarkPricingMethod(List<? extends PricingMethod> benchmarkPricingMethod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("benchmarkQuotes"), processor, QuotedAssetSet.QuotedAssetSetBuilder.class, getBenchmarkQuotes());
			processRosetta(path.newSubPath("pricingStructure"), processor, PricingStructure.PricingStructureBuilder.class, getPricingStructure());
			processRosetta(path.newSubPath("pricingStructureValuation"), processor, PricingStructureValuation.PricingStructureValuationBuilder.class, getPricingStructureValuation());
			processRosetta(path.newSubPath("benchmarkPricingMethod"), processor, PricingMethod.PricingMethodBuilder.class, getBenchmarkPricingMethod());
		}
		

		Market.MarketBuilder prune();
	}

	/*********************** Immutable Implementation of Market  ***********************/
	class MarketImpl implements Market {
		private final String id;
		private final String name;
		private final QuotedAssetSet benchmarkQuotes;
		private final List<? extends PricingStructure> pricingStructure;
		private final List<? extends PricingStructureValuation> pricingStructureValuation;
		private final List<? extends PricingMethod> benchmarkPricingMethod;
		
		protected MarketImpl(Market.MarketBuilder builder) {
			this.id = builder.getId();
			this.name = builder.getName();
			this.benchmarkQuotes = ofNullable(builder.getBenchmarkQuotes()).map(f->f.build()).orElse(null);
			this.pricingStructure = ofNullable(builder.getPricingStructure()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.pricingStructureValuation = ofNullable(builder.getPricingStructureValuation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.benchmarkPricingMethod = ofNullable(builder.getBenchmarkPricingMethod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("benchmarkQuotes")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("benchmarkQuotes")
		public QuotedAssetSet getBenchmarkQuotes() {
			return benchmarkQuotes;
		}
		
		@Override
		@RosettaAttribute("pricingStructure")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("pricingStructure")
		public List<? extends PricingStructure> getPricingStructure() {
			return pricingStructure;
		}
		
		@Override
		@RosettaAttribute("pricingStructureValuation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("pricingStructureValuation")
		public List<? extends PricingStructureValuation> getPricingStructureValuation() {
			return pricingStructureValuation;
		}
		
		@Override
		@RosettaAttribute("benchmarkPricingMethod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("benchmarkPricingMethod")
		public List<? extends PricingMethod> getBenchmarkPricingMethod() {
			return benchmarkPricingMethod;
		}
		
		@Override
		public Market build() {
			return this;
		}
		
		@Override
		public Market.MarketBuilder toBuilder() {
			Market.MarketBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Market.MarketBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getBenchmarkQuotes()).ifPresent(builder::setBenchmarkQuotes);
			ofNullable(getPricingStructure()).ifPresent(builder::setPricingStructure);
			ofNullable(getPricingStructureValuation()).ifPresent(builder::setPricingStructureValuation);
			ofNullable(getBenchmarkPricingMethod()).ifPresent(builder::setBenchmarkPricingMethod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Market _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(benchmarkQuotes, _that.getBenchmarkQuotes())) return false;
			if (!ListEquals.listEquals(pricingStructure, _that.getPricingStructure())) return false;
			if (!ListEquals.listEquals(pricingStructureValuation, _that.getPricingStructureValuation())) return false;
			if (!ListEquals.listEquals(benchmarkPricingMethod, _that.getBenchmarkPricingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (benchmarkQuotes != null ? benchmarkQuotes.hashCode() : 0);
			_result = 31 * _result + (pricingStructure != null ? pricingStructure.hashCode() : 0);
			_result = 31 * _result + (pricingStructureValuation != null ? pricingStructureValuation.hashCode() : 0);
			_result = 31 * _result + (benchmarkPricingMethod != null ? benchmarkPricingMethod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Market {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"benchmarkQuotes=" + this.benchmarkQuotes + ", " +
				"pricingStructure=" + this.pricingStructure + ", " +
				"pricingStructureValuation=" + this.pricingStructureValuation + ", " +
				"benchmarkPricingMethod=" + this.benchmarkPricingMethod +
			'}';
		}
	}

	/*********************** Builder Implementation of Market  ***********************/
	class MarketBuilderImpl implements Market.MarketBuilder {
	
		protected String id;
		protected String name;
		protected QuotedAssetSet.QuotedAssetSetBuilder benchmarkQuotes;
		protected List<PricingStructure.PricingStructureBuilder> pricingStructure = new ArrayList<>();
		protected List<PricingStructureValuation.PricingStructureValuationBuilder> pricingStructureValuation = new ArrayList<>();
		protected List<PricingMethod.PricingMethodBuilder> benchmarkPricingMethod = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("benchmarkQuotes")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("benchmarkQuotes")
		public QuotedAssetSet.QuotedAssetSetBuilder getBenchmarkQuotes() {
			return benchmarkQuotes;
		}
		
		@Override
		public QuotedAssetSet.QuotedAssetSetBuilder getOrCreateBenchmarkQuotes() {
			QuotedAssetSet.QuotedAssetSetBuilder result;
			if (benchmarkQuotes!=null) {
				result = benchmarkQuotes;
			}
			else {
				result = benchmarkQuotes = QuotedAssetSet.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingStructure")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("pricingStructure")
		public List<? extends PricingStructure.PricingStructureBuilder> getPricingStructure() {
			return pricingStructure;
		}
		
		@Override
		public PricingStructure.PricingStructureBuilder getOrCreatePricingStructure(int index) {
			if (pricingStructure==null) {
				this.pricingStructure = new ArrayList<>();
			}
			return getIndex(pricingStructure, index, () -> {
						PricingStructure.PricingStructureBuilder newPricingStructure = PricingStructure.builder();
						return newPricingStructure;
					});
		}
		
		@Override
		@RosettaAttribute("pricingStructureValuation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("pricingStructureValuation")
		public List<? extends PricingStructureValuation.PricingStructureValuationBuilder> getPricingStructureValuation() {
			return pricingStructureValuation;
		}
		
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder getOrCreatePricingStructureValuation(int index) {
			if (pricingStructureValuation==null) {
				this.pricingStructureValuation = new ArrayList<>();
			}
			return getIndex(pricingStructureValuation, index, () -> {
						PricingStructureValuation.PricingStructureValuationBuilder newPricingStructureValuation = PricingStructureValuation.builder();
						return newPricingStructureValuation;
					});
		}
		
		@Override
		@RosettaAttribute("benchmarkPricingMethod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("benchmarkPricingMethod")
		public List<? extends PricingMethod.PricingMethodBuilder> getBenchmarkPricingMethod() {
			return benchmarkPricingMethod;
		}
		
		@Override
		public PricingMethod.PricingMethodBuilder getOrCreateBenchmarkPricingMethod(int index) {
			if (benchmarkPricingMethod==null) {
				this.benchmarkPricingMethod = new ArrayList<>();
			}
			return getIndex(benchmarkPricingMethod, index, () -> {
						PricingMethod.PricingMethodBuilder newBenchmarkPricingMethod = PricingMethod.builder();
						return newBenchmarkPricingMethod;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Market.MarketBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public Market.MarketBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("benchmarkQuotes")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("benchmarkQuotes")
		@Override
		public Market.MarketBuilder setBenchmarkQuotes(QuotedAssetSet _benchmarkQuotes) {
			this.benchmarkQuotes = _benchmarkQuotes == null ? null : _benchmarkQuotes.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pricingStructure")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("pricingStructure")
		@Override
		public Market.MarketBuilder addPricingStructure(PricingStructure _pricingStructure) {
			if (_pricingStructure != null) {
				this.pricingStructure.add(_pricingStructure.toBuilder());
			}
			return this;
		}
		
		@Override
		public Market.MarketBuilder addPricingStructure(PricingStructure _pricingStructure, int idx) {
			getIndex(this.pricingStructure, idx, () -> _pricingStructure.toBuilder());
			return this;
		}
		
		@Override
		public Market.MarketBuilder addPricingStructure(List<? extends PricingStructure> pricingStructures) {
			if (pricingStructures != null) {
				for (final PricingStructure toAdd : pricingStructures) {
					this.pricingStructure.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("pricingStructure")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("pricingStructure")
		@Override
		public Market.MarketBuilder setPricingStructure(List<? extends PricingStructure> pricingStructures) {
			if (pricingStructures == null) {
				this.pricingStructure = new ArrayList<>();
			} else {
				this.pricingStructure = pricingStructures.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("pricingStructureValuation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("pricingStructureValuation")
		@Override
		public Market.MarketBuilder addPricingStructureValuation(PricingStructureValuation _pricingStructureValuation) {
			if (_pricingStructureValuation != null) {
				this.pricingStructureValuation.add(_pricingStructureValuation.toBuilder());
			}
			return this;
		}
		
		@Override
		public Market.MarketBuilder addPricingStructureValuation(PricingStructureValuation _pricingStructureValuation, int idx) {
			getIndex(this.pricingStructureValuation, idx, () -> _pricingStructureValuation.toBuilder());
			return this;
		}
		
		@Override
		public Market.MarketBuilder addPricingStructureValuation(List<? extends PricingStructureValuation> pricingStructureValuations) {
			if (pricingStructureValuations != null) {
				for (final PricingStructureValuation toAdd : pricingStructureValuations) {
					this.pricingStructureValuation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("pricingStructureValuation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("pricingStructureValuation")
		@Override
		public Market.MarketBuilder setPricingStructureValuation(List<? extends PricingStructureValuation> pricingStructureValuations) {
			if (pricingStructureValuations == null) {
				this.pricingStructureValuation = new ArrayList<>();
			} else {
				this.pricingStructureValuation = pricingStructureValuations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("benchmarkPricingMethod")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("benchmarkPricingMethod")
		@Override
		public Market.MarketBuilder addBenchmarkPricingMethod(PricingMethod _benchmarkPricingMethod) {
			if (_benchmarkPricingMethod != null) {
				this.benchmarkPricingMethod.add(_benchmarkPricingMethod.toBuilder());
			}
			return this;
		}
		
		@Override
		public Market.MarketBuilder addBenchmarkPricingMethod(PricingMethod _benchmarkPricingMethod, int idx) {
			getIndex(this.benchmarkPricingMethod, idx, () -> _benchmarkPricingMethod.toBuilder());
			return this;
		}
		
		@Override
		public Market.MarketBuilder addBenchmarkPricingMethod(List<? extends PricingMethod> benchmarkPricingMethods) {
			if (benchmarkPricingMethods != null) {
				for (final PricingMethod toAdd : benchmarkPricingMethods) {
					this.benchmarkPricingMethod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("benchmarkPricingMethod")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("benchmarkPricingMethod")
		@Override
		public Market.MarketBuilder setBenchmarkPricingMethod(List<? extends PricingMethod> benchmarkPricingMethods) {
			if (benchmarkPricingMethods == null) {
				this.benchmarkPricingMethod = new ArrayList<>();
			} else {
				this.benchmarkPricingMethod = benchmarkPricingMethods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Market build() {
			return new Market.MarketImpl(this);
		}
		
		@Override
		public Market.MarketBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Market.MarketBuilder prune() {
			if (benchmarkQuotes!=null && !benchmarkQuotes.prune().hasData()) benchmarkQuotes = null;
			pricingStructure = pricingStructure.stream().filter(b->b!=null).<PricingStructure.PricingStructureBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			pricingStructureValuation = pricingStructureValuation.stream().filter(b->b!=null).<PricingStructureValuation.PricingStructureValuationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			benchmarkPricingMethod = benchmarkPricingMethod.stream().filter(b->b!=null).<PricingMethod.PricingMethodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getName()!=null) return true;
			if (getBenchmarkQuotes()!=null && getBenchmarkQuotes().hasData()) return true;
			if (getPricingStructure()!=null && getPricingStructure().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPricingStructureValuation()!=null && getPricingStructureValuation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBenchmarkPricingMethod()!=null && getBenchmarkPricingMethod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Market.MarketBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Market.MarketBuilder o = (Market.MarketBuilder) other;
			
			merger.mergeRosetta(getBenchmarkQuotes(), o.getBenchmarkQuotes(), this::setBenchmarkQuotes);
			merger.mergeRosetta(getPricingStructure(), o.getPricingStructure(), this::getOrCreatePricingStructure);
			merger.mergeRosetta(getPricingStructureValuation(), o.getPricingStructureValuation(), this::getOrCreatePricingStructureValuation);
			merger.mergeRosetta(getBenchmarkPricingMethod(), o.getBenchmarkPricingMethod(), this::getOrCreateBenchmarkPricingMethod);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Market _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(benchmarkQuotes, _that.getBenchmarkQuotes())) return false;
			if (!ListEquals.listEquals(pricingStructure, _that.getPricingStructure())) return false;
			if (!ListEquals.listEquals(pricingStructureValuation, _that.getPricingStructureValuation())) return false;
			if (!ListEquals.listEquals(benchmarkPricingMethod, _that.getBenchmarkPricingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (benchmarkQuotes != null ? benchmarkQuotes.hashCode() : 0);
			_result = 31 * _result + (pricingStructure != null ? pricingStructure.hashCode() : 0);
			_result = 31 * _result + (pricingStructureValuation != null ? pricingStructureValuation.hashCode() : 0);
			_result = 31 * _result + (benchmarkPricingMethod != null ? benchmarkPricingMethod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarketBuilder {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"benchmarkQuotes=" + this.benchmarkQuotes + ", " +
				"pricingStructure=" + this.pricingStructure + ", " +
				"pricingStructureValuation=" + this.pricingStructureValuation + ", " +
				"benchmarkPricingMethod=" + this.benchmarkPricingMethod +
			'}';
		}
	}
}
