package fpml.consolidated.msg;

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
import fpml.consolidated.msg.meta.ServiceProcessingStatusMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the content model for report on the status of the processing by a service. In the future we may wish to provide some kind of scope or other qualification for the event, e.g. the currencies, products, or books to which it applies.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the content model for report on the status of the processing by a service. In the future we may wish to provide some kind of scope or other qualification for the event, e.g. the currencies, products, or books to which it applies.
 *
 */
@RosettaDataType(value="ServiceProcessingStatus", builder=ServiceProcessingStatus.ServiceProcessingStatusBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ServiceProcessingStatus", model="fpml", builder=ServiceProcessingStatus.ServiceProcessingStatusBuilderImpl.class, version="2.1.1")
public interface ServiceProcessingStatus extends RosettaModelObject {

	ServiceProcessingStatusMeta metaData = new ServiceProcessingStatusMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The processing cycle or phase that this message describes. For example, EndOfDay or Intraday.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The processing cycle or phase that this message describes. For example, EndOfDay or Intraday.
	 *
	 */
	ServiceProcessingCycle getCycle();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The stage within a processing cycle or phase that this message describes. For example, Netting or Valuation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The stage within a processing cycle or phase that this message describes. For example, Netting or Valuation.
	 *
	 */
	ServiceProcessingStep getStep();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The event that occurred within the cycle or step, for example "Started" or "Completed"..
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The event that occurred within the cycle or step, for example "Started" or "Completed"..
	 *
	 */
	ServiceProcessingEvent getEvent();

	/*********************** Build Methods  ***********************/
	ServiceProcessingStatus build();
	
	ServiceProcessingStatus.ServiceProcessingStatusBuilder toBuilder();
	
	static ServiceProcessingStatus.ServiceProcessingStatusBuilder builder() {
		return new ServiceProcessingStatus.ServiceProcessingStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ServiceProcessingStatus> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ServiceProcessingStatus> getType() {
		return ServiceProcessingStatus.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cycle"), processor, ServiceProcessingCycle.class, getCycle());
		processRosetta(path.newSubPath("step"), processor, ServiceProcessingStep.class, getStep());
		processRosetta(path.newSubPath("event"), processor, ServiceProcessingEvent.class, getEvent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ServiceProcessingStatusBuilder extends ServiceProcessingStatus, RosettaModelObjectBuilder {
		ServiceProcessingCycle.ServiceProcessingCycleBuilder getOrCreateCycle();
		@Override
		ServiceProcessingCycle.ServiceProcessingCycleBuilder getCycle();
		ServiceProcessingStep.ServiceProcessingStepBuilder getOrCreateStep();
		@Override
		ServiceProcessingStep.ServiceProcessingStepBuilder getStep();
		ServiceProcessingEvent.ServiceProcessingEventBuilder getOrCreateEvent();
		@Override
		ServiceProcessingEvent.ServiceProcessingEventBuilder getEvent();
		ServiceProcessingStatus.ServiceProcessingStatusBuilder setCycle(ServiceProcessingCycle cycle);
		ServiceProcessingStatus.ServiceProcessingStatusBuilder setStep(ServiceProcessingStep step);
		ServiceProcessingStatus.ServiceProcessingStatusBuilder setEvent(ServiceProcessingEvent event);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cycle"), processor, ServiceProcessingCycle.ServiceProcessingCycleBuilder.class, getCycle());
			processRosetta(path.newSubPath("step"), processor, ServiceProcessingStep.ServiceProcessingStepBuilder.class, getStep());
			processRosetta(path.newSubPath("event"), processor, ServiceProcessingEvent.ServiceProcessingEventBuilder.class, getEvent());
		}
		

		ServiceProcessingStatus.ServiceProcessingStatusBuilder prune();
	}

	/*********************** Immutable Implementation of ServiceProcessingStatus  ***********************/
	class ServiceProcessingStatusImpl implements ServiceProcessingStatus {
		private final ServiceProcessingCycle cycle;
		private final ServiceProcessingStep step;
		private final ServiceProcessingEvent event;
		
		protected ServiceProcessingStatusImpl(ServiceProcessingStatus.ServiceProcessingStatusBuilder builder) {
			this.cycle = ofNullable(builder.getCycle()).map(f->f.build()).orElse(null);
			this.step = ofNullable(builder.getStep()).map(f->f.build()).orElse(null);
			this.event = ofNullable(builder.getEvent()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cycle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cycle")
		public ServiceProcessingCycle getCycle() {
			return cycle;
		}
		
		@Override
		@RosettaAttribute("step")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("step")
		public ServiceProcessingStep getStep() {
			return step;
		}
		
		@Override
		@RosettaAttribute("event")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("event")
		public ServiceProcessingEvent getEvent() {
			return event;
		}
		
		@Override
		public ServiceProcessingStatus build() {
			return this;
		}
		
		@Override
		public ServiceProcessingStatus.ServiceProcessingStatusBuilder toBuilder() {
			ServiceProcessingStatus.ServiceProcessingStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ServiceProcessingStatus.ServiceProcessingStatusBuilder builder) {
			ofNullable(getCycle()).ifPresent(builder::setCycle);
			ofNullable(getStep()).ifPresent(builder::setStep);
			ofNullable(getEvent()).ifPresent(builder::setEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ServiceProcessingStatus _that = getType().cast(o);
		
			if (!Objects.equals(cycle, _that.getCycle())) return false;
			if (!Objects.equals(step, _that.getStep())) return false;
			if (!Objects.equals(event, _that.getEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cycle != null ? cycle.hashCode() : 0);
			_result = 31 * _result + (step != null ? step.hashCode() : 0);
			_result = 31 * _result + (event != null ? event.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceProcessingStatus {" +
				"cycle=" + this.cycle + ", " +
				"step=" + this.step + ", " +
				"event=" + this.event +
			'}';
		}
	}

	/*********************** Builder Implementation of ServiceProcessingStatus  ***********************/
	class ServiceProcessingStatusBuilderImpl implements ServiceProcessingStatus.ServiceProcessingStatusBuilder {
	
		protected ServiceProcessingCycle.ServiceProcessingCycleBuilder cycle;
		protected ServiceProcessingStep.ServiceProcessingStepBuilder step;
		protected ServiceProcessingEvent.ServiceProcessingEventBuilder event;
		
		@Override
		@RosettaAttribute("cycle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cycle")
		public ServiceProcessingCycle.ServiceProcessingCycleBuilder getCycle() {
			return cycle;
		}
		
		@Override
		public ServiceProcessingCycle.ServiceProcessingCycleBuilder getOrCreateCycle() {
			ServiceProcessingCycle.ServiceProcessingCycleBuilder result;
			if (cycle!=null) {
				result = cycle;
			}
			else {
				result = cycle = ServiceProcessingCycle.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("step")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("step")
		public ServiceProcessingStep.ServiceProcessingStepBuilder getStep() {
			return step;
		}
		
		@Override
		public ServiceProcessingStep.ServiceProcessingStepBuilder getOrCreateStep() {
			ServiceProcessingStep.ServiceProcessingStepBuilder result;
			if (step!=null) {
				result = step;
			}
			else {
				result = step = ServiceProcessingStep.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("event")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("event")
		public ServiceProcessingEvent.ServiceProcessingEventBuilder getEvent() {
			return event;
		}
		
		@Override
		public ServiceProcessingEvent.ServiceProcessingEventBuilder getOrCreateEvent() {
			ServiceProcessingEvent.ServiceProcessingEventBuilder result;
			if (event!=null) {
				result = event;
			}
			else {
				result = event = ServiceProcessingEvent.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("cycle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cycle")
		@Override
		public ServiceProcessingStatus.ServiceProcessingStatusBuilder setCycle(ServiceProcessingCycle _cycle) {
			this.cycle = _cycle == null ? null : _cycle.toBuilder();
			return this;
		}
		
		@RosettaAttribute("step")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("step")
		@Override
		public ServiceProcessingStatus.ServiceProcessingStatusBuilder setStep(ServiceProcessingStep _step) {
			this.step = _step == null ? null : _step.toBuilder();
			return this;
		}
		
		@RosettaAttribute("event")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("event")
		@Override
		public ServiceProcessingStatus.ServiceProcessingStatusBuilder setEvent(ServiceProcessingEvent _event) {
			this.event = _event == null ? null : _event.toBuilder();
			return this;
		}
		
		@Override
		public ServiceProcessingStatus build() {
			return new ServiceProcessingStatus.ServiceProcessingStatusImpl(this);
		}
		
		@Override
		public ServiceProcessingStatus.ServiceProcessingStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceProcessingStatus.ServiceProcessingStatusBuilder prune() {
			if (cycle!=null && !cycle.prune().hasData()) cycle = null;
			if (step!=null && !step.prune().hasData()) step = null;
			if (event!=null && !event.prune().hasData()) event = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCycle()!=null && getCycle().hasData()) return true;
			if (getStep()!=null && getStep().hasData()) return true;
			if (getEvent()!=null && getEvent().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceProcessingStatus.ServiceProcessingStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ServiceProcessingStatus.ServiceProcessingStatusBuilder o = (ServiceProcessingStatus.ServiceProcessingStatusBuilder) other;
			
			merger.mergeRosetta(getCycle(), o.getCycle(), this::setCycle);
			merger.mergeRosetta(getStep(), o.getStep(), this::setStep);
			merger.mergeRosetta(getEvent(), o.getEvent(), this::setEvent);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ServiceProcessingStatus _that = getType().cast(o);
		
			if (!Objects.equals(cycle, _that.getCycle())) return false;
			if (!Objects.equals(step, _that.getStep())) return false;
			if (!Objects.equals(event, _that.getEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cycle != null ? cycle.hashCode() : 0);
			_result = 31 * _result + (step != null ? step.hashCode() : 0);
			_result = 31 * _result + (event != null ? event.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceProcessingStatusBuilder {" +
				"cycle=" + this.cycle + ", " +
				"step=" + this.step + ", " +
				"event=" + this.event +
			'}';
		}
	}
}
