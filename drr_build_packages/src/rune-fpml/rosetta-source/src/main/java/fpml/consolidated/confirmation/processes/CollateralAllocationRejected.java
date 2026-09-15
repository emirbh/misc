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
import fpml.consolidated.confirmation.processes.meta.CollateralAllocationRejectedMeta;
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
@RosettaDataType(value="CollateralAllocationRejected", builder=CollateralAllocationRejected.CollateralAllocationRejectedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CollateralAllocationRejected", model="fpml", builder=CollateralAllocationRejected.CollateralAllocationRejectedBuilderImpl.class, version="2.1.1")
public interface CollateralAllocationRejected extends fpml.consolidated.msg.Exception {

	CollateralAllocationRejectedMeta metaData = new CollateralAllocationRejectedMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CollateralAllocationRejected build();
	
	CollateralAllocationRejected.CollateralAllocationRejectedBuilder toBuilder();
	
	static CollateralAllocationRejected.CollateralAllocationRejectedBuilder builder() {
		return new CollateralAllocationRejected.CollateralAllocationRejectedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralAllocationRejected> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralAllocationRejected> getType() {
		return CollateralAllocationRejected.class;
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
	interface CollateralAllocationRejectedBuilder extends CollateralAllocationRejected, fpml.consolidated.msg.Exception.ExceptionBuilder {
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setFpmlVersion(String fpmlVersion);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setActualBuild(Integer actualBuild);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setHeader(ExceptionMessageHeader header);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder addValidation(Validation validation);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder addValidation(Validation validation, int idx);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder addValidation(List<? extends Validation> validation);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setValidation(List<? extends Validation> validation);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder addReason(Reason reason);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder addReason(Reason reason, int idx);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder addReason(List<? extends Reason> reason);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setReason(List<? extends Reason> reason);
		@Override
		CollateralAllocationRejected.CollateralAllocationRejectedBuilder setAdditionalData(AdditionalData additionalData);

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
		

		CollateralAllocationRejected.CollateralAllocationRejectedBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralAllocationRejected  ***********************/
	class CollateralAllocationRejectedImpl extends fpml.consolidated.msg.Exception.ExceptionImpl implements CollateralAllocationRejected {
		
		protected CollateralAllocationRejectedImpl(CollateralAllocationRejected.CollateralAllocationRejectedBuilder builder) {
			super(builder);
		}
		
		@Override
		public CollateralAllocationRejected build() {
			return this;
		}
		
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder toBuilder() {
			CollateralAllocationRejected.CollateralAllocationRejectedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralAllocationRejected.CollateralAllocationRejectedBuilder builder) {
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
			return "CollateralAllocationRejected {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CollateralAllocationRejected  ***********************/
	class CollateralAllocationRejectedBuilderImpl extends fpml.consolidated.msg.Exception.ExceptionBuilderImpl implements CollateralAllocationRejected.CollateralAllocationRejectedBuilder {
	
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setHeader(ExceptionMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder addValidation(List<? extends Validation> validations) {
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
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setValidation(List<? extends Validation> validations) {
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
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder addReason(Reason _reason) {
			if (_reason != null) {
				this.reason.add(_reason.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder addReason(Reason _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason.toBuilder());
			return this;
		}
		
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder addReason(List<? extends Reason> reasons) {
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
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setReason(List<? extends Reason> reasons) {
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
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder setAdditionalData(AdditionalData _additionalData) {
			this.additionalData = _additionalData == null ? null : _additionalData.toBuilder();
			return this;
		}
		
		@Override
		public CollateralAllocationRejected build() {
			return new CollateralAllocationRejected.CollateralAllocationRejectedImpl(this);
		}
		
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder prune() {
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
		public CollateralAllocationRejected.CollateralAllocationRejectedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CollateralAllocationRejected.CollateralAllocationRejectedBuilder o = (CollateralAllocationRejected.CollateralAllocationRejectedBuilder) other;
			
			
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
			return "CollateralAllocationRejectedBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
