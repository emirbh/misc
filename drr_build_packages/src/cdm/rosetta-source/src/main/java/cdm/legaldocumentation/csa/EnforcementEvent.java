package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.EnforcementEventMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify Enforcement Events specific to Security Agreements.
 * @version 6.23.0
 */
@RosettaDataType(value="EnforcementEvent", builder=EnforcementEvent.EnforcementEventBuilderImpl.class, version="6.23.0")
@RuneDataType(value="EnforcementEvent", model="cdm", builder=EnforcementEvent.EnforcementEventBuilderImpl.class, version="6.23.0")
public interface EnforcementEvent extends RosettaModelObject {

	EnforcementEventMeta metaData = new EnforcementEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The early termination election.
	 */
	Boolean getEarlyTerminationDate();
	/**
	 * The failure to pay election.
	 */
	Boolean getFailureToPay();

	/*********************** Build Methods  ***********************/
	EnforcementEvent build();
	
	EnforcementEvent.EnforcementEventBuilder toBuilder();
	
	static EnforcementEvent.EnforcementEventBuilder builder() {
		return new EnforcementEvent.EnforcementEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnforcementEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnforcementEvent> getType() {
		return EnforcementEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("earlyTerminationDate"), Boolean.class, getEarlyTerminationDate(), this);
		processor.processBasic(path.newSubPath("failureToPay"), Boolean.class, getFailureToPay(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnforcementEventBuilder extends EnforcementEvent, RosettaModelObjectBuilder {
		EnforcementEvent.EnforcementEventBuilder setEarlyTerminationDate(Boolean earlyTerminationDate);
		EnforcementEvent.EnforcementEventBuilder setFailureToPay(Boolean failureToPay);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("earlyTerminationDate"), Boolean.class, getEarlyTerminationDate(), this);
			processor.processBasic(path.newSubPath("failureToPay"), Boolean.class, getFailureToPay(), this);
		}
		

		EnforcementEvent.EnforcementEventBuilder prune();
	}

	/*********************** Immutable Implementation of EnforcementEvent  ***********************/
	class EnforcementEventImpl implements EnforcementEvent {
		private final Boolean earlyTerminationDate;
		private final Boolean failureToPay;
		
		protected EnforcementEventImpl(EnforcementEvent.EnforcementEventBuilder builder) {
			this.earlyTerminationDate = builder.getEarlyTerminationDate();
			this.failureToPay = builder.getFailureToPay();
		}
		
		@Override
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("earlyTerminationDate")
		public Boolean getEarlyTerminationDate() {
			return earlyTerminationDate;
		}
		
		@Override
		@RosettaAttribute("failureToPay")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("failureToPay")
		public Boolean getFailureToPay() {
			return failureToPay;
		}
		
		@Override
		public EnforcementEvent build() {
			return this;
		}
		
		@Override
		public EnforcementEvent.EnforcementEventBuilder toBuilder() {
			EnforcementEvent.EnforcementEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnforcementEvent.EnforcementEventBuilder builder) {
			ofNullable(getEarlyTerminationDate()).ifPresent(builder::setEarlyTerminationDate);
			ofNullable(getFailureToPay()).ifPresent(builder::setFailureToPay);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnforcementEvent _that = getType().cast(o);
		
			if (!Objects.equals(earlyTerminationDate, _that.getEarlyTerminationDate())) return false;
			if (!Objects.equals(failureToPay, _that.getFailureToPay())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (earlyTerminationDate != null ? earlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (failureToPay != null ? failureToPay.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnforcementEvent {" +
				"earlyTerminationDate=" + this.earlyTerminationDate + ", " +
				"failureToPay=" + this.failureToPay +
			'}';
		}
	}

	/*********************** Builder Implementation of EnforcementEvent  ***********************/
	class EnforcementEventBuilderImpl implements EnforcementEvent.EnforcementEventBuilder {
	
		protected Boolean earlyTerminationDate;
		protected Boolean failureToPay;
		
		@Override
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("earlyTerminationDate")
		public Boolean getEarlyTerminationDate() {
			return earlyTerminationDate;
		}
		
		@Override
		@RosettaAttribute("failureToPay")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("failureToPay")
		public Boolean getFailureToPay() {
			return failureToPay;
		}
		
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("earlyTerminationDate")
		@Override
		public EnforcementEvent.EnforcementEventBuilder setEarlyTerminationDate(Boolean _earlyTerminationDate) {
			this.earlyTerminationDate = _earlyTerminationDate == null ? null : _earlyTerminationDate;
			return this;
		}
		
		@RosettaAttribute("failureToPay")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("failureToPay")
		@Override
		public EnforcementEvent.EnforcementEventBuilder setFailureToPay(Boolean _failureToPay) {
			this.failureToPay = _failureToPay == null ? null : _failureToPay;
			return this;
		}
		
		@Override
		public EnforcementEvent build() {
			return new EnforcementEvent.EnforcementEventImpl(this);
		}
		
		@Override
		public EnforcementEvent.EnforcementEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnforcementEvent.EnforcementEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEarlyTerminationDate()!=null) return true;
			if (getFailureToPay()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnforcementEvent.EnforcementEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnforcementEvent.EnforcementEventBuilder o = (EnforcementEvent.EnforcementEventBuilder) other;
			
			
			merger.mergeBasic(getEarlyTerminationDate(), o.getEarlyTerminationDate(), this::setEarlyTerminationDate);
			merger.mergeBasic(getFailureToPay(), o.getFailureToPay(), this::setFailureToPay);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnforcementEvent _that = getType().cast(o);
		
			if (!Objects.equals(earlyTerminationDate, _that.getEarlyTerminationDate())) return false;
			if (!Objects.equals(failureToPay, _that.getFailureToPay())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (earlyTerminationDate != null ? earlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (failureToPay != null ? failureToPay.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnforcementEventBuilder {" +
				"earlyTerminationDate=" + this.earlyTerminationDate + ", " +
				"failureToPay=" + this.failureToPay +
			'}';
		}
	}
}
