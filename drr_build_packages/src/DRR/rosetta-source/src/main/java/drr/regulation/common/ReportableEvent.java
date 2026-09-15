package drr.regulation.common;

import cdm.event.common.CounterpartyPositionState;
import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RosettaIgnore;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneIgnore;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.ReportableInformationBase;
import drr.regulation.common.meta.ReportableEventMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies a workflowstep with enriched information required for reporting.
 * @version 7.7.0
 */
@RosettaDataType(value="ReportableEvent", builder=ReportableEvent.ReportableEventBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ReportableEvent", model="drr", builder=ReportableEvent.ReportableEventBuilderImpl.class, version="7.7.0")
public interface ReportableEvent extends ReportableEventBase {

	ReportableEventMeta metaData = new ReportableEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Additional information required for a reportable transaction, including the reporting regime.
	 */
	@Override
	ReportableInformation getReportableInformation();

	/*********************** Build Methods  ***********************/
	ReportableEvent build();
	
	ReportableEvent.ReportableEventBuilder toBuilder();
	
	static ReportableEvent.ReportableEventBuilder builder() {
		return new ReportableEvent.ReportableEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportableEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportableEvent> getType() {
		return ReportableEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("originatingWorkflowStep"), processor, WorkflowStep.class, getOriginatingWorkflowStep());
		processRosetta(path.newSubPath("reportableTrade"), processor, TradeState.class, getReportableTrade());
		processRosetta(path.newSubPath("reportablePosition"), processor, CounterpartyPositionState.class, getReportablePosition());
		processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.class, getReportableInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportableEventBuilder extends ReportableEvent, ReportableEventBase.ReportableEventBaseBuilder {
		ReportableInformation.ReportableInformationBuilder getOrCreateReportableInformation();
		@Override
		ReportableInformation.ReportableInformationBuilder getReportableInformation();
		@Override
		ReportableEvent.ReportableEventBuilder setOriginatingWorkflowStep(WorkflowStep originatingWorkflowStep);
		@Override
		ReportableEvent.ReportableEventBuilder setReportableTrade(TradeState reportableTrade);
		@Override
		ReportableEvent.ReportableEventBuilder setReportablePosition(CounterpartyPositionState reportablePosition);
		@Override
		ReportableEvent.ReportableEventBuilder setReportableInformation(ReportableInformationBase reportableInformation);
		ReportableEvent.ReportableEventBuilder setReportableInformation(ReportableInformation reportableInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("originatingWorkflowStep"), processor, WorkflowStep.WorkflowStepBuilder.class, getOriginatingWorkflowStep());
			processRosetta(path.newSubPath("reportableTrade"), processor, TradeState.TradeStateBuilder.class, getReportableTrade());
			processRosetta(path.newSubPath("reportablePosition"), processor, CounterpartyPositionState.CounterpartyPositionStateBuilder.class, getReportablePosition());
			processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.ReportableInformationBuilder.class, getReportableInformation());
		}
		

		ReportableEvent.ReportableEventBuilder prune();
	}

	/*********************** Immutable Implementation of ReportableEvent  ***********************/
	class ReportableEventImpl extends ReportableEventBase.ReportableEventBaseImpl implements ReportableEvent {
		private final ReportableInformation reportableInformation;
		
		protected ReportableEventImpl(ReportableEvent.ReportableEventBuilder builder) {
			super(builder);
			this.reportableInformation = ofNullable(builder.getReportableInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportableInformation")
		public ReportableInformation getReportableInformation() {
			return reportableInformation;
		}
		
		@Override
		public ReportableEvent build() {
			return this;
		}
		
		@Override
		public ReportableEvent.ReportableEventBuilder toBuilder() {
			ReportableEvent.ReportableEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportableEvent.ReportableEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReportableInformation()).ifPresent(builder::setReportableInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReportableEvent _that = getType().cast(o);
		
			if (!Objects.equals(reportableInformation, _that.getReportableInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportableInformation != null ? reportableInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableEvent {" +
				"reportableInformation=" + this.reportableInformation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReportableEvent  ***********************/
	class ReportableEventBuilderImpl implements ReportableEvent.ReportableEventBuilder {
	
		protected WorkflowStep.WorkflowStepBuilder originatingWorkflowStep;
		protected TradeState.TradeStateBuilder reportableTrade;
		protected CounterpartyPositionState.CounterpartyPositionStateBuilder reportablePosition;
		protected ReportableInformation.ReportableInformationBuilder reportableInformation;
		
		@Override
		@RosettaAttribute("originatingWorkflowStep")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("originatingWorkflowStep")
		public WorkflowStep.WorkflowStepBuilder getOriginatingWorkflowStep() {
			return originatingWorkflowStep;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder getOrCreateOriginatingWorkflowStep() {
			WorkflowStep.WorkflowStepBuilder result;
			if (originatingWorkflowStep!=null) {
				result = originatingWorkflowStep;
			}
			else {
				result = originatingWorkflowStep = WorkflowStep.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportableTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportableTrade")
		public TradeState.TradeStateBuilder getReportableTrade() {
			return reportableTrade;
		}
		
		@Override
		public TradeState.TradeStateBuilder getOrCreateReportableTrade() {
			TradeState.TradeStateBuilder result;
			if (reportableTrade!=null) {
				result = reportableTrade;
			}
			else {
				result = reportableTrade = TradeState.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportablePosition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportablePosition")
		public CounterpartyPositionState.CounterpartyPositionStateBuilder getReportablePosition() {
			return reportablePosition;
		}
		
		@Override
		public CounterpartyPositionState.CounterpartyPositionStateBuilder getOrCreateReportablePosition() {
			CounterpartyPositionState.CounterpartyPositionStateBuilder result;
			if (reportablePosition!=null) {
				result = reportablePosition;
			}
			else {
				result = reportablePosition = CounterpartyPositionState.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportableInformation")
		public ReportableInformation.ReportableInformationBuilder getReportableInformation() {
			return reportableInformation;
		}
		
		@Override
		public ReportableInformation.ReportableInformationBuilder getOrCreateReportableInformation() {
			ReportableInformation.ReportableInformationBuilder result;
			if (reportableInformation!=null) {
				result = reportableInformation;
			}
			else {
				result = reportableInformation = ReportableInformation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("originatingWorkflowStep")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("originatingWorkflowStep")
		@Override
		public ReportableEvent.ReportableEventBuilder setOriginatingWorkflowStep(WorkflowStep _originatingWorkflowStep) {
			this.originatingWorkflowStep = _originatingWorkflowStep == null ? null : _originatingWorkflowStep.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportableTrade")
		@Override
		public ReportableEvent.ReportableEventBuilder setReportableTrade(TradeState _reportableTrade) {
			this.reportableTrade = _reportableTrade == null ? null : _reportableTrade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportablePosition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportablePosition")
		@Override
		public ReportableEvent.ReportableEventBuilder setReportablePosition(CounterpartyPositionState _reportablePosition) {
			this.reportablePosition = _reportablePosition == null ? null : _reportablePosition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportableInformation")
		@Override
		public ReportableEvent.ReportableEventBuilder setReportableInformation(ReportableInformation _reportableInformation) {
			this.reportableInformation = _reportableInformation == null ? null : _reportableInformation.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public ReportableEvent.ReportableEventBuilder setReportableInformation(ReportableInformationBase _reportableInformation) {
			final ReportableInformation ifThenElseResult;
			if (_reportableInformation == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _reportableInformation instanceof ReportableInformation ? ReportableInformation.class.cast(_reportableInformation) : null;
			}
			return setReportableInformation(ifThenElseResult);
		}
		
		@Override
		public ReportableEvent build() {
			return new ReportableEvent.ReportableEventImpl(this);
		}
		
		@Override
		public ReportableEvent.ReportableEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableEvent.ReportableEventBuilder prune() {
			if (originatingWorkflowStep!=null && !originatingWorkflowStep.prune().hasData()) originatingWorkflowStep = null;
			if (reportableTrade!=null && !reportableTrade.prune().hasData()) reportableTrade = null;
			if (reportablePosition!=null && !reportablePosition.prune().hasData()) reportablePosition = null;
			if (reportableInformation!=null && !reportableInformation.prune().hasData()) reportableInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOriginatingWorkflowStep()!=null && getOriginatingWorkflowStep().hasData()) return true;
			if (getReportableTrade()!=null && getReportableTrade().hasData()) return true;
			if (getReportablePosition()!=null && getReportablePosition().hasData()) return true;
			if (getReportableInformation()!=null && getReportableInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableEvent.ReportableEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportableEvent.ReportableEventBuilder o = (ReportableEvent.ReportableEventBuilder) other;
			
			merger.mergeRosetta(getOriginatingWorkflowStep(), o.getOriginatingWorkflowStep(), this::setOriginatingWorkflowStep);
			merger.mergeRosetta(getReportableTrade(), o.getReportableTrade(), this::setReportableTrade);
			merger.mergeRosetta(getReportablePosition(), o.getReportablePosition(), this::setReportablePosition);
			merger.mergeRosetta(getReportableInformation(), o.getReportableInformation(), this::setReportableInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportableEvent _that = getType().cast(o);
		
			if (!Objects.equals(originatingWorkflowStep, _that.getOriginatingWorkflowStep())) return false;
			if (!Objects.equals(reportableTrade, _that.getReportableTrade())) return false;
			if (!Objects.equals(reportablePosition, _that.getReportablePosition())) return false;
			if (!Objects.equals(reportableInformation, _that.getReportableInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (originatingWorkflowStep != null ? originatingWorkflowStep.hashCode() : 0);
			_result = 31 * _result + (reportableTrade != null ? reportableTrade.hashCode() : 0);
			_result = 31 * _result + (reportablePosition != null ? reportablePosition.hashCode() : 0);
			_result = 31 * _result + (reportableInformation != null ? reportableInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableEventBuilder {" +
				"originatingWorkflowStep=" + this.originatingWorkflowStep + ", " +
				"reportableTrade=" + this.reportableTrade + ", " +
				"reportablePosition=" + this.reportablePosition + ", " +
				"reportableInformation=" + this.reportableInformation +
			'}';
		}
	}
}
