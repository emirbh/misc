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
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.RelatedParty;
import fpml.consolidated.valuation.ValuationSet;
import fpml.consolidated.valuation.fpmlreporting.meta.TradeValuationItemMeta;
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
 * Provision A type used in trade valuation enquiry messages which relates a trade identifier to its current value.
 *
 */
@RosettaDataType(value="TradeValuationItem", builder=TradeValuationItem.TradeValuationItemBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeValuationItem", model="fpml", builder=TradeValuationItem.TradeValuationItemBuilderImpl.class, version="2.1.1")
public interface TradeValuationItem extends RosettaModelObject {

	TradeValuationItemMeta metaData = new TradeValuationItemMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision One or more trade identifiers needed to uniquely identify a trade.
	 *
	 */
	List<? extends PartyTradeIdentifier> getPartyTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This may be used to identify one or more parties that perform a role within the transaction. If this is within a partyTradeInformation block, the related party performs the role with respect to the party identifie by the "partyReference" in the partyTradeInformation block.
	 *
	 */
	List<? extends RelatedParty> getRelatedParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Fully-described trades whose values are reported.
	 *
	 */
	Trade getTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The trade valuation.
	 *
	 */
	ValuationSet getValuationSet();

	/*********************** Build Methods  ***********************/
	TradeValuationItem build();
	
	TradeValuationItem.TradeValuationItemBuilder toBuilder();
	
	static TradeValuationItem.TradeValuationItemBuilder builder() {
		return new TradeValuationItem.TradeValuationItemBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeValuationItem> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeValuationItem> getType() {
		return TradeValuationItem.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("valuationSet"), processor, ValuationSet.class, getValuationSet());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeValuationItemBuilder extends TradeValuationItem, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int index);
		@Override
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index);
		@Override
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		Trade.TradeBuilder getOrCreateTrade();
		@Override
		Trade.TradeBuilder getTrade();
		ValuationSet.ValuationSetBuilder getOrCreateValuationSet();
		@Override
		ValuationSet.ValuationSetBuilder getValuationSet();
		TradeValuationItem.TradeValuationItemBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier);
		TradeValuationItem.TradeValuationItemBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier, int idx);
		TradeValuationItem.TradeValuationItemBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier);
		TradeValuationItem.TradeValuationItemBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier);
		TradeValuationItem.TradeValuationItemBuilder addRelatedParty(RelatedParty relatedParty);
		TradeValuationItem.TradeValuationItemBuilder addRelatedParty(RelatedParty relatedParty, int idx);
		TradeValuationItem.TradeValuationItemBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		TradeValuationItem.TradeValuationItemBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);
		TradeValuationItem.TradeValuationItemBuilder setTrade(Trade trade);
		TradeValuationItem.TradeValuationItemBuilder setValuationSet(ValuationSet valuationSet);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("valuationSet"), processor, ValuationSet.ValuationSetBuilder.class, getValuationSet());
		}
		

		TradeValuationItem.TradeValuationItemBuilder prune();
	}

	/*********************** Immutable Implementation of TradeValuationItem  ***********************/
	class TradeValuationItemImpl implements TradeValuationItem {
		private final List<? extends PartyTradeIdentifier> partyTradeIdentifier;
		private final List<? extends RelatedParty> relatedParty;
		private final Trade trade;
		private final ValuationSet valuationSet;
		
		protected TradeValuationItemImpl(TradeValuationItem.TradeValuationItemBuilder builder) {
			this.partyTradeIdentifier = ofNullable(builder.getPartyTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.valuationSet = ofNullable(builder.getValuationSet()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("valuationSet")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationSet")
		public ValuationSet getValuationSet() {
			return valuationSet;
		}
		
		@Override
		public TradeValuationItem build() {
			return this;
		}
		
		@Override
		public TradeValuationItem.TradeValuationItemBuilder toBuilder() {
			TradeValuationItem.TradeValuationItemBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeValuationItem.TradeValuationItemBuilder builder) {
			ofNullable(getPartyTradeIdentifier()).ifPresent(builder::setPartyTradeIdentifier);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getValuationSet()).ifPresent(builder::setValuationSet);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeValuationItem _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(valuationSet, _that.getValuationSet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (valuationSet != null ? valuationSet.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeValuationItem {" +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"trade=" + this.trade + ", " +
				"valuationSet=" + this.valuationSet +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeValuationItem  ***********************/
	class TradeValuationItemBuilderImpl implements TradeValuationItem.TradeValuationItemBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> partyTradeIdentifier = new ArrayList<>();
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected Trade.TradeBuilder trade;
		protected ValuationSet.ValuationSetBuilder valuationSet;
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int index) {
			if (partyTradeIdentifier==null) {
				this.partyTradeIdentifier = new ArrayList<>();
			}
			return getIndex(partyTradeIdentifier, index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newPartyTradeIdentifier = PartyTradeIdentifier.builder();
						return newPartyTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index) {
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			return getIndex(relatedParty, index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trade")
		public Trade.TradeBuilder getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade() {
			Trade.TradeBuilder result;
			if (trade!=null) {
				result = trade;
			}
			else {
				result = trade = Trade.builder();
			}
			
			return result;
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
		
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		@Override
		public TradeValuationItem.TradeValuationItemBuilder addPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier) {
			if (_partyTradeIdentifier != null) {
				this.partyTradeIdentifier.add(_partyTradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeValuationItem.TradeValuationItemBuilder addPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier, int idx) {
			getIndex(this.partyTradeIdentifier, idx, () -> _partyTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeValuationItem.TradeValuationItemBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers != null) {
				for (final PartyTradeIdentifier toAdd : partyTradeIdentifiers) {
					this.partyTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		@Override
		public TradeValuationItem.TradeValuationItemBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers == null) {
				this.partyTradeIdentifier = new ArrayList<>();
			} else {
				this.partyTradeIdentifier = partyTradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public TradeValuationItem.TradeValuationItemBuilder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeValuationItem.TradeValuationItemBuilder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public TradeValuationItem.TradeValuationItemBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (final RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public TradeValuationItem.TradeValuationItemBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null) {
				this.relatedParty = new ArrayList<>();
			} else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public TradeValuationItem.TradeValuationItemBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationSet")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationSet")
		@Override
		public TradeValuationItem.TradeValuationItemBuilder setValuationSet(ValuationSet _valuationSet) {
			this.valuationSet = _valuationSet == null ? null : _valuationSet.toBuilder();
			return this;
		}
		
		@Override
		public TradeValuationItem build() {
			return new TradeValuationItem.TradeValuationItemImpl(this);
		}
		
		@Override
		public TradeValuationItem.TradeValuationItemBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeValuationItem.TradeValuationItemBuilder prune() {
			partyTradeIdentifier = partyTradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (valuationSet!=null && !valuationSet.prune().hasData()) valuationSet = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyTradeIdentifier()!=null && getPartyTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getValuationSet()!=null && getValuationSet().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeValuationItem.TradeValuationItemBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeValuationItem.TradeValuationItemBuilder o = (TradeValuationItem.TradeValuationItemBuilder) other;
			
			merger.mergeRosetta(getPartyTradeIdentifier(), o.getPartyTradeIdentifier(), this::getOrCreatePartyTradeIdentifier);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getValuationSet(), o.getValuationSet(), this::setValuationSet);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeValuationItem _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(valuationSet, _that.getValuationSet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (valuationSet != null ? valuationSet.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeValuationItemBuilder {" +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"trade=" + this.trade + ", " +
				"valuationSet=" + this.valuationSet +
			'}';
		}
	}
}
