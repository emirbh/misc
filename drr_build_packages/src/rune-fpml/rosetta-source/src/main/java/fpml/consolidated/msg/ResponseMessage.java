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
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.meta.ResponseMessageMeta;
import fpml.consolidated.shared.OnBehalfOf;
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
 * Provision A type refining the generic message content model to make it specific to response messages.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type refining the generic message content model to make it specific to response messages.
 *
 */
@RosettaDataType(value="ResponseMessage", builder=ResponseMessage.ResponseMessageBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ResponseMessage", model="fpml", builder=ResponseMessage.ResponseMessageBuilderImpl.class, version="2.1.1")
public interface ResponseMessage extends Message {

	ResponseMessageMeta metaData = new ResponseMessageMeta();

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
	ResponseMessageHeader getHeader();
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
	 * Provision Indicates which party (or parties) (and accounts) a trade or event is being processed for. Normally there will only be a maximum of 2 parties, but in the case of a novation there could be a transferor, transferee, remaining party, and other remaining party. Also, in the context of a trade package there could be several parties for which limit check is requested, necessitating multiple onBehalfOf elements. Except for these cases, there should be no more than two onBehalfOf references in a message.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates which party (or parties) (and accounts) a trade or event is being processed for. Normally there will only be a maximum of 2 parties, but in the case of a novation there could be a transferor, transferee, remaining party, and other remaining party. Also, in the context of a trade package there could be several parties for which limit check is requested, necessitating multiple onBehalfOf elements. Except for these cases, there should be no more than two onBehalfOf references in a message.
	 *
	 */
	List<? extends OnBehalfOf> getOnBehalfOf();

	/*********************** Build Methods  ***********************/
	ResponseMessage build();
	
	ResponseMessage.ResponseMessageBuilder toBuilder();
	
	static ResponseMessage.ResponseMessageBuilder builder() {
		return new ResponseMessage.ResponseMessageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResponseMessage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ResponseMessage> getType() {
		return ResponseMessage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResponseMessageBuilder extends ResponseMessage, Message.MessageBuilder {
		ResponseMessageHeader.ResponseMessageHeaderBuilder getOrCreateHeader();
		@Override
		ResponseMessageHeader.ResponseMessageHeaderBuilder getHeader();
		Validation.ValidationBuilder getOrCreateValidation(int index);
		@Override
		List<? extends Validation.ValidationBuilder> getValidation();
		CorrelationId.CorrelationIdBuilder getOrCreateParentCorrelationId();
		@Override
		CorrelationId.CorrelationIdBuilder getParentCorrelationId();
		CorrelationId.CorrelationIdBuilder getOrCreateCorrelationId(int index);
		@Override
		List<? extends CorrelationId.CorrelationIdBuilder> getCorrelationId();
		OnBehalfOf.OnBehalfOfBuilder getOrCreateOnBehalfOf(int index);
		@Override
		List<? extends OnBehalfOf.OnBehalfOfBuilder> getOnBehalfOf();
		@Override
		ResponseMessage.ResponseMessageBuilder setFpmlVersion(String fpmlVersion);
		@Override
		ResponseMessage.ResponseMessageBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		ResponseMessage.ResponseMessageBuilder setActualBuild(Integer actualBuild);
		ResponseMessage.ResponseMessageBuilder setHeader(ResponseMessageHeader header);
		ResponseMessage.ResponseMessageBuilder addValidation(Validation validation);
		ResponseMessage.ResponseMessageBuilder addValidation(Validation validation, int idx);
		ResponseMessage.ResponseMessageBuilder addValidation(List<? extends Validation> validation);
		ResponseMessage.ResponseMessageBuilder setValidation(List<? extends Validation> validation);
		ResponseMessage.ResponseMessageBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		ResponseMessage.ResponseMessageBuilder addCorrelationId(CorrelationId correlationId);
		ResponseMessage.ResponseMessageBuilder addCorrelationId(CorrelationId correlationId, int idx);
		ResponseMessage.ResponseMessageBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		ResponseMessage.ResponseMessageBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		ResponseMessage.ResponseMessageBuilder setSequenceNumber(Integer sequenceNumber);
		ResponseMessage.ResponseMessageBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		ResponseMessage.ResponseMessageBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		ResponseMessage.ResponseMessageBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		ResponseMessage.ResponseMessageBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
		}
		

		ResponseMessage.ResponseMessageBuilder prune();
	}

	/*********************** Immutable Implementation of ResponseMessage  ***********************/
	class ResponseMessageImpl extends Message.MessageImpl implements ResponseMessage {
		private final ResponseMessageHeader header;
		private final List<? extends Validation> validation;
		private final CorrelationId parentCorrelationId;
		private final List<? extends CorrelationId> correlationId;
		private final Integer sequenceNumber;
		private final List<? extends OnBehalfOf> onBehalfOf;
		
		protected ResponseMessageImpl(ResponseMessage.ResponseMessageBuilder builder) {
			super(builder);
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.validation = ofNullable(builder.getValidation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.parentCorrelationId = ofNullable(builder.getParentCorrelationId()).map(f->f.build()).orElse(null);
			this.correlationId = ofNullable(builder.getCorrelationId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.sequenceNumber = builder.getSequenceNumber();
			this.onBehalfOf = ofNullable(builder.getOnBehalfOf()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("header")
		public ResponseMessageHeader getHeader() {
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
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		public List<? extends OnBehalfOf> getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		public ResponseMessage build() {
			return this;
		}
		
		@Override
		public ResponseMessage.ResponseMessageBuilder toBuilder() {
			ResponseMessage.ResponseMessageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResponseMessage.ResponseMessageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getValidation()).ifPresent(builder::setValidation);
			ofNullable(getParentCorrelationId()).ifPresent(builder::setParentCorrelationId);
			ofNullable(getCorrelationId()).ifPresent(builder::setCorrelationId);
			ofNullable(getSequenceNumber()).ifPresent(builder::setSequenceNumber);
			ofNullable(getOnBehalfOf()).ifPresent(builder::setOnBehalfOf);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ResponseMessage _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!ListEquals.listEquals(validation, _that.getValidation())) return false;
			if (!Objects.equals(parentCorrelationId, _that.getParentCorrelationId())) return false;
			if (!ListEquals.listEquals(correlationId, _that.getCorrelationId())) return false;
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			if (!ListEquals.listEquals(onBehalfOf, _that.getOnBehalfOf())) return false;
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
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResponseMessage {" +
				"header=" + this.header + ", " +
				"validation=" + this.validation + ", " +
				"parentCorrelationId=" + this.parentCorrelationId + ", " +
				"correlationId=" + this.correlationId + ", " +
				"sequenceNumber=" + this.sequenceNumber + ", " +
				"onBehalfOf=" + this.onBehalfOf +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ResponseMessage  ***********************/
	class ResponseMessageBuilderImpl extends Message.MessageBuilderImpl implements ResponseMessage.ResponseMessageBuilder {
	
		protected ResponseMessageHeader.ResponseMessageHeaderBuilder header;
		protected List<Validation.ValidationBuilder> validation = new ArrayList<>();
		protected CorrelationId.CorrelationIdBuilder parentCorrelationId;
		protected List<CorrelationId.CorrelationIdBuilder> correlationId = new ArrayList<>();
		protected Integer sequenceNumber;
		protected List<OnBehalfOf.OnBehalfOfBuilder> onBehalfOf = new ArrayList<>();
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("header")
		public ResponseMessageHeader.ResponseMessageHeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder getOrCreateHeader() {
			ResponseMessageHeader.ResponseMessageHeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = ResponseMessageHeader.builder();
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
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		public List<? extends OnBehalfOf.OnBehalfOfBuilder> getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		public OnBehalfOf.OnBehalfOfBuilder getOrCreateOnBehalfOf(int index) {
			if (onBehalfOf==null) {
				this.onBehalfOf = new ArrayList<>();
			}
			return getIndex(onBehalfOf, index, () -> {
						OnBehalfOf.OnBehalfOfBuilder newOnBehalfOf = OnBehalfOf.builder();
						return newOnBehalfOf;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public ResponseMessage.ResponseMessageBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public ResponseMessage.ResponseMessageBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public ResponseMessage.ResponseMessageBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public ResponseMessage.ResponseMessageBuilder setHeader(ResponseMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public ResponseMessage.ResponseMessageBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ResponseMessage.ResponseMessageBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public ResponseMessage.ResponseMessageBuilder addValidation(List<? extends Validation> validations) {
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
		public ResponseMessage.ResponseMessageBuilder setValidation(List<? extends Validation> validations) {
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
		public ResponseMessage.ResponseMessageBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public ResponseMessage.ResponseMessageBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ResponseMessage.ResponseMessageBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public ResponseMessage.ResponseMessageBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ResponseMessage.ResponseMessageBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ResponseMessage.ResponseMessageBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public ResponseMessage.ResponseMessageBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public ResponseMessage.ResponseMessageBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public ResponseMessage.ResponseMessageBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs != null) {
				for (final OnBehalfOf toAdd : onBehalfOfs) {
					this.onBehalfOf.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public ResponseMessage.ResponseMessageBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ResponseMessage build() {
			return new ResponseMessage.ResponseMessageImpl(this);
		}
		
		@Override
		public ResponseMessage.ResponseMessageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResponseMessage.ResponseMessageBuilder prune() {
			super.prune();
			if (header!=null && !header.prune().hasData()) header = null;
			validation = validation.stream().filter(b->b!=null).<Validation.ValidationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (parentCorrelationId!=null && !parentCorrelationId.prune().hasData()) parentCorrelationId = null;
			correlationId = correlationId.stream().filter(b->b!=null).<CorrelationId.CorrelationIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			onBehalfOf = onBehalfOf.stream().filter(b->b!=null).<OnBehalfOf.OnBehalfOfBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
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
			if (getOnBehalfOf()!=null && getOnBehalfOf().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResponseMessage.ResponseMessageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ResponseMessage.ResponseMessageBuilder o = (ResponseMessage.ResponseMessageBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getValidation(), o.getValidation(), this::getOrCreateValidation);
			merger.mergeRosetta(getParentCorrelationId(), o.getParentCorrelationId(), this::setParentCorrelationId);
			merger.mergeRosetta(getCorrelationId(), o.getCorrelationId(), this::getOrCreateCorrelationId);
			merger.mergeRosetta(getOnBehalfOf(), o.getOnBehalfOf(), this::getOrCreateOnBehalfOf);
			
			merger.mergeBasic(getSequenceNumber(), o.getSequenceNumber(), this::setSequenceNumber);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ResponseMessage _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!ListEquals.listEquals(validation, _that.getValidation())) return false;
			if (!Objects.equals(parentCorrelationId, _that.getParentCorrelationId())) return false;
			if (!ListEquals.listEquals(correlationId, _that.getCorrelationId())) return false;
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			if (!ListEquals.listEquals(onBehalfOf, _that.getOnBehalfOf())) return false;
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
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResponseMessageBuilder {" +
				"header=" + this.header + ", " +
				"validation=" + this.validation + ", " +
				"parentCorrelationId=" + this.parentCorrelationId + ", " +
				"correlationId=" + this.correlationId + ", " +
				"sequenceNumber=" + this.sequenceNumber + ", " +
				"onBehalfOf=" + this.onBehalfOf +
			'}' + " " + super.toString();
		}
	}
}
