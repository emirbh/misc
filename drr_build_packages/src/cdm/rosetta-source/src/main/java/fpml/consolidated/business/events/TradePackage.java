package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.TradePackageMeta;
import fpml.consolidated.doc.Approvals;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeIdentifier;
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
 * version "confirmation-5.13"
 *
 * Provision A bundle of trades collected together into a single unit for reporting.
 *
 */
@RosettaDataType(value="TradePackage", builder=TradePackage.TradePackageBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradePackage", model="fpml", builder=TradePackage.TradePackageBuilderImpl.class, version="2.1.1")
public interface TradePackage extends RosettaModelObject {

	TradePackageMeta metaData = new TradePackageMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	PackageHeader getPackageHeader();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends Trade> getTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends TradePackageSequence> getTradePackageSequence();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends TradeIdentifier> getTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A container for approval states in the workflow.
	 *
	 */
	Approvals getApprovals();

	/*********************** Build Methods  ***********************/
	TradePackage build();
	
	TradePackage.TradePackageBuilder toBuilder();
	
	static TradePackage.TradePackageBuilder builder() {
		return new TradePackage.TradePackageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradePackage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradePackage> getType() {
		return TradePackage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("packageHeader"), processor, PackageHeader.class, getPackageHeader());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("tradePackageSequence"), processor, TradePackageSequence.class, getTradePackageSequence());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("approvals"), processor, Approvals.class, getApprovals());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradePackageBuilder extends TradePackage, RosettaModelObjectBuilder {
		PackageHeader.PackageHeaderBuilder getOrCreatePackageHeader();
		@Override
		PackageHeader.PackageHeaderBuilder getPackageHeader();
		Trade.TradeBuilder getOrCreateTrade(int index);
		@Override
		List<? extends Trade.TradeBuilder> getTrade();
		TradePackageSequence.TradePackageSequenceBuilder getOrCreateTradePackageSequence(int index);
		@Override
		List<? extends TradePackageSequence.TradePackageSequenceBuilder> getTradePackageSequence();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier(int index);
		@Override
		List<? extends TradeIdentifier.TradeIdentifierBuilder> getTradeIdentifier();
		Approvals.ApprovalsBuilder getOrCreateApprovals();
		@Override
		Approvals.ApprovalsBuilder getApprovals();
		TradePackage.TradePackageBuilder setPackageHeader(PackageHeader packageHeader);
		TradePackage.TradePackageBuilder addTrade(Trade trade);
		TradePackage.TradePackageBuilder addTrade(Trade trade, int idx);
		TradePackage.TradePackageBuilder addTrade(List<? extends Trade> trade);
		TradePackage.TradePackageBuilder setTrade(List<? extends Trade> trade);
		TradePackage.TradePackageBuilder addTradePackageSequence(TradePackageSequence tradePackageSequence);
		TradePackage.TradePackageBuilder addTradePackageSequence(TradePackageSequence tradePackageSequence, int idx);
		TradePackage.TradePackageBuilder addTradePackageSequence(List<? extends TradePackageSequence> tradePackageSequence);
		TradePackage.TradePackageBuilder setTradePackageSequence(List<? extends TradePackageSequence> tradePackageSequence);
		TradePackage.TradePackageBuilder addTradeIdentifier(TradeIdentifier tradeIdentifier);
		TradePackage.TradePackageBuilder addTradeIdentifier(TradeIdentifier tradeIdentifier, int idx);
		TradePackage.TradePackageBuilder addTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifier);
		TradePackage.TradePackageBuilder setTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifier);
		TradePackage.TradePackageBuilder setApprovals(Approvals approvals);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("packageHeader"), processor, PackageHeader.PackageHeaderBuilder.class, getPackageHeader());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("tradePackageSequence"), processor, TradePackageSequence.TradePackageSequenceBuilder.class, getTradePackageSequence());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("approvals"), processor, Approvals.ApprovalsBuilder.class, getApprovals());
		}
		

		TradePackage.TradePackageBuilder prune();
	}

	/*********************** Immutable Implementation of TradePackage  ***********************/
	class TradePackageImpl implements TradePackage {
		private final PackageHeader packageHeader;
		private final List<? extends Trade> trade;
		private final List<? extends TradePackageSequence> tradePackageSequence;
		private final List<? extends TradeIdentifier> tradeIdentifier;
		private final Approvals approvals;
		
		protected TradePackageImpl(TradePackage.TradePackageBuilder builder) {
			this.packageHeader = ofNullable(builder.getPackageHeader()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradePackageSequence = ofNullable(builder.getTradePackageSequence()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.approvals = ofNullable(builder.getApprovals()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("packageHeader")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageHeader")
		public PackageHeader getPackageHeader() {
			return packageHeader;
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("trade")
		public List<? extends Trade> getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("tradePackageSequence")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradePackageSequence")
		public List<? extends TradePackageSequence> getTradePackageSequence() {
			return tradePackageSequence;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		public List<? extends TradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("approvals")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvals")
		public Approvals getApprovals() {
			return approvals;
		}
		
		@Override
		public TradePackage build() {
			return this;
		}
		
		@Override
		public TradePackage.TradePackageBuilder toBuilder() {
			TradePackage.TradePackageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradePackage.TradePackageBuilder builder) {
			ofNullable(getPackageHeader()).ifPresent(builder::setPackageHeader);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getTradePackageSequence()).ifPresent(builder::setTradePackageSequence);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getApprovals()).ifPresent(builder::setApprovals);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradePackage _that = getType().cast(o);
		
			if (!Objects.equals(packageHeader, _that.getPackageHeader())) return false;
			if (!ListEquals.listEquals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(tradePackageSequence, _that.getTradePackageSequence())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (packageHeader != null ? packageHeader.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradePackageSequence != null ? tradePackageSequence.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradePackage {" +
				"packageHeader=" + this.packageHeader + ", " +
				"trade=" + this.trade + ", " +
				"tradePackageSequence=" + this.tradePackageSequence + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"approvals=" + this.approvals +
			'}';
		}
	}

	/*********************** Builder Implementation of TradePackage  ***********************/
	class TradePackageBuilderImpl implements TradePackage.TradePackageBuilder {
	
		protected PackageHeader.PackageHeaderBuilder packageHeader;
		protected List<Trade.TradeBuilder> trade = new ArrayList<>();
		protected List<TradePackageSequence.TradePackageSequenceBuilder> tradePackageSequence = new ArrayList<>();
		protected List<TradeIdentifier.TradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected Approvals.ApprovalsBuilder approvals;
		
		@Override
		@RosettaAttribute("packageHeader")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageHeader")
		public PackageHeader.PackageHeaderBuilder getPackageHeader() {
			return packageHeader;
		}
		
		@Override
		public PackageHeader.PackageHeaderBuilder getOrCreatePackageHeader() {
			PackageHeader.PackageHeaderBuilder result;
			if (packageHeader!=null) {
				result = packageHeader;
			}
			else {
				result = packageHeader = PackageHeader.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("trade")
		public List<? extends Trade.TradeBuilder> getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade(int index) {
			if (trade==null) {
				this.trade = new ArrayList<>();
			}
			return getIndex(trade, index, () -> {
						Trade.TradeBuilder newTrade = Trade.builder();
						return newTrade;
					});
		}
		
		@Override
		@RosettaAttribute("tradePackageSequence")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradePackageSequence")
		public List<? extends TradePackageSequence.TradePackageSequenceBuilder> getTradePackageSequence() {
			return tradePackageSequence;
		}
		
		@Override
		public TradePackageSequence.TradePackageSequenceBuilder getOrCreateTradePackageSequence(int index) {
			if (tradePackageSequence==null) {
				this.tradePackageSequence = new ArrayList<>();
			}
			return getIndex(tradePackageSequence, index, () -> {
						TradePackageSequence.TradePackageSequenceBuilder newTradePackageSequence = TradePackageSequence.builder();
						return newTradePackageSequence;
					});
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		public List<? extends TradeIdentifier.TradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier(int index) {
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			return getIndex(tradeIdentifier, index, () -> {
						TradeIdentifier.TradeIdentifierBuilder newTradeIdentifier = TradeIdentifier.builder();
						return newTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("approvals")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvals")
		public Approvals.ApprovalsBuilder getApprovals() {
			return approvals;
		}
		
		@Override
		public Approvals.ApprovalsBuilder getOrCreateApprovals() {
			Approvals.ApprovalsBuilder result;
			if (approvals!=null) {
				result = approvals;
			}
			else {
				result = approvals = Approvals.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("packageHeader")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageHeader")
		@Override
		public TradePackage.TradePackageBuilder setPackageHeader(PackageHeader _packageHeader) {
			this.packageHeader = _packageHeader == null ? null : _packageHeader.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("trade")
		@Override
		public TradePackage.TradePackageBuilder addTrade(Trade _trade) {
			if (_trade != null) {
				this.trade.add(_trade.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradePackage.TradePackageBuilder addTrade(Trade _trade, int idx) {
			getIndex(this.trade, idx, () -> _trade.toBuilder());
			return this;
		}
		
		@Override
		public TradePackage.TradePackageBuilder addTrade(List<? extends Trade> trades) {
			if (trades != null) {
				for (final Trade toAdd : trades) {
					this.trade.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("trade")
		@Override
		public TradePackage.TradePackageBuilder setTrade(List<? extends Trade> trades) {
			if (trades == null) {
				this.trade = new ArrayList<>();
			} else {
				this.trade = trades.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradePackageSequence")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradePackageSequence")
		@Override
		public TradePackage.TradePackageBuilder addTradePackageSequence(TradePackageSequence _tradePackageSequence) {
			if (_tradePackageSequence != null) {
				this.tradePackageSequence.add(_tradePackageSequence.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradePackage.TradePackageBuilder addTradePackageSequence(TradePackageSequence _tradePackageSequence, int idx) {
			getIndex(this.tradePackageSequence, idx, () -> _tradePackageSequence.toBuilder());
			return this;
		}
		
		@Override
		public TradePackage.TradePackageBuilder addTradePackageSequence(List<? extends TradePackageSequence> tradePackageSequences) {
			if (tradePackageSequences != null) {
				for (final TradePackageSequence toAdd : tradePackageSequences) {
					this.tradePackageSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradePackageSequence")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradePackageSequence")
		@Override
		public TradePackage.TradePackageBuilder setTradePackageSequence(List<? extends TradePackageSequence> tradePackageSequences) {
			if (tradePackageSequences == null) {
				this.tradePackageSequence = new ArrayList<>();
			} else {
				this.tradePackageSequence = tradePackageSequences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public TradePackage.TradePackageBuilder addTradeIdentifier(TradeIdentifier _tradeIdentifier) {
			if (_tradeIdentifier != null) {
				this.tradeIdentifier.add(_tradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradePackage.TradePackageBuilder addTradeIdentifier(TradeIdentifier _tradeIdentifier, int idx) {
			getIndex(this.tradeIdentifier, idx, () -> _tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradePackage.TradePackageBuilder addTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (final TradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public TradePackage.TradePackageBuilder setTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null) {
				this.tradeIdentifier = new ArrayList<>();
			} else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("approvals")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("approvals")
		@Override
		public TradePackage.TradePackageBuilder setApprovals(Approvals _approvals) {
			this.approvals = _approvals == null ? null : _approvals.toBuilder();
			return this;
		}
		
		@Override
		public TradePackage build() {
			return new TradePackage.TradePackageImpl(this);
		}
		
		@Override
		public TradePackage.TradePackageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradePackage.TradePackageBuilder prune() {
			if (packageHeader!=null && !packageHeader.prune().hasData()) packageHeader = null;
			trade = trade.stream().filter(b->b!=null).<Trade.TradeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			tradePackageSequence = tradePackageSequence.stream().filter(b->b!=null).<TradePackageSequence.TradePackageSequenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<TradeIdentifier.TradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (approvals!=null && !approvals.prune().hasData()) approvals = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPackageHeader()!=null && getPackageHeader().hasData()) return true;
			if (getTrade()!=null && getTrade().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradePackageSequence()!=null && getTradePackageSequence().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getApprovals()!=null && getApprovals().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradePackage.TradePackageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradePackage.TradePackageBuilder o = (TradePackage.TradePackageBuilder) other;
			
			merger.mergeRosetta(getPackageHeader(), o.getPackageHeader(), this::setPackageHeader);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::getOrCreateTrade);
			merger.mergeRosetta(getTradePackageSequence(), o.getTradePackageSequence(), this::getOrCreateTradePackageSequence);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getApprovals(), o.getApprovals(), this::setApprovals);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradePackage _that = getType().cast(o);
		
			if (!Objects.equals(packageHeader, _that.getPackageHeader())) return false;
			if (!ListEquals.listEquals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(tradePackageSequence, _that.getTradePackageSequence())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (packageHeader != null ? packageHeader.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradePackageSequence != null ? tradePackageSequence.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradePackageBuilder {" +
				"packageHeader=" + this.packageHeader + ", " +
				"trade=" + this.trade + ", " +
				"tradePackageSequence=" + this.tradePackageSequence + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"approvals=" + this.approvals +
			'}';
		}
	}
}
