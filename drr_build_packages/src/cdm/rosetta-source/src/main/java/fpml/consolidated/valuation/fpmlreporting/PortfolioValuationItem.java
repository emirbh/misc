package fpml.consolidated.valuation.fpmlreporting;

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
import fpml.consolidated.valuation.ValuationSet;
import fpml.consolidated.valuation.fpmlreporting.meta.PortfolioValuationItemMeta;
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
 * Provision A type used in valuation enquiry messages which relates a portfolio to its trades and current value.
 *
 */
@RosettaDataType(value="PortfolioValuationItem", builder=PortfolioValuationItem.PortfolioValuationItemBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PortfolioValuationItem", model="fpml", builder=PortfolioValuationItem.PortfolioValuationItemBuilderImpl.class, version="2.1.1")
public interface PortfolioValuationItem extends RosettaModelObject {

	PortfolioValuationItemMeta metaData = new PortfolioValuationItemMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Portfolio identifier
	 *
	 */
	Portfolio getPortfolio();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Zero or more trade valuation items.
	 *
	 */
	List<? extends TradeValuationItem> getTradeValuationItem();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The portfolio valuation.
	 *
	 */
	ValuationSet getValuationSet();

	/*********************** Build Methods  ***********************/
	PortfolioValuationItem build();
	
	PortfolioValuationItem.PortfolioValuationItemBuilder toBuilder();
	
	static PortfolioValuationItem.PortfolioValuationItemBuilder builder() {
		return new PortfolioValuationItem.PortfolioValuationItemBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioValuationItem> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PortfolioValuationItem> getType() {
		return PortfolioValuationItem.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("portfolio"), processor, Portfolio.class, getPortfolio());
		processRosetta(path.newSubPath("tradeValuationItem"), processor, TradeValuationItem.class, getTradeValuationItem());
		processRosetta(path.newSubPath("valuationSet"), processor, ValuationSet.class, getValuationSet());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioValuationItemBuilder extends PortfolioValuationItem, RosettaModelObjectBuilder {
		Portfolio.PortfolioBuilder getOrCreatePortfolio();
		@Override
		Portfolio.PortfolioBuilder getPortfolio();
		TradeValuationItem.TradeValuationItemBuilder getOrCreateTradeValuationItem(int index);
		@Override
		List<? extends TradeValuationItem.TradeValuationItemBuilder> getTradeValuationItem();
		ValuationSet.ValuationSetBuilder getOrCreateValuationSet();
		@Override
		ValuationSet.ValuationSetBuilder getValuationSet();
		PortfolioValuationItem.PortfolioValuationItemBuilder setPortfolio(Portfolio portfolio);
		PortfolioValuationItem.PortfolioValuationItemBuilder addTradeValuationItem(TradeValuationItem tradeValuationItem);
		PortfolioValuationItem.PortfolioValuationItemBuilder addTradeValuationItem(TradeValuationItem tradeValuationItem, int idx);
		PortfolioValuationItem.PortfolioValuationItemBuilder addTradeValuationItem(List<? extends TradeValuationItem> tradeValuationItem);
		PortfolioValuationItem.PortfolioValuationItemBuilder setTradeValuationItem(List<? extends TradeValuationItem> tradeValuationItem);
		PortfolioValuationItem.PortfolioValuationItemBuilder setValuationSet(ValuationSet valuationSet);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("portfolio"), processor, Portfolio.PortfolioBuilder.class, getPortfolio());
			processRosetta(path.newSubPath("tradeValuationItem"), processor, TradeValuationItem.TradeValuationItemBuilder.class, getTradeValuationItem());
			processRosetta(path.newSubPath("valuationSet"), processor, ValuationSet.ValuationSetBuilder.class, getValuationSet());
		}
		

		PortfolioValuationItem.PortfolioValuationItemBuilder prune();
	}

	/*********************** Immutable Implementation of PortfolioValuationItem  ***********************/
	class PortfolioValuationItemImpl implements PortfolioValuationItem {
		private final Portfolio portfolio;
		private final List<? extends TradeValuationItem> tradeValuationItem;
		private final ValuationSet valuationSet;
		
		protected PortfolioValuationItemImpl(PortfolioValuationItem.PortfolioValuationItemBuilder builder) {
			this.portfolio = ofNullable(builder.getPortfolio()).map(f->f.build()).orElse(null);
			this.tradeValuationItem = ofNullable(builder.getTradeValuationItem()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.valuationSet = ofNullable(builder.getValuationSet()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("portfolio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("portfolio")
		public Portfolio getPortfolio() {
			return portfolio;
		}
		
		@Override
		@RosettaAttribute("tradeValuationItem")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeValuationItem")
		public List<? extends TradeValuationItem> getTradeValuationItem() {
			return tradeValuationItem;
		}
		
		@Override
		@RosettaAttribute("valuationSet")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationSet")
		public ValuationSet getValuationSet() {
			return valuationSet;
		}
		
		@Override
		public PortfolioValuationItem build() {
			return this;
		}
		
		@Override
		public PortfolioValuationItem.PortfolioValuationItemBuilder toBuilder() {
			PortfolioValuationItem.PortfolioValuationItemBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioValuationItem.PortfolioValuationItemBuilder builder) {
			ofNullable(getPortfolio()).ifPresent(builder::setPortfolio);
			ofNullable(getTradeValuationItem()).ifPresent(builder::setTradeValuationItem);
			ofNullable(getValuationSet()).ifPresent(builder::setValuationSet);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioValuationItem _that = getType().cast(o);
		
			if (!Objects.equals(portfolio, _that.getPortfolio())) return false;
			if (!ListEquals.listEquals(tradeValuationItem, _that.getTradeValuationItem())) return false;
			if (!Objects.equals(valuationSet, _that.getValuationSet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (portfolio != null ? portfolio.hashCode() : 0);
			_result = 31 * _result + (tradeValuationItem != null ? tradeValuationItem.hashCode() : 0);
			_result = 31 * _result + (valuationSet != null ? valuationSet.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioValuationItem {" +
				"portfolio=" + this.portfolio + ", " +
				"tradeValuationItem=" + this.tradeValuationItem + ", " +
				"valuationSet=" + this.valuationSet +
			'}';
		}
	}

	/*********************** Builder Implementation of PortfolioValuationItem  ***********************/
	class PortfolioValuationItemBuilderImpl implements PortfolioValuationItem.PortfolioValuationItemBuilder {
	
		protected Portfolio.PortfolioBuilder portfolio;
		protected List<TradeValuationItem.TradeValuationItemBuilder> tradeValuationItem = new ArrayList<>();
		protected ValuationSet.ValuationSetBuilder valuationSet;
		
		@Override
		@RosettaAttribute("portfolio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("portfolio")
		public Portfolio.PortfolioBuilder getPortfolio() {
			return portfolio;
		}
		
		@Override
		public Portfolio.PortfolioBuilder getOrCreatePortfolio() {
			Portfolio.PortfolioBuilder result;
			if (portfolio!=null) {
				result = portfolio;
			}
			else {
				result = portfolio = Portfolio.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeValuationItem")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeValuationItem")
		public List<? extends TradeValuationItem.TradeValuationItemBuilder> getTradeValuationItem() {
			return tradeValuationItem;
		}
		
		@Override
		public TradeValuationItem.TradeValuationItemBuilder getOrCreateTradeValuationItem(int index) {
			if (tradeValuationItem==null) {
				this.tradeValuationItem = new ArrayList<>();
			}
			return getIndex(tradeValuationItem, index, () -> {
						TradeValuationItem.TradeValuationItemBuilder newTradeValuationItem = TradeValuationItem.builder();
						return newTradeValuationItem;
					});
		}
		
		@Override
		@RosettaAttribute("valuationSet")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationSet")
		public ValuationSet.ValuationSetBuilder getValuationSet() {
			return valuationSet;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder getOrCreateValuationSet() {
			ValuationSet.ValuationSetBuilder result;
			if (valuationSet!=null) {
				result = valuationSet;
			}
			else {
				result = valuationSet = ValuationSet.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("portfolio")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("portfolio")
		@Override
		public PortfolioValuationItem.PortfolioValuationItemBuilder setPortfolio(Portfolio _portfolio) {
			this.portfolio = _portfolio == null ? null : _portfolio.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeValuationItem")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeValuationItem")
		@Override
		public PortfolioValuationItem.PortfolioValuationItemBuilder addTradeValuationItem(TradeValuationItem _tradeValuationItem) {
			if (_tradeValuationItem != null) {
				this.tradeValuationItem.add(_tradeValuationItem.toBuilder());
			}
			return this;
		}
		
		@Override
		public PortfolioValuationItem.PortfolioValuationItemBuilder addTradeValuationItem(TradeValuationItem _tradeValuationItem, int idx) {
			getIndex(this.tradeValuationItem, idx, () -> _tradeValuationItem.toBuilder());
			return this;
		}
		
		@Override
		public PortfolioValuationItem.PortfolioValuationItemBuilder addTradeValuationItem(List<? extends TradeValuationItem> tradeValuationItems) {
			if (tradeValuationItems != null) {
				for (final TradeValuationItem toAdd : tradeValuationItems) {
					this.tradeValuationItem.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeValuationItem")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeValuationItem")
		@Override
		public PortfolioValuationItem.PortfolioValuationItemBuilder setTradeValuationItem(List<? extends TradeValuationItem> tradeValuationItems) {
			if (tradeValuationItems == null) {
				this.tradeValuationItem = new ArrayList<>();
			} else {
				this.tradeValuationItem = tradeValuationItems.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("valuationSet")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationSet")
		@Override
		public PortfolioValuationItem.PortfolioValuationItemBuilder setValuationSet(ValuationSet _valuationSet) {
			this.valuationSet = _valuationSet == null ? null : _valuationSet.toBuilder();
			return this;
		}
		
		@Override
		public PortfolioValuationItem build() {
			return new PortfolioValuationItem.PortfolioValuationItemImpl(this);
		}
		
		@Override
		public PortfolioValuationItem.PortfolioValuationItemBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioValuationItem.PortfolioValuationItemBuilder prune() {
			if (portfolio!=null && !portfolio.prune().hasData()) portfolio = null;
			tradeValuationItem = tradeValuationItem.stream().filter(b->b!=null).<TradeValuationItem.TradeValuationItemBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (valuationSet!=null && !valuationSet.prune().hasData()) valuationSet = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPortfolio()!=null && getPortfolio().hasData()) return true;
			if (getTradeValuationItem()!=null && getTradeValuationItem().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getValuationSet()!=null && getValuationSet().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioValuationItem.PortfolioValuationItemBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PortfolioValuationItem.PortfolioValuationItemBuilder o = (PortfolioValuationItem.PortfolioValuationItemBuilder) other;
			
			merger.mergeRosetta(getPortfolio(), o.getPortfolio(), this::setPortfolio);
			merger.mergeRosetta(getTradeValuationItem(), o.getTradeValuationItem(), this::getOrCreateTradeValuationItem);
			merger.mergeRosetta(getValuationSet(), o.getValuationSet(), this::setValuationSet);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioValuationItem _that = getType().cast(o);
		
			if (!Objects.equals(portfolio, _that.getPortfolio())) return false;
			if (!ListEquals.listEquals(tradeValuationItem, _that.getTradeValuationItem())) return false;
			if (!Objects.equals(valuationSet, _that.getValuationSet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (portfolio != null ? portfolio.hashCode() : 0);
			_result = 31 * _result + (tradeValuationItem != null ? tradeValuationItem.hashCode() : 0);
			_result = 31 * _result + (valuationSet != null ? valuationSet.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioValuationItemBuilder {" +
				"portfolio=" + this.portfolio + ", " +
				"tradeValuationItem=" + this.tradeValuationItem + ", " +
				"valuationSet=" + this.valuationSet +
			'}';
		}
	}
}
