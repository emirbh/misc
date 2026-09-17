package fpml.consolidated.confirmation.processes;

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
import fpml.consolidated.confirmation.processes.meta.ConfirmationExceptionMeta;
import fpml.consolidated.doc.AdditionalData;
import fpml.consolidated.doc.Reason;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.ExceptionMessageHeader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A message sent to inform another system that some exception has been detected.
 *
 */
@RosettaDataType(value="ConfirmationException", builder=ConfirmationException.ConfirmationExceptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ConfirmationException", model="fpml", builder=ConfirmationException.ConfirmationExceptionBuilderImpl.class, version="2.1.1")
public interface ConfirmationException extends fpml.consolidated.msg.Exception {

	ConfirmationExceptionMeta metaData = new ConfirmationExceptionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ConfirmationException build();
	
	ConfirmationException.ConfirmationExceptionBuilder toBuilder();
	
	static ConfirmationException.ConfirmationExceptionBuilder builder() {
		return new ConfirmationException.ConfirmationExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConfirmationException> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ConfirmationException> getType() {
		return ConfirmationException.class;
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
	interface ConfirmationExceptionBuilder extends ConfirmationException, fpml.consolidated.msg.Exception.ExceptionBuilder {
		@Override
		ConfirmationException.ConfirmationExceptionBuilder setFpmlVersion(String fpmlVersion);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder setActualBuild(Integer actualBuild);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder setHeader(ExceptionMessageHeader header);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder addValidation(Validation validation);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder addValidation(Validation validation, int idx);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder addValidation(List<? extends Validation> validation);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder setValidation(List<? extends Validation> validation);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder addReason(Reason reason);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder addReason(Reason reason, int idx);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder addReason(List<? extends Reason> reason);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder setReason(List<? extends Reason> reason);
		@Override
		ConfirmationException.ConfirmationExceptionBuilder setAdditionalData(AdditionalData additionalData);

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
		

		ConfirmationException.ConfirmationExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of ConfirmationException  ***********************/
	class ConfirmationExceptionImpl extends fpml.consolidated.msg.Exception.ExceptionImpl implements ConfirmationException {
		
		protected ConfirmationExceptionImpl(ConfirmationException.ConfirmationExceptionBuilder builder) {
			super(builder);
		}
		
		@Override
		public ConfirmationException build() {
			return this;
		}
		
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder toBuilder() {
			ConfirmationException.ConfirmationExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConfirmationException.ConfirmationExceptionBuilder builder) {
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
			return "ConfirmationException {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ConfirmationException  ***********************/
	class ConfirmationExceptionBuilderImpl extends fpml.consolidated.msg.Exception.ExceptionBuilderImpl implements ConfirmationException.ConfirmationExceptionBuilder {
	
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder setHeader(ExceptionMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder addValidation(List<? extends Validation> validations) {
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
		public ConfirmationException.ConfirmationExceptionBuilder setValidation(List<? extends Validation> validations) {
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
		public ConfirmationException.ConfirmationExceptionBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ConfirmationException.ConfirmationExceptionBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ConfirmationException.ConfirmationExceptionBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder addReason(Reason _reason) {
			if (_reason != null) {
				this.reason.add(_reason.toBuilder());
			}
			return this;
		}
		
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder addReason(Reason _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason.toBuilder());
			return this;
		}
		
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder addReason(List<? extends Reason> reasons) {
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
		public ConfirmationException.ConfirmationExceptionBuilder setReason(List<? extends Reason> reasons) {
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
		public ConfirmationException.ConfirmationExceptionBuilder setAdditionalData(AdditionalData _additionalData) {
			this.additionalData = _additionalData == null ? null : _additionalData.toBuilder();
			return this;
		}
		
		@Override
		public ConfirmationException build() {
			return new ConfirmationException.ConfirmationExceptionImpl(this);
		}
		
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConfirmationException.ConfirmationExceptionBuilder prune() {
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
		public ConfirmationException.ConfirmationExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ConfirmationException.ConfirmationExceptionBuilder o = (ConfirmationException.ConfirmationExceptionBuilder) other;
			
			
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
			return "ConfirmationExceptionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
