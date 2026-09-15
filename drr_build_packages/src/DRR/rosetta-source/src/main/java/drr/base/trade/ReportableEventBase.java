package drr.base.trade;

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
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import drr.base.trade.meta.ReportableEventBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="ReportableEventBase", builder=ReportableEventBase.ReportableEventBaseBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ReportableEventBase", model="drr", builder=ReportableEventBase.ReportableEventBaseBuilderImpl.class, version="7.7.0")
public interface ReportableEventBase extends RosettaModelObject {

	ReportableEventBaseMeta metaData = new ReportableEventBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The workflowstep that originated the reportable event.
	 */
	WorkflowStep getOriginatingWorkflowStep();
	/**
	 * The reportable trade decomposed from the originating workflow step when required.
	 */
	TradeState getReportableTrade();
	/**
	 * The reportable position decomposed from the originating workflow step when required.
	 */
	CounterpartyPositionState getReportablePosition();
	/**
	 * Additional information required for a reportable transaction, including the reporting regime.
	 */
	ReportableInformationBase getReportableInformation();

	/*********************** Build Methods  ***********************/
	ReportableEventBase build();
	
	ReportableEventBase.ReportableEventBaseBuilder toBuilder();
	
	static ReportableEventBase.ReportableEventBaseBuilder builder() {
		return new ReportableEventBase.ReportableEventBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportableEventBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportableEventBase> getType() {
		return ReportableEventBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("originatingWorkflowStep"), processor, WorkflowStep.class, getOriginatingWorkflowStep());
		processRosetta(path.newSubPath("reportableTrade"), processor, TradeState.class, getReportableTrade());
		processRosetta(path.newSubPath("reportablePosition"), processor, CounterpartyPositionState.class, getReportablePosition());
		processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformationBase.class, getReportableInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportableEventBaseBuilder extends ReportableEventBase, RosettaModelObjectBuilder {
		WorkflowStep.WorkflowStepBuilder getOrCreateOriginatingWorkflowStep();
		@Override
		WorkflowStep.WorkflowStepBuilder getOriginatingWorkflowStep();
		TradeState.TradeStateBuilder getOrCreateReportableTrade();
		@Override
		TradeState.TradeStateBuilder getReportableTrade();
		CounterpartyPositionState.CounterpartyPositionStateBuilder getOrCreateReportablePosition();
		@Override
		CounterpartyPositionState.CounterpartyPositionStateBuilder getReportablePosition();
		ReportableInformationBase.ReportableInformationBaseBuilder getOrCreateReportableInformation();
		@Override
		ReportableInformationBase.ReportableInformationBaseBuilder getReportableInformation();
		ReportableEventBase.ReportableEventBaseBuilder setOriginatingWorkflowStep(WorkflowStep originatingWorkflowStep);
		ReportableEventBase.ReportableEventBaseBuilder setReportableTrade(TradeState reportableTrade);
		ReportableEventBase.ReportableEventBaseBuilder setReportablePosition(CounterpartyPositionState reportablePosition);
		ReportableEventBase.ReportableEventBaseBuilder setReportableInformation(ReportableInformationBase reportableInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("originatingWorkflowStep"), processor, WorkflowStep.WorkflowStepBuilder.class, getOriginatingWorkflowStep());
			processRosetta(path.newSubPath("reportableTrade"), processor, TradeState.TradeStateBuilder.class, getReportableTrade());
			processRosetta(path.newSubPath("reportablePosition"), processor, CounterpartyPositionState.CounterpartyPositionStateBuilder.class, getReportablePosition());
			processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformationBase.ReportableInformationBaseBuilder.class, getReportableInformation());
		}
		

