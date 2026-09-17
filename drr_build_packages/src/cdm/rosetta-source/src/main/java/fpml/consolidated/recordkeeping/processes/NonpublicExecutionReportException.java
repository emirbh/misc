package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.ExceptionMessageHeader;
import fpml.consolidated.recordkeeping.processes.meta.NonpublicExecutionReportExceptionMeta;
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
 * Provision Exception message for nonpublicExecutionReport.
 *
 */
@RosettaDataType(value="NonpublicExecutionReportException", builder=NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NonpublicExecutionReportException", model="fpml", builder=NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilderImpl.class, version="2.1.1")
public interface NonpublicExecutionReportException extends fpml.consolidated.msg.Exception {

	NonpublicExecutionReportExceptionMeta metaData = new NonpublicExecutionReportExceptionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	NonpublicExecutionReportException build();
	
	NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder toBuilder();
	
	static NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder builder() {
		return new NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonpublicExecutionReportException> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonpublicExecutionReportException> getType() {
		return NonpublicExecutionReportException.class;
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
	interface NonpublicExecutionReportExceptionBuilder extends NonpublicExecutionReportException, fpml.consolidated.msg.Exception.ExceptionBuilder {
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setFpmlVersion(String fpmlVersion);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setActualBuild(Integer actualBuild);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setHeader(ExceptionMessageHeader header);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addValidation(Validation validation);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addValidation(Validation validation, int idx);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addValidation(List<? extends Validation> validation);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setValidation(List<? extends Validation> validation);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addReason(Reason reason);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addReason(Reason reason, int idx);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addReason(List<? extends Reason> reason);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setReason(List<? extends Reason> reason);
		@Override
		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setAdditionalData(AdditionalData additionalData);

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
		

		NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of NonpublicExecutionReportException  ***********************/
	class NonpublicExecutionReportExceptionImpl extends fpml.consolidated.msg.Exception.ExceptionImpl implements NonpublicExecutionReportException {
		
		protected NonpublicExecutionReportExceptionImpl(NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder builder) {
			super(builder);
		}
		
		@Override
		public NonpublicExecutionReportException build() {
			return this;
		}
		
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder toBuilder() {
			NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder builder) {
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
			return "NonpublicExecutionReportException {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonpublicExecutionReportException  ***********************/
	class NonpublicExecutionReportExceptionBuilderImpl extends fpml.consolidated.msg.Exception.ExceptionBuilderImpl implements NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder {
	
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setHeader(ExceptionMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addValidation(List<? extends Validation> validations) {
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
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setValidation(List<? extends Validation> validations) {
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
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addReason(Reason _reason) {
			if (_reason != null) {
				this.reason.add(_reason.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addReason(Reason _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason.toBuilder());
			return this;
		}
		
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder addReason(List<? extends Reason> reasons) {
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
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setReason(List<? extends Reason> reasons) {
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
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder setAdditionalData(AdditionalData _additionalData) {
			this.additionalData = _additionalData == null ? null : _additionalData.toBuilder();
			return this;
		}
		
		@Override
		public NonpublicExecutionReportException build() {
			return new NonpublicExecutionReportException.NonpublicExecutionReportExceptionImpl(this);
		}
		
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder prune() {
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
		public NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder o = (NonpublicExecutionReportException.NonpublicExecutionReportExceptionBuilder) other;
			
			
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
			return "NonpublicExecutionReportExceptionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
