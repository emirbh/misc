package fpml.consolidated.msg;

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
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.msg.meta.EventIdentifierMeta;
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
 * Provision Identification of a business event, for example through its correlation id or a business identifier.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Identification of a business event, for example through its correlation id or a business identifier.
 *
 */
@RosettaDataType(value="EventIdentifier", builder=EventIdentifier.EventIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EventIdentifier", model="fpml", builder=EventIdentifier.EventIdentifierBuilderImpl.class, version="2.1.1")
public interface EventIdentifier extends RosettaModelObject {

	EventIdentifierMeta metaData = new EventIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A qualified identifier used to correlate between messages
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A qualified identifier used to correlate between messages
	 *
	 */
	List<? extends CorrelationId> getCorrelationId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A numeric value that can be used to order messages with the same correlation identifier from the same sender.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A numeric value that can be used to order messages with the same correlation identifier from the same sender.
	 *
	 */
	Integer getSequenceNumber();
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
	TradeIdentifier getTradeIdentifier();

	/*********************** Build Methods  ***********************/
	EventIdentifier build();
	
	EventIdentifier.EventIdentifierBuilder toBuilder();
	
	static EventIdentifier.EventIdentifierBuilder builder() {
		return new EventIdentifier.EventIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EventIdentifier> getType() {
		return EventIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.class, getTradeIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventIdentifierBuilder extends EventIdentifier, RosettaModelObjectBuilder {
		CorrelationId.CorrelationIdBuilder getOrCreateCorrelationId(int index);
		@Override
		List<? extends CorrelationId.CorrelationIdBuilder> getCorrelationId();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier();
		@Override
		TradeIdentifier.TradeIdentifierBuilder getTradeIdentifier();
		EventIdentifier.EventIdentifierBuilder addCorrelationId(CorrelationId correlationId);
		EventIdentifier.EventIdentifierBuilder addCorrelationId(CorrelationId correlationId, int idx);
		EventIdentifier.EventIdentifierBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		EventIdentifier.EventIdentifierBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		EventIdentifier.EventIdentifierBuilder setSequenceNumber(Integer sequenceNumber);
		EventIdentifier.EventIdentifierBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTradeIdentifier());
		}
		

		EventIdentifier.EventIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of EventIdentifier  ***********************/
	class EventIdentifierImpl implements EventIdentifier {
		private final List<? extends CorrelationId> correlationId;
		private final Integer sequenceNumber;
		private final TradeIdentifier tradeIdentifier;
		
		protected EventIdentifierImpl(EventIdentifier.EventIdentifierBuilder builder) {
			this.correlationId = ofNullable(builder.getCorrelationId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.sequenceNumber = builder.getSequenceNumber();
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("correlationId")
		public List<? extends CorrelationId> getCorrelationId() {
			return correlationId;
		}
		
		@Override
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sequenceNumber")
		public Integer getSequenceNumber() {
			return sequenceNumber;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeIdentifier")
		public TradeIdentifier getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public EventIdentifier build() {
			return this;
		}
		
		@Override
		public EventIdentifier.EventIdentifierBuilder toBuilder() {
			EventIdentifier.EventIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventIdentifier.EventIdentifierBuilder builder) {
			ofNullable(getCorrelationId()).ifPresent(builder::setCorrelationId);
			ofNullable(getSequenceNumber()).ifPresent(builder::setSequenceNumber);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventIdentifier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(correlationId, _that.getCorrelationId())) return false;
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (correlationId != null ? correlationId.hashCode() : 0);
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventIdentifier {" +
				"correlationId=" + this.correlationId + ", " +
				"sequenceNumber=" + this.sequenceNumber + ", " +
				"tradeIdentifier=" + this.tradeIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of EventIdentifier  ***********************/
	class EventIdentifierBuilderImpl implements EventIdentifier.EventIdentifierBuilder {
	
		protected List<CorrelationId.CorrelationIdBuilder> correlationId = new ArrayList<>();
		protected Integer sequenceNumber;
		protected TradeIdentifier.TradeIdentifierBuilder tradeIdentifier;
		
		@Override
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("correlationId")
		public List<? extends CorrelationId.CorrelationIdBuilder> getCorrelationId() {
			return correlationId;
		}
		
		@Override
		public CorrelationId.CorrelationIdBuilder getOrCreateCorrelationId(int index) {
			if (correlationId==null) {
				this.correlationId = new ArrayList<>();
			}
			return getIndex(correlationId, index, () -> {
						CorrelationId.CorrelationIdBuilder newCorrelationId = CorrelationId.builder();
						return newCorrelationId;
					});
		}
		
		@Override
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sequenceNumber")
		public Integer getSequenceNumber() {
			return sequenceNumber;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeIdentifier")
		public TradeIdentifier.TradeIdentifierBuilder getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (tradeIdentifier!=null) {
				result = tradeIdentifier;
			}
			else {
				result = tradeIdentifier = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public EventIdentifier.EventIdentifierBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public EventIdentifier.EventIdentifierBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public EventIdentifier.EventIdentifierBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds != null) {
				for (final CorrelationId toAdd : correlationIds) {
					this.correlationId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public EventIdentifier.EventIdentifierBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds == null) {
				this.correlationId = new ArrayList<>();
			} else {
				this.correlationId = correlationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sequenceNumber")
		@Override
		public EventIdentifier.EventIdentifierBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeIdentifier")
		@Override
		public EventIdentifier.EventIdentifierBuilder setTradeIdentifier(TradeIdentifier _tradeIdentifier) {
			this.tradeIdentifier = _tradeIdentifier == null ? null : _tradeIdentifier.toBuilder();
			return this;
		}
		
		@Override
		public EventIdentifier build() {
			return new EventIdentifier.EventIdentifierImpl(this);
		}
		
		@Override
		public EventIdentifier.EventIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventIdentifier.EventIdentifierBuilder prune() {
			correlationId = correlationId.stream().filter(b->b!=null).<CorrelationId.CorrelationIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradeIdentifier!=null && !tradeIdentifier.prune().hasData()) tradeIdentifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCorrelationId()!=null && getCorrelationId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSequenceNumber()!=null) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventIdentifier.EventIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventIdentifier.EventIdentifierBuilder o = (EventIdentifier.EventIdentifierBuilder) other;
			
			merger.mergeRosetta(getCorrelationId(), o.getCorrelationId(), this::getOrCreateCorrelationId);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::setTradeIdentifier);
			
			merger.mergeBasic(getSequenceNumber(), o.getSequenceNumber(), this::setSequenceNumber);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventIdentifier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(correlationId, _that.getCorrelationId())) return false;
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (correlationId != null ? correlationId.hashCode() : 0);
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventIdentifierBuilder {" +
				"correlationId=" + this.correlationId + ", " +
				"sequenceNumber=" + this.sequenceNumber + ", " +
				"tradeIdentifier=" + this.tradeIdentifier +
			'}';
		}
	}
}
