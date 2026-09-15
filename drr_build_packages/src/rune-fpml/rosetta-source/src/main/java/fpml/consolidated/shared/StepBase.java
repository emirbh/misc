package fpml.consolidated.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.shared.meta.StepBaseMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a step date and step value pair. This step definitions are used to define varying rate or amount schedules, e.g. a notional amortization or a step-up coupon schedule.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a step date and step value pair. This step definitions are used to define varying rate or amount schedules, e.g. a notional amortization or a step-up coupon schedule.
 *
 */
@RosettaDataType(value="StepBase", builder=StepBase.StepBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="StepBase", model="fpml", builder=StepBase.StepBaseBuilderImpl.class, version="2.1.1")
public interface StepBase extends RosettaModelObject {

	StepBaseMeta metaData = new StepBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the associated stepValue becomes effective. This day may be subject to adjustment in accordance with a business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the associated stepValue becomes effective. This day may be subject to adjustment in accordance with a business day convention.
	 *
	 */
	ZonedDateTime getStepDate();

	/*********************** Build Methods  ***********************/
	StepBase build();
	
	StepBase.StepBaseBuilder toBuilder();
	
	static StepBase.StepBaseBuilder builder() {
		return new StepBase.StepBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StepBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends StepBase> getType() {
		return StepBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("stepDate"), ZonedDateTime.class, getStepDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface StepBaseBuilder extends StepBase, RosettaModelObjectBuilder {
		StepBase.StepBaseBuilder setId(String id);
		StepBase.StepBaseBuilder setStepDate(ZonedDateTime stepDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("stepDate"), ZonedDateTime.class, getStepDate(), this);
		}
		

		StepBase.StepBaseBuilder prune();
	}

	/*********************** Immutable Implementation of StepBase  ***********************/
	class StepBaseImpl implements StepBase {
		private final String id;
		private final ZonedDateTime stepDate;
		
		protected StepBaseImpl(StepBase.StepBaseBuilder builder) {
			this.id = builder.getId();
			this.stepDate = builder.getStepDate();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("stepDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("stepDate")
		public ZonedDateTime getStepDate() {
			return stepDate;
		}
		
		@Override
		public StepBase build() {
			return this;
		}
		
		@Override
		public StepBase.StepBaseBuilder toBuilder() {
			StepBase.StepBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StepBase.StepBaseBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getStepDate()).ifPresent(builder::setStepDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StepBase _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(stepDate, _that.getStepDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (stepDate != null ? stepDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StepBase {" +
				"id=" + this.id + ", " +
				"stepDate=" + this.stepDate +
			'}';
		}
	}

	/*********************** Builder Implementation of StepBase  ***********************/
	class StepBaseBuilderImpl implements StepBase.StepBaseBuilder {
	
		protected String id;
		protected ZonedDateTime stepDate;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("stepDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("stepDate")
		public ZonedDateTime getStepDate() {
			return stepDate;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public StepBase.StepBaseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("stepDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("stepDate")
		@Override
		public StepBase.StepBaseBuilder setStepDate(ZonedDateTime _stepDate) {
			this.stepDate = _stepDate == null ? null : _stepDate;
			return this;
		}
		
		@Override
		public StepBase build() {
			return new StepBase.StepBaseImpl(this);
		}
		
		@Override
		public StepBase.StepBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StepBase.StepBaseBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getStepDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StepBase.StepBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StepBase.StepBaseBuilder o = (StepBase.StepBaseBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getStepDate(), o.getStepDate(), this::setStepDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StepBase _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(stepDate, _that.getStepDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (stepDate != null ? stepDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StepBaseBuilder {" +
				"id=" + this.id + ", " +
				"stepDate=" + this.stepDate +
			'}';
		}
	}
}
