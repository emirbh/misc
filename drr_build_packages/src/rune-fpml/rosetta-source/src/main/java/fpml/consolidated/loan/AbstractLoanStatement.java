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
import fpml.consolidated.loan.meta.AbstractLoanStatementMeta;
import fpml.consolidated.msg.CorrectableRequestMessage;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import java.time.ZonedDateTime;
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
 * Provision An abstract base type for all syndicated loan statement notifications; the wrapper for deal/facility/contract definitions and facility/contract positions at a particular point in time (snapshot).
 *
 */
@RosettaDataType(value="AbstractLoanStatement", builder=AbstractLoanStatement.AbstractLoanStatementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractLoanStatement", model="fpml", builder=AbstractLoanStatement.AbstractLoanStatementBuilderImpl.class, version="2.1.1")
public interface AbstractLoanStatement extends CorrectableRequestMessage {

	AbstractLoanStatementMeta metaData = new AbstractLoanStatementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date as of which the embedded information is valid.
	 *
	 */
	ZonedDateTime getStatementDate();
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
	AbstractLoanStatement build();
	
	AbstractLoanStatement.AbstractLoanStatementBuilder toBuilder();
	
	static AbstractLoanStatement.AbstractLoanStatementBuilder builder() {
		return new AbstractLoanStatement.AbstractLoanStatementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanStatement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractLoanStatement> getType() {
		return AbstractLoanStatement.class;
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
		processor.processBasic(path.newSubPath("statementDate"), ZonedDateTime.class, getStatementDate(), this);
		processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanStatementBuilder extends AbstractLoanStatement, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder setFpmlVersion(String fpmlVersion);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder setActualBuild(Integer actualBuild);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder setHeader(RequestMessageHeader header);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder addValidation(Validation validation);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder addValidation(Validation validation, int idx);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder addValidation(List<? extends Validation> validation);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder setValidation(List<? extends Validation> validation);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder setIsCorrection(Boolean isCorrection);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		AbstractLoanStatement.AbstractLoanStatementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		AbstractLoanStatement.AbstractLoanStatementBuilder setStatementDate(ZonedDateTime statementDate);
		AbstractLoanStatement.AbstractLoanStatementBuilder setComments(String comments);

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
			processor.processBasic(path.newSubPath("statementDate"), ZonedDateTime.class, getStatementDate(), this);
			processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
		}
		

		AbstractLoanStatement.AbstractLoanStatementBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanStatement  ***********************/
	class AbstractLoanStatementImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements AbstractLoanStatement {
		private final ZonedDateTime statementDate;
		private final String comments;
		
		protected AbstractLoanStatementImpl(AbstractLoanStatement.AbstractLoanStatementBuilder builder) {
			super(builder);
			this.statementDate = builder.getStatementDate();
			this.comments = builder.getComments();
		}
		
		@Override
		@RosettaAttribute("statementDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("statementDate")
		public ZonedDateTime getStatementDate() {
			return statementDate;
		}
		
		@Override
		@RosettaAttribute("comments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("comments")
		public String getComments() {
			return comments;
		}
		
		@Override
		public AbstractLoanStatement build() {
			return this;
		}
		
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder toBuilder() {
			AbstractLoanStatement.AbstractLoanStatementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanStatement.AbstractLoanStatementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStatementDate()).ifPresent(builder::setStatementDate);
			ofNullable(getComments()).ifPresent(builder::setComments);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanStatement _that = getType().cast(o);
		
			if (!Objects.equals(statementDate, _that.getStatementDate())) return false;
			if (!Objects.equals(comments, _that.getComments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (statementDate != null ? statementDate.hashCode() : 0);
			_result = 31 * _result + (comments != null ? comments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanStatement {" +
				"statementDate=" + this.statementDate + ", " +
				"comments=" + this.comments +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanStatement  ***********************/
	class AbstractLoanStatementBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl implements AbstractLoanStatement.AbstractLoanStatementBuilder {
	
		protected ZonedDateTime statementDate;
		protected String comments;
		
		@Override
		@RosettaAttribute("statementDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("statementDate")
		public ZonedDateTime getStatementDate() {
			return statementDate;
		}
		
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
		public AbstractLoanStatement.AbstractLoanStatementBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder addValidation(List<? extends Validation> validations) {
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
		public AbstractLoanStatement.AbstractLoanStatementBuilder setValidation(List<? extends Validation> validations) {
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
		public AbstractLoanStatement.AbstractLoanStatementBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AbstractLoanStatement.AbstractLoanStatementBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AbstractLoanStatement.AbstractLoanStatementBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public AbstractLoanStatement.AbstractLoanStatementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("statementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("statementDate")
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder setStatementDate(ZonedDateTime _statementDate) {
			this.statementDate = _statementDate == null ? null : _statementDate;
			return this;
		}
		
		@RosettaAttribute("comments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comments")
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder setComments(String _comments) {
			this.comments = _comments == null ? null : _comments;
			return this;
		}
		
		@Override
		public AbstractLoanStatement build() {
			return new AbstractLoanStatement.AbstractLoanStatementImpl(this);
		}
		
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStatementDate()!=null) return true;
			if (getComments()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanStatement.AbstractLoanStatementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractLoanStatement.AbstractLoanStatementBuilder o = (AbstractLoanStatement.AbstractLoanStatementBuilder) other;
			
			
			merger.mergeBasic(getStatementDate(), o.getStatementDate(), this::setStatementDate);
			merger.mergeBasic(getComments(), o.getComments(), this::setComments);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanStatement _that = getType().cast(o);
		
			if (!Objects.equals(statementDate, _that.getStatementDate())) return false;
			if (!Objects.equals(comments, _that.getComments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (statementDate != null ? statementDate.hashCode() : 0);
			_result = 31 * _result + (comments != null ? comments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanStatementBuilder {" +
				"statementDate=" + this.statementDate + ", " +
				"comments=" + this.comments +
			'}' + " " + super.toString();
		}
	}
}
