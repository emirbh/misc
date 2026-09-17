package fpml.consolidated.credit.event.notification;

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
import fpml.consolidated.credit.event.notification.meta.AffectedTransactionsChoiceMeta;
import fpml.consolidated.doc.PartyTradeIdentifiers;
import fpml.consolidated.doc.Trade;
import java.util.Objects;

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
@RosettaDataType(value="AffectedTransactionsChoice", builder=AffectedTransactionsChoice.AffectedTransactionsChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AffectedTransactionsChoice", model="fpml", builder=AffectedTransactionsChoice.AffectedTransactionsChoiceBuilderImpl.class, version="2.1.1")
public interface AffectedTransactionsChoice extends RosettaModelObject {

	AffectedTransactionsChoiceMeta metaData = new AffectedTransactionsChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An element that allows the full details of the trade to be used as a mechanism for identifying the trade for which the post-trade event pertains
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An element that allows the full details of the trade to be used as a mechanism for identifying the trade for which the post-trade event pertains
	 *
	 */
	Trade getTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A container since an individual trade can be referenced by two or more different partyTradeIdentifier elements - each allocated by a different party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A container since an individual trade can be referenced by two or more different partyTradeIdentifier elements - each allocated by a different party.
	 *
	 */
	PartyTradeIdentifiers getTradeReference();

	/*********************** Build Methods  ***********************/
	AffectedTransactionsChoice build();
	
	AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder toBuilder();
	
	static AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder builder() {
		return new AffectedTransactionsChoice.AffectedTransactionsChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AffectedTransactionsChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AffectedTransactionsChoice> getType() {
		return AffectedTransactionsChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("tradeReference"), processor, PartyTradeIdentifiers.class, getTradeReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AffectedTransactionsChoiceBuilder extends AffectedTransactionsChoice, RosettaModelObjectBuilder {
		Trade.TradeBuilder getOrCreateTrade();
		@Override
		Trade.TradeBuilder getTrade();
		PartyTradeIdentifiers.PartyTradeIdentifiersBuilder getOrCreateTradeReference();
		@Override
		PartyTradeIdentifiers.PartyTradeIdentifiersBuilder getTradeReference();
		AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder setTrade(Trade trade);
		AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder setTradeReference(PartyTradeIdentifiers tradeReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("tradeReference"), processor, PartyTradeIdentifiers.PartyTradeIdentifiersBuilder.class, getTradeReference());
		}
		

		AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of AffectedTransactionsChoice  ***********************/
	class AffectedTransactionsChoiceImpl implements AffectedTransactionsChoice {
		private final Trade trade;
		private final PartyTradeIdentifiers tradeReference;
		
		protected AffectedTransactionsChoiceImpl(AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder builder) {
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.tradeReference = ofNullable(builder.getTradeReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("tradeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeReference")
		public PartyTradeIdentifiers getTradeReference() {
			return tradeReference;
		}
		
		@Override
		public AffectedTransactionsChoice build() {
			return this;
		}
		
		@Override
		public AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder toBuilder() {
			AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder builder) {
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getTradeReference()).ifPresent(builder::setTradeReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AffectedTransactionsChoice _that = getType().cast(o);
		
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(tradeReference, _that.getTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AffectedTransactionsChoice {" +
				"trade=" + this.trade + ", " +
				"tradeReference=" + this.tradeReference +
			'}';
		}
	}

	/*********************** Builder Implementation of AffectedTransactionsChoice  ***********************/
	class AffectedTransactionsChoiceBuilderImpl implements AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder {
	
		protected Trade.TradeBuilder trade;
		protected PartyTradeIdentifiers.PartyTradeIdentifiersBuilder tradeReference;
		
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
		@RosettaAttribute("tradeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeReference")
		public PartyTradeIdentifiers.PartyTradeIdentifiersBuilder getTradeReference() {
			return tradeReference;
		}
		
		@Override
		public PartyTradeIdentifiers.PartyTradeIdentifiersBuilder getOrCreateTradeReference() {
			PartyTradeIdentifiers.PartyTradeIdentifiersBuilder result;
			if (tradeReference!=null) {
				result = tradeReference;
			}
			else {
				result = tradeReference = PartyTradeIdentifiers.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeReference")
		@Override
		public AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder setTradeReference(PartyTradeIdentifiers _tradeReference) {
			this.tradeReference = _tradeReference == null ? null : _tradeReference.toBuilder();
			return this;
		}
		
		@Override
		public AffectedTransactionsChoice build() {
			return new AffectedTransactionsChoice.AffectedTransactionsChoiceImpl(this);
		}
		
		@Override
		public AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder prune() {
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (tradeReference!=null && !tradeReference.prune().hasData()) tradeReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getTradeReference()!=null && getTradeReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder o = (AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder) other;
			
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getTradeReference(), o.getTradeReference(), this::setTradeReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AffectedTransactionsChoice _that = getType().cast(o);
		
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(tradeReference, _that.getTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AffectedTransactionsChoiceBuilder {" +
				"trade=" + this.trade + ", " +
				"tradeReference=" + this.tradeReference +
			'}';
		}
	}
}
