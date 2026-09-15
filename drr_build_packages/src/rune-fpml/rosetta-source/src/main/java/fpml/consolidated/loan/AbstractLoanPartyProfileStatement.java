package fpml.consolidated.loan;

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
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.meta.AbstractLoanPartyProfileStatementMeta;
import fpml.consolidated.msg.CorrectableRequestMessage;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
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
 * version "confirmation-5.13"
 *
 * Provision An abstract base type for all supplementary communication to paying entities and/or servicing platforms.
 *
 */
@RosettaDataType(value="AbstractLoanPartyProfileStatement", builder=AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractLoanPartyProfileStatement", model="fpml", builder=AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilderImpl.class, version="2.1.1")
public interface AbstractLoanPartyProfileStatement extends CorrectableRequestMessage {

	AbstractLoanPartyProfileStatementMeta metaData = new AbstractLoanPartyProfileStatementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A free-form, manually entered field which will be used by users directly for additional information.
	 *
	 */
	String getComments();

	/*********************** Build Methods  ***********************/
	AbstractLoanPartyProfileStatement build();
	
	AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder toBuilder();
	
	static AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder builder() {
		return new AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanPartyProfileStatement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractLoanPartyProfileStatement> getType() {
		return AbstractLoanPartyProfileStatement.class;
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
		processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanPartyProfileStatementBuilder extends AbstractLoanPartyProfileStatement, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setFpmlVersion(String fpmlVersion);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setActualBuild(Integer actualBuild);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setHeader(RequestMessageHeader header);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addValidation(Validation validation);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addValidation(Validation validation, int idx);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addValidation(List<? extends Validation> validation);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setValidation(List<? extends Validation> validation);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setIsCorrection(Boolean isCorrection);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setComments(String comments);

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
			processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
		}
		

		AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanPartyProfileStatement  ***********************/
	class AbstractLoanPartyProfileStatementImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements AbstractLoanPartyProfileStatement {
		private final String comments;
		
		protected AbstractLoanPartyProfileStatementImpl(AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder builder) {
			super(builder);
			this.comments = builder.getComments();
		}
		
		@Override
		@RosettaAttribute("comments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("comments")
		public String getComments() {
			return comments;
		}
		
		@Override
		public AbstractLoanPartyProfileStatement build() {
			return this;
		}
		
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder toBuilder() {
			AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getComments()).ifPresent(builder::setComments);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanPartyProfileStatement _that = getType().cast(o);
		
			if (!Objects.equals(comments, _that.getComments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (comments != null ? comments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanPartyProfileStatement {" +
				"comments=" + this.comments +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanPartyProfileStatement  ***********************/
	class AbstractLoanPartyProfileStatementBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl implements AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder {
	
		protected String comments;
		
		@Override
		@RosettaAttribute("comments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("comments")
		public String getComments() {
			return comments;
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addValidation(List<? extends Validation> validations) {
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
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setValidation(List<? extends Validation> validations) {
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
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("comments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comments")
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder setComments(String _comments) {
			this.comments = _comments == null ? null : _comments;
			return this;
		}
		
		@Override
		public AbstractLoanPartyProfileStatement build() {
			return new AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementImpl(this);
		}
		
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getComments()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder o = (AbstractLoanPartyProfileStatement.AbstractLoanPartyProfileStatementBuilder) other;
			
			
			merger.mergeBasic(getComments(), o.getComments(), this::setComments);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanPartyProfileStatement _that = getType().cast(o);
		
			if (!Objects.equals(comments, _that.getComments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (comments != null ? comments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanPartyProfileStatementBuilder {" +
				"comments=" + this.comments +
			'}' + " " + super.toString();
		}
	}
}
