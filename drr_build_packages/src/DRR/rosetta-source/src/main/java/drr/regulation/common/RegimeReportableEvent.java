package drr.regulation.common;

import cdm.event.common.CounterpartyPositionState;
import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import drr.base.trade.ReportableInformationBase;
import drr.regulation.common.meta.RegimeReportableEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies a reportable event with a reporting side for each regime.
 * @version 7.7.0
 */
@RosettaDataType(value="RegimeReportableEvent", builder=RegimeReportableEvent.RegimeReportableEventBuilderImpl.class, version="7.7.0")
@RuneDataType(value="RegimeReportableEvent", model="drr", builder=RegimeReportableEvent.RegimeReportableEventBuilderImpl.class, version="7.7.0")
public interface RegimeReportableEvent extends ReportableEvent {

	RegimeReportableEventMeta metaData = new RegimeReportableEventMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends RegimeReportingSide> getRegimeReportingSide();

	/*********************** Build Methods  ***********************/
	RegimeReportableEvent build();
	
	RegimeReportableEvent.RegimeReportableEventBuilder toBuilder();
	
	static RegimeReportableEvent.RegimeReportableEventBuilder builder() {
		return new RegimeReportableEvent.RegimeReportableEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegimeReportableEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegimeReportableEvent> getType() {
		return RegimeReportableEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("originatingWorkflowStep"), processor, WorkflowStep.class, getOriginatingWorkflowStep());
		processRosetta(path.newSubPath("reportableTrade"), processor, TradeState.class, getReportableTrade());
		processRosetta(path.newSubPath("reportablePosition"), processor, CounterpartyPositionState.class, getReportablePosition());
		processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.class, getReportableInformation());
		processRosetta(path.newSubPath("regimeReportingSide"), processor, RegimeReportingSide.class, getRegimeReportingSide());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegimeReportableEventBuilder extends RegimeReportableEvent, ReportableEvent.ReportableEventBuilder {
		RegimeReportingSide.RegimeReportingSideBuilder getOrCreateRegimeReportingSide(int index);
		@Override
		List<? extends RegimeReportingSide.RegimeReportingSideBuilder> getRegimeReportingSide();
		@Override
		RegimeReportableEvent.RegimeReportableEventBuilder setOriginatingWorkflowStep(WorkflowStep originatingWorkflowStep);
		@Override
		RegimeReportableEvent.RegimeReportableEventBuilder setReportableTrade(TradeState reportableTrade);
		@Override
		RegimeReportableEvent.RegimeReportableEventBuilder setReportablePosition(CounterpartyPositionState reportablePosition);
		@Override
		RegimeReportableEvent.RegimeReportableEventBuilder setReportableInformation(ReportableInformationBase reportableInformation);
		@Override
		RegimeReportableEvent.RegimeReportableEventBuilder setReportableInformation(ReportableInformation reportableInformation);
		RegimeReportableEvent.RegimeReportableEventBuilder addRegimeReportingSide(RegimeReportingSide regimeReportingSide);
		RegimeReportableEvent.RegimeReportableEventBuilder addRegimeReportingSide(RegimeReportingSide regimeReportingSide, int idx);
		RegimeReportableEvent.RegimeReportableEventBuilder addRegimeReportingSide(List<? extends RegimeReportingSide> regimeReportingSide);
		RegimeReportableEvent.RegimeReportableEventBuilder setRegimeReportingSide(List<? extends RegimeReportingSide> regimeReportingSide);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("originatingWorkflowStep"), processor, WorkflowStep.WorkflowStepBuilder.class, getOriginatingWorkflowStep());
			processRosetta(path.newSubPath("reportableTrade"), processor, TradeState.TradeStateBuilder.class, getReportableTrade());
			processRosetta(path.newSubPath("reportablePosition"), processor, CounterpartyPositionState.CounterpartyPositionStateBuilder.class, getReportablePosition());
			processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.ReportableInformationBuilder.class, getReportableInformation());
			processRosetta(path.newSubPath("regimeReportingSide"), processor, RegimeReportingSide.RegimeReportingSideBuilder.class, getRegimeReportingSide());
		}
		

		RegimeReportableEvent.RegimeReportableEventBuilder prune();
	}

	/*********************** Immutable Implementation of RegimeReportableEvent  ***********************/
	class RegimeReportableEventImpl extends ReportableEvent.ReportableEventImpl implements RegimeReportableEvent {
		private final List<? extends RegimeReportingSide> regimeReportingSide;
		
		protected RegimeReportableEventImpl(RegimeReportableEvent.RegimeReportableEventBuilder builder) {
			super(builder);
			this.regimeReportingSide = ofNullable(builder.getRegimeReportingSide()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("regimeReportingSide")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("regimeReportingSide")
		public List<? extends RegimeReportingSide> getRegimeReportingSide() {
			return regimeReportingSide;
		}
		
		@Override
		public RegimeReportableEvent build() {
			return this;
		}
		
		@Override
		public RegimeReportableEvent.RegimeReportableEventBuilder toBuilder() {
			RegimeReportableEvent.RegimeReportableEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegimeReportableEvent.RegimeReportableEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRegimeReportingSide()).ifPresent(builder::setRegimeReportingSide);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegimeReportableEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(regimeReportingSide, _that.getRegimeReportingSide())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (regimeReportingSide != null ? regimeReportingSide.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegimeReportableEvent {" +
				"regimeReportingSide=" + this.regimeReportingSide +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegimeReportableEvent  ***********************/
	class RegimeReportableEventBuilderImpl extends ReportableEvent.ReportableEventBuilderImpl implements RegimeReportableEvent.RegimeReportableEventBuilder {
	
		protected List<RegimeReportingSide.RegimeReportingSideBuilder> regimeReportingSide = new ArrayList<>();
		
		@Override
		@RosettaAttribute("regimeReportingSide")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("regimeReportingSide")
		public List<? extends RegimeReportingSide.RegimeReportingSideBuilder> getRegimeReportingSide() {
			return regimeReportingSide;
		}
		
		@Override
		public RegimeReportingSide.RegimeReportingSideBuilder getOrCreateRegimeReportingSide(int index) {
			if (regimeReportingSide==null) {
				this.regimeReportingSide = new ArrayList<>();
			}
			return getIndex(regimeReportingSide, index, () -> {
						RegimeReportingSide.RegimeReportingSideBuilder newRegimeReportingSide = RegimeReportingSide.builder();
						return newRegimeReportingSide;
					});
		}
		
		@RosettaAttribute("originatingWorkflowStep")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("originatingWorkflowStep")
		@Override
		public RegimeReportableEvent.RegimeReportableEventBuilder setOriginatingWorkflowStep(WorkflowStep _originatingWorkflowStep) {
			this.originatingWorkflowStep = _originatingWorkflowStep == null ? null : _originatingWorkflowStep.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportableTrade")
		@Override
		public RegimeReportableEvent.RegimeReportableEventBuilder setReportableTrade(TradeState _reportableTrade) {
			this.reportableTrade = _reportableTrade == null ? null : _reportableTrade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportablePosition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportablePosition")
		@Override
		public RegimeReportableEvent.RegimeReportableEventBuilder setReportablePosition(CounterpartyPositionState _reportablePosition) {
			this.reportablePosition = _reportablePosition == null ? null : _reportablePosition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportableInformation")
		@Override
		public RegimeReportableEvent.RegimeReportableEventBuilder setReportableInformation(ReportableInformation _reportableInformation) {
			this.reportableInformation = _reportableInformation == null ? null : _reportableInformation.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public RegimeReportableEvent.RegimeReportableEventBuilder setReportableInformation(ReportableInformationBase _reportableInformation) {
			final ReportableInformation ifThenElseResult;
			if (_reportableInformation == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _reportableInformation instanceof ReportableInformation ? ReportableInformation.class.cast(_reportableInformation) : null;
			}
			return setReportableInformation(ifThenElseResult);
		}
		
		@RosettaAttribute("regimeReportingSide")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("regimeReportingSide")
		@Override
		public RegimeReportableEvent.RegimeReportableEventBuilder addRegimeReportingSide(RegimeReportingSide _regimeReportingSide) {
			if (_regimeReportingSide != null) {
				this.regimeReportingSide.add(_regimeReportingSide.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegimeReportableEvent.RegimeReportableEventBuilder addRegimeReportingSide(RegimeReportingSide _regimeReportingSide, int idx) {
			getIndex(this.regimeReportingSide, idx, () -> _regimeReportingSide.toBuilder());
			return this;
		}
		
		@Override
		public RegimeReportableEvent.RegimeReportableEventBuilder addRegimeReportingSide(List<? extends RegimeReportingSide> regimeReportingSides) {
			if (regimeReportingSides != null) {
				for (final RegimeReportingSide toAdd : regimeReportingSides) {
					this.regimeReportingSide.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("regimeReportingSide")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("regimeReportingSide")
		@Override
		public RegimeReportableEvent.RegimeReportableEventBuilder setRegimeReportingSide(List<? extends RegimeReportingSide> regimeReportingSides) {
			if (regimeReportingSides == null) {
				this.regimeReportingSide = new ArrayList<>();
			} else {
				this.regimeReportingSide = regimeReportingSides.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RegimeReportableEvent build() {
			return new RegimeReportableEvent.RegimeReportableEventImpl(this);
		}
		
		@Override
		public RegimeReportableEvent.RegimeReportableEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegimeReportableEvent.RegimeReportableEventBuilder prune() {
			super.prune();
			regimeReportingSide = regimeReportingSide.stream().filter(b->b!=null).<RegimeReportingSide.RegimeReportingSideBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRegimeReportingSide()!=null && getRegimeReportingSide().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegimeReportableEvent.RegimeReportableEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegimeReportableEvent.RegimeReportableEventBuilder o = (RegimeReportableEvent.RegimeReportableEventBuilder) other;
			
			merger.mergeRosetta(getRegimeReportingSide(), o.getRegimeReportingSide(), this::getOrCreateRegimeReportingSide);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegimeReportableEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(regimeReportingSide, _that.getRegimeReportingSide())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (regimeReportingSide != null ? regimeReportingSide.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegimeReportableEventBuilder {" +
				"regimeReportingSide=" + this.regimeReportingSide +
			'}' + " " + super.toString();
		}
	}
}
