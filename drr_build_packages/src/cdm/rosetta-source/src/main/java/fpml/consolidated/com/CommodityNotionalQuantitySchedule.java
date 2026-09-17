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
import fpml.consolidated.com.meta.CommodityNotionalQuantityScheduleMeta;
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
 * Provision The Notional Quantity per Calculation Period. There must be a Notional Quantity step specified for each Calculation Period, regardless of whether the Notional Quantity changes or remains the same between periods.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The Notional Quantity per Calculation Period. There must be a Notional Quantity step specified for each Calculation Period, regardless of whether the Notional Quantity changes or remains the same between periods.
 *
 */
@RosettaDataType(value="CommodityNotionalQuantitySchedule", builder=CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityNotionalQuantitySchedule", model="fpml", builder=CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilderImpl.class, version="2.1.1")
public interface CommodityNotionalQuantitySchedule extends RosettaModelObject {

	CommodityNotionalQuantityScheduleMeta metaData = new CommodityNotionalQuantityScheduleMeta();

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
	 * Provision The Notional Quantity per Calculation Period. There must be a Notional Quantity specified for each Calculation Period, regardless of whether the quantity changes or remains the same between periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Notional Quantity per Calculation Period. There must be a Notional Quantity specified for each Calculation Period, regardless of whether the quantity changes or remains the same between periods.
	 *
	 */
	List<? extends CommodityNotionalQuantity> getNotionalStep();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For an electricity transaction, the Notional Quantity schedule for a one or more groups of Settlement Periods to which the Notional Quantity is based. If the schedule differs for different groups of Settlement Periods, this element should be repeated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For an electricity transaction, the Notional Quantity schedule for a one or more groups of Settlement Periods to which the Notional Quantity is based. If the schedule differs for different groups of Settlement Periods, this element should be repeated.
	 *
	 */
	List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> getSettlementPeriodsNotionalQuantitySchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods defined on another leg.
	 *
	 */
	CalculationPeriodsReference getCalculationPeriodsReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined on another leg.
	 *
	 */
	CalculationPeriodsScheduleReference getCalculationPeriodsScheduleReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to single-day-duration Calculation Periods defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to single-day-duration Calculation Periods defined on another leg.
	 *
	 */
	CalculationPeriodsDatesReference getCalculationPeriodsDatesReference();

	/*********************** Build Methods  ***********************/
	CommodityNotionalQuantitySchedule build();
	
	CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder toBuilder();
	
	static CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder builder() {
		return new CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityNotionalQuantitySchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityNotionalQuantitySchedule> getType() {
		return CommodityNotionalQuantitySchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("notionalStep"), processor, CommodityNotionalQuantity.class, getNotionalStep());
		processRosetta(path.newSubPath("settlementPeriodsNotionalQuantitySchedule"), processor, CommoditySettlementPeriodsNotionalQuantitySchedule.class, getSettlementPeriodsNotionalQuantitySchedule());
		processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.class, getCalculationPeriodsReference());
		processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getCalculationPeriodsScheduleReference());
		processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.class, getCalculationPeriodsDatesReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityNotionalQuantityScheduleBuilder extends CommodityNotionalQuantitySchedule, RosettaModelObjectBuilder {
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateNotionalStep(int index);
		@Override
		List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getNotionalStep();
		CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder getOrCreateSettlementPeriodsNotionalQuantitySchedule(int index);
		@Override
		List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder> getSettlementPeriodsNotionalQuantitySchedule();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference();
		@Override
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference();
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference();
		@Override
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference();
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference();
		@Override
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference();
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setId(String id);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addNotionalStep(CommodityNotionalQuantity notionalStep);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addNotionalStep(CommodityNotionalQuantity notionalStep, int idx);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addNotionalStep(List<? extends CommodityNotionalQuantity> notionalStep);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setNotionalStep(List<? extends CommodityNotionalQuantity> notionalStep);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantitySchedule(CommoditySettlementPeriodsNotionalQuantitySchedule settlementPeriodsNotionalQuantitySchedule);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantitySchedule(CommoditySettlementPeriodsNotionalQuantitySchedule settlementPeriodsNotionalQuantitySchedule, int idx);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantitySchedule(List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> settlementPeriodsNotionalQuantitySchedule);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setSettlementPeriodsNotionalQuantitySchedule(List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> settlementPeriodsNotionalQuantitySchedule);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setCalculationPeriodsReference(CalculationPeriodsReference calculationPeriodsReference);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference calculationPeriodsScheduleReference);
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference calculationPeriodsDatesReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("notionalStep"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getNotionalStep());
			processRosetta(path.newSubPath("settlementPeriodsNotionalQuantitySchedule"), processor, CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder.class, getSettlementPeriodsNotionalQuantitySchedule());
			processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getCalculationPeriodsReference());
			processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getCalculationPeriodsScheduleReference());
			processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder.class, getCalculationPeriodsDatesReference());
		}
		

		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityNotionalQuantitySchedule  ***********************/
	class CommodityNotionalQuantityScheduleImpl implements CommodityNotionalQuantitySchedule {
		private final String id;
		private final List<? extends CommodityNotionalQuantity> notionalStep;
		private final List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> settlementPeriodsNotionalQuantitySchedule;
		private final CalculationPeriodsReference calculationPeriodsReference;
		private final CalculationPeriodsScheduleReference calculationPeriodsScheduleReference;
		private final CalculationPeriodsDatesReference calculationPeriodsDatesReference;
		
		protected CommodityNotionalQuantityScheduleImpl(CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder builder) {
			this.id = builder.getId();
			this.notionalStep = ofNullable(builder.getNotionalStep()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPeriodsNotionalQuantitySchedule = ofNullable(builder.getSettlementPeriodsNotionalQuantitySchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.calculationPeriodsReference = ofNullable(builder.getCalculationPeriodsReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsScheduleReference = ofNullable(builder.getCalculationPeriodsScheduleReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsDatesReference = ofNullable(builder.getCalculationPeriodsDatesReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("notionalStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notionalStep")
		public List<? extends CommodityNotionalQuantity> getNotionalStep() {
			return notionalStep;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsNotionalQuantitySchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantitySchedule")
		public List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> getSettlementPeriodsNotionalQuantitySchedule() {
			return settlementPeriodsNotionalQuantitySchedule;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsReference")
		public CalculationPeriodsReference getCalculationPeriodsReference() {
			return calculationPeriodsReference;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference getCalculationPeriodsScheduleReference() {
			return calculationPeriodsScheduleReference;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		public CalculationPeriodsDatesReference getCalculationPeriodsDatesReference() {
			return calculationPeriodsDatesReference;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule build() {
			return this;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder toBuilder() {
			CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getNotionalStep()).ifPresent(builder::setNotionalStep);
			ofNullable(getSettlementPeriodsNotionalQuantitySchedule()).ifPresent(builder::setSettlementPeriodsNotionalQuantitySchedule);
			ofNullable(getCalculationPeriodsReference()).ifPresent(builder::setCalculationPeriodsReference);
			ofNullable(getCalculationPeriodsScheduleReference()).ifPresent(builder::setCalculationPeriodsScheduleReference);
			ofNullable(getCalculationPeriodsDatesReference()).ifPresent(builder::setCalculationPeriodsDatesReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityNotionalQuantitySchedule _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(notionalStep, _that.getNotionalStep())) return false;
			if (!ListEquals.listEquals(settlementPeriodsNotionalQuantitySchedule, _that.getSettlementPeriodsNotionalQuantitySchedule())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (notionalStep != null ? notionalStep.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsNotionalQuantitySchedule != null ? settlementPeriodsNotionalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalQuantitySchedule {" +
				"id=" + this.id + ", " +
				"notionalStep=" + this.notionalStep + ", " +
				"settlementPeriodsNotionalQuantitySchedule=" + this.settlementPeriodsNotionalQuantitySchedule + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityNotionalQuantitySchedule  ***********************/
	class CommodityNotionalQuantityScheduleBuilderImpl implements CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder {
	
		protected String id;
		protected List<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> notionalStep = new ArrayList<>();
		protected List<CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder> settlementPeriodsNotionalQuantitySchedule = new ArrayList<>();
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder calculationPeriodsReference;
		protected CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder calculationPeriodsScheduleReference;
		protected CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder calculationPeriodsDatesReference;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("notionalStep")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notionalStep")
		public List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getNotionalStep() {
			return notionalStep;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateNotionalStep(int index) {
			if (notionalStep==null) {
				this.notionalStep = new ArrayList<>();
			}
			return getIndex(notionalStep, index, () -> {
						CommodityNotionalQuantity.CommodityNotionalQuantityBuilder newNotionalStep = CommodityNotionalQuantity.builder();
						return newNotionalStep;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsNotionalQuantitySchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantitySchedule")
		public List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder> getSettlementPeriodsNotionalQuantitySchedule() {
			return settlementPeriodsNotionalQuantitySchedule;
		}
		
		@Override
		public CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder getOrCreateSettlementPeriodsNotionalQuantitySchedule(int index) {
			if (settlementPeriodsNotionalQuantitySchedule==null) {
				this.settlementPeriodsNotionalQuantitySchedule = new ArrayList<>();
			}
			return getIndex(settlementPeriodsNotionalQuantitySchedule, index, () -> {
						CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder newSettlementPeriodsNotionalQuantitySchedule = CommoditySettlementPeriodsNotionalQuantitySchedule.builder();
						return newSettlementPeriodsNotionalQuantitySchedule;
					});
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsReference")
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference() {
			return calculationPeriodsReference;
		}
		
		@Override
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference() {
			CalculationPeriodsReference.CalculationPeriodsReferenceBuilder result;
			if (calculationPeriodsReference!=null) {
				result = calculationPeriodsReference;
			}
			else {
				result = calculationPeriodsReference = CalculationPeriodsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference() {
			return calculationPeriodsScheduleReference;
		}
		
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference() {
			CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder result;
			if (calculationPeriodsScheduleReference!=null) {
				result = calculationPeriodsScheduleReference;
			}
			else {
				result = calculationPeriodsScheduleReference = CalculationPeriodsScheduleReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference() {
			return calculationPeriodsDatesReference;
		}
		
		@Override
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference() {
			CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder result;
			if (calculationPeriodsDatesReference!=null) {
				result = calculationPeriodsDatesReference;
			}
			else {
				result = calculationPeriodsDatesReference = CalculationPeriodsDatesReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("notionalStep")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("notionalStep")
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addNotionalStep(CommodityNotionalQuantity _notionalStep) {
			if (_notionalStep != null) {
				this.notionalStep.add(_notionalStep.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addNotionalStep(CommodityNotionalQuantity _notionalStep, int idx) {
			getIndex(this.notionalStep, idx, () -> _notionalStep.toBuilder());
			return this;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addNotionalStep(List<? extends CommodityNotionalQuantity> notionalSteps) {
			if (notionalSteps != null) {
				for (final CommodityNotionalQuantity toAdd : notionalSteps) {
					this.notionalStep.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("notionalStep")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("notionalStep")
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setNotionalStep(List<? extends CommodityNotionalQuantity> notionalSteps) {
			if (notionalSteps == null) {
				this.notionalStep = new ArrayList<>();
			} else {
				this.notionalStep = notionalSteps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsNotionalQuantitySchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantitySchedule")
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantitySchedule(CommoditySettlementPeriodsNotionalQuantitySchedule _settlementPeriodsNotionalQuantitySchedule) {
			if (_settlementPeriodsNotionalQuantitySchedule != null) {
				this.settlementPeriodsNotionalQuantitySchedule.add(_settlementPeriodsNotionalQuantitySchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantitySchedule(CommoditySettlementPeriodsNotionalQuantitySchedule _settlementPeriodsNotionalQuantitySchedule, int idx) {
			getIndex(this.settlementPeriodsNotionalQuantitySchedule, idx, () -> _settlementPeriodsNotionalQuantitySchedule.toBuilder());
			return this;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder addSettlementPeriodsNotionalQuantitySchedule(List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> settlementPeriodsNotionalQuantitySchedules) {
			if (settlementPeriodsNotionalQuantitySchedules != null) {
				for (final CommoditySettlementPeriodsNotionalQuantitySchedule toAdd : settlementPeriodsNotionalQuantitySchedules) {
					this.settlementPeriodsNotionalQuantitySchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsNotionalQuantitySchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantitySchedule")
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setSettlementPeriodsNotionalQuantitySchedule(List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule> settlementPeriodsNotionalQuantitySchedules) {
			if (settlementPeriodsNotionalQuantitySchedules == null) {
				this.settlementPeriodsNotionalQuantitySchedule = new ArrayList<>();
			} else {
				this.settlementPeriodsNotionalQuantitySchedule = settlementPeriodsNotionalQuantitySchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsReference")
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setCalculationPeriodsReference(CalculationPeriodsReference _calculationPeriodsReference) {
			this.calculationPeriodsReference = _calculationPeriodsReference == null ? null : _calculationPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference _calculationPeriodsScheduleReference) {
			this.calculationPeriodsScheduleReference = _calculationPeriodsScheduleReference == null ? null : _calculationPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference _calculationPeriodsDatesReference) {
			this.calculationPeriodsDatesReference = _calculationPeriodsDatesReference == null ? null : _calculationPeriodsDatesReference.toBuilder();
			return this;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule build() {
			return new CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleImpl(this);
		}
		
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder prune() {
			notionalStep = notionalStep.stream().filter(b->b!=null).<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementPeriodsNotionalQuantitySchedule = settlementPeriodsNotionalQuantitySchedule.stream().filter(b->b!=null).<CommoditySettlementPeriodsNotionalQuantitySchedule.CommoditySettlementPeriodsNotionalQuantityScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (calculationPeriodsReference!=null && !calculationPeriodsReference.prune().hasData()) calculationPeriodsReference = null;
			if (calculationPeriodsScheduleReference!=null && !calculationPeriodsScheduleReference.prune().hasData()) calculationPeriodsScheduleReference = null;
			if (calculationPeriodsDatesReference!=null && !calculationPeriodsDatesReference.prune().hasData()) calculationPeriodsDatesReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getNotionalStep()!=null && getNotionalStep().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPeriodsNotionalQuantitySchedule()!=null && getSettlementPeriodsNotionalQuantitySchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCalculationPeriodsReference()!=null && getCalculationPeriodsReference().hasData()) return true;
			if (getCalculationPeriodsScheduleReference()!=null && getCalculationPeriodsScheduleReference().hasData()) return true;
			if (getCalculationPeriodsDatesReference()!=null && getCalculationPeriodsDatesReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder o = (CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder) other;
			
			merger.mergeRosetta(getNotionalStep(), o.getNotionalStep(), this::getOrCreateNotionalStep);
			merger.mergeRosetta(getSettlementPeriodsNotionalQuantitySchedule(), o.getSettlementPeriodsNotionalQuantitySchedule(), this::getOrCreateSettlementPeriodsNotionalQuantitySchedule);
			merger.mergeRosetta(getCalculationPeriodsReference(), o.getCalculationPeriodsReference(), this::setCalculationPeriodsReference);
			merger.mergeRosetta(getCalculationPeriodsScheduleReference(), o.getCalculationPeriodsScheduleReference(), this::setCalculationPeriodsScheduleReference);
			merger.mergeRosetta(getCalculationPeriodsDatesReference(), o.getCalculationPeriodsDatesReference(), this::setCalculationPeriodsDatesReference);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityNotionalQuantitySchedule _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(notionalStep, _that.getNotionalStep())) return false;
			if (!ListEquals.listEquals(settlementPeriodsNotionalQuantitySchedule, _that.getSettlementPeriodsNotionalQuantitySchedule())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (notionalStep != null ? notionalStep.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsNotionalQuantitySchedule != null ? settlementPeriodsNotionalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalQuantityScheduleBuilder {" +
				"id=" + this.id + ", " +
				"notionalStep=" + this.notionalStep + ", " +
				"settlementPeriodsNotionalQuantitySchedule=" + this.settlementPeriodsNotionalQuantitySchedule + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference +
			'}';
		}
	}
}
