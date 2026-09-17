package fpml.consolidated.msg;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.doc.AdditionalData;
import fpml.consolidated.doc.Reason;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.meta.ExceptionMeta;
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
 * Provision A type defining the basic content for a message sent to inform another system that some exception has been detected.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the basic content for a message sent to inform another system that some exception has been detected.
 *
 */
@RosettaDataType(value="Exception", builder=Exception.ExceptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Exception", model="fpml", builder=Exception.ExceptionBuilderImpl.class, version="2.1.1")
public interface Exception extends Message {

	ExceptionMeta metaData = new ExceptionMeta();

	/*********************** Getter Methods  ***********************/
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
	ExceptionMessageHeader getHeader();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A list of validation sets the sender asserts the document is valid with respect to.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A list of validation sets the sender asserts the document is valid with respect to.
	 *
	 */
	List<? extends Validation> getValidation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional identifier used to correlate between related processes
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional identifier used to correlate between related processes
	 *
	 */
	CorrelationId getParentCorrelationId();
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
	 * Provision An instance of the Reason type used to record the nature of any errors associated with a message.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An instance of the Reason type used to record the nature of any errors associated with a message.
	 *
	 */
	List<? extends Reason> getReason();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Any string of additional data that may help the message processor, for example in a rejection message this might contain a code value or the text of the original request (within a CDATA section).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Any string of additional data that may help the message processor, for example in a rejection message this might contain a code value or the text of the original request (within a CDATA section).
	 *
	 */
	AdditionalData getAdditionalData();

	/*********************** Build Methods  ***********************/
	Exception build();
	
	Exception.ExceptionBuilder toBuilder();
	
	static Exception.ExceptionBuilder builder() {
		return new Exception.ExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Exception> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Exception> getType() {
		return Exception.class;
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
	interface ExceptionBuilder extends Exception, Message.MessageBuilder {
		ExceptionMessageHeader.ExceptionMessageHeaderBuilder getOrCreateHeader();
		@Override
		ExceptionMessageHeader.ExceptionMessageHeaderBuilder getHeader();
		Validation.ValidationBuilder getOrCreateValidation(int index);
		@Override
		List<? extends Validation.ValidationBuilder> getValidation();
		CorrelationId.CorrelationIdBuilder getOrCreateParentCorrelationId();
		@Override
		CorrelationId.CorrelationIdBuilder getParentCorrelationId();
		CorrelationId.CorrelationIdBuilder getOrCreateCorrelationId(int index);
		@Override
		List<? extends CorrelationId.CorrelationIdBuilder> getCorrelationId();
		Reason.ReasonBuilder getOrCreateReason(int index);
		@Override
		List<? extends Reason.ReasonBuilder> getReason();
		AdditionalData.AdditionalDataBuilder getOrCreateAdditionalData();
		@Override
		AdditionalData.AdditionalDataBuilder getAdditionalData();
		@Override
		Exception.ExceptionBuilder setFpmlVersion(String fpmlVersion);
		@Override
		Exception.ExceptionBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		Exception.ExceptionBuilder setActualBuild(Integer actualBuild);
		Exception.ExceptionBuilder setHeader(ExceptionMessageHeader header);
		Exception.ExceptionBuilder addValidation(Validation validation);
		Exception.ExceptionBuilder addValidation(Validation validation, int idx);
		Exception.ExceptionBuilder addValidation(List<? extends Validation> validation);
		Exception.ExceptionBuilder setValidation(List<? extends Validation> validation);
		Exception.ExceptionBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		Exception.ExceptionBuilder addCorrelationId(CorrelationId correlationId);
		Exception.ExceptionBuilder addCorrelationId(CorrelationId correlationId, int idx);
		Exception.ExceptionBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		Exception.ExceptionBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		Exception.ExceptionBuilder setSequenceNumber(Integer sequenceNumber);
		Exception.ExceptionBuilder addReason(Reason reason);
		Exception.ExceptionBuilder addReason(Reason reason, int idx);
		Exception.ExceptionBuilder addReason(List<? extends Reason> reason);
		Exception.ExceptionBuilder setReason(List<? extends Reason> reason);
		Exception.ExceptionBuilder setAdditionalData(AdditionalData additionalData);

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
		

		Exception.ExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of Exception  ***********************/
	class ExceptionImpl extends Message.MessageImpl implements Exception {
		private final ExceptionMessageHeader header;
		private final List<? extends Validation> validation;
		private final CorrelationId parentCorrelationId;
		private final List<? extends CorrelationId> correlationId;
		private final Integer sequenceNumber;
		private final List<? extends Reason> reason;
		private final AdditionalData additionalData;
		
		protected ExceptionImpl(Exception.ExceptionBuilder builder) {
			super(builder);
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.validation = ofNullable(builder.getValidation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.parentCorrelationId = ofNullable(builder.getParentCorrelationId()).map(f->f.build()).orElse(null);
			this.correlationId = ofNullable(builder.getCorrelationId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.sequenceNumber = builder.getSequenceNumber();
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalData = ofNullable(builder.getAdditionalData()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("header")
		public ExceptionMessageHeader getHeader() {
			return header;
		}
		
		@Override
		@RosettaAttribute("validation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("validation")
		public List<? extends Validation> getValidation() {
			return validation;
		}
		
		@Override
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parentCorrelationId")
		public CorrelationId getParentCorrelationId() {
			return parentCorrelationId;
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
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<? extends Reason> getReason() {
			return reason;
		}
		
		@Override
		@RosettaAttribute("additionalData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalData")
		public AdditionalData getAdditionalData() {
			return additionalData;
		}
		
		@Override
		public Exception build() {
			return this;
		}
		
		@Override
		public Exception.ExceptionBuilder toBuilder() {
			Exception.ExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Exception.ExceptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getValidation()).ifPresent(builder::setValidation);
			ofNullable(getParentCorrelationId()).ifPresent(builder::setParentCorrelationId);
			ofNullable(getCorrelationId()).ifPresent(builder::setCorrelationId);
			ofNullable(getSequenceNumber()).ifPresent(builder::setSequenceNumber);
			ofNullable(getReason()).ifPresent(builder::setReason);
			ofNullable(getAdditionalData()).ifPresent(builder::setAdditionalData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Exception _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!ListEquals.listEquals(validation, _that.getValidation())) return false;
			if (!Objects.equals(parentCorrelationId, _that.getParentCorrelationId())) return false;
			if (!ListEquals.listEquals(correlationId, _that.getCorrelationId())) return false;
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!Objects.equals(additionalData, _that.getAdditionalData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (validation != null ? validation.hashCode() : 0);
			_result = 31 * _result + (parentCorrelationId != null ? parentCorrelationId.hashCode() : 0);
			_result = 31 * _result + (correlationId != null ? correlationId.hashCode() : 0);
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (additionalData != null ? additionalData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Exception {" +
				"header=" + this.header + ", " +
				"validation=" + this.validation + ", " +
				"parentCorrelationId=" + this.parentCorrelationId + ", " +
				"correlationId=" + this.correlationId + ", " +
				"sequenceNumber=" + this.sequenceNumber + ", " +
				"reason=" + this.reason + ", " +
				"additionalData=" + this.additionalData +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Exception  ***********************/
	class ExceptionBuilderImpl extends Message.MessageBuilderImpl implements Exception.ExceptionBuilder {
	
		protected ExceptionMessageHeader.ExceptionMessageHeaderBuilder header;
		protected List<Validation.ValidationBuilder> validation = new ArrayList<>();
		protected CorrelationId.CorrelationIdBuilder parentCorrelationId;
		protected List<CorrelationId.CorrelationIdBuilder> correlationId = new ArrayList<>();
		protected Integer sequenceNumber;
		protected List<Reason.ReasonBuilder> reason = new ArrayList<>();
		protected AdditionalData.AdditionalDataBuilder additionalData;
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("header")
		public ExceptionMessageHeader.ExceptionMessageHeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public ExceptionMessageHeader.ExceptionMessageHeaderBuilder getOrCreateHeader() {
			ExceptionMessageHeader.ExceptionMessageHeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = ExceptionMessageHeader.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("validation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("validation")
		public List<? extends Validation.ValidationBuilder> getValidation() {
			return validation;
		}
		
		@Override
		public Validation.ValidationBuilder getOrCreateValidation(int index) {
			if (validation==null) {
				this.validation = new ArrayList<>();
			}
			return getIndex(validation, index, () -> {
						Validation.ValidationBuilder newValidation = Validation.builder();
						return newValidation;
					});
		}
		
		@Override
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parentCorrelationId")
		public CorrelationId.CorrelationIdBuilder getParentCorrelationId() {
			return parentCorrelationId;
		}
		
		@Override
		public CorrelationId.CorrelationIdBuilder getOrCreateParentCorrelationId() {
			CorrelationId.CorrelationIdBuilder result;
			if (parentCorrelationId!=null) {
				result = parentCorrelationId;
			}
			else {
				result = parentCorrelationId = CorrelationId.builder();
			}
			
			return result;
		}
		
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
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<? extends Reason.ReasonBuilder> getReason() {
			return reason;
		}
		
		@Override
		public Reason.ReasonBuilder getOrCreateReason(int index) {
			if (reason==null) {
				this.reason = new ArrayList<>();
			}
			return getIndex(reason, index, () -> {
						Reason.ReasonBuilder newReason = Reason.builder();
						return newReason;
					});
		}
		
		@Override
		@RosettaAttribute("additionalData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalData")
		public AdditionalData.AdditionalDataBuilder getAdditionalData() {
			return additionalData;
		}
		
		@Override
		public AdditionalData.AdditionalDataBuilder getOrCreateAdditionalData() {
			AdditionalData.AdditionalDataBuilder result;
			if (additionalData!=null) {
				result = additionalData;
			}
			else {
				result = additionalData = AdditionalData.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public Exception.ExceptionBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public Exception.ExceptionBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public Exception.ExceptionBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public Exception.ExceptionBuilder setHeader(ExceptionMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public Exception.ExceptionBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public Exception.ExceptionBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public Exception.ExceptionBuilder addValidation(List<? extends Validation> validations) {
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
		public Exception.ExceptionBuilder setValidation(List<? extends Validation> validations) {
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
		public Exception.ExceptionBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public Exception.ExceptionBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Exception.ExceptionBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public Exception.ExceptionBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public Exception.ExceptionBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public Exception.ExceptionBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public Exception.ExceptionBuilder addReason(Reason _reason) {
			if (_reason != null) {
				this.reason.add(_reason.toBuilder());
			}
			return this;
		}
		
		@Override
		public Exception.ExceptionBuilder addReason(Reason _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason.toBuilder());
			return this;
		}
		
		@Override
		public Exception.ExceptionBuilder addReason(List<? extends Reason> reasons) {
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
		public Exception.ExceptionBuilder setReason(List<? extends Reason> reasons) {
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
		public Exception.ExceptionBuilder setAdditionalData(AdditionalData _additionalData) {
			this.additionalData = _additionalData == null ? null : _additionalData.toBuilder();
			return this;
		}
		
		@Override
		public Exception build() {
			return new Exception.ExceptionImpl(this);
		}
		
		@Override
		public Exception.ExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Exception.ExceptionBuilder prune() {
			super.prune();
			if (header!=null && !header.prune().hasData()) header = null;
			validation = validation.stream().filter(b->b!=null).<Validation.ValidationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (parentCorrelationId!=null && !parentCorrelationId.prune().hasData()) parentCorrelationId = null;
			correlationId = correlationId.stream().filter(b->b!=null).<CorrelationId.CorrelationIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			reason = reason.stream().filter(b->b!=null).<Reason.ReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (additionalData!=null && !additionalData.prune().hasData()) additionalData = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHeader()!=null && getHeader().hasData()) return true;
			if (getValidation()!=null && getValidation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParentCorrelationId()!=null && getParentCorrelationId().hasData()) return true;
			if (getCorrelationId()!=null && getCorrelationId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSequenceNumber()!=null) return true;
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalData()!=null && getAdditionalData().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Exception.ExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Exception.ExceptionBuilder o = (Exception.ExceptionBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getValidation(), o.getValidation(), this::getOrCreateValidation);
			merger.mergeRosetta(getParentCorrelationId(), o.getParentCorrelationId(), this::setParentCorrelationId);
			merger.mergeRosetta(getCorrelationId(), o.getCorrelationId(), this::getOrCreateCorrelationId);
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			merger.mergeRosetta(getAdditionalData(), o.getAdditionalData(), this::setAdditionalData);
			
			merger.mergeBasic(getSequenceNumber(), o.getSequenceNumber(), this::setSequenceNumber);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Exception _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!ListEquals.listEquals(validation, _that.getValidation())) return false;
			if (!Objects.equals(parentCorrelationId, _that.getParentCorrelationId())) return false;
			if (!ListEquals.listEquals(correlationId, _that.getCorrelationId())) return false;
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!Objects.equals(additionalData, _that.getAdditionalData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (validation != null ? validation.hashCode() : 0);
			_result = 31 * _result + (parentCorrelationId != null ? parentCorrelationId.hashCode() : 0);
			_result = 31 * _result + (correlationId != null ? correlationId.hashCode() : 0);
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (additionalData != null ? additionalData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExceptionBuilder {" +
				"header=" + this.header + ", " +
				"validation=" + this.validation + ", " +
				"parentCorrelationId=" + this.parentCorrelationId + ", " +
				"correlationId=" + this.correlationId + ", " +
				"sequenceNumber=" + this.sequenceNumber + ", " +
				"reason=" + this.reason + ", " +
				"additionalData=" + this.additionalData +
			'}' + " " + super.toString();
		}
	}
}
