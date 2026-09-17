package fpml.consolidated.msg;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.doc.AdditionalData;
import fpml.consolidated.doc.Reason;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.meta.MessageRejectedMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The root element used for rejected message exceptions
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The root element used for rejected message exceptions
 *
 */
@RosettaDataType(value="MessageRejected", builder=MessageRejected.MessageRejectedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MessageRejected", model="fpml", builder=MessageRejected.MessageRejectedBuilderImpl.class, version="2.1.1")
public interface MessageRejected extends fpml.consolidated.msg.Exception {

	MessageRejectedMeta metaData = new MessageRejectedMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	MessageRejected build();
	
	MessageRejected.MessageRejectedBuilder toBuilder();
	
	static MessageRejected.MessageRejectedBuilder builder() {
		return new MessageRejected.MessageRejectedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MessageRejected> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MessageRejected> getType() {
		return MessageRejected.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("reason"), processor, Reason.class, getReason());
		processRosetta(path.newSubPath("additionalData"), processor, AdditionalData.class, getAdditionalData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MessageRejectedBuilder extends MessageRejected, Exception.ExceptionBuilder {
		@Override
		MessageRejected.MessageRejectedBuilder setFpmlVersion(String fpmlVersion);
		@Override
		MessageRejected.MessageRejectedBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		MessageRejected.MessageRejectedBuilder setActualBuild(Integer actualBuild);
		@Override
		MessageRejected.MessageRejectedBuilder setHeader(ExceptionMessageHeader header);
		@Override
		MessageRejected.MessageRejectedBuilder addValidation(Validation validation);
		@Override
		MessageRejected.MessageRejectedBuilder addValidation(Validation validation, int idx);
		@Override
		MessageRejected.MessageRejectedBuilder addValidation(List<? extends Validation> validation);
		@Override
		MessageRejected.MessageRejectedBuilder setValidation(List<? extends Validation> validation);
		@Override
		MessageRejected.MessageRejectedBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		MessageRejected.MessageRejectedBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		MessageRejected.MessageRejectedBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		MessageRejected.MessageRejectedBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		MessageRejected.MessageRejectedBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		MessageRejected.MessageRejectedBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		MessageRejected.MessageRejectedBuilder addReason(Reason reason);
		@Override
		MessageRejected.MessageRejectedBuilder addReason(Reason reason, int idx);
		@Override
		MessageRejected.MessageRejectedBuilder addReason(List<? extends Reason> reason);
		@Override
		MessageRejected.MessageRejectedBuilder setReason(List<? extends Reason> reason);
		@Override
		MessageRejected.MessageRejectedBuilder setAdditionalData(AdditionalData additionalData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("reason"), processor, Reason.ReasonBuilder.class, getReason());
			processRosetta(path.newSubPath("additionalData"), processor, AdditionalData.AdditionalDataBuilder.class, getAdditionalData());
		}
		

		MessageRejected.MessageRejectedBuilder prune();
	}

	/*********************** Immutable Implementation of MessageRejected  ***********************/
	class MessageRejectedImpl extends Exception.ExceptionImpl implements MessageRejected {
		
		protected MessageRejectedImpl(MessageRejected.MessageRejectedBuilder builder) {
			super(builder);
		}
		
		@Override
		public MessageRejected build() {
			return this;
		}
		
		@Override
		public MessageRejected.MessageRejectedBuilder toBuilder() {
			MessageRejected.MessageRejectedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MessageRejected.MessageRejectedBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageRejected {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MessageRejected  ***********************/
	class MessageRejectedBuilderImpl extends Exception.ExceptionBuilderImpl implements MessageRejected.MessageRejectedBuilder {
	
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public MessageRejected.MessageRejectedBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public MessageRejected.MessageRejectedBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public MessageRejected.MessageRejectedBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public MessageRejected.MessageRejectedBuilder setHeader(ExceptionMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public MessageRejected.MessageRejectedBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public MessageRejected.MessageRejectedBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public MessageRejected.MessageRejectedBuilder addValidation(List<? extends Validation> validations) {
			if (validations != null) {
				for (final Validation toAdd : validations) {
					this.validation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public MessageRejected.MessageRejectedBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null) {
				this.validation = new ArrayList<>();
			} else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public MessageRejected.MessageRejectedBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public MessageRejected.MessageRejectedBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public MessageRejected.MessageRejectedBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public MessageRejected.MessageRejectedBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public MessageRejected.MessageRejectedBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public MessageRejected.MessageRejectedBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public MessageRejected.MessageRejectedBuilder addReason(Reason _reason) {
			if (_reason != null) {
				this.reason.add(_reason.toBuilder());
			}
			return this;
		}
		
		@Override
		public MessageRejected.MessageRejectedBuilder addReason(Reason _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason.toBuilder());
			return this;
		}
		
		@Override
		public MessageRejected.MessageRejectedBuilder addReason(List<? extends Reason> reasons) {
			if (reasons != null) {
				for (final Reason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public MessageRejected.MessageRejectedBuilder setReason(List<? extends Reason> reasons) {
			if (reasons == null) {
				this.reason = new ArrayList<>();
			} else {
				this.reason = reasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("additionalData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalData")
		@Override
		public MessageRejected.MessageRejectedBuilder setAdditionalData(AdditionalData _additionalData) {
			this.additionalData = _additionalData == null ? null : _additionalData.toBuilder();
			return this;
		}
		
		@Override
		public MessageRejected build() {
			return new MessageRejected.MessageRejectedImpl(this);
		}
		
		@Override
		public MessageRejected.MessageRejectedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageRejected.MessageRejectedBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageRejected.MessageRejectedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MessageRejected.MessageRejectedBuilder o = (MessageRejected.MessageRejectedBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageRejectedBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
