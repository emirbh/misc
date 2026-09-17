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
import fpml.consolidated.msg.meta.CorrectableRequestMessageMeta;
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
 * Provision A type defining the content model for a request message that can be subsequently corrected or retracted.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the content model for a request message that can be subsequently corrected or retracted.
 *
 */
@RosettaDataType(value="CorrectableRequestMessage", builder=CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CorrectableRequestMessage", model="fpml", builder=CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl.class, version="2.1.1")
public interface CorrectableRequestMessage extends RequestMessage {

	CorrectableRequestMessageMeta metaData = new CorrectableRequestMessageMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates if this message corrects an earlier request.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates if this message corrects an earlier request.
	 *
	 */
	Boolean getIsCorrection();
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
	CorrectableRequestMessage build();
	
	CorrectableRequestMessage.CorrectableRequestMessageBuilder toBuilder();
	
	static CorrectableRequestMessage.CorrectableRequestMessageBuilder builder() {
		return new CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrectableRequestMessage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CorrectableRequestMessage> getType() {
		return CorrectableRequestMessage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrectableRequestMessageBuilder extends CorrectableRequestMessage, RequestMessage.RequestMessageBuilder {
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
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setFpmlVersion(String fpmlVersion);
		@Override
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setActualBuild(Integer actualBuild);
		@Override
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setHeader(RequestMessageHeader header);
		@Override
		CorrectableRequestMessage.CorrectableRequestMessageBuilder addValidation(Validation validation);
		@Override
		CorrectableRequestMessage.CorrectableRequestMessageBuilder addValidation(Validation validation, int idx);
		@Override
		CorrectableRequestMessage.CorrectableRequestMessageBuilder addValidation(List<? extends Validation> validation);
		@Override
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setValidation(List<? extends Validation> validation);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setIsCorrection(Boolean isCorrection);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder addCorrelationId(CorrelationId correlationId);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder addCorrelationId(CorrelationId correlationId, int idx);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setSequenceNumber(Integer sequenceNumber);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		CorrectableRequestMessage.CorrectableRequestMessageBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
		}
		

		CorrectableRequestMessage.CorrectableRequestMessageBuilder prune();
	}

	/*********************** Immutable Implementation of CorrectableRequestMessage  ***********************/
	class CorrectableRequestMessageImpl extends RequestMessage.RequestMessageImpl implements CorrectableRequestMessage {
		private final Boolean isCorrection;
		private final CorrelationId parentCorrelationId;
		private final List<? extends CorrelationId> correlationId;
		private final Integer sequenceNumber;
		private final List<? extends OnBehalfOf> onBehalfOf;
		
		protected CorrectableRequestMessageImpl(CorrectableRequestMessage.CorrectableRequestMessageBuilder builder) {
			super(builder);
			this.isCorrection = builder.getIsCorrection();
			this.parentCorrelationId = ofNullable(builder.getParentCorrelationId()).map(f->f.build()).orElse(null);
			this.correlationId = ofNullable(builder.getCorrelationId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.sequenceNumber = builder.getSequenceNumber();
			this.onBehalfOf = ofNullable(builder.getOnBehalfOf()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isCorrection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isCorrection")
		public Boolean getIsCorrection() {
			return isCorrection;
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
		public CorrectableRequestMessage build() {
			return this;
		}
		
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder toBuilder() {
			CorrectableRequestMessage.CorrectableRequestMessageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrectableRequestMessage.CorrectableRequestMessageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getIsCorrection()).ifPresent(builder::setIsCorrection);
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
		
			CorrectableRequestMessage _that = getType().cast(o);
		
			if (!Objects.equals(isCorrection, _that.getIsCorrection())) return false;
			if (!Objects.equals(parentCorrelationId, _that.getParentCorrelationId())) return false;
			if (!ListEquals.listEquals(correlationId, _that.getCorrelationId())) return false;
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			if (!ListEquals.listEquals(onBehalfOf, _that.getOnBehalfOf())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (isCorrection != null ? isCorrection.hashCode() : 0);
			_result = 31 * _result + (parentCorrelationId != null ? parentCorrelationId.hashCode() : 0);
			_result = 31 * _result + (correlationId != null ? correlationId.hashCode() : 0);
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrectableRequestMessage {" +
				"isCorrection=" + this.isCorrection + ", " +
				"parentCorrelationId=" + this.parentCorrelationId + ", " +
				"correlationId=" + this.correlationId + ", " +
				"sequenceNumber=" + this.sequenceNumber + ", " +
				"onBehalfOf=" + this.onBehalfOf +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CorrectableRequestMessage  ***********************/
	class CorrectableRequestMessageBuilderImpl extends RequestMessage.RequestMessageBuilderImpl implements CorrectableRequestMessage.CorrectableRequestMessageBuilder {
	
		protected Boolean isCorrection;
		protected CorrelationId.CorrelationIdBuilder parentCorrelationId;
		protected List<CorrelationId.CorrelationIdBuilder> correlationId = new ArrayList<>();
		protected Integer sequenceNumber;
		protected List<OnBehalfOf.OnBehalfOfBuilder> onBehalfOf = new ArrayList<>();
		
		@Override
		@RosettaAttribute("isCorrection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isCorrection")
		public Boolean getIsCorrection() {
			return isCorrection;
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
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder addValidation(List<? extends Validation> validations) {
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
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null) {
				this.validation = new ArrayList<>();
			} else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("isCorrection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isCorrection")
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public CorrectableRequestMessage build() {
			return new CorrectableRequestMessage.CorrectableRequestMessageImpl(this);
		}
		
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder prune() {
			super.prune();
			if (parentCorrelationId!=null && !parentCorrelationId.prune().hasData()) parentCorrelationId = null;
			correlationId = correlationId.stream().filter(b->b!=null).<CorrelationId.CorrelationIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			onBehalfOf = onBehalfOf.stream().filter(b->b!=null).<OnBehalfOf.OnBehalfOfBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getIsCorrection()!=null) return true;
			if (getParentCorrelationId()!=null && getParentCorrelationId().hasData()) return true;
			if (getCorrelationId()!=null && getCorrelationId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSequenceNumber()!=null) return true;
			if (getOnBehalfOf()!=null && getOnBehalfOf().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrectableRequestMessage.CorrectableRequestMessageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CorrectableRequestMessage.CorrectableRequestMessageBuilder o = (CorrectableRequestMessage.CorrectableRequestMessageBuilder) other;
			
			merger.mergeRosetta(getParentCorrelationId(), o.getParentCorrelationId(), this::setParentCorrelationId);
			merger.mergeRosetta(getCorrelationId(), o.getCorrelationId(), this::getOrCreateCorrelationId);
			merger.mergeRosetta(getOnBehalfOf(), o.getOnBehalfOf(), this::getOrCreateOnBehalfOf);
			
			merger.mergeBasic(getIsCorrection(), o.getIsCorrection(), this::setIsCorrection);
			merger.mergeBasic(getSequenceNumber(), o.getSequenceNumber(), this::setSequenceNumber);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrectableRequestMessage _that = getType().cast(o);
		
			if (!Objects.equals(isCorrection, _that.getIsCorrection())) return false;
			if (!Objects.equals(parentCorrelationId, _that.getParentCorrelationId())) return false;
			if (!ListEquals.listEquals(correlationId, _that.getCorrelationId())) return false;
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			if (!ListEquals.listEquals(onBehalfOf, _that.getOnBehalfOf())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (isCorrection != null ? isCorrection.hashCode() : 0);
			_result = 31 * _result + (parentCorrelationId != null ? parentCorrelationId.hashCode() : 0);
			_result = 31 * _result + (correlationId != null ? correlationId.hashCode() : 0);
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrectableRequestMessageBuilder {" +
				"isCorrection=" + this.isCorrection + ", " +
				"parentCorrelationId=" + this.parentCorrelationId + ", " +
				"correlationId=" + this.correlationId + ", " +
				"sequenceNumber=" + this.sequenceNumber + ", " +
				"onBehalfOf=" + this.onBehalfOf +
			'}' + " " + super.toString();
		}
	}
}
