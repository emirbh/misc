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
import fpml.consolidated.confirmation.processes.meta.TradeChangeAdviceExceptionMeta;
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
@RosettaDataType(value="TradeChangeAdviceException", builder=TradeChangeAdviceException.TradeChangeAdviceExceptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeChangeAdviceException", model="fpml", builder=TradeChangeAdviceException.TradeChangeAdviceExceptionBuilderImpl.class, version="2.1.1")
public interface TradeChangeAdviceException extends fpml.consolidated.msg.Exception {

	TradeChangeAdviceExceptionMeta metaData = new TradeChangeAdviceExceptionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	TradeChangeAdviceException build();
	
	TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder toBuilder();
	
	static TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder builder() {
		return new TradeChangeAdviceException.TradeChangeAdviceExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeChangeAdviceException> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeChangeAdviceException> getType() {
		return TradeChangeAdviceException.class;
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
	interface TradeChangeAdviceExceptionBuilder extends TradeChangeAdviceException, fpml.consolidated.msg.Exception.ExceptionBuilder {
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setFpmlVersion(String fpmlVersion);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setActualBuild(Integer actualBuild);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setHeader(ExceptionMessageHeader header);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addValidation(Validation validation);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addValidation(Validation validation, int idx);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addValidation(List<? extends Validation> validation);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setValidation(List<? extends Validation> validation);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addReason(Reason reason);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addReason(Reason reason, int idx);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addReason(List<? extends Reason> reason);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setReason(List<? extends Reason> reason);
		@Override
		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setAdditionalData(AdditionalData additionalData);

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
		

		TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of TradeChangeAdviceException  ***********************/
	class TradeChangeAdviceExceptionImpl extends fpml.consolidated.msg.Exception.ExceptionImpl implements TradeChangeAdviceException {
		
		protected TradeChangeAdviceExceptionImpl(TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder builder) {
			super(builder);
		}
		
		@Override
		public TradeChangeAdviceException build() {
			return this;
		}
		
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder toBuilder() {
			TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder builder) {
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
			return "TradeChangeAdviceException {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeChangeAdviceException  ***********************/
	class TradeChangeAdviceExceptionBuilderImpl extends fpml.consolidated.msg.Exception.ExceptionBuilderImpl implements TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder {
	
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setHeader(ExceptionMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addValidation(List<? extends Validation> validations) {
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
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setValidation(List<? extends Validation> validations) {
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
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addReason(Reason _reason) {
			if (_reason != null) {
				this.reason.add(_reason.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addReason(Reason _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder addReason(List<? extends Reason> reasons) {
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
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setReason(List<? extends Reason> reasons) {
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
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder setAdditionalData(AdditionalData _additionalData) {
			this.additionalData = _additionalData == null ? null : _additionalData.toBuilder();
			return this;
		}
		
		@Override
		public TradeChangeAdviceException build() {
			return new TradeChangeAdviceException.TradeChangeAdviceExceptionImpl(this);
		}
		
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder prune() {
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
		public TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder o = (TradeChangeAdviceException.TradeChangeAdviceExceptionBuilder) other;
			
			
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
			return "TradeChangeAdviceExceptionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
