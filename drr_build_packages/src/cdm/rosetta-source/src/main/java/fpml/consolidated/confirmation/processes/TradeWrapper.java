package fpml.consolidated.confirmation.processes;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.TradeReferenceInformation;
import fpml.consolidated.confirmation.processes.meta.TradeWrapperMeta;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that contains a business event.
 *
 */
@RosettaDataType(value="TradeWrapper", builder=TradeWrapper.TradeWrapperBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeWrapper", model="fpml", builder=TradeWrapper.TradeWrapperBuilderImpl.class, version="2.1.1")
public interface TradeWrapper extends RosettaModelObject {

	TradeWrapperMeta metaData = new TradeWrapperMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to describe why a trade was created. This can be used to provide context for a newly created trade that is not part of a post-trade event. For example, it can report that the trade was created as a result of netting activity, or due to a transfer, an allocation process, etc. Omitting this implies that the trade record was created as a result of a negotiated new trade.
	 *
	 */
	OriginatingEvent getOriginatingEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Trade getTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Information about a trade.
	 *
	 */
	TradeReferenceInformation getTradeReferenceInformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	TradePackage getTradePackage();

	/*********************** Build Methods  ***********************/
	TradeWrapper build();
	
	TradeWrapper.TradeWrapperBuilder toBuilder();
	
	static TradeWrapper.TradeWrapperBuilder builder() {
		return new TradeWrapper.TradeWrapperBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeWrapper> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeWrapper> getType() {
		return TradeWrapper.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.class, getOriginatingEvent());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("tradeReferenceInformation"), processor, TradeReferenceInformation.class, getTradeReferenceInformation());
		processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.class, getTradePackage());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeWrapperBuilder extends TradeWrapper, RosettaModelObjectBuilder {
		OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent();
		@Override
		OriginatingEvent.OriginatingEventBuilder getOriginatingEvent();
		Trade.TradeBuilder getOrCreateTrade();
		@Override
		Trade.TradeBuilder getTrade();
		TradeReferenceInformation.TradeReferenceInformationBuilder getOrCreateTradeReferenceInformation();
		@Override
		TradeReferenceInformation.TradeReferenceInformationBuilder getTradeReferenceInformation();
		TradePackage.TradePackageBuilder getOrCreateTradePackage();
		@Override
		TradePackage.TradePackageBuilder getTradePackage();
		TradeWrapper.TradeWrapperBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		TradeWrapper.TradeWrapperBuilder setTrade(Trade trade);
		TradeWrapper.TradeWrapperBuilder setTradeReferenceInformation(TradeReferenceInformation tradeReferenceInformation);
		TradeWrapper.TradeWrapperBuilder setTradePackage(TradePackage tradePackage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.OriginatingEventBuilder.class, getOriginatingEvent());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("tradeReferenceInformation"), processor, TradeReferenceInformation.TradeReferenceInformationBuilder.class, getTradeReferenceInformation());
			processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.TradePackageBuilder.class, getTradePackage());
		}
		

		TradeWrapper.TradeWrapperBuilder prune();
	}

	/*********************** Immutable Implementation of TradeWrapper  ***********************/
	class TradeWrapperImpl implements TradeWrapper {
		private final OriginatingEvent originatingEvent;
		private final Trade trade;
		private final TradeReferenceInformation tradeReferenceInformation;
		private final TradePackage tradePackage;
		
		protected TradeWrapperImpl(TradeWrapper.TradeWrapperBuilder builder) {
			this.originatingEvent = ofNullable(builder.getOriginatingEvent()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.tradeReferenceInformation = ofNullable(builder.getTradeReferenceInformation()).map(f->f.build()).orElse(null);
			this.tradePackage = ofNullable(builder.getTradePackage()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originatingEvent")
		public OriginatingEvent getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeReferenceInformation")
		public TradeReferenceInformation getTradeReferenceInformation() {
			return tradeReferenceInformation;
		}
		
		@Override
		@RosettaAttribute("tradePackage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradePackage")
		public TradePackage getTradePackage() {
			return tradePackage;
		}
		
		@Override
		public TradeWrapper build() {
			return this;
		}
		
		@Override
		public TradeWrapper.TradeWrapperBuilder toBuilder() {
			TradeWrapper.TradeWrapperBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeWrapper.TradeWrapperBuilder builder) {
			ofNullable(getOriginatingEvent()).ifPresent(builder::setOriginatingEvent);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getTradeReferenceInformation()).ifPresent(builder::setTradeReferenceInformation);
			ofNullable(getTradePackage()).ifPresent(builder::setTradePackage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeWrapper _that = getType().cast(o);
		
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(tradeReferenceInformation, _that.getTradeReferenceInformation())) return false;
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradeReferenceInformation != null ? tradeReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeWrapper {" +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade + ", " +
				"tradeReferenceInformation=" + this.tradeReferenceInformation + ", " +
				"tradePackage=" + this.tradePackage +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeWrapper  ***********************/
	class TradeWrapperBuilderImpl implements TradeWrapper.TradeWrapperBuilder {
	
		protected OriginatingEvent.OriginatingEventBuilder originatingEvent;
		protected Trade.TradeBuilder trade;
		protected TradeReferenceInformation.TradeReferenceInformationBuilder tradeReferenceInformation;
		protected TradePackage.TradePackageBuilder tradePackage;
		
		@Override
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originatingEvent")
		public OriginatingEvent.OriginatingEventBuilder getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		public OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent() {
			OriginatingEvent.OriginatingEventBuilder result;
			if (originatingEvent!=null) {
				result = originatingEvent;
			}
			else {
				result = originatingEvent = OriginatingEvent.builder();
			}
			
			return result;
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
		@RosettaAttribute("tradeReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeReferenceInformation")
		public TradeReferenceInformation.TradeReferenceInformationBuilder getTradeReferenceInformation() {
			return tradeReferenceInformation;
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder getOrCreateTradeReferenceInformation() {
			TradeReferenceInformation.TradeReferenceInformationBuilder result;
			if (tradeReferenceInformation!=null) {
				result = tradeReferenceInformation;
			}
			else {
				result = tradeReferenceInformation = TradeReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradePackage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradePackage")
		public TradePackage.TradePackageBuilder getTradePackage() {
			return tradePackage;
		}
		
		@Override
		public TradePackage.TradePackageBuilder getOrCreateTradePackage() {
			TradePackage.TradePackageBuilder result;
			if (tradePackage!=null) {
				result = tradePackage;
			}
			else {
				result = tradePackage = TradePackage.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originatingEvent")
		@Override
		public TradeWrapper.TradeWrapperBuilder setOriginatingEvent(OriginatingEvent _originatingEvent) {
			this.originatingEvent = _originatingEvent == null ? null : _originatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public TradeWrapper.TradeWrapperBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeReferenceInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeReferenceInformation")
		@Override
		public TradeWrapper.TradeWrapperBuilder setTradeReferenceInformation(TradeReferenceInformation _tradeReferenceInformation) {
			this.tradeReferenceInformation = _tradeReferenceInformation == null ? null : _tradeReferenceInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradePackage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradePackage")
		@Override
		public TradeWrapper.TradeWrapperBuilder setTradePackage(TradePackage _tradePackage) {
			this.tradePackage = _tradePackage == null ? null : _tradePackage.toBuilder();
			return this;
		}
		
		@Override
		public TradeWrapper build() {
			return new TradeWrapper.TradeWrapperImpl(this);
		}
		
		@Override
		public TradeWrapper.TradeWrapperBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeWrapper.TradeWrapperBuilder prune() {
			if (originatingEvent!=null && !originatingEvent.prune().hasData()) originatingEvent = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (tradeReferenceInformation!=null && !tradeReferenceInformation.prune().hasData()) tradeReferenceInformation = null;
			if (tradePackage!=null && !tradePackage.prune().hasData()) tradePackage = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOriginatingEvent()!=null && getOriginatingEvent().hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getTradeReferenceInformation()!=null && getTradeReferenceInformation().hasData()) return true;
			if (getTradePackage()!=null && getTradePackage().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeWrapper.TradeWrapperBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeWrapper.TradeWrapperBuilder o = (TradeWrapper.TradeWrapperBuilder) other;
			
			merger.mergeRosetta(getOriginatingEvent(), o.getOriginatingEvent(), this::setOriginatingEvent);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getTradeReferenceInformation(), o.getTradeReferenceInformation(), this::setTradeReferenceInformation);
			merger.mergeRosetta(getTradePackage(), o.getTradePackage(), this::setTradePackage);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeWrapper _that = getType().cast(o);
		
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(tradeReferenceInformation, _that.getTradeReferenceInformation())) return false;
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradeReferenceInformation != null ? tradeReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeWrapperBuilder {" +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade + ", " +
				"tradeReferenceInformation=" + this.tradeReferenceInformation + ", " +
				"tradePackage=" + this.tradePackage +
			'}';
		}
	}
}
