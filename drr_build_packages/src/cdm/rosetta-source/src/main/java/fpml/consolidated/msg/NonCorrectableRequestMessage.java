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
import fpml.consolidated.msg.meta.NonCorrectableRequestMessageMeta;
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
 * Provision A type defining the content model for a request message that cannot be subsequently corrected or retracted.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the content model for a request message that cannot be subsequently corrected or retracted.
 *
 */
@RosettaDataType(value="NonCorrectableRequestMessage", builder=NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NonCorrectableRequestMessage", model="fpml", builder=NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl.class, version="2.1.1")
public interface NonCorrectableRequestMessage extends RequestMessage {

	NonCorrectableRequestMessageMeta metaData = new NonCorrectableRequestMessageMeta();

	/*********************** Getter Methods  ***********************/
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
	NonCorrectableRequestMessage build();
	
	NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder toBuilder();
	
	static NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder builder() {
		return new NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonCorrectableRequestMessage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonCorrectableRequestMessage> getType() {
		return NonCorrectableRequestMessage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonCorrectableRequestMessageBuilder extends NonCorrectableRequestMessage, RequestMessage.RequestMessageBuilder {
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
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setFpmlVersion(String fpmlVersion);
		@Override
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setActualBuild(Integer actualBuild);
		@Override
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setHeader(RequestMessageHeader header);
		@Override
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addValidation(Validation validation);
		@Override
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addValidation(Validation validation, int idx);
		@Override
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addValidation(List<? extends Validation> validation);
		@Override
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setValidation(List<? extends Validation> validation);
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addCorrelationId(CorrelationId correlationId);
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addCorrelationId(CorrelationId correlationId, int idx);
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setSequenceNumber(Integer sequenceNumber);
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
		}
		

		NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder prune();
	}

	/*********************** Immutable Implementation of NonCorrectableRequestMessage  ***********************/
	class NonCorrectableRequestMessageImpl extends RequestMessage.RequestMessageImpl implements NonCorrectableRequestMessage {
		private final CorrelationId parentCorrelationId;
		private final List<? extends CorrelationId> correlationId;
		private final Integer sequenceNumber;
		private final List<? extends OnBehalfOf> onBehalfOf;
		
		protected NonCorrectableRequestMessageImpl(NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder builder) {
			super(builder);
			this.parentCorrelationId = ofNullable(builder.getParentCorrelationId()).map(f->f.build()).orElse(null);
			this.correlationId = ofNullable(builder.getCorrelationId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.sequenceNumber = builder.getSequenceNumber();
			this.onBehalfOf = ofNullable(builder.getOnBehalfOf()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		public NonCorrectableRequestMessage build() {
			return this;
		}
		
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder toBuilder() {
			NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder builder) {
			super.setBuilderFields(builder);
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
		
			NonCorrectableRequestMessage _that = getType().cast(o);
		
			if (!Objects.equals(parentCorrelationId, _that.getParentCorrelationId())) return false;
			if (!ListEquals.listEquals(correlationId, _that.getCorrelationId())) return false;
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			if (!ListEquals.listEquals(onBehalfOf, _that.getOnBehalfOf())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (parentCorrelationId != null ? parentCorrelationId.hashCode() : 0);
			_result = 31 * _result + (correlationId != null ? correlationId.hashCode() : 0);
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonCorrectableRequestMessage {" +
				"parentCorrelationId=" + this.parentCorrelationId + ", " +
				"correlationId=" + this.correlationId + ", " +
				"sequenceNumber=" + this.sequenceNumber + ", " +
				"onBehalfOf=" + this.onBehalfOf +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonCorrectableRequestMessage  ***********************/
	class NonCorrectableRequestMessageBuilderImpl extends RequestMessage.RequestMessageBuilderImpl implements NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
	
		protected CorrelationId.CorrelationIdBuilder parentCorrelationId;
		protected List<CorrelationId.CorrelationIdBuilder> correlationId = new ArrayList<>();
		protected Integer sequenceNumber;
		protected List<OnBehalfOf.OnBehalfOfBuilder> onBehalfOf = new ArrayList<>();
		
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
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addValidation(List<? extends Validation> validations) {
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
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setValidation(List<? extends Validation> validations) {
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
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public NonCorrectableRequestMessage build() {
			return new NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl(this);
		}
		
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder prune() {
			super.prune();
			if (parentCorrelationId!=null && !parentCorrelationId.prune().hasData()) parentCorrelationId = null;
			correlationId = correlationId.stream().filter(b->b!=null).<CorrelationId.CorrelationIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			onBehalfOf = onBehalfOf.stream().filter(b->b!=null).<OnBehalfOf.OnBehalfOfBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getParentCorrelationId()!=null && getParentCorrelationId().hasData()) return true;
			if (getCorrelationId()!=null && getCorrelationId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSequenceNumber()!=null) return true;
			if (getOnBehalfOf()!=null && getOnBehalfOf().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder o = (NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder) other;
			
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
		
			NonCorrectableRequestMessage _that = getType().cast(o);
		
			if (!Objects.equals(parentCorrelationId, _that.getParentCorrelationId())) return false;
			if (!ListEquals.listEquals(correlationId, _that.getCorrelationId())) return false;
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			if (!ListEquals.listEquals(onBehalfOf, _that.getOnBehalfOf())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (parentCorrelationId != null ? parentCorrelationId.hashCode() : 0);
			_result = 31 * _result + (correlationId != null ? correlationId.hashCode() : 0);
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonCorrectableRequestMessageBuilder {" +
				"parentCorrelationId=" + this.parentCorrelationId + ", " +
				"correlationId=" + this.correlationId + ", " +
				"sequenceNumber=" + this.sequenceNumber + ", " +
				"onBehalfOf=" + this.onBehalfOf +
			'}' + " " + super.toString();
		}
	}
}
