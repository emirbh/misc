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
import fpml.consolidated.riskdef.meta.QuotedAssetSetMeta;
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
 * Provision A collection of quoted assets.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A collection of quoted assets.
 *
 */
@RosettaDataType(value="QuotedAssetSet", builder=QuotedAssetSet.QuotedAssetSetBuilderImpl.class, version="2.1.1")
@RuneDataType(value="QuotedAssetSet", model="fpml", builder=QuotedAssetSet.QuotedAssetSetBuilderImpl.class, version="2.1.1")
public interface QuotedAssetSet extends RosettaModelObject {

	QuotedAssetSetMeta metaData = new QuotedAssetSetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A collection of instruments used as a basis for quotation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A collection of instruments used as a basis for quotation.
	 *
	 */
	InstrumentSet getInstrumentSet();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A collection of valuations (quotes) for the assets needed in the set. Normally these quotes will be for the underlying assets listed above, but they don't necesarily have to be.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A collection of valuations (quotes) for the assets needed in the set. Normally these quotes will be for the underlying assets listed above, but they don't necesarily have to be.
	 *
	 */
	List<? extends BasicAssetValuation> getAssetQuote();

	/*********************** Build Methods  ***********************/
	QuotedAssetSet build();
	
	QuotedAssetSet.QuotedAssetSetBuilder toBuilder();
	
	static QuotedAssetSet.QuotedAssetSetBuilder builder() {
		return new QuotedAssetSet.QuotedAssetSetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QuotedAssetSet> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends QuotedAssetSet> getType() {
		return QuotedAssetSet.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("instrumentSet"), processor, InstrumentSet.class, getInstrumentSet());
		processRosetta(path.newSubPath("assetQuote"), processor, BasicAssetValuation.class, getAssetQuote());
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuotedAssetSetBuilder extends QuotedAssetSet, RosettaModelObjectBuilder {
		InstrumentSet.InstrumentSetBuilder getOrCreateInstrumentSet();
		@Override
		InstrumentSet.InstrumentSetBuilder getInstrumentSet();
		BasicAssetValuation.BasicAssetValuationBuilder getOrCreateAssetQuote(int index);
		@Override
		List<? extends BasicAssetValuation.BasicAssetValuationBuilder> getAssetQuote();
		QuotedAssetSet.QuotedAssetSetBuilder setInstrumentSet(InstrumentSet instrumentSet);
		QuotedAssetSet.QuotedAssetSetBuilder addAssetQuote(BasicAssetValuation assetQuote);
		QuotedAssetSet.QuotedAssetSetBuilder addAssetQuote(BasicAssetValuation assetQuote, int idx);
		QuotedAssetSet.QuotedAssetSetBuilder addAssetQuote(List<? extends BasicAssetValuation> assetQuote);
		QuotedAssetSet.QuotedAssetSetBuilder setAssetQuote(List<? extends BasicAssetValuation> assetQuote);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("instrumentSet"), processor, InstrumentSet.InstrumentSetBuilder.class, getInstrumentSet());
			processRosetta(path.newSubPath("assetQuote"), processor, BasicAssetValuation.BasicAssetValuationBuilder.class, getAssetQuote());
		}
		

