package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.ExchangeTradedContractUnderlyerMeta;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Period;
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
 * Provision A type describing a single underlyer
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing a single underlyer
 *
 */
@RosettaDataType(value="ExchangeTradedContractUnderlyer", builder=ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExchangeTradedContractUnderlyer", model="fpml", builder=ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilderImpl.class, version="2.1.1")
public interface ExchangeTradedContractUnderlyer extends RosettaModelObject {

	ExchangeTradedContractUnderlyerMeta metaData = new ExchangeTradedContractUnderlyerMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ISDA Floating Rate Option, i.e. the name of the floating rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA Floating Rate Option, i.e. the name of the floating rate.
	 *
	 */
	FloatingRateIndex getFloatingRateIndex();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ISDA Designated Maturity, i.e. the tenor of the floating rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA Designated Maturity, i.e. the tenor of the floating rate.
	 *
	 */
	Period getIndexTenor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 *
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
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
	List<? extends Asset> getUnderlyingAsset();

	/*********************** Build Methods  ***********************/
	ExchangeTradedContractUnderlyer build();
	
	ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder toBuilder();
	
	static ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder builder() {
		return new ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeTradedContractUnderlyer> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExchangeTradedContractUnderlyer> getType() {
		return ExchangeTradedContractUnderlyer.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.class, getUnderlyingAsset());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeTradedContractUnderlyerBuilder extends ExchangeTradedContractUnderlyer, RosettaModelObjectBuilder {
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex();
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex();
		Period.PeriodBuilder getOrCreateIndexTenor();
		@Override
		Period.PeriodBuilder getIndexTenor();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		Asset.AssetBuilder getOrCreateUnderlyingAsset(int index);
		@Override
		List<? extends Asset.AssetBuilder> getUnderlyingAsset();
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex);
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder setIndexTenor(Period indexTenor);
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder addUnderlyingAsset(Asset underlyingAsset);
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder addUnderlyingAsset(Asset underlyingAsset, int idx);
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder addUnderlyingAsset(List<? extends Asset> underlyingAsset);
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder setUnderlyingAsset(List<? extends Asset> underlyingAsset);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.AssetBuilder.class, getUnderlyingAsset());
		}
		

		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeTradedContractUnderlyer  ***********************/
	class ExchangeTradedContractUnderlyerImpl implements ExchangeTradedContractUnderlyer {
		private final FloatingRateIndex floatingRateIndex;
		private final Period indexTenor;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final List<? extends Asset> underlyingAsset;
		
		protected ExchangeTradedContractUnderlyerImpl(ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder builder) {
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.indexTenor = ofNullable(builder.getIndexTenor()).map(f->f.build()).orElse(null);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.underlyingAsset = ofNullable(builder.getUnderlyingAsset()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateIndex")
		public FloatingRateIndex getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexTenor")
		public Period getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAsset")
		public List<? extends Asset> getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public ExchangeTradedContractUnderlyer build() {
			return this;
		}
		
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder toBuilder() {
			ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder builder) {
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getUnderlyingAsset()).ifPresent(builder::setUnderlyingAsset);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeTradedContractUnderlyer _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!ListEquals.listEquals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedContractUnderlyer {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"underlyingAsset=" + this.underlyingAsset +
			'}';
		}
	}

	/*********************** Builder Implementation of ExchangeTradedContractUnderlyer  ***********************/
	class ExchangeTradedContractUnderlyerBuilderImpl implements ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder {
	
		protected FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex;
		protected Period.PeriodBuilder indexTenor;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected List<Asset.AssetBuilder> underlyingAsset = new ArrayList<>();
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateIndex")
		public FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex() {
			FloatingRateIndex.FloatingRateIndexBuilder result;
			if (floatingRateIndex!=null) {
				result = floatingRateIndex;
			}
			else {
				result = floatingRateIndex = FloatingRateIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexTenor")
		public Period.PeriodBuilder getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateIndexTenor() {
			Period.PeriodBuilder result;
			if (indexTenor!=null) {
				result = indexTenor;
			}
			else {
				result = indexTenor = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAsset")
		public List<? extends Asset.AssetBuilder> getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateUnderlyingAsset(int index) {
			if (underlyingAsset==null) {
				this.underlyingAsset = new ArrayList<>();
			}
			return getIndex(underlyingAsset, index, () -> {
						Asset.AssetBuilder newUnderlyingAsset = Asset.builder();
						return newUnderlyingAsset;
					});
		}
		
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateIndex")
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder setFloatingRateIndex(FloatingRateIndex _floatingRateIndex) {
			this.floatingRateIndex = _floatingRateIndex == null ? null : _floatingRateIndex.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexTenor")
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder setIndexTenor(Period _indexTenor) {
			this.indexTenor = _indexTenor == null ? null : _indexTenor.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyingAsset")
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder addUnderlyingAsset(Asset _underlyingAsset) {
			if (_underlyingAsset != null) {
				this.underlyingAsset.add(_underlyingAsset.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder addUnderlyingAsset(Asset _underlyingAsset, int idx) {
			getIndex(this.underlyingAsset, idx, () -> _underlyingAsset.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder addUnderlyingAsset(List<? extends Asset> underlyingAssets) {
			if (underlyingAssets != null) {
				for (final Asset toAdd : underlyingAssets) {
					this.underlyingAsset.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyingAsset")
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder setUnderlyingAsset(List<? extends Asset> underlyingAssets) {
			if (underlyingAssets == null) {
				this.underlyingAsset = new ArrayList<>();
			} else {
				this.underlyingAsset = underlyingAssets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ExchangeTradedContractUnderlyer build() {
			return new ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerImpl(this);
		}
		
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder prune() {
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			if (indexTenor!=null && !indexTenor.prune().hasData()) indexTenor = null;
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			underlyingAsset = underlyingAsset.stream().filter(b->b!=null).<Asset.AssetBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFloatingRateIndex()!=null && getFloatingRateIndex().hasData()) return true;
			if (getIndexTenor()!=null && getIndexTenor().hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getUnderlyingAsset()!=null && getUnderlyingAsset().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder o = (ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::setIndexTenor);
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getUnderlyingAsset(), o.getUnderlyingAsset(), this::getOrCreateUnderlyingAsset);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeTradedContractUnderlyer _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!ListEquals.listEquals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedContractUnderlyerBuilder {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"underlyingAsset=" + this.underlyingAsset +
			'}';
		}
	}
}
