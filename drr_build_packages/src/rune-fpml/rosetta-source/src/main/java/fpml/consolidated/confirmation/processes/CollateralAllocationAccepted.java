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
import fpml.consolidated.confirmation.processes.meta.CollateralAllocationAcceptedMeta;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.ResponseMessage;
import fpml.consolidated.msg.ResponseMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
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
@RosettaDataType(value="CollateralAllocationAccepted", builder=CollateralAllocationAccepted.CollateralAllocationAcceptedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CollateralAllocationAccepted", model="fpml", builder=CollateralAllocationAccepted.CollateralAllocationAcceptedBuilderImpl.class, version="2.1.1")
public interface CollateralAllocationAccepted extends ResponseMessage {

	CollateralAllocationAcceptedMeta metaData = new CollateralAllocationAcceptedMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CollateralAllocationAccepted build();
	
	CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder toBuilder();
	
	static CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder builder() {
		return new CollateralAllocationAccepted.CollateralAllocationAcceptedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralAllocationAccepted> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralAllocationAccepted> getType() {
		return CollateralAllocationAccepted.class;
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
	interface CollateralAllocationAcceptedBuilder extends CollateralAllocationAccepted, ResponseMessage.ResponseMessageBuilder {
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setFpmlVersion(String fpmlVersion);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setActualBuild(Integer actualBuild);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setHeader(ResponseMessageHeader header);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addValidation(Validation validation);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addValidation(Validation validation, int idx);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addValidation(List<? extends Validation> validation);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setValidation(List<? extends Validation> validation);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);

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
		

		CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralAllocationAccepted  ***********************/
	class CollateralAllocationAcceptedImpl extends ResponseMessage.ResponseMessageImpl implements CollateralAllocationAccepted {
		
		protected CollateralAllocationAcceptedImpl(CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder builder) {
			super(builder);
		}
		
		@Override
		public CollateralAllocationAccepted build() {
			return this;
		}
		
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder toBuilder() {
			CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder builder) {
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
			return "CollateralAllocationAccepted {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CollateralAllocationAccepted  ***********************/
	class CollateralAllocationAcceptedBuilderImpl extends ResponseMessage.ResponseMessageBuilderImpl implements CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder {
	
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setHeader(ResponseMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addValidation(List<? extends Validation> validations) {
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
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setValidation(List<? extends Validation> validations) {
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
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public CollateralAllocationAccepted build() {
			return new CollateralAllocationAccepted.CollateralAllocationAcceptedImpl(this);
		}
		
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder prune() {
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
		public CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder o = (CollateralAllocationAccepted.CollateralAllocationAcceptedBuilder) other;
			
			
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
			return "CollateralAllocationAcceptedBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