		QuotedAssetSet.QuotedAssetSetBuilder prune();
	}

	/*********************** Immutable Implementation of QuotedAssetSet  ***********************/
	class QuotedAssetSetImpl implements QuotedAssetSet {
		private final InstrumentSet instrumentSet;
		private final List<? extends BasicAssetValuation> assetQuote;
		
		protected QuotedAssetSetImpl(QuotedAssetSet.QuotedAssetSetBuilder builder) {
			this.instrumentSet = ofNullable(builder.getInstrumentSet()).map(f->f.build()).orElse(null);
			this.assetQuote = ofNullable(builder.getAssetQuote()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("instrumentSet")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("instrumentSet")
		public InstrumentSet getInstrumentSet() {
			return instrumentSet;
		}
		
		@Override
		@RosettaAttribute("assetQuote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("assetQuote")
		public List<? extends BasicAssetValuation> getAssetQuote() {
			return assetQuote;
		}
		
		@Override
		public QuotedAssetSet build() {
			return this;
		}
		
		@Override
		public QuotedAssetSet.QuotedAssetSetBuilder toBuilder() {
			QuotedAssetSet.QuotedAssetSetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuotedAssetSet.QuotedAssetSetBuilder builder) {
			ofNullable(getInstrumentSet()).ifPresent(builder::setInstrumentSet);
			ofNullable(getAssetQuote()).ifPresent(builder::setAssetQuote);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuotedAssetSet _that = getType().cast(o);
		
			if (!Objects.equals(instrumentSet, _that.getInstrumentSet())) return false;
			if (!ListEquals.listEquals(assetQuote, _that.getAssetQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (instrumentSet != null ? instrumentSet.hashCode() : 0);
			_result = 31 * _result + (assetQuote != null ? assetQuote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuotedAssetSet {" +
				"instrumentSet=" + this.instrumentSet + ", " +
				"assetQuote=" + this.assetQuote +
			'}';
		}
	}

	/*********************** Builder Implementation of QuotedAssetSet  ***********************/
	class QuotedAssetSetBuilderImpl implements QuotedAssetSet.QuotedAssetSetBuilder {
	
		protected InstrumentSet.InstrumentSetBuilder instrumentSet;
		protected List<BasicAssetValuation.BasicAssetValuationBuilder> assetQuote = new ArrayList<>();
		
		@Override
		@RosettaAttribute("instrumentSet")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("instrumentSet")
		public InstrumentSet.InstrumentSetBuilder getInstrumentSet() {
			return instrumentSet;
		}
		
		@Override
		public InstrumentSet.InstrumentSetBuilder getOrCreateInstrumentSet() {
			InstrumentSet.InstrumentSetBuilder result;
			if (instrumentSet!=null) {
				result = instrumentSet;
			}
			else {
				result = instrumentSet = InstrumentSet.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assetQuote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("assetQuote")
		public List<? extends BasicAssetValuation.BasicAssetValuationBuilder> getAssetQuote() {
			return assetQuote;
		}
		
		@Override
		public BasicAssetValuation.BasicAssetValuationBuilder getOrCreateAssetQuote(int index) {
			if (assetQuote==null) {
				this.assetQuote = new ArrayList<>();
			}
			return getIndex(assetQuote, index, () -> {
						BasicAssetValuation.BasicAssetValuationBuilder newAssetQuote = BasicAssetValuation.builder();
						return newAssetQuote;
					});
		}
		
		@RosettaAttribute("instrumentSet")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("instrumentSet")
		@Override
		public QuotedAssetSet.QuotedAssetSetBuilder setInstrumentSet(InstrumentSet _instrumentSet) {
			this.instrumentSet = _instrumentSet == null ? null : _instrumentSet.toBuilder();
			return this;
		}
		
		@RosettaAttribute("assetQuote")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("assetQuote")
		@Override
		public QuotedAssetSet.QuotedAssetSetBuilder addAssetQuote(BasicAssetValuation _assetQuote) {
			if (_assetQuote != null) {
				this.assetQuote.add(_assetQuote.toBuilder());
			}
			return this;
		}
		
		@Override
		public QuotedAssetSet.QuotedAssetSetBuilder addAssetQuote(BasicAssetValuation _assetQuote, int idx) {
			getIndex(this.assetQuote, idx, () -> _assetQuote.toBuilder());
			return this;
		}
		
		@Override
		public QuotedAssetSet.QuotedAssetSetBuilder addAssetQuote(List<? extends BasicAssetValuation> assetQuotes) {
			if (assetQuotes != null) {
				for (final BasicAssetValuation toAdd : assetQuotes) {
					this.assetQuote.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("assetQuote")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("assetQuote")
		@Override
		public QuotedAssetSet.QuotedAssetSetBuilder setAssetQuote(List<? extends BasicAssetValuation> assetQuotes) {
			if (assetQuotes == null) {
				this.assetQuote = new ArrayList<>();
			} else {
				this.assetQuote = assetQuotes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public QuotedAssetSet build() {
			return new QuotedAssetSet.QuotedAssetSetImpl(this);
		}
		
		@Override
		public QuotedAssetSet.QuotedAssetSetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuotedAssetSet.QuotedAssetSetBuilder prune() {
			if (instrumentSet!=null && !instrumentSet.prune().hasData()) instrumentSet = null;
			assetQuote = assetQuote.stream().filter(b->b!=null).<BasicAssetValuation.BasicAssetValuationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInstrumentSet()!=null && getInstrumentSet().hasData()) return true;
			if (getAssetQuote()!=null && getAssetQuote().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuotedAssetSet.QuotedAssetSetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuotedAssetSet.QuotedAssetSetBuilder o = (QuotedAssetSet.QuotedAssetSetBuilder) other;
			
			merger.mergeRosetta(getInstrumentSet(), o.getInstrumentSet(), this::setInstrumentSet);
			merger.mergeRosetta(getAssetQuote(), o.getAssetQuote(), this::getOrCreateAssetQuote);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuotedAssetSet _that = getType().cast(o);
		
			if (!Objects.equals(instrumentSet, _that.getInstrumentSet())) return false;
			if (!ListEquals.listEquals(assetQuote, _that.getAssetQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (instrumentSet != null ? instrumentSet.hashCode() : 0);
			_result = 31 * _result + (assetQuote != null ? assetQuote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuotedAssetSetBuilder {" +
				"instrumentSet=" + this.instrumentSet + ", " +
				"assetQuote=" + this.assetQuote +
			'}';
		}
	}
}
