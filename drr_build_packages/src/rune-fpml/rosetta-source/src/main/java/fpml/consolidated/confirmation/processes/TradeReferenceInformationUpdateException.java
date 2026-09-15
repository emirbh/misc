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
import fpml.consolidated.confirmation.processes.meta.TradeReferenceInformationUpdateExceptionMeta;
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
 * Provision 
 *
 */
@RosettaDataType(value="TradeReferenceInformationUpdateException", builder=TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeReferenceInformationUpdateException", model="fpml", builder=TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilderImpl.class, version="2.1.1")
public interface TradeReferenceInformationUpdateException extends fpml.consolidated.msg.Exception {

	TradeReferenceInformationUpdateExceptionMeta metaData = new TradeReferenceInformationUpdateExceptionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	TradeReferenceInformationUpdateException build();
	
	TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder toBuilder();
	
	static TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder builder() {
		return new TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeReferenceInformationUpdateException> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeReferenceInformationUpdateException> getType() {
		return TradeReferenceInformationUpdateException.class;
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
	interface TradeReferenceInformationUpdateExceptionBuilder extends TradeReferenceInformationUpdateException, fpml.consolidated.msg.Exception.ExceptionBuilder {
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setFpmlVersion(String fpmlVersion);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setActualBuild(Integer actualBuild);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setHeader(ExceptionMessageHeader header);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addValidation(Validation validation);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addValidation(Validation validation, int idx);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addValidation(List<? extends Validation> validation);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setValidation(List<? extends Validation> validation);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addReason(Reason reason);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addReason(Reason reason, int idx);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addReason(List<? extends Reason> reason);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setReason(List<? extends Reason> reason);
		@Override
		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setAdditionalData(AdditionalData additionalData);

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
		

		TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of TradeReferenceInformationUpdateException  ***********************/
	class TradeReferenceInformationUpdateExceptionImpl extends fpml.consolidated.msg.Exception.ExceptionImpl implements TradeReferenceInformationUpdateException {
		
		protected TradeReferenceInformationUpdateExceptionImpl(TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder builder) {
			super(builder);
		}
		
		@Override
		public TradeReferenceInformationUpdateException build() {
			return this;
		}
		
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder toBuilder() {
			TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder builder) {
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
			return "TradeReferenceInformationUpdateException {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeReferenceInformationUpdateException  ***********************/
	class TradeReferenceInformationUpdateExceptionBuilderImpl extends fpml.consolidated.msg.Exception.ExceptionBuilderImpl implements TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder {
	
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setHeader(ExceptionMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addValidation(List<? extends Validation> validations) {
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
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setValidation(List<? extends Validation> validations) {
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
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addReason(Reason _reason) {
			if (_reason != null) {
				this.reason.add(_reason.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addReason(Reason _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason.toBuilder());
			return this;
		}
		
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder addReason(List<? extends Reason> reasons) {
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
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setReason(List<? extends Reason> reasons) {
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
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder setAdditionalData(AdditionalData _additionalData) {
			this.additionalData = _additionalData == null ? null : _additionalData.toBuilder();
			return this;
		}
		
		@Override
		public TradeReferenceInformationUpdateException build() {
			return new TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionImpl(this);
		}
		
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder prune() {
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
		public TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder o = (TradeReferenceInformationUpdateException.TradeReferenceInformationUpdateExceptionBuilder) other;
			
			
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
			return "TradeReferenceInformationUpdateExceptionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