		ReportableEventBase.ReportableEventBaseBuilder prune();
	}

	/*********************** Immutable Implementation of ReportableEventBase  ***********************/
	class ReportableEventBaseImpl implements ReportableEventBase {
		private final WorkflowStep originatingWorkflowStep;
		private final TradeState reportableTrade;
		private final CounterpartyPositionState reportablePosition;
		private final ReportableInformationBase reportableInformation;
		
		protected ReportableEventBaseImpl(ReportableEventBase.ReportableEventBaseBuilder builder) {
			this.originatingWorkflowStep = ofNullable(builder.getOriginatingWorkflowStep()).map(f->f.build()).orElse(null);
			this.reportableTrade = ofNullable(builder.getReportableTrade()).map(f->f.build()).orElse(null);
			this.reportablePosition = ofNullable(builder.getReportablePosition()).map(f->f.build()).orElse(null);
			this.reportableInformation = ofNullable(builder.getReportableInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("originatingWorkflowStep")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("originatingWorkflowStep")
		public WorkflowStep getOriginatingWorkflowStep() {
			return originatingWorkflowStep;
		}
		
		@Override
		@RosettaAttribute("reportableTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportableTrade")
		public TradeState getReportableTrade() {
			return reportableTrade;
		}
		
		@Override
		@RosettaAttribute("reportablePosition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportablePosition")
		public CounterpartyPositionState getReportablePosition() {
			return reportablePosition;
		}
		
		@Override
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportableInformation")
		public ReportableInformationBase getReportableInformation() {
			return reportableInformation;
		}
		
		@Override
		public ReportableEventBase build() {
			return this;
		}
		
		@Override
		public ReportableEventBase.ReportableEventBaseBuilder toBuilder() {
			ReportableEventBase.ReportableEventBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportableEventBase.ReportableEventBaseBuilder builder) {
			ofNullable(getOriginatingWorkflowStep()).ifPresent(builder::setOriginatingWorkflowStep);
			ofNullable(getReportableTrade()).ifPresent(builder::setReportableTrade);
			ofNullable(getReportablePosition()).ifPresent(builder::setReportablePosition);
			ofNullable(getReportableInformation()).ifPresent(builder::setReportableInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportableEventBase _that = getType().cast(o);
		
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
			return "ReportableEventBase {" +
				"originatingWorkflowStep=" + this.originatingWorkflowStep + ", " +
				"reportableTrade=" + this.reportableTrade + ", " +
				"reportablePosition=" + this.reportablePosition + ", " +
				"reportableInformation=" + this.reportableInformation +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportableEventBase  ***********************/
	class ReportableEventBaseBuilderImpl implements ReportableEventBase.ReportableEventBaseBuilder {
	
		protected WorkflowStep.WorkflowStepBuilder originatingWorkflowStep;
		protected TradeState.TradeStateBuilder reportableTrade;
		protected CounterpartyPositionState.CounterpartyPositionStateBuilder reportablePosition;
		protected ReportableInformationBase.ReportableInformationBaseBuilder reportableInformation;
		
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
		@RuneAttribute("reportableInformation")
		public ReportableInformationBase.ReportableInformationBaseBuilder getReportableInformation() {
			return reportableInformation;
		}
		
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder getOrCreateReportableInformation() {
			ReportableInformationBase.ReportableInformationBaseBuilder result;
			if (reportableInformation!=null) {
				result = reportableInformation;
			}
			else {
				result = reportableInformation = ReportableInformationBase.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("originatingWorkflowStep")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("originatingWorkflowStep")
		@Override
		public ReportableEventBase.ReportableEventBaseBuilder setOriginatingWorkflowStep(WorkflowStep _originatingWorkflowStep) {
			this.originatingWorkflowStep = _originatingWorkflowStep == null ? null : _originatingWorkflowStep.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportableTrade")
		@Override
		public ReportableEventBase.ReportableEventBaseBuilder setReportableTrade(TradeState _reportableTrade) {
			this.reportableTrade = _reportableTrade == null ? null : _reportableTrade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportablePosition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportablePosition")
		@Override
		public ReportableEventBase.ReportableEventBaseBuilder setReportablePosition(CounterpartyPositionState _reportablePosition) {
			this.reportablePosition = _reportablePosition == null ? null : _reportablePosition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportableInformation")
		@Override
		public ReportableEventBase.ReportableEventBaseBuilder setReportableInformation(ReportableInformationBase _reportableInformation) {
			this.reportableInformation = _reportableInformation == null ? null : _reportableInformation.toBuilder();
			return this;
		}
		
		@Override
		public ReportableEventBase build() {
			return new ReportableEventBase.ReportableEventBaseImpl(this);
		}
		
		@Override
		public ReportableEventBase.ReportableEventBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableEventBase.ReportableEventBaseBuilder prune() {
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
		public ReportableEventBase.ReportableEventBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportableEventBase.ReportableEventBaseBuilder o = (ReportableEventBase.ReportableEventBaseBuilder) other;
			
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
		
			ReportableEventBase _that = getType().cast(o);
		
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
			return "ReportableEventBaseBuilder {" +
				"originatingWorkflowStep=" + this.originatingWorkflowStep + ", " +
				"reportableTrade=" + this.reportableTrade + ", " +
				"reportablePosition=" + this.reportablePosition + ", " +
				"reportableInformation=" + this.reportableInformation +
			'}';
		}
	}
}
