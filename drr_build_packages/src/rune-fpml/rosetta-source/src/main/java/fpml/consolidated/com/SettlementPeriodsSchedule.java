package fpml.consolidated.com;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.com.meta.SettlementPeriodsScheduleMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The specification of the Settlement Periods in which the electricity will be delivered for a "shaped" trade i.e. where different Settlement Period ranges will apply to different periods of the trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The specification of the Settlement Periods in which the electricity will be delivered for a "shaped" trade i.e. where different Settlement Period ranges will apply to different periods of the trade.
 *
 */
@RosettaDataType(value="SettlementPeriodsSchedule", builder=SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettlementPeriodsSchedule", model="fpml", builder=SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilderImpl.class, version="2.1.1")
public interface SettlementPeriodsSchedule extends RosettaModelObject {

	SettlementPeriodsScheduleMeta metaData = new SettlementPeriodsScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The range of Settlement Periods per Calculation Period. There must be a range of Settlement Periods specified for each Calculation Period, regardless of whether the range of Settlement Periods changes or stays the same between periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The range of Settlement Periods per Calculation Period. There must be a range of Settlement Periods specified for each Calculation Period, regardless of whether the range of Settlement Periods changes or stays the same between periods.
	 *
	 */
	List<? extends SettlementPeriodsStep> getSettlementPeriodsStep();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Delivery Periods defined elsewhere.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Delivery Periods defined elsewhere.
	 *
	 */
	CalculationPeriodsReference getDeliveryPeriodsReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined elsewhere.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined elsewhere.
	 *
	 */
	CalculationPeriodsScheduleReference getDeliveryPeriodsScheduleReference();

	/*********************** Build Methods  ***********************/
	SettlementPeriodsSchedule build();
	
	SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder toBuilder();
	
	static SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder builder() {
		return new SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriodsSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementPeriodsSchedule> getType() {
		return SettlementPeriodsSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementPeriodsStep"), processor, SettlementPeriodsStep.class, getSettlementPeriodsStep());
		processRosetta(path.newSubPath("deliveryPeriodsReference"), processor, CalculationPeriodsReference.class, getDeliveryPeriodsReference());
		processRosetta(path.newSubPath("deliveryPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getDeliveryPeriodsScheduleReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodsScheduleBuilder extends SettlementPeriodsSchedule, RosettaModelObjectBuilder {
		SettlementPeriodsStep.SettlementPeriodsStepBuilder getOrCreateSettlementPeriodsStep(int index);
		@Override
		List<? extends SettlementPeriodsStep.SettlementPeriodsStepBuilder> getSettlementPeriodsStep();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateDeliveryPeriodsReference();
		@Override
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getDeliveryPeriodsReference();
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateDeliveryPeriodsScheduleReference();
		@Override
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getDeliveryPeriodsScheduleReference();
		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder addSettlementPeriodsStep(SettlementPeriodsStep settlementPeriodsStep);
		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder addSettlementPeriodsStep(SettlementPeriodsStep settlementPeriodsStep, int idx);
		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder addSettlementPeriodsStep(List<? extends SettlementPeriodsStep> settlementPeriodsStep);
		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder setSettlementPeriodsStep(List<? extends SettlementPeriodsStep> settlementPeriodsStep);
		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder setDeliveryPeriodsReference(CalculationPeriodsReference deliveryPeriodsReference);
		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder setDeliveryPeriodsScheduleReference(CalculationPeriodsScheduleReference deliveryPeriodsScheduleReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementPeriodsStep"), processor, SettlementPeriodsStep.SettlementPeriodsStepBuilder.class, getSettlementPeriodsStep());
			processRosetta(path.newSubPath("deliveryPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getDeliveryPeriodsReference());
			processRosetta(path.newSubPath("deliveryPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getDeliveryPeriodsScheduleReference());
		}
		

		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriodsSchedule  ***********************/
	class SettlementPeriodsScheduleImpl implements SettlementPeriodsSchedule {
		private final List<? extends SettlementPeriodsStep> settlementPeriodsStep;
		private final CalculationPeriodsReference deliveryPeriodsReference;
		private final CalculationPeriodsScheduleReference deliveryPeriodsScheduleReference;
		
		protected SettlementPeriodsScheduleImpl(SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder builder) {
			this.settlementPeriodsStep = ofNullable(builder.getSettlementPeriodsStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.deliveryPeriodsReference = ofNullable(builder.getDeliveryPeriodsReference()).map(f->f.build()).orElse(null);
			this.deliveryPeriodsScheduleReference = ofNullable(builder.getDeliveryPeriodsScheduleReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsStep")
		public List<? extends SettlementPeriodsStep> getSettlementPeriodsStep() {
			return settlementPeriodsStep;
		}
		
		@Override
		@RosettaAttribute("deliveryPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPeriodsReference")
		public CalculationPeriodsReference getDeliveryPeriodsReference() {
			return deliveryPeriodsReference;
		}
		
		@Override
		@RosettaAttribute("deliveryPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference getDeliveryPeriodsScheduleReference() {
			return deliveryPeriodsScheduleReference;
		}
		
		@Override
		public SettlementPeriodsSchedule build() {
			return this;
		}
		
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder toBuilder() {
			SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder builder) {
			ofNullable(getSettlementPeriodsStep()).ifPresent(builder::setSettlementPeriodsStep);
			ofNullable(getDeliveryPeriodsReference()).ifPresent(builder::setDeliveryPeriodsReference);
			ofNullable(getDeliveryPeriodsScheduleReference()).ifPresent(builder::setDeliveryPeriodsScheduleReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodsSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsStep, _that.getSettlementPeriodsStep())) return false;
			if (!Objects.equals(deliveryPeriodsReference, _that.getDeliveryPeriodsReference())) return false;
			if (!Objects.equals(deliveryPeriodsScheduleReference, _that.getDeliveryPeriodsScheduleReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriodsStep != null ? settlementPeriodsStep.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriodsReference != null ? deliveryPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriodsScheduleReference != null ? deliveryPeriodsScheduleReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodsSchedule {" +
				"settlementPeriodsStep=" + this.settlementPeriodsStep + ", " +
				"deliveryPeriodsReference=" + this.deliveryPeriodsReference + ", " +
				"deliveryPeriodsScheduleReference=" + this.deliveryPeriodsScheduleReference +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementPeriodsSchedule  ***********************/
	class SettlementPeriodsScheduleBuilderImpl implements SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder {
	
		protected List<SettlementPeriodsStep.SettlementPeriodsStepBuilder> settlementPeriodsStep = new ArrayList<>();
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder deliveryPeriodsReference;
		protected CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder deliveryPeriodsScheduleReference;
		
		@Override
		@RosettaAttribute("settlementPeriodsStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsStep")
		public List<? extends SettlementPeriodsStep.SettlementPeriodsStepBuilder> getSettlementPeriodsStep() {
			return settlementPeriodsStep;
		}
		
		@Override
		public SettlementPeriodsStep.SettlementPeriodsStepBuilder getOrCreateSettlementPeriodsStep(int index) {
			if (settlementPeriodsStep==null) {
				this.settlementPeriodsStep = new ArrayList<>();
			}
			return getIndex(settlementPeriodsStep, index, () -> {
						SettlementPeriodsStep.SettlementPeriodsStepBuilder newSettlementPeriodsStep = SettlementPeriodsStep.builder();
						return newSettlementPeriodsStep;
					});
		}
		
		@Override
		@RosettaAttribute("deliveryPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPeriodsReference")
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getDeliveryPeriodsReference() {
			return deliveryPeriodsReference;
		}
		
		@Override
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateDeliveryPeriodsReference() {
			CalculationPeriodsReference.CalculationPeriodsReferenceBuilder result;
			if (deliveryPeriodsReference!=null) {
				result = deliveryPeriodsReference;
			}
			else {
				result = deliveryPeriodsReference = CalculationPeriodsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getDeliveryPeriodsScheduleReference() {
			return deliveryPeriodsScheduleReference;
		}
		
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateDeliveryPeriodsScheduleReference() {
			CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder result;
			if (deliveryPeriodsScheduleReference!=null) {
				result = deliveryPeriodsScheduleReference;
			}
			else {
				result = deliveryPeriodsScheduleReference = CalculationPeriodsScheduleReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("settlementPeriodsStep")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodsStep")
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder addSettlementPeriodsStep(SettlementPeriodsStep _settlementPeriodsStep) {
			if (_settlementPeriodsStep != null) {
				this.settlementPeriodsStep.add(_settlementPeriodsStep.toBuilder());
			}
			return this;
		}
		
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder addSettlementPeriodsStep(SettlementPeriodsStep _settlementPeriodsStep, int idx) {
			getIndex(this.settlementPeriodsStep, idx, () -> _settlementPeriodsStep.toBuilder());
			return this;
		}
		
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder addSettlementPeriodsStep(List<? extends SettlementPeriodsStep> settlementPeriodsSteps) {
			if (settlementPeriodsSteps != null) {
				for (final SettlementPeriodsStep toAdd : settlementPeriodsSteps) {
					this.settlementPeriodsStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsStep")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriodsStep")
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder setSettlementPeriodsStep(List<? extends SettlementPeriodsStep> settlementPeriodsSteps) {
			if (settlementPeriodsSteps == null) {
				this.settlementPeriodsStep = new ArrayList<>();
			} else {
				this.settlementPeriodsStep = settlementPeriodsSteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("deliveryPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPeriodsReference")
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder setDeliveryPeriodsReference(CalculationPeriodsReference _deliveryPeriodsReference) {
			this.deliveryPeriodsReference = _deliveryPeriodsReference == null ? null : _deliveryPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPeriodsScheduleReference")
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder setDeliveryPeriodsScheduleReference(CalculationPeriodsScheduleReference _deliveryPeriodsScheduleReference) {
			this.deliveryPeriodsScheduleReference = _deliveryPeriodsScheduleReference == null ? null : _deliveryPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@Override
		public SettlementPeriodsSchedule build() {
			return new SettlementPeriodsSchedule.SettlementPeriodsScheduleImpl(this);
		}
		
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder prune() {
			settlementPeriodsStep = settlementPeriodsStep.stream().filter(b->b!=null).<SettlementPeriodsStep.SettlementPeriodsStepBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (deliveryPeriodsReference!=null && !deliveryPeriodsReference.prune().hasData()) deliveryPeriodsReference = null;
			if (deliveryPeriodsScheduleReference!=null && !deliveryPeriodsScheduleReference.prune().hasData()) deliveryPeriodsScheduleReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementPeriodsStep()!=null && getSettlementPeriodsStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDeliveryPeriodsReference()!=null && getDeliveryPeriodsReference().hasData()) return true;
			if (getDeliveryPeriodsScheduleReference()!=null && getDeliveryPeriodsScheduleReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder o = (SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriodsStep(), o.getSettlementPeriodsStep(), this::getOrCreateSettlementPeriodsStep);
			merger.mergeRosetta(getDeliveryPeriodsReference(), o.getDeliveryPeriodsReference(), this::setDeliveryPeriodsReference);
			merger.mergeRosetta(getDeliveryPeriodsScheduleReference(), o.getDeliveryPeriodsScheduleReference(), this::setDeliveryPeriodsScheduleReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodsSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsStep, _that.getSettlementPeriodsStep())) return false;
			if (!Objects.equals(deliveryPeriodsReference, _that.getDeliveryPeriodsReference())) return false;
			if (!Objects.equals(deliveryPeriodsScheduleReference, _that.getDeliveryPeriodsScheduleReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementPeriodsStep != null ? settlementPeriodsStep.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriodsReference != null ? deliveryPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriodsScheduleReference != null ? deliveryPeriodsScheduleReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodsScheduleBuilder {" +
				"settlementPeriodsStep=" + this.settlementPeriodsStep + ", " +
				"deliveryPeriodsReference=" + this.deliveryPeriodsReference + ", " +
				"deliveryPeriodsScheduleReference=" + this.deliveryPeriodsScheduleReference +
			'}';
		}
	}
}
