package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.recordkeeping.processes.meta.EventTimestampsMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision  DEPRECATED. Not in use (RPTWG decision 2024-12-12).
 *
 */
@RosettaDataType(value="EventTimestamps", builder=EventTimestamps.EventTimestampsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EventTimestamps", model="fpml", builder=EventTimestamps.EventTimestampsBuilderImpl.class, version="2.1.1")
public interface EventTimestamps extends RosettaModelObject {

	EventTimestampsMeta metaData = new EventTimestampsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). When the details of the event were agreed.
	 *
	 */
	ZonedDateTime getAgreementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). When the agreed details where recorded.
	 *
	 */
	ZonedDateTime getEntryDateTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). When the event was executed.
	 *
	 */
	ZonedDateTime getExecutionDateTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). When the event is actually effective from
	 *
	 */
	ZonedDateTime getEffectiveDate();

	/*********************** Build Methods  ***********************/
	EventTimestamps build();
	
	EventTimestamps.EventTimestampsBuilder toBuilder();
	
	static EventTimestamps.EventTimestampsBuilder builder() {
		return new EventTimestamps.EventTimestampsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventTimestamps> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EventTimestamps> getType() {
		return EventTimestamps.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("agreementDate"), ZonedDateTime.class, getAgreementDate(), this);
		processor.processBasic(path.newSubPath("entryDateTime"), ZonedDateTime.class, getEntryDateTime(), this);
		processor.processBasic(path.newSubPath("executionDateTime"), ZonedDateTime.class, getExecutionDateTime(), this);
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventTimestampsBuilder extends EventTimestamps, RosettaModelObjectBuilder {
		EventTimestamps.EventTimestampsBuilder setAgreementDate(ZonedDateTime agreementDate);
		EventTimestamps.EventTimestampsBuilder setEntryDateTime(ZonedDateTime entryDateTime);
		EventTimestamps.EventTimestampsBuilder setExecutionDateTime(ZonedDateTime executionDateTime);
		EventTimestamps.EventTimestampsBuilder setEffectiveDate(ZonedDateTime effectiveDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("agreementDate"), ZonedDateTime.class, getAgreementDate(), this);
			processor.processBasic(path.newSubPath("entryDateTime"), ZonedDateTime.class, getEntryDateTime(), this);
			processor.processBasic(path.newSubPath("executionDateTime"), ZonedDateTime.class, getExecutionDateTime(), this);
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		}
		

		EventTimestamps.EventTimestampsBuilder prune();
	}

	/*********************** Immutable Implementation of EventTimestamps  ***********************/
	class EventTimestampsImpl implements EventTimestamps {
		private final ZonedDateTime agreementDate;
		private final ZonedDateTime entryDateTime;
		private final ZonedDateTime executionDateTime;
		private final ZonedDateTime effectiveDate;
		
		protected EventTimestampsImpl(EventTimestamps.EventTimestampsBuilder builder) {
			this.agreementDate = builder.getAgreementDate();
			this.entryDateTime = builder.getEntryDateTime();
			this.executionDateTime = builder.getExecutionDateTime();
			this.effectiveDate = builder.getEffectiveDate();
		}
		
		@Override
		@RosettaAttribute("agreementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agreementDate")
		public ZonedDateTime getAgreementDate() {
			return agreementDate;
		}
		
		@Override
		@RosettaAttribute("entryDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entryDateTime")
		public ZonedDateTime getEntryDateTime() {
			return entryDateTime;
		}
		
		@Override
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionDateTime")
		public ZonedDateTime getExecutionDateTime() {
			return executionDateTime;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public EventTimestamps build() {
			return this;
		}
		
		@Override
		public EventTimestamps.EventTimestampsBuilder toBuilder() {
			EventTimestamps.EventTimestampsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventTimestamps.EventTimestampsBuilder builder) {
			ofNullable(getAgreementDate()).ifPresent(builder::setAgreementDate);
			ofNullable(getEntryDateTime()).ifPresent(builder::setEntryDateTime);
			ofNullable(getExecutionDateTime()).ifPresent(builder::setExecutionDateTime);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventTimestamps _that = getType().cast(o);
		
			if (!Objects.equals(agreementDate, _that.getAgreementDate())) return false;
			if (!Objects.equals(entryDateTime, _that.getEntryDateTime())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agreementDate != null ? agreementDate.hashCode() : 0);
			_result = 31 * _result + (entryDateTime != null ? entryDateTime.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventTimestamps {" +
				"agreementDate=" + this.agreementDate + ", " +
				"entryDateTime=" + this.entryDateTime + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}

	/*********************** Builder Implementation of EventTimestamps  ***********************/
	class EventTimestampsBuilderImpl implements EventTimestamps.EventTimestampsBuilder {
	
		protected ZonedDateTime agreementDate;
		protected ZonedDateTime entryDateTime;
		protected ZonedDateTime executionDateTime;
		protected ZonedDateTime effectiveDate;
		
		@Override
		@RosettaAttribute("agreementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agreementDate")
		public ZonedDateTime getAgreementDate() {
			return agreementDate;
		}
		
		@Override
		@RosettaAttribute("entryDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entryDateTime")
		public ZonedDateTime getEntryDateTime() {
			return entryDateTime;
		}
		
		@Override
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionDateTime")
		public ZonedDateTime getExecutionDateTime() {
			return executionDateTime;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@RosettaAttribute("agreementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agreementDate")
		@Override
		public EventTimestamps.EventTimestampsBuilder setAgreementDate(ZonedDateTime _agreementDate) {
			this.agreementDate = _agreementDate == null ? null : _agreementDate;
			return this;
		}
		
		@RosettaAttribute("entryDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entryDateTime")
		@Override
		public EventTimestamps.EventTimestampsBuilder setEntryDateTime(ZonedDateTime _entryDateTime) {
			this.entryDateTime = _entryDateTime == null ? null : _entryDateTime;
			return this;
		}
		
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionDateTime")
		@Override
		public EventTimestamps.EventTimestampsBuilder setExecutionDateTime(ZonedDateTime _executionDateTime) {
			this.executionDateTime = _executionDateTime == null ? null : _executionDateTime;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public EventTimestamps.EventTimestampsBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@Override
		public EventTimestamps build() {
			return new EventTimestamps.EventTimestampsImpl(this);
		}
		
		@Override
		public EventTimestamps.EventTimestampsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventTimestamps.EventTimestampsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAgreementDate()!=null) return true;
			if (getEntryDateTime()!=null) return true;
			if (getExecutionDateTime()!=null) return true;
			if (getEffectiveDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventTimestamps.EventTimestampsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventTimestamps.EventTimestampsBuilder o = (EventTimestamps.EventTimestampsBuilder) other;
			
			
			merger.mergeBasic(getAgreementDate(), o.getAgreementDate(), this::setAgreementDate);
			merger.mergeBasic(getEntryDateTime(), o.getEntryDateTime(), this::setEntryDateTime);
			merger.mergeBasic(getExecutionDateTime(), o.getExecutionDateTime(), this::setExecutionDateTime);
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventTimestamps _that = getType().cast(o);
		
			if (!Objects.equals(agreementDate, _that.getAgreementDate())) return false;
			if (!Objects.equals(entryDateTime, _that.getEntryDateTime())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agreementDate != null ? agreementDate.hashCode() : 0);
			_result = 31 * _result + (entryDateTime != null ? entryDateTime.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventTimestampsBuilder {" +
				"agreementDate=" + this.agreementDate + ", " +
				"entryDateTime=" + this.entryDateTime + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}
}
