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
import drr.base.trade.meta.TransactionReportInstructionBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies a reportable event with with a single reporting side.
 * @version 7.7.0
 */
@RosettaDataType(value="TransactionReportInstructionBase", builder=TransactionReportInstructionBase.TransactionReportInstructionBaseBuilderImpl.class, version="7.7.0")
@RuneDataType(value="TransactionReportInstructionBase", model="drr", builder=TransactionReportInstructionBase.TransactionReportInstructionBaseBuilderImpl.class, version="7.7.0")
public interface TransactionReportInstructionBase extends ReportableEventBase {

	TransactionReportInstructionBaseMeta metaData = new TransactionReportInstructionBaseMeta();

	/*********************** Getter Methods  ***********************/
	ReportingSide getReportingSide();

	/*********************** Build Methods  ***********************/
	TransactionReportInstructionBase build();
	
	TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder toBuilder();
	
	static TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder builder() {
		return new TransactionReportInstructionBase.TransactionReportInstructionBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TransactionReportInstructionBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TransactionReportInstructionBase> getType() {
		return TransactionReportInstructionBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("originatingWorkflowStep"), processor, WorkflowStep.class, getOriginatingWorkflowStep());
		processRosetta(path.newSubPath("reportableTrade"), processor, TradeState.class, getReportableTrade());
		processRosetta(path.newSubPath("reportablePosition"), processor, CounterpartyPositionState.class, getReportablePosition());
		processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformationBase.class, getReportableInformation());
		processRosetta(path.newSubPath("reportingSide"), processor, ReportingSide.class, getReportingSide());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransactionReportInstructionBaseBuilder extends TransactionReportInstructionBase, ReportableEventBase.ReportableEventBaseBuilder {
		ReportingSide.ReportingSideBuilder getOrCreateReportingSide();
		@Override
		ReportingSide.ReportingSideBuilder getReportingSide();
		@Override
		TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder setOriginatingWorkflowStep(WorkflowStep originatingWorkflowStep);
		@Override
		TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder setReportableTrade(TradeState reportableTrade);
		@Override
		TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder setReportablePosition(CounterpartyPositionState reportablePosition);
		@Override
		TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder setReportableInformation(ReportableInformationBase reportableInformation);
		TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder setReportingSide(ReportingSide reportingSide);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("originatingWorkflowStep"), processor, WorkflowStep.WorkflowStepBuilder.class, getOriginatingWorkflowStep());
			processRosetta(path.newSubPath("reportableTrade"), processor, TradeState.TradeStateBuilder.class, getReportableTrade());
			processRosetta(path.newSubPath("reportablePosition"), processor, CounterpartyPositionState.CounterpartyPositionStateBuilder.class, getReportablePosition());
			processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformationBase.ReportableInformationBaseBuilder.class, getReportableInformation());
			processRosetta(path.newSubPath("reportingSide"), processor, ReportingSide.ReportingSideBuilder.class, getReportingSide());
		}
		

		TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder prune();
	}

	/*********************** Immutable Implementation of TransactionReportInstructionBase  ***********************/
	class TransactionReportInstructionBaseImpl extends ReportableEventBase.ReportableEventBaseImpl implements TransactionReportInstructionBase {
		private final ReportingSide reportingSide;
		
		protected TransactionReportInstructionBaseImpl(TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder builder) {
			super(builder);
			this.reportingSide = ofNullable(builder.getReportingSide()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reportingSide")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingSide")
		public ReportingSide getReportingSide() {
			return reportingSide;
		}
		
		@Override
		public TransactionReportInstructionBase build() {
			return this;
		}
		
		@Override
		public TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder toBuilder() {
			TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReportingSide()).ifPresent(builder::setReportingSide);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TransactionReportInstructionBase _that = getType().cast(o);
		
			if (!Objects.equals(reportingSide, _that.getReportingSide())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportingSide != null ? reportingSide.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransactionReportInstructionBase {" +
				"reportingSide=" + this.reportingSide +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TransactionReportInstructionBase  ***********************/
	class TransactionReportInstructionBaseBuilderImpl extends ReportableEventBase.ReportableEventBaseBuilderImpl implements TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder {
	
		protected ReportingSide.ReportingSideBuilder reportingSide;
		
		@Override
		@RosettaAttribute("reportingSide")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingSide")
		public ReportingSide.ReportingSideBuilder getReportingSide() {
			return reportingSide;
		}
		
		@Override
		public ReportingSide.ReportingSideBuilder getOrCreateReportingSide() {
			ReportingSide.ReportingSideBuilder result;
			if (reportingSide!=null) {
				result = reportingSide;
			}
			else {
				result = reportingSide = ReportingSide.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("originatingWorkflowStep")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("originatingWorkflowStep")
		@Override
		public TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder setOriginatingWorkflowStep(WorkflowStep _originatingWorkflowStep) {
			this.originatingWorkflowStep = _originatingWorkflowStep == null ? null : _originatingWorkflowStep.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportableTrade")
		@Override
		public TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder setReportableTrade(TradeState _reportableTrade) {
			this.reportableTrade = _reportableTrade == null ? null : _reportableTrade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportablePosition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportablePosition")
		@Override
		public TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder setReportablePosition(CounterpartyPositionState _reportablePosition) {
			this.reportablePosition = _reportablePosition == null ? null : _reportablePosition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportableInformation")
		@Override
		public TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder setReportableInformation(ReportableInformationBase _reportableInformation) {
			this.reportableInformation = _reportableInformation == null ? null : _reportableInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingSide")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingSide")
		@Override
		public TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder setReportingSide(ReportingSide _reportingSide) {
			this.reportingSide = _reportingSide == null ? null : _reportingSide.toBuilder();
			return this;
		}
		
		@Override
		public TransactionReportInstructionBase build() {
			return new TransactionReportInstructionBase.TransactionReportInstructionBaseImpl(this);
		}
		
		@Override
		public TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder prune() {
			super.prune();
			if (reportingSide!=null && !reportingSide.prune().hasData()) reportingSide = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getReportingSide()!=null && getReportingSide().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder o = (TransactionReportInstructionBase.TransactionReportInstructionBaseBuilder) other;
			
			merger.mergeRosetta(getReportingSide(), o.getReportingSide(), this::setReportingSide);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TransactionReportInstructionBase _that = getType().cast(o);
		
			if (!Objects.equals(reportingSide, _that.getReportingSide())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportingSide != null ? reportingSide.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransactionReportInstructionBaseBuilder {" +
				"reportingSide=" + this.reportingSide +
			'}' + " " + super.toString();
		}
	}
}
